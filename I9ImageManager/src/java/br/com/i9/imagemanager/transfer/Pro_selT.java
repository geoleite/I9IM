package br.com.i9.imagemanager.transfer;

import br.com.easynet.annotation.Conversion;
import java.sql.Timestamp;

public class Pro_selT {

    private int pro_nr_id;
    private int sel_nr_id;
    private Timestamp ps_dt_criacao;

    public void setPro_nr_id(int pro_nr_id) {
        this.pro_nr_id = pro_nr_id;
    }

    public int getPro_nr_id() {
        return pro_nr_id;
    }

    public void setSel_nr_id(int sel_nr_id) {
        this.sel_nr_id = sel_nr_id;
    }

    public int getSel_nr_id() {
        return sel_nr_id;
    }

    /**
     * @return the ps_dt_criacao
     */
    public Timestamp getPs_dt_criacao() {
        return ps_dt_criacao;
    }

    /**
     * @param ps_dt_criacao the ps_dt_criacao to set
     */
    public void setPs_dt_criacao(Timestamp ps_dt_criacao) {
        this.ps_dt_criacao = ps_dt_criacao;
    }
}
