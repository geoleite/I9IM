package br.com.i9.imagemanager.gwt.client.dao;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.transfer.Pag_paginaTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Pag_paginaDAOGWT implements IListenetResponse {

    public static final String PAGE_INSERIR = "i9im/i9im/pag_pagina/pag_paginaInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9im/i9im/pag_pagina/pag_paginaConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9im/i9im/pag_pagina/pag_paginaUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore list;
    private Pag_paginaTGWT pag_paginaT;

    public void consultarTodos() {
        list = null;
        msg = null;
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
    }

    public void consultByEncarte(Pag_paginaTGWT pagT) {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        list = null;
        msg = null;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByEncarte");
        param.put("pag_paginaT.enc_nr_id", pagT.getEnc_nr_id() + "");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
    }


    public void inserir(Pag_paginaTGWT pag_paginaT) {
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
        param.put("pag_paginaT.enc_nr_id", pag_paginaT.getEnc_nr_id() + "");

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Pag_paginaTGWT pag_paginaT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("pag_pagina").isObject();
                    Pag_paginaDAOGWT.this.pag_paginaT = lerRegistroJson(registro);
                }
            }
        };
        this.pag_paginaT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("pag_paginaT.pag_nr_id", pag_paginaT.getPag_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }

    public void excluir(Pag_paginaTGWT pag_paginaT) {
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
        param.put("pag_paginaT.pag_nr_id", pag_paginaT.getPag_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Pag_paginaTGWT pag_paginaT) {
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
        param.put("pag_paginaT.pag_nr_id", pag_paginaT.getPag_nr_id() + "");
        param.put("pag_paginaT.enc_nr_id", pag_paginaT.getEnc_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Pag_paginaTGWT> lista = new ListStore<Pag_paginaTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Pag_paginaTGWT pag_paginaT = lerRegistroJson(registro);
                lista.add(pag_paginaT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */
    private Pag_paginaTGWT lerRegistroJson(JSONObject registro) {
        Pag_paginaTGWT pag_paginaTGWT = new Pag_paginaTGWT();
        Integer pag_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("pag_nr_id").toString()));
        pag_paginaTGWT.setPag_nr_id(pag_nr_id);

        Integer enc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("enc_nr_id").toString()));
        pag_paginaTGWT.setEnc_nr_id(enc_nr_id);

        String pag_tx_nome = registro.get("pag_tx_nome").isString().stringValue();
        pag_paginaTGWT.setPag_tx_nome(pag_tx_nome);

        return pag_paginaTGWT;
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
     * @return the pag_paginaT
     */
    public Pag_paginaTGWT getPag_paginaT() {
        return pag_paginaT;
    }

    /**
     * @param pag_paginaTGWT the pag_paginaTGWT to set
     */
    public void setPag_paginaTGWT(Pag_paginaTGWT pag_paginaT) {
        this.pag_paginaT = pag_paginaT;
    }
}
