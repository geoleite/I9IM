package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.i9.imagemanager.dao.Set_setorNewDAO;
import br.com.i9.imagemanager.transfer.Set_setorNewT;
import br.com.jdragon.dao.DAOFactory;
import java.util.ArrayList;
import java.util.Vector;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Set_setorConsultNewJB extends SystemBase {

    // Atributos e propriedades
    private Set_setorNewT Set_setorNewT = new Set_setorNewT();

    public void setSet_setorNewT(Set_setorNewT Set_setorNewT) {
        this.Set_setorNewT = Set_setorNewT;
    }

    public Set_setorNewT getSet_setorNewT() {
        return Set_setorNewT;
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
        Set_setorNewT = (Set_setorNewT) getSession().getAttribute(SETOR);
    }

    public void obtendoSetorRaizColaborador() throws Exception {
        try {
            Set_setorNewT setT = verificaSetorEPai(Set_setorNewT);

            if (setT != null) {
                list = new Vector<Set_setorNewT>();
                list.add(setT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void obtendoSetoresFilhos(Set_setorNewT setT) throws Exception {
        if (setT != null) {
            List<Set_setorNewT> filhos = getSet_setorNewDAO().getAllFilhos(setT);
            if (list == null) {
                list = new ArrayList<Set_setorNewT>();
            }
            list.addAll(filhos);
            for (Set_setorNewT setTTemp : filhos) {
                obtendoSetoresFilhos(setTTemp);
            }
        }
    }

    public void consult() throws Exception {
        try {
            Set_setorNewDAO Set_setorNewDAO = getSet_setorNewDAO();

            if (Set_setorNewT != null) {
                list = new ArrayList<Set_setorNewT>();
                list.add(Set_setorNewT);
                obtendoSetoresFilhos(Set_setorNewT);
            } else {
                list = Set_setorNewDAO.getAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultarSetorSemPai() throws Exception {
        try {
            Set_setorNewDAO Set_setorNewDAO = getSet_setorNewDAO();
            list = Set_setorNewDAO.getAllSemPai();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultarSetoresFilhos() throws Exception {
        try {
            Set_setorNewDAO Set_setorNewDAO = getSet_setorNewDAO();
            list = Set_setorNewDAO.getAllFilhos(Set_setorNewT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Set_setorNewDAO Set_setorNewDAO = getSet_setorNewDAO();
            Set_setorNewDAO.delete(Set_setorNewT);
            setMsg("Exclusao efetuada com sucesso!");
            Set_setorNewT = new Set_setorNewT();
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
