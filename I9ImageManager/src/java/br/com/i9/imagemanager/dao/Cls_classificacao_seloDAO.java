package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Cls_classificacao_seloDAO extends ObjectDAO {

    public Cls_classificacao_seloDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Cls_classificacao_seloT cls_classificacao_seloT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.cls_classificacao_selo  ( cls_tx_tipo) values ( ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cls_classificacao_seloT.getCls_tx_tipo());
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

    public void update(Cls_classificacao_seloT cls_classificacao_seloT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.cls_classificacao_selo set  cls_tx_tipo=?  where  cls_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cls_classificacao_seloT.getCls_tx_tipo());
            pStmt.setObject(2, cls_classificacao_seloT.getCls_nr_id());
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

    public void delete(Cls_classificacao_seloT cls_classificacao_seloT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.cls_classificacao_selo where  cls_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cls_classificacao_seloT.getCls_nr_id());
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

    private List<Cls_classificacao_seloT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Cls_classificacao_seloT> objs = new Vector();
        while (rs.next()) {
            Cls_classificacao_seloT cls_classificacao_seloT = new Cls_classificacao_seloT();
            cls_classificacao_seloT.setCls_nr_id(rs.getInt("cls_nr_id"));
            cls_classificacao_seloT.setCls_tx_tipo(rs.getString("cls_tx_tipo"));
            objs.add(cls_classificacao_seloT);
        }
        return objs;
    }

    public List<Cls_classificacao_seloT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cls_classificacao_selo";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Cls_classificacao_seloT> list = resultSetToObjectTransfer(rs);
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

    public List<Cls_classificacao_seloT> getByPK(Cls_classificacao_seloT cls_classificacao_seloT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cls_classificacao_selo where  cls_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cls_classificacao_seloT.getCls_nr_id());
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

    public List<Cls_classificacao_seloT> getByCls_nr_id(Cls_classificacao_seloT cls_classificacao_seloT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cls_classificacao_selo where  cls_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cls_classificacao_seloT.getCls_nr_id());
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

    public List<Cls_classificacao_seloT> getByCls_tx_tipo(Cls_classificacao_seloT cls_classificacao_seloT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cls_classificacao_selo where  Upper(cls_tx_tipo) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cls_classificacao_seloT.getCls_tx_tipo() + '%');
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
