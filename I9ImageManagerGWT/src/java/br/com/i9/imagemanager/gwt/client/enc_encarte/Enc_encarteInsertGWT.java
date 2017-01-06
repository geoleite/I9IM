/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.enc_encarte;

import br.com.easynet.gwt.client.CadastrarBaseGWT;
import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.dao.Enc_encarteDAOGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Enc_encarteTGWT;

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
public class Enc_encarteInsertGWT extends CadastrarBaseGWT {

    private Enc_encarteConsultGWT enc_encarteConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Enc_encarteDAOGWT enc_encarteDao = new Enc_encarteDAOGWT();
    private TextField<String> enc_nr_id = new TextField<String>();
    private TextField<String> enc_tx_nome = new TextField<String>();
    private DateField enc_dt_limite = new DateField();

    public Enc_encarteInsertGWT() {
        setHeading("Cadastrar Encarte");
        setResizable(false);
        this.setSize("300", "200");
        getCpMaster().setLayout(new TableLayout(2));

        getCpMaster().add(new LabelField("Nome:"));
        getCpMaster().add(enc_tx_nome);

        getCpMaster().add(new LabelField("Data:"));
        enc_dt_limite.getPropertyEditor().setFormat(DateTimeFormat.getFormat("dd/MM/yyyy"));
        getCpMaster().add(enc_dt_limite);
    }

    public void btnInsertAction(ButtonEvent ce) {
        Enc_encarteTGWT enc_encarteT = new Enc_encarteTGWT();
        enc_encarteT.setEnc_dt_limite(enc_dt_limite.getValue());
        enc_encarteT.setEnc_tx_nome(enc_tx_nome.getValue());

        enc_encarteDao.inserir(enc_encarteT);
        Timer timer = new Timer() {

            public void run() {
                String msg = enc_encarteDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        btnLimpartAction(null);
                        enc_encarteConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnLimpartAction(ButtonEvent ce) {
        enc_tx_nome.setValue("");
        enc_dt_limite.setValue(null);
    }

    /**
     * @return the enc_encarteConsult
     */
    public Enc_encarteConsultGWT getEnc_encarteConsult() {
        return enc_encarteConsult;
    }

    /**
     * @param enc_encarteConsult the enc_encarteConsult to set
     */
    public void setEnc_encarteConsult(Enc_encarteConsultGWT enc_encarteConsult) {
        this.enc_encarteConsult = enc_encarteConsult;
    }
}
