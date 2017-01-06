/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.easynet.bo;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.transfer.Set_setorTGWT;
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
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
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
public class Set_setorConsultGWT implements IListenetResponse {

    public static final String PAGE = "i9im/i9im/set_setor/set_setorConsultGWT.jsp";
    private ListStore<Set_setorTGWT> store;

    public Set_setorConsultGWT() {
        
        load();
    }

    public void load() {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSon(Constantes.URL + PAGE);//"portalgwt/exemplos/gridexemplo.jsp");
        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONArray resultado = jsonObject.get("resultado").isArray();

            store = new ListStore<Set_setorTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Set_setorTGWT set_setorTGWT = new Set_setorTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer set_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("set_nr_id").toString()));
                set_setorTGWT.setSet_nr_id(set_nr_id);

                String set_tx_nome = EasyContainer.clearAspas(registro.get("set_tx_nome").toString());
                set_setorTGWT.setSet_tx_nome(set_tx_nome);

                store.add(set_setorTGWT);
            }
        }
    }

    /**
     * @return the store
     */
    public ListStore<Set_setorTGWT> getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(ListStore<Set_setorTGWT> store) {
        this.store = store;
    }
}

