/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.enc_encarte;

import br.com.easynet.gwt.client.CPConsultarBaseGWT;


import br.com.i9.imagemanager.gwt.client.dao.Enc_encarteDAOGWT;
import br.com.i9.imagemanager.gwt.client.easynet.upload.UploadMutiplosPaginasGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Enc_encarteTGWT;

import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.store.ListStore;
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
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Enc_encarteConsultGWT extends CPConsultarBaseGWT {

    private ContentPanel cp = new ContentPanel();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Enc_encarteDAOGWT enc_encarteDao = new Enc_encarteDAOGWT();

    public Enc_encarteConsultGWT() {
        setBorders(false);
        setHeaderVisible(false);
        setWidth("100%");
        final NumberFormat currency = NumberFormat.getCurrencyFormat();
        final NumberFormat number = NumberFormat.getFormat("0.00");
        final NumberCellRenderer<Grid<Enc_encarteTGWT>> numberRenderer = new NumberCellRenderer<Grid<Enc_encarteTGWT>>(currency);
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
        column.setId("enc_tx_nome");
        column.setHeader("Nome");
        column.setWidth(300);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("enc_dt_limite");
        column.setHeader("Data/Hora");
        column.setWidth(200);
        column.setDateTimeFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgEditar");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getEditarRender());
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgPáginas");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getPaginaRender());
        configs.add(column);

        column = new ColumnConfig();
        column.setId("imgCorregir");
        column.setWidth(30);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getCorrigirRender());
        configs.add(column);

        load();

    }

    public void btnNovoAction(ButtonEvent be) {
        Enc_encarteInsertGWT enc_encarteInsertGWT = new Enc_encarteInsertGWT();
        enc_encarteInsertGWT.setEnc_encarteConsult(this);
        enc_encarteInsertGWT.setModal(true);
        enc_encarteInsertGWT.show();

    }

    private GridCellRenderer<Enc_encarteTGWT> getCorrigirRender() {
        return new GridCellRenderer<Enc_encarteTGWT>() {

            public Object render(final Enc_encarteTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Enc_encarteTGWT> store, Grid<Enc_encarteTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Enc_encarteCorrecaoGWT enc_encarteCorrecaoGWT = new Enc_encarteCorrecaoGWT();
                        enc_encarteCorrecaoGWT.setEnc_encarteTGWT(model);
                        enc_encarteCorrecaoGWT.show();

//                        Enc_encarteUpdateDeleteGWT enc_encarteUpdateDeleteGWT = new Enc_encarteUpdateDeleteGWT();
//                        enc_encarteUpdateDeleteGWT.setEnc_encarteConsult(Enc_encarteConsultGWT.this);
//                        enc_encarteUpdateDeleteGWT.load(model);
//                        enc_encarteUpdateDeleteGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Corrigir Encarte.");
                b.setIcon(ICONS.aplicar());

                return b;
            }
        };
    }

    private GridCellRenderer<Enc_encarteTGWT> getEditarRender() {
        return new GridCellRenderer<Enc_encarteTGWT>() {

            public Object render(final Enc_encarteTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Enc_encarteTGWT> store, Grid<Enc_encarteTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        Enc_encarteUpdateDeleteGWT enc_encarteUpdateDeleteGWT = new Enc_encarteUpdateDeleteGWT();
                        enc_encarteUpdateDeleteGWT.setEnc_encarteConsult(Enc_encarteConsultGWT.this);
                        enc_encarteUpdateDeleteGWT.load(model);
                        enc_encarteUpdateDeleteGWT.show();
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Alterar dados.");
                b.setIcon(ICONS.edit());

                return b;
            }
        };
    }

    private GridCellRenderer<Enc_encarteTGWT> getPaginaRender() {
        return new GridCellRenderer<Enc_encarteTGWT>() {

            public Object render(final Enc_encarteTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Enc_encarteTGWT> store, Grid<Enc_encarteTGWT> grid) {

                Button b = new Button();
                b.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        UploadMutiplosPaginasGWT uploadMutiplosPaginasGWT = new UploadMutiplosPaginasGWT();
                        uploadMutiplosPaginasGWT.setEnc_encarteTGWT(model);
                        uploadMutiplosPaginasGWT.setVisible(true);
                    }
                });

                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Inserir páginas para o encarte.");
                b.setIcon(ICONS.add());

                return b;
            }
        };
    }

    public void load() {
        enc_encarteDao.consultarTodos();
        Timer timer = new Timer() {

            public void run() {
                ListStore<Enc_encarteTGWT> list = enc_encarteDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    List lista = getCpMaster().getItems();
                    if (lista.size() > 0) {
                        getCpMaster().removeAll();
                    }

                    ColumnModel cm = new ColumnModel(configs);

                    Grid<Enc_encarteTGWT> grid = new Grid<Enc_encarteTGWT>(list, cm);
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
