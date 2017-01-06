/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.pag_pagina;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.easynet.gwt.client.CadastrarBaseGWT;
import br.com.i9.imagemanager.gwt.client.dao.Pag_paginaDAOGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Enc_encarteTGWT;
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
public class Pag_paginaInsertGWT extends CadastrarBaseGWT {

    private Pag_paginaConsultGWT pag_paginaConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Pag_paginaDAOGWT pag_paginaDao = new Pag_paginaDAOGWT();
    private Enc_encarteTGWT enc_encarteTGWT;

    public Pag_paginaInsertGWT() {
        this.setSize("300", "200");
    }

    public void btnInsertAction(ButtonEvent ce) {
        Pag_paginaTGWT pag_paginaT = new Pag_paginaTGWT();

        pag_paginaDao.inserir(pag_paginaT);
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
                        btnLimpartAction(null);
                        pag_paginaConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnLimpartAction(ButtonEvent ce) {

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

    /**
     * @return the enc_encarteTGWT
     */
    public Enc_encarteTGWT getEnc_encarteTGWT() {
        return enc_encarteTGWT;
    }

    /**
     * @param enc_encarteTGWT the enc_encarteTGWT to set
     */
    public void setEnc_encarteTGWT(Enc_encarteTGWT enc_encarteTGWT) {
        this.enc_encarteTGWT = enc_encarteTGWT;
    }
}
