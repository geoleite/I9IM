
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
public class Cor_correcaoTGWT extends BaseModel {

    public Cor_correcaoTGWT() {
    }

    public int getCor_nr_id() {
        return ((Integer) get("cor_nr_id")).intValue();
//    return get("cor_nr_id");
    }

    public void setCor_nr_id(int cor_nr_id) {
        set("cor_nr_id", cor_nr_id);
    }

    public int getTic_nr_id() {
        return ((Integer) get("tic_nr_id")).intValue();
//    return get("tic_nr_id");
    }

    public void setTic_nr_id(int tic_nr_id) {
        set("tic_nr_id", tic_nr_id);
    }

    public String getCor_tx_observacao() {
        return get("cor_tx_observacao");
//    return get("cor_tx_observacao");
    }

    public void setCor_tx_observacao(String cor_tx_observacao) {
        set("cor_tx_observacao", cor_tx_observacao);
    }

    public int getSet_nr_id() {
        return ((Integer) get("set_nr_id")).intValue();
//    return get("set_nr_id");
    }

    public void setSet_nr_id(int set_nr_id) {
        set("set_nr_id", set_nr_id);
    }

    public int getUsu_nr_id() {
        return ((Integer) get("usu_nr_id")).intValue();
//    return get("usu_nr_id");
    }

    public void setUsu_nr_id(int usu_nr_id) {
        set("usu_nr_id", usu_nr_id);
    }

    public String getCor_tx_status() {
        return get("cor_tx_status");
//    return get("cor_tx_status");
    }

    public void setCor_tx_status(String cor_tx_status) {
        set("cor_tx_status", cor_tx_status);
    }

    public int getCor_nr_posx() {
        return ((Integer) get("cor_nr_posx")).intValue();
//    return get("cor_nr_posx");
    }

    public void setCor_nr_posx(int cor_nr_posx) {
        set("cor_nr_posx", cor_nr_posx);
    }

    public int getCor_nr_posy() {
        return ((Integer) get("cor_nr_posy")).intValue();
//    return get("cor_nr_posy");
    }

    public void setCor_nr_posy(int cor_nr_posy) {
        set("cor_nr_posy", cor_nr_posy);
    }


    public int getCor_nr_posx2() {
        return ((Integer) get("cor_nr_posx2")).intValue();
    }

    public void setCor_nr_posx2(int cor_nr_posx) {
        set("cor_nr_posx2", cor_nr_posx);
    }

    public int getCor_nr_posy2() {
        return ((Integer) get("cor_nr_posy2")).intValue();
    }

    public void setCor_nr_posy2(int cor_nr_posy) {
        set("cor_nr_posy2", cor_nr_posy);
    }

    public int getReg_nr_id() {
        return ((Integer) get("reg_nr_id")).intValue();
//    return get("reg_nr_id");
    }

    public void setReg_nr_id(int reg_nr_id) {
        set("reg_nr_id", reg_nr_id);
    }

    public Date getCor_dt_corrigido() {
        return (Date) get("cor_dt_corrigido");
//    return get("cor_dt_corrigido");
    }

    public void setCor_dt_corrigido(Date cor_dt_corrigido) {
        set("cor_dt_corrigido", cor_dt_corrigido);
    }

    public int getPag_nr_id() {
        return ((Integer) get("pag_nr_id")).intValue();
//    return get("pag_nr_id");
    }

    public void setPag_nr_id(int pag_nr_id) {
        set("pag_nr_id", pag_nr_id);
    }
}
