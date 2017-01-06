package br.com.i9.imagemanager.transfer;

import br.com.easynet.annotation.Conversion;

public class Set_setorNewT { 
	 private int set_nr_id;
	 private String set_tx_nome;
	 private String set_tx_status;
	 private int set_nr_idsetorpai;
	 private String set_tx_visivel="S";
         private int emp_nr_id=1;
         private String set_tx_idsap="0";
	 public void setSet_nr_id(int set_nr_id) {
		 this.set_nr_id=set_nr_id;
	}
 
	 public int getSet_nr_id() {
		 return set_nr_id;
 	} 
 	 public void setSet_tx_nome(String set_tx_nome) {
		 this.set_tx_nome=set_tx_nome;
	}
 
	 public String getSet_tx_nome() {
		 return set_tx_nome;
 	} 
 	 public void setSet_tx_status(String set_tx_status) {
		 this.set_tx_status=set_tx_status;
	}
 
	 public String getSet_tx_status() {
		 return set_tx_status;
 	} 
 	 public void setSet_nr_idsetorpai(int set_nr_idsetorpai) {
		 this.set_nr_idsetorpai=set_nr_idsetorpai;
	}
 
	 public int getSet_nr_idsetorpai() {
		 return set_nr_idsetorpai;
 	}

    /**
     * @return the set_tx_visivel
     */
    public String getSet_tx_visivel() {
        return set_tx_visivel;
    }

    /**
     * @param set_tx_visivel the set_tx_visivel to set
     */
    public void setSet_tx_visivel(String set_tx_visivel) {
        this.set_tx_visivel = set_tx_visivel;
    }

    /**
     * @return the emp_nr_id
     */
    public int getEmp_nr_id() {
        return emp_nr_id;
    }

    /**
     * @param emp_nr_id the emp_nr_id to set
     */
    public void setEmp_nr_id(int emp_nr_id) {
        this.emp_nr_id = emp_nr_id;
    }

    /**
     * @return the set_tx_idsap
     */
    public String getSet_tx_idsap() {
        return set_tx_idsap;
    }

    /**
     * @param set_tx_idsap the set_tx_idsap to set
     */
    public void setSet_tx_idsap(String set_tx_idsap) {
        this.set_tx_idsap = set_tx_idsap;
    }
 }