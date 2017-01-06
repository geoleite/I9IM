package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Pro_produtoDAO extends ObjectDAO {

    public Pro_produtoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.pro_produto  ( pro_nr_id, pro_tx_nome, pro_nr_cdfamilia, pro_dt_atualizacao, pro_nr_valor, pro_tx_situacao, set_nr_id,  pro_tx_obs, pro_nr_idantigo, pro_tx_idsap) values ( ? , ? , ? , ? , ? , ? , ? , ? , ?, ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getPro_nr_id());
            pStmt.setObject(2, pro_produtoT.getPro_tx_nome());
            pStmt.setObject(3, pro_produtoT.getPro_nr_cdfamilia());
            java.sql.Date dt4 = new java.sql.Date(pro_produtoT.getPro_dt_atualizacao().getTime());
            pStmt.setObject(4, dt4);
            pStmt.setObject(5, pro_produtoT.getPro_nr_valor());
            pStmt.setObject(6, pro_produtoT.getPro_tx_situacao());
            pStmt.setObject(7, pro_produtoT.getSet_nr_id());
            pStmt.setObject(8, pro_produtoT.getPro_tx_obs());
            pStmt.setObject(9, pro_produtoT.getPro_nr_idantigo());
            pStmt.setObject(10, pro_produtoT.getPro_tx_idsap());
            pStmt.execute();
        } catch (Exception e) {
            //System.out.println("error:" + e.getMessage());
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void updateObs(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.pro_produto set  pro_tx_obs=?  where  pro_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getPro_tx_obs());
            pStmt.setObject(2, pro_produtoT.getPro_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void update(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.pro_produto set  pro_tx_nome=?, pro_nr_cdfamilia=?, pro_dt_atualizacao=?, pro_nr_valor=?, pro_tx_situacao=?, set_nr_id=?, pro_tx_obs=?, pro_tx_idsap=?  where  pro_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getPro_tx_nome());
            pStmt.setObject(2, pro_produtoT.getPro_nr_cdfamilia());
            java.sql.Date dt3 = new java.sql.Date(pro_produtoT.getPro_dt_atualizacao().getTime());
            pStmt.setObject(3, dt3);
            pStmt.setObject(4, pro_produtoT.getPro_nr_valor());
            pStmt.setObject(5, pro_produtoT.getPro_tx_situacao());
            pStmt.setObject(6, pro_produtoT.getSet_nr_id());
            pStmt.setObject(7, pro_produtoT.getPro_tx_obs());
            pStmt.setObject(8, pro_produtoT.getPro_tx_idsap());
            pStmt.setObject(9, pro_produtoT.getPro_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void updateParcial(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.pro_produto set  pro_tx_nome=?, pro_dt_atualizacao=?, pro_tx_situacao=?, set_nr_id=? where  pro_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getPro_tx_nome());
            java.sql.Date dt3 = new java.sql.Date(pro_produtoT.getPro_dt_atualizacao().getTime());
            pStmt.setObject(2, dt3);
            pStmt.setObject(3, pro_produtoT.getPro_tx_situacao());
            pStmt.setObject(4, pro_produtoT.getSet_nr_id());
            pStmt.setObject(5, pro_produtoT.getPro_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void delete(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.pro_produto where  pro_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getPro_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    private List<Pro_produtoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Pro_produtoT> objs = new Vector();
        while (rs.next()) {
            Pro_produtoT pro_produtoT = new Pro_produtoT();
            pro_produtoT.setPro_nr_id(rs.getInt("pro_nr_id"));
            pro_produtoT.setPro_nr_idantigo(rs.getInt("pro_nr_idantigo"));
            pro_produtoT.setPro_tx_nome(rs.getString("pro_tx_nome"));
            pro_produtoT.setPro_nr_cdfamilia(rs.getInt("pro_nr_cdfamilia"));
            pro_produtoT.setPro_dt_atualizacao(rs.getDate("pro_dt_atualizacao"));
            pro_produtoT.setPro_nr_valor(rs.getFloat("pro_nr_valor"));
            pro_produtoT.setPro_tx_situacao(rs.getString("pro_tx_situacao"));
            pro_produtoT.setSet_nr_id(rs.getInt("set_nr_id"));
            pro_produtoT.setPro_tx_obs(rs.getString("pro_tx_obs"));
            pro_produtoT.setPro_tx_idsap(rs.getString("pro_tx_idsap"));
            pro_produtoT.setPro_tx_nome(pro_produtoT.getPro_tx_nome().replaceAll("\"", "'"));
            objs.add(pro_produtoT);
        }
        return objs;
    }

    /**
     * Obtém a quantidade de produtos afetados pelas imagens inseridas no periodo
     * @param dtInicio
     * @param dtFinal
     * @return
     * @throws Exception
     */
    public int getCountTotalAfetadoImg(java.util.Date dtInicio, java.util.Date dtFinal) throws Exception{
        //
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from (select distinct arq.pro_nr_id from i9im.pro_produto pro, i9im.arq_arquivo arq  where arq.pro_nr_id = pro.pro_nr_id  and arq.arq_dt_cadastro between ?  and ? ) vw";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt = new java.sql.Date(dtInicio.getTime());
            pStmt.setObject(1, dt);
            dt = new java.sql.Date(dtFinal.getTime());
            pStmt.setObject(2, dt);
            rs = pStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
        return 0;
    }

    public int getCountTotalAfetadoImg() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from (select distinct arq.pro_nr_id from i9im.pro_produto pro, i9im.arq_arquivo arq  where arq.pro_nr_id = pro.pro_nr_id  ) vw";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
        return 0;
    }
    public int getCountTotal() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(pro_nr_id) from i9im.pro_produto where pro_tx_situacao='A'";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
        return 0;
    }

    public List<Pro_produtoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_produto order by pro_tx_nome limit 200";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Pro_produtoT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Pro_produtoT> getAllProdutosSemImagensClassificacao(Cla_classificacaoT claT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(pro.*) from i9im.pro_produto pro where pro.pro_nr_id not in (select distinct pro_nr_id from i9im.arq_arquivo arq where arq.cla_nr_id=1) order by pro_tx_nome limit 1000";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Pro_produtoT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public int getAllSessaoGrupoCount(Pro_produtoT proT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(pro.pro_nr_id) from i9im.pro_produto pro, i9im.set_setor setor where setor.set_nr_id=? and pro.pro_tx_idsap like setor.set_tx_idsap||'%' ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, proT.getSet_nr_id());
            rs = pStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public int getAllSessaoGrupoCountImagem(Pro_produtoT proT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(pro_nr_id) from i9im.pro_produto pro, i9im.set_setor setor where setor.set_nr_id=? and pro.pro_tx_idsap like setor.set_tx_idsap||'%' and pro.pro_nr_id in (select distinct pro_nr_id from i9im.arq_arquivo arq where arq.pro_nr_id=pro.pro_nr_id and arq.arq_tx_situacao='A')";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, proT.getSet_nr_id());
            rs = pStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public int getAllSessaoGrupoCountSemImagem(Pro_produtoT proT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(pro_nr_id) from i9im.pro_produto pro , i9im.set_setor setor where setor.set_nr_id=? and pro.pro_tx_idsap like setor.set_tx_idsap||'%' and pro.pro_nr_id not in (select distinct pro_nr_id from i9im.arq_arquivo arq where arq.pro_nr_id=pro.pro_nr_id and arq.arq_tx_situacao='A') ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, proT.getSet_nr_id());
            rs = pStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }


    public List<Pro_produtoT> getAllSessaoGrupoLimit(Pro_produtoT proT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro.* from i9im.pro_produto pro, i9im.set_setor setor where setor.set_nr_id=? and pro.pro_tx_idsap like setor.set_tx_idsap||'%'  order by pro_tx_nome limit 200";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, proT.getSet_nr_id());
            rs = pStmt.executeQuery();
            List<Pro_produtoT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public List<Pro_produtoT> getAllSessaoGrupoLimitImagem(Pro_produtoT proT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro.* from i9im.pro_produto pro, i9im.set_setor setor where setor.set_nr_id=? and pro.pro_tx_idsap like setor.set_tx_idsap||'%' and pro.pro_nr_id in (select distinct pro_nr_id from i9im.arq_arquivo arq where arq.pro_nr_id=pro.pro_nr_id and arq.arq_tx_situacao='A')  order by pro_tx_nome limit 200";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, proT.getSet_nr_id());
            rs = pStmt.executeQuery();
            List<Pro_produtoT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public List<Pro_produtoT> getAllSessaoGrupoLimitSemImagem(Pro_produtoT proT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro.* from i9im.pro_produto pro , i9im.set_setor setor where setor.set_nr_id=? and pro.pro_tx_idsap like setor.set_tx_idsap||'%' and pro.pro_nr_id not in (select distinct pro_nr_id from i9im.arq_arquivo arq where arq.pro_nr_id=pro.pro_nr_id and arq.arq_tx_situacao='A')  order by pro_tx_nome limit 200";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, proT.getSet_nr_id());
            rs = pStmt.executeQuery();
            List<Pro_produtoT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public List<Pro_produtoT> getAllByEvento(Eve_eventoT eveT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro.* from i9im.pro_produto pro, i9im.pro_eve pe where pe.eve_nr_id=? and pe.pro_nr_id=pro.pro_nr_id order by pro_tx_nome ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eveT.getEve_nr_id());
            rs = pStmt.executeQuery();
            List<Pro_produtoT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public List<Pro_produtoT> getAllBySelo(Sel_seloT selT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro.* from i9im.pro_produto pro, i9im.pro_sel ps where ps.sel_nr_id=? and ps.pro_nr_id=pro.pro_nr_id order by pro_tx_nome ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, selT.getSel_nr_id());
            rs = pStmt.executeQuery();
            List<Pro_produtoT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    /**
     * Obtém a quantidade de produtos trazidos pela consulta
     * @param proT
     * @return
     * @throws Exception
     */
    public int getAllByNaoSeloDescricaoCount(Sel_seloT selT, Pro_produtoT proT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String nome = proT.getPro_tx_nome();
            String[] palavras = nome.split(" ");
            StringBuffer sql = new StringBuffer("select count(pro.pro_nr_id) from i9im.pro_produto pro where pro.pro_nr_id not in (select ps.pro_nr_id from i9im.pro_sel ps where ps.sel_nr_id=? ) and  ");
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    sql.append(" Upper(pro.pro_tx_nome) like Upper(?) and ");
                }
            }

            sql.append("1=1 ");

            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, selT.getSel_nr_id());

            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    pStmt.setObject(i + 2, "%".concat(palavra).concat("%"));
                }
            }
            rs = pStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public List<Pro_produtoT> getAllByNaoSeloDescricaoLimit(Sel_seloT selT, Pro_produtoT proT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String nome = proT.getPro_tx_nome();
            String[] palavras = nome.split(" ");
            StringBuffer sql = new StringBuffer("select pro.* from i9im.pro_produto pro where pro.pro_nr_id not in (select ps.pro_nr_id from i9im.pro_sel ps where ps.sel_nr_id=? ) and  ");
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    sql.append(" Upper(pro.pro_tx_nome) like Upper(?) and ");
                }
            }

            sql.append("1=1 order by pro.pro_tx_nome  limit 200");

            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, selT.getSel_nr_id());

            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    pStmt.setObject(i + 2, "%".concat(palavra).concat("%"));
                }
            }

            rs = pStmt.executeQuery();
            List<Pro_produtoT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    /**
     * Pesquisa produtos pela descricao que não estão associados ao selo
     * @param selT
     * @param proT
     * @return
     * @throws Exception
     */
    public List<Pro_produtoT> getAllByNaoSeloDescricao(Sel_seloT selT, Pro_produtoT proT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String nome = proT.getPro_tx_nome();
            String[] palavras = nome.split(" ");
            StringBuffer sql = new StringBuffer("select pro.* from i9im.pro_produto pro where pro.pro_nr_id not in (select ps.pro_nr_id from i9im.pro_sel ps where ps.sel_nr_id=? ) and  ");
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    sql.append(" Upper(pro.pro_tx_nome) like Upper(?) and ");
                }
            }

            sql.append("1=1 order by pro.pro_tx_nome");

            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, selT.getSel_nr_id());

            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    pStmt.setObject(i + 2, "%".concat(palavra).concat("%"));
                }
            }
            rs = pStmt.executeQuery();
            List<Pro_produtoT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    /**
     * Pesquisa o produto pelo código que nao está assciado ao selo
     * @param selT
     * @param proT
     * @return
     * @throws Exception
     */
    public List<Pro_produtoT> getAllByNaoSeloCodigo(Sel_seloT selT, Pro_produtoT proT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro.* from i9im.pro_produto pro where pro.pro_nr_id not in (select ps.pro_nr_id from i9im.pro_sel ps where ps.sel_nr_id=? ) and pro.pro_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, selT.getSel_nr_id());
            pStmt.setObject(2, proT.getPro_nr_id());
            rs = pStmt.executeQuery();
            List<Pro_produtoT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public List<Pro_produtoT> getAllSemImagemByEvento(Eve_eventoT eveT, Cla_classificacaoT claT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_eve pe, i9im.pro_produto pro where pe.eve_nr_id=? and pe.pro_nr_id=pro.pro_nr_id and pro.pro_nr_id not in ( select distinct arq.pro_nr_id from i9im.pro_eve pe, i9im.arq_arquivo arq  where arq.arq_tx_situacao='A' and pe.eve_nr_id=? and arq.pro_nr_id=pe.pro_nr_id and arq.cla_nr_id=? ) order by pro.pro_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eveT.getEve_nr_id());
            pStmt.setObject(2, eveT.getEve_nr_id());
            pStmt.setObject(3, claT.getCla_nr_id());
            rs = pStmt.executeQuery();
            List<Pro_produtoT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public List<Pro_produtoT> getAllComImagemByEvento(Eve_eventoT eveT, Cla_classificacaoT claT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_eve pe, i9im.pro_produto pro where pe.eve_nr_id=? and pe.pro_nr_id=pro.pro_nr_id and pro.pro_nr_id in ( select distinct arq.pro_nr_id from i9im.pro_eve pe, i9im.arq_arquivo arq  where arq.arq_tx_situacao='A' and pe.eve_nr_id=? and arq.pro_nr_id=pe.pro_nr_id and arq.cla_nr_id=? ) order by pro.pro_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eveT.getEve_nr_id());
            pStmt.setObject(2, eveT.getEve_nr_id());
            pStmt.setObject(3, claT.getCla_nr_id());
            rs = pStmt.executeQuery();
            List<Pro_produtoT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }


    public List<Pro_produtoT> getAllSessaoGrupoSemImagem(Pro_produtoT proT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro.* from i9im.pro_produto pro , i9im.set_setor setor where setor.set_nr_id=? and pro.pro_tx_idsap like setor.set_tx_idsap||'%' and pro.pro_nr_id not in (select distinct pro_nr_id from i9im.arq_arquivo arq where arq.pro_nr_id=pro.pro_nr_id and arq.arq_tx_situacao='A') order by pro_tx_nome ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, proT.getSet_nr_id());
            rs = pStmt.executeQuery();
            List<Pro_produtoT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public List<Pro_produtoT> getAllSessaoGrupoImagem(Pro_produtoT proT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro.* from i9im.pro_produto pro, i9im.set_setor setor where setor.set_nr_id=? and pro.pro_tx_idsap like setor.set_tx_idsap||'%' and pro.pro_nr_id in (select distinct pro_nr_id from i9im.arq_arquivo arq where arq.pro_nr_id=pro.pro_nr_id and arq.arq_tx_situacao='A') order by pro_tx_nome ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, proT.getSet_nr_id());
            rs = pStmt.executeQuery();
            List<Pro_produtoT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }
    public List<Pro_produtoT> getAllSessaoGrupo(Pro_produtoT proT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro.* from i9im.pro_produto pro, i9im.set_setor setor where setor.set_nr_id=? and pro.pro_tx_idsap like setor.set_tx_idsap||'%'  order by pro_tx_nome ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, proT.getSet_nr_id());
            rs = pStmt.executeQuery();
            List<Pro_produtoT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public List<Pro_produtoT> getByPK(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_produto where  pro_nr_id=? or pro_nr_idantigo=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getPro_nr_id());
            pStmt.setObject(2, pro_produtoT.getPro_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public int getByIdSapAntigoId(int proNrId) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_produto where  pro_nr_id=? or pro_nr_idantigo=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, proNrId);
            pStmt.setObject(2, proNrId);
            rs = pStmt.executeQuery();
            List<Pro_produtoT> list = resultSetToObjectTransfer(rs);
            return list.size()>0?list.get(0).getPro_nr_id():0;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public List<Pro_produtoT> getBySelo(Sel_seloT selT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro.* from i9im.pro_produto pro, i9im.pro_sel ps where ps.sel_nr_id=? and ps.pro_nr_id=pro.pro_nr_id order by pro.pro_tx_nome ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, selT.getSel_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Pro_produtoT> getByPro_nr_id(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_produto where  pro_nr_id = ? or pro_nr_idantigo ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getPro_nr_id());
            pStmt.setObject(2, pro_produtoT.getPro_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }


    public int getByPro_tx_nomeCountGeralSemImagem(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String nome = pro_produtoT.getPro_tx_nome();
            String[] palavras = nome.split(" ");
            StringBuffer sql = new StringBuffer("select count(pro_nr_id) from i9im.pro_produto pro where ");
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    sql.append(" Upper(pro_tx_nome) like Upper(?) and ");
                }
            }

            sql.append(" 1=1 and pro.pro_nr_id not in (select distinct pro_nr_id from i9im.arq_arquivo arq where arq.pro_nr_id=pro.pro_nr_id and arq.arq_tx_situacao='A') ");

            pStmt = con.prepareStatement(sql.toString());
            String str = pro_produtoT.getPro_tx_nome();
//            str = str.replaceAll(" ", "%");
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    pStmt.setObject(i + 1, "%".concat(palavra).concat("%"));
                }
            }
            rs = pStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }



    public int getByPro_tx_nomeCountGeralImagem(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String nome = pro_produtoT.getPro_tx_nome();
            String[] palavras = nome.split(" ");
            StringBuffer sql = new StringBuffer("select count(pro_nr_id) from i9im.pro_produto pro where ");
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    sql.append(" Upper(pro_tx_nome) like Upper(?) and ");
                }
            }

            sql.append(" 1=1 and pro.pro_nr_id in (select distinct pro_nr_id from i9im.arq_arquivo arq where arq.pro_nr_id=pro.pro_nr_id and arq.arq_tx_situacao='A') ");

            pStmt = con.prepareStatement(sql.toString());
            String str = pro_produtoT.getPro_tx_nome();
//            str = str.replaceAll(" ", "%");
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    pStmt.setObject(i + 1, "%".concat(palavra).concat("%"));
                }
            }
            rs = pStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }
    public int getByPro_tx_nomeCountGeral(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String nome = pro_produtoT.getPro_tx_nome();
            String[] palavras = nome.split(" ");
            StringBuffer sql = new StringBuffer("select count(pro_nr_id) from i9im.pro_produto where ");
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    sql.append(" Upper(pro_tx_nome) like Upper(?) and ");
                }
            }

            sql.append(" 1=1 ");

            pStmt = con.prepareStatement(sql.toString());
            String str = pro_produtoT.getPro_tx_nome();
//            str = str.replaceAll(" ", "%");
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    pStmt.setObject(i + 1, "%".concat(palavra).concat("%"));
                }
            }
            rs = pStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }


    public int getByPro_tx_nomeCount(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String nome = pro_produtoT.getPro_tx_nome();
            String[] palavras = nome.split(" ");
            StringBuffer sql = new StringBuffer("select count(pro_nr_id) from i9im.pro_produto pro, i9im.set_setor setor  where setor.set_nr_id=? and pro.pro_tx_idsap like setor.set_tx_idsap||'%' and ");
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    sql.append(" Upper(pro_tx_nome) like Upper(?) and ");
                }
            }
            sql.append("1=1 ");
            pStmt = con.prepareStatement(sql.toString());
            String str = pro_produtoT.getPro_tx_nome();
            pStmt.setObject(1, pro_produtoT.getSet_nr_id());

            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    pStmt.setObject(i + 2, "%".concat(palavra).concat("%"));
                }
            }

            rs = pStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Pro_produtoT> getByPro_tx_nomeLimit(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro.* from i9im.pro_produto pro, i9im.set_setor setor  where setor.set_nr_id=? and pro.pro_tx_idsap like setor.set_tx_idsap||'%' and Upper(pro_tx_nome) like Upper(?)  order by pro_tx_nome limit 200";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getSet_nr_id());
            String str = pro_produtoT.getPro_tx_nome();
            str = str.replaceAll(" ", "%");
            pStmt.setObject(3, "%".concat(str).concat("%"));

//            pStmt.setObject(3, '%' + pro_produtoT.getPro_tx_nome() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }


    public List<Pro_produtoT> getByPro_tx_nomeLimitGeralImagem(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String nome = pro_produtoT.getPro_tx_nome();
            String[] palavras = nome.split(" ");
            StringBuffer sql = new StringBuffer("select * from i9im.pro_produto where (");
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    sql.append(" Upper(pro_tx_nome) like Upper(?) and ");
                }
            }
            sql.append("1=1 ) and pro.pro_nr_id in (select distinct pro_nr_id from i9im.arq_arquivo arq where arq.pro_nr_id=pro.pro_nr_id and arq.arq_tx_situacao='A')  order by pro_tx_nome limit 200");

            pStmt = con.prepareStatement(sql.toString());
            String str = pro_produtoT.getPro_tx_nome();
//            str = str.replaceAll(" ", "%");
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    pStmt.setObject(i + 1, "%".concat(palavra).concat("%"));
                }
            }



//            pStmt.setObject(1, '%' + pro_produtoT.getPro_tx_nome() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }



    public List<Pro_produtoT> getByPro_tx_nomeLimitGeralSemImagem(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String nome = pro_produtoT.getPro_tx_nome();
            String[] palavras = nome.split(" ");
            StringBuffer sql = new StringBuffer("select * from i9im.pro_produto pro where (");
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    sql.append(" Upper(pro_tx_nome) like Upper(?) and ");
                }
            }
            sql.append("1=1 ) and pro.pro_nr_id not in (select distinct pro_nr_id from i9im.arq_arquivo arq where arq.pro_nr_id=pro.pro_nr_id and arq.arq_tx_situacao='A')  order by pro_tx_nome limit 200");

            pStmt = con.prepareStatement(sql.toString());
            String str = pro_produtoT.getPro_tx_nome();
//            str = str.replaceAll(" ", "%");
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    pStmt.setObject(i + 1, "%".concat(palavra).concat("%"));
                }
            }



//            pStmt.setObject(1, '%' + pro_produtoT.getPro_tx_nome() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }
    public List<Pro_produtoT> getByPro_tx_nomeLimitGeral(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String nome = pro_produtoT.getPro_tx_nome();
            String[] palavras = nome.split(" ");
            StringBuffer sql = new StringBuffer("select * from i9im.pro_produto where (");
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    sql.append(" Upper(pro_tx_nome) like Upper(?) and ");
                }
            }
            sql.append("1=1 ) order by pro_tx_nome limit 200");

            pStmt = con.prepareStatement(sql.toString());
            String str = pro_produtoT.getPro_tx_nome();
//            str = str.replaceAll(" ", "%");
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    pStmt.setObject(i + 1, "%".concat(palavra).concat("%"));
                }
            }



//            pStmt.setObject(1, '%' + pro_produtoT.getPro_tx_nome() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Pro_produtoT> getByPro_tx_nomeLimitGeralOld(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_produto where Upper(pro_tx_nome) like Upper(?)  order by pro_tx_nome limit 200";
            pStmt = con.prepareStatement(sql);
            String str = pro_produtoT.getPro_tx_nome();
            str = str.replaceAll(" ", "%");
            pStmt.setObject(1, "%".concat(str).concat("%"));

//            pStmt.setObject(1, '%' + pro_produtoT.getPro_tx_nome() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Pro_produtoT> getByPro_tx_nomeGeral(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String nome = pro_produtoT.getPro_tx_nome();
            String[] palavras = nome.split(" ");
            StringBuffer sql = new StringBuffer("select * from i9im.pro_produto where (");
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    sql.append(" Upper(pro_tx_nome) like Upper(?) and ");
                }
            }
            sql.append(" 1=1 ) order by pro_tx_nome ");

            pStmt = con.prepareStatement(sql.toString());
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    pStmt.setObject(i + 1, "%".concat(palavra).concat("%"));
                }
            }

//            pStmt.setObject(1, '%' + pro_produtoT.getPro_tx_nome() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }


    public List<Pro_produtoT> getByPro_tx_nomeGeralImagem(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String nome = pro_produtoT.getPro_tx_nome();
            String[] palavras = nome.split(" ");
            StringBuffer sql = new StringBuffer("select * from i9im.pro_produto pro where ");
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    sql.append(" Upper(pro.pro_tx_nome) like Upper(?) and ");
                }
            }
            sql.append(" 1=1 and pro.pro_nr_id in (select distinct pro_nr_id from i9im.arq_arquivo arq where arq.pro_nr_id=pro.pro_nr_id and arq.arq_tx_situacao='A') order by pro_tx_nome ");

            pStmt = con.prepareStatement(sql.toString());
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    pStmt.setObject(i + 1, "%".concat(palavra).concat("%"));
                }
            }

//            pStmt.setObject(1, '%' + pro_produtoT.getPro_tx_nome() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }
    public List<Pro_produtoT> getByPro_tx_nomeGeralSemImagem(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String nome = pro_produtoT.getPro_tx_nome();
            String[] palavras = nome.split(" ");
            StringBuffer sql = new StringBuffer("select * from i9im.pro_produto pro where ( ");
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    sql.append(" Upper(pro.pro_tx_nome) like Upper(?) and ");
                }
            }
            sql.append(" 1=1 ) and pro.pro_nr_id not in (select distinct pro_nr_id from i9im.arq_arquivo arq where arq.pro_nr_id=pro.pro_nr_id and arq.arq_tx_situacao='A') order by pro_tx_nome ");

            pStmt = con.prepareStatement(sql.toString());
            for (int i = 0; i < palavras.length; i++) {
                String palavra = palavras[i];
                if (palavra.trim().length() > 0) {
                    pStmt.setObject(i + 1, "%".concat(palavra).concat("%"));
                }
            }

//            pStmt.setObject(1, '%' + pro_produtoT.getPro_tx_nome() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }
    public List<Pro_produtoT> getByPro_tx_nomeGeralOld(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {

            String sql = "select * from i9im.pro_produto where Upper(pro_tx_nome) like Upper(?) order by pro_tx_nome ";
            pStmt = con.prepareStatement(sql);
            String str = pro_produtoT.getPro_tx_nome();
            str = str.replaceAll(" ", "%");
            pStmt.setObject(1, "%".concat(str).concat("%"));

//            pStmt.setObject(1, '%' + pro_produtoT.getPro_tx_nome() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Pro_produtoT> getByPro_tx_nome(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro.* from i9im.pro_produto pro, i9im.set_setor setor  where setor.set_nr_id=? and pro.pro_tx_idsap like setor.set_tx_idsap||'%' and Upper(pro_tx_nome) like Upper(?) order by pro_tx_nome ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getSet_nr_id());
            String str = pro_produtoT.getPro_tx_nome();
            str = str.replaceAll(" ", "%");
            pStmt.setObject(2, "%".concat(str).concat("%"));

//            pStmt.setObject(3, '%' + pro_produtoT.getPro_tx_nome() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Pro_produtoT> getByPro_nr_cdfamilia(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_produto where  pro_nr_cdfamilia = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getPro_nr_cdfamilia());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Pro_produtoT> getByPro_dt_atualizacao(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_produto where  pro_dt_atualizacao = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(pro_produtoT.getPro_dt_atualizacao().getTime());
            pStmt.setObject(1, dt1);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Pro_produtoT> getByPro_nr_valor(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_produto where  pro_nr_valor = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getPro_nr_valor());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Pro_produtoT> getByPro_tx_situacao(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_produto where  Upper(pro_tx_situacao) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + pro_produtoT.getPro_tx_situacao() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Pro_produtoT> getByGru_nr_id(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_produto where  set_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getSet_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public int getQuantidadeProdutosSetorAfetadosImagem(Set_setorT setT, java.util.Date dtInicio, java.util.Date dtFim) throws Exception {

        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from (select distinct arq.pro_nr_id from i9im.ses_sessao ses, i9im.gru_grupo gru, i9im.pro_produto pro, i9im.arq_arquivo arq  where ses.set_nr_id=? and ses.ses_nr_id = gru.ses_nr_id and  gru.gru_nr_id = pro.gru_nr_id and gru.ses_nr_id = pro.ses_nr_id and  arq.pro_nr_id = pro.pro_nr_id  and arq.arq_dt_cadastro between ?  and ? ) vw";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, setT.getSet_nr_id());
            java.sql.Date dt = new java.sql.Date(dtInicio.getTime());
            pStmt.setObject(2, dt);
            dt = new java.sql.Date(dtFim.getTime());
            pStmt.setObject(3, dt);

            rs = pStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
        return 0;
    }

    public int getQuantideProdutoSetor(Set_setorT setT) throws Exception {
        /*
        select count(pro.pro_nr_id) from pro_produto pro, sug_subgrupo sug, gru_grupo gru, ses_sessao ses
        where ses.set_nr_id=2 and ses.ses_nr_id=gru.ses_nr_id and
        gru.ses_nr_id=sug.ses_nr_id and gru.gru_nr_id=sug.gru_nr_id and
        sug.ses_nr_id=pro.ses_nr_id and sug.gru_nr_id=pro.gru_nr_id and sug.sug_nr_id=pro.sug_nr_id     */
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(pro.pro_nr_id) from pro_produto pro, sug_subgrupo sug, gru_grupo gru, ses_sessao ses where ses.set_nr_id=? and ses.ses_nr_id=gru.ses_nr_id and         gru.ses_nr_id=sug.ses_nr_id and gru.gru_nr_id=sug.gru_nr_id and         sug.ses_nr_id=pro.ses_nr_id and sug.gru_nr_id=pro.gru_nr_id and sug.sug_nr_id=pro.sug_nr_id";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, setT.getSet_nr_id());
            rs = pStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
        return 0;
    }

    public List<Pro_produtoT> getBySes_nr_id(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_produto where  set_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getSet_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Pro_produtoT> getBySug_nr_id(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_produto where  sug_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getSet_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Pro_produtoT> getByPro_tx_obs(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_produto where  Upper(pro_tx_obs) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + pro_produtoT.getPro_tx_obs() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }
}
