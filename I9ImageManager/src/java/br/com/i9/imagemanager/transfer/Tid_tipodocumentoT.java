package br.com.i9.imagemanager.transfer;

import br.com.easynet.annotation.Conversion;

public class Tid_tipodocumentoT { 
	 private int tid_nr_id;
	 private String tid_tx_sigla;
	 private String tid_tx_descricao;
	 private String tid_tx_reduzir;
	 public void setTid_nr_id(int tid_nr_id) {
		 this.tid_nr_id=tid_nr_id;
	}
 
	 public int getTid_nr_id() {
		 return tid_nr_id;
 	} 
 	 public void setTid_tx_sigla(String tid_tx_sigla) {
		 this.tid_tx_sigla=tid_tx_sigla;
	}
 
	 public String getTid_tx_sigla() {
		 return tid_tx_sigla;
 	} 
 	 public void setTid_tx_descricao(String tid_tx_descricao) {
		 this.tid_tx_descricao=tid_tx_descricao;
	}
 
	 public String getTid_tx_descricao() {
		 return tid_tx_descricao;
 	} 
 	 public void setTid_tx_reduzir(String tid_tx_reduzir) {
		 this.tid_tx_reduzir=tid_tx_reduzir;
	}
 
	 public String getTid_tx_reduzir() {
		 return tid_tx_reduzir;
 	} 
 }