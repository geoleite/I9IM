package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Use_usuario_setorDAO extends ObjectDAO {

    public Use_usuario_setorDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Use_usuario_setorT use_usuario_setorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.use_usuario_setor  ( usu_nr_id, set_nr_id) values ( ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, use_usuario_setorT.getUsu_nr_id());
            pStmt.setObject(2, use_usuario_setorT.getSet_nr_id());
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

    public void update(Use_usuario_setorT use_usuario_setorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.use_usuario_setor set - where  usu_nr_id=? and set_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, use_usuario_setorT.getUsu_nr_id());
            pStmt.setObject(2, use_usuario_setorT.getSet_nr_id());
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

    public void delete(Use_usuario_setorT use_usuario_setorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.use_usuario_setor where  usu_nr_id=? and set_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, use_usuario_setorT.getUsu_nr_id());
            pStmt.setObject(2, use_usuario_setorT.getSet_nr_id());
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

    private List<Use_usuario_setorT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Use_usuario_setorT> objs = new Vector();
        while (rs.next()) {
            Use_usuario_setorT use_usuario_setorT = new Use_usuario_setorT();
            use_usuario_setorT.setUsu_nr_id(rs.getInt("usu_nr_id"));
            use_usuario_setorT.setSet_nr_id(rs.getInt("set_nr_id"));
            objs.add(use_usuario_setorT);
        }
        return objs;
    }

    public List<Use_usuario_setorT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.use_usuario_setor";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Use_usuario_setorT> list = resultSetToObjectTransfer(rs);
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

    public List<Use_usuario_setorT> getByPK(Use_usuario_setorT use_usuario_setorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.use_usuario_setor where  usu_nr_id=? and set_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, use_usuario_setorT.getUsu_nr_id());
            pStmt.setObject(2, use_usuario_setorT.getSet_nr_id());
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

    public List<Use_usuario_setorT> getByUsu_nr_id(Use_usuario_setorT use_usuario_setorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.use_usuario_setor where  usu_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, use_usuario_setorT.getUsu_nr_id());
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

    public List<Use_usuario_setorT> getBySet_nr_id(Use_usuario_setorT use_usuario_setorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.use_usuario_setor where  set_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, use_usuario_setorT.getSet_nr_id());
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
