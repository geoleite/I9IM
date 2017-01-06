package br.com.i9.imagemanager.gwt.client.dao;
import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.transfer.Tic_tipo_correcaoTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

import java.util.*;

public class Tic_tipo_correcaoDAOGWT implements IListenetResponse {
    public static final String PAGE_INSERIR = "i9im/i9im/tic_tipo_correcao/tic_tipo_correcaoInsertGWT.jsp";
    public static final String PAGE_CONSULTAR = "i9im/i9im/tic_tipo_correcao/tic_tipo_correcaoConsultGWT.jsp";
    public static final String PAGE_ALTERAR_EXCLUIR = "i9im/i9im/tic_tipo_correcao/tic_tipo_correcaoUpdateDeleteGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;	
    private ListStore list;
    private Tic_tipo_correcaoTGWT tic_tipo_correcaoT;	
    public void consultarTodos() {        
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void inserir(Tic_tipo_correcaoTGWT tic_tipo_correcaoT) {
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
	param.put("tic_tipo_correcaoT.tic_tx_nome" , tic_tipo_correcaoT.getTic_tx_nome());

        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void pesquisar(Tic_tipo_correcaoTGWT tic_tipo_correcaoT) {
        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
                JSONObject jsonObject;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

                    JSONObject result = jsonObject.get("resultado").isObject();
                    msg = result.get("msg").isString().stringValue();
                    JSONObject registro = result.get("tic_tipo_correcao").isObject();
                    Tic_tipo_correcaoDAOGWT.this.tic_tipo_correcaoT = lerRegistroJson(registro);
                }
            }
        };
	this.tic_tipo_correcaoT = null;
        list = null;
        msg = null;
        String url = Constantes.URL + PAGE_ALTERAR_EXCLUIR;
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "findbyid");
        param.put("tic_tipo_correcaoT.tic_nr_id" , tic_tipo_correcaoT.getTic_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);

    }
    public void excluir(Tic_tipo_correcaoTGWT tic_tipo_correcaoT) {
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
        param.put("tic_tipo_correcaoT.tic_nr_id" , tic_tipo_correcaoT.getTic_nr_id() + "");


        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }

    public void alterar(Tic_tipo_correcaoTGWT tic_tipo_correcaoT) {
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
	param.put("tic_tipo_correcaoT.tic_nr_id" , tic_tipo_correcaoT.getTic_nr_id() + "");
param.put("tic_tipo_correcaoT.tic_tx_nome" , tic_tipo_correcaoT.getTic_tx_nome());

        
        EasyAccessURL eaurl = new EasyAccessURL(listener);
        eaurl.accessJSonMap(url, param);
    }
    
    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Tic_tipo_correcaoTGWT> lista = new ListStore<Tic_tipo_correcaoTGWT>();            

            for (int i = 1; i < resultado.size(); i++) {		
                JSONObject registro = resultado.get(i).isObject();
	        Tic_tipo_correcaoTGWT tic_tipo_correcaoT = lerRegistroJson(registro);
                lista.add(tic_tipo_correcaoT);            
            }
	    list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json 
     */	
    private Tic_tipo_correcaoTGWT lerRegistroJson(JSONObject registro) {
	Tic_tipo_correcaoTGWT tic_tipo_correcaoTGWT = new Tic_tipo_correcaoTGWT();
	                Integer tic_nr_id=Integer.parseInt(EasyContainer.clearAspas(registro.get("tic_nr_id").toString()));
                tic_tipo_correcaoTGWT.setTic_nr_id(tic_nr_id);

                String tic_tx_nome=EasyContainer.clearAspas(registro.get("tic_tx_nome").toString());
                tic_tipo_correcaoTGWT.setTic_tx_nome(tic_tx_nome);


	return tic_tipo_correcaoTGWT;
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
     * @return the tic_tipo_correcaoT
     */
    public Tic_tipo_correcaoTGWT getTic_tipo_correcaoT() {
        return tic_tipo_correcaoT;
    }

    /**
     * @param tic_tipo_correcaoTGWT the tic_tipo_correcaoTGWT to set
     */
    public void setTic_tipo_correcaoTGWT(Tic_tipo_correcaoTGWT tic_tipo_correcaoT) {
        this.tic_tipo_correcaoT = tic_tipo_correcaoT;
    }
}
