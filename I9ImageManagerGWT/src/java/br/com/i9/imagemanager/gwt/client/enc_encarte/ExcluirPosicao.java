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
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import org.vaadin.gwtgraphics.client.Line;

/**
 *
 * @author geoleite
 */
public class ExcluirPosicao extends PalhetaOpcao {

    private LabelField lfPonto1 = new LabelField();
    private LabelField lfPonto2 = new LabelField();
    private Line line;
    public ExcluirPosicao(IEventCanvas eventCanvas) {
        super(eventCanvas);
        
        setHeading("Excluir Seta");
        setLayout(new TableLayout(2));
        add(new LabelField("Ponto 1:"));
        add(lfPonto1);
        add(new LabelField("Ponto 2:"));
        add(lfPonto2);
        btnSalvar.setVisible(false);
        btnAlterar.setVisible(false);
        btnExcluir.setVisible(true);
        btnExcluir.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                excluir(be);
                setVisible(false);
            }
        });
    }
    public void excluir(ButtonEvent be) {
        getEventCanvas().remover(line);
        if (corT.getCor_nr_id() == 0) {
            getCorDao().excluirSemChave(corT);
        } else {
            getCorDao().excluir(corT);
        }
    }

    /**
     * @return the line
     */
    public Line getLine() {
        return line;
    }

    /**
     * @param line the line to set
     */
    public void setLine(Line line) {
        this.line = line;
        lfPonto1.setText(line.getX1() + "," + line.getY1());
        lfPonto2.setText(line.getX2() + "," + line.getY2());
    }
}
