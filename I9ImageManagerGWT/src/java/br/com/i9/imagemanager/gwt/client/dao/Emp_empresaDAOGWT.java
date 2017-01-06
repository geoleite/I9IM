package br.com.i9.imagemanager.gwt.client.dao;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.transfer.Emp_empresaTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Emp_empresaDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9im/i9im/emp_empresa/emp_empresaInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9im/i9im/emp_empresa/emp_empresaConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9im/i9im/emp_empresa/emp_empresaUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Emp_empresaTGWT emp_empresaT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Emp_empresaTGWT emp_empresaT) {
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
        param.put("emp_empresaT.emp_tx_nome", emp_empresaT.getEmp_tx_nome() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Emp_empresaTGWT emp_empresaT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("emp_empresa").isObject();
                    Emp_empresaDAOGWT.this.emp_empresaT = lerRegistroJson(registro);
                }
            }
        };
        this.emp_empresaT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("emp_empresaT.emp_nr_id", emp_empresaT.getEmp_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Emp_empresaTGWT emp_empresaT) {
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
        param.put("op", "delete");
        param.put("emp_empresaT.emp_nr_id", emp_empresaT.getEmp_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Emp_empresaTGWT emp_empresaT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                }
            }
        };
        msg = null;
        list = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "update");
        param.put("emp_empresaT.emp_nr_id", emp_empresaT.getEmp_nr_id() + "");
        param.put("emp_empresaT.emp_tx_nome", emp_empresaT.getEmp_tx_nome() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Emp_empresaTGWT> lista = new ListStore<Emp_empresaTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Emp_empresaTGWT emp_empresaT = lerRegistroJson(registro);
                lista.add(emp_empresaT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Emp_empresaTGWT lerRegistroJson(JSONObject registro) {
        Emp_empresaTGWT emp_empresaTGWT = new Emp_empresaTGWT();
        Integer emp_nr_id = Integer.parseInt(registro.get("emp_nr_id").isString().stringValue());
        emp_empresaTGWT.setEmp_nr_id(emp_nr_id);

        String emp_tx_nome = registro.get("emp_tx_nome").isString().stringValue();
        emp_empresaTGWT.setEmp_tx_nome(emp_tx_nome);


        return emp_empresaTGWT;
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
     * @return the emp_empresaT
     */
    public Emp_empresaTGWT getEmp_empresaT() {
        return emp_empresaT;
    }

    /**
     * @param emp_empresaTGWT the emp_empresaTGWT to set
     */
    public void setEmp_empresaTGWT(Emp_empresaTGWT emp_empresaT) {
        this.emp_empresaT = emp_empresaT;
    }
}
