/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.imagemanager.jb;

import br.com.easynet.annotation.Conversion;
import br.com.i9.imagemanager.dao.Arq_arquivoDAO;
import br.com.i9.imagemanager.dao.Pro_produtoDAO;
import br.com.i9.imagemanager.transfer.Set_setorT;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author geoleite
 */
public class RelatorioSetorJB  extends SystemBase {
    
    private List<Set_setorT> listSet;
    //@Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private String dtInicio;
    //@Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private String dtFim;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private TreeMap<Integer, Integer> quantidadesSetor = new TreeMap<Integer, Integer>();
    private TreeMap<Integer, Integer> quantProdutoSetorImg = new TreeMap<Integer, Integer>();
    private TreeMap<Integer, Integer> quantidadesProdutoSetor = new TreeMap<Integer, Integer>();



    public void calcularImagensPeriodoSetor() {
        try {
            Date dtIni = sdf.parse(dtInicio);
            Date dtFinal = sdf.parse(dtFim);
            setListSet(getSet_setorDAO().getAll());
            Arq_arquivoDAO arqDao = getArq_arquivoDAO();
            Pro_produtoDAO proDao = getPro_produtoDAO();
            for (int i = 0; i < getListSet().size(); i++) {
                int qntImagens = arqDao.getCountIntervaloSetor(getListSet().get(i), dtIni, dtFinal);
                quantidadesSetor.put(getListSet().get(i).getSet_nr_id(), qntImagens);
                int qntProdutos = proDao.getQuantideProdutoSetor(listSet.get(i));
                quantidadesProdutoSetor.put(listSet.get(i).getSet_nr_id(), qntProdutos);
                int qntProdutosSetorImg = proDao.getQuantidadeProdutosSetorAfetadosImagem(listSet.get(i), dtIni, dtFinal);
                quantProdutoSetorImg.put(listSet.get(i).getSet_nr_id(), qntProdutosSetorImg) ;
            }
            //getArq_arquivoDAO().getCountIntervaloSetor(set_setorT, dtIni, dtFinal);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
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
     * @return the quantidadesSetor
     */
    public TreeMap<Integer, Integer> getQuantidadesSetor() {
        return quantidadesSetor;
    }

    /**
     * @param quantidadesSetor the quantidadesSetor to set
     */
    public void setQuantidadesSetor(TreeMap<Integer, Integer> quantidadesSetor) {
        this.quantidadesSetor = quantidadesSetor;
    }

    /**
     * @return the listSet
     */
    public List<Set_setorT> getListSet() {
        return listSet;
    }

    /**
     * @param listSet the listSet to set
     */
    public void setListSet(List<Set_setorT> listSet) {
        this.listSet = listSet;
    }

    /**
     * @return the quantidadesProdutoSetor
     */
    public TreeMap<Integer, Integer> getQuantidadesProdutoSetor() {
        return quantidadesProdutoSetor;
    }

    /**
     * @param quantidadesProdutoSetor the quantidadesProdutoSetor to set
     */
    public void setQuantidadesProdutoSetor(TreeMap<Integer, Integer> quantidadesProdutoSetor) {
        this.quantidadesProdutoSetor = quantidadesProdutoSetor;
    }

    /**
     * @return the quantProdutoSetorImg
     */
    public TreeMap<Integer, Integer> getQuantProdutoSetorImg() {
        return quantProdutoSetorImg;
    }

    /**
     * @param quantProdutoSetorImg the quantProdutoSetorImg to set
     */
    public void setQuantProdutoSetorImg(TreeMap<Integer, Integer> quantProdutoSetorImg) {
        this.quantProdutoSetorImg = quantProdutoSetorImg;
    }

}
