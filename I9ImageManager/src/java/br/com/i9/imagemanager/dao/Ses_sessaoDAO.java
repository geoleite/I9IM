package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Ses_sessaoDAO extends ObjectDAO {

    public Ses_sessaoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Ses_sessaoT ses_sessaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.ses_sessao  ( ses_nr_id, ses_tx_nome, set_nr_id) values ( ? , ?, ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ses_sessaoT.getSes_nr_id());
            pStmt.setObject(2, ses_sessaoT.getSes_tx_nome());
            pStmt.setObject(3, ses_sessaoT.getSet_nr_id());
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

    public void update(Ses_sessaoT ses_sessaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.ses_sessao set  ses_tx_nome=?, set_nr_id=?   where  ses_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ses_sessaoT.getSes_tx_nome());
            pStmt.setObject(2, ses_sessaoT.getSet_nr_id());
            pStmt.setObject(3, ses_sessaoT.getSes_nr_id());
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

    public void delete(Ses_sessaoT ses_sessaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.ses_sessao where  ses_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ses_sessaoT.getSes_nr_id());
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

    private List<Ses_sessaoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Ses_sessaoT> objs = new Vector();
        while (rs.next()) {
            Ses_sessaoT ses_sessaoT = new Ses_sessaoT();
            ses_sessaoT.setSes_nr_id(rs.getInt("ses_nr_id"));
            ses_sessaoT.setSes_tx_nome(rs.getString("ses_tx_nome"));
            ses_sessaoT.setSet_nr_id(rs.getInt("set_nr_id"));
            objs.add(ses_sessaoT);
        }
        return objs;
    }

    public List<Ses_sessaoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.ses_sessao order by ses_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Ses_sessaoT> list = resultSetToObjectTransfer(rs);
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

    public List<Ses_sessaoT> getByPK(Ses_sessaoT ses_sessaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.ses_sessao where  ses_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ses_sessaoT.getSes_nr_id());
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

    public List<Ses_sessaoT> getBySetor(Ses_sessaoT sesT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.ses_sessao where  set_nr_id = ? order by ses_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sesT.getSet_nr_id());
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

    public List<Ses_sessaoT> getBySes_nr_id(Ses_sessaoT ses_sessaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.ses_sessao where  ses_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ses_sessaoT.getSes_nr_id());
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

    public List<Ses_sessaoT> getBySes_tx_nome(Ses_sessaoT ses_sessaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.ses_sessao where  Upper(ses_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + ses_sessaoT.getSes_tx_nome() + '%');
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
