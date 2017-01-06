/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client;

import br.com.i9.imagemanager.gwt.client.easynet.bo.Pro_produtoConsultGWT;
import br.com.i9.imagemanager.gwt.client.icons.ExampleIcons;
import br.com.i9.imagemanager.gwt.client.transfer.Pro_produtoTGWT;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author geoleite
 */
public class ProdutosPanel extends ContentPanel {
    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    //private ContentPanel north = new ContentPanel();
    private ContentPanel west = new ContentPanel();
    //private ContentPanel east = new ContentPanel();
    private ContentPanel center = new ContentPanel();
    //private ContentPanel south = new ContentPanel();

    
    private PrincipalGWT principalGWT;
    
    private DadosImagemGWT imagens;// criado no momento que um produto é selecionado
    private DadosProdutosGWT produtos = new DadosProdutosGWT();
    private int idSetor;// dados para busca dos produtos
    private String texto;
    public ProdutosPanel() {
        //proConsult = new Pro_produtoConsultGWT();
        setHeaderVisible(false);
        setWidth("100%");
        setBorders(false);
        //setScrollMode(Scroll.ALWAYS);
        // Definindo a altura

        //setHeight(400);
        setLayout(new BorderLayout());
        BorderLayoutData westData = new BorderLayoutData(LayoutRegion.WEST, 300);
        westData.setSplit(true);
        westData.setCollapsible(true);
        westData.setMargins(new Margins(0, 5, 0, 0));

        BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);
        centerData.setMargins(new Margins(0));

        //add(north, northData);

        //adicionando o tree na janela principal
        center.setHeaderVisible(false);
        west.setHeaderVisible(true);
        west.setHeading("Produtos");
        west.setIcon(ICONS.filter());
        center.setHeading("Imagens");

        west.setHeaderVisible(true);
        center.setLayout(new FillLayout());
        center.setWidth("100%");
        add(west, westData);
        add(center, centerData);

        center.setBorders(false);
        west.setBorders(false);
        west.setLayout(new FillLayout());
        //center.add(imagens);
        //add(east, eastData);
        //add(south, southData);
        produtos.setProdutosPanel(this);
    
    }

    public void consultarDados() {
        produtos.setIdSetor(getIdSetor());
        produtos.consultar();
        //west.removeAll();
        getWest().add(produtos);
        
        layout();
    }

    public void consultarDadosImagem() {
        produtos.setIdSetor(getIdSetor());
        produtos.consultarImagem();
        //west.removeAll();
        getWest().add(produtos);

        layout();
    }

    public void consultarDadosSemImagem() {
        produtos.setIdSetor(getIdSetor());
        produtos.consultarSemImagem();
        //west.removeAll();
        getWest().add(produtos);

        layout();
    }

    public void consultarDadosTexto() {
        //produtos.setIdSessao(idSessao);
        //produtos.setIdGrupo(idGrupo);
        produtos.setTexto(texto);
        produtos.consultarTexto();
        //west.removeAll();
        getWest().add(produtos);

        layout();
    }

    public void consultarDadosTextoSemImagem() {
        //produtos.setIdSessao(idSessao);
        //produtos.setIdGrupo(idGrupo);
        produtos.setTexto(texto);
        produtos.consultarTextoSemImagem();
        //west.removeAll();
        getWest().add(produtos);

        layout();
    }

    public void consultarDadosTextoImagem() {
        //produtos.setIdSessao(idSessao);
        //produtos.setIdGrupo(idGrupo);
        produtos.setTexto(texto);
        produtos.consultarTextoImagem();
        //west.removeAll();
        getWest().add(produtos);
        layout();
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
        if (principalGWT != null) {
            setHeight(principalGWT.getHeight()-70);
            
            layout();
        }
    }

    /**
     * @return the west
     */
    public ContentPanel getWest() {
        return west;
    }

    /**
     * @param west the west to set
     */
    public void setWest(ContentPanel west) {
        this.west = west;
    }

    /**
     * @return the center
     */
    public ContentPanel getCenter() {
        return center;
    }

    /**
     * @param center the center to set
     */
    public void setCenter(ContentPanel center) {
        this.center = center;
    }

    /**
     * @return the imagens
     */
    public DadosImagemGWT getImagens() {
        return imagens;
    }

    /**
     * @param imagens the imagens to set
     */
    public void setImagens(DadosImagemGWT imagens) {

        if (this.imagens != null) {
            center.remove(this.imagens);
        }
        if (imagens != null) {
            
            center.add(imagens);
            imagens.setPrincipalGWT(principalGWT);
            center.layout();
            layout();

        }
        this.imagens = imagens;
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
