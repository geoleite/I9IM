/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.easynet.bo;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.transfer.Pro_produtoTGWT;
import com.google.gwt.json.client.JSONValue;


import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.VerticalPanel;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Pro_produtoConsultGWT extends VerticalPanel implements IListenetResponse {

    public static final String PAGE = "i9im/i9im/pro_produto/pro_produtoConsultGWT.jsp";
    private ListStore<Pro_produtoTGWT> store;
    private int count;
    private int idSetor;

    public Pro_produtoConsultGWT() {
    }

    public void consultarDescricao(int idSetor, String descricao) {
        try {
            setStore(null);
            setIdSetor(idSetor);

            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consultDescricao");
            param.put("pro_produtoT.pro_tx_nome", descricao);
            param.put("pro_produtoT.set_nr_id", "" + idSetor);
            //param.put("pro_produtoT.gru_nr_id", "" + idGrupo);


            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception ex) {
        }
    }

    public void consultarDescricaoCodigo(String texto) {
        try {
            setStore(null);
            setTitle(texto);
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consultDescricaoCodigo");
            param.put("pro_produtoT.pro_tx_nome", texto);

            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception ex) {
        }
    }

    public void consultarDescricaoCodigoImagem(String texto) {
        try {
            setStore(null);
            setTitle(texto);
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consultDescricaoCodigoImagem");
            param.put("pro_produtoT.pro_tx_nome", texto);

            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception ex) {
        }
    }

    public void consultarDescricaoCodigoSemImagem(String texto) {
        setStore(null);
        setTitle(texto);
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultDescricaoCodigoSemImagem");
        param.put("pro_produtoT.pro_tx_nome", texto);

        eaurl.accessJSonMap(Constantes.URL + PAGE, param);
    }

    public void consultarSessaoGrupo(int idSetor) {
        setStore(null);
        setIdSetor(idSetor);
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consult");
        param.put("pro_produtoT.set_nr_id", "" + idSetor);
        eaurl.accessJSonMap(Constantes.URL + PAGE, param);
    }

    public void consultarSessaoGrupoImagem(int idSetor) {
        setStore(null);
        setIdSetor(idSetor);
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultImagem");
        param.put("pro_produtoT.set_nr_id", "" + idSetor);
        eaurl.accessJSonMap(Constantes.URL + PAGE, param);
    }

    public void consultarSessaoGrupoSemImagem(int idSetor) {
        try {
            setStore(null);
            setIdSetor(idSetor);
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consultSemImagem");
            param.put("pro_produtoT.set_nr_id", "" + idSetor);
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception ex) {
        }
    }

    public void consultarEvento(int idEvento, boolean excel) {
        try {
            setStore(null);
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consultProdutosEvento");
            param.put("eve_eventoT.eve_nr_id", "" + idEvento);
            if (excel) {
                param.put("excel", "true");
            }

            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception ex) {
        }
    }

    public void consultarSelo(int idSelo) {
        try {
            setStore(null);
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consultProdutosSelo");
            param.put("sel_seloT.sel_nr_id", "" + idSelo);


            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception ex) {
        }
    }

    public void consultarNaoSeloDescricao(int idSelo, String desc) {
        try {
            setStore(null);
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consultProdutosNaoSeloDescricao");
            param.put("sel_seloT.sel_nr_id", "" + idSelo);
            param.put("pro_produtoT.pro_tx_nome", desc);

            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception ex) {
        }
    }

    public void consultarEventoProdutosSemImagemBruta(int idEvento, boolean excel) {
        try {
            setStore(null);
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consultProdutosSemImagemBrutaEvento");
            param.put("eve_eventoT.eve_nr_id", "" + idEvento);
            if (excel) {
                param.put("excel", "true");
            }


            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception ex) {
        }
    }

    public void consultarEventoProdutosSemImagemTratada(int idEvento, boolean excel) {
        try {
            setStore(null);
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consultProdutosSemImagemTratadaEvento");
            param.put("eve_eventoT.eve_nr_id", "" + idEvento);
            if (excel) {
                param.put("excel", "true");
            }
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception ex) {
        }
    }

    public void consultarEventoProdutosComImagemTratada(int idEvento, boolean excel) {
        try {
            setStore(null);
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consultProdutosComImagemTratadaEvento");
            param.put("eve_eventoT.eve_nr_id", "" + idEvento);
            if (excel) {
                param.put("excel", "true");
            }
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception ex) {
        }
    }

    public void consultarEventoProdutosSemImagemWeb(int idEvento, boolean excel) {
        try {
            setStore(null);
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consultProdutosSemImagemWebEvento");
            param.put("eve_eventoT.eve_nr_id", "" + idEvento);
            if (excel) {
                param.put("excel", "true");
            }


            eaurl.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

            JSONArray resultado = jsonObject.get("resultado").isArray();

            setStore(new ListStore<Pro_produtoTGWT>());
            JSONObject regCount = resultado.get(0).isObject();
            count = Integer.parseInt(EasyContainer.clearAspas(regCount.get("registro").toString()));
            for (int i = 1; i < resultado.size(); i++) {
                Pro_produtoTGWT pro_produtoTGWT = new Pro_produtoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer pro_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("pro_nr_id").toString()));
                pro_produtoTGWT.setPro_nr_id(pro_nr_id);

                String pro_tx_nome = EasyContainer.clearAspas(registro.get("pro_tx_nome").toString());
                pro_produtoTGWT.setPro_tx_nome(pro_tx_nome);

                Integer pro_nr_cdfamilia = Integer.parseInt(EasyContainer.clearAspas(registro.get("pro_nr_cdfamilia").toString()));
                pro_produtoTGWT.setPro_nr_cdfamilia(pro_nr_cdfamilia);

                DateTimeFormat dtf3 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date pro_dt_atualizacao = dtf3.parse(EasyContainer.clearAspas(registro.get("pro_dt_atualizacao").toString()));
                pro_produtoTGWT.setPro_dt_atualizacao(pro_dt_atualizacao);

                float pro_nr_valor = Float.parseFloat(EasyContainer.clearAspas(registro.get("pro_nr_valor").toString()));
                pro_produtoTGWT.setPro_nr_valor(pro_nr_valor);

                String pro_tx_situacao = EasyContainer.clearAspas(registro.get("pro_tx_situacao").toString());
                pro_produtoTGWT.setPro_tx_situacao(pro_tx_situacao);

                Integer set_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("set_nr_id").toString()));
                pro_produtoTGWT.setSet_nr_id(set_nr_id);


                String pro_tx_obs = EasyContainer.clearAspas(registro.get("pro_tx_obs").toString());
                pro_produtoTGWT.setPro_tx_obs(pro_tx_obs);

                String pro_tx_idsap = EasyContainer.clearAspas(registro.get("pro_tx_idsap").toString());
                pro_produtoTGWT.setPro_tx_idsap(pro_tx_idsap);

                getStore().add(pro_produtoTGWT);
            }
        }
    }

    /**
     * @return the store
     */
    public ListStore<Pro_produtoTGWT> getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(ListStore<Pro_produtoTGWT> store) {
        this.store = store;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the idSetor
     */
    public int getIdSetor() {
        return idSetor;
    }

    /**
     * @param idSetor the idSetor to set
     */
    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }
}
