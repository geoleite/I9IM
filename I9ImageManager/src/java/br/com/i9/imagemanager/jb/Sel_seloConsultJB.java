package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Sel_seloConsultJB extends SystemBase {

    // Atributos e propriedades
    private Sel_seloT sel_seloT = new Sel_seloT();
    private Pro_produtoT pro_produtoT = new Pro_produtoT();
    private Cls_classificacao_seloT cls_classificacao_seloT = new Cls_classificacao_seloT();
    private String tipo = "Caracteristicas";

    public void setSel_seloT(Sel_seloT sel_seloT) {
        this.sel_seloT = sel_seloT;
    }

    public Sel_seloT getSel_seloT() {
        return sel_seloT;
    }
    private List<Sel_seloT> list;

    public List<Sel_seloT> getList() {
        return list;
    }

    public void setList(List<Sel_seloT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //consult();
    }

    public void consult() throws Exception {
        try {
            Sel_seloT selT = new Sel_seloT();
            Sel_seloDAO sel_seloDAO = getSel_seloDAO();
            if ("Caracteristicas".equalsIgnoreCase(tipo)) {
                selT.setCls_nr_id(1);
            } else if ("Marcas".equalsIgnoreCase(tipo)) {
                selT.setCls_nr_id(2);
            } else if ("Diversos".equalsIgnoreCase(tipo)) {
                selT.setCls_nr_id(3);
            }
            selT.setSel_tx_nome(sel_seloT.getSel_tx_nome());
            list = sel_seloDAO.getByCls_classificacao_seloNomeArquivo(selT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultSelosProduto() throws Exception {
        try {
            Sel_seloDAO sel_seloDAO = getSel_seloDAO();
            list = sel_seloDAO.getSelosProdutos(pro_produtoT, cls_classificacao_seloT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultSelosNaoProduto() throws Exception {
        try {
            Sel_seloDAO sel_seloDAO = getSel_seloDAO();
            list = sel_seloDAO.getSelosNaoProdutos(sel_seloT,pro_produtoT, cls_classificacao_seloT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Sel_seloDAO sel_seloDAO = getSel_seloDAO();
            sel_seloDAO.delete(sel_seloT);
            setMsg("Exclusao efetuada com sucesso!");
            sel_seloT = new Sel_seloT();
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
            String page = "sel_seloInsert.jsp";// defina aqui a p?gina que deve ser chamada
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

    /**
     * @return the pro_produtoT
     */
    public Pro_produtoT getPro_produtoT() {
        return pro_produtoT;
    }

    /**
     * @param pro_produtoT the pro_produtoT to set
     */
    public void setPro_produtoT(Pro_produtoT pro_produtoT) {
        this.pro_produtoT = pro_produtoT;
    }

    /**
     * @return the cls_classificacao_seloT
     */
    public Cls_classificacao_seloT getCls_classificacao_seloT() {
        return cls_classificacao_seloT;
    }

    /**
     * @param cls_classificacao_seloT the cls_classificacao_seloT to set
     */
    public void setCls_classificacao_seloT(Cls_classificacao_seloT cls_classificacao_seloT) {
        this.cls_classificacao_seloT = cls_classificacao_seloT;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
