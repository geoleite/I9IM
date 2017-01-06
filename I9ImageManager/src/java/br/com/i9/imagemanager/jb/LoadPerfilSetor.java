/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.imagemanager.jb;

import br.com.easynet.easyportal.transfer.Usu_usuarioT;
import br.com.i9.imagemanager.dao.Use_usuario_setorDAO;
import br.com.i9.imagemanager.transfer.Use_usuario_setorT;
import java.util.List;

/**
 *
 * @author geoleite 
 */
public class LoadPerfilSetor extends SystemBase {

    public void pageLoad() {
        try {
            Usu_usuarioT usuT = (Usu_usuarioT)getSession().getAttribute(br.com.easynet.portal.jb.SystemBase.USER_PRINCIPAL);
            setUsuarioLogado(usuT);
        //    SystemBase sb = new SystemBase();
            Use_usuario_setorT useT = new Use_usuario_setorT();
            useT.setUsu_nr_id(usuT.getUsu_nr_id());
            Use_usuario_setorDAO useDao = getUse_usuario_setorDAO();
            List<Use_usuario_setorT> list = useDao.getByUsu_nr_id(useT);
            if (list.size() > 0) {
                useT = list.get(0);
                getSession().setAttribute(PERFIL_SETOR, useT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
}
