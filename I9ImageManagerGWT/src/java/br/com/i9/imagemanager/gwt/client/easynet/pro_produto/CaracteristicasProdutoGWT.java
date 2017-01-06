/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.easynet.pro_produto;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.icons.ExampleIcons;
import br.com.i9.imagemanager.gwt.client.transfer.Pro_produtoTGWT;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONValue;
import java.util.HashMap;

/**
 *
 * @author geoleite
 */
public class CaracteristicasProdutoGWT extends Window implements IListenetResponse, Listener<ButtonEvent> {

    private TextArea taDescricao = new TextArea();
    private Button btnSalvar = new Button("Salvar");
    private Button btnFechar = new Button("Fechar");
    private ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private Pro_produtoTGWT proT;
    public final static String PAGE = "i9im/i9im/pro_produto/pro_produtoUpdateDeleteGWT.jsp";

    public CaracteristicasProdutoGWT() {
        setSize(420, 120);
        setResizable(false);
        setModal(true);
        setHeading("Características do Produto");
        setLayout(new CenterLayout());
        taDescricao.setPreventScrollbars(true);
        
        add(taDescricao);
        taDescricao.setWidth("100%");
        btnSalvar.setIcon(ICONS.upload());
        btnFechar.setIcon(ICONS.delete());
        addButton(btnSalvar);
        addButton(btnFechar);
        btnSalvar.addListener(Events.OnClick, this);
        btnFechar.addListener(Events.OnClick, this);
    }

    public void read(JSONValue jsonValue) {
    }

    private void salvarCaracteristicas() {
        try {
            EasyAccessURL access = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "updateObs");
            param.put("pro_produtoT.pro_nr_id", "" + proT.getPro_nr_id());
            param.put("pro_produtoT.pro_tx_obs", taDescricao.getValue());
            proT.setPro_tx_obs(taDescricao.getValue());
            access.accessJSonMap(Constantes.URL + PAGE, param);
        } catch (Exception e) {
        }
    }
    
    public void handleEvent(ButtonEvent be) {
        if (be.getButton() == btnFechar) {
            setVisible(false);
        } else if (be.getButton() == btnSalvar) {
            salvarCaracteristicas();
        }
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
        taDescricao.setValue(proT.getPro_tx_obs());
    }
}
