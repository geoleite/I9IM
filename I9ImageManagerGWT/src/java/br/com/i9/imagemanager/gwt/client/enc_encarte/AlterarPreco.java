/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.enc_encarte;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import org.vaadin.gwtgraphics.client.shape.Text;

/**
 *
 * @author geoleite
 */
public class AlterarPreco extends PalhetaOpcao {

    private Text text;
    private TextField<String> tfValor = new TextField<String>();
    private LabelField lfValor = new LabelField();

    public AlterarPreco(IEventCanvas eventCanvas) {
        super(eventCanvas);
        setHeading("Excluir Preco");
        setLayout(new TableLayout(2));
        add(lfValor);
        add(tfValor);
        btnSalvar.setVisible(false);
        btnAlterar.setVisible(true);
        btnExcluir.setVisible(true);
        btnExcluir.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                excluir(be);
                setVisible(false);
            }
        });
    }
    public void excluir(ButtonEvent be) {
        getEventCanvas().remover(text);
        if (corT.getCor_nr_id() == 0) {
            getCorDao().excluirSemChave(corT);
        } else {
            getCorDao().excluir(corT);
        }
    }
    public void alterar(ButtonEvent be) {
        text.setText(lfValor.getText() + "" +  tfValor.getValue());
        getCorDao().alterar(corT);
    }

    /**
     * @return the text
     */
    public Text getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(Text text) {
        this.text = text;
        String conteudo = text.getText();
        String[] conteudos = conteudo.split(":");
        String label = conteudos[0].trim();
        conteudo = conteudos[1].trim();
        lfValor.setText(label + ":");
        tfValor.setValue(conteudo);
    }
}
