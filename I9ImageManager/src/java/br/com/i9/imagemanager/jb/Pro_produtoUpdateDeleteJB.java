package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Pro_produtoUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Pro_produtoT pro_produtoT = new Pro_produtoT();

    public void setPro_produtoT(Pro_produtoT pro_produtoT) {
        this.pro_produtoT = pro_produtoT;
    }

    public Pro_produtoT getPro_produtoT() {
        return pro_produtoT;
    }
    private List<Pro_produtoT> list;

    public List<Pro_produtoT> getList() {
        return list;
    }

    public void setList(List<Pro_produtoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
        consultSug_subgrupo();
    }

    public void clear() throws Exception {

        pro_produtoT = new Pro_produtoT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
                pro_produtoDAO.delete(pro_produtoT);
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
            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            List<Pro_produtoT> listTemp = pro_produtoDAO.getByPK(pro_produtoT);

            return listTemp.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
        return false;

    }

    public void updateObs() {
        try {
            if (exist()) {
                Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
                pro_produtoDAO.updateObs(pro_produtoT);
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
    public void update() throws Exception {
        try {
            if (exist()) {
                Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
                pro_produtoDAO.update(pro_produtoT);
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
    private List<Sug_subgrupoT> listsug_subgrupo;

    public List<Sug_subgrupoT> getListsug_subgrupo() {
        return listsug_subgrupo;
    }

    public void setListsug_subgrupo(List<Sug_subgrupoT> list) {
        this.listsug_subgrupo = list;
    }

    public void consultSug_subgrupo() throws Exception {
        try {
            Sug_subgrupoDAO sug_subgrupoDAO = getSug_subgrupoDAO();
            listsug_subgrupo = sug_subgrupoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    //Method Download Image ? montando se houver algum campo do tipo bin?rio
    //|DOWNLOADIMAGE|
    public void findbyid() throws Exception {
        try {
            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            List<Pro_produtoT> listTemp = pro_produtoDAO.getByPK(pro_produtoT);

            pro_produtoT = listTemp.size() > 0 ? listTemp.get(0) : new Pro_produtoT();

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
            String page = "pro_produtoConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "pro_produtoConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
