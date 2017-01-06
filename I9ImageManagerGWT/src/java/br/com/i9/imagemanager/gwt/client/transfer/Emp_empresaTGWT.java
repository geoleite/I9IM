
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
public class Emp_empresaTGWT extends BaseModel {
  public Emp_empresaTGWT() {
  }

  public int getEmp_nr_id() {
    return  ((Integer)get("emp_nr_id")).intValue();
  }

  public void setEmp_nr_id(int emp_nr_id) {
    set("emp_nr_id", emp_nr_id);
  }

  public String getEmp_tx_nome() {
    return  get("emp_tx_nome");
  }

  public void setEmp_tx_nome(String emp_tx_nome) {
    set("emp_tx_nome", emp_tx_nome);
  }



}

