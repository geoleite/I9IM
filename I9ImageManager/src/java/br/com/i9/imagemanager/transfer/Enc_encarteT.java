package br.com.i9.imagemanager.transfer;

import br.com.easynet.annotation.Conversion;

public class Enc_encarteT {

    private int enc_nr_id;
    @Conversion(classe = "br.com.easynet.convesion.ConvertTimestamp", format = "dd/MM/yyyy HH:mm")
    private java.sql.Timestamp enc_dt_limite;
    private String enc_tx_nome;
    private int emp_nr_id=1;

    public void setEnc_nr_id(int enc_nr_id) {
        this.enc_nr_id = enc_nr_id;
    }

    public int getEnc_nr_id() {
        return enc_nr_id;
    }


    public void setEnc_dt_limite(java.sql.Timestamp enc_dt_limite) {
        this.enc_dt_limite = enc_dt_limite;
    }

    public java.sql.Timestamp getEnc_dt_limite() {
        return enc_dt_limite;
    }

    /**
     * @return the enc_tx_nome
     */
    public String getEnc_tx_nome() {
        return enc_tx_nome;
    }

    /**
     * @param enc_tx_nome the enc_tx_nome to set
     */
    public void setEnc_tx_nome(String enc_tx_nome) {
        this.enc_tx_nome = enc_tx_nome;
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
