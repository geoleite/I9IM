package br.com.i9.imagemanager.gwt.client.pag_pagina;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;
import br.com.i9.imagemanager.gwt.client.dao.Pag_paginaDAOGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Pag_paginaTGWT;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Pag_paginaUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private Pag_paginaConsultGWT pag_paginaConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Pag_paginaDAOGWT pag_paginaDao = new Pag_paginaDAOGWT();
    private Pag_paginaTGWT pag_paginaT;
    private TextField<String> pag_nr_id = new TextField<String>();
    private TextField<String> enc_nr_id = new TextField<String>();
    private TextField<String> pag_bt_arquivo = new TextField<String>();

    public Pag_paginaUpdateDeleteGWT() {
        this.setSize("500", "400");

        getCpMaster().setLayout(new TableLayout(2));
        getCpMaster().add(new LabelField("pag_nr_id:"));
        getCpMaster().add(pag_nr_id);

        getCpMaster().add(new LabelField("enc_nr_id:"));
        getCpMaster().add(enc_nr_id);

        getCpMaster().add(new LabelField("pag_bt_arquivo:"));
        getCpMaster().add(pag_bt_arquivo);


    }

    public void load(Pag_paginaTGWT pag_paginaT) {
        this.pag_paginaT = pag_paginaT;
        pag_nr_id.setValue(pag_paginaT.getPag_nr_id() + "");
        enc_nr_id.setValue(pag_paginaT.getEnc_nr_id() + "");

    }

    public void btnUpdateAction(ButtonEvent ce) {
        pag_paginaT.setPag_nr_id(Integer.parseInt(pag_nr_id.getValue()));
        pag_paginaT.setEnc_nr_id(Integer.parseInt(enc_nr_id.getValue()));

        pag_paginaDao.alterar(pag_paginaT);
        Timer timer = new Timer() {

            public void run() {
                String msg = pag_paginaDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        pag_paginaConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

        pag_paginaDao.excluir(pag_paginaT);
        Timer timer = new Timer() {

            public void run() {
                String msg = pag_paginaDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        pag_paginaConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    /**
     * @return the pag_paginaConsult
     */
    public Pag_paginaConsultGWT getPag_paginaConsult() {
        return pag_paginaConsult;
    }

    /**
     * @param pag_paginaConsult the pag_paginaConsult to set
     */
    public void setPag_paginaConsult(Pag_paginaConsultGWT pag_paginaConsult) {
        this.pag_paginaConsult = pag_paginaConsult;
    }
}
