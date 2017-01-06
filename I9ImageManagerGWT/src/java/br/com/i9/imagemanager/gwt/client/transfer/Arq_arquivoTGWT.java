
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
public class Arq_arquivoTGWT extends BaseModel{
  public Arq_arquivoTGWT() {
      
  }

  public int getPro_nr_id() {
    return  ((Integer)get("pro_nr_id")).intValue();
//    return get("pro_nr_id");
  }

  public void setPro_nr_id(int pro_nr_id) {
    set("pro_nr_id", pro_nr_id);
  }

  public int getArq_nr_id() {
    return  ((Integer)get("arq_nr_id")).intValue();
//    return get("arq_nr_id");
  }

  public void setArq_nr_id(int arq_nr_id) {
    set("arq_nr_id", arq_nr_id);
  }

  public int getCla_nr_id() {
    return  ((Integer)get("cla_nr_id")).intValue();
//    return get("cd_tipoimagem");
  }

  public void setCla_nr_id(int cla_nr_id) {
    set("cla_nr_id", cla_nr_id);
  }

  public int getTid_nr_id() {
    return  ((Integer)get("tid_nr_id")).intValue();
//    return get("cd_tipodocumento");
  }

  public void setTid_nr_id(int tid_nr_id) {
    set("tid_nr_id", tid_nr_id);
  }

  public String getArq_tx_nome() {
    return  get("arq_tx_nome");
//    return get("arq_tx_nome");
  }

  public void setArq_tx_nome(String arq_tx_nome) {
    set("arq_tx_nome", arq_tx_nome);
  }

  public String getArq_tx_descricao() {
    return  get("arq_tx_descricao");
//    return get("arq_tx_descricao");
  }

  public void setArq_tx_descricao(String arq_tx_descricao) {
    set("arq_tx_descricao", arq_tx_descricao);
  }

  public java.util.Date getArq_dt_cadastro() {
    return  (Date)get("arq_dt_cadastro");
//    return get("arq_dt_cadastro");
  }

  public void setArq_dt_cadastro(java.util.Date arq_dt_cadastro) {
    set("arq_dt_cadastro", arq_dt_cadastro);
  }

  public String getArq_tx_situacao() {
    return  get("arq_tx_situacao");
//    return get("arq_tx_situacao");
  }

  public void setArq_tx_situacao(String arq_tx_situacao) {
    set("arq_tx_situacao", arq_tx_situacao);
  }


  public void setArq_bt_arquivo(byte[] arq_bt_arquivo) {
    set("arq_bt_arquivo", arq_bt_arquivo);
  }

  public java.util.Date getArq_dt_validadeinicio() {
    return  (Date)get("arq_dt_validadeinicio");
//    return get("arq_dt_validadeinicio");
  }

  public void setArq_dt_validadeinicio(java.util.Date arq_dt_validadeinicio) {
    set("arq_dt_validadeinicio", arq_dt_validadeinicio);
  }

  public java.util.Date getArq_dt_validadefim() {
    return  (Date)get("arq_dt_validadefim");
//    return get("arq_dt_validadefim");
  }

  public void setArq_dt_validadefim(java.util.Date arq_dt_validadefim) {
    set("arq_dt_validadefim", arq_dt_validadefim);
  }

  public String getArq_tx_promocional() {
    return  get("arq_tx_promocional");
//    return get("arq_tx_promocional");
  }

  public void setArq_tx_promocional(String arq_tx_promocional) {
    set("arq_tx_promocional", arq_tx_promocional);
  }



}

