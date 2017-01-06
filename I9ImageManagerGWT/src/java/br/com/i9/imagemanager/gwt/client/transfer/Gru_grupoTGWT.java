
/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.transfer;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import java.util.Date;

/**
 *
 * @author geoleite
 */
public class Gru_grupoTGWT extends BaseTreeModel {

    public Gru_grupoTGWT() {
    }

    public int getGru_nr_id() {
        return ((Integer) get("gru_nr_id")).intValue();
//    return get("gru_nr_id");
    }

    public void setGru_nr_id(int gru_nr_id) {
        set("gru_nr_id", gru_nr_id);
    }

    public int getSes_nr_id() {
        return ((Integer) get("ses_nr_id")).intValue();
//    return get("ses_nr_id");
    }

    public void setSes_nr_id(int ses_nr_id) {
        set("ses_nr_id", ses_nr_id);
    }

    public String getGru_tx_nome() {
        return get("gru_tx_nome");
//    return get("gru_tx_nome");
    }

    public void setGru_tx_nome(String gru_tx_nome) {
        set("gru_tx_nome", gru_tx_nome);
        set("descricao", gru_tx_nome);
    }

    public String toString() {
        return getGru_tx_nome();
    }
}

