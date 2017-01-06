package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Tid_tipodocumentoDAO extends ObjectDAO {

    public Tid_tipodocumentoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Tid_tipodocumentoT tid_tipodocumentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.tid_tipodocumento  ( tid_tx_sigla, tid_tx_descricao, tid_tx_reduzir) values ( ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tid_tipodocumentoT.getTid_tx_sigla());
            pStmt.setObject(2, tid_tipodocumentoT.getTid_tx_descricao());
            pStmt.setObject(3, tid_tipodocumentoT.getTid_tx_reduzir());
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

    public void update(Tid_tipodocumentoT tid_tipodocumentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.tid_tipodocumento set  tid_tx_sigla=?, tid_tx_descricao=?, tid_tx_reduzir=?  where  tid_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tid_tipodocumentoT.getTid_tx_sigla());
            pStmt.setObject(2, tid_tipodocumentoT.getTid_tx_descricao());
            pStmt.setObject(3, tid_tipodocumentoT.getTid_tx_reduzir());
            pStmt.setObject(4, tid_tipodocumentoT.getTid_nr_id());
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

    public void delete(Tid_tipodocumentoT tid_tipodocumentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.tid_tipodocumento where  tid_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tid_tipodocumentoT.getTid_nr_id());
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

    private List<Tid_tipodocumentoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Tid_tipodocumentoT> objs = new Vector();
        while (rs.next()) {
            Tid_tipodocumentoT tid_tipodocumentoT = new Tid_tipodocumentoT();
            tid_tipodocumentoT.setTid_nr_id(rs.getInt("tid_nr_id"));
            tid_tipodocumentoT.setTid_tx_sigla(rs.getString("tid_tx_sigla"));
            tid_tipodocumentoT.setTid_tx_descricao(rs.getString("tid_tx_descricao"));
            tid_tipodocumentoT.setTid_tx_reduzir(rs.getString("tid_tx_reduzir"));
            objs.add(tid_tipodocumentoT);
        }
        return objs;
    }

    public List<Tid_tipodocumentoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.tid_tipodocumento order by tid_tx_sigla";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Tid_tipodocumentoT> list = resultSetToObjectTransfer(rs);
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

    public List<Tid_tipodocumentoT> getByPK(Tid_tipodocumentoT tid_tipodocumentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.tid_tipodocumento where  tid_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tid_tipodocumentoT.getTid_nr_id());
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

    public List<Tid_tipodocumentoT> getByTid_nr_id(Tid_tipodocumentoT tid_tipodocumentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.tid_tipodocumento where  tid_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tid_tipodocumentoT.getTid_nr_id());
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

    public List<Tid_tipodocumentoT> getByTid_tx_sigla(Tid_tipodocumentoT tid_tipodocumentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.tid_tipodocumento where  Upper(tid_tx_sigla) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, tid_tipodocumentoT.getTid_tx_sigla());
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

    public List<Tid_tipodocumentoT> getByTid_tx_descricao(Tid_tipodocumentoT tid_tipodocumentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.tid_tipodocumento where  Upper(tid_tx_descricao) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + tid_tipodocumentoT.getTid_tx_descricao() + '%');
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

    public List<Tid_tipodocumentoT> getByTid_tx_reduzir(Tid_tipodocumentoT tid_tipodocumentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.tid_tipodocumento where  Upper(tid_tx_reduzir) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + tid_tipodocumentoT.getTid_tx_reduzir() + '%');
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
