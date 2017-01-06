
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
public class Imt_imagemthumbTGWT extends BaseModel{
  public Imt_imagemthumbTGWT() {
  }

  public int getArq_nr_id() {
    return  ((Integer)get("arq_nr_id")).intValue();
//    return get("cd_arquivo");
  }

  public void setArq_nr_id(int arq_nr_id) {
    set("arq_nr_id", arq_nr_id);
  }

  public int getPro_nr_id() {
    return  ((Integer)get("pro_nr_id")).intValue();
//    return get("pro_nr_id");
  }

  public void setPro_nr_id(int pro_nr_id) {
    set("pro_nr_id", pro_nr_id);
  }

  public int getImt_nr_id() {
    return  ((Integer)get("imt_nr_id")).intValue();
//    return get("imt_nr_id");
  }

  public void setImt_nr_id(int imt_nr_id) {
    set("imt_nr_id", imt_nr_id);
  }



}

