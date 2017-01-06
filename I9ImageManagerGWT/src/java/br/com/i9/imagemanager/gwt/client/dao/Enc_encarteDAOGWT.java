package br.com.i9.imagemanager.gwt.client.dao;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.transfer.Enc_encarteTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Enc_encarteDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9im/i9im/enc_encarte/enc_encarteInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9im/i9im/enc_encarte/enc_encarteConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9im/i9im/enc_encarte/enc_encarteUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private String msg;
    private ListStore list;
    private Enc_encarteTGWT enc_encarteT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Enc_encarteTGWT enc_encarteT) {
        msg = null;
        list = null;
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    String result = jsonObject.get("resultado").toString();
                    msg = result;
                }
            }
        };
        String url = Constantes.URL + PAGE_INSERIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "insert");
        param.put("enc_encarteT.enc_tx_nome", enc_encarteT.getEnc_tx_nome());
        param.put("enc_encarteT.enc_dt_limite", dtfDateTime.format(enc_encarteT.getEnc_dt_limite()));

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Enc_encarteTGWT enc_encarteT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("enc_encarte").isObject();
                    Enc_encarteDAOGWT.this.enc_encarteT = lerRegistroJson(registro);
                }
            }
        };
        this.enc_encarteT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("enc_encarteT.enc_nr_id", enc_encarteT.getEnc_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Enc_encarteTGWT enc_encarteT) {
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
        param.put("enc_encarteT.enc_nr_id", enc_encarteT.getEnc_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Enc_encarteTGWT enc_encarteT) {
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
        param.put("enc_encarteT.enc_nr_id", enc_encarteT.getEnc_nr_id() + "");
        param.put("enc_encarteT.enc_tx_nome", enc_encarteT.getEnc_tx_nome());
        param.put("enc_encarteT.enc_dt_limite", dtfDateTime.format(enc_encarteT.getEnc_dt_limite()));

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            ListStore<Enc_encarteTGWT> lista = new ListStore<Enc_encarteTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Enc_encarteTGWT enc_encarteT = lerRegistroJson(registro);
                lista.add(enc_encarteT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Enc_encarteTGWT lerRegistroJson(JSONObject registro) {
        Enc_encarteTGWT enc_encarteTGWT = new Enc_encarteTGWT();
        Integer enc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("enc_nr_id").toString()));
        enc_encarteTGWT.setEnc_nr_id(enc_nr_id);
        String enc_tx_nome = EasyContainer.clearAspas(registro.get("enc_tx_nome").toString());
        enc_encarteTGWT.setEnc_tx_nome(enc_tx_nome);
        Date enc_dt_limite = dtfDateTime.parse(EasyContainer.clearAspas(registro.get("enc_dt_limite").toString()));
        enc_encarteTGWT.setEnc_dt_limite(enc_dt_limite);

        //Info.display("DEBUG", "" + registro.get("emp_nr_id"));
        Integer emp_nr_id = Integer.parseInt(registro.get("emp_nr_id").isString().stringValue());
        enc_encarteTGWT.setEmp_nr_id(emp_nr_id);

        return enc_encarteTGWT;
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
     * @return the enc_encarteT
     */
    public Enc_encarteTGWT getEnc_encarteT() {
        return enc_encarteT;
    }

    /**
     * @param enc_encarteTGWT the enc_encarteTGWT to set
     */
    public void setEnc_encarteTGWT(Enc_encarteTGWT enc_encarteT) {
        this.enc_encarteT = enc_encarteT;
    }
}
