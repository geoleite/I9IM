/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.imagemanager.jb;

import br.com.easynet.annotation.Conversion;
import br.com.i9.imagemanager.transfer.Set_setorT;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author geoleite
 */
public class RelatorioJB  extends SystemBase {
    private int qntImagens, qntProdutos;
    private Set_setorT set_setorT = new Set_setorT();
    //@Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private String dtInicio;
    //@Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private String dtFim;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    
    public void calcularImagensPeriodo() {
        try {
            Date dtIni = sdf.parse(dtInicio);
            Date dtFinal = sdf.parse(dtFim);
            qntImagens = getArq_arquivoDAO().getCountIntervalo(dtIni, dtFinal);
            qntProdutos = getPro_produtoDAO().getCountTotalAfetadoImg(dtIni, dtFinal);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void totalImagens() {
        try {
            qntImagens = getArq_arquivoDAO().getCountTotal();
            qntProdutos = getPro_produtoDAO().getCountTotalAfetadoImg();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void totalSelos() {
        try {
            qntImagens = getSel_seloDAO().getCountTotal();
            qntProdutos = getPro_produtoDAO().getCountTotal();
        } catch (Exception e) {
        } finally {
            close();
        }
    }

    public void total() {
        try {
            qntImagens = getArq_arquivoDAO().getCountTotal();
            qntImagens += getSel_seloDAO().getCountTotal();
            qntProdutos = getPro_produtoDAO().getCountTotal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }
    
    public void calcularImagensPeriodoSetor() {
        try {
            Date dtIni = sdf.parse(dtInicio);
            Date dtFinal = sdf.parse(dtFim);
            qntImagens = getArq_arquivoDAO().getCountIntervaloSetor(set_setorT, dtIni, dtFinal);
            qntProdutos = getPro_produtoDAO().getCountTotal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    /**
     * @return the qntImagens
     */
    public int getQntImagens() {
        return qntImagens;
    }

    /**
     * @param qntImagens the qntImagens to set
     */
    public void setQntImagens(int qntImagens) {
        this.qntImagens = qntImagens;
    }

  
    /**
     * @return the set_setorT
     */
    public Set_setorT getSet_setorT() {
        return set_setorT;
    }

    /**
     * @param set_setorT the set_setorT to set
     */
    public void setSet_setorT(Set_setorT set_setorT) {
        this.set_setorT = set_setorT;
    }

    /**
     * @return the dtInicio
     */
    public String getDtInicio() {
        return dtInicio;
    }

    /**
     * @param dtInicio the dtInicio to set
     */
    public void setDtInicio(String dtInicio) {
        this.dtInicio = dtInicio;
    }

    /**
     * @return the dtFim
     */
    public String getDtFim() {
        return dtFim;
    }

    /**
     * @param dtFim the dtFim to set
     */
    public void setDtFim(String dtFim) {
        this.dtFim = dtFim;
    }

    /**
     * @return the qntProdutos
     */
    public int getQntProdutos() {
        return qntProdutos;
    }

    /**
     * @param qntProdutos the qntProdutos to set
     */
    public void setQntProdutos(int qntProdutos) {
        this.qntProdutos = qntProdutos;
    }

}
