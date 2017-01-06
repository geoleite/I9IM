/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.easynet.bo;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.transfer.Cls_classificacao_seloTGWT;
import com.google.gwt.json.client.JSONValue;
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
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;

/**
 *
 * @author geoleite
 */
public class Cls_classificacao_seloConsultGWT  implements IListenetResponse {

    public static final String PAGE = "i9im/i9im/cls_classificacao_selo/cls_classificacao_seloConsultGWT.jsp";
    private ListStore<Cls_classificacao_seloTGWT> store;

    public Cls_classificacao_seloConsultGWT() {
        try {
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Cls_classificacao_seloTGWT>> numberRenderer = new NumberCellRenderer<Grid<Cls_classificacao_seloTGWT>>(currency);
            /*
            GridCellRenderer<Stock> change = new GridCellRenderer<Stock>() {
            public String render(Stock model, String property, ColumnData config, int rowIndex,
            int colIndex, ListStore<Stock> store) {
            double val = (Double) model.get(property);
            String style = val < 0 ? "red" : "green";
            return "<span style='color:" + style + "'>" + number.format(val) + "</span>";
            }
            };
            GridCellRenderer<Stock> gridNumber = new GridCellRenderer<Stock>() {
            public String render(Stock model, String property, ColumnData config, int rowIndex,
            int colIndex, ListStore<Stock> store) {
            return numberRenderer.render(null, property, model.get(property));
            }
            };
             */
            load();
        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }

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

            setStore(new ListStore<Cls_classificacao_seloTGWT>());
            for (int i = 1; i < resultado.size(); i++) {
                Cls_classificacao_seloTGWT cls_classificacao_seloTGWT = new Cls_classificacao_seloTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer cls_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("cls_nr_id").toString()));
                cls_classificacao_seloTGWT.setCls_nr_id(cls_nr_id);

                String cls_tx_tipo = EasyContainer.clearAspas(registro.get("cls_tx_tipo").toString());
                cls_classificacao_seloTGWT.setCls_tx_tipo(cls_tx_tipo);


                getStore().add(cls_classificacao_seloTGWT);
            }



        }
    }

    /**
     * @return the store
     */
    public ListStore<Cls_classificacao_seloTGWT> getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(ListStore<Cls_classificacao_seloTGWT> store) {
        this.store = store;
    }
}

