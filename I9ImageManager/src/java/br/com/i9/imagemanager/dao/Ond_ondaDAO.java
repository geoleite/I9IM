package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Ond_ondaDAO extends ObjectDAO {

    public Ond_ondaDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Ond_ondaT ond_ondaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.ond_onda  ( eve_nr_id, ond_dt_criacao) values ( ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ond_ondaT.getEve_nr_id());
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

    public void update(Ond_ondaT ond_ondaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.ond_onda set  ond_dt_criacao=?  where  eve_nr_id=? and ond_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ond_ondaT.getOnd_dt_criacao());
            pStmt.setObject(2, ond_ondaT.getEve_nr_id());
            pStmt.setObject(3, ond_ondaT.getOnd_nr_id());
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

    public void delete(Ond_ondaT ond_ondaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.ond_onda where  eve_nr_id=? and ond_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ond_ondaT.getEve_nr_id());
            pStmt.setObject(2, ond_ondaT.getOnd_nr_id());
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

    private List<Ond_ondaT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Ond_ondaT> objs = new Vector();
        while (rs.next()) {
            Ond_ondaT ond_ondaT = new Ond_ondaT();
            ond_ondaT.setEve_nr_id(rs.getInt("eve_nr_id"));
            ond_ondaT.setOnd_nr_id(rs.getInt("ond_nr_id"));
            ond_ondaT.setOnd_dt_criacao(rs.getTimestamp("ond_dt_criacao"));
            objs.add(ond_ondaT);
        }
        return objs;
    }

    public List<Ond_ondaT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.ond_onda";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Ond_ondaT> list = resultSetToObjectTransfer(rs);
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

    public List<Ond_ondaT> getByPK(Ond_ondaT ond_ondaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.ond_onda where  eve_nr_id=? and ond_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ond_ondaT.getEve_nr_id());
            pStmt.setObject(2, ond_ondaT.getOnd_nr_id());
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



    public List<Ond_ondaT> getByEve_nr_id(Ond_ondaT ond_ondaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.ond_onda where  eve_nr_id = ? order by ond_dt_criacao";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ond_ondaT.getEve_nr_id());
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

    public List<Ond_ondaT> getByOnd_nr_id(Ond_ondaT ond_ondaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.ond_onda where  ond_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ond_ondaT.getOnd_nr_id());
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

    public List<Ond_ondaT> getByOnd_dt_criacao(Ond_ondaT ond_ondaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.ond_onda where  ond_dt_criacao = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ond_ondaT.getOnd_dt_criacao());
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
    public List<Ond_ondaT> getByEve_evento(Ond_ondaT ond_ondaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.ond_onda where eve_nr_id=? order by ond_dt_criacao ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ond_ondaT.getEve_nr_id());
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
