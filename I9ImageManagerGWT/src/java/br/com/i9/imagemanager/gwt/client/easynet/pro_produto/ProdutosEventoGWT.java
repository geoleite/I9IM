/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.easynet.pro_produto;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.ExibirImagensGWT;
import br.com.i9.imagemanager.gwt.client.PrincipalGWT;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.easynet.bo.Pro_produtoConsultGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Eve_eventoTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Pro_produtoTGWT;
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
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import java.util.Date;

/**
 *
 * @author geoleite
 */
public class ProdutosEventoGWT extends com.extjs.gxt.ui.client.widget.Window implements Listener<ButtonEvent> {

    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Eve_eventoTGWT eve_eventoTGWT;
    private Button btnFechar = new Button("Fechar");
    private Button btnExcel = new Button("Exportar Excel");
    private final static int PRODUTOS_EVENTO = 0;
    private final static int PRODUTOS_SEM_IMG_BRUTA = 1;
    private final static int PRODUTOS_SEM_IMG_TRATADA = 2;
    private final static int PRODUTOS_SEM_IMG_WEB = 3;
    private final static int PRODUTOS_COM_IMG_TRATADA = 4;
    private int tipoConsulta = 0;

    public ProdutosEventoGWT() {
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
            column.setWidth(80);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_tx_nome");
            column.setHeader("Nome");
            column.setWidth(350);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_dt_atualizacao");
            column.setHeader("Dt Atualizacao.");
            column.setWidth(100);
            column.setRenderer(dtRender);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("pro_tx_situacao");
            column.setHeader("Situacao");
            column.setWidth(80);
            column.setRenderer(situacaoRender);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            btnFechar.addListener(Events.OnClick, this);
            btnFechar.setIcon(PrincipalGWT.ICONS.delete());
            btnExcel.addListener(Events.OnClick, this);
            btnExcel.setIcon(PrincipalGWT.ICONS.excel());
            addButton(btnFechar);
            addButton(btnExcel);
        } catch (Exception ex) {
        }
    }

    public void load() {
        tipoConsulta = PRODUTOS_EVENTO;
        setHeading("Produtos do Evento " + eve_eventoTGWT.getEve_tx_nome());
        final Pro_produtoConsultGWT proConsult = new Pro_produtoConsultGWT();
        proConsult.consultarEvento(eve_eventoTGWT.getEve_nr_id(), false);
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

    public void loadProdutosSemImagensBruta() {
        tipoConsulta = PRODUTOS_SEM_IMG_BRUTA;
        setHeading("Produtos sem imagem bruta do evento" + eve_eventoTGWT.getEve_tx_nome());
        final Pro_produtoConsultGWT proConsult = new Pro_produtoConsultGWT();
        proConsult.consultarEventoProdutosSemImagemBruta(eve_eventoTGWT.getEve_nr_id(), false);
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

    public void loadProdutosSemImagensWeb() {
        tipoConsulta = PRODUTOS_SEM_IMG_WEB;
        setHeading("Produtos sem imagem web do evento " + eve_eventoTGWT.getEve_tx_nome());
        final Pro_produtoConsultGWT proConsult = new Pro_produtoConsultGWT();
        proConsult.consultarEventoProdutosSemImagemWeb(eve_eventoTGWT.getEve_nr_id(), false);
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

    public void loadProdutosSemImagensTratada() {
        tipoConsulta = PRODUTOS_SEM_IMG_TRATADA;
        setHeading("Produtos sem imagem tratada do evento " + eve_eventoTGWT.getEve_tx_nome());
        final Pro_produtoConsultGWT proConsult = new Pro_produtoConsultGWT();
        proConsult.consultarEventoProdutosSemImagemTratada(eve_eventoTGWT.getEve_nr_id(), false);
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

    public void loadProdutosComImagensTratada() {
        tipoConsulta = PRODUTOS_COM_IMG_TRATADA;
        setHeading("Produtos com imagem tratada do evento " + eve_eventoTGWT.getEve_tx_nome());
        final Pro_produtoConsultGWT proConsult = new Pro_produtoConsultGWT();
        proConsult.consultarEventoProdutosComImagemTratada(eve_eventoTGWT.getEve_nr_id(), false);
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

    private void downloadExcel() {
        String url = "";
        final Pro_produtoConsultGWT proConsult = new Pro_produtoConsultGWT();
        switch (tipoConsulta) {
            case PRODUTOS_EVENTO:
                url = Constantes.URL + "i9im/i9im/pro_produto/pro_produtoConsultGWT.jsp?op=consultProdutosEvento&excel=true&eve_eventoT.eve_nr_id=" + eve_eventoTGWT.getEve_nr_id();
                //proConsult.consultarEvento(eve_eventoTGWT.getEve_nr_id(), true);
                break;
            case PRODUTOS_SEM_IMG_BRUTA:
                url = Constantes.URL + "i9im/i9im/pro_produto/pro_produtoConsultGWT.jsp?op=consultProdutosSemImagemBrutaEvento&excel=true&eve_eventoT.eve_nr_id=" + eve_eventoTGWT.getEve_nr_id();
                //proConsult.consultarEventoProdutosSemImagemBruta(eve_eventoTGWT.getEve_nr_id(), true);
                break;
            case PRODUTOS_SEM_IMG_TRATADA:
                //proConsult.consultarEventoProdutosSemImagemTratada(eve_eventoTGWT.getEve_nr_id(), true);
                url = Constantes.URL + "i9im/i9im/pro_produto/pro_produtoConsultGWT.jsp?op=consultProdutosSemImagemTratadaEvento&excel=true&eve_eventoT.eve_nr_id=" + eve_eventoTGWT.getEve_nr_id();
                break;
            case PRODUTOS_SEM_IMG_WEB:
                //proConsult.consultarEventoProdutosSemImagemWeb(eve_eventoTGWT.getEve_nr_id(), true);
                url = Constantes.URL + "i9im/i9im/pro_produto/pro_produtoConsultGWT.jsp?op=consultProdutosSemImagemWebEvento&excel=true&eve_eventoT.eve_nr_id=" + eve_eventoTGWT.getEve_nr_id();
                break;
            case PRODUTOS_COM_IMG_TRATADA: 
                //proConsult.consultarEventoProdutosSemImagemTratada(eve_eventoTGWT.getEve_nr_id(), true);
                url = Constantes.URL + "i9im/i9im/pro_produto/pro_produtoConsultGWT.jsp?op=consultProdutosComImagemTratadaEvento&excel=true&eve_eventoT.eve_nr_id=" + eve_eventoTGWT.getEve_nr_id();
                break;
        }
        final com.extjs.gxt.ui.client.widget.Window winDownload = new com.extjs.gxt.ui.client.widget.Window();
        winDownload.setUrl(url);
        winDownload.setSize(10, 10);
        //winDownload.setResizable(false);
        winDownload.show();
        final MessageBox mb = MessageBox.wait("Preparando Download", "Download lista de produtos do Evento.", "Esperando geracao do Excel");
        Timer timer = new Timer() {

            @Override
            public void run() {
                winDownload.setVisible(false);
                mb.close();
            }
        };
        timer.schedule(10000);
    }

    public void handleEvent(ButtonEvent be) {
        if (be.getButton() == btnFechar) {
            setVisible(false);
        } else if (be.getButton() == btnExcel) {
            downloadExcel();
        }
    }
}
