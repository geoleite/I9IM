/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.imagemanager.gwt.client.tic_tipo_correcao;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.easynet.gwt.client.CadastrarBaseGWT;
import br.com.i9.imagemanager.gwt.client.dao.Tic_tipo_correcaoDAOGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Tic_tipo_correcaoTGWT;

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
public class Tic_tipo_correcaoInsertGWT extends CadastrarBaseGWT  {
    private Tic_tipo_correcaoConsultGWT tic_tipo_correcaoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");

	private Tic_tipo_correcaoDAOGWT tic_tipo_correcaoDao = new Tic_tipo_correcaoDAOGWT();
    private TextField<String> tic_nr_id = new TextField<String>();
    private TextField<String> tic_tx_nome = new TextField<String>();


    public Tic_tipo_correcaoInsertGWT() {
        this.setSize("500", "400");
        getCpMaster().setLayout(new TableLayout(2));
        getCpMaster().add(new LabelField("tic_nr_id:"));
        getCpMaster().add(tic_nr_id);

        getCpMaster().add(new LabelField("tic_tx_nome:"));
        getCpMaster().add(tic_tx_nome);


    }

    public void btnInsertAction(ButtonEvent ce){
	Tic_tipo_correcaoTGWT tic_tipo_correcaoT = new Tic_tipo_correcaoTGWT();
			tic_tipo_correcaoT.setTic_nr_id( Integer.parseInt(tic_nr_id.getValue()));
		tic_tipo_correcaoT.setTic_tx_nome(tic_tx_nome.getValue());

        tic_tipo_correcaoDao.inserir(tic_tipo_correcaoT);
	Timer timer = new Timer() {
	   public void run() {
 	     String msg = tic_tipo_correcaoDao.getMsg();
 	     if (msg == null) {
		schedule(500);
	     } else {
		if (msg.toUpperCase().indexOf("FALHA") >=0 ) {
		  MessageBox.alert("Problemas", msg, null);
		} else {
		  Info.display("Resultado", msg);
		  btnLimpartAction(null);
		  tic_tipo_correcaoConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }
    public void btnLimpartAction(ButtonEvent ce){
			tic_nr_id.setValue("");
		tic_tx_nome.setValue("");

    }

   /**
     * @return the tic_tipo_correcaoConsult
     */
    public Tic_tipo_correcaoConsultGWT getTic_tipo_correcaoConsult() {
        return tic_tipo_correcaoConsult;
    }

    /**
     * @param tic_tipo_correcaoConsult the tic_tipo_correcaoConsult to set
     */
    public void setTic_tipo_correcaoConsult(Tic_tipo_correcaoConsultGWT tic_tipo_correcaoConsult) {
        this.tic_tipo_correcaoConsult = tic_tipo_correcaoConsult;
    }
}

