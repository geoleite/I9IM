package br.com.i9.imagemanager.transfer;

import br.com.easynet.annotation.Conversion;

public class Pag_paginaT { 
	 private int pag_nr_id;
	 private int enc_nr_id;
         private String pag_tx_nome;
	 private byte[] pag_bt_arquivo;
	 public void setPag_nr_id(int pag_nr_id) {
		 this.pag_nr_id=pag_nr_id;
	}
 
	 public int getPag_nr_id() {
		 return pag_nr_id;
 	} 
 	 public void setEnc_nr_id(int enc_nr_id) {
		 this.enc_nr_id=enc_nr_id;
	}
 
	 public int getEnc_nr_id() {
		 return enc_nr_id;
 	} 
 	 public void setPag_bt_arquivo(byte[] pag_bt_arquivo) {
		 this.pag_bt_arquivo=pag_bt_arquivo;
	}
 
	 public byte[] getPag_bt_arquivo() {
		 return pag_bt_arquivo;
 	}

    /**
     * @return the pag_tx_nome
     */
    public String getPag_tx_nome() {
        return pag_tx_nome;
    }

    /**
     * @param pag_tx_nome the pag_tx_nome to set
     */
    public void setPag_tx_nome(String pag_tx_nome) {
        this.pag_tx_nome = pag_tx_nome;
    }
 }