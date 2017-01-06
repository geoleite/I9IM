/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.imagemanager.gwt.client.easynet.bo;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author geoleite
 */
public class PerfilUsuarioConsult implements IListenetResponse {

    private static String PAGE="portalgwt/perfisusuario.jsp";
    private List<String> perfis;
    public void load() {
        try {
            EasyAccessURL access = new EasyAccessURL(this);
            access.accessJSon(Constantes.URL + PAGE);
        } catch (Exception e) {
        }
    }
    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONObject resultado = jsonObject.get("resultado").isObject();            
            JSONArray registros = resultado.get("perfis").isArray();
            perfis = new Vector<String>();
            for (int i = 1; i < registros.size(); i++) {
                JSONObject registro = registros.get(i).isObject();
                String nome = EasyContainer.clearAspas(registro.get("nome").toString());
                perfis.add(nome);
            }
        }
    }

    /**
     * @return the perfis
     */
    public List<String> getPerfis() {
        return perfis;
    }

    /**
     * @param perfis the perfis to set
     */
    public void setPerfis(List<String> perfis) {
        this.perfis = perfis;
    }

}
