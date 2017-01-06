
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
public class Pro_selTGWT extends BaseModel{
  public Pro_selTGWT() {
  }

  public int getPro_nr_id() {
    return  ((Integer)get("pro_nr_id")).intValue();
//    return get("pro_nr_id");
  }

  public void setPro_nr_id(int pro_nr_id) {
    set("pro_nr_id", pro_nr_id);
  }

  public int getSel_nr_id() {
    return  ((Integer)get("sel_nr_id")).intValue();
//    return get("sel_nr_id");
  }

  public void setSel_nr_id(int sel_nr_id) {
    set("sel_nr_id", sel_nr_id);
  }



}

