
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
public class Cla_classificacaoTGWT extends BaseModel{
  public Cla_classificacaoTGWT() {
  }

  public int getCla_nr_id() {
    return  ((Integer)get("cla_nr_id")).intValue();
//    return get("cla_nr_id");
  }

  public void setCla_nr_id(int cla_nr_id) {
    set("cla_nr_id", cla_nr_id);
  }

  public String getCla_tx_tipo() {
    return  get("cla_tx_tipo");
//    return get("cla_tx_tipo");
  }

  public void setCla_tx_tipo(String cla_tx_tipo) {
    set("cla_tx_tipo", cla_tx_tipo);
  }



}

