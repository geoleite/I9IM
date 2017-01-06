package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Eve_eventoDAO extends ObjectDAO {

    private static Object sinal = "sinal";

    public Eve_eventoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    /**
     * Obtém o código do ultimo evento cadastrado
     * @return
     * @throws Exception
     */
    private int getAutoInc() throws Exception {
        String sql = "select max(eve_nr_id) from i9im.eve_evento";
        PreparedStatement pStmt = con.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    public void insert(Eve_eventoT eve_eventoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.eve_evento  ( eve_tx_nome, eve_dt_inicio, eve_dt_fim, eve_dt_criacao, emp_nr_id) values ( ? , ? , ? , ?, ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eve_eventoT.getEve_tx_nome());
            pStmt.setObject(2, eve_eventoT.getEve_dt_inicio());
            pStmt.setObject(3, eve_eventoT.getEve_dt_fim());
            pStmt.setObject(4, eve_eventoT.getEve_dt_criacao());
            pStmt.setObject(5, eve_eventoT.getEmp_nr_id());
            synchronized (sinal) {
                pStmt.execute();
                eve_eventoT.setEve_nr_id(getAutoInc());
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void update(Eve_eventoT eve_eventoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.eve_evento set  eve_tx_nome=?, eve_dt_inicio=?, eve_dt_fim=?, emp_nr_id=?  where  eve_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eve_eventoT.getEve_tx_nome());
            pStmt.setObject(2, eve_eventoT.getEve_dt_inicio());
            pStmt.setObject(3, eve_eventoT.getEve_dt_fim());
            pStmt.setObject(4, eve_eventoT.getEmp_nr_id());
            pStmt.setObject(5, eve_eventoT.getEve_nr_id());
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

    public void updateStatus(Eve_eventoT eve_eventoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.eve_evento set  eve_tx_status=? where  eve_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eve_eventoT.getEve_tx_status());
            pStmt.setObject(2, eve_eventoT.getEve_nr_id());
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


    public void updateDataCriacao(Eve_eventoT eve_eventoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.eve_evento set  eve_dt_criacao=?  where  eve_nr_id=?";

            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eve_eventoT.getEve_dt_criacao());
            pStmt.setObject(2, eve_eventoT.getEve_nr_id());
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
    
    /**
     * Altera a data da ultima exportacao
     * @param eve_eventoT
     * @throws Exception
     */
    public void updateDataExportacao(Eve_eventoT eve_eventoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.eve_evento set  eve_dt_exportacao=?  where  eve_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eve_eventoT.getEve_nr_id());
            pStmt.setObject(2, new Timestamp(System.currentTimeMillis()));
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

    public void delete(Eve_eventoT eve_eventoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.eve_evento where  eve_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eve_eventoT.getEve_nr_id());
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

    private List<Eve_eventoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Eve_eventoT> objs = new Vector();
        while (rs.next()) {
            Eve_eventoT eve_eventoT = new Eve_eventoT();
            eve_eventoT.setEve_nr_id(rs.getInt("eve_nr_id"));
            eve_eventoT.setEve_tx_nome(rs.getString("eve_tx_nome"));
            eve_eventoT.setEve_dt_inicio(rs.getTimestamp("eve_dt_inicio"));
            eve_eventoT.setEve_dt_fim(rs.getTimestamp("eve_dt_fim"));
            eve_eventoT.setEve_dt_criacao(rs.getTimestamp("eve_dt_criacao"));
            eve_eventoT.setEmp_nr_id(rs.getInt("emp_nr_id"));
            objs.add(eve_eventoT);
        }
        return objs;
    }

    public List<Eve_eventoT> getAllEventosModificados() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            //String sql = "select distinct eve.* from eve_evento eve , arq_arquivo arq, pro_eve pe,pro_produto pro where eve.eve_nr_id=pe.eve_nr_id and pe.pro_nr_id=pro.pro_nr_id and arq.pro_nr_id = pro.pro_nr_id and arq.arq_dt_cadastro > (select max(ond_dt_criacao) from ond_onda where eve.eve_nr_id=eve_nr_id) ";
            //String sql = "select distinct eve.* from eve_evento eve , arq_arquivo arq, pro_eve pe,pro_produto pro where eve.eve_nr_id=pe.eve_nr_id and pe.pro_nr_id=pro.pro_nr_id and arq.pro_nr_id = pro.pro_nr_id and arq.arq_dt_cadastro > coalesce ((select max(ond_dt_criacao) from ond_onda where eve.eve_nr_id=eve_nr_id), '01/01/2000') ";
            String sql = "select distinct eve.* from i9im.eve_evento eve , i9im.arq_arquivo arq, i9im.pro_eve pe, i9im.pro_produto pro where eve.eve_nr_id=pe.eve_nr_id and pe.pro_nr_id=pro.pro_nr_id and arq.pro_nr_id = pro.pro_nr_id and arq.arq_dt_cadastro > coalesce ((select max(ond_dt_criacao) from i9im.ond_onda where eve.eve_nr_id=eve_nr_id), '01/01/2000') union select distinct eve.* from i9im.eve_evento eve , i9im.sel_selo sel, i9im.pro_eve pe, i9im.pro_produto pro, i9im.pro_sel ps where eve.eve_nr_id=pe.eve_nr_id and pe.pro_nr_id=pro.pro_nr_id and ps.pro_nr_id = pro.pro_nr_id and ps.sel_nr_id=sel.sel_nr_id and (sel.sel_dt_cadastro > coalesce ((select max(ond_dt_criacao) from i9im.ond_onda where eve.eve_nr_id=eve_nr_id), '01/01/2000') or ps.ps_dt_criacao > coalesce ((select max(ond_dt_criacao) from i9im.ond_onda where eve.eve_nr_id=eve_nr_id), '01/01/2000') )";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Eve_eventoT> list = resultSetToObjectTransfer(rs);
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

    public List<Eve_eventoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.eve_evento where eve_tx_status='A' order by eve_dt_inicio desc, eve_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Eve_eventoT> list = resultSetToObjectTransfer(rs);
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

    public List<Eve_eventoT> getByPK(Eve_eventoT eve_eventoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.eve_evento where  eve_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eve_eventoT.getEve_nr_id());
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

    public List<Eve_eventoT> getByEve_nr_id(Eve_eventoT eve_eventoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.eve_evento where  eve_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eve_eventoT.getEve_nr_id());
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

    public List<Eve_eventoT> getByEve_tx_nome(Eve_eventoT eve_eventoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.eve_evento where  Upper(eve_tx_nome) like Upper(?) and eve_tx_status='A' order by eve_tx_nome desc";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + eve_eventoT.getEve_tx_nome() + '%');
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

    public List<Eve_eventoT> getByNomePeriodo(Eve_eventoT eve_eventoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.eve_evento where  Upper(eve_tx_nome) = Upper(?) and eve_dt_inicio=? and eve_dt_fim=?  order by eve_dt_inicio desc";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eve_eventoT.getEve_tx_nome());
            pStmt.setObject(2, eve_eventoT.getEve_dt_inicio());
            pStmt.setObject(3, eve_eventoT.getEve_dt_fim());
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

    public List<Eve_eventoT> getByEve_dt_inicio(Eve_eventoT eve_eventoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.eve_evento where  eve_dt_inicio = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eve_eventoT.getEve_dt_inicio());
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

    public List<Eve_eventoT> getByEve_dt_fim(Eve_eventoT eve_eventoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.eve_evento where  eve_dt_fim = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eve_eventoT.getEve_dt_fim());
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

    public List<Eve_eventoT> getByEve_dt_criacao(Eve_eventoT eve_eventoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.eve_evento where  eve_dt_criacao = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eve_eventoT.getEve_dt_criacao());
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
