package br.com.i9.imagemanager.gwt.client.dao;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.transfer.Use_usuario_setorTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Use_usuario_setorDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9im/i9im/use_usuario_setor/use_usuario_setorInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9im/i9im/use_usuario_setor/use_usuario_setorConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9im/i9im/use_usuario_setor/use_usuario_setorUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Use_usuario_setorTGWT use_usuario_setorT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Use_usuario_setorTGWT use_usuario_setorT) {
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
        param.put("use_usuario_setorT.usu_nr_id", use_usuario_setorT.getUsu_nr_id() + "");
        param.put("use_usuario_setorT.set_nr_id", use_usuario_setorT.getSet_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Use_usuario_setorTGWT use_usuario_setorT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("use_usuario_setor").isObject();
                    Use_usuario_setorDAOGWT.this.use_usuario_setorT = lerRegistroJson(registro);
                }
            }
        };
        this.use_usuario_setorT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("use_usuario_setorT.usu_nr_id", use_usuario_setorT.getUsu_nr_id() + "");
        param.put("use_usuario_setorT.set_nr_id", use_usuario_setorT.getSet_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Use_usuario_setorTGWT use_usuario_setorT) {
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
        param.put("use_usuario_setorT.usu_nr_id", use_usuario_setorT.getUsu_nr_id() + "");
        param.put("use_usuario_setorT.set_nr_id", use_usuario_setorT.getSet_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Use_usuario_setorTGWT use_usuario_setorT) {
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
        param.put("use_usuario_setorT.usu_nr_id", use_usuario_setorT.getUsu_nr_id() + "");
        param.put("use_usuario_setorT.set_nr_id", use_usuario_setorT.getSet_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Use_usuario_setorTGWT> lista = new ListStore<Use_usuario_setorTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Use_usuario_setorTGWT use_usuario_setorT = lerRegistroJson(registro);
                lista.add(use_usuario_setorT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Use_usuario_setorTGWT lerRegistroJson(JSONObject registro) {
        Use_usuario_setorTGWT use_usuario_setorTGWT = new Use_usuario_setorTGWT();
        Integer usu_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("usu_nr_id").toString()));
        use_usuario_setorTGWT.setUsu_nr_id(usu_nr_id);

        Integer set_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("set_nr_id").toString()));
        use_usuario_setorTGWT.setSet_nr_id(set_nr_id);


        return use_usuario_setorTGWT;
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
     * @return the use_usuario_setorT
     */
    public Use_usuario_setorTGWT getUse_usuario_setorT() {
        return use_usuario_setorT;
    }

    /**
     * @param use_usuario_setorTGWT the use_usuario_setorTGWT to set
     */
    public void setUse_usuario_setorTGWT(Use_usuario_setorTGWT use_usuario_setorT) {
        this.use_usuario_setorT = use_usuario_setorT;
    }
}
