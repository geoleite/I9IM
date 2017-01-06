package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Cla_classificacaoDAO extends ObjectDAO {

    public Cla_classificacaoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Cla_classificacaoT cla_classificacaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.cla_classificacao  ( cla_tx_tipo) values ( ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cla_classificacaoT.getCla_tx_tipo());
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

    public void update(Cla_classificacaoT cla_classificacaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.cla_classificacao set  cla_tx_tipo=?  where  cla_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cla_classificacaoT.getCla_tx_tipo());
            pStmt.setObject(2, cla_classificacaoT.getCla_nr_id());
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

    public void delete(Cla_classificacaoT cla_classificacaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.cla_classificacao where  cla_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cla_classificacaoT.getCla_nr_id());
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

    private List<Cla_classificacaoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Cla_classificacaoT> objs = new Vector();
        while (rs.next()) {
            Cla_classificacaoT cla_classificacaoT = new Cla_classificacaoT();
            cla_classificacaoT.setCla_nr_id(rs.getInt("cla_nr_id"));
            cla_classificacaoT.setCla_tx_tipo(rs.getString("cla_tx_tipo"));
            objs.add(cla_classificacaoT);
        }
        return objs;
    }

    public List<Cla_classificacaoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cla_classificacao order by cla_tx_tipo";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Cla_classificacaoT> list = resultSetToObjectTransfer(rs);
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

    public List<Cla_classificacaoT> getByPK(Cla_classificacaoT cla_classificacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cla_classificacao where  cla_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cla_classificacaoT.getCla_nr_id());
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

    public List<Cla_classificacaoT> getByCla_nr_id(Cla_classificacaoT cla_classificacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cla_classificacao where  cla_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cla_classificacaoT.getCla_nr_id());
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

    public List<Cla_classificacaoT> getByCla_tx_tipo(Cla_classificacaoT cla_classificacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cla_classificacao where  Upper(cla_tx_tipo) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cla_classificacaoT.getCla_tx_tipo() + '%');
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
