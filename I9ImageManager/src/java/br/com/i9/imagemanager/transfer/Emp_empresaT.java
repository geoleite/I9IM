package br.com.i9.imagemanager.transfer;

import br.com.easynet.annotation.Conversion;

public class Emp_empresaT { 
	 private int emp_nr_id;
	 private String emp_tx_nome;
	 public void setEmp_nr_id(int emp_nr_id) {
		 this.emp_nr_id=emp_nr_id;
	}
 
	 public int getEmp_nr_id() {
		 return emp_nr_id;
 	} 
 	 public void setEmp_tx_nome(String emp_tx_nome) {
		 this.emp_tx_nome=emp_tx_nome;
	}
 
	 public String getEmp_tx_nome() {
		 return emp_tx_nome;
 	} 
 }