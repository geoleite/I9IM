package br.com.i9.imagemanager.transfer;

import br.com.easynet.annotation.Conversion;

public class Obe_observacaoexclusaoT { 
	 private int arq_nr_id;
	 private int obe_nr_id;
	 private int cd_produto;
	 private String obe_tx_texto;
	 public void setArq_nr_id(int arq_nr_id) {
		 this.arq_nr_id=arq_nr_id;
	}
 
	 public int getArq_nr_id() {
		 return arq_nr_id;
 	} 
 	 public void setObe_nr_id(int obe_nr_id) {
		 this.obe_nr_id=obe_nr_id;
	}
 
	 public int getObe_nr_id() {
		 return obe_nr_id;
 	} 
 	 public void setCd_produto(int cd_produto) {
		 this.cd_produto=cd_produto;
	}
 
	 public int getCd_produto() {
		 return cd_produto;
 	} 
 	 public void setObe_tx_texto(String obe_tx_texto) {
		 this.obe_tx_texto=obe_tx_texto;
	}
 
	 public String getObe_tx_texto() {
		 return obe_tx_texto;
 	} 
 }