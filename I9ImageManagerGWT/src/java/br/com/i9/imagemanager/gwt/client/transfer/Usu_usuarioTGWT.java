/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.transfer;

import com.extjs.gxt.ui.client.data.BaseModel;

/**
 *
 * @author geoleite
 */
public class Usu_usuarioTGWT extends BaseModel {

    public int getUsu_nr_id() {
        return ((Integer) get("usu_nr_id")).intValue();
    }

    public void setUsu_nr_id(int usu_nr_id) {
        set("usu_nr_id", usu_nr_id);
    }

    public String getUsu_tx_nome() {
        return (String) get("usu_tx_nome");
    }

    public void setUsu_tx_nome(String usu_tx_nome) {
        set("usu_tx_nome", usu_tx_nome);
    }

    public String getUsu_tx_login() {
        return (String) get("usu_tx_login");
    }

    public void setUsu_tx_login(String usu_tx_login) {
        set("usu_tx_login", usu_tx_login);
    }

    public String getUsu_tx_status() {
        return (String) get("usu_tx_status");
    }

    public void setUsu_tx_status(String usu_tx_status) {
        set("usu_tx_status", usu_tx_status);
    }

    public String getUsu_tx_email() {
        return (String) get("usu_tx_email");
    }

    public void setUsu_tx_email(String usu_tx_email) {
        set("usu_tx_email", usu_tx_email);
    }
}
