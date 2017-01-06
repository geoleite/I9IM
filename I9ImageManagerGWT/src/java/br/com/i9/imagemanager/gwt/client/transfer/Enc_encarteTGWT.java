
/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.transfer;

import com.extjs.gxt.ui.client.data.BaseModel;
import java.util.Date;

/**
 *
 * @author geoleite
 */
public class Enc_encarteTGWT extends BaseModel {

    public Enc_encarteTGWT() {
    }

    public int getEnc_nr_id() {
        return ((Integer) get("enc_nr_id")).intValue();
//    return get("enc_nr_id");
    }

    public void setEnc_nr_id(int enc_nr_id) {
        set("enc_nr_id", enc_nr_id);
    }

    public String getEnc_tx_nome() {
        return get("enc_tx_nome");
    }

    public void setEnc_tx_nome(String enc_tx_nome) {
        set("enc_tx_nome", enc_tx_nome);
    }

    public Date getEnc_dt_limite() {
        return (Date) get("enc_dt_limite");
//    return get("enc_dt_limite");
    }

    public void setEnc_dt_limite(Date enc_dt_limite) {
        set("enc_dt_limite", enc_dt_limite);
    }

    public int getEmp_nr_id() {
        return ((Integer) get("emp_nr_id")).intValue();
    }

    public void setEmp_nr_id(int emp_nr_id) {
        set("emp_nr_id", emp_nr_id);
    }
}
