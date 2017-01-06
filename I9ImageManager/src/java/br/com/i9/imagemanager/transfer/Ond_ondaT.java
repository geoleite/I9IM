package br.com.i9.imagemanager.transfer;

import br.com.easynet.annotation.Conversion;

public class Ond_ondaT { 
	 private int eve_nr_id;
	 private int ond_nr_id;
	@Conversion(classe="br.com.easynet.convesion.ConvertTimestamp", format="dd/MM/yyyy HH:mm")
	 private java.sql.Timestamp ond_dt_criacao;
	 public void setEve_nr_id(int eve_nr_id) {
		 this.eve_nr_id=eve_nr_id;
	}
 
	 public int getEve_nr_id() {
		 return eve_nr_id;
 	} 
 	 public void setOnd_nr_id(int ond_nr_id) {
		 this.ond_nr_id=ond_nr_id;
	}
 
	 public int getOnd_nr_id() {
		 return ond_nr_id;
 	} 
 	 public void setOnd_dt_criacao(java.sql.Timestamp ond_dt_criacao) {
		 this.ond_dt_criacao=ond_dt_criacao;
	}
 
	 public java.sql.Timestamp getOnd_dt_criacao() {
		 return ond_dt_criacao;
 	} 
 }