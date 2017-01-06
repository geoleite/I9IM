
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
public class Reg_regiaoTGWT extends BaseModel {
  public Reg_regiaoTGWT() {
  }

  public int getReg_nr_id() {
    return  ((Integer)get("reg_nr_id")).intValue();
//    return get("reg_nr_id");
  }

  public void setReg_nr_id(int reg_nr_id) {
    set("reg_nr_id", reg_nr_id);
  }

  public String getReg_tx_nome() {
    return  get("reg_tx_nome");
//    return get("reg_tx_nome");
  }

  public void setReg_tx_nome(String reg_tx_nome) {
    set("reg_tx_nome", reg_tx_nome);
  }



}

