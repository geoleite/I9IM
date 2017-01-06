
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
public class Sug_subgrupoTGWT extends BaseModel{
  public Sug_subgrupoTGWT() {
  }

  public int getGru_nr_id() {
    return  ((Integer)get("gru_nr_id")).intValue();
//    return get("gru_nr_id");
  }

  public void setGru_nr_id(int gru_nr_id) {
    set("gru_nr_id", gru_nr_id);
  }

  public int getSes_nr_id() {
    return  ((Integer)get("ses_nr_id")).intValue();
//    return get("ses_nr_id");
  }

  public void setSes_nr_id(int ses_nr_id) {
    set("ses_nr_id", ses_nr_id);
  }

  public int getSug_nr_id() {
    return  ((Integer)get("sug_nr_id")).intValue();
//    return get("sug_nr_id");
  }

  public void setSug_nr_id(int sug_nr_id) {
    set("sug_nr_id", sug_nr_id);
  }

  public String getSug_tx_nome() {
    return  get("sug_tx_nome");
//    return get("sug_tx_nome");
  }

  public void setSug_tx_nome(String sug_tx_nome) {
    set("sug_tx_nome", sug_tx_nome);
  }

  public int getSet_nr_id() {
    return  ((Integer)get("set_nr_id")).intValue();
//    return get("set_nr_id");
  }

  public void setSet_nr_id(int set_nr_id) {
    set("set_nr_id", set_nr_id);
  }



}

