package br.com.i9.imagemanager.gwt.client.tic_tipo_correcao;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;

import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;
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
public class Tic_tipo_correcaoUpdateDeleteGWT extends AlterarExcluirBaseGWT {
    private Tic_tipo_correcaoConsultGWT tic_tipo_correcaoConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Tic_tipo_correcaoDAOGWT tic_tipo_correcaoDao = new Tic_tipo_correcaoDAOGWT();
    private Tic_tipo_correcaoTGWT tic_tipo_correcaoT;

    private TextField<String> tic_nr_id = new TextField<String>();
    private TextField<String> tic_tx_nome = new TextField<String>();


    public Tic_tipo_correcaoUpdateDeleteGWT() {
        this.setSize("500", "400");
	
        getCpMaster().setLayout(new TableLayout(2));
        getCpMaster().add(new LabelField("tic_nr_id:"));
        getCpMaster().add(tic_nr_id);

        getCpMaster().add(new LabelField("tic_tx_nome:"));
        getCpMaster().add(tic_tx_nome);


    }

    public void load(Tic_tipo_correcaoTGWT tic_tipo_correcaoT) {
	this.tic_tipo_correcaoT = tic_tipo_correcaoT;
		tic_nr_id.setValue(tic_tipo_correcaoT.getTic_nr_id() + "");
		tic_tx_nome.setValue(tic_tipo_correcaoT.getTic_tx_nome());

    }
    public void btnUpdateAction(ButtonEvent ce) {
		tic_tipo_correcaoT.setTic_nr_id( Integer.parseInt(tic_nr_id.getValue()));
		tic_tipo_correcaoT.setTic_tx_nome(tic_tx_nome.getValue());

	tic_tipo_correcaoDao.alterar(tic_tipo_correcaoT);
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
		  tic_tipo_correcaoConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

	tic_tipo_correcaoDao.excluir(tic_tipo_correcaoT);
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
		  tic_tipo_correcaoConsult.load();
		  setVisible(false);
		}
	     }
	   }
        };
	timer.schedule(500);
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

