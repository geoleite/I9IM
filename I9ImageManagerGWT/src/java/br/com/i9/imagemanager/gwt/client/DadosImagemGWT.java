/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client;

import br.com.i9.imagemanager.gwt.client.easynet.pro_produto.CaracteristicasProdutoGWT;
import br.com.i9.imagemanager.gwt.client.easynet.sel_selo.SeloProdutoGWT;
import br.com.i9.imagemanager.gwt.client.icons.ExampleIcons;
import br.com.i9.imagemanager.gwt.client.transfer.Pro_produtoTGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Image;

/**
 *
 * @author geoleite
 */
public class DadosImagemGWT extends ContentPanel implements Listener<ButtonEvent>, ClickHandler {

    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private PrincipalGWT principalGWT;
    private ExibirImagensGWT abasImagens;
    private ExibirImagensGWT abasImagensPromocionais;
    private ExibirImagensGWT abasImagensInativas;
    private CadastrarImagemGWT cadastrarImagemGWT;
    private Image imgImagens = new Image("/i9imgwt/images/icons/imagens.png");
    private Image imgCadastrar = new Image("/i9imgwt/images/icons/btn_adcionar.png");
    private Image imgPromocionais = new Image("/i9imgwt/images/icons/bolo.png");
    private Image imgVisualizarInativas = new Image("/i9imgwt/images/icons/ina_images.png");
    private Image imgSelos = new Image("/i9imgwt/images/icons/selos.png");
    private Image imgCaracteristicas = new Image("/i9imgwt/images/icons/caracteristicas.png");
    private Pro_produtoTGWT pro_produtoTGWT;
    private ContentPanel west = new ContentPanel();
    private ContentPanel center = new ContentPanel();
    private SeloProdutoGWT seloProdutoGWT;
    private CaracteristicasProdutoGWT caracteristasProdutoGWT;

    public DadosImagemGWT() {

        setLayout(new BorderLayout());
        setHeaderVisible(true);

        setWidth("100%");
        setBorders(false);

        BorderLayoutData westData = new BorderLayoutData(LayoutRegion.WEST, 100, 100, 100);
        westData.setSplit(true);
        westData.setCollapsible(true);
        westData.setMargins(new Margins(0, 5, 0, 0));

        BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);
        centerData.setMargins(new Margins(0));
        add(west, westData);
        add(center, centerData);
        west.setHeaderVisible(false);
        center.setHeaderVisible(false);
        center.setLayout(new FillLayout());
        TableLayout tl = new TableLayout(1);
        tl.setCellHorizontalAlign(HorizontalAlignment.CENTER);
        west.setLayout(new FillLayout());

        defineOpcoes();
    }

    private void defineOpcoes() {

        TableLayout tl = new TableLayout(1);
        tl.setCellPadding(5);
        tl.setCellSpacing(5);
        tl.setCellHorizontalAlign(HorizontalAlignment.CENTER);
        tl.setWidth("100%");
        ContentPanel cp = new ContentPanel(tl);
        cp.setScrollMode(Scroll.AUTO);
        cp.setHeaderVisible(false);
        cp.setFrame(false);
        cp.setBorders(false);
        imgImagens.setTitle("Imagens do produto.");
        imgPromocionais.setTitle("Imagens promocionais do produto.");
        imgVisualizarInativas.setTitle("Imagens inativas do produto.");
        //imgOutros.setTitle("Outras opcoes.");
        imgCadastrar.setTitle("Cadastrar imagens para o produto.");
        imgSelos.setTitle("Selos do produto.");
        imgCaracteristicas.setTitle("Características do produto.");

        cp.add(imgImagens);
        cp.add(imgPromocionais);
        if (PrincipalGWT.mapPerfis.containsKey("I9IM.Admin")) {
            cp.add(imgCadastrar);
        }
        cp.add(imgSelos);
        cp.add(imgCaracteristicas);
        if (PrincipalGWT.mapPerfis.containsKey("I9IM.Admin")) {
            cp.add(imgVisualizarInativas);
        }
        //cp.add(imgOutros);

        imgImagens.addClickHandler(this);
        imgCadastrar.addClickHandler(this);
        imgPromocionais.addClickHandler(this);
        imgSelos.addClickHandler(this);
        imgVisualizarInativas.addClickHandler(this);
        imgCaracteristicas.addClickHandler(this);
        //imgOutros.addClickHandler(this);

        west.add(cp);
        // por padrao já exibi a tela de cadastro e define o botao de cadastro como pressionado
        //btnImagens.toggle(true);

        //Espera 2 segundo para abrir a janela de cadastrar Imagem
        Timer timer = new Timer() {

            @Override
            public void run() {
                //abrirCadastroImagem();
                exibirImagens();
            }
        };
        timer.schedule(2000);
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

    /**
     * @return the cadastrarImagemGWT
     */
    public CadastrarImagemGWT getCadastrarImagemGWT() {
        return cadastrarImagemGWT;
    }

    /**
     * @param cadastrarImagemGWT the cadastrarImagemGWT to set
     */
    public void setCadastrarImagemGWT(CadastrarImagemGWT cadastrarImagemGWT) {
        this.cadastrarImagemGWT = cadastrarImagemGWT;
    }

    /**
     * @return the pro_produtoTGWT
     */
    public Pro_produtoTGWT getPro_produtoTGWT() {
        return pro_produtoTGWT;
    }

    /**
     * @param pro_produtoTGWT the pro_produtoTGWT to set
     */
    public void setPro_produtoTGWT(Pro_produtoTGWT pro_produtoTGWT) {
        this.pro_produtoTGWT = pro_produtoTGWT;
        setHeading("Imagens do Produto: " + pro_produtoTGWT.getPro_nr_id() + " " + pro_produtoTGWT.getPro_tx_nome());
    }

    private void abrirCadastroImagem() {
        if (cadastrarImagemGWT == null) {
            cadastrarImagemGWT = new CadastrarImagemGWT();
            cadastrarImagemGWT.setPro_produtoTGWT(pro_produtoTGWT);
        }
        cadastrarImagemGWT.removeAll();
        cadastrarImagemGWT.criarForm();
        cadastrarImagemGWT.show();
    }

    private void exibirImagens() {
        if (abasImagens == null) {
            abasImagens = new ExibirImagensGWT();
            abasImagens.setPro_produtoTGWT(pro_produtoTGWT);
            abasImagens.setTipoImagem(ExibirImagensGWT.TIPO_IMAGEM);
            abasImagens.load();
        }
        center.add(abasImagens);
        center.layout();
    }

    private void exibirPromocionais() {
        if (abasImagensPromocionais == null) {
            abasImagensPromocionais = new ExibirImagensGWT();
            abasImagensPromocionais.setPro_produtoTGWT(pro_produtoTGWT);
            abasImagensPromocionais.setTipoImagem(ExibirImagensGWT.TIPO_PROMOCIONAL);
            abasImagensPromocionais.load();
        }
        center.add(abasImagensPromocionais);
        center.layout();
    }

    private void exibirInativas() {
        if (abasImagensInativas == null) {
            abasImagensInativas = new ExibirImagensGWT();
            abasImagensInativas.setPro_produtoTGWT(pro_produtoTGWT);
            abasImagensInativas.setTipoImagem(ExibirImagensGWT.TIPO_INATIVA);
            abasImagensInativas.load();
        }

        center.add(abasImagensInativas);
        center.layout();
    }

    private void exibirOutros() {
    }

    private void exibirSelos() {
        if (seloProdutoGWT == null) {
            seloProdutoGWT = new SeloProdutoGWT();
            seloProdutoGWT.setProT(pro_produtoTGWT);
        }
        seloProdutoGWT.show();
    }

    private void exibirCaracteristicas() {
        if (caracteristasProdutoGWT == null) {
            caracteristasProdutoGWT = new CaracteristicasProdutoGWT();
            caracteristasProdutoGWT.setProT(pro_produtoTGWT);
        }
        caracteristasProdutoGWT.show();
    }

    public void handleEvent(ButtonEvent be) {
        /*
        center.removeAll();
        if (be.getSource() == btnImagens) {
        exibirImagens();
        }
        if (be.getSource() == btnCadastrar) {
        abrirCadastroImagem();
        }
        if (be.getSource() == btnPromocionais) {
        exibirPromocionais();
        }
        if (be.getSource() == btnVisualizarInativas) {
        exibirPromocionais();
        }
        if (be.getSource() == btnOutros) {
        exibirOutros();
        }
         */
    }

    public void onClick(ClickEvent event) {

        if (event.getSource() != imgCadastrar) {
            center.removeAll();
        }
        if (event.getSource() == imgImagens) {
            exibirImagens();
        } else if (event.getSource() == imgCadastrar) {
            abrirCadastroImagem();
        } else if (event.getSource() == imgSelos) {
            exibirSelos();
        } else if (event.getSource() == imgPromocionais) {
            exibirPromocionais();
        } else if (event.getSource() == imgCaracteristicas) {
            exibirCaracteristicas();
        } else if (event.getSource() == imgVisualizarInativas) {
            exibirInativas();
//        } else if (event.getSource() == imgOutros) {
//            exibirOutros();
        }
    }
}
