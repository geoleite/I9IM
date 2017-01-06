package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Sug_subgrupoDAO extends ObjectDAO {

    public Sug_subgrupoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Sug_subgrupoT sug_subgrupoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.sug_subgrupo  ( gru_nr_id, ses_nr_id, sug_nr_id, sug_tx_nome) values ( ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sug_subgrupoT.getGru_nr_id());
            pStmt.setObject(2, sug_subgrupoT.getSes_nr_id());
            pStmt.setObject(3, sug_subgrupoT.getSug_nr_id());
            pStmt.setObject(4, sug_subgrupoT.getSug_tx_nome());
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

    public void update(Sug_subgrupoT sug_subgrupoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.sug_subgrupo set  sug_tx_nome=?  where  gru_nr_id=? and ses_nr_id=? and sug_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sug_subgrupoT.getSug_tx_nome());
            pStmt.setObject(2, sug_subgrupoT.getGru_nr_id());
            pStmt.setObject(3, sug_subgrupoT.getSes_nr_id());
            pStmt.setObject(4, sug_subgrupoT.getSug_nr_id());
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

    public void delete(Sug_subgrupoT sug_subgrupoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.sug_subgrupo where  gru_nr_id=? and ses_nr_id=? and sug_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sug_subgrupoT.getGru_nr_id());
            pStmt.setObject(2, sug_subgrupoT.getSes_nr_id());
            pStmt.setObject(3, sug_subgrupoT.getSug_nr_id());
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

    private List<Sug_subgrupoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Sug_subgrupoT> objs = new Vector();
        while (rs.next()) {
            Sug_subgrupoT sug_subgrupoT = new Sug_subgrupoT();
            sug_subgrupoT.setGru_nr_id(rs.getInt("gru_nr_id"));
            sug_subgrupoT.setSes_nr_id(rs.getInt("ses_nr_id"));
            sug_subgrupoT.setSug_nr_id(rs.getInt("sug_nr_id"));
            sug_subgrupoT.setSug_tx_nome(rs.getString("sug_tx_nome"));
            objs.add(sug_subgrupoT);
        }
        return objs;
    }

    public List<Sug_subgrupoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.sug_subgrupo";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Sug_subgrupoT> list = resultSetToObjectTransfer(rs);
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

    public List<Sug_subgrupoT> getByPK(Sug_subgrupoT sug_subgrupoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.sug_subgrupo where  gru_nr_id=? and ses_nr_id=? and sug_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sug_subgrupoT.getGru_nr_id());
            pStmt.setObject(2, sug_subgrupoT.getSes_nr_id());
            pStmt.setObject(3, sug_subgrupoT.getSug_nr_id());
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

    public List<Sug_subgrupoT> getByGru_nr_id(Sug_subgrupoT sug_subgrupoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.sug_subgrupo where  gru_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sug_subgrupoT.getGru_nr_id());
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

    public List<Sug_subgrupoT> getBySes_nr_id(Sug_subgrupoT sug_subgrupoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.sug_subgrupo where  ses_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sug_subgrupoT.getSes_nr_id());
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

    public List<Sug_subgrupoT> getBySug_nr_id(Sug_subgrupoT sug_subgrupoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.sug_subgrupo where  sug_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sug_subgrupoT.getSug_nr_id());
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

    public List<Sug_subgrupoT> getBySug_tx_nome(Sug_subgrupoT sug_subgrupoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.sug_subgrupo where  Upper(sug_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + sug_subgrupoT.getSug_tx_nome() + '%');
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
    public List<Sug_subgrupoT> getByGru_grupo(Sug_subgrupoT sug_subgrupoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.sug_subgrupo where gru_grupo.gru_nr_id=? and gru_grupo.ses_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sug_subgrupoT.getGru_nr_id());
            pStmt.setObject(2, sug_subgrupoT.getSes_nr_id());
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
