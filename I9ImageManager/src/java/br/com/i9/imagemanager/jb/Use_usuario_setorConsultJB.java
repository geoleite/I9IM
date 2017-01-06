package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import java.util.ArrayList;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Use_usuario_setorConsultJB extends SystemBase {

    // Atributos e propriedades
    private Use_usuario_setorT use_usuario_setorT = new Use_usuario_setorT();

    public void setUse_usuario_setorT(Use_usuario_setorT use_usuario_setorT) {
        this.use_usuario_setorT = use_usuario_setorT;
    }

    public Use_usuario_setorT getUse_usuario_setorT() {
        return use_usuario_setorT;
    }
    private List<Use_usuario_setorT> list;

    public List<Use_usuario_setorT> getList() {
        return list;
    }

    public void setList(List<Use_usuario_setorT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        consult();
    }

    public void consult() throws Exception {
        try {
            Use_usuario_setorDAO use_usuario_setorDAO = getUse_usuario_setorDAO();
            //getUsuarioLogado()
            use_usuario_setorT.setUsu_nr_id(getUsuarioLogado().getUsu_nr_id());
            list = new ArrayList<Use_usuario_setorT>();
            list.add(use_usuario_setorT);
            //list = use_usuario_setorDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Use_usuario_setorDAO use_usuario_setorDAO = getUse_usuario_setorDAO();
            use_usuario_setorDAO.delete(use_usuario_setorT);
            setMsg("Exclusao efetuada com sucesso!");
            use_usuario_setorT = new Use_usuario_setorT();
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
            String page = "use_usuario_setorInsert.jsp";// defina aqui a p?gina que deve ser chamada
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
