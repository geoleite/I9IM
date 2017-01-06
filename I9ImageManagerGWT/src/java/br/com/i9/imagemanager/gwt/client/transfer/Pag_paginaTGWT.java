
/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.transfer;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import java.util.Date;

/**
 *
 * @author geoleite
 */
public class Pag_paginaTGWT extends BaseModel  {

    public Pag_paginaTGWT() {
    }

    public int getPag_nr_id() {
        return ((Integer) get("pag_nr_id")).intValue();
//    return get("pag_nr_id");
    }

    public void setPag_nr_id(int pag_nr_id) {
        set("pag_nr_id", pag_nr_id);
    }

    public String getPag_tx_nome() {
        return get("pag_tx_nome");
//    return get("pag_nr_id");
    }

    public void setPag_tx_nome(String pag_tx_nome) {
        set("pag_tx_nome", pag_tx_nome);
    }

    public int getEnc_nr_id() {
        return ((Integer) get("enc_nr_id")).intValue();
//    return get("enc_nr_id");
    }

    public void setEnc_nr_id(int enc_nr_id) {
        set("enc_nr_id", enc_nr_id);
    }
}
