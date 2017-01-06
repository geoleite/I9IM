
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
public class Eve_eventoTGWT extends BaseModel{
  public Eve_eventoTGWT() {
  }

  public int getEve_nr_id() {
    return  ((Integer)get("eve_nr_id")).intValue();
  }

  public void setEve_nr_id(int eve_nr_id) {
    set("eve_nr_id", eve_nr_id);
  }

  public String getEve_tx_nome() {
    return  get("eve_tx_nome");
//    return get("eve_tx_nome");
  }

  public void setEve_tx_nome(String eve_tx_nome) {
    set("eve_tx_nome", eve_tx_nome);
  }

  public java.util.Date getEve_dt_inicio() {
    return  (Date)get("eve_dt_inicio");
//    return get("eve_dt_inicio");
  }

  public void setEve_dt_inicio(Date eve_dt_inicio) {
    set("eve_dt_inicio", eve_dt_inicio);
  }

  public java.util.Date getEve_dt_fim() {
    return  (Date)get("eve_dt_fim");
//    return get("eve_dt_fim");
  }

  public void setEve_dt_fim(Date eve_dt_fim) {
    set("eve_dt_fim", eve_dt_fim);
  }

  public java.util.Date getEve_dt_criacao() {
    return  (Date)get("eve_dt_criacao");
//    return get("eve_dt_criacao");
  }

  public void setEve_dt_criacao(Date eve_dt_criacao) {
    set("eve_dt_criacao", eve_dt_criacao);
  }

  public boolean getModificado() {
    return Boolean.parseBoolean((String)get("modificado"));
  }

  public void setModificado(boolean modificado) {
    set("modificado", modificado + "");
  }

  public int getEmp_nr_id() {
    return  ((Integer)get("emp_nr_id")).intValue();
  }

  public void setEmp_nr_id(int emp_nr_id) {
    set("emp_nr_id", emp_nr_id);
  }

}

