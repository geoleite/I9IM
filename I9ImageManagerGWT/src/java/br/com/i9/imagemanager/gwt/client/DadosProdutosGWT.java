/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client;

import br.com.i9.imagemanager.gwt.client.easynet.bo.Pro_produtoConsultGWT;
import br.com.i9.imagemanager.gwt.client.icons.ExampleIcons;
import br.com.i9.imagemanager.gwt.client.model.Folder;
import br.com.i9.imagemanager.gwt.client.transfer.Pro_produtoTGWT;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.BaseTreeLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelIconProvider;
import com.extjs.gxt.ui.client.data.TreeLoader;
import com.extjs.gxt.ui.client.data.TreeModel;
import com.extjs.gxt.ui.client.data.TreeModelReader;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.TreePanelEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.form.StoreFilterField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class DadosProdutosGWT extends ContentPanel implements Listener<ButtonEvent> {

    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private int idSetor;
    private Pro_produtoConsultGWT proConsult = new Pro_produtoConsultGWT();
    private Timer timer;
    private TextField<String> tfPesquisar = new TextField<String>();
    //private Text lbPesq = new Text("Produto:");
    //private Button btnPesquisar = new Button("Pesq.");
    private ListView<Pro_produtoTGWT> list;
    private ContentPanel cpFiltroServidor = new ContentPanel();
    private ProdutosPanel produtosPanel;
    private String texto;

//    private ListView<Pro_produtoTGWT> listProduto;
    public DadosProdutosGWT() {
        list = new ListView<Pro_produtoTGWT>();
        setHeaderVisible(false);
        setBorders(false);
        setWidth("100%");
        //setHeight(380);
        setScrollMode(Scroll.ALWAYS);
        cpFiltroServidor.setLayout(new RowLayout(Orientation.HORIZONTAL));
        cpFiltroServidor.setHeaderVisible(false);
        cpFiltroServidor.setBorders(false);
        cpFiltroServidor.setWidth("100%");

        tfPesquisar.setWidth("100%");
        
        tfPesquisar.setTitle("Pesquisa produtos da categoria pela descricao ou pelo codigo.");
        cpFiltroServidor.setTopComponent(tfPesquisar);

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
                //Info.display("Debug", event.getKeyCode() + "");
                if (event.getKeyCode() == 13) {
                    proConsult.consultarDescricao(idSetor, tfPesquisar.getValue());
                    waitLoad();
                }
            }
        });
    }

    private void waitLoad() {
        timer = new Timer() {

            @Override
            public void run() {
                ListStore<Pro_produtoTGWT> listPro = proConsult.getStore();
                if (listPro == null) {
                    timer.schedule(500);
                } else {
                    // Encontrou os dados

                    //listProduto = new ListView<Pro_produtoTGWT>(listPro);
                    //listProduto.setDisplayProperty("pro_tx_nome");
                    //add(listProduto);
                    /*
                    Folder root = new Folder();

                    for (int i = 0; i < listPro.getCount(); i++) {
                    Pro_produtoTGWT proT = listPro.getAt(i);
                    Folder folder = new Folder(proT.getPro_nr_id(), proT.getPro_tx_nome(), "produto");
                    root.add(folder);
                    }
                     *
                     */
                    removeAll();
                    //montarTreePanel(root);
                    montaList(listPro);

                    layout();
                }
            }
        };
        timer.schedule(500);
    }

    public void consultar() {

        proConsult.consultarSessaoGrupo(idSetor);

        waitLoad();
    }

    public void consultarImagem() {

        proConsult.consultarSessaoGrupoImagem(idSetor);

        waitLoad();
    }

    public void consultarSemImagem() {

        proConsult.consultarSessaoGrupoSemImagem(idSetor);

        waitLoad();
    }


    public void consultarTexto() {

        proConsult.consultarDescricaoCodigo(texto);

        waitLoad();
    }

    public void consultarTextoImagem() {

        proConsult.consultarDescricaoCodigoImagem(texto);

        waitLoad();
    }

    public void consultarTextoSemImagem() {

        proConsult.consultarDescricaoCodigoSemImagem(texto);

        waitLoad();
    }

    private void montaList(ListStore<Pro_produtoTGWT> listPro) {


        list.setStore(listPro);
        list.setDisplayProperty("pro_tx_nome");
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        list.getSelectionModel().addListener(Events.SelectionChange, new Listener<SelectionChangedEvent<Pro_produtoTGWT>>() {

            public void handleEvent(SelectionChangedEvent<Pro_produtoTGWT> be) {
                Pro_produtoTGWT proT = be.getSelectedItem();
                DadosImagemGWT dadosImagemGWT = new DadosImagemGWT();
                dadosImagemGWT.setPro_produtoTGWT(proT);
                produtosPanel.setImagens(dadosImagemGWT);
                layout();
            }
        });
        add(cpFiltroServidor);
        //add(filtro);
        add(list);
        if (proConsult.getCount() > 200) {
            MessageBox.alert("Quantidade de Produtos",
                    "Há produtos que não aparecerão na lista devido ao número superior a 200 ítens. é necessário refinar a busca.", null);
        }
        layout();
    }

    private void montarTreePanel(Folder root) {
        TreeLoader<ModelData> loader = new BaseTreeLoader<ModelData>(
                new TreeModelReader<List<? extends ModelData>>());

        TreeStore<ModelData> store = new TreeStore<ModelData>(loader);

        TreePanel<ModelData> tree = new TreePanel<ModelData>(store);
        tree.setAutoLoad(true);
        tree.setDisplayProperty("name");
        tree.setWidth(250);
        tree.addListener(Events.OnClick, new Listener<TreePanelEvent>() {

            public void handleEvent(TreePanelEvent event) {
                //selecionarGrupo(event);
            }
        });
        tree.setIconProvider(new ModelIconProvider<ModelData>() {

            public AbstractImagePrototype getIcon(ModelData model) {
                if (((TreeModel) model).isLeaf()) {
                    return ICONS.menu_show();
                }
                return null;
            }
        });


        loader.load(root);

        StoreFilterField<ModelData> filter = new StoreFilterField<ModelData>() {

            @Override
            protected boolean doSelect(Store<ModelData> store, ModelData parent,
                    ModelData record, String property, String filter) {
                // only match leaf nodes

                /*
                if (record instanceof Folder) {
                return false;
                }
                 */
                String name = record.get("name");
                name = name.toLowerCase();
                //if (name.startsWith(filter.toLowerCase())) {
                if (name.indexOf(filter.toLowerCase()) > -1) {
                    return true;
                }
                return false;
            }
        };

        filter.bind(store);

        VerticalPanel panel = new VerticalPanel();
        panel.addStyleName("x-small-editor");
        panel.setSpacing(8);

        //panel.add(new Html("<span class=text>Enter a search string such as 'vio'</span>"));
        panel.add(filter);
        panel.add(tree);

        add(panel);
        if (proConsult.getCount() > 200) {
            MessageBox.alert("Quantidade de Produtos",
                    "Há produtos que não aparecerão na lista devido ao número superior a 200 ítens. é necessário refinar a busca.", null);
        }
        // Refazer o render
        layout();

    }

    

    /**
     * Pesquisar pelo Texto do produtno
     * @param be
     */
    public void handleEvent(ButtonEvent be) {
        proConsult.consultarDescricao(idSetor, tfPesquisar.getValue());

        waitLoad();
    }

    /**
     * @return the produtosPanel
     */
    public ProdutosPanel getProdutosPanel() {
        return produtosPanel;
    }

    /**
     * @param produtosPanel the produtosPanel to set
     */
    public void setProdutosPanel(ProdutosPanel produtosPanel) {
        this.produtosPanel = produtosPanel;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the idSetor
     */
    public int getIdSetor() {
        return idSetor;
    }

    /**
     * @param idSetor the idSetor to set
     */
    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }
}
