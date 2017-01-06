/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.easynet.bo;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.transfer.Arq_arquivoTGWT;
import com.google.gwt.json.client.JSONValue;


import com.extjs.gxt.ui.client.store.ListStore;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import java.util.Date;
import java.util.HashMap;


/**
 *
 * @author geoleite
 */
public class Arq_arquivoConsultGWT implements IListenetResponse {

//    public static final String PAGE = "i9im/public/arq_arquivo/arq_arquivoConsultGWT.jsp";
    public static final String PAGE = "i9im/i9im/arq_arquivo/arq_arquivoConsultGWT.jsp";
    private ListStore<Arq_arquivoTGWT> store;

    public Arq_arquivoConsultGWT() {
/*        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSon(Constantes.URL + PAGE);//"portalgwt/exemplos/gridexemplo.jsp");
        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }
 */
    }

    /**
     * Carrega as imagens para exibicao
     * @param claNrId
     * @param imagemPromocional
     */
    public void load(String claNrId, String proNrId, String tipoImagem) {
        try {
           
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("arq_arquivoT.cla_nr_id", claNrId);
            param.put("arq_arquivoT.pro_nr_id", proNrId);
            param.put("tipoImagem", tipoImagem);
            param.put("op", "consultPorClassificacao");

            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);//"portalgwt/exemplos/gridexemplo.jsp");
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(jsonValue + "");
            JSONArray resultado = jsonObject.get("resultado").isArray();

            setStore(new ListStore<Arq_arquivoTGWT>());
            for (int i = 1; i < resultado.size(); i++) {
                Arq_arquivoTGWT arq_arquivoTGWT = new Arq_arquivoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer cd_produto = Integer.parseInt(EasyContainer.clearAspas(registro.get("pro_nr_id").toString()));
                arq_arquivoTGWT.setPro_nr_id(cd_produto);

                Integer arq_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("arq_nr_id").toString()));
                arq_arquivoTGWT.setArq_nr_id(arq_nr_id);

                Integer cd_tipoimagem = Integer.parseInt(EasyContainer.clearAspas(registro.get("cla_nr_id").toString()));
                arq_arquivoTGWT.setCla_nr_id(cd_tipoimagem);

                Integer cd_tipodocumento = Integer.parseInt(EasyContainer.clearAspas(registro.get("tid_nr_id").toString()));
                arq_arquivoTGWT.setTid_nr_id(cd_tipodocumento);

                String arq_tx_nome = EasyContainer.clearAspas(registro.get("arq_tx_nome").toString());
                arq_arquivoTGWT.setArq_tx_nome(arq_tx_nome);

                String arq_tx_descricao = EasyContainer.clearAspas(registro.get("arq_tx_descricao").toString());
                arq_arquivoTGWT.setArq_tx_descricao(arq_tx_descricao);

                DateTimeFormat dtf6 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date arq_dt_cadastro = dtf6.parse(EasyContainer.clearAspas(registro.get("arq_dt_cadastro").toString()));
                arq_arquivoTGWT.setArq_dt_cadastro(arq_dt_cadastro);

                String arq_tx_situacao = EasyContainer.clearAspas(registro.get("arq_tx_situacao").toString());
                arq_arquivoTGWT.setArq_tx_situacao(arq_tx_situacao);

                //DateTimeFormat dtf9 = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
                DateTimeFormat dtf9 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date arq_dt_validadeinicio = dtf9.parse(EasyContainer.clearAspas(registro.get("arq_dt_validadeinicio").toString()));
                arq_arquivoTGWT.setArq_dt_validadeinicio(arq_dt_validadeinicio);

                //DateTimeFormat dtf10 = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
                DateTimeFormat dtf10 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date arq_dt_validadefim = dtf10.parse(EasyContainer.clearAspas(registro.get("arq_dt_validadefim").toString()));
                arq_arquivoTGWT.setArq_dt_validadefim(arq_dt_validadefim);

                String arq_tx_promocional = EasyContainer.clearAspas(registro.get("arq_tx_promocional").toString());
                arq_arquivoTGWT.setArq_tx_promocional(arq_tx_promocional);


                getStore().add(arq_arquivoTGWT);
                //Info.display("Debug", arq_arquivoTGWT.getArq_tx_nome());
            }


        }
    }

    /**
     * @return the store
     */
    public ListStore<Arq_arquivoTGWT> getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(ListStore<Arq_arquivoTGWT> store) {
        this.store = store;
    }
}

