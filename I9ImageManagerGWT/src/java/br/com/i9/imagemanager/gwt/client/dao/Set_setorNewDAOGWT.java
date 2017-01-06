package br.com.i9.imagemanager.gwt.client.dao;

import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.transfer.Set_setorNewTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Set_setorNewDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9im/i9im/set_setor/set_setorInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9im/i9im/set_setor/set_setorConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9im/i9im/set_setor/set_setorUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Set_setorNewTGWT set_setorT;

    public void consultarTodos() {        
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_CONSULTAR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(url, param);
    }

    public void obtendoSetorRaizColaborador() {
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_CONSULTAR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "obtendoSetorRaizColaborador");
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(url, param);
    }

    public void obtendoSetorColaborador() {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("set_setor").isObject();
                    Set_setorNewDAOGWT.this.set_setorT = lerRegistroJson(registro);
                }
            }
        };
        this.set_setorT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "obtendoSetorColaborador");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);    }

    public void consultarSetorSemPai() {

        this.set_setorT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_CONSULTAR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultarSetorSemPai");
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMapNoMessage(url, param);
    }

    public void consultarSetoresFilhos(Set_setorNewTGWT set_setorT) {

        this.set_setorT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_CONSULTAR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultarSetoresFilhos");
        param.put("set_setorT.set_nr_id", set_setorT.getSet_nr_id() + "");
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMapNoMessage(url, param);
    }


    public void inserir(Set_setorNewTGWT set_setorT) {
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
        param.put("set_setorT.set_tx_nome", set_setorT.getSet_tx_nome());
        param.put("set_setorT.set_tx_status", set_setorT.getSet_tx_status());
        param.put("set_setorT.set_nr_idsetorpai", set_setorT.getSet_nr_idsetorpai() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Set_setorNewTGWT set_setorT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("set_setor").isObject();
                    Set_setorNewDAOGWT.this.set_setorT = lerRegistroJson(registro);
                }
            }
        };
        this.set_setorT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("set_setorT.set_nr_id", set_setorT.getSet_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Set_setorNewTGWT set_setorT) {
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
        param.put("set_setorT.set_nr_id", set_setorT.getSet_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Set_setorNewTGWT set_setorT) {
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
        param.put("set_setorT.set_nr_id", set_setorT.getSet_nr_id() + "");
        param.put("set_setorT.set_tx_nome", set_setorT.getSet_tx_nome());
        param.put("set_setorT.set_tx_status", set_setorT.getSet_tx_status());
        param.put("set_setorT.set_nr_idsetorpai", set_setorT.getSet_nr_idsetorpai() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Set_setorNewTGWT> lista = new ListStore<Set_setorNewTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Set_setorNewTGWT set_setorT = lerRegistroJson(registro);
                lista.add(set_setorT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Set_setorNewTGWT lerRegistroJson(JSONObject registro) {
        Set_setorNewTGWT set_setorTGWT = new Set_setorNewTGWT();
        Integer set_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("set_nr_id").toString()));
        set_setorTGWT.setSet_nr_id(set_nr_id);

        String set_tx_nome = EasyContainer.clearAspas(registro.get("set_tx_nome").toString());
        set_setorTGWT.setSet_tx_nome(set_tx_nome);

        String set_tx_status = EasyContainer.clearAspas(registro.get("set_tx_status").toString());
        set_setorTGWT.setSet_tx_status(set_tx_status);

        Integer set_nr_idsetorpai = Integer.parseInt(EasyContainer.clearAspas(registro.get("set_nr_idsetorpai").toString()));
        set_setorTGWT.setSet_nr_idsetorpai(set_nr_idsetorpai);

        String set_tx_visivel = EasyContainer.clearAspas(registro.get("set_tx_visivel").toString());
        set_setorTGWT.setSet_tx_visivel(set_tx_visivel);

        Integer emp_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("emp_nr_id").toString()));
        set_setorTGWT.setEmp_nr_id(emp_nr_id);

        return set_setorTGWT;
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
     * @return the set_setorT
     */
    public Set_setorNewTGWT getSet_setorT() {
        return set_setorT;
    }

    /**
     * @param set_setorTGWT the set_setorTGWT to set
     */
    public void setSet_setorTGWT(Set_setorNewTGWT set_setorT) {
        this.set_setorT = set_setorT;
    }
}
