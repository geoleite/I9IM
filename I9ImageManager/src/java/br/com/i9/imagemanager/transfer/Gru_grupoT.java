package br.com.i9.imagemanager.transfer;

import br.com.easynet.annotation.Conversion;

public class Gru_grupoT { 
	 private int gru_nr_id;
	 private int ses_nr_id;
	 private String gru_tx_nome;
	 public void setGru_nr_id(int gru_nr_id) {
		 this.gru_nr_id=gru_nr_id;
	}
 
	 public int getGru_nr_id() {
		 return gru_nr_id;
 	} 
 	 public void setSes_nr_id(int ses_nr_id) {
		 this.ses_nr_id=ses_nr_id;
	}
 
	 public int getSes_nr_id() {
		 return ses_nr_id;
 	} 
 	 public void setGru_tx_nome(String gru_tx_nome) {
		 this.gru_tx_nome=gru_tx_nome;
	}
 
	 public String getGru_tx_nome() {
		 return gru_tx_nome;
 	} 
 }