/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.jb;

import br.com.easynet.easyportal.transfer.Usu_usuarioT;
import br.com.i9.imagemanager.dao.Cor_correcaoDAO;
import br.com.i9.imagemanager.transfer.Cor_correcaoT;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class Uco_usuariocorrecaoConsultJB extends SystemBase {

    private Cor_correcaoT cor_correcaoT = new Cor_correcaoT();
    private List<Usu_usuarioT> list;
    public void consultByPagina() throws Exception {
        try {
            Cor_correcaoDAO cor_correcaoDAO = getCor_correcaoDAO();
            //cor_correcaoT.setUsu_nr_id(getUsuarioLogado().getUsu_nr_id());                        
            list = cor_correcaoDAO.getUsuariosByPagina(cor_correcaoT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    /**
     * @return the cor_correcaoT
     */
    public Cor_correcaoT getCor_correcaoT() {
        return cor_correcaoT;
    }

    /**
     * @param cor_correcaoT the cor_correcaoT to set
     */
    public void setCor_correcaoT(Cor_correcaoT cor_correcaoT) {
        this.cor_correcaoT = cor_correcaoT;
    }

    /**
     * @return the list
     */
    public List<Usu_usuarioT> getList() {
        return list;
    }
}
