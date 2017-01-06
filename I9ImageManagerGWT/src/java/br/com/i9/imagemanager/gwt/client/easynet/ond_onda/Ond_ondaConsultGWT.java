/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.easynet.ond_onda;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.transfer.Eve_eventoTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Ond_ondaTGWT;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.google.gwt.json.client.JSONValue;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Ond_ondaConsultGWT extends Window implements IListenetResponse {

    public static final String PAGE = "i9im/i9im/ond_onda/ond_ondaConsultGWT.jsp";
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Eve_eventoTGWT eve_eventoTGWT;
    private int cont = 1, total=0;

    public Ond_ondaConsultGWT() {
        try {
            setLayout(new FillLayout());
            setHeading("Ondas do Evento:");
            setModal(true);
            this.setSize("300", "200");
            setResizable(false);
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Ond_ondaTGWT>> numberRenderer = new NumberCellRenderer<Grid<Ond_ondaTGWT>>(currency);
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



            ColumnConfig column = null;

            column = new ColumnConfig();
            column.setId("numeracao");
            column.setHeader("Num.");
            column.setWidth(50);
            column.setAlignment(HorizontalAlignment.LEFT);
            column.setRenderer(getNumeracaoRender());
            configs.add(column);


            column = new ColumnConfig();
            column.setId("ond_dt_criacao");
            column.setHeader("Data onda");
            column.setWidth(200);
            column.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy HH:mm"));
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

        } catch (Exception ex) {
        }
    }

    /**
     * Define uma sequencia das ondas
     * @return
     */
    private GridCellRenderer<Ond_ondaTGWT> getNumeracaoRender() {
        return new GridCellRenderer<Ond_ondaTGWT>() {

            public Object render(Ond_ondaTGWT model, String property,
                    ColumnData config, int rowIndex, int colIndex,
                    ListStore<Ond_ondaTGWT> store, Grid<Ond_ondaTGWT> grid) {

                String str = "<span style='color:red'>" + cont++ + "</span>";
                if (cont == total) {
                    cont = 1;
                }
                return str;
            }
        };
    }

    public void load() {
        try {
            setHeading("Ondas do Evento: " + eve_eventoTGWT.getEve_tx_nome());
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("ond_ondaT.eve_nr_id", ""+ eve_eventoTGWT.getEve_nr_id());
            eaurl.accessJSonMap(Constantes.URL + PAGE, param); //"portalgwt/exemplos/gridexemplo.jsp");
        } catch (Exception ex) {
        }

    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Ond_ondaTGWT> store = new ListStore<Ond_ondaTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Ond_ondaTGWT ond_ondaTGWT = new Ond_ondaTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer eve_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("eve_nr_id").toString()));
                ond_ondaTGWT.setEve_nr_id(eve_nr_id);

                Integer ond_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ond_nr_id").toString()));
                ond_ondaTGWT.setOnd_nr_id(ond_nr_id);

                DateTimeFormat dtf2 = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
                Date ond_dt_criacao = dtf2.parse(EasyContainer.clearAspas(registro.get("ond_dt_criacao").toString()));
                ond_ondaTGWT.setOnd_dt_criacao(ond_dt_criacao);
                store.add(ond_ondaTGWT);
            }
            total = resultado.size();


            ColumnModel cm = new ColumnModel(configs);

            Grid<Ond_ondaTGWT> grid = new Grid<Ond_ondaTGWT>(store, cm);
            grid.setLoadMask(true);

            grid.setStyleAttribute("borderTop", "none");
            grid.setBorders(true);

            add(grid);
            show();
            layout();
        }
    }

    /**
     * @return the eve_eventoTGWT
     */
    public Eve_eventoTGWT getEve_eventoTGWT() {
        return eve_eventoTGWT;
    }

    /**
     * @param eve_eventoTGWT the eve_eventoTGWT to set
     */
    public void setEve_eventoTGWT(Eve_eventoTGWT eve_eventoTGWT) {
        this.eve_eventoTGWT = eve_eventoTGWT;
    }
}

