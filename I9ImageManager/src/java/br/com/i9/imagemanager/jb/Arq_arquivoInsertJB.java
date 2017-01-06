package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyFileUpload;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.i9.imagemanager.util.Zipper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.zip.GZIPInputStream;
import javax.servlet.http.Cookie;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Arq_arquivoInsertJB extends SystemBase {

    // Atributos e propriedades
    private boolean multiplos = false;
    private byte[] Filedata;
    private Arq_arquivoT arq_arquivoT = new Arq_arquivoT();
    private Cla_classificacaoT cla_classificacaoT = new Cla_classificacaoT();
    private Tid_tipodocumentoT tid_tipodocumentoT = new Tid_tipodocumentoT();
    private ArquivoT arquivoT = new ArquivoT();
    private String query;

    public void setArq_arquivoT(Arq_arquivoT arq_arquivoT) {
        this.arq_arquivoT = arq_arquivoT;
    }

    public Arq_arquivoT getArq_arquivoT() {
        return arq_arquivoT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();

        if ("insert".equals(getOp())) {

            List<Cla_classificacaoT> listCla = getCla_classificacaoDAO().getByCla_tx_tipo(cla_classificacaoT);
            //List<Tid_tipodocumentoT> listTid = getTid_tipodocumentoDAO().getByTid_tx_sigla(tid_tipodocumentoT);
            cla_classificacaoT = listCla.get(0);
            //tid_tipodocumentoT = listTid.get(0);
            arq_arquivoT.setCla_nr_id(cla_classificacaoT.getCla_nr_id());
        }
    }

    /**
     * Verifica se existe imagem bruta para este produto
     * @param proNrId
     * @return
     * @throws Exception
     */
    private boolean existeImagemBruta(int proNrId) throws Exception {
        Arq_arquivoT arqT = new Arq_arquivoT();
        arqT.setPro_nr_id(proNrId);
        arqT.setCla_nr_id(CODIGO_BRUTA);
        int cont = getArq_arquivoDAO().getContImagemClassificacao(arqT);
        return cont > 0;
    }

    /**
     * Verifica se existe imagem tratada para este produto
     * @param proNrId
     * @return
     * @throws Exception
     */
    private boolean existeImagemTratada(int proNrId) throws Exception {
        Arq_arquivoT arqT = new Arq_arquivoT();
        arqT.setPro_nr_id(proNrId);
        arqT.setCla_nr_id(CODIGO_TRATADA);
        int cont = getArq_arquivoDAO().getContImagemClassificacao(arqT);
        return cont > 0;
    }

    /**
     * Verifica as regras de insercao de imagens
     * 1- Só pode inserir imagens tratadas se houver imagem bruta
     * 2- Só pode inserir imagens web se hou ver imagem tratada
     * @return
     */
    private boolean validarRegrasInsercaoArquivos(Arq_arquivoT arqT) throws Exception {
        boolean resultado = false;
        switch (arqT.getCla_nr_id()) {
            case CODIGO_BRUTA:
                resultado = true;
                break;
            case CODIGO_TRATADA:
                resultado = existeImagemBruta(arqT.getPro_nr_id());
                break;
            case CODIGO_WEB:
                resultado = existeImagemTratada(arqT.getPro_nr_id());
        }
        return resultado;
    }

    /**
     * Substituir arquivo existente
     * @throws Exception
     */
    public void substituir() throws Exception {
        EasyFileUpload efU = (EasyFileUpload) getRequest().getAttribute("arq_arquivoT.arq_bt_arquivo");
        String nome = efU.getPath();
        nome = getNomeArquivo(nome);
        arq_arquivoT.setArq_tx_nome(nome);


        arq_arquivoT.setTid_nr_id(getTipoDocumento(nome).getTid_nr_id());
        Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();
        String path = getParametro(PATH_ARQUIVO);
        arq_arquivoDAO.setPath(path);
        arq_arquivoDAO.substituirArquivo(arq_arquivoT);
        setMsg(INFO, "Substituicao efetuada com sucesso!");
        clear();
    }

    private void insertArquivo(EasyFileUpload efU) throws Exception {
        //EasyFileUpload efU = (EasyFileUpload) getRequest().getAttribute("arq_arquivoT.arq_bt_arquivo");
        String nome = efU.getPath();
        nome = getNomeArquivo(nome);
        if ("zip".equalsIgnoreCase(efU.getType())) {
            insertZip();
        } else {
            insertArquivo(nome);
        }
    }

    /**
     * Verifica se o arquivo a ser inserido é do tipo psd
     * @param arqT
     * @return
     * @throws Exception
     */
    private int getCodTipoPSD() throws Exception {
        Tid_tipodocumentoT tidT = new Tid_tipodocumentoT();
        tidT.setTid_tx_sigla("psd");
        List<Tid_tipodocumentoT> listTid = getTid_tipodocumentoDAO().getByTid_tx_sigla(tidT);
        if (listTid.size() > 0) {
            tidT = listTid.get(0);
            return tidT.getTid_nr_id();
        }
        return -1;
    }

    /**
     * Compactando PSD
     * @param arqT
     */
    private void compactarPSD(Arq_arquivoT arqT) {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(arqT.getArq_bt_arquivo());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            GZIPInputStream gzip = new GZIPInputStream(bais);
            int controle = -1;
            byte[] buffer = new byte[1024];
            while ((controle = gzip.read(buffer)) > 0) {
                byte[] bufferTemp = new byte[controle];
                System.arraycopy(buffer, 0, bufferTemp, 0, controle);
                baos.write(buffer);
            }
            arqT.setArq_bt_arquivo(baos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertArquivo(String nome) throws Exception {
        arq_arquivoT.setArq_tx_nome(nome);
        arq_arquivoT.setTid_nr_id(getTipoDocumento(nome).getTid_nr_id());
//        int tidNrId = getCodTipoPSD();
//        //Se for igual  deve compactar o arquivo PSD
//        if (tidNrId == arq_arquivoT.getTid_nr_id()) {
//            compactarPSD(arq_arquivoT);
//        }
        Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();
        String path = getParametro(PATH_ARQUIVO);
        arq_arquivoDAO.setPath(path);

        arq_arquivoT.setArq_dt_cadastro(new Date());
        if ("N".equals(arq_arquivoT.getArq_tx_promocional())) {
            arq_arquivoDAO.insert(arq_arquivoT);
        } else {
            arq_arquivoDAO.insertPromocional(arq_arquivoT);
        }
    }

    /**
     * Removendo os arquivos temporários
     * @param file
     * @throws Exception
     */
    private void deleteFile(File file) throws Exception {
        if (file != null) {
            if (file.isDirectory()) {
                File[] lista = file.listFiles();
                for (int i = 0; i < lista.length; i++) {
                    File file1 = lista[i];
                    deleteFile(file1);
                }
            }
            file.delete();
        }
    }

    /**
     * Prepara o zip para inserir as imagens no banco e apagar o conteudo temporário
     * @throws Exception
     */
    private void insertZip() throws Exception {
        String zipName = getSession().getId().concat(String.valueOf(System.currentTimeMillis())).concat("_zip.zip");
        FileOutputStream fos = new FileOutputStream(zipName);
        fos.write(arq_arquivoT.getArq_bt_arquivo());
        fos.flush();
        fos.close();
        Zipper zip = new Zipper();
        File fileDestino = new File("/tmp/temp/".concat(String.valueOf(System.currentTimeMillis())));
        zip.extrairZip(new File(zipName), fileDestino);

        //Obtem as 3 pastas bruta tratada e web
        File[] produtos = fileDestino.listFiles();
        for (int k = 0; k < produtos.length; k++) {
            File fileProduto = produtos[k];

            File[] pastas = fileProduto.listFiles();

            File[] listImg = null;
            for (int i = 0; i < pastas.length; i++) {
                File file = pastas[i];
                listImg = file.listFiles();
                if ("bruta".equalsIgnoreCase(file.getName())) {
                    arq_arquivoT.setCla_nr_id(CODIGO_BRUTA);
                } else if ("tratada".equalsIgnoreCase(file.getName())) {
                    arq_arquivoT.setCla_nr_id(CODIGO_TRATADA);
                } else if ("web".equalsIgnoreCase(file.getName())) {
                    arq_arquivoT.setCla_nr_id(CODIGO_WEB);
                }
                for (int j = 0; j < listImg.length; j++) {
                    File arqImg = listImg[j];
                    arq_arquivoT.setArq_bt_arquivo(readFile(arqImg));
                    insertArquivo(arqImg.getName());
                }
            }
        }
        deleteFile(fileDestino);
    }

    /**
     * Ler o arquivo do disco
     * @param file
     * @return
     */
    private byte[] readFile(File file) {

        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int controle = -1;
            byte[] buffer = new byte[1024];
            while ((controle = fis.read(buffer)) != -1) {
                byte[] bufferTemp = new byte[controle];
                System.arraycopy(buffer, 0, bufferTemp, 0, controle);
                baos.write(bufferTemp);
            }
            fis.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                file.delete();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public void insert() throws Exception {

        try {
            //Verifica as regras de insercao de imagens
            if (!validarRegrasInsercaoArquivos(arq_arquivoT)) {
                switch (arq_arquivoT.getCla_nr_id()) {
                    case CODIGO_TRATADA:
                        setMsg(ERROR, "É necessário cadastrar imagens brutas primeiro.");
                        break;
                    case CODIGO_WEB:
                        setMsg(ERROR, "É necessário cadastrar imagens tratadas primeiro.");
                }
                return;
            } else {
                if (arq_arquivoT.getCla_nr_id() == 0) {
                    setMsg(ERROR, "É necessário escolher a classificacao do arquivo.");
                    return;
                }
            }
            // Para insercao de multiplos arquivos
            if (multiplos) {
                String nome = "Filedata";
                EasyFileUpload efu = (EasyFileUpload) getRequest().getAttribute(nome);
                arq_arquivoT.setArq_bt_arquivo(Filedata);
                if ("_PNG_JPG_JPEG".indexOf(efu.getType().toUpperCase()) > 0) {
                    bytesToImagePNGThumb(arq_arquivoT);
                } else {
                    byte[] temp = {0};
                    arq_arquivoT.setArq_bt_thumb(temp);
                }
                insertArquivo(efu);
                setMsg(INFO, "Cadastro efetuado com sucesso!");
                return;
            }

            EasyFileUpload efU = (EasyFileUpload) getRequest().getAttribute("arquivoT.arq1");
            if (efU != null) {
                arq_arquivoT.setArq_bt_arquivo(arquivoT.getArq1());
                insertArquivo(efU);
            } else {
                // Se nenhum arquivo foi enviado, deve ser colocado a definicao do arquivo na sessao
                getSession().setAttribute(ARQUIVO_UPLOAD_MULTIPLO, arq_arquivoT);
                setMsg(INFO, "Definicao do arquivo colocado na sessao com sucesso!");
                return;
            }

            efU = (EasyFileUpload) getRequest().getAttribute("arquivoT.arq2");
            if (efU != null) {
                arq_arquivoT.setArq_bt_arquivo(arquivoT.getArq2());
                insertArquivo(efU);
            }

            efU = (EasyFileUpload) getRequest().getAttribute("arquivoT.arq3");
            if (efU != null) {
                arq_arquivoT.setArq_bt_arquivo(arquivoT.getArq3());
                insertArquivo(efU);
            }

            efU = (EasyFileUpload) getRequest().getAttribute("arquivoT.arq4");
            if (efU != null) {
                arq_arquivoT.setArq_bt_arquivo(arquivoT.getArq4());
                insertArquivo(efU);
            }

            efU = (EasyFileUpload) getRequest().getAttribute("arquivoT.arq5");
            if (efU != null) {
                arq_arquivoT.setArq_bt_arquivo(arquivoT.getArq5());
                insertArquivo(efU);
            }

            efU = (EasyFileUpload) getRequest().getAttribute("arquivoT.arq6");
            if (efU != null) {
                arq_arquivoT.setArq_bt_arquivo(arquivoT.getArq6());
                insertArquivo(efU);
            }

            efU = (EasyFileUpload) getRequest().getAttribute("arquivoT.arq7");
            if (efU != null) {
                arq_arquivoT.setArq_bt_arquivo(arquivoT.getArq7());
                insertArquivo(efU);
            }

            /*            EasyFileUpload efU = (EasyFileUpload) getRequest().getAttribute("arq_arquivoT.arq_bt_arquivo");
            String nome = efU.getPath();
            arq_arquivoT.setArq_tx_nome(nome);

            arq_arquivoT.setTid_nr_id(getTipoDocumento(nome).getTid_nr_id());
            Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();
            arq_arquivoT.setArq_dt_cadastro(new Date());
            if ("N".equals(arq_arquivoT.getArq_tx_promocional())) {
            arq_arquivoDAO.insert(arq_arquivoT);
            } else {
            arq_arquivoDAO.insertPromocional(arq_arquivoT);
            }
             */
            setMsg(INFO, "Cadastro efetuado com sucesso!");
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar cadastro!");
        } finally {
            close();
        }
    }
// Method de lookup
// 
    private List<Pro_produtoT> listpro_produto;

    public List<Pro_produtoT> getListpro_produto() {
        return listpro_produto;
    }

    public void setListpro_produto(List<Pro_produtoT> list) {
        this.listpro_produto = list;
    }

    public void consultPro_produto() throws Exception {
        try {
            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            listpro_produto = pro_produtoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    private List<Cla_classificacaoT> listcla_classificacao;

    public List<Cla_classificacaoT> getListcla_classificacao() {
        return listcla_classificacao;
    }

    public void setListcla_classificacao(List<Cla_classificacaoT> list) {
        this.listcla_classificacao = list;
    }

    public void consultCla_classificacao() throws Exception {
        try {
            Cla_classificacaoDAO cla_classificacaoDAO = getCla_classificacaoDAO();
            listcla_classificacao = cla_classificacaoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    private List<Tid_tipodocumentoT> listtid_tipodocumento;

    public List<Tid_tipodocumentoT> getListtid_tipodocumento() {
        return listtid_tipodocumento;
    }

    public void setListtid_tipodocumento(List<Tid_tipodocumentoT> list) {
        this.listtid_tipodocumento = list;
    }

    public void consultTid_tipodocumento() throws Exception {
        try {
            Tid_tipodocumentoDAO tid_tipodocumentoDAO = getTid_tipodocumentoDAO();
            listtid_tipodocumento = tid_tipodocumentoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void clear() throws Exception {

        arq_arquivoT = new Arq_arquivoT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "arq_arquivoConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the cla_classificacaoT
     */
    public Cla_classificacaoT getCla_classificacaoT() {
        return cla_classificacaoT;
    }

    /**
     * @param cla_classificacaoT the cla_classificacaoT to set
     */
    public void setCla_classificacaoT(Cla_classificacaoT cla_classificacaoT) {
        this.cla_classificacaoT = cla_classificacaoT;
    }

    /**
     * @return the tid_tipodocumentoT
     */
    public Tid_tipodocumentoT getTid_tipodocumentoT() {
        return tid_tipodocumentoT;
    }

    /**
     * @param tid_tipodocumentoT the tid_tipodocumentoT to set
     */
    public void setTid_tipodocumentoT(Tid_tipodocumentoT tid_tipodocumentoT) {
        this.tid_tipodocumentoT = tid_tipodocumentoT;
    }

    /**
     * @return the arquivoT
     */
    public ArquivoT getArquivoT() {
        return arquivoT;
    }

    /**
     * @param arquivoT the arquivoT to set
     */
    public void setArquivoT(ArquivoT arquivoT) {
        this.arquivoT = arquivoT;
    }

    /**
     * @return the multiplos
     */
    public boolean isMultiplos() {
        return multiplos;
    }

    /**
     * @param multiplos the multiplos to set
     */
    public void setMultiplos(boolean multiplos) {
        this.multiplos = multiplos;
    }

    /**
     * @return the Filedata
     */
    public byte[] getFiledata() {
        return Filedata;
    }

    /**
     * @param Filedata the Filedata to set
     */
    public void setFiledata(byte[] Filedata) {
        this.Filedata = Filedata;
    }

    /**
     * @return the query
     */
    public String getQuery() {
        return query;
    }

    /**
     * @param query the query to set
     */
    public void setQuery(String query) {
        this.query = query;
        try {
            String str = query;
            String[] parametros = str.split("-");
            setOp(parametros[0]);
            cla_classificacaoT.setCla_tx_tipo(parametros[1]);
            arq_arquivoT.setPro_nr_id(Integer.parseInt(parametros[2]));
            arq_arquivoT.setArq_tx_promocional(parametros[3]);
            if (arq_arquivoT.getArq_tx_promocional().equalsIgnoreCase("S")) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                arq_arquivoT.setArq_dt_validadeinicio(sdf.parse(parametros[4]));
                arq_arquivoT.setArq_dt_validadefim(sdf.parse(parametros[5]));
            }
            multiplos = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
