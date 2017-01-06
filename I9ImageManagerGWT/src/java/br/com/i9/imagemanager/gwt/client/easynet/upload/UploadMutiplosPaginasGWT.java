/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.easynet.upload;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.PrincipalGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Enc_encarteTGWT;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;

/**
 *
 * @author geoleite
 */
public class UploadMutiplosPaginasGWT extends Window implements Listener<ButtonEvent> {

    private Enc_encarteTGWT enc_encarteTGWT;

    public UploadMutiplosPaginasGWT() {
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

        String url = Constantes.URL + "/i9im/upload/uploadEncarte.jsp?pag_paginaT.enc_nr_id=" + enc_encarteTGWT.getEnc_nr_id();
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
     * @return the enc_encarteTGWT
     */
    public Enc_encarteTGWT getEnc_encarteTGWT() {
        return enc_encarteTGWT;
    }

    /**
     * @param enc_encarteTGWT the enc_encarteTGWT to set
     */
    public void setEnc_encarteTGWT(Enc_encarteTGWT enc_encarteTGWT) {
        this.enc_encarteTGWT = enc_encarteTGWT;
        if (enc_encarteTGWT != null) {
            setHeading("Inserindo no Encarte " + enc_encarteTGWT.getEnc_tx_nome());
        }
    }
}
