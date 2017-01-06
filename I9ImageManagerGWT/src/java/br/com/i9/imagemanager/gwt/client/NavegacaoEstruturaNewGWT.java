/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client;

import br.com.i9.imagemanager.gwt.client.dao.Set_setorNewDAOGWT;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.easynet.bo.Gru_grupoConsultGWT;
import br.com.i9.imagemanager.gwt.client.easynet.bo.Ses_sessaoConsultGWT;
import br.com.i9.imagemanager.gwt.client.easynet.bo.Set_setorConsultGWT;
import br.com.i9.imagemanager.gwt.client.icons.ExampleIcons;
import br.com.i9.imagemanager.gwt.client.model.Folder;
import br.com.i9.imagemanager.gwt.client.set_setorNew.SetorTree;
import br.com.i9.imagemanager.gwt.client.transfer.Gru_grupoTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Ses_sessaoTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Set_setorNewTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Set_setorTGWT;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.data.BaseTreeLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelIconProvider;
import com.extjs.gxt.ui.client.data.TreeLoader;
import com.extjs.gxt.ui.client.data.TreeModel;
import com.extjs.gxt.ui.client.data.TreeModelReader;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.TreePanelEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.StoreFilterField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author geoleite
 */
public class NavegacaoEstruturaNewGWT extends ContentPanel implements IListenetResponse, Listener<ButtonEvent> {

    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private Set_setorNewDAOGWT set_setorDao = new Set_setorNewDAOGWT();
    private HashMap<Integer, Set_setorNewTGWT> setMap = new HashMap<Integer, Set_setorNewTGWT>();
    private TreePanel<SetorTree> treeSetor;
    private TreeStore<SetorTree> treeStore;
    private List<Set_setorNewTGWT> listSet;
    private Timer timer;
    private PrincipalGWT principalGWT;
    private TabItem ti = new TabItem("Produtos e Imagens");
    private ContentPanel cpAccording = new ContentPanel();
    private ContentPanel cpSearch = new ContentPanel();
    private ContentPanel cpSearchSetor = new ContentPanel();
    private ContentPanel cpCategoria = new ContentPanel();
    //private LabelField lfPesquisar = new LabelField("Produto:");
    private TextField<String> tfProduto = new TextField<String>();
    private Button btnPesquisar = new Button("");
    // deve ser utilizado um único panel para os produtos
    private static ProdutosPanel produtosPanel = new ProdutosPanel();
    private RadioGroup rgTipoPesquisa = new RadioGroup();
    private Radio rImagem = new Radio();
    private Radio rSemImagem = new Radio();
    private Radio rTodos = new Radio();

    public NavegacaoEstruturaNewGWT() {
        try {
            rTodos.setValue(true);
            rImagem.setTitle("Pesquisar apenas produtos que contenham imagens.");
            rImagem.setBoxLabel("Com Img");
            rSemImagem.setTitle("Pesquisar produtos que não contenham imagens.");
            rSemImagem.setBoxLabel("Sem Img");
            rTodos.setTitle("Pesquisar todos os produtos.");
            rTodos.setBoxLabel("Todos");
            rgTipoPesquisa.add(rImagem);
            rgTipoPesquisa.add(rSemImagem);
            rgTipoPesquisa.add(rTodos);
            setTopComponent(rgTipoPesquisa);
            setBorders(false);
            setHeaderVisible(false);
            ti.setClosable(true);
            ti.setBorders(false);
            ti.setLayout(new FillLayout());
            setLayout(new FillLayout());
            //ti.add(produtosPanel);
            //cpAccording.setLayout(new AccordionLayout());
            TableLayout tlPrincipal = new TableLayout(1);
            tlPrincipal.setCellSpacing(5);
            cpAccording.setLayout(tlPrincipal);
            cpAccording.setBorders(false);
            cpAccording.setHeaderVisible(false);
            cpSearch.setHeading("Pesquisar Produto");
            cpSearch.setIcon(ICONS.filter());
            cpSearch.setWidth(260);

            cpSearchSetor.setHeading("Pesquisar Estrutura");
            cpSearchSetor.setIcon(ICONS.filter());
            cpSearchSetor.setWidth(260);

            cpCategoria.setWidth(260);
            cpCategoria.setHeading("Estrutura Setores");
            cpSearch.setAnimCollapse(true);
            cpSearch.setCollapsible(false);

            cpSearchSetor.setAnimCollapse(true);
            cpSearchSetor.setCollapsible(false);

            cpCategoria.setCollapsible(false);
            cpCategoria.setAnimCollapse(true);
            cpAccording.add(cpSearch);
            cpAccording.add(cpSearchSetor);
            cpAccording.add(cpCategoria);
            TableLayout tl = new TableLayout(1);
            tl.setBorder(0);
            tl.setCellPadding(10);
            cpSearch.setLayout(tl);

            cpSearchSetor.setLayout(new FillLayout());

            cpCategoria.setLayout(new FillLayout());
            //cpCategoria.setLayout(new RowLayout(Orientation.VERTICAL));
            defineSearch();
            // Espera carregar os dados ses_sessao do servidor
            add(cpAccording);

            KeyListener keyListener = new KeyListener() {

                public void componentKeyPress(ComponentEvent event) {
                    int keyCode = event.getKeyCode();
                    if (keyCode == 13) {
                        if (rgTipoPesquisa.getValue() == rImagem) {
                            pesquisarDescricaoCodigoImagem();
                        } else if (rgTipoPesquisa.getValue() == rSemImagem) {
                            pesquisarDescricaoCodigoSemImagem();
                        } else {
                            pesquisarDescricaoCodigo();
                        }
                    }
                }
            };
            tfProduto.addKeyListener(keyListener);
        } catch (Exception ex) {
        }
        load();
    }

    private void montaTree(SetorTree setor) {
        List<Set_setorNewTGWT> filhos = getFilhos(setor.getId());
        for (Set_setorNewTGWT setT : filhos) {
            SetorTree newSetor = new SetorTree(setT.getSet_nr_id(), setT.getSet_tx_nome(), "");
            setor.add(newSetor);
            montaTree(newSetor);
        }
    }

    private List<Set_setorNewTGWT> getFilhos(int setNrId) {
        List<Set_setorNewTGWT> filhos = new ArrayList<Set_setorNewTGWT>();
        for (Set_setorNewTGWT set_setorTGWT : listSet) {
            if (set_setorTGWT.getSet_nr_idsetorpai() == setNrId) {
                filhos.add(set_setorTGWT);
            }
        }
        return filhos;
    }

    public void load() {
        set_setorDao.consultarTodos();
        Timer timer = new Timer() {

            @Override
            public void run() {
                //getCpMaster().removeAll();
                ListStore<Set_setorNewTGWT> list = set_setorDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    listSet = new ArrayList<Set_setorNewTGWT>();
                    for (int i = 0; i < list.getCount(); i++) {
                        Set_setorNewTGWT setT = list.getAt(i);
                        listSet.add(setT);
                        setMap.put(setT.getSet_nr_id(), setT);
                    }
                    SetorTree root = new SetorTree(Util.getCodigoSetorRaiz(listSet), "", "");
                    montaTree(root);
                    TreeLoader<SetorTree> loader = new BaseTreeLoader<SetorTree>(new TreeModelReader<List<SetorTree>>());
                    treeStore = new TreeStore<SetorTree>(loader);
                    treeSetor = new TreePanel<SetorTree>(treeStore);
                    treeSetor.setStateful(true);
                    treeSetor.setAutoLoad(true);
                    treeSetor.setDisplayProperty("name");
                    treeSetor.addListener(Events.OnClick, new Listener<TreePanelEvent>() {

                        public void handleEvent(TreePanelEvent event) {
                            selecionarSetor(event);
                        }
                    });

                    treeSetor.setIconProvider(new ModelIconProvider<SetorTree>() {

                        public AbstractImagePrototype getIcon(SetorTree model) {
                            if (model.isLeaf()) {
                                //return ICONS.plugin();
                                return ICONS.tick();
                            }
                            return null;//ICONS.f
                        }
                    });
                    loader.load(root);
                    //definirMenuSuspenso();
                    //getCpMaster().add(treeSetor);
                    StoreFilterField<SetorTree> filter = new StoreFilterField<SetorTree>() {

                        @Override
                        protected boolean doSelect(Store<SetorTree> store, SetorTree parent,
                                SetorTree record, String property, String filter) {
                            String name = record.getName();
                            name = name.toLowerCase();
                            if (name.startsWith(filter.toLowerCase())) {
                                return true;
                            }
                            return false;
                        }
                    };

                    filter.bind(treeStore);

                    cpSearchSetor.add(filter);

                    ContentPanel cp = new ContentPanel(new FitLayout());
                    cp.setHeaderVisible(false);
                    cp.setBodyBorder(false);
                    cp.add(treeSetor);
                    cpCategoria.add(cp);
                    //cpCategoria.add(defineSearchSessao(filter));
                    //cpCategoria.add(treeSetor);
                    cpCategoria.setHeight(PrincipalGWT.height_size - 230);
                    cpCategoria.setScrollMode(Scroll.AUTOY);
                    cpCategoria.setBorders(false);
                    cpCategoria.setFrame(false);
                    cpCategoria.setBodyBorder(false);

                    //mb.close();
                    // Refazer o render
                    cpCategoria.layout();
                    //getCpMaster().layout();
                    //treeSetor.expandAll();
                }
            }
        };

        timer.schedule(500);
    }

    private void defineSearch() {
        tfProduto.setTitle("Pesquisa em todos os produtos pela descricao ou pelo codigo.");
        cpSearch.setTopComponent(tfProduto);
    }

    /**
     * Monta a estrutura do Tree
     * @param listSes
     * @param listGru
     *
    private void montarTree(ListStore<Set_setorTGWT> listSet, ListStore<Ses_sessaoTGWT> listSes, ListStore<Gru_grupoTGWT> listGru) {
    Folder root = new Folder();
    setTreeMap = new TreeMap<Integer, Folder>();
    sesTreeMap = new TreeMap<Integer, Folder>();

    // Monta o primeiro niveos com os setores
    for (int i = 0; i < listSet.getCount(); i++) {
    Set_setorTGWT setT = listSet.getAt(i);
    Folder folder = new Folder(setT.getSet_nr_id(), setT.getSet_tx_nome(), "setor");
    root.add(folder);
    setTreeMap.put(setT.getSet_nr_id(), folder);
    setMap.put(setT.getSet_nr_id(), setT);
    }


    for (int i = 0; i < listSes.getCount(); i++) {
    Ses_sessaoTGWT sesT = listSes.getAt(i);
    Folder folderSes = new Folder(sesT.getSes_nr_id(), sesT.getSes_tx_nome(), "sessao");
    Folder folderSetor = setTreeMap.get(sesT.getSet_nr_id());
    folderSetor.add(folderSes);
    //root.add(folder);
    sesTreeMap.put(sesT.getSes_nr_id(), folderSes);
    sesMap.put(sesT.getSes_nr_id(), sesT);
    }

    for (int i = 0; i < listGru.getCount(); i++) {
    Gru_grupoTGWT gruT = listGru.getAt(i);
    Folder folderGru = new Folder(gruT.getGru_nr_id(), gruT.getGru_tx_nome(), "grupo");
    gruMap.put(gruT.getGru_nr_id(), gruT);
    Folder folder = sesTreeMap.get(gruT.getSes_nr_id());
    folder.add(folderGru);
    // Definindo os eventos na lista do grupo
    //folder.addChangeListener(this);
    }

    montarTreePanel(root);
    }
     */
    /**
     * Monta as sessoes no componente Tree
     * @param listSes
     *
    private void montarTreePanel(Folder root) {
    //MessageBox mb = MessageBox.wait("Carrgando Tree", "Montando Tree", "aguarde enquanto monta o Tree");
    TreeLoader<ModelData> loader = new BaseTreeLoader<ModelData>(
    new TreeModelReader<List<ModelData>>());

    TreeStore<ModelData> store = new TreeStore<ModelData>(loader);

    TreePanel<ModelData> tree = new TreePanel<ModelData>(store);

    tree.setStateful(true);
    tree.setAutoLoad(true);
    tree.setDisplayProperty("name");
    //tree.setWidth(230);
    tree.addListener(Events.OnClick, new Listener<TreePanelEvent>() {

    public void handleEvent(TreePanelEvent event) {
    selecionarGrupo(event);
    }
    });
    tree.setIconProvider(new ModelIconProvider<ModelData>() {

    public AbstractImagePrototype getIcon(ModelData model) {
    if (((TreeModel) model).isLeaf()) {
    //return ICONS.plugin();
    return ICONS.filter();
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

    String name = record.get("name");
    name = name.toLowerCase();
    if (name.startsWith(filter.toLowerCase())) {
    return true;
    }
    return false;
    }
    };

    filter.bind(store);

    cpCategoria.setHeight(PrincipalGWT.height_size - 130);
    cpCategoria.setScrollMode(Scroll.NONE);
    //cpCategoria.setLayout(new FillLayout());
    cpCategoria.setBorders(false);
    cpCategoria.setFrame(false);
    cpCategoria.setBodyBorder(false);
    cpCategoria.setLayout(new TableLayout(1));


    ContentPanel container = new ContentPanel();
    container.setLayout(new FillLayout());
    container.setBorders(false);
    container.setBodyBorder(false);
    container.setFrame(false);
    container.add(tree);
    container.setHeaderVisible(false);
    container.setScrollMode(Scroll.AUTO);
    container.setHeight(cpCategoria.getHeight() - 50);
    container.setWidth(250);
    //container.setWidth("100%");


    cpCategoria.add(defineSearchSessao(filter));
    cpCategoria.add(container);
    //mb.close();
    // Refazer o render
    cpCategoria.layout();
    layout();

    }
     */
    private ContentPanel defineSearchSessao(StoreFilterField<SetorTree> filter) {
        ContentPanel cp = new ContentPanel(new FillLayout());
        cp.setHeaderVisible(false);
        cp.setBorders(false);
        cp.setFrame(false);
        cp.add(filter);
        cp.setFrame(false);
        cp.layout();
        return cp;
    }

    /**
     * Obrém o tree selecionado
     * @param event
     */
    private void selecionarSetor(TreePanelEvent<SetorTree> event) {
        SetorTree setor = event.getItem();
        if (setor.getChildCount() == 0) {
            ti.removeAll();
            produtosPanel = new ProdutosPanel();
            produtosPanel.setPrincipalGWT(principalGWT);
            produtosPanel.setIdSetor((Integer) setor.getParent().get("id"));


            if (rgTipoPesquisa.getValue() == rImagem) {
                produtosPanel.consultarDadosImagem();
            } else if (rgTipoPesquisa.getValue() == rSemImagem) {
                produtosPanel.consultarDadosSemImagem();
            } else {
                produtosPanel.consultarDados();
            }

            ti.add(produtosPanel);
            //ti.setScrollMode(Scroll.AUTO);


            ti.setAutoHeight(true);

            principalGWT.getTabPanelPrincipal().add(ti);
            principalGWT.getTabPanelPrincipal().setSelection(ti);
            produtosPanel.layout();
            principalGWT.layout();
        }

    }

    public void read(JSONValue jsonValue) {
    }

    /**
     * @return the principalGWT
     */
    public PrincipalGWT getPrincipalGWT() {
        return principalGWT;


    }

    /**
     * @param principalGWT the principalGWT to set
     */
    public void setPrincipalGWT(PrincipalGWT principalGWT) {
        this.principalGWT = principalGWT;


    }

    private void pesquisarDescricaoCodigo() {
        if (tfProduto.getValue().trim().length() > 0) {
            ti.removeAll();
            produtosPanel = new ProdutosPanel();
            produtosPanel.setPrincipalGWT(principalGWT);
            //produtosPanel.setIdSessao((Integer) folder.getParent().get("id"));
            //produtosPanel.setIdGrupo(folder.getId());
            produtosPanel.setTexto(tfProduto.getValue());
            produtosPanel.consultarDadosTexto();
            ti.add(produtosPanel);
            //ti.setScrollMode(Scroll.AUTO);

            //ti.setAutoHeight(true);
            principalGWT.getTabPanelPrincipal().add(ti);
            principalGWT.getTabPanelPrincipal().setSelection(ti);
            produtosPanel.layout();
            principalGWT.layout();


        }
    }

    private void pesquisarDescricaoCodigoImagem() {
        if (tfProduto.getValue().trim().length() > 0) {
            ti.removeAll();
            produtosPanel = new ProdutosPanel();
            produtosPanel.setPrincipalGWT(principalGWT);
            //produtosPanel.setIdSessao((Integer) folder.getParent().get("id"));
            //produtosPanel.setIdGrupo(folder.getId());
            produtosPanel.setTexto(tfProduto.getValue());
            produtosPanel.consultarDadosTextoImagem();
            ti.add(produtosPanel);
            //ti.setScrollMode(Scroll.AUTO);

            //ti.setAutoHeight(true);
            principalGWT.getTabPanelPrincipal().add(ti);
            principalGWT.getTabPanelPrincipal().setSelection(ti);
            produtosPanel.layout();
            principalGWT.layout();


        }
    }

    private void pesquisarDescricaoCodigoSemImagem() {
        if (tfProduto.getValue().trim().length() > 0) {
            ti.removeAll();
            produtosPanel = new ProdutosPanel();
            produtosPanel.setPrincipalGWT(principalGWT);
            //produtosPanel.setIdSessao((Integer) folder.getParent().get("id"));
            //produtosPanel.setIdGrupo(folder.getId());
            produtosPanel.setTexto(tfProduto.getValue());
            produtosPanel.consultarDadosTextoSemImagem();
            ti.add(produtosPanel);
            //ti.setScrollMode(Scroll.AUTO);

            //ti.setAutoHeight(true);
            principalGWT.getTabPanelPrincipal().add(ti);
            principalGWT.getTabPanelPrincipal().setSelection(ti);
            produtosPanel.layout();
            principalGWT.layout();


        }
    }

    public void handleEvent(ButtonEvent be) {
        if (be.getSource() == btnPesquisar) {

            pesquisarDescricaoCodigo();

        }
    }
}
