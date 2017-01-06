/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.easynet.sel_selo;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.PrincipalGWT;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.easynet.bo.Sel_selosConsult;
import br.com.i9.imagemanager.gwt.client.easynet.pro_produto.ProdutosSeloGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Sel_seloTGWT;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONValue;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Image;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Sel_seloConsultGWT extends ContentPanel {

    public final static String PAGE_DOWNLOAD_IMAGE = "i9im/i9im/sel_selo/sel_seloUpdateDeleteGWT.jsp";
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Sel_selosConsult selConsult = new Sel_selosConsult();
    private ListStore<Sel_seloTGWT> store;
    private String tipo;
    private TextField<String> textFind = new TextField<String>();
    private CheckBox cbStatus = new CheckBox();
    private Grid<Sel_seloTGWT> grid;

    public Sel_seloConsultGWT() {
        try {

            KeyEventoSelo keyEventoSelo = new KeyEventoSelo();
            keyEventoSelo.setSel_seloConsultGWT(this);
            textFind.setTitle("Nome do arquivo que deseja pesquisar.");
            textFind.addKeyListener(keyEventoSelo);
            setTopComponent(textFind);

            setBorders(false);
            setHeaderVisible(false);
            setWidth("100%");

            setLayout(new FillLayout());


            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Sel_seloTGWT>> numberRenderer = new NumberCellRenderer<Grid<Sel_seloTGWT>>(currency);


            GridCellRenderer<Sel_seloTGWT> dtRender = new GridCellRenderer<Sel_seloTGWT>() {

                public Object render(Sel_seloTGWT model, String property, ColumnData config,
                        int rowIndex, int colIndex, ListStore<Sel_seloTGWT> store, Grid<Sel_seloTGWT> grid) {
                    Date dt = (Date) model.get(property);
                    //model.getSel_tx_promocional();
                    String conteudo = PrincipalGWT.DATE_FORMAT.format(dt);
                    if (!"sel_dt_cadastro".equals(property) && "N".equals(model.getSel_tx_promocional())) {
                        conteudo = "  ";
                    }
                    return conteudo;
                }
            };

            GridCellRenderer<Sel_seloTGWT> statusRender = new GridCellRenderer<Sel_seloTGWT>() {

                public Object render(Sel_seloTGWT model, String property, ColumnData config,
                        int rowIndex, int colIndex, ListStore<Sel_seloTGWT> store, Grid<Sel_seloTGWT> grid) {
                    String conteudo = "Ativo";
                    if ("I".equals(model.getSel_tx_situacao())) {
                        conteudo = "Inativo";
                    }
                    return conteudo;
                }
            };

            ColumnConfig column = null;


            column = new ColumnConfig();
            column.setId("sel_tx_nome");
            column.setHeader("Nome");
            column.setWidth(200);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("sel_dt_cadastro");
            column.setHeader("Data Cadastro");
            column.setWidth(80);
            column.setRenderer(dtRender);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);


            column = new ColumnConfig();
            column.setId("sel_dt_validadeinicio");
            column.setHeader("Inicio Vigencia");
            column.setWidth(80);
            column.setRenderer(dtRender);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("sel_dt_validadefim");
            column.setHeader("Fim Vigencia");
            column.setWidth(80);
            column.setRenderer(dtRender);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("sel_tx_situacao");
            column.setHeader("Status");
            column.setWidth(60);
            column.setRenderer(statusRender);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            /*
            column = new ColumnConfig();
            column.setId("btnEditar");
            column.setWidth(30);            
            column.setAlignment(HorizontalAlignment.CENTER);
            column.setRenderer(getBtnEditRender());
            configs.add(column);
             */

            if (PrincipalGWT.mapPerfis.containsKey("I9IM.Admin")) {
                column = new ColumnConfig();
                column.setId("btnProdutosAdd");
                column.setWidth(30);
                column.setAlignment(HorizontalAlignment.CENTER);
                column.setRenderer(getBtnProdutosAddRender());
                configs.add(column);
            }

            column = new ColumnConfig();
            column.setId("btnProdutos");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.CENTER);
            column.setRenderer(getBtnProdutosRender());
            configs.add(column);

            if (PrincipalGWT.mapPerfis.containsKey("I9IM.Admin")) {
                column = new ColumnConfig();
                column.setId("imgSubstituir");
                column.setWidth(30);
                column.setAlignment(HorizontalAlignment.CENTER);
                column.setRenderer(getSubstituirRender());
                configs.add(column);
            }

            column = new ColumnConfig();
            column.setId("imgDownload");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.CENTER);
            column.setRenderer(getDownloadRender());
            configs.add(column);

            if (PrincipalGWT.mapPerfis.containsKey("I9IM.Admin")) {
                column = new ColumnConfig();
                column.setId("imgExcluir");
                column.setWidth(30);
                column.setAlignment(HorizontalAlignment.CENTER);
                column.setRenderer(getExcluirRender());
                configs.add(column);
            }

        } catch (Exception ex) {
        }
    }

    private GridCellRenderer<Sel_seloTGWT> getBtnEditRender() {
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

                Button b = new Button("", new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
//                        Eve_eventoUpdateDeleteGWT eve_eventoUpdateDeleteGWT = new Eve_eventoUpdateDeleteGWT();
//                        eve_eventoUpdateDeleteGWT.load(model);
//                        eve_eventoUpdateDeleteGWT.setEveConsult(eveConsult);
//                        eve_eventoUpdateDeleteGWT.show();
                    }
                });
                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Editar Selo");
                b.setIcon(PrincipalGWT.ICONS.edit());

                return b;
            }
        };

    }

    private GridCellRenderer<Sel_seloTGWT> getBtnProdutosRender() {
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

                Button b = new Button("", new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        ProdutosSeloGWT produtosSeloGWT = new ProdutosSeloGWT();
                        produtosSeloGWT.setSel_seloTGWT(model);
                        produtosSeloGWT.load();
                    }
                });
                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Produtos com este Selo");
                b.setIcon(PrincipalGWT.ICONS.list_items());

                return b;
            }
        };

    }

    private GridCellRenderer<Sel_seloTGWT> getBtnProdutosAddRender() {
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

                Button b = new Button("", new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        ProdutoSeloGWT psGWT = new ProdutoSeloGWT();
                        psGWT.setSelT(model);
                        psGWT.load();
                    }
                });
                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Associar Produtos a este Selo");
                b.setIcon(PrincipalGWT.ICONS.add());

                return b;
            }
        };

    }

    private GridCellRenderer<Sel_seloTGWT> getSubstituirRender() {
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
                Button b = new Button("", new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        SubstituirSelo subsSelo = new SubstituirSelo();
                        subsSelo.setSel_seloTGWT(model);
                        subsSelo.show();
                    }
                });
                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Substituir Selo.");
                b.setIcon(PrincipalGWT.ICONS.atualizar());

                return b;
            }
        };
    }

    private GridCellRenderer<Sel_seloTGWT> getDownloadRender() {
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
                Button b = new Button("", new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        String url = Constantes.URL + PAGE_DOWNLOAD_IMAGE + "?thumb=I&op=downloadImage&sel_seloT.sel_nr_id=" + model.getSel_nr_id();
                        final com.extjs.gxt.ui.client.widget.Window winDownload = new com.extjs.gxt.ui.client.widget.Window();
                        winDownload.setUrl(url);
                        winDownload.show();

                        Timer timer = new Timer() {

                            @Override
                            public void run() {
                                winDownload.setVisible(false);
                            }
                        };
                        timer.schedule(5000);
//                        ProdutoSeloGWT psGWT = new ProdutoSeloGWT();
//                        psGWT.setSelT(model);
//                        psGWT.load();
                    }
                });
                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Download Selo.");
                b.setIcon(PrincipalGWT.ICONS.download());

                return b;

            }
        };
    }

    private GridCellRenderer<Sel_seloTGWT> getExcluirRender() {
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

                Button b = new Button("", new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        try {
                            IListenetResponse listener = new IListenetResponse() {

                                public void read(JSONValue jsonValue) {
                                }
                            };
                            EasyAccessURL access = new EasyAccessURL(listener);
                            HashMap<String, String> param = new HashMap<String, String>();
                            param.put("op", "delete");
                            param.put("sel_seloT.sel_nr_id", model.getSel_nr_id() + "");
                            access.accessJSonMap(Constantes.URL + PAGE_DOWNLOAD_IMAGE, param);
                            // espera 2 segundos para realizar a atualizacao
                            Timer timer = new Timer() {

                                @Override
                                public void run() {
                                    load();
                                }
                            };
                            timer.schedule(2000);
                        } catch (Exception e) {
                        }
//                        ProdutoSeloGWT psGWT = new ProdutoSeloGWT();
//                        psGWT.setSelT(model);
//                        psGWT.load();
                    }
                });
                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Excluir Selo.");
                b.setIcon(PrincipalGWT.ICONS.remover());

                return b;
            }
        };
    }

    public void previewImagem(ClickEvent event) {

        Image imgThumb = (Image) event.getSource();
        String url = imgThumb.getUrl() + "&thumb=N";
        Image img = new Image(url);

        final Dialog simple = new Dialog();
        simple.setModal(true);
        simple.setLayout(new FitLayout());
        simple.setHeading("Imagem Ampliada");
        Button btn = new Button("Excluir");
        btn.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
            }
        });
        simple.addButton(btn);
        //simple.setButtons(Dialog.CLOSE);
        simple.setBodyStyleName("pad-text");
        simple.add(img);
        simple.setScrollMode(Scroll.AUTO);
        simple.setHideOnButtonClick(true);
        simple.setWidth(365);
        simple.setHeight(325);
        simple.show();
    }

    public void load() {
        selConsult.setTipo(tipo);
        selConsult.setNomeArquivo(textFind.getValue());
        selConsult.load();
        Timer timer = new Timer() {

            @Override
            public void run() {
                store = selConsult.getStore();
                if (store == null) {
                    schedule(500);
                } else {
                    montarGrid(store);
                }
            }
        };
        timer.schedule(500);

    }

    public void montarGrid(ListStore<Sel_seloTGWT> store) {

        ColumnModel cm = new ColumnModel(configs);

//        Grid<Sel_seloTGWT> grid = new Grid<Sel_seloTGWT>(store, cm);
        if (grid != null) {
            remove(grid);
        }
        grid = new Grid<Sel_seloTGWT>(store, cm);
        grid.setLoadMask(true);

        grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
        grid.setBorders(true);
        grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        removeAll();
        add(grid);
        layout();

    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

class KeyEventoSelo extends KeyListener {

    private Sel_seloConsultGWT sel_seloConsultGWT;

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
            sel_seloConsultGWT.load();
        }
    }

    /**
     * @return the sel_seloConsultGWT
     */
    public Sel_seloConsultGWT getSel_seloConsultGWT() {
        return sel_seloConsultGWT;
    }

    /**
     * @param sel_seloConsultGWT the sel_seloConsultGWT to set
     */
    public void setSel_seloConsultGWT(Sel_seloConsultGWT sel_seloConsultGWT) {
        this.sel_seloConsultGWT = sel_seloConsultGWT;
    }
}
