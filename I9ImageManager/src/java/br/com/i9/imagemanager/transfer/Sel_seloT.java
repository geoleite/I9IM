package br.com.i9.imagemanager.transfer;

import br.com.easynet.annotation.Conversion;
import java.util.Date;

public class Sel_seloT {

    private int sel_nr_id;
    private int cls_nr_id;
    private int tid_nr_id;
    private String sel_tx_nome="";
    private String sel_tx_descricao;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private Date sel_dt_cadastro;
    private String sel_tx_situacao="A";
    private byte[] sel_bt_arquivo;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private Date sel_dt_validadeinicio;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private Date sel_dt_validadefim;
    private String sel_tx_promocional = "N";

    public void setSel_nr_id(int sel_nr_id) {
        this.sel_nr_id = sel_nr_id;
    }

    public int getSel_nr_id() {
        return sel_nr_id;
    }

    public void setCls_nr_id(int cls_nr_id) {
        this.cls_nr_id = cls_nr_id;
    }

    public int getCls_nr_id() {
        return cls_nr_id;
    }

    public void setTid_nr_id(int tid_nr_id) {
        this.tid_nr_id = tid_nr_id;
    }

    public int getTid_nr_id() {
        return tid_nr_id;
    }

    public void setSel_tx_nome(String sel_tx_nome) {
        this.sel_tx_nome = sel_tx_nome;
    }

    public String getSel_tx_nome() {
        return sel_tx_nome;
    }

    public void setSel_tx_descricao(String sel_tx_descricao) {
        this.sel_tx_descricao = sel_tx_descricao;
    }

    public String getSel_tx_descricao() {
        return sel_tx_descricao;
    }

    public void setSel_tx_situacao(String sel_tx_situacao) {
        this.sel_tx_situacao = sel_tx_situacao;
    }

    public String getSel_tx_situacao() {
        return sel_tx_situacao;
    }

    public void setSel_bt_arquivo(byte[] sel_bt_arquivo) {
        this.sel_bt_arquivo = sel_bt_arquivo;
    }

    public byte[] getSel_bt_arquivo() {
        return sel_bt_arquivo;
    }

    public void setSel_tx_promocional(String sel_tx_promocional) {
        this.sel_tx_promocional = sel_tx_promocional;
    }

    public String getSel_tx_promocional() {
        return sel_tx_promocional;
    }

    /**
     * @return the sel_dt_cadastro
     */
    public Date getSel_dt_cadastro() {
        return sel_dt_cadastro;
    }

    /**
     * @param sel_dt_cadastro the sel_dt_cadastro to set
     */
    public void setSel_dt_cadastro(Date sel_dt_cadastro) {
        this.sel_dt_cadastro = sel_dt_cadastro;
    }

    /**
     * @return the sel_dt_validadeinicio
     */
    public Date getSel_dt_validadeinicio() {
        return sel_dt_validadeinicio;
    }

    /**
     * @param sel_dt_validadeinicio the sel_dt_validadeinicio to set
     */
    public void setSel_dt_validadeinicio(Date sel_dt_validadeinicio) {
        this.sel_dt_validadeinicio = sel_dt_validadeinicio;
    }

    /**
     * @return the sel_dt_validadefim
     */
    public Date getSel_dt_validadefim() {
        return sel_dt_validadefim;
    }

    /**
     * @param sel_dt_validadefim the sel_dt_validadefim to set
     */
    public void setSel_dt_validadefim(Date sel_dt_validadefim) {
        this.sel_dt_validadefim = sel_dt_validadefim;
    }
}
