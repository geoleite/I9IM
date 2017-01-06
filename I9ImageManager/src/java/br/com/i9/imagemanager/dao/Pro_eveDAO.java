package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Pro_eveDAO extends ObjectDAO {

    public Pro_eveDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Pro_eveT pro_eveT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.pro_eve  ( pro_nr_id, eve_nr_id) values ( ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_eveT.getPro_nr_id());
            pStmt.setObject(2, pro_eveT.getEve_nr_id());
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

    public void update(Pro_eveT pro_eveT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.pro_eve set - where  pro_nr_id=? and eve_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_eveT.getPro_nr_id());
            pStmt.setObject(2, pro_eveT.getEve_nr_id());
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
     * Remove os produtos associados a um evento
     * @param pro_eveT
     * @throws Exception
     */
    public void deleteProdutosByEvento(Pro_eveT pro_eveT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.pro_eve where eve_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_eveT.getEve_nr_id());
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

    public void delete(Pro_eveT pro_eveT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.pro_eve where  pro_nr_id=? and eve_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_eveT.getPro_nr_id());
            pStmt.setObject(2, pro_eveT.getEve_nr_id());
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

    private List<Pro_eveT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Pro_eveT> objs = new Vector();
        while (rs.next()) {
            Pro_eveT pro_eveT = new Pro_eveT();
            pro_eveT.setPro_nr_id(rs.getInt("pro_nr_id"));
            pro_eveT.setEve_nr_id(rs.getInt("eve_nr_id"));
            objs.add(pro_eveT);
        }
        return objs;
    }

    public List<Pro_eveT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_eve";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Pro_eveT> list = resultSetToObjectTransfer(rs);
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

    public List<Pro_eveT> getByPK(Pro_eveT pro_eveT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_eve where  pro_nr_id=? and eve_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_eveT.getPro_nr_id());
            pStmt.setObject(2, pro_eveT.getEve_nr_id());
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

    public List<Pro_eveT> getByPro_nr_id(Pro_eveT pro_eveT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_eve where  pro_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_eveT.getPro_nr_id());
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

    public List<Pro_eveT> getByEve_nr_id(Pro_eveT pro_eveT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_eve where  eve_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_eveT.getEve_nr_id());
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

    /** M�todos FK */
    public List<Pro_eveT> getByPro_produto(Pro_eveT pro_eveT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_eve where pro_produto.pro_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_eveT.getPro_nr_id());
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

    /** M�todos FK */
    public List<Pro_eveT> getByEve_evento(Pro_eveT pro_eveT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_eve where eve_evento.eve_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_eveT.getEve_nr_id());
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
