package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Pag_paginaDAO extends ObjectDAO {

    public Pag_paginaDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Pag_paginaT pag_paginaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.pag_pagina  ( enc_nr_id, pag_bt_arquivo, pag_tx_nome) values ( ? , ?, ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pag_paginaT.getEnc_nr_id());
            pStmt.setObject(2, pag_paginaT.getPag_bt_arquivo());
            pStmt.setObject(3, pag_paginaT.getPag_tx_nome());
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

    public void update(Pag_paginaT pag_paginaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.pag_pagina set  enc_nr_id=?, pag_bt_arquivo=?  where  pag_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pag_paginaT.getEnc_nr_id());
            pStmt.setObject(2, pag_paginaT.getPag_bt_arquivo());
            pStmt.setObject(3, pag_paginaT.getPag_nr_id());
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

    public void delete(Pag_paginaT pag_paginaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.pag_pagina where  pag_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pag_paginaT.getPag_nr_id());
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

    private List<Pag_paginaT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Pag_paginaT> objs = new Vector();
        while (rs.next()) {
            Pag_paginaT pag_paginaT = new Pag_paginaT();
            pag_paginaT.setPag_nr_id(rs.getInt("pag_nr_id"));
            pag_paginaT.setEnc_nr_id(rs.getInt("enc_nr_id"));
            //pag_paginaT.setPag_bt_arquivo(rs.getBytes("pag_bt_arquivo"));
            pag_paginaT.setPag_tx_nome(rs.getString("pag_tx_nome"));
            objs.add(pag_paginaT);
        }
        return objs;
    }

    private List<Pag_paginaT> resultSetToObjectTransferArquivo(ResultSet rs) throws Exception {
        List<Pag_paginaT> objs = new Vector();
        while (rs.next()) {
            Pag_paginaT pag_paginaT = new Pag_paginaT();
            pag_paginaT.setPag_nr_id(rs.getInt("pag_nr_id"));
            pag_paginaT.setEnc_nr_id(rs.getInt("enc_nr_id"));
            pag_paginaT.setPag_tx_nome(rs.getString("pag_tx_nome"));
            pag_paginaT.setPag_bt_arquivo(rs.getBytes("pag_bt_arquivo"));
            objs.add(pag_paginaT);
        }
        return objs;
    }
    public List<Pag_paginaT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pag_nr_id, enc_nr_id, pag_tx_nome from i9im.pag_pagina";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Pag_paginaT> list = resultSetToObjectTransfer(rs);
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

    public List<Pag_paginaT> getByPK(Pag_paginaT pag_paginaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pag_nr_id, enc_nr_id, pag_tx_nome from i9im.pag_pagina where  pag_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pag_paginaT.getPag_nr_id());
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

    public List<Pag_paginaT> getByPag_nr_id(Pag_paginaT pag_paginaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pag_nr_id, enc_nr_id, pag_tx_nome from i9im.pag_pagina where  pag_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pag_paginaT.getPag_nr_id());
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

    public List<Pag_paginaT> getByEnc_nr_id(Pag_paginaT pag_paginaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pag_nr_id, enc_nr_id, pag_tx_nome from i9im.pag_pagina where  enc_nr_id = ? order by pag_nr_id ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pag_paginaT.getEnc_nr_id());
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

    public List<Pag_paginaT> getByPag_bt_arquivo(Pag_paginaT pag_paginaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pag_pagina where  pag_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pag_paginaT.getPag_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransferArquivo(rs);
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
    public List<Pag_paginaT> getByEnc_encarte(Pag_paginaT pag_paginaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.pag_pagina where enc_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pag_paginaT.getEnc_nr_id());
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
