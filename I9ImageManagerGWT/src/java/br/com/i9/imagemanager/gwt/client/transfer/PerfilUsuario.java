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
public class PerfilUsuario extends BaseModel  {
    public String getPerfil() {
        return get("perfil");
    }
    public void setPerfil(String perfil) {
        set("perfil", perfil);
    }
}
