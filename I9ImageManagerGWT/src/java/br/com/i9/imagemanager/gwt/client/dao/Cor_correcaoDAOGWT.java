package br.com.i9.imagemanager.gwt.client.dao;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.transfer.Cor_correcaoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Cor_correcaoDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9im/i9im/cor_correcao/cor_correcaoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9im/i9im/cor_correcao/cor_correcaoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9im/i9im/cor_correcao/cor_correcaoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Cor_correcaoTGWT cor_correcaoT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void consultBySetorPagina(Cor_correcaoTGWT corT) {
        list = null;
        msg = null;
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultBySetorPagina");
        param.put("cor_correcaoT.set_nr_id", corT.getSet_nr_id() + "");
        param.put("cor_correcaoT.pag_nr_id", corT.getPag_nr_id() + "");

        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void consultByUsuarioPagina(Cor_correcaoTGWT corT) {
        list = null;
        msg = null;
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByUsuarioPagina");
        param.put("cor_correcaoT.usu_nr_id", corT.getUsu_nr_id() + "");
        param.put("cor_correcaoT.pag_nr_id", corT.getPag_nr_id() + "");

        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void inserir(Cor_correcaoTGWT cor_correcaoT) {
        msg = null;
        list = null;
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    String result = jsonObject.get("resultado").isString().stringValue();
                    msg = result;
                }
            }
        };
        String url = Constantes.URL + PAGE_INSERIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "insert");
        param.put("cor_correcaoT.tic_nr_id", cor_correcaoT.getTic_nr_id() + "");
        param.put("cor_correcaoT.cor_tx_observacao", cor_correcaoT.getCor_tx_observacao());
        //param.put("cor_correcaoT.set_nr_id", cor_correcaoT.getSet_nr_id() + "");
        //param.put("cor_correcaoT.usu_nr_id", cor_correcaoT.getUsu_nr_id() + "");
        param.put("cor_correcaoT.cor_tx_status", cor_correcaoT.getCor_tx_status());
        param.put("cor_correcaoT.cor_nr_posx", cor_correcaoT.getCor_nr_posx() + "");
        param.put("cor_correcaoT.cor_nr_posy", cor_correcaoT.getCor_nr_posy() + "");
        param.put("cor_correcaoT.cor_nr_posx2", cor_correcaoT.getCor_nr_posx2() + "");
        param.put("cor_correcaoT.cor_nr_posy2", cor_correcaoT.getCor_nr_posy2() + "");
        param.put("cor_correcaoT.reg_nr_id", cor_correcaoT.getReg_nr_id() + "");
        param.put("cor_correcaoT.pag_nr_id", cor_correcaoT.getPag_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Cor_correcaoTGWT cor_correcaoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("cor_correcao").isObject();
                    Cor_correcaoDAOGWT.this.cor_correcaoT = lerRegistroJson(registro);
                }
            }
        };
        this.cor_correcaoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("cor_correcaoT.cor_nr_id", cor_correcaoT.getCor_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Cor_correcaoTGWT cor_correcaoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
//                    String result = jsonObject.get("resultado").toString();
                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();

//                    msg = result;
                }
            }
        };

        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "delete");
        param.put("cor_correcaoT.cor_nr_id", cor_correcaoT.getCor_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void excluirSemChave(Cor_correcaoTGWT cor_correcaoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                }
            }
        };

        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "deleteSemChave");
        param.put("cor_correcaoT.tic_nr_id", cor_correcaoT.getTic_nr_id() + "");
        param.put("cor_correcaoT.cor_tx_observacao", cor_correcaoT.getCor_tx_observacao());
        param.put("cor_correcaoT.set_nr_id", cor_correcaoT.getSet_nr_id() + "");
        param.put("cor_correcaoT.usu_nr_id", cor_correcaoT.getUsu_nr_id() + "");
        param.put("cor_correcaoT.cor_tx_status", cor_correcaoT.getCor_tx_status());
        param.put("cor_correcaoT.cor_nr_posx", cor_correcaoT.getCor_nr_posx() + "");
        param.put("cor_correcaoT.cor_nr_posy", cor_correcaoT.getCor_nr_posy() + "");
        param.put("cor_correcaoT.cor_nr_posx2", cor_correcaoT.getCor_nr_posx2() + "");
        param.put("cor_correcaoT.cor_nr_posy2", cor_correcaoT.getCor_nr_posy2() + "");
        param.put("cor_correcaoT.reg_nr_id", cor_correcaoT.getReg_nr_id() + "");
        param.put("cor_correcaoT.pag_nr_id", cor_correcaoT.getPag_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Cor_correcaoTGWT cor_correcaoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();

//                    String result = jsonObject.get("resultado").toString();
//                    msg = result;
                }
            }
        };
        msg = null;
        list = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "update");
        param.put("cor_correcaoT.cor_nr_id", cor_correcaoT.getCor_nr_id() + "");
        param.put("cor_correcaoT.tic_nr_id", cor_correcaoT.getTic_nr_id() + "");
        param.put("cor_correcaoT.cor_tx_observacao", cor_correcaoT.getCor_tx_observacao());
        param.put("cor_correcaoT.set_nr_id", cor_correcaoT.getSet_nr_id() + "");
        param.put("cor_correcaoT.usu_nr_id", cor_correcaoT.getUsu_nr_id() + "");
        param.put("cor_correcaoT.cor_tx_status", cor_correcaoT.getCor_tx_status());
        param.put("cor_correcaoT.cor_nr_posx", cor_correcaoT.getCor_nr_posx() + "");
        param.put("cor_correcaoT.cor_nr_posy", cor_correcaoT.getCor_nr_posy() + "");
        param.put("cor_correcaoT.cor_nr_posx2", cor_correcaoT.getCor_nr_posx2() + "");
        param.put("cor_correcaoT.cor_nr_posy2", cor_correcaoT.getCor_nr_posy2() + "");
        param.put("cor_correcaoT.reg_nr_id", cor_correcaoT.getReg_nr_id() + "");
        param.put("cor_correcaoT.cor_dt_corrigido", dtfDateTime.format(cor_correcaoT.getCor_dt_corrigido()));
        param.put("cor_correcaoT.pag_nr_id", cor_correcaoT.getPag_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Cor_correcaoTGWT> lista = new ListStore<Cor_correcaoTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Cor_correcaoTGWT cor_correcaoT = lerRegistroJson(registro);
                lista.add(cor_correcaoT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Cor_correcaoTGWT lerRegistroJson(JSONObject registro) {
        Cor_correcaoTGWT cor_correcaoTGWT = new Cor_correcaoTGWT();
        Integer cor_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cor_nr_id").toString()));
        cor_correcaoTGWT.setCor_nr_id(cor_nr_id);

        Integer tic_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("tic_nr_id").toString()));
        cor_correcaoTGWT.setTic_nr_id(tic_nr_id);

        String cor_tx_observacao = EasyContainer.clearAspas(registro.get("cor_tx_observacao").toString());
        cor_correcaoTGWT.setCor_tx_observacao(cor_tx_observacao);

        Integer set_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("set_nr_id").toString()));
        cor_correcaoTGWT.setSet_nr_id(set_nr_id);

        Integer usu_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("usu_nr_id").toString()));
        cor_correcaoTGWT.setUsu_nr_id(usu_nr_id);

        String cor_tx_status = EasyContainer.clearAspas(registro.get("cor_tx_status").toString());
        cor_correcaoTGWT.setCor_tx_status(cor_tx_status);

        Integer cor_nr_posx = Integer.parseInt(EasyContainer.clearAspas(registro.get("cor_nr_posx").toString()));
        cor_correcaoTGWT.setCor_nr_posx(cor_nr_posx);

        Integer cor_nr_posy = Integer.parseInt(EasyContainer.clearAspas(registro.get("cor_nr_posy").toString()));
        cor_correcaoTGWT.setCor_nr_posy(cor_nr_posy);

        Integer cor_nr_posx2 = Integer.parseInt(EasyContainer.clearAspas(registro.get("cor_nr_posx2").toString()));
        cor_correcaoTGWT.setCor_nr_posx2(cor_nr_posx2);

        Integer cor_nr_posy2 = Integer.parseInt(EasyContainer.clearAspas(registro.get("cor_nr_posy2").toString()));
        cor_correcaoTGWT.setCor_nr_posy2(cor_nr_posy2);

        Integer reg_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("reg_nr_id").toString()));
        cor_correcaoTGWT.setReg_nr_id(reg_nr_id);

        Date cor_dt_corrigido = dtfDateTime.parse(EasyContainer.clearAspas(registro.get("cor_dt_corrigido").toString()));
        cor_correcaoTGWT.setCor_dt_corrigido(cor_dt_corrigido);

        Integer pag_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("pag_nr_id").toString()));
        cor_correcaoTGWT.setPag_nr_id(pag_nr_id);


        return cor_correcaoTGWT;
    }

    /**
     * @return the list
     */
    public ListStore getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ListStore list) {
        this.list = list;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the cor_correcaoT
     */
    public Cor_correcaoTGWT getCor_correcaoT() {
        return cor_correcaoT;
    }

    /**
     * @param cor_correcaoTGWT the cor_correcaoTGWT to set
     */
    public void setCor_correcaoTGWT(Cor_correcaoTGWT cor_correcaoT) {
        this.cor_correcaoT = cor_correcaoT;
    }
}
