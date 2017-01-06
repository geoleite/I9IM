package br.com.i9.imagemanager.gwt.client.emp_empresa;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.EasyContainer;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.easynet.gwt.client.component.EasyTextField;

import br.com.easynet.gwt.client.AlterarExcluirBaseGWT;
import br.com.i9.imagemanager.gwt.client.dao.Emp_empresaDAOGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Emp_empresaTGWT;

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
public class Emp_empresaUpdateDeleteGWT extends AlterarExcluirBaseGWT {

    private Emp_empresaConsultGWT emp_empresaConsult;
    private DateTimeFormat dtfDate = DateTimeFormat.getFormat("dd/MM/yyyy");
    private DateTimeFormat dtfDateTime = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm:ss");
    private Emp_empresaDAOGWT emp_empresaDao = new Emp_empresaDAOGWT();
    private Emp_empresaTGWT emp_empresaT;
    private EasyTextField<String> emp_tx_nome = new EasyTextField<String>();

    public Emp_empresaUpdateDeleteGWT() {
        this.setSize("250", "130");

        getCpMaster().setLayout(new TableLayout(2));

        LabelField lfemp_tx_nome = new LabelField("Nome:");
        lfemp_tx_nome.setId("lfemp_tx_nome");
        getCpMaster().add(lfemp_tx_nome);
        emp_tx_nome.setId("emp_tx_nome");
        emp_tx_nome.setMaxLength(100);
        getCpMaster().add(emp_tx_nome);


    }

    public void load(Emp_empresaTGWT emp_empresaT) {
        this.emp_empresaT = emp_empresaT;
        emp_tx_nome.setValue(emp_empresaT.getEmp_tx_nome());
    }

    public void btnUpdateAction(ButtonEvent ce) {
        emp_empresaT.setEmp_tx_nome(emp_tx_nome.getValue());

        emp_empresaDao.alterar(emp_empresaT);
        Timer timer = new Timer() {

            public void run() {
                String msg = emp_empresaDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        emp_empresaConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    public void btnDeltAction(ButtonEvent ce) {

        emp_empresaDao.excluir(emp_empresaT);
        Timer timer = new Timer() {

            public void run() {
                String msg = emp_empresaDao.getMsg();
                if (msg == null) {
                    schedule(500);
                } else {
                    if (msg.toUpperCase().indexOf("FALHA") >= 0) {
                        MessageBox.alert("Problemas", msg, null);
                    } else {
                        Info.display("Resultado", msg);
                        emp_empresaConsult.load();
                        setVisible(false);
                    }
                }
            }
        };
        timer.schedule(500);
    }

    /**
     * @return the emp_empresaConsult
     */
    public Emp_empresaConsultGWT getEmp_empresaConsult() {
        return emp_empresaConsult;
    }

    /**
     * @param emp_empresaConsult the emp_empresaConsult to set
     */
    public void setEmp_empresaConsult(Emp_empresaConsultGWT emp_empresaConsult) {
        this.emp_empresaConsult = emp_empresaConsult;
    }
}
