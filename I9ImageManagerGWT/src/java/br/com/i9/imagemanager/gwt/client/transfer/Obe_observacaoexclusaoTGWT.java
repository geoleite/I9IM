
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
public class Obe_observacaoexclusaoTGWT extends BaseModel{
  public Obe_observacaoexclusaoTGWT() {
  }

  public int getArq_nr_id() {
    return  ((Integer)get("arq_nr_id")).intValue();
//    return get("arq_nr_id");
  }

  public void setArq_nr_id(int arq_nr_id) {
    set("arq_nr_id", arq_nr_id);
  }

  public int getObe_nr_id() {
    return  ((Integer)get("obe_nr_id")).intValue();
//    return get("obe_nr_id");
  }

  public void setObe_nr_id(int obe_nr_id) {
    set("obe_nr_id", obe_nr_id);
  }

  public int getPro_nr_id() {
    return  ((Integer)get("pro_nr_id")).intValue();
//    return get("cd_produto");
  }

  public void setPro_nr_id(int pro_nr_id) {
    set("pro_nr_id", pro_nr_id);
  }

  public String getObe_tx_texto() {
    return  get("obe_tx_texto");
//    return get("obe_tx_texto");
  }

  public void setObe_tx_texto(String obe_tx_texto) {
    set("obe_tx_texto", obe_tx_texto);
  }



}

