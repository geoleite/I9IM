/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.enc_encarte;

import br.com.easynet.gwt.client.BaseGWT;
import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.icons.ExampleIcons;
import br.com.i9.imagemanager.gwt.client.transfer.Cor_correcaoTGWT;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import com.google.gwt.widgetideas.graphics.client.GWTCanvas;
import java.util.HashMap;
import org.vaadin.gwtgraphics.client.shape.Text;

/**
 *
 * @author geoleite
 */
public class CorrecaoTexto extends PalhetaOpcao {

    private TextArea taTexto = new TextArea();
    private Text text;
    private Cor_correcaoTGWT corT;

    public CorrecaoTexto(IEventCanvas eventCanvasTemp) {
        super(eventCanvasTemp);
        setResizable(false);
        setHeading("Adicioando Comentário");
        setBodyStyle("filter: alpha(opacity=50); opacity: .50;");

        setLayout(new FitLayout());
        add(taTexto);

        //setPosX(posTempX);
        //setPosY(posTempY);
        setSize(300, 120);
    }

    public void limpar() {
        taTexto.setValue("");
    }

    public void alterar(ButtonEvent be) {
        text.setText(taTexto.getValue());
        corT.setCor_tx_observacao(text.getText());
        corT.setCor_tx_status("A");
        getCorDao().alterar(corT);
        setVisible(false);
        limpar();
    }

    public void importar(Cor_correcaoTGWT corT) {
        this.corT = corT;
        Text text = new Text(corT.getCor_nr_posx(), corT.getCor_nr_posy(), corT.getCor_tx_observacao());
        text.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                CorrecaoTexto.this.text = (Text) event.getSource();
                taTexto.setValue(CorrecaoTexto.this.text.getText());
                btnSalvar.setVisible(false);
                btnExcluir.setVisible(true);
                btnAlterar.setVisible(true);
                btnExcluir.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                    public void handleEvent(ButtonEvent be) {
                        getEventCanvas().remover(CorrecaoTexto.this.text);
                        getCorDao().excluir(CorrecaoTexto.this.corT);
                        CorrecaoTexto.this.text = null;
                        setVisible(false);
                    }
                });
                setVisible(true);
            }
        });
        getEventCanvas().add(text);
    }

    public void salvar(ButtonEvent be) {

        int posFinalX = getPosX() + getPosScrollX() - ERRO_X;
        int posFinalY = getPosY() + getPosScrollY() - ERRO_Y;

        if (taTexto.getValue() != null && taTexto.getValue().trim().length() > 0) {
            Text text = new Text(posFinalX, posFinalY, taTexto.getValue());

            text.addClickHandler(new ClickHandler() {

                public void onClick(ClickEvent event) {
                    CorrecaoTexto.this.text = (Text) event.getSource();
                    taTexto.setValue(CorrecaoTexto.this.text.getText());
                    btnSalvar.setVisible(false);
                    btnExcluir.setVisible(true);
                    btnAlterar.setVisible(true);
                    btnExcluir.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                        public void handleEvent(ButtonEvent be) {
                            getEventCanvas().remover(CorrecaoTexto.this.text);
                            getCorDao().excluirSemChave(CorrecaoTexto.this.corT);
                            CorrecaoTexto.this.text = null;
                            limpar();
                            setVisible(false);
                        }
                    });
                    setVisible(true);
                }
            });
            getEventCanvas().add(text);

            Cor_correcaoTGWT corT = new Cor_correcaoTGWT();
            corT.setCor_nr_posx(posFinalX);
            corT.setCor_nr_posy(posFinalY);
            corT.setCor_nr_posx2(posFinalX);
            corT.setCor_nr_posy2(posFinalY);
            corT.setCor_tx_observacao(taTexto.getValue());
            corT.setTic_nr_id(getTicNrId());
            corT.setPag_nr_id(getPagNrId());
            corT.setReg_nr_id(1);
            //corT.setUsu_nr_id(592);
            //corT.setSet_nr_id(9);
            corT.setCor_tx_status("A");
            getCorDao().inserir(corT);
            esperarResposta(text);
            this.corT = corT;            
            layout();
            limpar();
        }
        setVisible(false);

    }

    /**
     * @return the taTexto
     */
    public TextArea getTaTexto() {
        return taTexto;
    }

    /**
     * @param taTexto the taTexto to set
     */
    public void setTaTexto(TextArea taTexto) {
        this.taTexto = taTexto;
    }
}
