/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.util;

import br.com.i9.imagemanager.dao.Set_setorNewDAO;
import br.com.i9.imagemanager.transfer.Gru_grupoT;
import br.com.i9.imagemanager.transfer.Pro_produtoT;
import br.com.i9.imagemanager.transfer.Ses_sessaoT;
import br.com.i9.imagemanager.transfer.Set_setorNewT;
import br.com.i9.imagemanager.transfer.Set_setorT;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 *
 * @author geoleite
 */
public class ExcelProdutos {

    private String titulo = "";
    private List<Pro_produtoT> listProdutos;
    private TreeMap<String, Set_setorNewT> treeSetor;
    private TreeMap<String, Set_setorNewT> treeSessao;
    private Set_setorNewDAO setDao;
    public static void main(String[] p) {
        ExcelProdutos ep = new ExcelProdutos();
        ep.gerarExcel();
    }

    /**
     * Inicia a geracao do evento
     */
    public byte[] gerarExcel() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            WritableWorkbook workbook = Workbook.createWorkbook(baos);
            WritableSheet sheet = workbook.createSheet("Produtos", 0);
            String[] cabecalho = {"Setor", "Sessao", "Cod Produto", "Produto"};

            WritableFont arial12font = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD);
            WritableCellFormat arial12format = new WritableCellFormat(arial12font);
            WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 10);
            WritableCellFormat arial10format = new WritableCellFormat(arial10font);

            for (int i = 0; i < cabecalho.length; i++) {
                String title = cabecalho[i];
                Label label = new Label(i, 0, title, arial10format);
                sheet.addCell(label);
            }
            int y = 1;
            //for (Pro_produtoT proT : listProdutos) {
            for (int i = 0; i < listProdutos.size(); i++) {
                Pro_produtoT proT = listProdutos.get(i);
                /*
                String idSapSetorProduto = "";
                if (proT.getPro_tx_idsap() != null && proT.getPro_tx_idsap().trim().length() > 0) {
                idSapSetorProduto = proT.getPro_tx_idsap().substring(0, 2);
                } else {
                Set_setorNewT setT = new Set_setorNewT();
                setT.setSet_nr_id(proT.getSet_nr_id());
                List<Set_setorNewT> listSet = getSet_setorNewDAO().getBySet_nr_id(setT);
                if (listSet.size() > 0) {
                setT = listSet.get(0);
                idSapSetorProduto = setT.getSet_tx_idsap().substring(0, 2);
                }
                }

                 */
                int x = 0;
                String setorProdutoSap = "";
                if (proT.getPro_tx_idsap() != null && proT.getPro_tx_idsap().length() > 0) {
                    setorProdutoSap = proT.getPro_tx_idsap();
                } else {
                    Set_setorNewT setT = new Set_setorNewT();
                    setT.setSet_nr_id(proT.getSet_nr_id());
                    List<Set_setorNewT> listSet = setDao.getBySet_nr_id(setT);
                    if (listSet.size() > 0) {
                        setT = listSet.get(0);
                        setorProdutoSap = setT.getSet_tx_idsap();
                    }
                }
                //String setorProdutoSap = proT.getPro_tx_idsap();
                String idSetorSap = setorProdutoSap.substring(0, 2);
                String idSessaoSap = setorProdutoSap.substring(0, 4);
                Set_setorNewT sesT = treeSessao.get(idSessaoSap);
                Set_setorNewT setT = treeSetor.get(idSetorSap);
                StringBuffer sb = new StringBuffer();

                //Motando setor
                Label label = new Label(x++, y, setT.getSet_tx_nome(), arial10format);
                sheet.addCell(label);
                //Motando sessao
                label = new Label(x++, y, sesT.getSet_tx_nome(), arial10format);
                sheet.addCell(label);
                //Motando codigo produto
                label = new Label(x++, y, String.valueOf(proT.getPro_nr_id()), arial10format);
                sheet.addCell(label);
                //Motando produto
                label = new Label(x++, y++, proT.getPro_tx_nome(), arial10format);
                sheet.addCell(label);
            }

            workbook.write();
            workbook.close();
            return baos.toByteArray();
        } catch (Exception ex) {
            Logger.getLogger(ExcelProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the listProdutos
     */
    public List<Pro_produtoT> getListProdutos() {
        return listProdutos;
    }

    /**
     * @param listProdutos the listProdutos to set
     */
    public void setListProdutos(List<Pro_produtoT> listProdutos) {
        this.listProdutos = listProdutos;
    }

    /**
     * @return the treeSetor
     */
    public TreeMap<String, Set_setorNewT> getTreeSetor() {
        return treeSetor;
    }

    /**
     * @param treeSetor the treeSetor to set
     */
    public void setTreeSetor(TreeMap<String, Set_setorNewT> treeSetor) {
        this.treeSetor = treeSetor;
    }

    /**
     * @return the treeSesao
     */
    public TreeMap<String, Set_setorNewT> getTreeSessao() {
        return treeSessao;
    }

    /**
     * @param treeSesao the treeSesao to set
     */
    public void setTreeSessao(TreeMap<String, Set_setorNewT> treeSessao) {
        this.treeSessao = treeSessao;
    }

    /**
     * @param setDao the setDao to set
     */
    public void setSetDao(Set_setorNewDAO setDao) {
        this.setDao = setDao;
    }
}
