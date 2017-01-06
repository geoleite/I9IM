package br.com.i9.imagemanager.jb;


import br.com.i9.imagemanager.jb.SystemBase;
import br.com.i9.imagemanager.transfer.EncarteT;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author geoleite
 */
public class EncarteSalvarComentarioJB extends SystemBase {
    private EncarteT encarteT = new EncarteT();
    public void salvarComentario() {
        if (encarteT.getComentario() != null && encarteT.getComentario().trim().length() > 0) {
            List<EncarteT> lista = (List<EncarteT>)getSession().getAttribute("encarte");
            if (lista == null) {
                lista = new ArrayList<EncarteT>();
            }
            lista.add(encarteT);
            getSession().setAttribute("encarte", lista);
        }
    }

    /**
     * @return the encarteT
     */
    public EncarteT getEncarteT() {
        return encarteT;
    }

    /**
     * @param encarteT the encarteT to set
     */
    public void setEncarteT(EncarteT encarteT) {
        this.encarteT = encarteT;
    }
}
