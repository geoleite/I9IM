/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.tic_tipo_correcao;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;


import br.com.easynet.gwt.client.ConsultarBaseGWT;
import br.com.i9.imagemanager.gwt.client.dao.Tic_tipo_correcaoDAOGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Tic_tipo_correcaoTGWT;

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
public class Tic_tipo_correcaoConsultGWT extends ConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Tic_tipo_correcaoDAOGWT tic_tipo_correcaoDao = new Tic_tipo_correcaoDAOGWT();
    public Tic_tipo_correcaoConsultGWT() {
        
            this.setSize("500", "400");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Tic_tipo_correcaoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Tic_tipo_correcaoTGWT>>(currency);
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
            column.setId("tic_nr_id");
            column.setHeader("Tic_nr_id");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

	    column = new ColumnConfig();
            column.setId("tic_tx_nome");
            column.setHeader("Tic_tx_nome");
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
        Tic_tipo_correcaoInsertGWT tic_tipo_correcaoInsertGWT = new Tic_tipo_correcaoInsertGWT();
        tic_tipo_correcaoInsertGWT.setTic_tipo_correcaoConsult(this);
        tic_tipo_correcaoInsertGWT.setModal(true);
        tic_tipo_correcaoInsertGWT.show();

    }
    private GridCellRenderer<Tic_tipo_correcaoTGWT> getEditarRender() {
        return new GridCellRenderer<Tic_tipo_correcaoTGWT>() {

            private boolean init;

            public Object render(final Tic_tipo_correcaoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Tic_tipo_correcaoTGWT> store, Grid<Tic_tipo_correcaoTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Tic_tipo_correcaoTGWT>>() {

                        public void handleEvent(GridEvent<Tic_tipo_correcaoTGWT> be) {
                            for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {
                                if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null
                                        && be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {
                                    ((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10);
                                }
                            }
                        }
                    });
                }

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Tic_tipo_correcaoUpdateDeleteGWT tic_tipo_correcaoUpdateDeleteGWT = new Tic_tipo_correcaoUpdateDeleteGWT();
                        tic_tipo_correcaoUpdateDeleteGWT.setTic_tipo_correcaoConsult(Tic_tipo_correcaoConsultGWT.this);
                        tic_tipo_correcaoUpdateDeleteGWT.load(model);
                        tic_tipo_correcaoUpdateDeleteGWT.show();
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
    tic_tipo_correcaoDao.consultarTodos();
    Timer timer = new Timer() {
            public void run() {
                ListStore<Tic_tipo_correcaoTGWT> list = tic_tipo_correcaoDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configs);

                    Grid<Tic_tipo_correcaoTGWT> grid = new Grid<Tic_tipo_correcaoTGWT>(list, cm);
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

