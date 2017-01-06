package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.i9.imagemanager.util.ExcelProdutos;
import java.util.TreeMap;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Pro_produtoConsultJB extends SystemBase {

    // Atributos e propriedades
    private Pro_produtoT pro_produtoT = new Pro_produtoT();
    private Cla_classificacaoT cla_classificacaoT = new Cla_classificacaoT();
    private Eve_eventoT eve_eventoT = new Eve_eventoT();
    private Sel_seloT sel_seloT = new Sel_seloT();
    private int count;
    private boolean excel = false;

    public void setPro_produtoT(Pro_produtoT pro_produtoT) {
        this.pro_produtoT = pro_produtoT;
    }

    public Pro_produtoT getPro_produtoT() {
        return pro_produtoT;
    }
    private List<Pro_produtoT> list;

    public List<Pro_produtoT> getList() {
        return list;
    }

    public void setList(List<Pro_produtoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //consult();
        eve_eventoT = findbyIdEve_evento(eve_eventoT);
    }

    public void consultProdutosSemImagens() throws Exception {
        try {
            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            list = pro_produtoDAO.getAllProdutosSemImagensClassificacao(cla_classificacaoT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultProdutosSemImagemBrutaEvento() throws Exception {
        try {
            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            Cla_classificacaoT claT = new Cla_classificacaoT();
            claT.setCla_nr_id(1);//Codigo Imagem Bruta
            list = pro_produtoDAO.getAllSemImagemByEvento(eve_eventoT, claT);
            if (excel) {
                montarExcel();
            }

        } catch (Exception e) {
        }
    }

    public void consultProdutosComImagemTratadaEvento() throws Exception {
        try {
            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            Cla_classificacaoT claT = new Cla_classificacaoT();
            claT.setCla_nr_id(2);//Codigo Imagem Tratada
            list = pro_produtoDAO.getAllComImagemByEvento(eve_eventoT, claT);
            if (excel) {
                montarExcel();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consultProdutosSemImagemTratadaEvento() throws Exception {
        try {
            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            Cla_classificacaoT claT = new Cla_classificacaoT();
            claT.setCla_nr_id(2);//Codigo Imagem Tratada
            list = pro_produtoDAO.getAllSemImagemByEvento(eve_eventoT, claT);
            if (excel) {
                montarExcel();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consultProdutosSemImagemWebEvento() throws Exception {
        try {
            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            Cla_classificacaoT claT = new Cla_classificacaoT();
            claT.setCla_nr_id(3);//Codigo Imagem Web
            list = pro_produtoDAO.getAllSemImagemByEvento(eve_eventoT, claT);
            if (excel) {
                montarExcel();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void consultDescricaoCodigo() throws Exception {
        try {
            try {
                int codigo = Integer.parseInt(pro_produtoT.getPro_tx_nome());
                pro_produtoT.setPro_nr_id(codigo);
                consultCodigo();
                return;
            } catch (Exception e) {
            }

            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            count = pro_produtoDAO.getByPro_tx_nomeCountGeral(pro_produtoT);
            if (count > 200) {
                list = pro_produtoDAO.getByPro_tx_nomeLimitGeral(pro_produtoT);
            } else {
                list = pro_produtoDAO.getByPro_tx_nomeGeral(pro_produtoT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void consultDescricaoCodigoSemImagem() throws Exception {
        try {
            try {
                int codigo = Integer.parseInt(pro_produtoT.getPro_tx_nome());
                pro_produtoT.setPro_nr_id(codigo);
                consultCodigo();
                return;
            } catch (Exception e) {
            }

            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            count = pro_produtoDAO.getByPro_tx_nomeCountGeralSemImagem(pro_produtoT);
            if (count > 200) {
                list = pro_produtoDAO.getByPro_tx_nomeLimitGeralSemImagem(pro_produtoT);
            } else {
                list = pro_produtoDAO.getByPro_tx_nomeGeralSemImagem(pro_produtoT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void consultDescricaoCodigoImagem() throws Exception {
        try {
            try {
                int codigo = Integer.parseInt(pro_produtoT.getPro_tx_nome());
                pro_produtoT.setPro_nr_id(codigo);
                consultCodigo();
                return;
            } catch (Exception e) {
            }

            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            count = pro_produtoDAO.getByPro_tx_nomeCountGeralImagem(pro_produtoT);
            if (count > 200) {
                list = pro_produtoDAO.getByPro_tx_nomeLimitGeralImagem(pro_produtoT);
            } else {
                list = pro_produtoDAO.getByPro_tx_nomeGeralImagem(pro_produtoT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void consultDescricao() throws Exception {
        try {

            // Verificando se o valor informado no nome contem apenas dígitos,
            // caso positivo pesquisa o produto pelo código
            try {
                int codigo = Integer.parseInt(pro_produtoT.getPro_tx_nome());
                pro_produtoT.setPro_nr_id(codigo);
                consultCodigo();
                return;
            } catch (Exception e) {
            }


            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            count = pro_produtoDAO.getByPro_tx_nomeCount(pro_produtoT);
            if (count > 200) {
                list = pro_produtoDAO.getByPro_tx_nomeLimit(pro_produtoT);
            } else {
                list = pro_produtoDAO.getByPro_tx_nome(pro_produtoT);
            }

        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    /**
     * Pesquisando pelo codigo
     * @throws Exception
     */
    public void consultCodigo() throws Exception {
        try {
            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            list = pro_produtoDAO.getByPK(pro_produtoT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consult() throws Exception {
        try {

            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            count = pro_produtoDAO.getAllSessaoGrupoCount(pro_produtoT);
            if (count > 200) {
                list = pro_produtoDAO.getAllSessaoGrupoLimit(pro_produtoT);
            } else {
                list = pro_produtoDAO.getAllSessaoGrupo(pro_produtoT);
            }

        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultImagem() throws Exception {
        try {

            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            count = pro_produtoDAO.getAllSessaoGrupoCountImagem(pro_produtoT);
            if (count > 200) {
                list = pro_produtoDAO.getAllSessaoGrupoLimitImagem(pro_produtoT);
            } else {
                list = pro_produtoDAO.getAllSessaoGrupoImagem(pro_produtoT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultSemImagem() throws Exception {
        try {

            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            count = pro_produtoDAO.getAllSessaoGrupoCountSemImagem(pro_produtoT);
            if (count > 200) {
                list = pro_produtoDAO.getAllSessaoGrupoLimitSemImagem(pro_produtoT);
            } else {
                list = pro_produtoDAO.getAllSessaoGrupoSemImagem(pro_produtoT);
            }

        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    /**
     * Monta um exel com a lista dos produtos
     * @throws Exception
     */
    private void montarExcel() throws Exception {
        TreeMap<String, Set_setorNewT> treeSetor = new TreeMap<String, Set_setorNewT>();
        TreeMap<String, Set_setorNewT> treeSessao = new TreeMap<String, Set_setorNewT>();
        

        //Montando o tree do Setor
        List<Set_setorNewT> listSet = getSet_setorNewDAO().getAllSemPai();
        for (Set_setorNewT set_setorT : listSet) {
            treeSetor.put(set_setorT.getSet_tx_idsap(), set_setorT);
        }

        //Montando o tree da sessao
        List<Set_setorNewT> listSes = getSet_setorNewDAO().getAllNivel1();
        for (Set_setorNewT ses_sessaoT : listSes) {
            treeSessao.put(ses_sessaoT.getSet_tx_idsap(), ses_sessaoT);
        }

        ExcelProdutos excelProdutos = new ExcelProdutos();
        excelProdutos.setSetDao(getSet_setorNewDAO());
        excelProdutos.setTreeSetor(treeSetor);
        excelProdutos.setTreeSessao(treeSessao);

        excelProdutos.setTitulo("Produtos do Evento " + eve_eventoT.getEve_tx_nome());
        excelProdutos.setListProdutos(list);
        byte[] arquivoExcel = excelProdutos.gerarExcel();
        getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "application/vnd.ms-excel");
        getRequest().setAttribute(EasyDownloadJB.FILE_NAME, eve_eventoT.getEve_tx_nome().concat(".xls"));
        getRequest().setAttribute(EasyDownloadJB.DATA, arquivoExcel);
        getPage().forward("../../../portal/easydownload.jsp");
    }

    public void consultProdutosEvento() throws Exception {
        try {

            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            list = pro_produtoDAO.getAllByEvento(eve_eventoT);
            if (excel) {
                montarExcel();
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultProdutosNaoSeloDescricao() throws Exception {
        try {

            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            try {
                int codigo = Integer.parseInt(pro_produtoT.getPro_tx_nome());
                pro_produtoT.setPro_nr_id(codigo);
                list = pro_produtoDAO.getAllByNaoSeloCodigo(sel_seloT, pro_produtoT);
                return;
            } catch (Exception e) {
            }

            count = pro_produtoDAO.getAllByNaoSeloDescricaoCount(sel_seloT, pro_produtoT);
            if (count > 200) {
                list = pro_produtoDAO.getAllByNaoSeloDescricaoLimit(sel_seloT, pro_produtoT);
            } else {
                list = pro_produtoDAO.getAllByNaoSeloDescricao(sel_seloT, pro_produtoT);
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultProdutosSelo() throws Exception {
        try {

            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            list = pro_produtoDAO.getAllBySelo(sel_seloT);

        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
            pro_produtoDAO.delete(pro_produtoT);
            setMsg("Exclusao efetuada com sucesso!");
            pro_produtoT = new Pro_produtoT();
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar exclusao!");
        } finally {
            close();
        }
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "pro_produtoInsert.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @return the cla_classificacaoT
     */
    public Cla_classificacaoT getCla_classificacaoT() {
        return cla_classificacaoT;
    }

    /**
     * @param cla_classificacaoT the cla_classificacaoT to set
     */
    public void setCla_classificacaoT(Cla_classificacaoT cla_classificacaoT) {
        this.cla_classificacaoT = cla_classificacaoT;
    }

    /**
     * @return the eve_eventoT
     */
    public Eve_eventoT getEve_eventoT() {
        return eve_eventoT;
    }

    /**
     * @param eve_eventoT the eve_eventoT to set
     */
    public void setEve_eventoT(Eve_eventoT eve_eventoT) {
        this.eve_eventoT = eve_eventoT;
    }

    /**
     * @return the sel_seloT
     */
    public Sel_seloT getSel_seloT() {
        return sel_seloT;
    }

    /**
     * @param sel_seloT the sel_seloT to set
     */
    public void setSel_seloT(Sel_seloT sel_seloT) {
        this.sel_seloT = sel_seloT;
    }

    /**
     * @return the excel
     */
    public boolean isExcel() {
        return excel;
    }

    /**
     * @param excel the excel to set
     */
    public void setExcel(boolean excel) {
        this.excel = excel;
    }
}
