package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyFileUpload;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.i9.imagemanager.transfer.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Sel_seloInsertJB extends SystemBase {

    // Atributos e propriedades
    private Sel_seloT sel_seloT = new Sel_seloT();
    private Cls_classificacao_seloT cls_classificacao_seloT = new Cls_classificacao_seloT();
    private Tid_tipodocumentoT tid_tipodocumentoT = new Tid_tipodocumentoT();
    private String query;
    private boolean multiplos = false;
    private byte[] Filedata;
    private ArquivoT arquivoT = new ArquivoT();

    public void setSel_seloT(Sel_seloT sel_seloT) {
        this.sel_seloT = sel_seloT;
    }

    public Sel_seloT getSel_seloT() {
        return sel_seloT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        if ("insert".equals(getOp())) {
            List<Cls_classificacao_seloT> listCls = getCls_classificacao_seloDAO().getByCls_tx_tipo(cls_classificacao_seloT);
            //List<Tid_tipodocumentoT> listTid = getTid_tipodocumentoDAO().getByTid_tx_sigla(tid_tipodocumentoT);
            cls_classificacao_seloT = listCls.get(0);
            //tid_tipodocumentoT = listTid.get(0);
            sel_seloT.setCls_nr_id(cls_classificacao_seloT.getCls_nr_id());
        }
    }

    /**
     * Substituir selo existente
     * @throws Exception
     */
    public void substituir() throws Exception {
        try {

            EasyFileUpload efU = (EasyFileUpload) getRequest().getAttribute("sel_seloT.sel_bt_arquivo");
            String nome = efU.getPath();
            nome = getNomeArquivo(nome);
            sel_seloT.setSel_tx_nome(nome);
            sel_seloT.setSel_tx_descricao(nome);

            sel_seloT.setTid_nr_id(getTipoDocumento(nome).getTid_nr_id());
            Sel_seloDAO sel_seloDAO = getSel_seloDAO();
            sel_seloT.setSel_dt_cadastro(new Timestamp(System.currentTimeMillis()));
            sel_seloDAO.substituirArquivo(sel_seloT);
            setMsg(INFO, "Substituicao efetuada com sucesso!");
            clear();
        } catch (Exception e) {
            setMsg(ERROR, "Falha ao substituir selo.");
            e.printStackTrace();
        } finally {
            close();
        }

    }

    private void inserindoArquivo(EasyFileUpload efu) throws Exception {
        String nome = efu.getPath();
        nome = getNomeArquivo(nome);
        sel_seloT.setSel_tx_nome(nome);
        sel_seloT.setSel_tx_descricao(nome);
        sel_seloT.setSel_tx_situacao("A");
        sel_seloT.setTid_nr_id(getTipoDocumento(nome).getTid_nr_id());
        //System.out.println(arq_arquivoT.getCla_nr_id() + ":" + arq_arquivoT.getTid_nr_id());
        Sel_seloDAO sel_seloDAO = getSel_seloDAO();
        sel_seloT.setSel_dt_cadastro(new Timestamp(System.currentTimeMillis()));
        if ("N".equals(sel_seloT.getSel_tx_promocional())) {
            sel_seloDAO.insert(sel_seloT);
        } else {
            sel_seloDAO.insertPromocional(sel_seloT);
        }

    }

    // M?todos de Eventos
    public void insert() throws Exception {

        try {
            // Para insercao de multiplos arquivos
            if (multiplos) {
                String nome = "Filedata";
                EasyFileUpload efu = (EasyFileUpload) getRequest().getAttribute(nome);
                sel_seloT.setSel_bt_arquivo(getFiledata());
                inserindoArquivo(efu);
                setMsg(INFO, "Cadastro efetuado com sucesso!");
                return;
            }

            //EasyFileUpload efU = (EasyFileUpload) getRequest().getAttribute("sel_seloT.sel_bt_arquivo");
            EasyFileUpload efU = (EasyFileUpload) getRequest().getAttribute("arquivoT.arq1");
            if (efU != null) {
                sel_seloT.setSel_bt_arquivo(arquivoT.getArq1());
                inserindoArquivo(efU);
            }
            efU = (EasyFileUpload) getRequest().getAttribute("arquivoT.arq2");
            if (efU != null) {
                sel_seloT.setSel_bt_arquivo(arquivoT.getArq2());
                inserindoArquivo(efU);
            }
            efU = (EasyFileUpload) getRequest().getAttribute("arquivoT.arq3");
            if (efU != null) {
                sel_seloT.setSel_bt_arquivo(arquivoT.getArq3());
                inserindoArquivo(efU);
            }
            efU = (EasyFileUpload) getRequest().getAttribute("arquivoT.arq4");
            if (efU != null) {
                sel_seloT.setSel_bt_arquivo(arquivoT.getArq4());
                inserindoArquivo(efU);
            }
            efU = (EasyFileUpload) getRequest().getAttribute("arquivoT.arq5");
            if (efU != null) {
                sel_seloT.setSel_bt_arquivo(arquivoT.getArq5());
                inserindoArquivo(efU);
            }
            efU = (EasyFileUpload) getRequest().getAttribute("arquivoT.arq6");
            if (efU != null) {
                sel_seloT.setSel_bt_arquivo(arquivoT.getArq6());
                inserindoArquivo(efU);
            }
            efU = (EasyFileUpload) getRequest().getAttribute("arquivoT.arq7");
            if (efU != null) {
                sel_seloT.setSel_bt_arquivo(arquivoT.getArq7());
                inserindoArquivo(efU);
            }

            setMsg(INFO, "Cadastro efetuado com sucesso!");
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar cadastro!");
        } finally {
            close();
        }
    }
// Method de lookup
// 
    private List<Cls_classificacao_seloT> listcls_classificacao_selo;

    public List<Cls_classificacao_seloT> getListcls_classificacao_selo() {
        return listcls_classificacao_selo;
    }

    public void setListcls_classificacao_selo(List<Cls_classificacao_seloT> list) {
        this.listcls_classificacao_selo = list;
    }

    public void consultCls_classificacao_selo() throws Exception {
        try {
            Cls_classificacao_seloDAO cls_classificacao_seloDAO = getCls_classificacao_seloDAO();
            listcls_classificacao_selo = cls_classificacao_seloDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    private List<Tid_tipodocumentoT> listtid_tipodocumento;

    public List<Tid_tipodocumentoT> getListtid_tipodocumento() {
        return listtid_tipodocumento;
    }

    public void setListtid_tipodocumento(List<Tid_tipodocumentoT> list) {
        this.listtid_tipodocumento = list;
    }

    public void consultTid_tipodocumento() throws Exception {
        try {
            Tid_tipodocumentoDAO tid_tipodocumentoDAO = getTid_tipodocumentoDAO();
            listtid_tipodocumento = tid_tipodocumentoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void clear() throws Exception {

        sel_seloT = new Sel_seloT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "sel_seloConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
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
     * @return the arquivoT
     */
    public ArquivoT getArquivoT() {
        return arquivoT;
    }

    /**
     * @param arquivoT the arquivoT to set
     */
    public void setArquivoT(ArquivoT arquivoT) {
        this.arquivoT = arquivoT;
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
            cls_classificacao_seloT.setCls_tx_tipo(parametros[1]);
            sel_seloT.setSel_tx_promocional(parametros[2]);
            if (sel_seloT.getSel_tx_promocional().equalsIgnoreCase("S")) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sel_seloT.setSel_dt_validadeinicio(sdf.parse(parametros[3]));
                sel_seloT.setSel_dt_validadefim(sdf.parse(parametros[4]));
            }
            //s.setPro_nr_id(Integer.parseInt(parametros[2]));
            multiplos = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

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
