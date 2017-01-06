/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.easynet.eve_evento;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.transfer.Eve_eventoTGWT;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class ImportarEvento extends Window {

    private Timer timer;
    private Eve_eventoTGWT eve_eventoTGWT;
    private FormPanel fp = new FormPanel();
    private FileUploadField file = new FileUploadField();

    public ImportarEvento() {
        setScrollMode(Scroll.AUTO);
        setHeaderVisible(true);
        setHeading("Importar Evento");
        setBorders(false);
        setWidth("100%");
        setSize(350, 150);
        setResizable(false);
        setModal(true);
        //setLayout(new RowLayout(Orientation.VERTICAL));
        //TableLayout layout = new TableLayout(2);
        //layout.setCellSpacing(10);
        setLayout(new FillLayout());
    }

    private FormPanel createForm() {
        

        fp.setHeaderVisible(false);
        //Definindo campos obrigatorios
        HiddenField<String> hfOp = new HiddenField<String>();
        hfOp.setName("op");
        hfOp.setValue("importar");
        fp.add(hfOp);

        HiddenField<String> hfIdEvento = new HiddenField<String>();
        hfIdEvento.setName("eve_eventoT.eve_nr_id");
        hfIdEvento.setValue(eve_eventoTGWT.getEve_nr_id() + "");
        fp.add(hfIdEvento);

        String page = "i9im/i9im/eve_evento/importarEvento.jsp";
        fp.setAction(Constantes.URL + page);
        fp.setEncoding(FormPanel.Encoding.MULTIPART);
        fp.setMethod(FormPanel.Method.POST);

        LabelField eventoNome = new LabelField(eve_eventoTGWT.getEve_tx_nome());
        eventoNome.setFieldLabel("Evento:");
        fp.add(eventoNome);

        
        //file.setValue("/home/geoleite/curriculo.pdf");
        file.setWidth(10);

        //file.setAllowBlank(false);
        file.setName("eve_eventoT.arquivoImportacao");
        file.setFieldLabel("Arquivo");
        Button btn = new Button("Importar");
        Button btnFechar = new Button("Fechar");
        fp.addButton(btn);
        fp.addButton(btnFechar);
        fp.setFrame(true);
        fp.add(file);

        //Definindo campo para upload do arquivo

        btn.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                fp.setHeading("Enviando Arquivo...");
                Info.display("Upload", "Enviando arquivo de eventos");
                fp.addListener(Events.Submit, new Listener<FormEvent>() {

                    public void handleEvent(FormEvent be) {
                        
                        String dados = be.getResultHtml();
                        dados = dados.trim();
                        JSONValue jsonValue = JSONParser.parse(dados);
                        JSONObject jsonObject = null;
                        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                            String resultado = EasyContainer.clearAspas(jsonObject.get("resultado").toString());
                            if (resultado.toUpperCase().indexOf("SUCESSO") > -1) {
                                Info.display("Resultado", resultado);
                                file.setValue("");
                            } else {
                                MessageBox.alert("Erro ao enviar arquivo: " + fp.getTitle(), resultado, null);
                            }
                        }
                        fp.clear();
                    }
                });
                fp.submit();
                //setVisible(false);

            }
        });
        btnFechar.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                setVisible(false);
            }
        });

        return fp;
    }

    public void show() {
        add(createForm());
        super.show();
    }

    /**
     * @return the eve_eventoTGWT
     */
    public Eve_eventoTGWT getEve_eventoTGWT() {
        return eve_eventoTGWT;
    }

    /**
     * @param eve_eventoTGWT the eve_eventoTGWT to set
     */
    public void setEve_eventoTGWT(Eve_eventoTGWT eve_eventoTGWT) {
        this.eve_eventoTGWT = eve_eventoTGWT;
    }
}
