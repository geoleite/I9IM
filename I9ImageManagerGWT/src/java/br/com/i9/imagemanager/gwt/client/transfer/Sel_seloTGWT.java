
/*
 * EasyNet JDragon
 */
package br.com.i9.imagemanager.gwt.client.transfer;

import com.extjs.gxt.ui.client.data.BaseModel;
import java.util.Date;

/**
 *
 * @author geoleite
 */
public class Sel_seloTGWT extends BaseModel {

    public Sel_seloTGWT() {
    }

    public int getSel_nr_id() {
        return ((Integer) get("sel_nr_id")).intValue();
//    return get("sel_nr_id");
    }

    public void setSel_nr_id(int sel_nr_id) {
        set("sel_nr_id", sel_nr_id);
    }

    public int getCls_nr_id() {
        return ((Integer) get("cls_nr_id")).intValue();
//    return get("cls_nr_id");
    }

    public void setCls_nr_id(int cls_nr_id) {
        set("cls_nr_id", cls_nr_id);
    }

    public int getTid_nr_id() {
        return ((Integer) get("tid_nr_id")).intValue();
//    return get("tid_nr_id");
    }

    public void setTid_nr_id(int tid_nr_id) {
        set("tid_nr_id", tid_nr_id);
    }

    public String getSel_tx_nome() {
        return get("sel_tx_nome");
//    return get("sel_tx_nome");
    }

    public void setSel_tx_nome(String sel_tx_nome) {
        set("sel_tx_nome", sel_tx_nome);
    }

    public String getSel_tx_descricao() {
        return get("sel_tx_descricao");
//    return get("sel_tx_descricao");
    }

    public void setSel_tx_descricao(String sel_tx_descricao) {
        set("sel_tx_descricao", sel_tx_descricao);
    }

    public Date getSel_dt_cadastro() {
        return (Date) get("sel_dt_cadastro");
//    return get("sel_dt_cadastro");
    }

    public void setSel_dt_cadastro(Date sel_dt_cadastro) {
        set("sel_dt_cadastro", sel_dt_cadastro);
    }

    public String getSel_tx_situacao() {
        return get("sel_tx_situacao");
//    return get("sel_tx_situacao");
    }

    public void setSel_tx_situacao(String sel_tx_situacao) {
        set("sel_tx_situacao", sel_tx_situacao);
    }

    public void setSel_bt_arquivo(byte[] sel_bt_arquivo) {
        set("sel_bt_arquivo", sel_bt_arquivo);
    }

    public Date getSel_dt_validadeinicio() {
        return (Date) get("sel_dt_validadeinicio");
//    return get("sel_dt_validadeinicio");
    }

    public void setSel_dt_validadeinicio(Date sel_dt_validadeinicio) {
        set("sel_dt_validadeinicio", sel_dt_validadeinicio);
    }

    public Date getSel_dt_validadefim() {
        return (Date) get("sel_dt_validadefim");
//    return get("sel_dt_validadefim");
    }

    public void setSel_dt_validadefim(Date sel_dt_validadefim) {
        set("sel_dt_validadefim", sel_dt_validadefim);
    }

    public String getSel_tx_promocional() {
        return get("sel_tx_promocional");
//    return get("sel_tx_promocional");
    }

    public void setSel_tx_promocional(String sel_tx_promocional) {
        set("sel_tx_promocional", sel_tx_promocional);
    }
}

