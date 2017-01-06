package br.com.i9.imagemanager.transfer;

import br.com.easynet.annotation.Conversion;

public class Eve_eventoT { 
	 private int eve_nr_id;
	 private String eve_tx_nome;
	@Conversion(classe="br.com.easynet.convesion.ConvertTimestamp", format="dd/MM/yyyy HH:mm")
	 private java.sql.Timestamp eve_dt_inicio;
	@Conversion(classe="br.com.easynet.convesion.ConvertTimestamp", format="dd/MM/yyyy HH:mm")
	 private java.sql.Timestamp eve_dt_fim;
	@Conversion(classe="br.com.easynet.convesion.ConvertTimestamp", format="dd/MM/yyyy HH:mm")
	 private java.sql.Timestamp eve_dt_criacao;
         private byte[] arquivoImportacao;// usado para importacao
         private String eve_tx_status="A";
         private int emp_nr_id=1;
	 public void setEve_nr_id(int eve_nr_id) {
		 this.eve_nr_id=eve_nr_id;
	}
 
	 public int getEve_nr_id() {
		 return eve_nr_id;
 	} 
 	 public void setEve_tx_nome(String eve_tx_nome) {
		 this.eve_tx_nome=eve_tx_nome;
	}
 
	 public String getEve_tx_nome() {
		 return eve_tx_nome;
 	} 
 	 public void setEve_dt_inicio(java.sql.Timestamp eve_dt_inicio) {
		 this.eve_dt_inicio=eve_dt_inicio;
	}
 
	 public java.sql.Timestamp getEve_dt_inicio() {
		 return eve_dt_inicio;
 	} 
 	 public void setEve_dt_fim(java.sql.Timestamp eve_dt_fim) {
		 this.eve_dt_fim=eve_dt_fim;
	}
 
	 public java.sql.Timestamp getEve_dt_fim() {
		 return eve_dt_fim;
 	} 
 	 public void setEve_dt_criacao(java.sql.Timestamp eve_dt_criacao) {
		 this.eve_dt_criacao=eve_dt_criacao;
	}
 
	 public java.sql.Timestamp getEve_dt_criacao() {
		 return eve_dt_criacao;
 	}

    /**
     * @return the arquivoImportacao
     */
    public byte[] getArquivoImportacao() {
        return arquivoImportacao;
    }

    /**
     * @param arquivoImportacao the arquivoImportacao to set
     */
    public void setArquivoImportacao(byte[] arquivoImportacao) {
        this.arquivoImportacao = arquivoImportacao;
    }

    /**
     * @return the eve_tx_status
     */
    public String getEve_tx_status() {
        return eve_tx_status;
    }

    /**
     * @param eve_tx_status the eve_tx_status to set
     */
    public void setEve_tx_status(String eve_tx_status) {
        this.eve_tx_status = eve_tx_status;
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
 }