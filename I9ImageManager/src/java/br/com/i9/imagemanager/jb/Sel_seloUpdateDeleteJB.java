package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.i9.imagemanager.util.Zipper;
import br.com.i9.imagemanager.util.images.Images;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Sel_seloUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Sel_seloT sel_seloT = new Sel_seloT();
    private Pro_produtoT pro_produtoT = new Pro_produtoT();
    private String thumb = "S";
    private String idsSelos, idsProdutos;

    public void setSel_seloT(Sel_seloT sel_seloT) {
        this.sel_seloT = sel_seloT;
    }

    public Sel_seloT getSel_seloT() {
        return sel_seloT;
    }
    private List<Sel_seloT> list;

    public List<Sel_seloT> getList() {
        return list;
    }

    public void setList(List<Sel_seloT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
        consultCls_classificacao_selo();

        //consultTid_tipodocumento();

    }

    public void adicionarProdutos() {
        try {
            if (idsProdutos != null) {
                String[] ids = idsProdutos.split(",");
                Pro_selT ps = new Pro_selT();
                ps.setSel_nr_id(sel_seloT.getSel_nr_id());
                if (ids.length == 1) {
                    setMsg(INFO, "Produtos nao foram selecionados!");
                    return;
                }
                for (int i = 1; i < ids.length; i++) {
                    int proNrId = Integer.parseInt(ids[i]);
                    ps.setPro_nr_id(proNrId);
                    getPro_selDAO().insert(ps);
                }
            }
            setMsg(INFO, "Produtos Adicionados com Sucesso!");
        } catch (Exception e) {
            setMsg(ERROR, "Falha ao adicionar produto ao selo!");
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void adicionarSelos() {
        try {
            if (idsSelos != null) {
                String[] ids = idsSelos.split(",");
                Pro_selT ps = new Pro_selT();
                ps.setPro_nr_id(pro_produtoT.getPro_nr_id());
                if (ids.length == 1) {
                    setMsg(INFO, "Selos nao foram selecionados!");
                    return;
                }
                for (int i = 1; i < ids.length; i++) {
                    int selNrId = Integer.parseInt(ids[i]);
                    ps.setSel_nr_id(selNrId);
                    getPro_selDAO().insert(ps);
                }
            }
            setMsg(INFO, "Selos Adicionados com Sucesso!");
        } catch (Exception e) {
            setMsg(ERROR, "Falha ao adicionar selos ao produto!");
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void removerProdutos() {
        try {
            if (idsProdutos != null) {
                String[] ids = idsProdutos.split(",");
                if (ids.length == 1) {
                    setMsg(INFO, "Produtos nao foram selecionados!");
                    return;
                }

                getPro_selDAO().deleteIds(sel_seloT, idsProdutos);
                setMsg(INFO, "Selos Removidos com Sucesso!");
            }
        } catch (Exception e) {
            setMsg(ERROR, "Falha ao remover selos do produto!");
            e.printStackTrace();
        } finally {
            close();
        }

    }

    public void removerSelos() {
        try {
            if (idsSelos != null) {
                String[] ids = idsSelos.split(",");
                if (ids.length == 1) {
                    setMsg(INFO, "Selos nao foram selecionados!");
                    return;
                }

                getPro_selDAO().deleteIds(pro_produtoT, idsSelos);
                setMsg(INFO, "Selos Removidos com Sucesso!");
            }
        } catch (Exception e) {
            setMsg(ERROR, "Falha ao remover selos do produto!");
            e.printStackTrace();
        } finally {
            close();
        }
    }

    /**
     * Salva o arquivo em disco
     * @param dirName
     * @param selT
     * @throws Exception
     */
    private void salvarImagemDisco(String dirName, Sel_seloT selT) throws Exception {
        File fileDir = new File(dirName);
        fileDir.mkdirs();
        File file = new File(dirName.concat("/").concat(selT.getSel_tx_nome()));
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(selT.getSel_bt_arquivo());
        fos.flush();
        fos.close();
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

    private void salvarZip(byte[] zipImages) throws Exception {
        FileOutputStream fos = new FileOutputStream(PASTA_BASE.concat(getSession().getId().concat("_selos.zip")));
        fos.write(zipImages);
        fos.flush();
        fos.close();
    }

    public void downloadSelos() {
        try {
            if (idsSelos != null) {
                String[] ids = idsSelos.split(",");
                if (ids.length == 1) {
                    setMsg(INFO, "Selos nao foram selecionados!");
                    return;
                }
                String dirName = PASTA_BASE.concat(getSession().getId().concat("_selos"));
                for (int i = 1; i < ids.length; i++) {
                    int selNrId = Integer.parseInt(ids[i]);
                    Sel_seloT selT = new Sel_seloT();
                    selT.setSel_nr_id(selNrId);
                    List<Sel_seloT> listSel = getSel_seloDAO().getBySel_bt_arquivo(selT);
                    if (listSel.size() > 0) {
                        selT = listSel.get(0);
                        salvarImagemDisco(dirName, selT);
                    }
                }
                byte[] zipImages = zipImagens(dirName);
                salvarZip(zipImages);

                //getPro_selDAO().deleteIds(pro_produtoT, idsSelos);
                //setMsg(INFO, "Selos Removidos com Sucesso!");
            }
        } catch (Exception e) {
            setMsg(ERROR, "Falha ao remover selos do produto!");
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void clear() throws Exception {

        sel_seloT = new Sel_seloT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Sel_seloDAO sel_seloDAO = getSel_seloDAO();
                //sel_seloDAO.delete(sel_seloT);
                sel_seloT.setSel_tx_situacao("I");
                sel_seloDAO.updateSituacaoSelo(sel_seloT);
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
            Sel_seloDAO sel_seloDAO = getSel_seloDAO();
            List<Sel_seloT> listTemp = sel_seloDAO.getByPK(sel_seloT);

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
                Sel_seloDAO sel_seloDAO = getSel_seloDAO();
                sel_seloDAO.update(sel_seloT);
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
    private List<Cls_classificacao_seloT> listcls_classificacao_selo;

    public List<Cls_classificacao_seloT> getListcls_classificacao_selo() {
        return listcls_classificacao_selo;
    }

    public void setListcls_classificacao_selo(List<Cls_classificacao_seloT> list) {
        this.listcls_classificacao_selo = list;
    }

    public void consultCls_classificacao_selo() throws Exception {
        try {
            Cls_classificacao_seloDAO cls_classificacao_seloDAO = getCls_classificacao_seloDAO();
            listcls_classificacao_selo = cls_classificacao_seloDAO.getAll();
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

    //Method Download Image ? montando se houver algum campo do tipo bin?rio
    //
    /**
     * Download de Imagem caso existe sen?o pode remover
     */
    public void downloadImage() throws Exception {

        try {
            findbyidArquivo();
            try {
                BufferedImage bi = bytesToImage(sel_seloT.getSel_bt_arquivo());
                /*
                if ("S".equals(getThumb())) {
                bi = createScaledImage(bi, 80, 60);
                } else if ("I".equals(getThumb())) {
                bi = createScaledImage(bi, 20, 20);
                } else {
                bi = createScaledImage(bi, 320, 240);
                }
                 */
                sel_seloT.setSel_bt_arquivo(imageToBytes(bi));
            } catch (Exception e) {                
            }


            Sel_seloT selT = new Sel_seloT();
            selT.setSel_nr_id(sel_seloT.getSel_nr_id());
            selT = findbyIdSel_selo(selT);
            Tid_tipodocumentoT tidT = new Tid_tipodocumentoT();
            tidT.setTid_nr_id(selT.getTid_nr_id());
            tidT = findbyIdTid_tipodocumento(tidT);
            if ("N".equals(tidT.getTid_tx_reduzir())) {
                /*
                if ("_CDR_PDF_PSD_PS_SVG_BMP_AI_EPS_".indexOf(tidT.getTid_tx_sigla().toUpperCase()) > -1) {
                    sel_seloT.setSel_bt_arquivo(Images.getImage(tidT.getTid_tx_sigla().toLowerCase().concat(".png")));
                } else {

                }
                */
            } else {
            }
            //getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "image/jpg");
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "desconhecido");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, sel_seloT.getSel_tx_nome());
            getRequest().setAttribute(EasyDownloadJB.DATA, sel_seloT.getSel_bt_arquivo());
            //getPage().forward("easydownload.jsp");
            getPage().forward("../../../portal/easydownload.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }

    }

    public void findbyidArquivo() throws Exception {
        try {
            List<Sel_seloT> listTemp = getSel_seloDAO().getBySel_bt_arquivo(sel_seloT);
            sel_seloT = listTemp.size() > 0 ? listTemp.get(0) : new Sel_seloT();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void findbyid() throws Exception {
        try {
            Sel_seloDAO sel_seloDAO = getSel_seloDAO();
            List<Sel_seloT> listTemp = sel_seloDAO.getByPK(sel_seloT);

            sel_seloT = listTemp.size() > 0 ? listTemp.get(0) : new Sel_seloT();

        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    /**
     * Volta para a p?gina de consulta
     */
    public void consult() throws Exception {
        // TODO Consult
        try {
            String page = "sel_seloConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "sel_seloConsult.jsp";// defina aqui a p?gina que deve ser chamada
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
     * @return the idsSelos
     */
    public String getIdsSelos() {
        return idsSelos;
    }

    /**
     * @param idsSelos the idsSelos to set
     */
    public void setIdsSelos(String idsSelos) {
        this.idsSelos = idsSelos;
    }

    /**
     * @return the pro_produtoT
     */
    public Pro_produtoT getPro_produtoT() {
        return pro_produtoT;
    }

    /**
     * @param pro_produtoT the pro_produtoT to set
     */
    public void setPro_produtoT(Pro_produtoT pro_produtoT) {
        this.pro_produtoT = pro_produtoT;
    }

    /**
     * @return the idsProdutos
     */
    public String getIdsProdutos() {
        return idsProdutos;
    }

    /**
     * @param idsProdutos the idsProdutos to set
     */
    public void setIdsProdutos(String idsProdutos) {
        this.idsProdutos = idsProdutos;
    }
}
