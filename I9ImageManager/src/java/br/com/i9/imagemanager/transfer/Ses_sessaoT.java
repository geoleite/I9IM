package br.com.i9.imagemanager.transfer;

import br.com.easynet.annotation.Conversion;

public class Ses_sessaoT { 
	 private int ses_nr_id;
	 private String ses_tx_nome;
         private int set_nr_id;
	 public void setSes_nr_id(int ses_nr_id) {
		 this.ses_nr_id=ses_nr_id;
	}
 
	 public int getSes_nr_id() {
		 return ses_nr_id;
 	} 
 	 public void setSes_tx_nome(String ses_tx_nome) {
		 this.ses_tx_nome=ses_tx_nome;
	}
 
	 public String getSes_tx_nome() {
		 return ses_tx_nome;
 	}

    /**
     * @return the set_nr_id
     */
    public int getSet_nr_id() {
        return set_nr_id;
    }

    /**
     * @param set_nr_id the set_nr_id to set
     */
    public void setSet_nr_id(int set_nr_id) {
        this.set_nr_id = set_nr_id;
    }
 }