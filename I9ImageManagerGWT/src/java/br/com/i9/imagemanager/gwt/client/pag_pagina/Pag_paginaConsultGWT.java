/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.pag_pagina;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;


import br.com.easynet.gwt.client.ConsultarBaseGWT;
import br.com.i9.imagemanager.gwt.client.dao.Pag_paginaDAOGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Pag_paginaTGWT;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import java.util.Date;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Pag_paginaConsultGWT extends ConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Pag_paginaDAOGWT pag_paginaDao = new Pag_paginaDAOGWT();

    public Pag_paginaConsultGWT() {

        this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Pag_paginaTGWT>> numberRenderer = new NumberCellRenderer<Grid<Pag_paginaTGWT>>(currency);
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
        column.setId("pag_nr_id");
        column.setHeader("Pag_nr_id");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("enc_nr_id");
        column.setHeader("Enc_nr_id");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("pag_bt_arquivo");
        column.setHeader("Pag_bt_arquivo");
        column.setWidth(200);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);



        column = new ColumnConfig();
        column.setId("imgEditar");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);

        load();

    }

    public void btnNovoAction(ButtonEvent be) {
        Pag_paginaInsertGWT pag_paginaInsertGWT = new Pag_paginaInsertGWT();
        pag_paginaInsertGWT.setPag_paginaConsult(this);
        pag_paginaInsertGWT.setModal(true);
        pag_paginaInsertGWT.show();

    }

    private GridCellRenderer<Pag_paginaTGWT> getEditarRender() {
        return new GridCellRenderer<Pag_paginaTGWT>() {

            public Object render(final Pag_paginaTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Pag_paginaTGWT> store, Grid<Pag_paginaTGWT> grid) {


                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Pag_paginaUpdateDeleteGWT pag_paginaUpdateDeleteGWT = new Pag_paginaUpdateDeleteGWT();
                        pag_paginaUpdateDeleteGWT.setPag_paginaConsult(Pag_paginaConsultGWT.this);
                        pag_paginaUpdateDeleteGWT.load(model);
                        pag_paginaUpdateDeleteGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar dados.");
                b.setIcon(ICONS.edit());

                return b;
            }
        };
    }

    public void load() {
        pag_paginaDao.consultarTodos();
        Timer timer = new Timer() {

            public void run() {
                ListStore<Pag_paginaTGWT> list = pag_paginaDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configs);

                    Grid<Pag_paginaTGWT> grid = new Grid<Pag_paginaTGWT>(list, cm);
                    grid.setLoadMask(true);

                    grid.setStyleAttribute("borderTop", "none");
                    grid.setBorders(true);
                    grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                    getCpMaster().add(grid);
                    getCpMaster().layout();
                }
            }
        };
        timer.schedule(500);
    }
}
