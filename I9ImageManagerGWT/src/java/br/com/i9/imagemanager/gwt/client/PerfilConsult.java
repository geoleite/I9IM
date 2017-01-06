/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client;

import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.transfer.Arq_arquivoTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.PerfilUsuario;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

/**
 *
 * @author geoleite
 */
public class PerfilConsult implements IListenetResponse {

    public static final String PAGE = "portalgwt/perfisusuario.jsp";
    private ListStore<PerfilUsuario> store;

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(jsonValue + "");
            JSONArray resultado = jsonObject.get("resultado").isArray();

            setStore(new ListStore<PerfilUsuario>());
            for (int i = 1; i < resultado.size(); i++) {
                PerfilUsuario pu = new PerfilUsuario();
                Arq_arquivoTGWT arq_arquivoTGWT = new Arq_arquivoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                String perfil = EasyContainer.clearAspas(registro.get("arq_tx_nome").toString());
                pu.setPerfil(perfil);
                getStore().add(pu);
            }
        }
    }

    /**
     * @return the store
     */
    public ListStore<PerfilUsuario> getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(ListStore<PerfilUsuario> store) {
        this.store = store;
    }
}
