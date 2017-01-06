
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
public class Ond_ondaTGWT extends BaseModel {

    public Ond_ondaTGWT() {
    }

    public int getEve_nr_id() {
        return ((Integer) get("eve_nr_id")).intValue();
//    return get("eve_nr_id");
    }

    public void setEve_nr_id(int eve_nr_id) {
        set("eve_nr_id", eve_nr_id);
    }

    public int getOnd_nr_id() {
        return ((Integer) get("ond_nr_id")).intValue();
//    return get("ond_nr_id");
    }

    public void setOnd_nr_id(int ond_nr_id) {
        set("ond_nr_id", ond_nr_id);
    }

    public Date getOnd_dt_criacao() {
        return (Date) get("ond_dt_criacao");
//    return get("ond_dt_criacao");
    }

    public void setOnd_dt_criacao(Date ond_dt_criacao) {
        set("ond_dt_criacao", ond_dt_criacao);
    }
}

