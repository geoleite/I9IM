
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
public class Use_usuario_setorTGWT extends BaseModel {
  public Use_usuario_setorTGWT() {
  }

  public int getUsu_nr_id() {
    return  ((Integer)get("usu_nr_id")).intValue();
//    return get("usu_nr_id");
  }

  public void setUsu_nr_id(int usu_nr_id) {
    set("usu_nr_id", usu_nr_id);
  }

  public int getSet_nr_id() {
    return  ((Integer)get("set_nr_id")).intValue();
//    return get("set_nr_id");
  }

  public void setSet_nr_id(int set_nr_id) {
    set("set_nr_id", set_nr_id);
  }



}

