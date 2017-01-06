package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyFileUpload;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Pag_paginaInsertJB extends SystemBase {

    // Atributos e propriedades
    private Pag_paginaT pag_paginaT = new Pag_paginaT();
    private String query;
    private boolean multiplos = false;
    private byte[] Filedata;

    public void setPag_paginaT(Pag_paginaT pag_paginaT) {
        this.pag_paginaT = pag_paginaT;
    }

    public Pag_paginaT getPag_paginaT() {
        return pag_paginaT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    private void inserindoArquivo(EasyFileUpload efu) throws Exception {
        String nome = efu.getPath();
        nome = getNomeArquivo(nome);
        pag_paginaT.setPag_tx_nome(nome);
        //System.out.println(arq_arquivoT.getCla_nr_id() + ":" + arq_arquivoT.getTid_nr_id());
        Pag_paginaDAO pagDao = getPag_paginaDAO();
        pagDao.insert(pag_paginaT);
    }

    // M?todos de Eventos
    public void insert() throws Exception {
        try {
            if (multiplos) {
                String nome = "Filedata";
                EasyFileUpload efu = (EasyFileUpload) getRequest().getAttribute(nome);
                pag_paginaT.setPag_bt_arquivo(getFiledata());
                inserindoArquivo(efu);
                setMsg(INFO, "Cadastro efetuado com sucesso!");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar cadastro!");
        } finally {
            close();
        }
    }
// Method de lookup
// 
    private List<Enc_encarteT> listenc_encarte;

    public List<Enc_encarteT> getListenc_encarte() {
        return listenc_encarte;
    }

    public void setListenc_encarte(List<Enc_encarteT> list) {
        this.setListenc_encarte(list);
    }

    public void consultEnc_encarte() throws Exception {
        try {
            Enc_encarteDAO enc_encarteDAO = getEnc_encarteDAO();
            setListenc_encarte(enc_encarteDAO.getAll());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void clear() throws Exception {

        setPag_paginaT(new Pag_paginaT());
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "pag_paginaConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the query
     */
    public String getQuery() {
        return query;
    }

    /**
     * @param query the query to set
     */
    public void setQuery(String query) {
        this.query = query;
        try {
            String str = query;
            String[] parametros = str.split("-");
            setOp(parametros[0]);
            pag_paginaT.setEnc_nr_id(Integer.parseInt(parametros[1]));
            multiplos = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the multiplos
     */
    public boolean isMultiplos() {
        return multiplos;
    }

    /**
     * @param multiplos the multiplos to set
     */
    public void setMultiplos(boolean multiplos) {
        this.multiplos = multiplos;
    }

    /**
     * @return the Filedata
     */
    public byte[] getFiledata() {
        return Filedata;
    }

    /**
     * @param Filedata the Filedata to set
     */
    public void setFiledata(byte[] Filedata) {
        this.Filedata = Filedata;
    }
}
