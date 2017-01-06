package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Cor_correcaoConsultJB extends SystemBase {

    // Atributos e propriedades
    private Cor_correcaoT cor_correcaoT = new Cor_correcaoT();

    public void setCor_correcaoT(Cor_correcaoT cor_correcaoT) {
        this.cor_correcaoT = cor_correcaoT;
    }

    public Cor_correcaoT getCor_correcaoT() {
        return cor_correcaoT;
    }
    private List<Cor_correcaoT> list;

    public List<Cor_correcaoT> getList() {
        return list;
    }

    public void setList(List<Cor_correcaoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();

    }

    public void consult() throws Exception {
        try {
            Cor_correcaoDAO cor_correcaoDAO = getCor_correcaoDAO();
            list = cor_correcaoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultBySetorPagina() throws Exception {
        try {
            Cor_correcaoDAO cor_correcaoDAO = getCor_correcaoDAO();
            cor_correcaoT.setUsu_nr_id(getUsuarioLogado().getUsu_nr_id());
            Use_usuario_setorT useT = (Use_usuario_setorT) getSession().getAttribute(PERFIL_SETOR);
            cor_correcaoT.setSet_nr_id(useT.getSet_nr_id());
            list = cor_correcaoDAO.getBySetorPagina(cor_correcaoT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultByUsuarioPagina() throws Exception {
        try {
            Cor_correcaoDAO cor_correcaoDAO = getCor_correcaoDAO();
            cor_correcaoT.setUsu_nr_id(cor_correcaoT.getUsu_nr_id());
            list = cor_correcaoDAO.getByUsuarioPagina(cor_correcaoT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Cor_correcaoDAO cor_correcaoDAO = getCor_correcaoDAO();
            cor_correcaoDAO.delete(cor_correcaoT);
            setMsg("Exclusao efetuada com sucesso!");
            cor_correcaoT = new Cor_correcaoT();
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
            String page = "cor_correcaoInsert.jsp";// defina aqui a p?gina que deve ser chamada
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
