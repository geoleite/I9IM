/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.reg_regiao;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;
import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;


import br.com.easynet.gwt.client.ConsultarBaseGWT;
import br.com.i9.imagemanager.gwt.client.dao.Reg_regiaoDAOGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Reg_regiaoTGWT;

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
public class Reg_regiaoConsultGWT extends CPConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Reg_regiaoDAOGWT reg_regiaoDao = new Reg_regiaoDAOGWT();

    public Reg_regiaoConsultGWT() {
        setBorders(false);
        setHeaderVisible(false);

        //this.setSize("500", "400");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Reg_regiaoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Reg_regiaoTGWT>>(currency);
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
        column.setId("reg_tx_nome");
        column.setHeader("Nome");
        column.setWidth(300);
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
        Reg_regiaoInsertGWT reg_regiaoInsertGWT = new Reg_regiaoInsertGWT();
        reg_regiaoInsertGWT.setReg_regiaoConsult(this);
        reg_regiaoInsertGWT.setModal(true);
        reg_regiaoInsertGWT.show();

    }

    private GridCellRenderer<Reg_regiaoTGWT> getEditarRender() {
        return new GridCellRenderer<Reg_regiaoTGWT>() {

            public Object render(final Reg_regiaoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Reg_regiaoTGWT> store, Grid<Reg_regiaoTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Reg_regiaoUpdateDeleteGWT reg_regiaoUpdateDeleteGWT = new Reg_regiaoUpdateDeleteGWT();
                        reg_regiaoUpdateDeleteGWT.setReg_regiaoConsult(Reg_regiaoConsultGWT.this);
                        reg_regiaoUpdateDeleteGWT.load(model);
                        reg_regiaoUpdateDeleteGWT.show();
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
        reg_regiaoDao.consultarTodos();
        Timer timer = new Timer() {

            public void run() {
                ListStore<Reg_regiaoTGWT> list = reg_regiaoDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configs);

                    Grid<Reg_regiaoTGWT> grid = new Grid<Reg_regiaoTGWT>(list, cm);
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
