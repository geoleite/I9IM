package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Eve_eventoUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Eve_eventoT eve_eventoT = new Eve_eventoT();
    private byte[] arquivoImportacao;

    public void setEve_eventoT(Eve_eventoT eve_eventoT) {
        this.eve_eventoT = eve_eventoT;
    }

    public Eve_eventoT getEve_eventoT() {
        return eve_eventoT;
    }
    private List<Eve_eventoT> list;

    public List<Eve_eventoT> getList() {
        return list;
    }

    public void setList(List<Eve_eventoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
    }

    public void importar() throws Exception {
    }

    public void clear() throws Exception {

        eve_eventoT = new Eve_eventoT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Eve_eventoDAO eve_eventoDAO = getEve_eventoDAO();
                eve_eventoDAO.delete(eve_eventoT);
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
            Eve_eventoDAO eve_eventoDAO = getEve_eventoDAO();
            List<Eve_eventoT> listTemp = eve_eventoDAO.getByPK(eve_eventoT);

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
                Eve_eventoDAO eve_eventoDAO = getEve_eventoDAO();
                eve_eventoDAO.update(eve_eventoT);
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
            Eve_eventoDAO eve_eventoDAO = getEve_eventoDAO();
            List<Eve_eventoT> listTemp = eve_eventoDAO.getByPK(eve_eventoT);

            eve_eventoT = listTemp.size() > 0 ? listTemp.get(0) : new Eve_eventoT();

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
            String page = "eve_eventoConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "eve_eventoConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
