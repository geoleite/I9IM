
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
public class Tid_tipodocumentoTGWT extends BaseModel{
  public Tid_tipodocumentoTGWT() {
  }

  public int getTid_nr_id() {
    return  ((Integer)get("tid_nr_id")).intValue();
//    return get("tid_nr_id");
  }

  public void setTid_nr_id(int tid_nr_id) {
    set("tid_nr_id", tid_nr_id);
  }

  public String getTid_tx_sigla() {
    return  get("tid_tx_sigla");
//    return get("tid_tx_sigla");
  }

  public void setTid_tx_sigla(String tid_tx_sigla) {
    set("tid_tx_sigla", tid_tx_sigla);
  }

  public String getTid_tx_descricao() {
    return  get("tid_tx_descricao");
//    return get("tid_tx_descricao");
  }

  public void setTid_tx_descricao(String tid_tx_descricao) {
    set("tid_tx_descricao", tid_tx_descricao);
  }

  public String getTid_tx_reduzir() {
    return  get("tid_tx_reduzir");
//    return get("tid_tx_reduzir");
  }

  public void setTid_tx_reduzir(String tid_tx_reduzir) {
    set("tid_tx_reduzir", tid_tx_reduzir);
  }



}

