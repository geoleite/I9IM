/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.easynet.eve_evento;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.icons.ExampleIcons;
import br.com.i9.imagemanager.gwt.client.transfer.*;

import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.core.client.GWT;


import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Grid;

import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Eve_eventoUpdateDeleteGWT extends Window implements Listener<ButtonEvent>, IListenetResponse {

    public static final String PAGE = "i9im/i9im/eve_evento/eve_eventoUpdateDeleteGWT.jsp";
    private Button btnAlt = new Button("Alterar");
    private Button btnDel = new Button("Excluir");
    private Button btnCancelar = new Button("Cancelar");
    private TextField<String> eve_nr_id = new TextField<String>();
    private TextField<String> eve_tx_nome = new TextField<String>();
    private DateField eve_dt_inicio = new DateField();
    private DateField eve_dt_fim = new DateField();
    private Eve_eventoTGWT eve_eventoTGWT = new Eve_eventoTGWT();
    private ExampleIcons ICONS = GWT.create(ExampleIcons.class);

    private Eve_eventoConsultGWT eveConsult;

    private boolean refresh = false;

    public Eve_eventoUpdateDeleteGWT() {
        //this.setSize("100%", "80%");
        setModal(true);
        setHeading("Alterar Evento");
        TableLayout tl = new TableLayout(2);        
        setLayout(tl);

        DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
        eve_dt_inicio.getPropertyEditor().setFormat(dtf);

        eve_dt_fim.getPropertyEditor().setFormat(dtf);

        add(new LabelField("Nome Evento:"));
        add(eve_tx_nome);

        add(new LabelField("Inicio Vigência:"));
        add( eve_dt_inicio);

        add(new LabelField("Fim Vigência:"));
        add(eve_dt_fim);

        
        addButton(btnAlt);
        addButton(btnDel);
        addButton(btnCancelar);
        btnAlt.addListener(Events.OnClick, this);
        btnDel.addListener(Events.OnClick, this);
        btnCancelar.addListener(Events.OnClick, this);
        setResizable(false);
    }

    public void load(Eve_eventoTGWT eve_eventoTGWT) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "findbyid");
            param.put("eve_eventoT.eve_nr_id", eve_eventoTGWT.getEve_nr_id() + "");

            param.put("eve_eventoT.eve_tx_nome", eve_eventoTGWT.getEve_tx_nome() + "");

            DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
            param.put("eve_eventoT.eve_dt_inicio", dtf.format(eve_eventoTGWT.getEve_dt_inicio()));

            param.put("eve_eventoT.eve_dt_fim", dtf.format(eve_eventoTGWT.getEve_dt_fim() ));


            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
            refresh = false;
        } catch (Exception ex) {
        }
    }

    private void btnAltAction(ButtonEvent event) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            //url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");
            param.put("eve_eventoT.eve_nr_id", eve_nr_id.getValue());
            param.put("eve_eventoT.eve_tx_nome", eve_tx_nome.getValue());

            DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
            param.put("eve_eventoT.eve_dt_inicio", dtf.format(eve_dt_inicio.getValue()) + " 00:00");

            param.put("eve_eventoT.eve_dt_fim", dtf.format(eve_dt_fim.getValue()) + " 00:00");

            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
            refresh = true;
        } catch (Exception ex) {
        }
    }

    private void btnDelAction(ButtonEvent event) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
//            url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "delete");

            param.put("eve_eventoT.eve_nr_id", eve_nr_id.getValue());

            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
            refresh = true;
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONObject resultado = jsonObject.get("resultado").isObject();
            String msg = EasyContainer.clearAspas(resultado.get("msg").toString());
            if (msg.trim().length() > 0) {
                MessageBox mb = new MessageBox();
                mb.alert("", msg, null);
                setVisible(false);
            }
            try {
                JSONObject registro = resultado.get("eve_evento").isObject();

                int eve_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("eve_nr_id").toString()));
                eve_eventoTGWT.setEve_nr_id(eve_nr_id);
                this.eve_nr_id.setValue(eve_eventoTGWT.getEve_nr_id() + "");

                String eve_tx_nome = (EasyContainer.clearAspas(registro.get("eve_tx_nome").toString()));
                eve_eventoTGWT.setEve_tx_nome(eve_tx_nome);
                this.eve_tx_nome.setValue(eve_eventoTGWT.getEve_tx_nome() + "");

                DateTimeFormat dtf2 = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
                java.util.Date eve_dt_inicio = dtf2.parse(EasyContainer.clearAspas(registro.get("eve_dt_inicio").toString()));
                eve_eventoTGWT.setEve_dt_inicio(eve_dt_inicio);
                this.eve_dt_inicio.setValue(eve_dt_inicio);

                DateTimeFormat dtf3 = DateTimeFormat.getFormat("dd/MM/yyyy HH:mm");
                java.util.Date eve_dt_fim = dtf3.parse(EasyContainer.clearAspas(registro.get("eve_dt_fim").toString()));
                eve_eventoTGWT.setEve_dt_fim(eve_dt_fim);
                this.eve_dt_fim.setValue(eve_dt_fim);
 
                
            } catch (Exception e) {
            }
        }
        if (refresh && eveConsult != null) {
            eveConsult.load();
        }

    }

    /**
     * @return the eveConsult
     */
    public Eve_eventoConsultGWT getEveConsult() {
        return eveConsult;
    }

    /**
     * @param eveConsult the eveConsult to set
     */
    public void setEveConsult(Eve_eventoConsultGWT eveConsult) {
        this.eveConsult = eveConsult;
    }

    public void handleEvent(ButtonEvent be) {
        if (be.getSource() == btnAlt) {
            btnAltAction(be);
            setVisible(false);
        } else if (be.getSource() == btnDel) {
            btnDelAction(be);
            setVisible(false);
        } else if (be.getSource() == btnCancelar) {
            setVisible(false);
        }
    }
}

