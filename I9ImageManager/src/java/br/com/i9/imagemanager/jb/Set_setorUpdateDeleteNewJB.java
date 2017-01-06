package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.i9.imagemanager.dao.Set_setorNewDAO;
import br.com.i9.imagemanager.transfer.Set_setorNewT;
import br.com.jdragon.dao.DAOFactory;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Set_setorUpdateDeleteNewJB extends SystemBase {

    // Atributos e propriedades
    private Set_setorNewT set_setorT = new Set_setorNewT();

    public void setSet_setorT(Set_setorNewT set_setorT) {
        this.set_setorT = set_setorT;
    }

    public Set_setorNewT getSet_setorT() {
        return set_setorT;
    }
    private List<Set_setorNewT> list;

    public List<Set_setorNewT> getList() {
        return list;
    }

    public void setList(List<Set_setorNewT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void clear() throws Exception {

        set_setorT = new Set_setorNewT();
    }

    private void deleteRecursivo(Set_setorNewT setT) throws Exception {
        List<Set_setorNewT> listSet = getSet_setorNewDAO().getAllFilhos(setT);
        for (Set_setorNewT set_setorT : listSet) {
            deleteRecursivo(set_setorT);
            getSet_setorNewDAO().delete(set_setorT);
        }
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Set_setorNewDAO set_setorDAO = getSet_setorNewDAO();
                deleteRecursivo(set_setorT);
                set_setorDAO.delete(set_setorT);
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
            Set_setorNewDAO set_setorDAO = getSet_setorNewDAO();
            List<Set_setorNewT> listTemp = set_setorDAO.getByPK(set_setorT);

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
                Set_setorNewDAO set_setorDAO = getSet_setorNewDAO();
                set_setorDAO.update(set_setorT);
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

    public void obtendoSetorColaborador() {
        set_setorT = (Set_setorNewT)getSession().getAttribute(SETOR);
    }
    //Method Download Image ? montando se houver algum campo do tipo bin?rio
    //|DOWNLOADIMAGE|
    public void findbyid() throws Exception {
        try {
            Set_setorNewDAO set_setorDAO = getSet_setorNewDAO();
            List<Set_setorNewT> listTemp = set_setorDAO.getByPK(set_setorT);

            set_setorT = listTemp.size() > 0 ? listTemp.get(0) : new Set_setorNewT();

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
            String page = "set_setorConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
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
