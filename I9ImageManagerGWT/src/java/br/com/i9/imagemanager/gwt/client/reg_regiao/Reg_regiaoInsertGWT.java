/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.reg_regiao;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.easynet.gwt.client.CadastrarBaseGWT;
import br.com.i9.imagemanager.gwt.client.dao.Reg_regiaoDAOGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Reg_regiaoTGWT;

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
public class Reg_regiaoInsertGWT extends CadastrarBaseGWT {

    private Reg_regiaoConsultGWT reg_regiaoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Reg_regiaoDAOGWT reg_regiaoDao = new Reg_regiaoDAOGWT();
    private TextField<String> reg_nr_id = new TextField<String>();
    private TextField<String> reg_tx_nome = new TextField<String>();

    public Reg_regiaoInsertGWT() {
        setHeading("Cadastrar Região");
        setModal(true);
        this.setSize("300", "120");
        getCpMaster().setLayout(new TableLayout(2));

        getCpMaster().add(new LabelField("Nome:"));
        getCpMaster().add(reg_tx_nome);
    }

    public void btnInsertAction(ButtonEvent ce) {
        Reg_regiaoTGWT reg_regiaoT = new Reg_regiaoTGWT();
        reg_regiaoT.setReg_tx_nome(reg_tx_nome.getValue());

        reg_regiaoDao.inserir(reg_regiaoT);
        Timer timer = new Timer() {

            public void run() {
                String msg = reg_regiaoDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        btnLimpartAction(null);
                        reg_regiaoConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnLimpartAction(ButtonEvent ce) {
        reg_nr_id.setValue("");
        reg_tx_nome.setValue("");

    }

    /**
     * @return the reg_regiaoConsult
     */
    public Reg_regiaoConsultGWT getReg_regiaoConsult() {
        return reg_regiaoConsult;
    }

    /**
     * @param reg_regiaoConsult the reg_regiaoConsult to set
     */
    public void setReg_regiaoConsult(Reg_regiaoConsultGWT reg_regiaoConsult) {
        this.reg_regiaoConsult = reg_regiaoConsult;
    }
}
