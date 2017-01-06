package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Pag_paginaConsultJB extends SystemBase {

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

    }

    public void consultByEncarte() throws Exception {
        try {
            Pag_paginaDAO pag_paginaDAO = getPag_paginaDAO();
            list = pag_paginaDAO.getByEnc_nr_id(pag_paginaT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consult() throws Exception {
        try {
            Pag_paginaDAO pag_paginaDAO = getPag_paginaDAO();
            list = pag_paginaDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Pag_paginaDAO pag_paginaDAO = getPag_paginaDAO();
            pag_paginaDAO.delete(pag_paginaT);
            setMsg("Exclusao efetuada com sucesso!");
            pag_paginaT = new Pag_paginaT();
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar exclusao!");
        } finally {
            close();
        }
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "pag_paginaInsert.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
