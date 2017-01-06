/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.easynet.sel_selo;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.PrincipalGWT;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.easynet.bo.Cls_classificacao_seloConsultGWT;
import br.com.i9.imagemanager.gwt.client.easynet.bo.Sel_selosConsult;
import br.com.i9.imagemanager.gwt.client.transfer.Cls_classificacao_seloTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Pro_produtoTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Sel_seloTGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Padding;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class SeloProdutoGWT extends Window implements Listener<ButtonEvent>, IListenetResponse {

    private Pro_produtoTGWT proT;
    private String titulo = "Selos para o produto: ";
    private Button btnFechar = new Button("Fechar");
    private ContentPanel north = new ContentPanel();
    private ContentPanel center = new ContentPanel();
    private ContentPanel east = new ContentPanel();
    private ContentPanel west = new ContentPanel();
    private ContentPanel cpSelosProduto = new ContentPanel();
    private ContentPanel cpSelosNaoProduto = new ContentPanel();
    private ContentPanel cpControleBotoes = new ContentPanel();
    private Cls_classificacao_seloConsultGWT clsConsult = new Cls_classificacao_seloConsultGWT();
    private ComboBox<Cls_classificacao_seloTGWT> comboCls = new ComboBox<Cls_classificacao_seloTGWT>();
    private Sel_selosConsult selConsult1 = new Sel_selosConsult();
    private Sel_selosConsult selConsult2 = new Sel_selosConsult();
    private Button btnAdd = new Button("Adicionar");
    private Button btnRem = new Button("Remover");
    private Button btnDownload = new Button("Download");
    private List<CheckBox> listChProdutos = new ArrayList<CheckBox>();
    private List<CheckBox> listChNaoProdutos = new ArrayList<CheckBox>();
    public final static String PAGE_DOWNLOAD_IMAGE = "i9im/i9im/sel_selo/sel_seloUpdateDeleteGWT.jsp";
    private Cls_classificacao_seloTGWT clsCorrente;
    private TextField<String> txFind = new TextField<String>();

    public SeloProdutoGWT() {

        setResizable(false);
        setSize(710, 500);
        setModal(true);

        btnFechar.setIcon(PrincipalGWT.ICONS.delete());

        addButton(btnFechar);
        btnFechar.addListener(Events.OnClick, this);

        BorderLayoutData northData = new BorderLayoutData(LayoutRegion.NORTH, 25, 25, 25);
        northData.setCollapsible(false);
        northData.setFloatable(true);
        northData.setHideCollapseTool(true);
        northData.setSplit(false);
        northData.setMargins(new Margins(0, 0, 0, 0));

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
        north.setHeaderVisible(false);
        center.setHeaderVisible(false);
        east.setHeaderVisible(false);
        west.setHeaderVisible(false);
        VBoxLayout vblLayout1 = new VBoxLayout();
        vblLayout1.setPadding(new Padding(5));
        vblLayout1.setVBoxLayoutAlign(VBoxLayout.VBoxLayoutAlign.STRETCH);

        VBoxLayout vblLayout2 = new VBoxLayout();
        vblLayout2.setPadding(new Padding(5));
        vblLayout2.setVBoxLayoutAlign(VBoxLayout.VBoxLayoutAlign.STRETCH);

        west.setLayout(vblLayout1);
        east.setLayout(vblLayout2);

        VBoxLayout layout = new VBoxLayout();
        layout.setPadding(new Padding(5));

        layout.setVBoxLayoutAlign(VBoxLayout.VBoxLayoutAlign.STRETCH);
        center.setLayout(layout);

        //cpControleBotoes.setLayout(new RowLayout(Orientation.VERTICAL));
        //cpControleBotoes.setHeaderVisible(false);
        //cpControleBotoes.setBorders(false);
        //cpControleBotoes.setBodyBorder(false);

        btnAdd.setIcon(PrincipalGWT.ICONS.setaAdd());
        btnRem.setIcon(PrincipalGWT.ICONS.setaRem());
        btnDownload.setIcon(PrincipalGWT.ICONS.download());
        btnAdd.setTitle("Adiciona os selos ao produto.");
        btnRem.setTitle("Remove os selos do produto.");
        btnDownload.setTitle("Download dos selos do produto.");

        //cpControleBotoes.add(btnAdd);
        //cpControleBotoes.add(btnRem);

        cpSelosProduto.setWidth("90%");
        cpSelosNaoProduto.setWidth("90%");
        cpSelosProduto.setHeight("385");
        cpSelosNaoProduto.setHeight("385");
        cpSelosProduto.setLayout(new FitLayout());
        //cpSelosNaoProduto.setLayout(new TableLayout(3));
        cpSelosNaoProduto.setLayout(new FitLayout());
        cpSelosNaoProduto.setScrollMode(Scroll.ALWAYS);
        cpSelosProduto.setScrollMode(Scroll.ALWAYS);
        east.add(cpSelosNaoProduto);
        west.add(cpSelosProduto);
        //center.add(cpControleBotoes);
        center.add(btnAdd);
        center.add(new LabelField(" "));
        center.add(btnRem);
        center.add(new LabelField(" "));
        center.add(btnDownload);

        cpSelosProduto.setHeading("Selos associados ao Produto");
        cpSelosNaoProduto.setHeading("Selos nao associados ao Produto");
        cpSelosNaoProduto.setTopComponent(txFind);
        txFind.setTitle("Nome do arquivo que deseja pesquisar.");
        KeyEventoSeloProduto keyEventoSelo = new KeyEventoSeloProduto();
        keyEventoSelo.setSeloProdutoGWT(this);

        txFind.addKeyListener(keyEventoSelo);


        cpSelosProduto.setScrollMode(Scroll.AUTO);
        cpSelosNaoProduto.setScrollMode(Scroll.AUTO);

        add(north, northData);
        add(east, eastData);
        add(center, centerData);
        add(west, westData);

        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Cls_classificacao_seloTGWT> listCls = clsConsult.getStore();

                if (listCls == null) {
                    schedule(500);
                } else {
                    comboCls.setLabelSeparator("");
                    comboCls.setForceSelection(true);
                    comboCls.setName("cls_classificacao_seloT.cls_tx_tipo");
                    comboCls.setEmptyText("Selecione a classificacão...");
                    comboCls.setDisplayField("cls_tx_tipo");
                    comboCls.setValueField("cls_tx_tipo");
                    //comboCla.set
                    comboCls.setWidth(250);

                    comboCls.setTypeAhead(true);
                    comboCls.setTriggerAction(ComboBox.TriggerAction.ALL);

                    north.add(comboCls);
                    comboCls.setStore(listCls);
                    north.layout();
                    layout();

                    comboCls.addSelectionChangedListener(new SelectionChangedListener<Cls_classificacao_seloTGWT>() {

                        @Override
                        public void selectionChanged(SelectionChangedEvent<Cls_classificacao_seloTGWT> se) {
                            //com.google.gwt.user.client.Window.alert("Selecionado " + se.getSelectedItem().getCls_tx_tipo());
                            clsCorrente = se.getSelectedItem();
                            exibirSelos(clsCorrente);
                        }
                    });
                }

            }
        };
        timer.schedule(500);
        btnAdd.addListener(Events.OnClick, this);
        btnRem.addListener(Events.OnClick, this);
        btnDownload.addListener(Events.OnClick, this);        
    }

    private GridCellRenderer<Sel_seloTGWT> getBtnCheckRender() {
        return new GridCellRenderer<Sel_seloTGWT>() {

            private boolean init;

            public Object render(final Sel_seloTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Sel_seloTGWT> store, Grid<Sel_seloTGWT> grid) {
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
        column.setId("sel_nr_id");
        column.setHeader("Codigo");
        column.setWidth(70);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("sel_tx_nome");
        column.setHeader("Nome");
        column.setWidth(250);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);
        return configs;
    }

    public void load() {
        selConsult2.loadSelosNaoProduto(txFind.getValue(), proT, clsCorrente);
        Timer timerNP = new Timer() {

            @Override
            public void run() {
                ListStore<Sel_seloTGWT> listSel = selConsult2.getStore();
                if (listSel == null) {
                    schedule(500);
                } else {
                    cpSelosNaoProduto.removeAll();
                    cpSelosNaoProduto.layout();
                    listChNaoProdutos.clear();
                    /*

                    for (int i = 0; i < listSel.getCount(); i++) {
                    Sel_seloTGWT selT = listSel.getAt(i);
                    //String url = Constantes.URL + PAGE_DOWNLOAD_IMAGE + "?thumb=S&op=downloadImage&sel_seloT.sel_nr_id=" + selT.getSel_nr_id();
                    //Image img = new Image(url);
                    //img.setTitle(selT.getSel_tx_nome());

                    CheckBox cb = new CheckBox();
                    cb.setItemId(selT.getSel_nr_id() + "");

                    LayoutContainer container = new LayoutContainer();

                    container.setBorders(false);
                    TableLayout tlImg = new TableLayout(1);
                    tlImg.setCellHorizontalAlign(HorizontalAlignment.CENTER);
                    container.setLayout(tlImg);

                    //container.add(img);
                    container.add(cb);
                    container.add(new LabelField(selT.getSel_tx_nome()));
                    listChNaoProdutos.add(cb);
                    cpSelosNaoProduto.add(container);

                    }
                     */
                    ColumnModel cm = new ColumnModel(definirGrid());
                    Grid<Sel_seloTGWT> gridSelo = new Grid<Sel_seloTGWT>(listSel, cm);
                    gridSelo.setLoadMask(true);
                    gridSelo.setStyleAttribute("borderTop", "none");
                    gridSelo.setBorders(false);
                    cpSelosNaoProduto.setScrollMode(Scroll.AUTO);
                    cpSelosNaoProduto.add(gridSelo);

                    show();
                    cpSelosNaoProduto.layout();
                }
            }
        };

        timerNP.schedule(500);
    }

    /**
     * Exibir os produtos
     * @param cls
     */
    private void exibirSelos(Cls_classificacao_seloTGWT cls) {
        cpSelosNaoProduto.removeAll();
        cpSelosProduto.removeAll();
        selConsult1.loadSelosProduto(proT, cls);
        Timer timerP = new Timer() {

            @Override
            public void run() {
                ListStore<Sel_seloTGWT> listSel = selConsult1.getStore();


                if (listSel == null) {
                    schedule(500);


                } else {
                    listChProdutos.clear();

/*
                    for (int i = 0; i < listSel.getCount(); i++) {
                        Sel_seloTGWT selT = listSel.getAt(i);
                        //String url = Constantes.URL + PAGE_DOWNLOAD_IMAGE + "?thumb=S&op=downloadImage&sel_seloT.sel_nr_id=" + selT.getSel_nr_id();
                        ///Image img = new Image(url);
                        //img.setTitle(selT.getSel_tx_nome());                        
                        //img.addClickHandler(this);

                        CheckBox cb = new CheckBox();

                        cb.setItemId(selT.getSel_nr_id() + "");

                        LayoutContainer container = new LayoutContainer();

                        container.setBorders(false);
                        TableLayout tlImg = new TableLayout(1);
                        tlImg.setCellHorizontalAlign(HorizontalAlignment.CENTER);
                        container.setLayout(tlImg);
                        //container.add(img);
                        container.add(cb);
                        container.add(new LabelField(selT.getSel_tx_nome()));
                        listChProdutos.add(cb);
                        cpSelosProduto.add(container);
                        //ti.add(img);

                    }
 */
                    ColumnModel cm = new ColumnModel(definirGrid());
                    Grid<Sel_seloTGWT> gridSelo = new Grid<Sel_seloTGWT>(listSel, cm);
                    gridSelo.setLoadMask(true);
                    gridSelo.setStyleAttribute("borderTop", "none");
                    gridSelo.setBorders(false);
                    cpSelosProduto.setScrollMode(Scroll.AUTO);
                    cpSelosProduto.add(gridSelo);
                    show();
                    cpSelosProduto.layout();
                    layout();


                }
            }
        };
        timerP.schedule(500);

        load();
        /*
        selConsult2.loadSelosNaoProduto(proT, cls);
        Timer timerNP = new Timer() {

        @Override
        public void run() {
        ListStore<Sel_seloTGWT> listSel = selConsult2.getStore();
        if (listSel == null) {
        schedule(500);
        } else {
        listChNaoProdutos.clear();
        for (int i = 0; i < listSel.getCount(); i++) {
        Sel_seloTGWT selT = listSel.getAt(i);
        String url = Constantes.URL + PAGE_DOWNLOAD_IMAGE + "?thumb=S&op=downloadImage&sel_seloT.sel_nr_id=" + selT.getSel_nr_id();
        Image img = new Image(url);

        img.setTitle(selT.getSel_tx_nome());
        //img.addClickHandler(this);
        CheckBox cb = new CheckBox();
        cb.setItemId(selT.getSel_nr_id() + "");

        LayoutContainer container = new LayoutContainer();

        container.setBorders(false);
        TableLayout tlImg = new TableLayout(1);
        tlImg.setCellHorizontalAlign(HorizontalAlignment.CENTER);
        container.setLayout(tlImg);
        container.add(img);
        container.add(cb);
        listChNaoProdutos.add(cb);
        cpSelosNaoProduto.add(container);
        //ti.add(img);

        }
        cpSelosNaoProduto.layout();
        layout();
        }
        }
        };
        timerNP.schedule(500);
         */



    }

    /**
     * @return the proT
     */
    public Pro_produtoTGWT getProT() {
        return proT;


    }

    /**
     * @param proT the proT to set
     */
    public void setProT(Pro_produtoTGWT proT) {
        this.proT = proT;


        if (proT != null) {
            setHeading(titulo + proT.getPro_nr_id() + "-" + proT.getPro_tx_nome());


        }
    }

    public void handleEvent(ButtonEvent be) {
        if (be.getButton() == btnFechar) {
            setVisible(false);


        } else if (be.getButton() == btnAdd) {
            adicionarSelos();


        } else if (be.getButton() == btnRem) {
            removerSelos();


        } else if (be.getButton() == btnDownload) {
            downloadSelos();


        }
    }

    /**
     * Adicionar selos ao produto
     */
    private void adicionarSelos() {
        try {
            StringBuffer sb = new StringBuffer();
            sb.append("0");

            Grid<Sel_seloTGWT> gridSelo = (Grid<Sel_seloTGWT>) cpSelosNaoProduto.getItem(0);
            int count = gridSelo.getStore().getCount();
            for (int i = 0; i < count; i++) {
                CheckBox cb = (CheckBox) gridSelo.getView().getWidget(i, 0);
                if (cb.isDirty()) {
                    //MessageBox.info("DEBUG", cb.getValue() + "-" + gridProduto.getStore().getAt(i).getPro_tx_nome(), null);
                    sb.append(",").append(gridSelo.getStore().getAt(i).getSel_nr_id());
                }
            }
            /*
            for (int i = 0; i< listChNaoProdutos.size(); i++) {
                CheckBox cb = listChNaoProdutos.get(i);


                if (cb.isDirty()) {
                    sb.append(",").append(cb.getItemId());


                }
            }
             */
            EasyAccessURL access = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "adicionarSelos");
            param.put("pro_produtoT.pro_nr_id", proT.getPro_nr_id() + "");
            param.put("idsSelos", sb.toString());
            access.accessJSonMap(Constantes.URL + "i9im/i9im/sel_selo/sel_seloUpdateDeleteGWT.jsp", param);


        } catch (Exception e) {
        }
    }

    private void removerSelos() {
        try {
            StringBuffer sb = new StringBuffer();
            sb.append("0");


            Grid<Sel_seloTGWT> gridSelo = (Grid<Sel_seloTGWT>) cpSelosProduto.getItem(0);
            int count = gridSelo.getStore().getCount();
            for (int i = 0; i < count; i++) {
                CheckBox cb = (CheckBox) gridSelo.getView().getWidget(i, 0);
                if (cb.isDirty()) {
                    //MessageBox.info("DEBUG", cb.getValue() + "-" + gridProduto.getStore().getAt(i).getPro_tx_nome(), null);
                    sb.append(",").append(gridSelo.getStore().getAt(i).getSel_nr_id());
                }
            }
/*
            for (int i = 0; i
                    < listChProdutos.size(); i++) {
                CheckBox cb = listChProdutos.get(i);


                if (cb.isDirty()) {
                    sb.append(",").append(cb.getItemId());


                }
            }
 */
            EasyAccessURL access = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "removerSelos");
            param.put("pro_produtoT.pro_nr_id", proT.getPro_nr_id() + "");
            param.put("idsSelos", sb.toString());
            access.accessJSonMap(Constantes.URL + "i9im/i9im/sel_selo/sel_seloUpdateDeleteGWT.jsp", param);


        } catch (Exception e) {
        }
    }

    private void downloadSelos() {
        try {
            IListenetResponse listener = new IListenetResponse() {

                public void read(JSONValue jsonValue) {
                }
            };
            StringBuffer sb = new StringBuffer();
            sb.append("0");


            for (int i = 0; i
                    < listChProdutos.size(); i++) {
                CheckBox cb = listChProdutos.get(i);
                //if (cb.isDirty()) {
                sb.append(",").append(cb.getItemId());
                //}


            }
            EasyAccessURL access = new EasyAccessURL(listener);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "downloadSelos");
            param.put("pro_produtoT.pro_nr_id", proT.getPro_nr_id() + "");
            param.put("idsSelos", sb.toString());
            final MessageBox mb = MessageBox.wait("Download Selos", "Esperando a compactacão dos Selos", "Compactando...");
            access.accessJSonMap(Constantes.URL + "i9im/i9im/sel_selo/sel_seloUpdateDeleteGWT.jsp", param);
            Timer timer = new Timer() {

                @Override
                public void run() {
                    mb.close();
                    final com.extjs.gxt.ui.client.widget.Window winDownload = new com.extjs.gxt.ui.client.widget.Window();
                    winDownload.setUrl(Constantes.URL + "i9im/download/downloadSelos.jsp?pro_produtoT.pro_nr_id=" + proT.getPro_nr_id());
                    winDownload.setSize(5, 5);
                    winDownload.setResizable(false);
                    winDownload.show();
                    Timer t = new Timer() {

                        @Override
                        public void run() {
                            winDownload.setVisible(false);


                        }
                    };
                    t.schedule(5000);


                }
            };
            timer.schedule(5000);


        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;


        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONObject resultado = jsonObject.get("resultado").isObject();
            String msg = EasyContainer.clearAspas(resultado.get("msg").toString());


            if (msg != null && msg.trim().length() > 0) {
                if (msg.toUpperCase().indexOf("SUCESSO") > -1) {
                    Info.display("Resultado", msg);


                } else {
                    MessageBox.alert("Falha", msg, null);


                }
            }
        }

        exibirSelos(clsCorrente);







    }
}

class KeyEventoSeloProduto extends KeyListener {

    private SeloProdutoGWT seloProdutoGWT;

    /**
     * Fires on key down.
     *
     * @param event the component event
     */
    public void componentKeyDown(ComponentEvent event) {
    }

    /**
     * Fires on key press.
     *
     * @param event the component event
     */
    public void componentKeyPress(ComponentEvent event) {
    }

    public void componentKeyUp(ComponentEvent event) {
        if (event.getKeyCode() == 13) {// enter
            seloProdutoGWT.load();
        }
    }

    /**
     * @return the seloProdutoGWT
     */
    public SeloProdutoGWT getSeloProdutoGWT() {
        return seloProdutoGWT;
    }

    /**
     * @param seloProdutoGWT the seloProdutoGWT to set
     */
    public void setSeloProdutoGWT(SeloProdutoGWT seloProdutoGWT) {
        this.seloProdutoGWT = seloProdutoGWT;
    }
}
