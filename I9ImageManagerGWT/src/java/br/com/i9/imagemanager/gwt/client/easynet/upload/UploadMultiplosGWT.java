/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.easynet.upload;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.PrincipalGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Cla_classificacaoTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Pro_produtoTGWT;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.i18n.client.DateTimeFormat;
import java.util.Date;

/**
 *
 * @author geoleite
 */
public class UploadMultiplosGWT extends Window implements Listener<ButtonEvent> {

    private Cla_classificacaoTGWT claT;
    private Pro_produtoTGWT proT;
    private boolean promocional=false;
    private Date dtInicio, dtFim;


    public UploadMultiplosGWT() {
    }

    public void show() {
        setScrollMode(Scroll.AUTO);
        setHeaderVisible(true);
        setHeading("Selecionar Imagens");
        setBorders(false);
        setWidth("100%");
        setSize(450, 450);
        setResizable(false);
        setModal(true);
        
        String url = Constantes.URL + "/i9im/upload/upload.jsp?cla_classificacaoT.cla_tx_tipo="+
                claT.getCla_tx_tipo()+"&pro_produtoT.pro_nr_id=" + proT.getPro_nr_id() +
                "&promocional=" + (promocional?"S":"N");
        if (promocional) {
            DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
            url += "&dtinicio=" + dtf.format(dtInicio) + "&dtfim=" + dtf.format(dtFim);
        }
        setUrl(url);
        Button btn = new Button("Fechar");
        btn.setIcon(PrincipalGWT.ICONS.delete());
        btn.addListener(Events.OnClick, this);
        addButton(btn);
        super.show();
    }

    public void handleEvent(ButtonEvent be) {
        setVisible(false);
    }

    /**
     * @return the claT
     */
    public Cla_classificacaoTGWT getClaT() {
        return claT;
    }

    /**
     * @param claT the claT to set
     */
    public void setClaT(Cla_classificacaoTGWT claT) {
        this.claT = claT;
    }

    /**
     * @return the proT
     */
    public Pro_produtoTGWT getProT() {
        return proT;
    }

    /**
     * @param proT the proT to set
     */
    public void setProT(Pro_produtoTGWT proT) {
        this.proT = proT;
    }

    /**
     * @return the promocional
     */
    public boolean isPromocional() {
        return promocional;
    }

    /**
     * @param promocional the promocional to set
     */
    public void setPromocional(boolean promocional) {
        this.promocional = promocional;
    }

    /**
     * @return the dtInicio
     */
    public Date getDtInicio() {
        return dtInicio;
    }

    /**
     * @param dtInicio the dtInicio to set
     */
    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    /**
     * @return the dtFim
     */
    public Date getDtFim() {
        return dtFim;
    }

    /**
     * @param dtFim the dtFim to set
     */
    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }
}
