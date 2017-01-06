package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Imt_imagemthumbDAO extends ObjectDAO {

    public Imt_imagemthumbDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Imt_imagemthumbT imt_imagemthumbT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.imt_imagemthumb  ( arq_nr_id, pro_nr_id, imt_bt_thumb) values ( ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, imt_imagemthumbT.getArq_nr_id());
            pStmt.setObject(2, imt_imagemthumbT.getPro_nr_id());
            pStmt.setObject(3, imt_imagemthumbT.getImt_bt_thumb());
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

    public void update(Imt_imagemthumbT imt_imagemthumbT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.imt_imagemthumb set  imt_bt_thumb=?  where  arq_nr_id=? and pro_nr_id=? and imt_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, imt_imagemthumbT.getImt_bt_thumb());
            pStmt.setObject(2, imt_imagemthumbT.getArq_nr_id());
            pStmt.setObject(3, imt_imagemthumbT.getPro_nr_id());
            pStmt.setObject(4, imt_imagemthumbT.getImt_nr_id());
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

    public void delete(Imt_imagemthumbT imt_imagemthumbT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.imt_imagemthumb where  arq_nr_id=? and pro_nr_id=? and imt_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, imt_imagemthumbT.getArq_nr_id());
            pStmt.setObject(2, imt_imagemthumbT.getPro_nr_id());
            pStmt.setObject(3, imt_imagemthumbT.getImt_nr_id());
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

    private List<Imt_imagemthumbT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Imt_imagemthumbT> objs = new Vector();
        while (rs.next()) {
            Imt_imagemthumbT imt_imagemthumbT = new Imt_imagemthumbT();
            imt_imagemthumbT.setArq_nr_id(rs.getInt("arq_nr_id"));
            imt_imagemthumbT.setPro_nr_id(rs.getInt("pro_nr_id"));
            imt_imagemthumbT.setImt_nr_id(rs.getInt("imt_nr_id"));
            objs.add(imt_imagemthumbT);
        }
        return objs;
    }

    private List<Imt_imagemthumbT> resultSetToObjectTransferImagem(ResultSet rs) throws Exception {
        List<Imt_imagemthumbT> objs = new Vector();
        while (rs.next()) {
            Imt_imagemthumbT imt_imagemthumbT = new Imt_imagemthumbT();
            imt_imagemthumbT.setImt_bt_thumb(rs.getBytes("imt_bt_thumb"));
            objs.add(imt_imagemthumbT);
        }
        return objs;
    }

    public List<Imt_imagemthumbT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select arq_nr_id, pro_nr_id, imt_nr_id from i9im.imt_imagemthumb";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Imt_imagemthumbT> list = resultSetToObjectTransfer(rs);
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

    public List<Imt_imagemthumbT> getByPK(Imt_imagemthumbT imt_imagemthumbT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select arq_nr_id, pro_nr_id, imt_nr_id from i9im.imt_imagemthumb where  arq_nr_id=? and pro_nr_id=? and imt_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, imt_imagemthumbT.getArq_nr_id());
            pStmt.setObject(2, imt_imagemthumbT.getPro_nr_id());
            pStmt.setObject(3, imt_imagemthumbT.getImt_nr_id());
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

    public List<Imt_imagemthumbT> getByarq_nr_id(Imt_imagemthumbT imt_imagemthumbT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select arq_nr_id, pro_nr_id, imt_nr_id from i9im.imt_imagemthumb where  arq_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, imt_imagemthumbT.getArq_nr_id());
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

    public List<Imt_imagemthumbT> getBypro_nr_id(Imt_imagemthumbT imt_imagemthumbT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select arq_nr_id, pro_nr_id, imt_nr_id from i9im.imt_imagemthumb where  pro_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, imt_imagemthumbT.getPro_nr_id());
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

    public List<Imt_imagemthumbT> getByImt_nr_id(Imt_imagemthumbT imt_imagemthumbT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select arq_nr_id, pro_nr_id, imt_nr_id from i9im.imt_imagemthumb where  imt_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, imt_imagemthumbT.getImt_nr_id());
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

    public List<Imt_imagemthumbT> getByImt_bt_thumb(Imt_imagemthumbT imt_imagemthumbT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select imt_bt_thumb from i9im.imt_imagemthumb where  imt_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, imt_imagemthumbT.getImt_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransferImagem(rs);
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
    public List<Imt_imagemthumbT> getByArq_arquivo(Imt_imagemthumbT imt_imagemthumbT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select arq_nr_id, pro_nr_id, imt_nr_id from i9im.imt_imagemthumb, i9im.arq_arquivo arq where arq.arq_nr_id=? and arq.pro_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, imt_imagemthumbT.getArq_nr_id());
            pStmt.setObject(2, imt_imagemthumbT.getPro_nr_id());
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
