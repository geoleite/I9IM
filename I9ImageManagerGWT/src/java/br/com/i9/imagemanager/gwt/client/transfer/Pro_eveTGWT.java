
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
public class Pro_eveTGWT extends BaseModel{
  public Pro_eveTGWT() {
  }

  public int getPro_nr_id() {
    return  ((Integer)get("pro_nr_id")).intValue();
//    return get("pro_nr_id");
  }

  public void setPro_nr_id(int pro_nr_id) {
    set("pro_nr_id", pro_nr_id);
  }

  public int getEve_nr_id() {
    return  ((Integer)get("eve_nr_id")).intValue();
//    return get("eve_nr_id");
  }

  public void setEve_nr_id(int eve_nr_id) {
    set("eve_nr_id", eve_nr_id);
  }



}

