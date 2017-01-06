
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
public class Set_setorNewTGWT extends BaseModel {
  public Set_setorNewTGWT() {
      setSet_nr_id(0);
  }

  public int getSet_nr_id() {
    return  ((Integer)get("set_nr_id")).intValue();
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

  public String getSet_tx_status() {
    return  get("set_tx_status");
  }

  public void setSet_tx_status(String set_tx_status) {
    set("set_tx_status", set_tx_status);
  }

  public int getSet_nr_idsetorpai() {
    return  ((Integer)get("set_nr_idsetorpai")).intValue();
  }

  public void setSet_nr_idsetorpai(int set_nr_idsetorpai) {
    set("set_nr_idsetorpai", set_nr_idsetorpai);
  }

  public String getSet_tx_visivel() {
    return  get("set_tx_visivel");
  }

  public void setSet_tx_visivel(String set_tx_visivel) {
    set("set_tx_visivel", set_tx_visivel);
  }

  public int getEmp_nr_id() {
    return  ((Integer)get("emp_nr_id")).intValue();
  }

  public void setEmp_nr_id(int emp_nr_id) {
    set("emp_nr_id", emp_nr_id);
  }
}

