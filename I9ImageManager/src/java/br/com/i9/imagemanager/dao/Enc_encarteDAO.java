package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Enc_encarteDAO extends ObjectDAO {

    public Enc_encarteDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Enc_encarteT enc_encarteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.enc_encarte  ( enc_dt_limite, enc_tx_nome, emp_nr_id) values ( ? , ?, ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, enc_encarteT.getEnc_dt_limite());
            pStmt.setObject(2, enc_encarteT.getEnc_tx_nome());
            pStmt.setObject(3, enc_encarteT.getEmp_nr_id());
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

    public void update(Enc_encarteT enc_encarteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.enc_encarte set  enc_dt_limite=?, enc_tx_nome=?, emp_nr_id=?  where  enc_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, enc_encarteT.getEnc_dt_limite());
            pStmt.setObject(2, enc_encarteT.getEnc_tx_nome());
            pStmt.setObject(3, enc_encarteT.getEmp_nr_id());
            pStmt.setObject(4, enc_encarteT.getEnc_nr_id());
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

    public void delete(Enc_encarteT enc_encarteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.enc_encarte where  enc_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, enc_encarteT.getEnc_nr_id());
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

    private List<Enc_encarteT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Enc_encarteT> objs = new Vector();
        while (rs.next()) {
            Enc_encarteT enc_encarteT = new Enc_encarteT();
            enc_encarteT.setEnc_nr_id(rs.getInt("enc_nr_id"));
            enc_encarteT.setEnc_dt_limite(rs.getTimestamp("enc_dt_limite"));
            enc_encarteT.setEnc_tx_nome(rs.getString("enc_tx_nome"));
            enc_encarteT.setEmp_nr_id(rs.getInt("emp_nr_id"));
            objs.add(enc_encarteT);
        }
        return objs;
    }


    public List<Enc_encarteT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.enc_encarte order by enc_dt_limite desc";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Enc_encarteT> list = resultSetToObjectTransfer(rs);
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

    public List<Enc_encarteT> getByPK(Enc_encarteT enc_encarteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select *  from i9im.enc_encarte where  enc_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, enc_encarteT.getEnc_nr_id());
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

    public List<Enc_encarteT> getByEnc_nr_id(Enc_encarteT enc_encarteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select *  from i9im.enc_encarte where  enc_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, enc_encarteT.getEnc_nr_id());
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



    public List<Enc_encarteT> getByEnc_dt_limite(Enc_encarteT enc_encarteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select enc_nr_id, enc_dt_limite, enc_tx_nome  from i9im.enc_encarte where  enc_dt_limite = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, enc_encarteT.getEnc_dt_limite());
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
