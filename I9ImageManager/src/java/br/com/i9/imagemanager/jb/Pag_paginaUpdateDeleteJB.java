package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Pag_paginaUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Pag_paginaT pag_paginaT = new Pag_paginaT();

    public void setPag_paginaT(Pag_paginaT pag_paginaT) {
        this.pag_paginaT = pag_paginaT;
    }

    public Pag_paginaT getPag_paginaT() {
        return pag_paginaT;
    }
    private List<Pag_paginaT> list;

    public List<Pag_paginaT> getList() {
        return list;
    }

    public void setList(List<Pag_paginaT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
        consultEnc_encarte();

    }

    public void clear() throws Exception {

        pag_paginaT = new Pag_paginaT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Pag_paginaDAO pag_paginaDAO = getPag_paginaDAO();
                pag_paginaDAO.delete(pag_paginaT);
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
            Pag_paginaDAO pag_paginaDAO = getPag_paginaDAO();
            List<Pag_paginaT> listTemp = pag_paginaDAO.getByPK(pag_paginaT);

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
                Pag_paginaDAO pag_paginaDAO = getPag_paginaDAO();
                pag_paginaDAO.update(pag_paginaT);
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
    private List<Enc_encarteT> listenc_encarte;

    public List<Enc_encarteT> getListenc_encarte() {
        return listenc_encarte;
    }

    public void setListenc_encarte(List<Enc_encarteT> list) {
        this.listenc_encarte = list;
    }

    public void consultEnc_encarte() throws Exception {
        try {
            Enc_encarteDAO enc_encarteDAO = getEnc_encarteDAO();
            listenc_encarte = enc_encarteDAO.getAll();
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
            findbyid();
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "image/jpg");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, "pag_paginaT.jpg");
            getRequest().setAttribute(EasyDownloadJB.DATA, pag_paginaT.getPag_bt_arquivo());
            getPage().forward("easydownload.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }

    }

    public void findbyid() throws Exception {
        try {
            Pag_paginaDAO pag_paginaDAO = getPag_paginaDAO();
            List<Pag_paginaT> listTemp = pag_paginaDAO.getByPK(pag_paginaT);

            pag_paginaT = listTemp.size() > 0 ? listTemp.get(0) : new Pag_paginaT();

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
            String page = "pag_paginaConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "pag_paginaConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
