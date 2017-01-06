/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.easynet.bo;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.transfer.Cls_classificacao_seloTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Pro_produtoTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Sel_seloTGWT;
import com.google.gwt.json.client.JSONValue;


import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Sel_selosConsult implements IListenetResponse {

    public static final String PAGE = "i9im/i9im/sel_selo/sel_seloConsultGWT.jsp";
    private ListStore<Sel_seloTGWT> store;
    private String tipo;
    private String nomeArquivo="";

    public Sel_selosConsult() {

    }

    public void load() {
        try {
            Window.alert("Load");
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("tipo", tipo);
            param.put("op", "consult");
            param.put("sel_seloT.sel_tx_nome", nomeArquivo);
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);//"portalgwt/exemplos/gridexemplo.jsp");
        } catch (Exception e) {
        }
    }

    public void loadSelosProduto(Pro_produtoTGWT proT, Cls_classificacao_seloTGWT clsT) {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consultSelosProduto");
            param.put("pro_produtoT.pro_nr_id","" + proT.getPro_nr_id());
            param.put("cls_classificacao_seloT.cls_nr_id","" + clsT.getCls_nr_id());
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);//"portalgwt/exemplos/gridexemplo.jsp");
        } catch (Exception e) {
        }
    }

    public void loadSelosNaoProduto(String selTxNome, Pro_produtoTGWT proT,Cls_classificacao_seloTGWT clsT) {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consultSelosNaoProduto");
            param.put("pro_produtoT.pro_nr_id","" + proT.getPro_nr_id());
            param.put("cls_classificacao_seloT.cls_nr_id","" + clsT.getCls_nr_id());
            param.put("sel_seloT.sel_tx_nome",selTxNome);
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);//"portalgwt/exemplos/gridexemplo.jsp");
        } catch (Exception e) {
        }
    }


    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(jsonValue + "");
            JSONArray resultado = jsonObject.get("resultado").isArray();
            setStore(new ListStore<Sel_seloTGWT>());
            for (int i = 1; i < resultado.size(); i++) {
                Sel_seloTGWT sel_seloTGWT = new Sel_seloTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer sel_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("sel_nr_id").toString()));
                sel_seloTGWT.setSel_nr_id(sel_nr_id);

                Integer cls_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cls_nr_id").toString()));
                sel_seloTGWT.setCls_nr_id(cls_nr_id);

                Integer tid_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("tid_nr_id").toString()));
                sel_seloTGWT.setTid_nr_id(tid_nr_id);

                String sel_tx_nome = EasyContainer.clearAspas(registro.get("sel_tx_nome").toString());
                sel_seloTGWT.setSel_tx_nome(sel_tx_nome);

                String sel_tx_descricao = EasyContainer.clearAspas(registro.get("sel_tx_descricao").toString());
                sel_seloTGWT.setSel_tx_descricao(sel_tx_descricao);

                DateTimeFormat dtf5 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date sel_dt_cadastro = dtf5.parse(EasyContainer.clearAspas(registro.get("sel_dt_cadastro").toString()));
                sel_seloTGWT.setSel_dt_cadastro(sel_dt_cadastro);

                String sel_tx_situacao = EasyContainer.clearAspas(registro.get("sel_tx_situacao").toString());
                sel_seloTGWT.setSel_tx_situacao(sel_tx_situacao);


                DateTimeFormat dtf8 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date sel_dt_validadeinicio = dtf8.parse(EasyContainer.clearAspas(registro.get("sel_dt_validadeinicio").toString()));
                sel_seloTGWT.setSel_dt_validadeinicio(sel_dt_validadeinicio);

                DateTimeFormat dtf9 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date sel_dt_validadefim = dtf9.parse(EasyContainer.clearAspas(registro.get("sel_dt_validadefim").toString()));
                sel_seloTGWT.setSel_dt_validadefim(sel_dt_validadefim);

                String sel_tx_promocional = EasyContainer.clearAspas(registro.get("sel_tx_promocional").toString());
                sel_seloTGWT.setSel_tx_promocional(sel_tx_promocional);


                getStore().add(sel_seloTGWT);
            }
        }
    }

    /**
     * @return the store
     */
    public ListStore<Sel_seloTGWT> getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(ListStore<Sel_seloTGWT> store) {
        this.store = store;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the nomeArquivo
     */
    public String getNomeArquivo() {
        return nomeArquivo;
    }

    /**
     * @param nomeArquivo the nomeArquivo to set
     */
    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
}

