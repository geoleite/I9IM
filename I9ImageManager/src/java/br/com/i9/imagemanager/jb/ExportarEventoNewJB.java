/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.jb;

import br.com.i9.imagemanager.transfer.Arq_arquivoT;
import br.com.i9.imagemanager.transfer.Eve_eventoT;
import br.com.i9.imagemanager.transfer.Gru_grupoT;
import br.com.i9.imagemanager.transfer.Ond_ondaT;
import br.com.i9.imagemanager.transfer.Pro_eveT;
import br.com.i9.imagemanager.transfer.Pro_produtoT;
import br.com.i9.imagemanager.transfer.Sel_seloT;
import br.com.i9.imagemanager.transfer.Ses_sessaoT;
import br.com.i9.imagemanager.transfer.Set_setorNewT;
import br.com.i9.imagemanager.transfer.Set_setorT;
import br.com.i9.imagemanager.util.CommandLinux;
import br.com.i9.imagemanager.util.Zipper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author geoleite
 */
public class ExportarEventoNewJB extends SystemBase {

    /**
     * @return the percentual
     */
    public float getPercentual() {
        try {
            System.gc();

        } catch (Exception e) {
        }
       return Math.round(percentual);//percentual;
    }

    /**
     * @param aPercentual the percentual to set
     */
    public void setPercentual(float aPercentual) {
        percentual = aPercentual;
    }
    private Eve_eventoT eve_eventoT = new Eve_eventoT();
    private TreeMap<Integer, Set_setorNewT> mapSetor = new TreeMap<Integer, Set_setorNewT>();
    private TreeMap<Integer, Pro_produtoT> mapProduto = new TreeMap<Integer, Pro_produtoT>();
    private List<File> files = new ArrayList<File>();
    private String PASTA_MERCADORIAS = "/home/mercadorias/";
    //private String PASTA_MERCADORIAS = "/media/hd_externo2/mercadorias/";
    private static boolean geracaoIniciada = false;
    private static String sinal = "sinal";
    //private final static String DIRETORIO_RAIZ = "/tmp/";
    private static float percentual = 0;

    public void pageLoad() {
        try {
            if (!"percentual".equalsIgnoreCase(getOp())) {
                eve_eventoT = findbyIdEve_evento(eve_eventoT);
                consultarSetores();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void consultarSetores() {
        try {
            List<Set_setorNewT> listSet = getSet_setorNewDAO().getAll();
            for (Set_setorNewT set_setorT : listSet) {
                mapSetor.put(set_setorT.getSet_nr_id(), set_setorT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();

        }
    }

    private byte[] getImage(Arq_arquivoT arqT) throws Exception {
        List<Arq_arquivoT> listArq = getArq_arquivoDAO().getByArq_bt_arquivo(arqT);
        return listArq.size() > 0 ? listArq.get(0).getArq_bt_arquivo() : null;
    }

    private void saveImage(Arq_arquivoT arqT, OutputStream os) throws Exception {
        getArq_arquivoDAO().getByArq_bt_arquivoStream(arqT, os);
        //listArq.size() > 0 ? listArq.get(0).getArq_bt_arquivo() : null;
    }

    private byte[] getImage(Sel_seloT selT) throws Exception {
        List<Sel_seloT> listSel = getSel_seloDAO().getBySel_bt_arquivo(selT);
        return listSel.size() > 0 ? listSel.get(0).getSel_bt_arquivo() : null;
    }

    private void saveImage(Sel_seloT selT, OutputStream os) throws Exception {
        getSel_seloDAO().getBySel_bt_arquivo(selT);
    }

    private String getTipoArquivo(Arq_arquivoT arqT) {
        String tipoArquivo = arqT.getArq_tx_nome();
        int pos = tipoArquivo.indexOf(".");
        if (pos > 0) {
            tipoArquivo = tipoArquivo.substring(pos, tipoArquivo.length());
        }
        return tipoArquivo;
    }

    private String getTipoArquivo(Sel_seloT selT) {
        String tipoArquivo = selT.getSel_tx_nome();
        int pos = tipoArquivo.indexOf(".");
        if (pos > 0) {
            tipoArquivo = tipoArquivo.substring(pos, tipoArquivo.length());
        }
        return tipoArquivo;
    }

    private Pro_produtoT getProduto(int proNrId) throws Exception {
        Pro_produtoT proT = null;
        if (mapProduto.containsKey(proNrId)) {
            proT = mapProduto.get(proNrId);
        } else {
            proT = new Pro_produtoT();
            proT.setPro_nr_id(proNrId);
            List<Pro_produtoT> listPro = getPro_produtoDAO().getByPK(proT);
            proT = listPro.size() > 0 ? listPro.get(0) : null;
            mapProduto.put(proNrId, proT);
        }
        return proT;
    }

    /**
     * Obtem todos os produtos associados a um selo
     * @param selNrId
     * @return
     * @throws Exception
     */
    private List<Pro_produtoT> getProdutosSelo(Sel_seloT selT) throws Exception {
        List<Pro_produtoT> listPro = getPro_produtoDAO().getBySelo(selT);
        return listPro;

    }

    /**
     * Salvar Imagens em disco
     * @param arqT
     * @throws Exception
     */
    private void salvarImagens(Arq_arquivoT arqT, File file) throws Exception {

        Pro_produtoT proT = getProduto(arqT.getPro_nr_id());
        StringBuffer sb = new StringBuffer();
        Set_setorNewT setT = mapSetor.get(proT.getSet_nr_id());
        String path = file.getPath().concat("/").concat(setT.getSet_tx_nome()).concat("/").concat(String.valueOf(arqT.getPro_nr_id()));
        path = path.replaceAll(" ", "_");
        File fileDiretorio = new File(path);

        if (!fileDiretorio.exists()) {
            fileDiretorio.mkdirs();
        }

//        File fileArquivo = new File(fileDiretorio.getPath().concat("/").concat(String.valueOf(arqT.getArq_tx_nome())).concat(getTipoArquivo(arqT)));
        File fileArquivo = new File(fileDiretorio.getPath().concat("/").concat(String.valueOf(arqT.getArq_tx_nome())));
        //files.add(file);
        FileOutputStream fos = new FileOutputStream(fileArquivo);
        saveImage(arqT, fos);
        //fos.write(getImage(arqT));
        //fos.flush();
        //fos.close();



    }

    /**
     * Salvar Selos em disco
     * @param arqT
     * @throws Exception
     */
    private void salvarSelos(Sel_seloT selT, File file) throws Exception {

        List<Pro_produtoT> produtos = getProdutosSelo(selT);
        for (Pro_produtoT proT : produtos) {
            Set_setorNewT setT = mapSetor.get(proT.getSet_nr_id());

            String path = file.getPath().concat("/").concat(setT.getSet_tx_nome()).concat("/").concat(String.valueOf(proT.getPro_nr_id()));
            path = path.replaceAll(" ", "_");
            File fileDiretorio = new File(path);

            if (!fileDiretorio.exists()) {
                fileDiretorio.mkdirs();
            }

            File fileArquivo = new File(fileDiretorio.getPath().concat("/selo_").concat(String.valueOf(selT.getSel_tx_nome())));//.concat(getTipoArquivo(selT)));
            FileOutputStream fos = new FileOutputStream(fileArquivo);
            saveImage(selT, fos);
        }
    }

    private void excluirImagens(File file) throws Exception {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                File file1 = files[i];
                excluirImagens(file1);
            }
        }
        file.delete();
    }

    public void percentual() {
    }
    
    public void compactarImages() {
        try {
            synchronized (sinal) {
                percentual = 0;
                // Permite apenas uma exportacao por vez
                if (!geracaoIniciada) {
                    geracaoIniciada = true;
                    String nomePastaEvento = eve_eventoT.getEve_tx_nome();
                    //String pastaUnica = String.valueOf(eve_eventoT.getEve_tx_nome());
                    //nomePastaEvento = PASTA_MERCADORIAS.concat(pastaUnica).concat("/").concat(nomePastaEvento.replaceAll(" ", "_"));
                    nomePastaEvento = PASTA_MERCADORIAS.concat("").concat(nomePastaEvento.replaceAll(" ", "_"));
                    File fileRaiz = new File(nomePastaEvento);

                    if (fileRaiz.exists()) {
                        excluirImagens(fileRaiz);
                    }
                    fileRaiz.mkdirs();
                    List<Arq_arquivoT> listArq = getArq_arquivoDAO().getEvento(eve_eventoT);
                    List<Sel_seloT> listSel = getSel_seloDAO().getEvento(eve_eventoT);
                    //File file = new File();
                    int indice = 0;
                    float total = listArq.size() + listSel.size();
                    if (listArq.size() > 0) {
                        for (Arq_arquivoT arq_arquivoT : listArq) {
                            salvarImagens(arq_arquivoT, fileRaiz);                            
                            percentual =  ( ((++indice*100) / total));
                        }
                    }

                    
                    if (listSel.size() > 0) {
                        for (Sel_seloT sel_seloT : listSel) {
                            salvarSelos(sel_seloT, fileRaiz);
                            percentual =  ( ((++indice*100) / total));
                        }
                    }

                    CommandLinux.chmod("777", fileRaiz);

                    // Compactrando os arquivos
                    /*
                    Zipper zip = new Zipper();
                    File[] arquivos = {fileRaiz};

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
                    String nomeZip = eve_eventoT.getEve_tx_nome().concat("_").concat(sdf.format(new Date(System.currentTimeMillis())));
                    nomeZip = PASTA_MERCADORIAS.concat(nomeZip.replaceAll(" ", "_").trim());
                    zip.criarZipDiretorioLinux(new File(nomeZip.concat(".zip")), PASTA_MERCADORIAS.concat(eve_eventoT.getEve_tx_nome()).replaceAll(" ", "_"));
                    */
                    // excluir os arquivos deixando apenas o zip
                    //excluirImagens(new File(nomePastaEvento));
                    //Informando a data da ultima exportacao
                    Ond_ondaT ondT = new Ond_ondaT();
                    ondT.setEve_nr_id(eve_eventoT.getEve_nr_id());
                    getOnd_ondaDAO().insert(ondT);
                    percentual = 100;
                } else {
                    // Há uma geracao em Andamento
                    setMsg("Há uma geracao em andamento. tente novamente em alguns minutos!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();


        } finally {
            geracaoIniciada = false;
            close();



        }
    }

    /**
     * @return the eve_eventoT
     */
    public Eve_eventoT getEve_eventoT() {
        return eve_eventoT;


    }

    /**
     * @param eve_eventoT the eve_eventoT to set
     */
    public void setEve_eventoT(Eve_eventoT eve_eventoT) {
        this.eve_eventoT = eve_eventoT;

    }
}
