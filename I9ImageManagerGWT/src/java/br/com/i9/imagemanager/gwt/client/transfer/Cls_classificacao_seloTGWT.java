
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
public class Cls_classificacao_seloTGWT extends BaseModel{
  public Cls_classificacao_seloTGWT() {
  }

  public int getCls_nr_id() {
    return  ((Integer)get("cls_nr_id")).intValue();
//    return get("cls_nr_id");
  }

  public void setCls_nr_id(int cls_nr_id) {
    set("cls_nr_id", cls_nr_id);
  }

  public String getCls_tx_tipo() {
    return  get("cls_tx_tipo");
//    return get("cls_tx_tipo");
  }

  public void setCls_tx_tipo(String cls_tx_tipo) {
    set("cls_tx_tipo", cls_tx_tipo);
  }



}

