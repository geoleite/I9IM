/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.easynet.bo;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.transfer.Tid_tipodocumentoTGWT;
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
public class Tid_tipodocumentoConsultGWT extends VerticalPanel implements IListenetResponse {

    public static final String PAGE = "i9im/i9im/tid_tipodocumento/tid_tipodocumentoConsultGWT.jsp";
    private ListStore<Tid_tipodocumentoTGWT> store;

    public Tid_tipodocumentoConsultGWT() {
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
            //Window.alert(usuario);
            JSONArray resultado = jsonObject.get("resultado").isArray();

            setStore(new ListStore<Tid_tipodocumentoTGWT>());
            for (int i = 1; i < resultado.size(); i++) {
                Tid_tipodocumentoTGWT tid_tipodocumentoTGWT = new Tid_tipodocumentoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer tid_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("tid_nr_id").toString()));
                tid_tipodocumentoTGWT.setTid_nr_id(tid_nr_id);

                String tid_tx_sigla = EasyContainer.clearAspas(registro.get("tid_tx_sigla").toString());
                tid_tipodocumentoTGWT.setTid_tx_sigla(tid_tx_sigla);

                String tid_tx_descricao = EasyContainer.clearAspas(registro.get("tid_tx_descricao").toString());
                tid_tipodocumentoTGWT.setTid_tx_descricao(tid_tx_descricao);

                String tid_tx_reduzir = EasyContainer.clearAspas(registro.get("tid_tx_reduzir").toString());
                tid_tipodocumentoTGWT.setTid_tx_reduzir(tid_tx_reduzir);
                getStore().add(tid_tipodocumentoTGWT);
            }
        }
    }

    /**
     * @return the store
     */
    public ListStore<Tid_tipodocumentoTGWT> getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(ListStore<Tid_tipodocumentoTGWT> store) {
        this.store = store;
    }
}

