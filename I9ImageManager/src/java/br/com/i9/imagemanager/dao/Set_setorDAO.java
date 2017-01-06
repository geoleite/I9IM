package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Set_setorDAO extends ObjectDAO {

    private static String sinal = "sinal";

    public Set_setorDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    private int getCodigoAutoInc() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select max(set_nr_id) from i9im.set_setor";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            try {
                rs.close();
                ps.close();
            } catch (Exception ex) {
            }
        }
        return 1;
    }

    public void insert(Set_setorT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.set_setor  ( set_nr_id, set_tx_nome) values ( ? , ? )";
            synchronized (sinal) {
                pStmt = con.prepareStatement(sql);
                set_setorT.setSet_nr_id(getCodigoAutoInc());
                pStmt.setObject(1, set_setorT.getSet_nr_id());
                pStmt.setObject(2, set_setorT.getSet_tx_nome());
                pStmt.execute();

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

    public void update(Set_setorT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.set_setor set  set_tx_nome=?  where  set_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_setorT.getSet_tx_nome());
            pStmt.setObject(2, set_setorT.getSet_nr_id());
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

    public void delete(Set_setorT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.set_setor where  set_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_setorT.getSet_nr_id());
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

    private List<Set_setorT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Set_setorT> objs = new Vector();
        while (rs.next()) {
            Set_setorT set_setorT = new Set_setorT();
            set_setorT.setSet_nr_id(rs.getInt("set_nr_id"));
            set_setorT.setSet_tx_nome(rs.getString("set_tx_nome"));
            objs.add(set_setorT);
        }
        return objs;
    }

    public List<Set_setorT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.set_setor order by set_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Set_setorT> list = resultSetToObjectTransfer(rs);
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

    public List<Set_setorT> getAllRaiz() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.set_setor where set_nr_idsetorpai=0 order by set_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Set_setorT> list = resultSetToObjectTransfer(rs);
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


    public List<Set_setorT> getByPK(Set_setorT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.set_setor where  set_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_setorT.getSet_nr_id());
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

    public List<Set_setorT> getBySet_nr_id(Set_setorT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.set_setor where  set_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_setorT.getSet_nr_id());
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

    public List<Set_setorT> getBySet_tx_nome(Set_setorT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.set_setor where  Upper(set_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_setorT.getSet_tx_nome());
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
