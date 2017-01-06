    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client;

import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.easynet.eve_evento.Eve_eventoConsultGWT;
import br.com.i9.imagemanager.gwt.client.easynet.eve_evento.Eve_eventoInsertGWT;
import br.com.i9.imagemanager.gwt.client.easynet.relatorio.RelatorioProdutosSemImagens;
import br.com.i9.imagemanager.gwt.client.icons.ExampleIcons;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.menu.SeparatorMenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class PrincipalGWT extends ContentPanel {

    public static final DateTimeFormat DATE_FORMAT = DateTimeFormat.getFormat("dd/MM/yyyy");
    public static  List<String> perfis;
    public static HashMap<String, String> mapPerfis;
    private ContentPanel north = new ContentPanel();
    private ContentPanel west = new ContentPanel();
    private ContentPanel east = new ContentPanel();
    private ContentPanel center = new ContentPanel();
    private ContentPanel south = new ContentPanel();
    public final static ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private TabPanelPrincipal tabPanelPrincipal = new TabPanelPrincipal();
    private Button btnSuporte = new Button("Suporte On-line");
    private Button btnProdutos = new Button("Produtos");
    private Button btnUsuarioLogado = new Button("Usuarios");
    private Button btnUsuarios = new Button("Usuarios");
    private Button btnEventos = new Button("Evento");
    private Button btnRelatorios = new Button("Relatorios");
    private MenuItem miCadastroUsuario = new MenuItem("Cadastrar");
    private MenuItem miNovoEvento = new MenuItem("Novo");
    private MenuItem miListarEvento = new MenuItem("Listar");
    private MenuItem miAlterarUsuario = new MenuItem("Cadastrar");
    private MenuItem miAlterarSenha = new MenuItem("Alterar Senha");
    private MenuItem miSair = new MenuItem("Sair");

    //private MenuItem miImportarEvento = new MenuItem("Importar");
    //private MenuItem miExportarEvento = new MenuItem("Exportar");
    private MenuItem miRelProSemImgBruta = new MenuItem("Produtos Sem Imagens");
    //private MenuItem miRelProSemImgTratada = new MenuItem("Produtos Sem Imagens Tratadas");
    //private TabItem tiEventos = new TabItem("Eventos");
    private TabItem tiRelatorioProdutosSemImagensBrutas = new TabItem("Produtos Sem Imagens Brutas");
    private Eve_eventoInsertGWT eve_eventoInsertGWT = null;
    private Eve_eventoConsultGWT eveConsult = null;
    private RelatorioProdutosSemImagens rpsib = null;
    private String usuarioLogado;
    private List<Button> listMenu;
    private ToolBar toolBar = new ToolBar();
    public static int height_size=0;

    public PrincipalGWT() {
        setHeading("I9 Image Manager - Version 2.0");
        setHeaderVisible(false);
        setScrollMode(Scroll.NONE);
        BorderLayout layout = new BorderLayout();
        //center.setHeading("BorderLayout Example");
        //center.setScrollMode(Scroll.AUTO);
        //west.setScrollMode(Scroll.AUTO);
        setLayout(layout);

        //setStyleAttribute("padding", "10px");


        BorderLayoutData northData = new BorderLayoutData(LayoutRegion.NORTH, 28, 28, 28);
        northData.setCollapsible(true);
        northData.setFloatable(true);
        northData.setHideCollapseTool(true);
        northData.setSplit(true);
        northData.setMargins(new Margins(0, 0, 5, 0));

        BorderLayoutData westData = new BorderLayoutData(LayoutRegion.WEST, 280, 280, 280);
        westData.setSplit(true);
        westData.setCollapsible(true);
        westData.setMargins(new Margins(0, 5, 0, 0));

        BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);
        centerData.setMargins(new Margins(0));

        BorderLayoutData eastData = new BorderLayoutData(LayoutRegion.EAST, 150);
        eastData.setSplit(true);
        eastData.setCollapsible(true);
        eastData.setMargins(new Margins(0, 0, 0, 5));

        BorderLayoutData southData = new BorderLayoutData(LayoutRegion.SOUTH, 100);
        southData.setSplit(true);
        southData.setCollapsible(true);
        southData.setFloatable(true);
        southData.setMargins(new Margins(5, 0, 0, 0));

        north.setHeaderVisible(false);
        add(north, northData);

        //adicionando o tree na janela principal
        center.setHeaderVisible(false);
        west.setHeading("Navegacao");
        west.setHeaderVisible(true);
        west.add(getTreePanel());
        add(west, westData);
        west.setLayout(new FillLayout());
        add(center, centerData);
        center.add(tabPanelPrincipal);
        setWidth("100%");
        height_size = Window.getClientHeight() - 80;
        if (height_size < 570)
            height_size = 575;
        setHeight(height_size);
        tabPanelPrincipal.setHeight(height_size-40);
        Window.setMargin("0");
    }

    private ToolBar getToolBar() {
        final MenuGWT menuGWT = new MenuGWT();
        menuGWT.setPrincipalGWT(this);
        Timer t = new Timer() {

            @Override
            public void run() {
                listMenu = menuGWT.getList();
                if (listMenu == null) {
                    schedule(1000);
                } else {
                    for (int i = 0; i < listMenu.size(); i++) {
                        toolBar.add(listMenu.get(i));
                        //Window.alert(listMenu.get(i).getText() + "");
                    }
                    layout();
                }
            }
        };
        t.schedule(1000);

        SelectionListener eventMenu = new SelectionListener<MenuEvent>() {

            @Override
            public void componentSelected(MenuEvent ce) {
                eventoMenu(ce);
            }
        };

        Menu subMenu = new Menu();
        miAlterarSenha.setIcon(ICONS.chave());
        miSair.setIcon(ICONS.exit());
        subMenu.add(miAlterarSenha);
        SeparatorMenuItem smi = new SeparatorMenuItem();
        subMenu.add(smi);
        subMenu.add(miSair);
        btnUsuarioLogado.setIcon(ICONS.user());
        miAlterarSenha.addSelectionListener(eventMenu);
        miSair.addSelectionListener(eventMenu);
        btnUsuarioLogado.setMenu(subMenu);
        btnUsuarioLogado.setText(usuarioLogado);

        miCadastroUsuario.addSelectionListener(eventMenu);

        btnUsuarios.setIcon(ICONS.user());
/*
        
        subMenu = new Menu();

        miCadastroUsuario.setIcon(ICONS.addUser());
        subMenu.add(miCadastroUsuario);
        miAlterarUsuario = new MenuItem("Alterar");
        miAlterarUsuario.addSelectionListener(eventMenu);
        subMenu.add(miAlterarUsuario);
        miAlterarUsuario.setIcon(ICONS.editUser());
        btnUsuarios.setMenu(subMenu);

        subMenu = new Menu();

        btnEventos.setIcon(ICONS.cog());
        miNovoEvento.addSelectionListener(eventMenu);
        miNovoEvento.setIcon(ICONS.add());
        subMenu.add(miNovoEvento);


        miListarEvento.addSelectionListener(eventMenu);
        miListarEvento.setIcon(ICONS.list_items());
        subMenu.add(miListarEvento);

//        miImportarEvento.addSelectionListener(eventMenu);
//        subMenu.add(miImportarEvento);
//        miImportarEvento.setIcon(ICONS.importation());

        //miExportarEvento.addSelectionListener(eventMenu);
        //miExportarEvento.setIcon(ICONS.exportation());
        //subMenu.add(miExportarEvento);
        btnEventos.setMenu(subMenu);

        subMenu = new Menu();
        miRelProSemImgBruta.addSelectionListener(eventMenu);
        miRelProSemImgBruta.setIcon(ICONS.noImage());
        subMenu.add(miRelProSemImgBruta);

//        miRelProSemImgTratada.addSelectionListener(eventMenu);
//        miRelProSemImgTratada.setIcon(ICONS.noImage());
//        subMenu.add(miRelProSemImgTratada);



        btnRelatorios.setMenu(subMenu);

        btnProdutos.setIcon(ICONS.carrinho());
        btnRelatorios.setIcon(ICONS.chart());
*/
        //toolBar.add(btnProdutos);
        toolBar.add(btnUsuarioLogado);
        //toolBar.add(btnUsuarios);
        //toolBar.add(btnEventos);
        //toolBar.add(btnRelatorios);
        return toolBar;
    }


    private void defineAbaRelatorioProdutosSemImagensBrutas() {
        if (rpsib == null) {
            rpsib = new RelatorioProdutosSemImagens();
            tiRelatorioProdutosSemImagensBrutas.setItemId("TabRelatorioProdutosSemImagensBrutas");
            tiRelatorioProdutosSemImagensBrutas.setHeight(getHeight() - 80);
            tiRelatorioProdutosSemImagensBrutas.setLayout(new FitLayout());
            tiRelatorioProdutosSemImagensBrutas.setClosable(true);
            tiRelatorioProdutosSemImagensBrutas.setBorders(false);
            tiRelatorioProdutosSemImagensBrutas.add(rpsib);
            tabPanelPrincipal.add(tiRelatorioProdutosSemImagensBrutas);
        } else {
            if (tabPanelPrincipal.getItemByItemId("TabRelatorioProdutosSemImagensBrutas") == null) {
//                tabPanelPrincipal.add(tiEventos);
            }
            //rpsib.load();
        }
        tabPanelPrincipal.setSelection(tiRelatorioProdutosSemImagensBrutas);

    }

    private void saindo() {
        try {
            EasyAccessURL eaurl = new EasyAccessURL(new SairIListenerUrl());
            String url = Constantes.URL + "portalgwt/principalpage.jsp?op=sair";
            eaurl.accessJSon(url);

        } catch (Exception ex) {

        }
    }

    private void alterarSenha() {
        AlterarSenhaGWT altSenhaGWT = new AlterarSenhaGWT();
        altSenhaGWT.show();
    }
    /**
     * Trata os eventos do menu
     * @param me
     */
    private void eventoMenu(MenuEvent me) {
        if (me.getItem() == miAlterarSenha) {
            alterarSenha();
        } else if (me.getItem() == miSair) {
            saindo();
        } else if (me.getSource() == miCadastroUsuario) {
        } else if (me.getItem() == miAlterarUsuario) {
        } else if (me.getItem() == miNovoEvento) {
            if (eve_eventoInsertGWT == null) {
                eve_eventoInsertGWT = new Eve_eventoInsertGWT();
            }
            eve_eventoInsertGWT.show();
        } else if (me.getItem() == miListarEvento) {
//            defineAbaEventos();

            //} else if (me.getItem() == miExportarEvento) {
//        } else if (me.getItem() == miImportarEvento) {
        } else if (me.getItem() == miRelProSemImgBruta) {
            defineAbaRelatorioProdutosSemImagensBrutas();

            //} else if (me.getItem() == miRelProSemImgTratada) {
        }
    }

    private ContentPanel getTreePanel() {
//        NavegacaoEstruturaGWT navegacaoEstruturaGWT = new NavegacaoEstruturaGWT();
//        navegacaoEstruturaGWT.setPrincipalGWT(this);
//        return navegacaoEstruturaGWT;
        NavegacaoEstruturaNewGWT navegacaoEstruturaGWT = new NavegacaoEstruturaNewGWT();
        navegacaoEstruturaGWT.setPrincipalGWT(this);
        return navegacaoEstruturaGWT;

    }

    /**
     * @return the north
     */
    public ContentPanel getNorth() {
        return north;
    }

    /**
     * @return the west
     */
    public ContentPanel getWest() {
        return west;
    }

    /**
     * @return the east
     */
    public ContentPanel getEast() {
        return east;
    }

    /**
     * @return the center
     */
    public ContentPanel getCenter() {
        return center;
    }

    /**
     * @return the south
     */
    public ContentPanel getSouth() {
        return south;
    }

    /**
     * @return the tabPanelPrincipal
     */
    public TabPanelPrincipal getTabPanelPrincipal() {
        return tabPanelPrincipal;
    }

    /**
     * @return the usuarioLogado
     */
    public String getUsuarioLogado() {
        return usuarioLogado;
    }

    /**
     * @param usuarioLogado the usuarioLogado to set
     */
    public void setUsuarioLogado(String usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
        north.setTopComponent(getToolBar());
    }
}


class SairIListenerUrl implements IListenetResponse {

    public void read(JSONValue jsonValue) {
        Window.Location.reload();
        //execute("document.location='index.html?teste=1';");
        //execute("history.back(1);");
    //execute("document.location.reload();");

    //execute("window.location.reload( true );");
    }

    public native static void execute(String command)/*-{
    eval(command);
    }-*/;
}