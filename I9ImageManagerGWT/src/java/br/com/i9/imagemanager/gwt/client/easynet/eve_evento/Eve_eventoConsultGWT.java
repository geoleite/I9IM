/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.easynet.eve_evento;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.PrincipalGWT;
import br.com.i9.imagemanager.gwt.client.dao.Eve_eventoDAOGWT;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.easynet.eve_evento.*;
import br.com.i9.imagemanager.gwt.client.easynet.ond_onda.Ond_ondaConsultGWT;
import br.com.i9.imagemanager.gwt.client.easynet.pro_produto.ProdutosEventoGWT;
import br.com.i9.imagemanager.gwt.client.icons.ExampleIcons;
import br.com.i9.imagemanager.gwt.client.transfer.Eve_eventoTGWT;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;

import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;
import com.google.gwt.core.client.GWT;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Timer;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Eve_eventoConsultGWT extends ContentPanel implements IListenetResponse {

    public static final String PAGE = "i9im/i9im/eve_evento/eve_eventoConsultGWT.jsp";
    private TextField<String> tfFind = new TextField<String>();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Button btnNovo = new Button("Novo");
    private Grid<Eve_eventoTGWT> grid;
    private ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private Eve_eventoConsultGWT eveConsult;
    private String opcao = "";
    private boolean gerando = false;
    private MessageBox mb = null;
    private float percentual = 0;
    private Eve_eventoDAOGWT eveDao = new Eve_eventoDAOGWT();

    public Eve_eventoConsultGWT() {
        try {
            setBorders(false);
            setHeaderVisible(false);
            setWidth("100%");
            //TableLayout tl = new TableLayout(1);
            //setLayout(tl);
            setLayout(new FillLayout());



            //this.setSize("600", "400");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Eve_eventoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Eve_eventoTGWT>>(currency);

            GridCellRenderer<Eve_eventoTGWT> dtRender = new GridCellRenderer<Eve_eventoTGWT>() {

                public Object render(Eve_eventoTGWT model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<Eve_eventoTGWT> store, Grid<Eve_eventoTGWT> grid) {
                    Date dt = (Date) model.get(property);
                    return PrincipalGWT.DATE_FORMAT.format(dt);
                }
            };

            ColumnConfig column = null;

            column = new ColumnConfig();
            column.setId("eve_tx_nome");
            column.setHeader("Nome");
            column.setWidth(400);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("eve_dt_inicio");
            column.setHeader("Inicio Vigência");
            column.setWidth(80);
            column.setRenderer(dtRender);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("eve_dt_fim");
            column.setHeader("Fim Vigência");
            column.setWidth(80);
            column.setRenderer(dtRender);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            column = new ColumnConfig();
            column.setId("eve_dt_criacao");
            column.setHeader("Data Criacao");
            column.setWidth(80);
            column.setRenderer(dtRender);
            column.setAlignment(HorizontalAlignment.LEFT);
            configs.add(column);

            eveConsult = this;

            column = new ColumnConfig();
            column.setId("btnEditar");
            column.setWidth(30);
            column.setRenderer(dtRender);
            column.setAlignment(HorizontalAlignment.CENTER);
            column.setRenderer(getBtnEditRender());
            configs.add(column);

            column = new ColumnConfig();
            column.setId("btnProdutos");
            column.setWidth(30);
            column.setRenderer(dtRender);
            column.setAlignment(HorizontalAlignment.CENTER);
            column.setRenderer(getBtnProdutoRender());
            configs.add(column);

            //Verifica a permissao para essa importacao
            if (PrincipalGWT.mapPerfis.containsKey("I9IM.Admin")) {
                column = new ColumnConfig();
                column.setId("btnImportar");
                column.setWidth(30);
                column.setAlignment(HorizontalAlignment.CENTER);
                column.setRenderer(getBtnImportarRender());
                configs.add(column);
            }

            column = new ColumnConfig();
            column.setId("btnExportar");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.CENTER);
            column.setRenderer(getBtnExportarRender());
            configs.add(column);

            column = new ColumnConfig();
            column.setId("btnOndas");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.CENTER);
            column.setRenderer(getBtnOndasRender());
            configs.add(column);

            column = new ColumnConfig();
            column.setId("btnComImagensTratada");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.CENTER);
            column.setRenderer(getBtnComImgTratadaRender());
            configs.add(column);

            column = new ColumnConfig();
            column.setId("btnSemImagensBrutas");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.CENTER);
            column.setRenderer(getBtnSemImgBrutaRender());
            configs.add(column);

            column = new ColumnConfig();
            column.setId("btnSemImagensTratada");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.CENTER);
            column.setRenderer(getBtnSemImgTratadaRender());
            configs.add(column);

            column = new ColumnConfig();
            column.setId("btnSemImagensWeb");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.CENTER);
            column.setRenderer(getBtnSemImgWebRender());
            configs.add(column);

            column = new ColumnConfig();
            column.setId("modificado");
            column.setWidth(30);
            column.setAlignment(HorizontalAlignment.CENTER);
            column.setRenderer(getBtnModificadoRender());
            configs.add(column);


            btnNovo.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                public void handleEvent(ButtonEvent be) {
                    Eve_eventoInsertGWT eveInsert = new Eve_eventoInsertGWT();
                    eveInsert.show();
                }
            });

            KeyEventoEve keyEventoEve = new KeyEventoEve();
            keyEventoEve.setEve_eventoGWT(this);
            tfFind.setTitle("Nome do evento que deseja pesquisar.");
            tfFind.addKeyListener(keyEventoEve);

            setTopComponent(tfFind);
            //load();
        } catch (Exception ex) {
        }
    }

    private GridCellRenderer<Eve_eventoTGWT> getBtnModificadoRender() {
        return new GridCellRenderer<Eve_eventoTGWT>() {

            private boolean init;

            public Object render(final Eve_eventoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Eve_eventoTGWT> store, Grid<Eve_eventoTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Eve_eventoTGWT>>() {

                        public void handleEvent(GridEvent<Eve_eventoTGWT> be) {
                            for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {
                                if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null
                                        && be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {
                                    ((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10);
                                }
                            }
                        }
                    });
                }

                Button b = new Button("");
                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                if (model.getModificado()) {
                    b.setToolTip("Evento possui imagens novas ou alteradas.");
                    b.setIcon(ICONS.delete());
                } else {
                    b.setToolTip("Evento já foi exportado.");
                    b.setIcon(ICONS.tick());
                }
                return b;
            }
        };
    }

    private GridCellRenderer<Eve_eventoTGWT> getBtnSemImgTratadaRender() {
        return new GridCellRenderer<Eve_eventoTGWT>() {

            public Object render(final Eve_eventoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Eve_eventoTGWT> store, Grid<Eve_eventoTGWT> grid) {

                Button b = new Button("", new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        // Produtos sem imagens tratadas
                        ProdutosEventoGWT produtosEvento = new ProdutosEventoGWT();
                        produtosEvento.setEve_eventoTGWT(model);
                        produtosEvento.loadProdutosSemImagensTratada();
                    }
                });
                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Produtos sem imagens tratadas.");
                b.setIcon(ICONS.noImageTratada());
                return b;
            }
        };
    }

    /**
     * Botao para icone de imagens tratadas
     * @return
     */
    private GridCellRenderer<Eve_eventoTGWT> getBtnComImgTratadaRender() {
        return new GridCellRenderer<Eve_eventoTGWT>() {

            public Object render(final Eve_eventoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Eve_eventoTGWT> store, Grid<Eve_eventoTGWT> grid) {

                Button b = new Button("", new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        // Produtos com imagens tratadas
                        ProdutosEventoGWT produtosEvento = new ProdutosEventoGWT();
                        produtosEvento.setEve_eventoTGWT(model);
                        produtosEvento.loadProdutosComImagensTratada();
                    }
                });
                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Produtos com imagens tratadas.");
                b.setIcon(ICONS.imageTratada());
                return b;
            }
        };
    }

    private GridCellRenderer<Eve_eventoTGWT> getBtnSemImgWebRender() {
        return new GridCellRenderer<Eve_eventoTGWT>() {

            private boolean init;

            public Object render(final Eve_eventoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Eve_eventoTGWT> store, Grid<Eve_eventoTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Eve_eventoTGWT>>() {

                        public void handleEvent(GridEvent<Eve_eventoTGWT> be) {
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
                        // Produtos sem imagens tratadas
                        ProdutosEventoGWT produtosEvento = new ProdutosEventoGWT();
                        produtosEvento.setEve_eventoTGWT(model);
                        produtosEvento.loadProdutosSemImagensWeb();
                    }
                });
                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Produtos sem imagens Web.");
                b.setIcon(ICONS.noImageWeb());
                return b;
            }
        };
    }

    private GridCellRenderer<Eve_eventoTGWT> getBtnSemImgBrutaRender() {
        return new GridCellRenderer<Eve_eventoTGWT>() {

            public Object render(final Eve_eventoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Eve_eventoTGWT> store, Grid<Eve_eventoTGWT> grid) {

                Button b = new Button("", new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        //Produtos sem imagens brutas
                        ProdutosEventoGWT produtosEvento = new ProdutosEventoGWT();
                        produtosEvento.setEve_eventoTGWT(model);
                        produtosEvento.loadProdutosSemImagensBruta();

                    }
                });
                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Produtos sem imagens brutas.");
                b.setIcon(ICONS.noImageBruta());
                return b;
            }
        };
    }

    private GridCellRenderer<Eve_eventoTGWT> getBtnExportarRender() {
        return new GridCellRenderer<Eve_eventoTGWT>() {

            public Object render(final Eve_eventoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Eve_eventoTGWT> store, Grid<Eve_eventoTGWT> grid) {

                Button b = new Button("", new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        // Exportar Evento
                        String url = Constantes.URL + "i9im/i9im/eve_evento/exportarEvento.jsp";
                        HashMap<String, String> param = new HashMap<String, String>();
                        param.put("op", "compactarImages");
                        param.put("eve_eventoT.eve_nr_id", "" + model.getEve_nr_id());
                        try {
                            IListenetResponse listenetResponse = new IListenetResponse() {

                                public void read(JSONValue jsonValue) {
                                    //Info.display("DEBUG", "read download ");
                                    load();
                                }
                            };
                            gerando = true;
                            EasyAccessURL access = new EasyAccessURL(listenetResponse);
                            access.accessJSonMapNoMessage(url, param);
                            opcao = "exportar";

                            IListenetResponse listenetResponsePercentual = new IListenetResponse() {

                                public void read(JSONValue jsonValue) {
                                    JSONObject jsonObject;
                                    //Info.display("Debug", gerando + " " + jsonValue);
                                    if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                                        String resultado = jsonObject.get("resultado").toString();
                                        percentual = Float.parseFloat(EasyContainer.clearAspas(resultado));
                                    }
                                }
                            };
                            final EasyAccessURL accessPercentual = new EasyAccessURL(listenetResponsePercentual);

                            Timer t = new Timer() {

                                @Override
                                public void run() {

                                    accessPercentual.accessJSonNoMessage(Constantes.URL + "i9im/i9im/eve_evento/statusExportacao.jsp");
                                    if (mb != null) {
                                        mb.close();
                                    }

                                    if (gerando) {
                                        mb = MessageBox.progress("Progresso", "percentual concluido:", percentual + "%");
                                        if (percentual < 100) {
                                            schedule(1000);
                                        } else {
                                            mb.close();
                                        }
                                    }
                                }
                            };

                            t.schedule(1000);
                            //model.getEve_nr_id();
                        } catch (Exception ex) {
                        }
                    }
                });
                b.setEnabled(model.getModificado());
                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Exportar Evento");
                b.setIcon(ICONS.exportation());
                return b;
            }
        };
    }

    private GridCellRenderer<Eve_eventoTGWT> getBtnOndasRender() {
        return new GridCellRenderer<Eve_eventoTGWT>() {

            private boolean init;

            public Object render(final Eve_eventoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Eve_eventoTGWT> store, Grid<Eve_eventoTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Eve_eventoTGWT>>() {

                        public void handleEvent(GridEvent<Eve_eventoTGWT> be) {
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
                        // Exportar Evento
                        Ond_ondaConsultGWT ondConsult = new Ond_ondaConsultGWT();
                        ondConsult.setEve_eventoTGWT(model);

                        ondConsult.load();

                    }
                });
                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Exibir ondas.");
                b.setIcon(ICONS.ondas());
                return b;
            }
        };
    }

    private GridCellRenderer<Eve_eventoTGWT> getBtnImportarRender() {
        return new GridCellRenderer<Eve_eventoTGWT>() {

            private boolean init;

            public Object render(final Eve_eventoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Eve_eventoTGWT> store, Grid<Eve_eventoTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Eve_eventoTGWT>>() {

                        public void handleEvent(GridEvent<Eve_eventoTGWT> be) {
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
                        // Importar Evento
                        ImportarEvento importar = new ImportarEvento();
                        importar.setEve_eventoTGWT(model);
                        importar.show();
                    }
                });
                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Importar Evento");
                b.setIcon(ICONS.importation());
                return b;
            }
        };
    }

    private GridCellRenderer<Eve_eventoTGWT> getBtnProdutoRender() {
        return new GridCellRenderer<Eve_eventoTGWT>() {

            private boolean init;

            public Object render(final Eve_eventoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Eve_eventoTGWT> store, Grid<Eve_eventoTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Eve_eventoTGWT>>() {

                        public void handleEvent(GridEvent<Eve_eventoTGWT> be) {
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
                        // Exibir os produtos do evento e suas imagens
                        ProdutosEventoGWT produtosEvento = new ProdutosEventoGWT();
                        produtosEvento.setEve_eventoTGWT(model);
                        produtosEvento.load();
                    }
                });
                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Produtos do Evento");
                b.setIcon(ICONS.list());
                return b;
            }
        };

    }

    private GridCellRenderer<Eve_eventoTGWT> getBtnEditRender() {
        return new GridCellRenderer<Eve_eventoTGWT>() {

            private boolean init;

            public Object render(final Eve_eventoTGWT model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<Eve_eventoTGWT> store, Grid<Eve_eventoTGWT> grid) {
                if (!init) {
                    init = true;
                    grid.addListener(Events.ColumnResize, new Listener<GridEvent<Eve_eventoTGWT>>() {

                        public void handleEvent(GridEvent<Eve_eventoTGWT> be) {
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
                        Eve_eventoUpdateDeleteGWT eve_eventoUpdateDeleteGWT = new Eve_eventoUpdateDeleteGWT();
                        eve_eventoUpdateDeleteGWT.load(model);
                        eve_eventoUpdateDeleteGWT.setEveConsult(eveConsult);
                        eve_eventoUpdateDeleteGWT.show();
                    }
                });
                b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
                b.setToolTip("Editar Evento");
                b.setIcon(ICONS.edit());
                return b;
            }
        };

    }

    public void load() {
        gerando = false;
        Eve_eventoTGWT eveT = new Eve_eventoTGWT();
        eveT.setEve_tx_nome(tfFind.getValue());
        eveDao.consultarPorNome(eveT);
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Eve_eventoTGWT> list = eveDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    removeAll();
                    ColumnModel cm = new ColumnModel(configs);

                    Grid<Eve_eventoTGWT> grid = new Grid<Eve_eventoTGWT>(list, cm);
                    grid.setLoadMask(true);

                    grid.setStyleAttribute("borderTop", "none");
                    grid.setBorders(true);
                    add(grid);
                    layout();
                }
            }
        };
        timer.schedule(500);
        //EasyAccessURL eaurl = new EasyAccessURL(this);
        //eaurl.accessJSon(Constantes.URL + PAGE); //"portalgwt/exemplos/gridexemplo.jsp");
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;

        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

            JSONArray resultado = jsonObject.get("resultado").isArray();
            removeAll();
            ListStore<Eve_eventoTGWT> store = new ListStore<Eve_eventoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Eve_eventoTGWT eve_eventoTGWT = new Eve_eventoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer eve_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("eve_nr_id").toString()));
                eve_eventoTGWT.setEve_nr_id(eve_nr_id);

                String eve_tx_nome = EasyContainer.clearAspas(registro.get("eve_tx_nome").toString());
                eve_eventoTGWT.setEve_tx_nome(eve_tx_nome);

                DateTimeFormat dtf2 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date eve_dt_inicio = dtf2.parse(EasyContainer.clearAspas(registro.get("eve_dt_inicio").toString()));
                eve_eventoTGWT.setEve_dt_inicio(eve_dt_inicio);

                DateTimeFormat dtf3 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date eve_dt_fim = dtf3.parse(EasyContainer.clearAspas(registro.get("eve_dt_fim").toString()));
                eve_eventoTGWT.setEve_dt_fim(eve_dt_fim);

                DateTimeFormat dtf4 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date eve_dt_criacao = dtf4.parse(EasyContainer.clearAspas(registro.get("eve_dt_criacao").toString()));
                eve_eventoTGWT.setEve_dt_criacao(eve_dt_criacao);

                String modificado = EasyContainer.clearAspas(registro.get("modificado").toString());
                eve_eventoTGWT.setModificado("S".equals(modificado));


                store.add(eve_eventoTGWT);
            }
            ColumnModel cm = new ColumnModel(configs);

            Grid<Eve_eventoTGWT> grid = new Grid<Eve_eventoTGWT>(store, cm);
            grid.setLoadMask(true);

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);
            //grid.addListener(Events, null);
            add(grid);
            layout();
        }
    }
}

class KeyEventoEve extends KeyListener {

    private Eve_eventoConsultGWT eve_eventoConsultGWT;

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
            eve_eventoConsultGWT.load();
        }
    }

    /**
     * @return the sel_seloConsultGWT
     */
    public Eve_eventoConsultGWT getEve_eventoConsultGWT() {
        return eve_eventoConsultGWT;
    }

    /**
     * @param sel_seloConsultGWT the sel_seloConsultGWT to set
     */
    public void setEve_eventoGWT(Eve_eventoConsultGWT eve_eventoConsultGWT) {
        this.eve_eventoConsultGWT = eve_eventoConsultGWT;
    }
}
