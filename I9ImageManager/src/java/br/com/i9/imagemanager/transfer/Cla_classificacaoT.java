package br.com.i9.imagemanager.transfer;

import br.com.easynet.annotation.Conversion;

public class Cla_classificacaoT { 
	 private int cla_nr_id;
	 private String cla_tx_tipo;
         
	 public void setCla_nr_id(int cla_nr_id) {
		 this.cla_nr_id=cla_nr_id;
	}
 
	 public int getCla_nr_id() {
		 return cla_nr_id;
 	} 
 	 public void setCla_tx_tipo(String cla_tx_tipo) {
		 this.cla_tx_tipo=cla_tx_tipo;
	}
 
	 public String getCla_tx_tipo() {
		 return cla_tx_tipo;
 	} 
 }