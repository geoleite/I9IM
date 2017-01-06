package br.com.i9.imagemanager.transfer;

import br.com.easynet.annotation.Conversion;

public class Arq_arquivoT {

    private int pro_nr_id;
    private int arq_nr_id;
    private int cla_nr_id;
    private int tid_nr_id;

    private String arq_tx_nome;
    private String arq_tx_descricao="";
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private java.util.Date arq_dt_cadastro;
    private String arq_tx_situacao="A";
    private byte[] arq_bt_arquivo;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private java.util.Date arq_dt_validadeinicio;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private java.util.Date arq_dt_validadefim;
    private String arq_tx_promocional="N";
    private byte[] arq_bt_thumb;

    public void setArq_nr_id(int arq_nr_id) {
        this.arq_nr_id = arq_nr_id;
    }

    public int getArq_nr_id() {
        return arq_nr_id;
    }

    public void setArq_tx_nome(String arq_tx_nome) {
        this.arq_tx_nome = arq_tx_nome;
    }

    public String getArq_tx_nome() {
        return arq_tx_nome;
    }

    public void setArq_tx_descricao(String arq_tx_descricao) {
        this.arq_tx_descricao = arq_tx_descricao;
    }

    public String getArq_tx_descricao() {
        return arq_tx_descricao;
    }

    public void setArq_dt_cadastro(java.util.Date arq_dt_cadastro) {
        this.arq_dt_cadastro = arq_dt_cadastro;
    }

    public java.util.Date getArq_dt_cadastro() {
        return arq_dt_cadastro;
    }

    public void setArq_tx_situacao(String arq_tx_situacao) {
        this.arq_tx_situacao = arq_tx_situacao;
    }

    public String getArq_tx_situacao() {
        return arq_tx_situacao;
    }

    public void setArq_bt_arquivo(byte[] arq_bt_arquivo) {
        this.arq_bt_arquivo = arq_bt_arquivo;
    }

    public byte[] getArq_bt_arquivo() {
        return arq_bt_arquivo;
    }


    public void setArq_tx_promocional(String arq_tx_promocional) {
        this.arq_tx_promocional = arq_tx_promocional;
    }

    public String getArq_tx_promocional() {
        return arq_tx_promocional;
    }

    /**
     * @return the cla_nr_id
     */
    public int getCla_nr_id() {
        return cla_nr_id;
    }

    /**
     * @param cla_nr_id the cla_nr_id to set
     */
    public void setCla_nr_id(int cla_nr_id) {
        this.cla_nr_id = cla_nr_id;
    }

    /**
     * @return the tid_nr_id
     */
    public int getTid_nr_id() {
        return tid_nr_id;
    }

    /**
     * @param tid_nr_id the tid_nr_id to set
     */
    public void setTid_nr_id(int tid_nr_id) {
        this.tid_nr_id = tid_nr_id;
    }

    /**
     * @return the pro_nr_id
     */
    public int getPro_nr_id() {
        return pro_nr_id;
    }

    /**
     * @param pro_nr_id the pro_nr_id to set
     */
    public void setPro_nr_id(int pro_nr_id) {
        this.pro_nr_id = pro_nr_id;
    }

    /**
     * @return the arq_dt_validadeinicio
     */
    public java.util.Date getArq_dt_validadeinicio() {
        return arq_dt_validadeinicio;
    }

    /**
     * @param arq_dt_validadeinicio the arq_dt_validadeinicio to set
     */
    public void setArq_dt_validadeinicio(java.util.Date arq_dt_validadeinicio) {
        this.arq_dt_validadeinicio = arq_dt_validadeinicio;
    }

    /**
     * @return the arq_dt_validadefim
     */
    public java.util.Date getArq_dt_validadefim() {
        return arq_dt_validadefim;
    }

    /**
     * @param arq_dt_validadefim the arq_dt_validadefim to set
     */
    public void setArq_dt_validadefim(java.util.Date arq_dt_validadefim) {
        this.arq_dt_validadefim = arq_dt_validadefim;
    }

    /**
     * @return the arq_bt_thumb
     */
    public byte[] getArq_bt_thumb() {
        return arq_bt_thumb;
    }

    /**
     * @param arq_bt_thumb the arq_bt_thumb to set
     */
    public void setArq_bt_thumb(byte[] arq_bt_thumb) {
        this.arq_bt_thumb = arq_bt_thumb;
    }


}
