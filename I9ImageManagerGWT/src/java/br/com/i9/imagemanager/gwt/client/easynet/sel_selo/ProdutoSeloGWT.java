/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.easynet.sel_selo;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.PrincipalGWT;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.easynet.bo.Pro_produtoConsultGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Pro_produtoTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Sel_seloTGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Padding;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class ProdutoSeloGWT extends Window implements Listener<ButtonEvent>, IListenetResponse {

    private Sel_seloTGWT selT;
    private String titulo = "Produtos para o Selo: ";
    private Button btnFechar = new Button("Fechar");
    //private ContentPanel north = new ContentPanel();
    private ContentPanel center = new ContentPanel();
    private ContentPanel east = new ContentPanel();
    private ContentPanel west = new ContentPanel();
    private ContentPanel cpProdutosSelo = new ContentPanel();
    private ContentPanel cpProdutosNaoSelo = new ContentPanel();
    private ContentPanel cpControleBotoes = new ContentPanel();
    //private ContentPanel cpGridNaoSelo = new ContentPanel();
    private Pro_produtoConsultGWT proConsult1 = new Pro_produtoConsultGWT();
    private Pro_produtoConsultGWT proConsult2 = new Pro_produtoConsultGWT();
    private Button btnAdd = new Button("Adicionar");
    private Button btnRem = new Button("Remover");
    private ListView<Pro_produtoTGWT> listProAssociados = new ListView<Pro_produtoTGWT>();
    private TextField<String> tfPesquisar = new TextField<String>();
    public final static String PAGE_DOWNLOAD_IMAGE = "i9im/i9im/sel_selo/sel_seloUpdateDeleteGWT.jsp";

    public ProdutoSeloGWT() {
        setResizable(false);
        setSize(710, 400);
        setModal(true);

        btnFechar.setIcon(PrincipalGWT.ICONS.delete());

        addButton(btnFechar);
        btnFechar.addListener(Events.OnClick, this);

        /*
        BorderLayoutData northData = new BorderLayoutData(LayoutRegion.NORTH, 25, 25, 25);
        northData.setCollapsible(false);
        northData.setFloatable(true);
        northData.setHideCollapseTool(true);
        northData.setSplit(false);
        northData.setMargins(new Margins(0, 0, 0, 0));
        
         */

        BorderLayoutData eastData = new BorderLayoutData(LayoutRegion.EAST, 290, 290, 290);
        eastData.setCollapsible(false);
        eastData.setFloatable(true);
        eastData.setHideCollapseTool(true);
        eastData.setSplit(false);
        eastData.setMargins(new Margins(5, 5, 5, 5));

        BorderLayoutData westData = new BorderLayoutData(LayoutRegion.WEST, 290, 290, 290);
        westData.setCollapsible(false);
        westData.setFloatable(true);
        westData.setHideCollapseTool(true);
        westData.setSplit(false);
        westData.setMargins(new Margins(5, 5, 5, 5));


        BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER, 60, 60, 60);
        centerData.setCollapsible(false);
        centerData.setFloatable(true);
        centerData.setHideCollapseTool(true);
        centerData.setSplit(false);
        centerData.setMargins(new Margins(5, 0, 5, 0));

        setLayout(new BorderLayout());
        //north.setHeaderVisible(false);
        center.setHeaderVisible(false);
        east.setHeaderVisible(false);
        west.setHeaderVisible(false);
        VBoxLayout vblLayout1 = new VBoxLayout();
        vblLayout1.setPadding(new Padding(5));
        vblLayout1.setVBoxLayoutAlign(VBoxLayout.VBoxLayoutAlign.STRETCH);

        VBoxLayout vblLayout2 = new VBoxLayout();
        vblLayout2.setPadding(new Padding(5));
        vblLayout2.setVBoxLayoutAlign(VBoxLayout.VBoxLayoutAlign.STRETCH);

        west.setLayout(new FillLayout());
        east.setLayout(new FillLayout());

        VBoxLayout layout = new VBoxLayout();
        layout.setPadding(new Padding(5));

        layout.setVBoxLayoutAlign(VBoxLayout.VBoxLayoutAlign.STRETCH);
        center.setLayout(new CenterLayout());


        btnAdd.setIcon(PrincipalGWT.ICONS.setaAdd());
        btnRem.setIcon(PrincipalGWT.ICONS.setaRem());
        btnAdd.setTitle("Associar produtos ao selo.");
        btnRem.setTitle("Remove associacao produto selo.");


        //cpProdutosSelo.setSize(340, 300);
        //cpProdutosNaoSelo.setSize(340, 300);
        cpProdutosSelo.setLayout(new FillLayout());
        cpProdutosNaoSelo.setLayout(new FillLayout());


        east.add(cpProdutosNaoSelo);
        west.add(cpProdutosSelo);

        cpControleBotoes.setHeaderVisible(false);
        cpControleBotoes.setBorders(false);
        cpControleBotoes.setFrame(false);
        TableLayout tl = new TableLayout(1);
        tl.setCellPadding(10);
        cpControleBotoes.setLayout(tl);
        cpControleBotoes.add(btnAdd);
        //cpControleBotoes.add(new Label(""));
        //cpControleBotoes.add(new Label(""));
        cpControleBotoes.add(btnRem);
        center.add(cpControleBotoes);



        cpProdutosSelo.setHeading("Produtos associados ao Selo");
        cpProdutosNaoSelo.setHeading("Produtos nao associados ao Selo");

        tfPesquisar.addKeyListener(new KeyListener() {

            public void componentKeyDown(ComponentEvent event) {
            }

            /**
             * Fires on key press.
             *
             * @param event the component event
             */
            public void componentKeyPress(ComponentEvent event) {
            }

            /**
             * Fires on key up.
             *
             * @param event the component event
             */
            public void componentKeyUp(ComponentEvent event) {

                if (event.getKeyCode() == 13) {
                    consultar();
                }
            }
        });

        //cpProdutosSelo.add(listProAssociados);
        Button btnPesquisar = new Button();
        btnPesquisar.setIcon(PrincipalGWT.ICONS.find());
        btnPesquisar.setEnabled(false);
        ToolBar toolBar = new ToolBar();
        toolBar.add(tfPesquisar);
        toolBar.add(btnPesquisar);
        tfPesquisar.setTitle("Entre com parte do nome do produto com pelo menos 4 letras e tecle Enter.");
        cpProdutosNaoSelo.setTopComponent(toolBar);

        //add(north, northData);
        add(east, eastData);
        add(center, centerData);
        add(west, westData);

        btnAdd.addListener(Events.OnClick, this);
        btnRem.addListener(Events.OnClick, this);
    }

    /**
     * Consulta os produtos por parte do nome
     */
    private void consultar() {
        if (tfPesquisar.getValue().trim().length() > 3) {
            proConsult2.consultarNaoSeloDescricao(selT.getSel_nr_id(), tfPesquisar.getValue());
            Timer timer = new Timer() {

                @Override
                public void run() {
                    ListStore<Pro_produtoTGWT> listProNaoSelo = proConsult2.getStore();
                    
                    if (listProNaoSelo == null) {
                        schedule(500);
                    } else {
                        cpProdutosNaoSelo.removeAll();
                        ColumnModel cm = new ColumnModel(definirGrid());
                        Grid<Pro_produtoTGWT> gridNaoSelo = new Grid<Pro_produtoTGWT>(listProNaoSelo, cm);
                        gridNaoSelo.setLoadMask(true);
                        gridNaoSelo.setStyleAttribute("borderTop", "none");
                        gridNaoSelo.setBorders(false);
                        cpProdutosNaoSelo.setScrollMode(Scroll.AUTO);
                        cpProdutosNaoSelo.add(gridNaoSelo);
                        cpProdutosNaoSelo.layout();
                        east.layout();
                        layout();
                    }
                }
            };
            timer.schedule(500);
        }

    }

    private List<ColumnConfig> definirGrid() {
        List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("proCheck");
        column.setHeader("");
        column.setWidth(20);
        column.setAlignment(HorizontalAlignment.CENTER);
        column.setRenderer(getBtnCheckRender());
        configs.add(column);

        column = new ColumnConfig();
        column.setId("pro_nr_id");
        column.setHeader("Codigo");
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("pro_tx_nome");
        column.setHeader("Nome");
        column.setWidth(250);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);
        return configs;
    }

    private GridCellRenderer<Pro_produtoTGWT> getBtnCheckRender() {
        return new GridCellRenderer<Pro_produtoTGWT>() {

            private boolean init;

            public Object render(final Pro_produtoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Pro_produtoTGWT> store, Grid<Pro_produtoTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Sel_seloTGWT>>() {

                        public void handleEvent(GridEvent<Sel_seloTGWT> be) {
                            for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {
                                if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null
                                        && be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {
                                    ((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10);
                                }
                            }
                        }
                    });
                }


                return new CheckBox();
            }
        };

    }

    public void load() {
        setHeading("Produtos com Selo " + selT.getSel_tx_nome());
        proConsult1.consultarSelo(selT.getSel_nr_id());

        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Pro_produtoTGWT> listProSelo = proConsult1.getStore();
                if (listProSelo == null) {
                    schedule(500);
                } else {
                    cpProdutosSelo.removeAll();
                    
                    ColumnModel cm = new ColumnModel(definirGrid());
                    Grid<Pro_produtoTGWT> gridSelo = new Grid<Pro_produtoTGWT>(listProSelo, cm);
                    gridSelo.setLoadMask(true);
                    gridSelo.setStyleAttribute("borderTop", "none");
                    gridSelo.setBorders(false);
                    cpProdutosSelo.setScrollMode(Scroll.AUTO);
                    cpProdutosSelo.add(gridSelo);

                    show();
                    cpProdutosSelo.layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void handleEvent(ButtonEvent be) {
        if (be.getButton() == btnFechar) {
            setVisible(false);
        } else if (be.getButton() == btnAdd) {
            adicionarSelos();
        } else if (be.getButton() == btnRem) {
            removerSelos();
        }

    }

    private void adicionarSelos() {

        try {
            StringBuffer sb = new StringBuffer();
            sb.append("0");
            Grid<Pro_produtoTGWT> gridProduto = (Grid<Pro_produtoTGWT>) cpProdutosNaoSelo.getItem(0);
            int count = gridProduto.getStore().getCount();
            EasyAccessURL access = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "adicionarProdutos");
            param.put("sel_seloT.sel_nr_id", selT.getSel_nr_id() + "");

            for (int i = 0; i < count; i++) {
                CheckBox cb = (CheckBox) gridProduto.getView().getWidget(i, 0);
                if (cb.isDirty()) {
                    //MessageBox.info("DEBUG", cb.getValue() + "-" + gridProduto.getStore().getAt(i).getPro_tx_nome(), null);
                    sb.append(",").append(gridProduto.getStore().getAt(i).getPro_nr_id());
                }
            }
            param.put("idsProdutos", sb.toString());
            access.accessJSonMap(Constantes.URL + "i9im/i9im/sel_selo/sel_seloUpdateDeleteGWT.jsp", param);
            load();
            consultar();
        } catch (Exception e) {
        }


    }

    private void removerSelos() {
        try {
            StringBuffer sb = new StringBuffer();
            sb.append("0");
            Grid<Pro_produtoTGWT> gridProduto = (Grid<Pro_produtoTGWT>) cpProdutosSelo.getItem(0);
            int count = gridProduto.getStore().getCount();
            EasyAccessURL access = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "removerProdutos");
            param.put("sel_seloT.sel_nr_id", selT.getSel_nr_id() + "");

            for (int i = 0; i < count; i++) {
                CheckBox cb = (CheckBox) gridProduto.getView().getWidget(i, 0);
                if (cb.isDirty()) {
                    sb.append(",").append(gridProduto.getStore().getAt(i).getPro_nr_id());
                }
            }
            param.put("idsProdutos", sb.toString());
            access.accessJSonMap(Constantes.URL + "i9im/i9im/sel_selo/sel_seloUpdateDeleteGWT.jsp", param);
            load();
            consultar();
        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {
        load();
    }

    /**
     * @return the selT
     */
    public Sel_seloTGWT getSelT() {
        return selT;
    }

    /**
     * @param selT the selT to set
     */
    public void setSelT(Sel_seloTGWT selT) {
        this.selT = selT;
    }
}
