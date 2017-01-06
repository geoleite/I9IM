package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Set_setorConsultJB extends SystemBase {

    // Atributos e propriedades
    private Set_setorT set_setorT = new Set_setorT();

    public void setSet_setorT(Set_setorT set_setorT) {
        this.set_setorT = set_setorT;
    }

    public Set_setorT getSet_setorT() {
        return set_setorT;
    }
    private List<Set_setorT> list;

    public List<Set_setorT> getList() {
        return list;
    }

    public void setList(List<Set_setorT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        consult();
    }

    public void consult() throws Exception {
        try {
            Set_setorDAO set_setorDAO = getSet_setorDAO();
            list = set_setorDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Set_setorDAO set_setorDAO = getSet_setorDAO();
            set_setorDAO.delete(set_setorT);
            setMsg("Exclusao efetuada com sucesso!");
            set_setorT = new Set_setorT();
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
            String page = "set_setorInsert.jsp";// defina aqui a p?gina que deve ser chamada
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
