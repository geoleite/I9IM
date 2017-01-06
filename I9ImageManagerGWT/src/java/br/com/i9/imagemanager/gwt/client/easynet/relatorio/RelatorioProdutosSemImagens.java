/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.easynet.relatorio;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.PrincipalGWT;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.easynet.bo.Cla_classificacaoConsultGWT;
import br.com.i9.imagemanager.gwt.client.icons.ExampleIcons;
import br.com.i9.imagemanager.gwt.client.transfer.Cla_classificacaoTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Pro_produtoTGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.BoxLayout;
import com.extjs.gxt.ui.client.widget.layout.CardLayout;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class RelatorioProdutosSemImagens extends ContentPanel implements IListenetResponse, Listener<ButtonEvent> {

    public static final String PAGE = "i9im/i9im/pro_produto/pro_produtoConsultGWT.jsp";
    private Cla_classificacaoConsultGWT claConsult = new Cla_classificacaoConsultGWT();
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    private Grid<Pro_produtoTGWT> grid;
    private Button btnPesquisar = new Button("Pesquisar");
    private ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private final ComboBox<Cla_classificacaoTGWT> comboCla = new ComboBox<Cla_classificacaoTGWT>();
    private ListStore<Cla_classificacaoTGWT> listCla;
    private ContentPanel north = new ContentPanel();
    private ContentPanel center = new ContentPanel();
    private HashMap<String, Cla_classificacaoTGWT> dadosCla = new HashMap<String, Cla_classificacaoTGWT>();

    public RelatorioProdutosSemImagens() {
        setBorders(false);
        setHeaderVisible(false);
        setWidth("100%");
        setLayout(new BorderLayout());

        BorderLayoutData northData = new BorderLayoutData(LayoutRegion.NORTH, 40);
        northData.setCollapsible(true);
        northData.setFloatable(true);
        northData.setHideCollapseTool(true);
        northData.setSplit(true);
        northData.setMargins(new Margins(0, 0, 5, 0));

        BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);
        centerData.setMargins(new Margins(0));

        north.setLayout(new FillLayout());
        center.setLayout(new FillLayout());
        add(north, northData);
        add(center, centerData);

        //adicionando o tree na janela principal
        north.setHeaderVisible(false);
        north.setBorders(false);
        center.setHeaderVisible(false);
        center.setBorders(false);

        
        Timer timer = new Timer() {

            public void run() {
                listCla = claConsult.getStore();
                if (listCla == null) {
                    schedule(500);
                } else {
                    camposFiltro();
                    layout();
                }
            }
        };
        timer.schedule(500);



    }

    private void camposFiltro() {
        comboCla.setFieldLabel("Classificacão");
        comboCla.setForceSelection(true);
        comboCla.setName("cla_classificacaoT.cla_tx_tipo");
        comboCla.setEmptyText("Selecione a classificacão...");
        comboCla.setDisplayField("cla_tx_tipo");
        comboCla.setValueField("cla_tx_tipo");
        //comboCla.set
        comboCla.setWidth(150);
        comboCla.setStore(listCla);
        comboCla.setTypeAhead(true);
        comboCla.setTriggerAction(ComboBox.TriggerAction.ALL);

        /*
        for (int i = 0; i < listCla.getCount(); i++) {
            Cla_classificacaoTGWT claT = listCla.getAt(i);
            dadosCla.put(claT.getCla_tx_tipo(), claT);
        }
         
         */

        ContentPanel cpFiltro = new ContentPanel(new RowLayout(Orientation.HORIZONTAL));
        
        cpFiltro.setWidth("100%");
        cpFiltro.setBorders(false);
        cpFiltro.setHeaderVisible(false);
        cpFiltro.add(new LabelField("Classificacao:"));

        cpFiltro.add(comboCla);
        btnPesquisar.addListener(Events.OnClick, this);
        cpFiltro.add(btnPesquisar);
        north.add(cpFiltro);

    }

    public void load() {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consultProdutosSemImagens");
            
            String codigoCla = comboCla.getValue().getCla_nr_id() + "";//dadosCla.get(comboCla.getDisplayField()).getCla_nr_id() + "";

            param.put("cla_classificacaoT.cla_nr_id", codigoCla);
            
            eaurl.accessJSonMap(Constantes.URL + PAGE, param);//"portalgwt/exemplos/gridexemplo.jsp");
        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(jsonValue + "");
            JSONArray resultado = jsonObject.get("resultado").isArray();

            ListStore<Pro_produtoTGWT> store = new ListStore<Pro_produtoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Pro_produtoTGWT pro_produtoTGWT = new Pro_produtoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer pro_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("pro_nr_id").toString()));
                pro_produtoTGWT.setPro_nr_id(pro_nr_id);

                String pro_tx_nome = EasyContainer.clearAspas(registro.get("pro_tx_nome").toString());
                pro_produtoTGWT.setPro_tx_nome(pro_tx_nome);

                Integer pro_nr_cdfamilia = Integer.parseInt(EasyContainer.clearAspas(registro.get("pro_nr_cdfamilia").toString()));
                pro_produtoTGWT.setPro_nr_cdfamilia(pro_nr_cdfamilia);

                DateTimeFormat dtf3 = DateTimeFormat.getFormat("dd/MM/yyyy");
                Date pro_dt_atualizacao = dtf3.parse(EasyContainer.clearAspas(registro.get("pro_dt_atualizacao").toString()));
                pro_produtoTGWT.setPro_dt_atualizacao(pro_dt_atualizacao);

                float pro_nr_valor = Float.parseFloat(EasyContainer.clearAspas(registro.get("pro_nr_valor").toString()));
                pro_produtoTGWT.setPro_nr_valor(pro_nr_valor);

                String pro_tx_situacao = EasyContainer.clearAspas(registro.get("pro_tx_situacao").toString());
                pro_produtoTGWT.setPro_tx_situacao(pro_tx_situacao);

                Integer ses_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("set_nr_id").toString()));
                pro_produtoTGWT.setSet_nr_id(ses_nr_id);

                String pro_tx_obs = EasyContainer.clearAspas(registro.get("pro_tx_obs").toString());
                pro_produtoTGWT.setPro_tx_obs(pro_tx_obs);

                String pro_tx_idsap = EasyContainer.clearAspas(registro.get("pro_tx_idsap").toString());
                pro_produtoTGWT.setPro_tx_idsap(pro_tx_idsap);

                store.add(pro_produtoTGWT);
            }


            ColumnModel cm = new ColumnModel(configs);

            if (grid != null) {
                remove(grid);
            }
            grid = new Grid<Pro_produtoTGWT>(store, cm);

            grid.setLoadMask(true);

            grid.setStyleAttribute("borderTop", "none");
//            grid.setAutoExpandColumn("name");
            grid.setBorders(true);


            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            //grid.setSize(, "100%");
            center.add(grid);
            layout();
        }
    }

    /**
     * Realiza a pesquisa após escolher a classificacao da imagem
     * @param be
     */
    public void handleEvent(ButtonEvent be) {
        GridCellRenderer<Pro_produtoTGWT> dtRender = new GridCellRenderer<Pro_produtoTGWT>() {

            public Object render(Pro_produtoTGWT model, String property,
                    ColumnData config, int rowIndex, int colIndex,
                    ListStore<Pro_produtoTGWT> store, Grid<Pro_produtoTGWT> grid) {
                Date dt = (Date) model.get(property);
                return PrincipalGWT.DATE_FORMAT.format(dt);
            }
        };
        GridCellRenderer<Pro_produtoTGWT> statusRender = new GridCellRenderer<Pro_produtoTGWT>() {

            public Object render(Pro_produtoTGWT model, String property,
                    ColumnData config, int rowIndex, int colIndex,
                    ListStore<Pro_produtoTGWT> store, Grid<Pro_produtoTGWT> grid) {

                if ("A".equalsIgnoreCase(""+ model.get(property))) {
                    return "Ativo";
                } else if ("E".equalsIgnoreCase(""+model.get(property))) {
                    return "Excluido";
                } else if ("I".equalsIgnoreCase(""+model.get(property))) {
                    return "Inativo";
                }
                return "";

            }
        };

        ColumnConfig column = null;

        column = new ColumnConfig();
        column.setId("pro_nr_id");
        column.setHeader("Codigo");
        column.setWidth(50);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("pro_tx_nome");
        column.setHeader("Nome");
        column.setWidth(400);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("pro_dt_atualizacao");
        column.setHeader("Data Atualizacao");
        column.setWidth(100);
        column.setRenderer(dtRender);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);

        column = new ColumnConfig();
        column.setId("pro_tx_situacao");
        column.setHeader("Situacao");
        column.setWidth(80);
        column.setRenderer(statusRender);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);



        column = new ColumnConfig();
        column.setId("pro_tx_obs");
        column.setHeader("Obs");
        column.setWidth(400);
        column.setAlignment(HorizontalAlignment.LEFT);
        configs.add(column);
        load();
    }
}
