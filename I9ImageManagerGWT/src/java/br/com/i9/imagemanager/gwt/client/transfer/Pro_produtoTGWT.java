
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
public class Pro_produtoTGWT extends BaseModel {
  public Pro_produtoTGWT() {
  }

  public int getPro_nr_id() {
    return  ((Integer)get("pro_nr_id")).intValue();
//    return get("pro_nr_id");
  }

  public void setPro_nr_id(int pro_nr_id) {
    set("pro_nr_id", pro_nr_id);
  }

  public String getPro_tx_nome() {
    return  get("pro_tx_nome");
//    return get("pro_tx_nome");
  }

  public void setPro_tx_nome(String pro_tx_nome) {
    set("pro_tx_nome", pro_tx_nome);
  }

  public int getPro_nr_cdfamilia() {
    return  ((Integer)get("pro_nr_cdfamilia")).intValue();
//    return get("pro_nr_cdfamilia");
  }

  public void setPro_nr_cdfamilia(int pro_nr_cdfamilia) {
    set("pro_nr_cdfamilia", pro_nr_cdfamilia);
  }

  public java.util.Date getPro_dt_atualizacao() {
    return  (Date)get("pro_dt_atualizacao");
//    return get("pro_dt_atualizacao");
  }

  public void setPro_dt_atualizacao(java.util.Date pro_dt_atualizacao) {
    set("pro_dt_atualizacao", pro_dt_atualizacao);
  }

  public float getPro_nr_valor() {
    return  ((Float)get("pro_nr_valor")).floatValue();
//    return get("pro_nr_valor");
  }

  public void setPro_nr_valor(float pro_nr_valor) {
    set("pro_nr_valor", pro_nr_valor);
  }

  public String getPro_tx_situacao() {
    return  get("pro_tx_situacao");
//    return get("pro_tx_situacao");
  }

  public void setPro_tx_situacao(String pro_tx_situacao) {
    set("pro_tx_situacao", pro_tx_situacao);
  }

  public int getSet_nr_id() {
    return  ((Integer)get("set_nr_id")).intValue();
//    return get("ses_nr_id");
  }

  public void setSet_nr_id(int set_nr_id) {
    set("set_nr_id", set_nr_id);
  }

  public String getPro_tx_obs() {
    return  get("pro_tx_obs");
//    return get("pro_tx_obs");
  }

  public void setPro_tx_obs(String pro_tx_obs) {
    set("pro_tx_obs", pro_tx_obs);
  }

  public String getPro_tx_idsap() {
    return  get("pro_tx_idsap");
  }

  public void setPro_tx_idsap(String pro_tx_idsap) {
    set("pro_tx_idsap", pro_tx_idsap);
  }

  public String toString() {
      return getPro_tx_nome();
  }

}

