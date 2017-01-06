/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.enc_encarte;

import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.transfer.Cor_correcaoTGWT;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import org.vaadin.gwtgraphics.client.Line;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class CorrecaoPosicao extends PalhetaOpcao {

    private int x1, x2;
    private int y1, y2;
    private LabelField lfImg1 = new LabelField("");
    private LabelField lfImg2 = new LabelField("");
    private Line line;
    public CorrecaoPosicao(IEventCanvas eventCanvas) {
        super(eventCanvas);
        setLayout(new TableLayout(2));
        setHeading("Corrigir posição de produtos");
        setResizable(false);
        add(new LabelField("Imagem 1:"));
        add(lfImg1);
        add(new LabelField("Imagem 2:"));
        add(lfImg2);
    }

    public void limpar() {
        if (x1 != 0 && x2 != 0) {
            x1 = 0;
            x2 = 0;
            y1 = 0;
            y2 = 0;
        }
    }

    public void salvar(ButtonEvent be) {
        Line line = new Line(x1, y1, x2, y2);
        line.setStrokeWidth(10);
        line.setStrokeColor("#1020FF");
        getEventCanvas().add(line);
        line.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                Line line = (Line) event.getSource();
                ExcluirPosicao excluirPosicao = new ExcluirPosicao(getEventCanvas());
                excluirPosicao.corT = corT;
                excluirPosicao.setLine(line);
                excluirPosicao.setVisible(true);
            }
        });
        Cor_correcaoTGWT corT = new Cor_correcaoTGWT();
        corT.setCor_nr_posx(x1);
        corT.setCor_nr_posy(y1);
        corT.setCor_nr_posx2(x2);
        corT.setCor_nr_posy2(y2);
        corT.setCor_tx_observacao("");
        corT.setTic_nr_id(getTicNrId());
        corT.setPag_nr_id(getPagNrId());
        corT.setReg_nr_id(1);
        //corT.setUsu_nr_id(592);
        //corT.setSet_nr_id(9);
        corT.setCor_tx_status("A");
        getCorDao().inserir(corT);
        esperarResposta(line);
        limpar();        
        setVisible(false);
    }

    public void importar(Cor_correcaoTGWT corT) {
        this.corT = corT;
        line = new Line(corT.getCor_nr_posx(), corT.getCor_nr_posy(), corT.getCor_nr_posx2(), corT.getCor_nr_posy2());
        line.setStrokeWidth(10);
        line.setStrokeColor("#1020FF");
        line.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                ExcluirPosicao excluirPosicao = new ExcluirPosicao(getEventCanvas());
                excluirPosicao.corT = CorrecaoPosicao.this.corT;
                excluirPosicao.setLine(line);
                excluirPosicao.setVisible(true);
            }
        });
        getEventCanvas().add(line);
    }

    public void setVisible(boolean visible) {
        if (!visible) {
            super.setVisible(visible);
        } else {
            if (x1 != 0 && x2 != 0) {
                lfImg1.setText(x1 + "," + y1);
                lfImg2.setText(x2 + "," + y2);
                super.setVisible(visible);
            } else {
                MessageBox.info("Escolha a segunda Imagem", "Clique em cima da segunda imagem.", null);
            }
        }
    }

    /**
     * @param posScrollX the posScrollX to set
     */
    public void setPosScrollX(int posScrollX) {
        super.setPosScrollX(posScrollX);
        if (x1 == 0) {
            x1 = getPosX() + getPosScrollX() - ERRO_X;
        } else {
            x2 = getPosX() + getPosScrollX() - ERRO_X;
        }
    }

    /**
     * @param posScrollY the posScrollY to set
     */
    public void setPosScrollY(int posScrollY) {
        super.setPosScrollY(posScrollY);
        if (y1 == 0) {
            y1 = getPosY() + getPosScrollY() - ERRO_Y;
        } else {
            y2 = getPosY() + getPosScrollY() - ERRO_Y;
        }
    }

    /**
     * @return the x1
     */
    public int getX1() {
        return x1;
    }

    /**
     * @param x1 the x1 to set
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * @return the x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * @param x2 the x2 to set
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * @return the y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * @param y1 the y1 to set
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * @return the y2
     */
    public int getY2() {
        return y2;
    }

    /**
     * @param y2 the y2 to set
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }
}
