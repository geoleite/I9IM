/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client;

import br.com.i9.imagemanager.gwt.client.easynet.eve_evento.Eve_eventoConsultGWT;
import br.com.i9.imagemanager.gwt.client.easynet.eve_evento.Eve_eventoInsertGWT;
import br.com.i9.imagemanager.gwt.client.easynet.relatorio.RelatorioInclusoesPeriodo;
import br.com.i9.imagemanager.gwt.client.easynet.relatorio.RelatorioInclusoesPeriodoSetor;
import br.com.i9.imagemanager.gwt.client.easynet.relatorio.RelatorioTotal;
import br.com.i9.imagemanager.gwt.client.easynet.relatorio.RelatorioTotalImagens;
import br.com.i9.imagemanager.gwt.client.easynet.relatorio.RelatorioTotalSelos;
import br.com.i9.imagemanager.gwt.client.easynet.sel_selo.CadastrarSeloGWT;
import br.com.i9.imagemanager.gwt.client.easynet.sel_selo.Sel_seloConsultGWT;
import br.com.i9.imagemanager.gwt.client.emp_empresa.Emp_empresaConsultGWT;
import br.com.i9.imagemanager.gwt.client.emp_empresa.Emp_empresaInsertGWT;
import br.com.i9.imagemanager.gwt.client.enc_encarte.Enc_encarteConsultGWT;
import br.com.i9.imagemanager.gwt.client.enc_encarte.Enc_encarteCorrecaoGWT;
import br.com.i9.imagemanager.gwt.client.reg_regiao.Reg_regiaoConsultGWT;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

/**
 *
 * @author geoleite
 */
public class I9IMMenuHandler extends AMenuHandler {

    private static final int LIMITE = 66;
    public static final String MENU_ITEM = "menuitem";
    private Eve_eventoInsertGWT eve_eventoInsertGWT;
    private Eve_eventoConsultGWT eveConsult;
    private Enc_encarteCorrecaoGWT encCorrecao;
    private CadastrarSeloGWT sel_seloInsertGWT;
    private Emp_empresaInsertGWT emp_empresaInsertGWT;
    private Sel_seloConsultGWT selConsult;
    private Enc_encarteConsultGWT encConsult;
    private PrincipalGWT principalGWT;
    private TabItem tiEventos = new TabItem("Eventos");
    private TabItem tiSelos = new TabItem("Selos");
    private TabItem tiEncarte = new TabItem("Encarte");
    private TabItem tiRegioes = new TabItem("Regioes");
    private TabItem tiEmpresas = new TabItem("Empresas");
    private RelatorioTotal relatorioTotal;
    private RelatorioTotalImagens relatorioTotalImagens;
    private RelatorioTotalSelos relatorioTotalSelos;
    private RelatorioInclusoesPeriodo relatorioInclusoesPeriodo;
    private RelatorioInclusoesPeriodoSetor relatorioInclusoesPeriodoSetor;
    private Reg_regiaoConsultGWT regConsult;
    private Emp_empresaConsultGWT empConsult;

    public I9IMMenuHandler() {
    }

    /**
     * Trata os eventos do menu
     * @param me
     */
    public void actionEventMenu(Object me, String acao) {

        //String acao = me.getItem().getData(AMenuHandler.MENU_ACTION);
        //Window.alert("Evento " + me.getItem().getData(AMenuHandler.MENU_HANDLER) + " " + acao);
        if ("I9IM.NovoEvento".equalsIgnoreCase(acao)) {
            if (eve_eventoInsertGWT == null) {
                eve_eventoInsertGWT = new Eve_eventoInsertGWT();
            }
            eve_eventoInsertGWT.show();
        } else if ("I9IM.ListarEventos".equalsIgnoreCase(acao)) {
            defineAbaEventos();
        } else if ("I9IM.ListarSelosMarcas".equalsIgnoreCase(acao)) {
            defineAbaSelos("Marcas");
        } else if ("I9IM.ListarSelosCaracteristicas".equalsIgnoreCase(acao)) {
            defineAbaSelos("Caracteristicas");
        } else if ("I9IM.ListarRegioes".equalsIgnoreCase(acao)) {
            defineAbaRegioes();
        } else if ("I9IM.ListarEmpresas".equalsIgnoreCase(acao)) {
            defineAbaEmpresas();
        } else if ("I9IM.ListarSelosDisversos".equalsIgnoreCase(acao)) {
            defineAbaSelos("Diversos");
        } else if ("I9IM.NovaEmpresa".equalsIgnoreCase(acao)) {
            if (emp_empresaInsertGWT == null) {
                emp_empresaInsertGWT = new Emp_empresaInsertGWT();
                //emp_empresaInsertGWT.criarForm();
            }
            emp_empresaInsertGWT.setVisible(true);
        } else if ("I9IM.NovoSelo".equalsIgnoreCase(acao)) {
            if (sel_seloInsertGWT == null) {
                sel_seloInsertGWT = new CadastrarSeloGWT();
                sel_seloInsertGWT.criarForm();
            }
            sel_seloInsertGWT.show();
        } else if ("I9IM.RelatorioTotalImagens".equalsIgnoreCase(acao)) {
            if (relatorioTotalImagens == null) {
                relatorioTotalImagens = new RelatorioTotalImagens();
            }
            relatorioTotalImagens.load();
            relatorioTotalImagens.show();
        } else if ("I9IM.RelatorioTotalSelos".equalsIgnoreCase(acao)) {
            if (relatorioTotalSelos == null) {
                relatorioTotalSelos = new RelatorioTotalSelos();
            }
            relatorioTotalSelos.load();
            relatorioTotalSelos.show();
        } else if ("I9IM.RelatorioTotal".equalsIgnoreCase(acao)) {
            if (relatorioTotal == null) {
                relatorioTotal = new RelatorioTotal();
            }
            relatorioTotal.load();
            relatorioTotal.show();
        } else if ("I9IM.RelatorioInclusoesPeriodo".equalsIgnoreCase(acao)) {
            if (relatorioInclusoesPeriodo == null) {
                relatorioInclusoesPeriodo = new RelatorioInclusoesPeriodo();
            }
            relatorioInclusoesPeriodo.show();
        } else if ("I9IM.RelatorioInclusoesPeriodoSetor".equalsIgnoreCase(acao)) {
            //if (relatorioInclusoesPeriodoSetor == null) {
            relatorioInclusoesPeriodoSetor = new RelatorioInclusoesPeriodoSetor();
            //}
            relatorioInclusoesPeriodoSetor.show();
        } else if ("I9IM.NovoEncarte".equalsIgnoreCase(acao)) {
            Enc_encarteCorrecaoGWT enc_encarteCorrecaoGWT = new Enc_encarteCorrecaoGWT();
            enc_encarteCorrecaoGWT.show();
            //defineAbaEncarte();
        } else if ("I9IM.ListarEncartes".equalsIgnoreCase(acao)) {
            defineAbaEncartes();
        } else {
            MessageBox.alert("Aviso", "Evento ainda nao definido!", null);
        }
    }

    private void defineAbaEncartes() {
        tiEncarte.setText("Encartes ");
        if (encConsult == null) {
            tiEncarte.setItemId("TabEncartes");
            tiEncarte.setHeight(principalGWT.getHeight() - LIMITE);
            tiEncarte.setLayout(new FitLayout());
            tiEncarte.setClosable(true);
            tiEncarte.setBorders(false);
            encConsult = new Enc_encarteConsultGWT();
            ContentPanel cp = new ContentPanel();
            cp.setLayout(new FitLayout());
            cp.setHeaderVisible(false);
            cp.add(encConsult);
            //selConsult.load();
            tiEncarte.add(cp);
            principalGWT.getTabPanelPrincipal().add(tiEncarte);
        } else {
            //tabPanelPrincipal.remove(tiEventos);
            if (principalGWT.getTabPanelPrincipal().getItemByItemId("TabEncartes") == null) {
                principalGWT.getTabPanelPrincipal().add(tiEncarte);
            }
            encConsult.load();
        }
        //tiEventos.setAutoHeight(true);
        principalGWT.getTabPanelPrincipal().setSelection(tiEncarte);
    }

    private void defineAbaSelos(String tipo) {
        tiSelos.setText("Selos " + tipo);
        if (selConsult == null) {
            tiSelos.setItemId("TabSelos" + tipo);
            tiSelos.setHeight(principalGWT.getHeight() - LIMITE);
            tiSelos.setLayout(new FitLayout());
            tiSelos.setClosable(true);
            tiSelos.setBorders(false);
            selConsult = new Sel_seloConsultGWT();
            selConsult.setTipo(tipo);
            //selConsult.load();
            tiSelos.add(selConsult);
            principalGWT.getTabPanelPrincipal().add(tiSelos);
        } else {
            //tabPanelPrincipal.remove(tiEventos);
            if (principalGWT.getTabPanelPrincipal().getItemByItemId("TabSelos" + tipo) == null) {
                principalGWT.getTabPanelPrincipal().add(tiSelos);
            }
            selConsult.load();
        }
        //tiEventos.setAutoHeight(true);
        principalGWT.getTabPanelPrincipal().setSelection(tiSelos);
    }

    private void defineAbaEncarte() {
        if (eveConsult == null) {
            tiEncarte.setItemId("TabEncarte");
            tiEncarte.setHeight(principalGWT.getHeight() - LIMITE);
            tiEncarte.setLayout(new FitLayout());
            tiEncarte.setClosable(true);
            tiEncarte.setBorders(false);
            encCorrecao = new Enc_encarteCorrecaoGWT();

            tiEncarte.add(encCorrecao);
            principalGWT.getTabPanelPrincipal().add(tiEncarte);
        } else {
            //tabPanelPrincipal.remove(tiEventos);
            if (principalGWT.getTabPanelPrincipal().getItemByItemId("TabEventos") == null) {
                principalGWT.getTabPanelPrincipal().add(tiEventos);
            }
            eveConsult.load();
        }
        //tiEventos.setAutoHeight(true);
        principalGWT.getTabPanelPrincipal().setSelection(tiEventos);
    }

    private void defineAbaEventos() {
        if (eveConsult == null) {
            tiEventos.setItemId("TabEventos");
            tiEventos.setHeight(principalGWT.getHeight() - LIMITE);
            tiEventos.setLayout(new FitLayout());
            tiEventos.setClosable(true);
            tiEventos.setBorders(false);
            eveConsult = new Eve_eventoConsultGWT();
            tiEventos.add(eveConsult);
            principalGWT.getTabPanelPrincipal().add(tiEventos);
        } else {
            //tabPanelPrincipal.remove(tiEventos);
            if (principalGWT.getTabPanelPrincipal().getItemByItemId("TabEventos") == null) {
                principalGWT.getTabPanelPrincipal().add(tiEventos);
            }
            eveConsult.load();
        }
        //tiEventos.setAutoHeight(true);
        principalGWT.getTabPanelPrincipal().setSelection(tiEventos);
    }

    private void defineAbaRegioes() {
        if (regConsult == null) {
            tiRegioes.setItemId("TabRegioes");
            tiRegioes.setHeight(principalGWT.getHeight() - LIMITE);
            tiRegioes.setLayout(new FitLayout());
            tiRegioes.setClosable(true);
            tiRegioes.setBorders(false);
            regConsult = new Reg_regiaoConsultGWT();
            ContentPanel cp = new ContentPanel(new FitLayout());
            cp.setHeaderVisible(false);
            cp.add(regConsult);
            tiRegioes.add(cp);
            principalGWT.getTabPanelPrincipal().add(tiRegioes);
        } else {
            //tabPanelPrincipal.remove(tiEventos);
            if (principalGWT.getTabPanelPrincipal().getItemByItemId("TabEventos") == null) {
                principalGWT.getTabPanelPrincipal().add(tiRegioes);
            }
            regConsult.load();
        }
        //tiEventos.setAutoHeight(true);
        principalGWT.getTabPanelPrincipal().setSelection(tiRegioes);
    }

    private void defineAbaEmpresas() {
        if (regConsult == null) {
            tiEmpresas.setItemId("TabEmpresas");
            tiEmpresas.setHeight(principalGWT.getHeight() - LIMITE);
            tiEmpresas.setLayout(new FitLayout());
            tiEmpresas.setClosable(true);
            tiEmpresas.setBorders(false);
            empConsult = new Emp_empresaConsultGWT();
            ContentPanel cp = new ContentPanel(new FitLayout());
            cp.setHeaderVisible(false);
            cp.add(empConsult);
            tiEmpresas.add(cp);
            principalGWT.getTabPanelPrincipal().add(tiEmpresas);
        } else {
            //tabPanelPrincipal.remove(tiEventos);
            if (principalGWT.getTabPanelPrincipal().getItemByItemId("TabEventos") == null) {
                principalGWT.getTabPanelPrincipal().add(tiEmpresas);
            }
            empConsult.load();
        }
        //tiEventos.setAutoHeight(true);
        principalGWT.getTabPanelPrincipal().setSelection(tiEmpresas);
    }

    private void defineAbaRelatorioProdutosSemImagensBrutas() {
        /*
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
        tabPanelPrincipal.add(tiEventos);
        }
        //rpsib.load();
        }
        tabPanelPrincipal.setSelection(tiRelatorioProdutosSemImagensBrutas);
         */
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
}
