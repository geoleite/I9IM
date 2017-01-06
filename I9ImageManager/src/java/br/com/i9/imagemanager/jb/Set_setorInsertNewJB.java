package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.i9.imagemanager.dao.Set_setorNewDAO;
import br.com.i9.imagemanager.transfer.Set_setorNewT;
import br.com.jdragon.dao.DAOFactory;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Set_setorInsertNewJB extends SystemBase {

    // Atributos e propriedades
    private Set_setorNewT set_setorT = new Set_setorNewT();

    public void setSet_setorT(Set_setorNewT set_setorT) {
        this.set_setorT = set_setorT;
    }

    public Set_setorNewT getSet_setorT() {
        return set_setorT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    // M?todos de Eventos
    public void insert() throws Exception {

        try {
            Set_setorNewDAO set_setorDAO = getSet_setorNewDAO();
            set_setorDAO.insert(set_setorT);
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
    private List<Set_setorNewT> listset_setor;

    public List<Set_setorNewT> getListset_setor() {
        return listset_setor;
    }

    public void setListset_setor(List<Set_setorNewT> list) {
        this.listset_setor = list;
    }

    public void consultSet_setor() throws Exception {
        try {
            Set_setorNewDAO set_setorDAO = getSet_setorNewDAO();
            listset_setor = set_setorDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void clear() throws Exception {

        set_setorT = new Set_setorNewT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "set_setorConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
