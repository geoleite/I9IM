package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Arq_arquivoConsultJB extends SystemBase {

    // Atributos e propriedades
    private Arq_arquivoT arq_arquivoT = new Arq_arquivoT();
    private String tipoImagem = "Imagem";

    public void setArq_arquivoT(Arq_arquivoT arq_arquivoT) {
        this.arq_arquivoT = arq_arquivoT;
    }

    public Arq_arquivoT getArq_arquivoT() {
        return arq_arquivoT;
    }
    private List<Arq_arquivoT> list;

    public List<Arq_arquivoT> getList() {
        return list;
    }

    public void setList(List<Arq_arquivoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //consult();
    }

    public void consultPorClassificacao() {
        try {
            Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();
            if ("Imagem".equalsIgnoreCase(tipoImagem)) {
                arq_arquivoT.setArq_tx_situacao("A");
                arq_arquivoT.setArq_tx_promocional("N");
                list = arq_arquivoDAO.getAllSituacaoPromocao(arq_arquivoT);
            } else if ("Promocional".equalsIgnoreCase(tipoImagem)) {
                arq_arquivoT.setArq_tx_situacao("A");
                arq_arquivoT.setArq_tx_promocional("S");
                list = arq_arquivoDAO.getAllPromocionais(arq_arquivoT);
            } else if ("Inativa".equalsIgnoreCase(tipoImagem)) {
                arq_arquivoT.setArq_tx_situacao("I");
                list = arq_arquivoDAO.getAllSituacao(arq_arquivoT);
            }

            //list = arq_arquivoDAO.getByClaPro(arq_arquivoT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }
    public void consult() throws Exception {
        try {
            Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();
            list = arq_arquivoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();
            arq_arquivoDAO.delete(arq_arquivoT);
            setMsg("Exclusao efetuada com sucesso!");
            arq_arquivoT = new Arq_arquivoT();
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
            String page = "arq_arquivoInsert.jsp";// defina aqui a p?gina que deve ser chamada
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
     * @return the tipoImagem
     */
    public String getTipoImagem() {
        return tipoImagem;
    }

    /**
     * @param tipoImagem the tipoImagem to set
     */
    public void setTipoImagem(String tipoImagem) {
        this.tipoImagem = tipoImagem;
    }
}
