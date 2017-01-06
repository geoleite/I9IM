/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.imagemanager.gwt.client.dao;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.transfer.Enc_encarteTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Eve_eventoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Eve_eventoDAOGWT  implements IListenetResponse {
    public static final String PAGE_INSERIR = "i9im/i9im/eve_evento/eve_eventoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9im/i9im/eve_evento/eve_eventoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9im/i9im/eve_evento/eve_eventoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private String msg;
    private ListStore list;
    private Eve_eventoTGWT eve_eventoTGWT;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void consultarPorNome(Eve_eventoTGWT eve_eventoTGWT) {
        list = null;
        msg = null;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByNome");
        param.put("eve_eventoT.eve_tx_nome", eve_eventoTGWT.getEve_tx_nome());
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
        //Info.display("Debug", "consultando  " + Constantes.URL + PAGE_CONSULTAR);
    }

    public void inserir(Eve_eventoTGWT eve_eventoTGWT) {
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
        param.put("eve_eventoT.eve_tx_nome", eve_eventoTGWT.getEve_tx_nome());
        param.put("eve_eventoT.eve_dt_inicio", dtfDate.format(eve_eventoTGWT.getEve_dt_inicio()));
        param.put("eve_eventoT.eve_dt_fim", dtfDate.format(eve_eventoTGWT.getEve_dt_fim()));

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Eve_eventoTGWT eve_eventoTGWT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("enc_encarte").isObject();
                    Eve_eventoDAOGWT.this.setEve_eventoTGWT(lerRegistroJson(registro));
                }
            }
        };
        this.setEve_eventoTGWT(null);
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("eve_eventoT.eve_nr_id", eve_eventoTGWT.getEve_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Eve_eventoTGWT eve_eventoTGWT) {
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
        param.put("eve_eventoT.eve_nr_id", eve_eventoTGWT.getEve_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Eve_eventoTGWT eve_eventoTGWT) {
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
        param.put("eve_eventoT.eve_nr_id", eve_eventoTGWT.getEve_nr_id() + "");
        param.put("eve_eventoT.eve_tx_nome", eve_eventoTGWT.getEve_tx_nome());
        param.put("eve_eventoT.eve_dt_inicio", dtfDateTime.format(eve_eventoTGWT.getEve_dt_inicio()));
        param.put("eve_eventoT.eve_dt_fim", dtfDateTime.format(eve_eventoTGWT.getEve_dt_fim()));

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        
        
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();
            ListStore<Eve_eventoTGWT> lista = new ListStore<Eve_eventoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Eve_eventoTGWT eve_eventoTGWT = lerRegistroJson(registro);
                lista.add(eve_eventoTGWT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json
     */
    private Eve_eventoTGWT lerRegistroJson(JSONObject registro) {
        Eve_eventoTGWT eve_eventoTGWT = new Eve_eventoTGWT();
        Integer enc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("eve_nr_id").toString()));
        eve_eventoTGWT.setEve_nr_id(enc_nr_id);
        String enc_tx_nome = EasyContainer.clearAspas(registro.get("eve_tx_nome").toString());
        eve_eventoTGWT.setEve_tx_nome(enc_tx_nome);
        Date eve_dt_inicio = dtfDate.parse(EasyContainer.clearAspas(registro.get("eve_dt_inicio").toString()));
        eve_eventoTGWT.setEve_dt_inicio(eve_dt_inicio);
        Date eve_dt_fim = dtfDate.parse(EasyContainer.clearAspas(registro.get("eve_dt_fim").toString()));
        eve_eventoTGWT.setEve_dt_fim(eve_dt_fim);
        Date eve_dt_criacao = dtfDate.parse(EasyContainer.clearAspas(registro.get("eve_dt_criacao").toString()));
        eve_eventoTGWT.setEve_dt_criacao(eve_dt_criacao);
        String modificado = EasyContainer.clearAspas(registro.get("modificado").toString());
        eve_eventoTGWT.setModificado("S".equals(modificado));
        Integer emp_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("emp_nr_id").toString()));
        eve_eventoTGWT.setEmp_nr_id(emp_nr_id);
        return eve_eventoTGWT;
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
     * @return the eve_eventoTGWT
     */
    public Eve_eventoTGWT getEve_eventoTGWT() {
        return eve_eventoTGWT;
    }

    /**
     * @param eve_eventoTGWT the eve_eventoTGWT to set
     */
    public void setEve_eventoTGWT(Eve_eventoTGWT eve_eventoTGWT) {
        this.eve_eventoTGWT = eve_eventoTGWT;
    }

}
