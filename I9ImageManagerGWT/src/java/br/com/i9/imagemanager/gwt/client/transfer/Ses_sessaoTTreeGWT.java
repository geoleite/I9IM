
/*
 * EasyNet JDragon
 */

package br.com.i9.imagemanager.gwt.client.transfer;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import java.util.Date;

/**
 *
 * @author geoleite
 */
public class Ses_sessaoTTreeGWT extends BaseTreeModel{
  public Ses_sessaoTTreeGWT() {
  }

  public int getSes_nr_id() {
    return  ((Integer)get("ses_nr_id")).intValue();
//    return get("ses_nr_id");
  }

  public void setSes_nr_id(int ses_nr_id) {
    set("ses_nr_id", ses_nr_id);
  }

  public String getSes_tx_nome() {
    return  get("ses_tx_nome");
//    return get("ses_tx_nome");
  }

  public void setSes_tx_nome(String ses_tx_nome) {
    set("ses_tx_nome", ses_tx_nome);
  }
  
  public String toString() {
    return getSes_tx_nome();
  }


}

