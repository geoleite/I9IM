package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Pro_selDAO extends ObjectDAO {

    public Pro_selDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Pro_selT pro_selT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.pro_sel  ( pro_nr_id, sel_nr_id) values ( ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_selT.getPro_nr_id());
            pStmt.setObject(2, pro_selT.getSel_nr_id());
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

    public void update(Pro_selT pro_selT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.pro_sel set - where  pro_nr_id=? and sel_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_selT.getPro_nr_id());
            pStmt.setObject(2, pro_selT.getSel_nr_id());
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

    public void delete(Pro_selT pro_selT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.pro_sel where  pro_nr_id=? and sel_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_selT.getPro_nr_id());
            pStmt.setObject(2, pro_selT.getSel_nr_id());
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

    public void deleteIds(Pro_produtoT proT, String ids) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.pro_sel where  pro_nr_id=? and sel_nr_id in (".concat(ids).concat(")");
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, proT.getPro_nr_id());
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

    public void deleteIds(Sel_seloT selT, String ids) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.pro_sel where  sel_nr_id=? and pro_nr_id in (".concat(ids).concat(")");
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, selT.getSel_nr_id());
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

    private List<Pro_selT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Pro_selT> objs = new Vector();
        while (rs.next()) {
            Pro_selT pro_selT = new Pro_selT();
            pro_selT.setPro_nr_id(rs.getInt("pro_nr_id"));
            pro_selT.setSel_nr_id(rs.getInt("sel_nr_id"));
            objs.add(pro_selT);
        }
        return objs;
    }

    public List<Pro_selT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_sel";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Pro_selT> list = resultSetToObjectTransfer(rs);
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

    public List<Pro_selT> getByPK(Pro_selT pro_selT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_sel where  pro_nr_id=? and sel_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_selT.getPro_nr_id());
            pStmt.setObject(2, pro_selT.getSel_nr_id());
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

    public List<Pro_selT> getByPro_nr_id(Pro_selT pro_selT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_sel where  pro_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_selT.getPro_nr_id());
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

    public List<Pro_selT> getBySel_nr_id(Pro_selT pro_selT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_sel where  sel_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_selT.getSel_nr_id());
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
    public List<Pro_selT> getBySel_selo(Pro_selT pro_selT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pro_sel where sel_selo.sel_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_selT.getSel_nr_id());
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
