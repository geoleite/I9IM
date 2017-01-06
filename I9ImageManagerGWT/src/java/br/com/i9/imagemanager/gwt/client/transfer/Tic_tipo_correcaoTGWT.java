
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
public class Tic_tipo_correcaoTGWT extends BaseModel {
  public Tic_tipo_correcaoTGWT() {
  }

  public int getTic_nr_id() {
    return  ((Integer)get("tic_nr_id")).intValue();
//    return get("tic_nr_id");
  }

  public void setTic_nr_id(int tic_nr_id) {
    set("tic_nr_id", tic_nr_id);
  }

  public String getTic_tx_nome() {
    return  get("tic_tx_nome");
//    return get("tic_tx_nome");
  }

  public void setTic_tx_nome(String tic_tx_nome) {
    set("tic_tx_nome", tic_tx_nome);
  }



}

