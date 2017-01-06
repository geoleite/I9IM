package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Cls_classificacao_seloConsultJB extends SystemBase {

    // Atributos e propriedades
    private Cls_classificacao_seloT cls_classificacao_seloT = new Cls_classificacao_seloT();

    public void setCls_classificacao_seloT(Cls_classificacao_seloT cls_classificacao_seloT) {
        this.cls_classificacao_seloT = cls_classificacao_seloT;
    }

    public Cls_classificacao_seloT getCls_classificacao_seloT() {
        return cls_classificacao_seloT;
    }
    private List<Cls_classificacao_seloT> list;

    public List<Cls_classificacao_seloT> getList() {
        return list;
    }

    public void setList(List<Cls_classificacao_seloT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        consult();
    }

    public void consult() throws Exception {
        try {
            Cls_classificacao_seloDAO cls_classificacao_seloDAO = getCls_classificacao_seloDAO();
            list = cls_classificacao_seloDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Cls_classificacao_seloDAO cls_classificacao_seloDAO = getCls_classificacao_seloDAO();
            cls_classificacao_seloDAO.delete(cls_classificacao_seloT);
            setMsg("Exclusao efetuada com sucesso!");
            cls_classificacao_seloT = new Cls_classificacao_seloT();
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
            String page = "cls_classificacao_seloInsert.jsp";// defina aqui a p?gina que deve ser chamada
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
