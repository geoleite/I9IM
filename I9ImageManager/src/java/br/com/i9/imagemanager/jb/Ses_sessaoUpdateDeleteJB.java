package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Ses_sessaoUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Ses_sessaoT ses_sessaoT = new Ses_sessaoT();
    
    public void setSes_sessaoT(Ses_sessaoT ses_sessaoT) {
        this.ses_sessaoT = ses_sessaoT;
    }

    public Ses_sessaoT getSes_sessaoT() {
        return ses_sessaoT;
    }
    private List<Ses_sessaoT> list;

    public List<Ses_sessaoT> getList() {
        return list;
    }

    public void setList(List<Ses_sessaoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
    }

    public void clear() throws Exception {

        ses_sessaoT = new Ses_sessaoT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Ses_sessaoDAO ses_sessaoDAO = getSes_sessaoDAO();
                ses_sessaoDAO.delete(ses_sessaoT);
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
            Ses_sessaoDAO ses_sessaoDAO = getSes_sessaoDAO();
            List<Ses_sessaoT> listTemp = ses_sessaoDAO.getByPK(ses_sessaoT);

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
                Ses_sessaoDAO ses_sessaoDAO = getSes_sessaoDAO();
                ses_sessaoDAO.update(ses_sessaoT);
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
    //Method Download Image ? montando se houver algum campo do tipo bin?rio
    //|DOWNLOADIMAGE|
    public void findbyid() throws Exception {
        try {
            Ses_sessaoDAO ses_sessaoDAO = getSes_sessaoDAO();
            List<Ses_sessaoT> listTemp = ses_sessaoDAO.getByPK(ses_sessaoT);

            ses_sessaoT = listTemp.size() > 0 ? listTemp.get(0) : new Ses_sessaoT();

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
            String page = "ses_sessaoConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "ses_sessaoConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
