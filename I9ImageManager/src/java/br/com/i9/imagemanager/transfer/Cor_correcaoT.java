package br.com.i9.imagemanager.transfer;

import br.com.easynet.annotation.Conversion;

public class Cor_correcaoT { 
	 private int cor_nr_id;
	 private int tic_nr_id;
	 private String cor_tx_observacao;
	 private int set_nr_id;
	 private int usu_nr_id;
	 private String cor_tx_status;
	 private int cor_nr_posx;
	 private int cor_nr_posy;
	 private int cor_nr_posx2;
	 private int cor_nr_posy2;
	 private int reg_nr_id;
	@Conversion(classe="br.com.easynet.convesion.ConvertTimestamp", format="dd/MM/yyyy HH:mm")
	 private java.sql.Timestamp cor_dt_corrigido;
	 private int pag_nr_id;
	 public void setCor_nr_id(int cor_nr_id) {
		 this.cor_nr_id=cor_nr_id;
	}
 
	 public int getCor_nr_id() {
		 return cor_nr_id;
 	} 
 	 public void setTic_nr_id(int tic_nr_id) {
		 this.tic_nr_id=tic_nr_id;
	}
 
	 public int getTic_nr_id() {
		 return tic_nr_id;
 	} 
 	 public void setCor_tx_observacao(String cor_tx_observacao) {
		 this.cor_tx_observacao=cor_tx_observacao;
	}
 
	 public String getCor_tx_observacao() {
		 return cor_tx_observacao;
 	} 
 	 public void setSet_nr_id(int set_nr_id) {
		 this.set_nr_id=set_nr_id;
	}
 
	 public int getSet_nr_id() {
		 return set_nr_id;
 	} 
 	 public void setUsu_nr_id(int usu_nr_id) {
		 this.usu_nr_id=usu_nr_id;
	}
 
	 public int getUsu_nr_id() {
		 return usu_nr_id;
 	} 
 	 public void setCor_tx_status(String cor_tx_status) {
		 this.cor_tx_status=cor_tx_status;
	}
 
	 public String getCor_tx_status() {
		 return cor_tx_status;
 	} 
 	 public void setCor_nr_posx(int cor_nr_posx) {
		 this.cor_nr_posx=cor_nr_posx;
	}
 
	 public int getCor_nr_posx() {
		 return cor_nr_posx;
 	} 
 	 public void setCor_nr_posy(int cor_nr_posy) {
		 this.cor_nr_posy=cor_nr_posy;
	}
 
	 public int getCor_nr_posy() {
		 return cor_nr_posy;
 	} 
 	 public void setReg_nr_id(int reg_nr_id) {
		 this.reg_nr_id=reg_nr_id;
	}
 
	 public int getReg_nr_id() {
		 return reg_nr_id;
 	} 
 	 public void setCor_dt_corrigido(java.sql.Timestamp cor_dt_corrigido) {
		 this.cor_dt_corrigido=cor_dt_corrigido;
	}
 
	 public java.sql.Timestamp getCor_dt_corrigido() {
		 return cor_dt_corrigido;
 	} 
 	 public void setPag_nr_id(int pag_nr_id) {
		 this.pag_nr_id=pag_nr_id;
	}
 
	 public int getPag_nr_id() {
		 return pag_nr_id;
 	}

    /**
     * @return the cor_nr_posx2
     */
    public int getCor_nr_posx2() {
        return cor_nr_posx2;
    }

    /**
     * @param cor_nr_posx2 the cor_nr_posx2 to set
     */
    public void setCor_nr_posx2(int cor_nr_posx2) {
        this.cor_nr_posx2 = cor_nr_posx2;
    }

    /**
     * @return the cor_nr_posy2
     */
    public int getCor_nr_posy2() {
        return cor_nr_posy2;
    }

    /**
     * @param cor_nr_posy2 the cor_nr_posy2 to set
     */
    public void setCor_nr_posy2(int cor_nr_posy2) {
        this.cor_nr_posy2 = cor_nr_posy2;
    }
 }