/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.easynet.bo;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.transfer.Cla_classificacaoTGWT;
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
public class Cla_classificacaoConsultGWT implements IListenetResponse {

    public static final String PAGE = "i9im/i9im/cla_classificacao/cla_classificacaoConsultGWT.jsp";
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private ListStore<Cla_classificacaoTGWT> store;

    public Cla_classificacaoConsultGWT() {
        try {

            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSon(Constantes.URL + PAGE);//"portalgwt/exemplos/gridexemplo.jsp");
        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }

    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            
            JSONArray resultado = jsonObject.get("resultado").isArray();

            store = new ListStore<Cla_classificacaoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Cla_classificacaoTGWT cla_classificacaoTGWT = new Cla_classificacaoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer cla_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cla_nr_id").toString()));
                cla_classificacaoTGWT.setCla_nr_id(cla_nr_id);

                String cla_tx_tipo = EasyContainer.clearAspas(registro.get("cla_tx_tipo").toString());
                cla_classificacaoTGWT.setCla_tx_tipo(cla_tx_tipo);


                store.add(cla_classificacaoTGWT);
            }


        }
    }

    /**
     * @return the store
     */
    public ListStore<Cla_classificacaoTGWT> getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(ListStore<Cla_classificacaoTGWT> store) {
        this.store = store;
    }
}

