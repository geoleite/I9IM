package br.com.i9.imagemanager.transfer;

import br.com.easynet.annotation.Conversion;

public class Pro_produtoT {

    private int pro_nr_id;
    private int pro_nr_idantigo;
    private String pro_tx_nome;
    private int pro_nr_cdfamilia;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private java.util.Date pro_dt_atualizacao;
    private float pro_nr_valor;
    private String pro_tx_situacao;
    private int set_nr_id;
    private String pro_tx_obs = "";
    private String pro_tx_idsap = "";

    public void setPro_nr_id(int pro_nr_id) {
        this.pro_nr_id = pro_nr_id;
    }

    public int getPro_nr_id() {
        return pro_nr_id;
    }

    public void setPro_tx_nome(String pro_tx_nome) {
        this.pro_tx_nome = pro_tx_nome;
    }

    public String getPro_tx_nome() {
        return pro_tx_nome;
    }

    public void setPro_nr_cdfamilia(int pro_nr_cdfamilia) {
        this.pro_nr_cdfamilia = pro_nr_cdfamilia;
    }

    public int getPro_nr_cdfamilia() {
        return pro_nr_cdfamilia;
    }

    public void setPro_dt_atualizacao(java.util.Date pro_dt_atualizacao) {
        this.pro_dt_atualizacao = pro_dt_atualizacao;
    }

    public java.util.Date getPro_dt_atualizacao() {
        return pro_dt_atualizacao;
    }

    public void setPro_nr_valor(float pro_nr_valor) {
        this.pro_nr_valor = pro_nr_valor;
    }

    public float getPro_nr_valor() {
        return pro_nr_valor;
    }

    public void setPro_tx_situacao(String pro_tx_situacao) {
        this.pro_tx_situacao = pro_tx_situacao;
    }

    public String getPro_tx_situacao() {
        return pro_tx_situacao;
    }

    public void setPro_tx_obs(String pro_tx_obs) {
        this.pro_tx_obs = pro_tx_obs;
    }

    public String getPro_tx_obs() {
        return pro_tx_obs;
    }

    /**
     * @return the pro_nr_idantigo
     */
    public int getPro_nr_idantigo() {
        return pro_nr_idantigo;
    }

    /**
     * @param pro_nr_idantigo the pro_nr_idantigo to set
     */
    public void setPro_nr_idantigo(int pro_nr_idantigo) {
        this.pro_nr_idantigo = pro_nr_idantigo;
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

    /**
     * @return the pro_tx_idsap
     */
    public String getPro_tx_idsap() {
        return pro_tx_idsap;
    }

    /**
     * @param pro_tx_idsap the pro_tx_idsap to set
     */
    public void setPro_tx_idsap(String pro_tx_idsap) {
        this.pro_tx_idsap = pro_tx_idsap;
    }
}
