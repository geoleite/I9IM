package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.i9.imagemanager.util.Zipper;
import br.com.i9.imagemanager.util.images.Images;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Arq_arquivoUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Arq_arquivoT arq_arquivoT = new Arq_arquivoT();
    private String thumb = "S";
    private String ids;

    public void setArq_arquivoT(Arq_arquivoT arq_arquivoT) {
        this.arq_arquivoT = arq_arquivoT;
    }

    public Arq_arquivoT getArq_arquivoT() {
        return arq_arquivoT;
    }
    private List<Arq_arquivoT> list;

    public List<Arq_arquivoT> getList() {
        return list;
    }

    public void setList(List<Arq_arquivoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        /*
        consultPro_produto();

        consultCla_classificacao();

        consultTid_tipodocumento();
         */
    }

    public void clear() throws Exception {

        arq_arquivoT = new Arq_arquivoT();
    }

    public void deleteIds() {
        try {
            getArq_arquivoDAO().deleteVarios(ids);

            setMsg("Exclusao efetuada com sucesso!");
        } catch (Exception e) {
            setMsg(ERROR, "Falha ao realizar exclusao!");
            e.printStackTrace();
        }
    }

    public void inativarIds() {
        try {
            getArq_arquivoDAO().inativarVarios(ids);

            setMsg("Exclusao efetuada com sucesso!");
        } catch (Exception e) {
            setMsg(ERROR, "Falha ao realizar exclusao!");
            e.printStackTrace();
        }
    }

    public void reativarIds() {
        try {
            getArq_arquivoDAO().reativarVarios(ids);

            setMsg("Reativacão efetuada com sucesso!");
        } catch (Exception e) {
            setMsg(ERROR, "Falha ao reativar arquivos!");
            e.printStackTrace();
        }
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();
                arq_arquivoDAO.delete(arq_arquivoT);
                setMsg("Exclusao efetuada com sucesso!");
                clear();
            } else {
                setMsg(ERROR, "Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar exclusao!");
        } finally {
            close();
        }
    }

    public boolean exist() throws Exception {
        try {
            Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();
            List<Arq_arquivoT> listTemp = arq_arquivoDAO.getByPK(arq_arquivoT);

            return listTemp.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
        return false;

    }

    public void update() throws Exception {
        try {
            if (exist()) {
                Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();
                arq_arquivoDAO.update(arq_arquivoT);
                setMsg("Alteracao efetuada com sucesso!");
            } else {
                setMsg(ERROR, "Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar alteracao!");
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

    private byte[] zipImagens(String dirName) throws Exception {
        try {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Zipper zip = new Zipper();
            File file = new File(dirName);
            zip.criarZip(baos, file.listFiles());
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            deleteDir(new File(dirName));
        }
        return null;
    }

    private void deleteDir(File file) {
        try {
            if (file != null) {
                if (file.isDirectory()) {
                    File[] files = file.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        File file1 = files[i];
                        deleteDir(file1);
                    }
                }
                file.delete();
            }
        } catch (Exception e) {
        }
    }

    private void salvarImagemDisco(String dirName, Arq_arquivoT arqT) throws Exception {
        File fileDir = new File(dirName);
        fileDir.mkdirs();
        File file = new File(fileDir.getPath().concat("/").concat(arqT.getArq_tx_nome()));

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(arqT.getArq_bt_arquivo());
        fos.flush();
        fos.close();
    }

    private void salvarZip(byte[] zipImages) throws Exception {
        FileOutputStream fos = new FileOutputStream(PASTA_BASE.concat(getSession().getId().concat(".zip")));

        fos.write(zipImages);
        fos.flush();
        fos.close();
    }

    private Pro_produtoT getProduto(int proNrId) throws Exception {
        Pro_produtoT proT = new Pro_produtoT();
        proT.setPro_nr_id(proNrId);
        List<Pro_produtoT> listPro = getPro_produtoDAO().getByPK(proT);
        return listPro.size() > 0 ? listPro.get(0) : null;
    }

    public void downloadImagesZip() {
        try {
            if (ids != null) {
                List<Arq_arquivoT> listImages = getArq_arquivoDAO().getArq_bt_arquivoVarios(ids);
                String dirName = PASTA_BASE.concat(getSession().getId());
                for (Arq_arquivoT arq_arquivoT : listImages) {
                    //Obtem o coidog do produto
                    salvarImagemDisco(dirName, arq_arquivoT);
                }
                byte[] zipImages = zipImagens(dirName);
                salvarZip(zipImages);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void downloadImage() throws Exception {

        try {
            findbyidArquivo();
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "image/png");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, "arq_arquivoT.png");

            Arq_arquivoT arqT = new Arq_arquivoT();
            arqT.setPro_nr_id(arq_arquivoT.getPro_nr_id());
            arqT.setArq_nr_id(arq_arquivoT.getArq_nr_id());
            arqT = findbyIdArq_arquivo(arqT);
            Tid_tipodocumentoT tidT = new Tid_tipodocumentoT();
            tidT.setTid_nr_id(arqT.getTid_nr_id());
            tidT = findbyIdTid_tipodocumento(tidT);
            if ("_PNG_JPG_JPEG_".indexOf(tidT.getTid_tx_sigla().toUpperCase()) > -1) {                
                byte[] thumb = findbyidThumb();
                if (thumb != null && thumb.length > 10) {
                    arq_arquivoT.setArq_bt_arquivo(thumb);
                } else {
                    //findbyidArquivo();
                }
            } else {
                arq_arquivoT.setArq_bt_arquivo(Images.getSEM_IMAGEM());
            }


            /*            if ("_CDR_PDF_PSD_PS_SVG_BMP_AI_EPS_".indexOf(tidT.getTid_tx_sigla().toUpperCase()) > -1) {
            //findbyidArquivo();
            arq_arquivoT.setArq_bt_arquivo(Images.getImage(tidT.getTid_tx_sigla().toLowerCase().concat("_maior.png")));
            } else {
            findbyidThumb();
            byte[] thumb = arq_arquivoT.getArq_bt_thumb();
            if (thumb != null) {
            arq_arquivoT.setArq_bt_arquivo(thumb);
            } else {
            //findbyidArquivo();
            }

            /*
            //                BufferedImage bi = null;
            //
            //                try {
            //
            //                    bi = bytesToImage(arq_arquivoT.getArq_bt_thumb());
            //                } catch (Exception e) {
            //                    //bi = bytesToImageJPEG(arq_arquivoT.getArq_bt_);
            //                }
            //
            //                try {// Tenta redimencionar Imagems caso nao seja imagem vai dar erro
            //
            //                    if (bi == null) {
            //                        throw new Exception("Imagem nula");
            //                    }
            //                    if ("S".equals(thumb)) {
            //                        //bi = createScaledImage(bi, 120, 100);
            //                    } else if ("I".equals(thumb)) {
            //                        bi = createScaledImage(bi, 30, 25);
            //                    } else {
            //                        bi = createScaledImage(bi, 320, 240);
            //                    }
            //
            //
            //                    //bi = bytesToImagePNG(thumb, arq_arquivoT);
            //
            //                    arq_arquivoT.setArq_bt_arquivo(imageToBytes(bi));
            //
            //                } catch (Exception e) {
            //                    arq_arquivoT.setArq_bt_arquivo(Images.getSEM_IMAGEM());
            //                }
            //
            //
            }
             */
            getRequest().setAttribute(EasyDownloadJB.DATA, arq_arquivoT.getArq_bt_arquivo());
            getPage().forward("../../../portal/easydownload.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void findbyid() throws Exception {
        try {
            Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();
            List<Arq_arquivoT> listTemp = arq_arquivoDAO.getByPK(arq_arquivoT);

            arq_arquivoT = listTemp.size() > 0 ? listTemp.get(0) : new Arq_arquivoT();

        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void findbyidArquivo() throws Exception {
        try {
            Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();
            //String path = getParametro(PATH_ARQUIVO);
            //arq_arquivoDAO.setPath(path);
            List<Arq_arquivoT> listTemp = arq_arquivoDAO.getByArq_bt_arquivo(arq_arquivoT);
            arq_arquivoT = listTemp.size() > 0 ? listTemp.get(0) : new Arq_arquivoT();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public byte[] findbyidThumb() throws Exception {
        try {
            Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();
            String path = getParametro(PATH_ARQUIVO_THUMB);
            arq_arquivoDAO.setPath(path);

            List<Arq_arquivoT> listTemp = arq_arquivoDAO.getByArq_bt_thumb(arq_arquivoT);
            Arq_arquivoT arqT = listTemp.size() > 0 ? listTemp.get(0) : null;
            return arqT.getArq_bt_thumb();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
        return null;
    }

    /**
     * Volta para a p?gina de consulta
     */
    public void consult() throws Exception {
        // TODO Consult
        try {
            String page = "arq_arquivoConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
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
     * @return the thumb
     */
    public String getThumb() {
        return thumb;
    }

    /**
     * @param thumb the thumb to set
     */
    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    /**
     * @return the ids
     */
    public String getIds() {
        return ids;
    }

    /**
     * @param ids the ids to set
     */
    public void setIds(String ids) {
        this.ids = ids;
    }
}
