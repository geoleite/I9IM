/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.easynet.eve_evento;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class Eve_eventoInsertGWT extends com.extjs.gxt.ui.client.widget.Window implements Listener<ButtonEvent>, IListenetResponse {

    public static final String PAGE = "i9im/i9im/eve_evento/eve_eventoInsertGWT.jsp";
    private Button btnCad = new Button("Cadastrar");
    private Button btnCancelar = new Button("Cancelar");
    private TextField<String> eve_tx_nome = new TextField<String>();
    private DateField eve_dt_inicio = new DateField();
    private DateField eve_dt_fim = new DateField();

    public Eve_eventoInsertGWT() {
        setModal(true);
        setHeading("Criar Evento");
        TableLayout tl = new TableLayout(2);
        setLayout(tl);

        add(new LabelField("Nome Evento:"));
        add(eve_tx_nome);

        add(new LabelField("Inicio Vigência:"));
        add(eve_dt_inicio);
        DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
        eve_dt_inicio.getPropertyEditor().setFormat(dtf);

        add(new LabelField("Fim Vigência:"));
        add(eve_dt_fim);
        eve_dt_fim.getPropertyEditor().setFormat(dtf);

        setButtonAlign(HorizontalAlignment.CENTER);
        addButton(btnCad);
        addButton(btnCancelar);

        btnCad.addListener(Events.OnClick, this);
        btnCancelar.addListener(Events.OnClick, this);
        setResizable(false);
    }

    private void btnCadAction(ButtonEvent event) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "insert");
            param.put("eve_eventoT.eve_tx_nome", eve_tx_nome.getValue());

            DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
            param.put("eve_eventoT.eve_dt_inicio", dtf.format(eve_dt_inicio.getValue()) + " 00:00");

            param.put("eve_eventoT.eve_dt_fim", dtf.format(eve_dt_fim.getValue()) + " 00:00");

            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Window.alert("Result " + jsonObject.get("resultado").toString());
            String msg = EasyContainer.clearAspas(jsonObject.get("resultado").toString());
            if (msg.toUpperCase().indexOf("falha") > -1) {
                MessageBox.alert("Resultado", msg, null);
            } else {
                Info.display("Mensagem", msg);
                eve_tx_nome.setValue("");
                eve_dt_inicio.setValue(null);
                eve_dt_fim.setValue(null);
            }
        }
    }

    public void handleEvent(ButtonEvent be) {
        if (be.getSource() == btnCad) {
            btnCadAction(be);
            setVisible(false);
        } else if (be.getSource() == btnCancelar) {
            setVisible(false);
        }
    }
}

