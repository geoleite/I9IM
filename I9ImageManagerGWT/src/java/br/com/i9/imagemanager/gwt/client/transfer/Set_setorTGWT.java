
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
public class Set_setorTGWT extends BaseModel{
  public Set_setorTGWT() {
  }

  public int getSet_nr_id() {
    return  ((Integer)get("set_nr_id")).intValue();
//    return get("set_nr_id");
  }

  public void setSet_nr_id(int set_nr_id) {
    set("set_nr_id", set_nr_id);
  }

  public String getSet_tx_nome() {
    return  get("set_tx_nome");
//    return get("set_tx_nome");
  }

  public void setSet_tx_nome(String set_tx_nome) {
    set("set_tx_nome", set_tx_nome);
  }



}

