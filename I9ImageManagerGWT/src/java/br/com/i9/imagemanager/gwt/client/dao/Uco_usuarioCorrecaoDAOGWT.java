/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.imagemanager.gwt.client.dao;
import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.transfer.Cor_correcaoTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Usu_usuarioTGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Uco_usuarioCorrecaoDAOGWT implements IListenetResponse{
    public static final String PAGE_CONSULTAR = "i9im/i9im/cor_correcao/uco_usuarioCorrecaoConsultGWT.jsp";
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
    private String msg;
    private ListStore<Usu_usuarioTGWT> list;

    public void consultarTodos() {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        eaurl.accessJSon(Constantes.URL + PAGE_CONSULTAR);
        list = null;
        msg = null;
    }

    public void consultUsuariosByPagina(Cor_correcaoTGWT corT) {
        list = null;
        msg = null;
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultByPagina");
        param.put("cor_correcaoT.pag_nr_id", corT.getPag_nr_id() + "");
        eaurl.accessJSonMap(Constantes.URL + PAGE_CONSULTAR, param);
    }



    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Usu_usuarioTGWT> lista = new ListStore<Usu_usuarioTGWT>();

            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Usu_usuarioTGWT usu_usuarioTGWT = lerRegistroJson(registro);
                lista.add(usu_usuarioTGWT);
            }
            list = lista;
        }
    }

    /**
     * Ler os dados o conte�do json
     */
    private Usu_usuarioTGWT lerRegistroJson(JSONObject registro) {
        Usu_usuarioTGWT usu_usuarioTGWT = new Usu_usuarioTGWT();
        Integer usu_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("usu_nr_id").toString()));
        usu_usuarioTGWT.setUsu_nr_id(usu_nr_id);

        String usu_tx_nome = (EasyContainer.clearAspas(registro.get("usu_tx_nome").toString()));
        usu_usuarioTGWT.setUsu_tx_nome(usu_tx_nome);

        String usu_tx_login = EasyContainer.clearAspas(registro.get("usu_tx_login").toString());
        usu_usuarioTGWT.setUsu_tx_login(usu_tx_login);

        String usu_tx_status = EasyContainer.clearAspas(registro.get("usu_tx_status").toString());
        usu_usuarioTGWT.setUsu_tx_status(usu_tx_status);

        String usu_tx_email = EasyContainer.clearAspas(registro.get("usu_tx_email").toString());
        usu_usuarioTGWT.setUsu_tx_email(usu_tx_email);

        return usu_usuarioTGWT;
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

}
