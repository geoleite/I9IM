/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.easynet.pro_produto;

import br.com.i9.imagemanager.gwt.client.PrincipalGWT;
import br.com.i9.imagemanager.gwt.client.easynet.bo.Pro_produtoConsultGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Pro_produtoTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Sel_seloTGWT;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import java.util.Date;

/**
 *
 * @author geoleite
 */
public class ProdutosSeloGWT extends com.extjs.gxt.ui.client.widget.Window implements Listener<ButtonEvent>  {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Sel_seloTGWT sel_seloTGWT;
    private Button btnFechar = new Button("Fechar");

    public ProdutosSeloGWT() {
        try {
            setModal(true);
            setLayout(new FillLayout());
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Pro_produtoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Pro_produtoTGWT>>(currency);
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

            GridCellRenderer<Pro_produtoTGWT> dtRender = new GridCellRenderer<Pro_produtoTGWT>() {

                public Object render(Pro_produtoTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Pro_produtoTGWT> store, Grid<Pro_produtoTGWT> grid) {
                    Date dt = (Date) model.get(property);
                    return PrincipalGWT.DATE_FORMAT.format(dt);
                }
            };

            GridCellRenderer<Pro_produtoTGWT> situacaoRender = new GridCellRenderer<Pro_produtoTGWT>() {

                public Object render(Pro_produtoTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Pro_produtoTGWT> store, Grid<Pro_produtoTGWT> grid) {
                    if ("A".equals(model.get(property))) {
                        return "Ativo";
                    } else if ("I".equals(model.get(property))) {
                        return "Inativo";
                    } else if ("E".equals(model.get(property))) {
                        return "Excluido";
                    }
                    return model.get(property);
                }
            };

            ColumnConfig column = null;

            column = new ColumnConfig();
            column.setId("pro_nr_id");
            column.setHeader("Codigo");
            column.setWidth(100);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_tx_nome");
            column.setHeader("Nome");
            column.setWidth(300);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_dt_atualizacao");
            column.setHeader("Data Atualizacao.");
            column.setWidth(120);
            column.setRenderer(dtRender);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_tx_situacao");
            column.setHeader("Situacao");
            column.setWidth(100);
            column.setRenderer(situacaoRender);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            btnFechar.addListener(Events.OnClick, this);
            addButton(btnFechar);
        } catch (Exception ex) {
            Window.alert(ex.getMessage());
        }
    }

    public void load() {
        setHeading("Produtos com Selo " + sel_seloTGWT.getSel_tx_nome());
        final Pro_produtoConsultGWT proConsult = new Pro_produtoConsultGWT();
        proConsult.consultarSelo(sel_seloTGWT.getSel_nr_id());
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Pro_produtoTGWT> listPro = proConsult.getStore();
                if (listPro == null) {
                    schedule(500);
                } else {
                    exibir(listPro);
                    show();
                }
            }
        };
        timer.schedule(500);
    }


    public void exibir(ListStore<Pro_produtoTGWT> listPro) {


        setSize(660, 300);

        ColumnModel cm = new ColumnModel(configs);
        Grid<Pro_produtoTGWT> grid = new Grid<Pro_produtoTGWT>(listPro, cm);
        grid.setLoadMask(true);
        grid.setStyleAttribute("borderTop", "none");
        grid.setBorders(true);
        add(grid);
        layout();
    }

 
    public void handleEvent(ButtonEvent be) {
        setVisible(false);
    }

    /**
     * @return the sel_seloTGWT
     */
    public Sel_seloTGWT getSel_seloTGWT() {
        return sel_seloTGWT;
    }

    /**
     * @param sel_seloTGWT the sel_seloTGWT to set
     */
    public void setSel_seloTGWT(Sel_seloTGWT sel_seloTGWT) {
        this.sel_seloTGWT = sel_seloTGWT;
    }
}

