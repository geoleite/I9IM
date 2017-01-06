package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Tic_tipo_correcaoDAO extends ObjectDAO {

    public Tic_tipo_correcaoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Tic_tipo_correcaoT tic_tipo_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.tic_tipo_correcao  ( tic_tx_nome) values ( ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tic_tipo_correcaoT.getTic_tx_nome());
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

    public void update(Tic_tipo_correcaoT tic_tipo_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.tic_tipo_correcao set  tic_tx_nome=?  where  tic_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tic_tipo_correcaoT.getTic_tx_nome());
            pStmt.setObject(2, tic_tipo_correcaoT.getTic_nr_id());
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

    public void delete(Tic_tipo_correcaoT tic_tipo_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.tic_tipo_correcao where  tic_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tic_tipo_correcaoT.getTic_nr_id());
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

    private List<Tic_tipo_correcaoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Tic_tipo_correcaoT> objs = new Vector();
        while (rs.next()) {
            Tic_tipo_correcaoT tic_tipo_correcaoT = new Tic_tipo_correcaoT();
            tic_tipo_correcaoT.setTic_nr_id(rs.getInt("tic_nr_id"));
            tic_tipo_correcaoT.setTic_tx_nome(rs.getString("tic_tx_nome"));
            objs.add(tic_tipo_correcaoT);
        }
        return objs;
    }

    public List<Tic_tipo_correcaoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.tic_tipo_correcao order by tic_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Tic_tipo_correcaoT> list = resultSetToObjectTransfer(rs);
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

    public List<Tic_tipo_correcaoT> getByPK(Tic_tipo_correcaoT tic_tipo_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.tic_tipo_correcao where  tic_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tic_tipo_correcaoT.getTic_nr_id());
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

    public List<Tic_tipo_correcaoT> getByTic_nr_id(Tic_tipo_correcaoT tic_tipo_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.tic_tipo_correcao where  tic_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tic_tipo_correcaoT.getTic_nr_id());
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

    public List<Tic_tipo_correcaoT> getByTic_tx_nome(Tic_tipo_correcaoT tic_tipo_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.tic_tipo_correcao where  Upper(tic_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + tic_tipo_correcaoT.getTic_tx_nome() + '%');
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
