/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.easynet.bo;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.transfer.Ses_sessaoTGWT;
import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import java.util.Date;

/**
 *
 * @author geoleite
 */
public class Ses_sessaoConsultGWT implements IListenetResponse {

    public static final String PAGE = "i9im/i9im/ses_sessao/ses_sessaoConsultGWT.jsp";
    private ListStore<Ses_sessaoTGWT> store;

    public Ses_sessaoConsultGWT() {
        load();
    }

    public void load() {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSon(Constantes.URL + PAGE);//"portalgwt/exemplos/gridexemplo.jsp");
        } catch (Exception ex) {

        }
    }

    /**
     * Ler os dados do servidor
     * @param jsonValue
     */
    public void read(JSONValue jsonValue) {

        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            JSONArray resultado = jsonObject.get("resultado").isArray();
            store = new ListStore<Ses_sessaoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Ses_sessaoTGWT ses_sessaoTGWT = new Ses_sessaoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer ses_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ses_nr_id").toString()));
                ses_sessaoTGWT.setSes_nr_id(ses_nr_id);
                Integer set_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("set_nr_id").toString()));
                ses_sessaoTGWT.setSet_nr_id(set_nr_id);

                String ses_tx_nome = EasyContainer.clearAspas(registro.get("ses_tx_nome").toString());
                ses_sessaoTGWT.setSes_tx_nome(ses_tx_nome);
                store.add(ses_sessaoTGWT);
            }
            
        }
    }

    /**
     * @return the store
     */
    public ListStore<Ses_sessaoTGWT> getStore() {
        return store;
    }
}

