package br.com.i9.imagemanager.transfer;

import br.com.easynet.annotation.Conversion;

public class Sug_subgrupoT {

    private int gru_nr_id;
    private int ses_nr_id;
    private int sug_nr_id;
    private String sug_tx_nome;

    public void setGru_nr_id(int gru_nr_id) {
        this.gru_nr_id = gru_nr_id;
    }

    public int getGru_nr_id() {
        return gru_nr_id;
    }

    public void setSes_nr_id(int ses_nr_id) {
        this.ses_nr_id = ses_nr_id;
    }

    public int getSes_nr_id() {
        return ses_nr_id;
    }

    public void setSug_nr_id(int sug_nr_id) {
        this.sug_nr_id = sug_nr_id;
    }

    public int getSug_nr_id() {
        return sug_nr_id;
    }

    public void setSug_tx_nome(String sug_tx_nome) {
        this.sug_tx_nome = sug_tx_nome;
    }

    public String getSug_tx_nome() {
        return sug_tx_nome;
    }
}
