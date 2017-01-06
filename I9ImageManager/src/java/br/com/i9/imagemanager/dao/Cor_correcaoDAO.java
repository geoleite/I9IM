package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;

public class Cor_correcaoDAO extends ObjectDAO {

    public Cor_correcaoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.cor_correcao  ( tic_nr_id, cor_tx_observacao, set_nr_id, usu_nr_id, cor_tx_status, cor_nr_posx, cor_nr_posy, reg_nr_id, cor_dt_corrigido, pag_nr_id, cor_nr_posx2, cor_nr_posy2) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ?, ?, ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cor_correcaoT.getTic_nr_id());
            pStmt.setObject(2, cor_correcaoT.getCor_tx_observacao());
            pStmt.setObject(3, cor_correcaoT.getSet_nr_id());
            pStmt.setObject(4, cor_correcaoT.getUsu_nr_id());
            pStmt.setObject(5, cor_correcaoT.getCor_tx_status());
            pStmt.setObject(6, cor_correcaoT.getCor_nr_posx());
            pStmt.setObject(7, cor_correcaoT.getCor_nr_posy());
            pStmt.setObject(8, cor_correcaoT.getReg_nr_id());
            pStmt.setObject(9, cor_correcaoT.getCor_dt_corrigido());
            pStmt.setObject(10, cor_correcaoT.getPag_nr_id());
            pStmt.setObject(11, cor_correcaoT.getCor_nr_posx2());
            pStmt.setObject(12, cor_correcaoT.getCor_nr_posy2());
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

    public void update(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.cor_correcao set  tic_nr_id=?, cor_tx_observacao=?, set_nr_id=?, usu_nr_id=?, cor_tx_status=?, cor_nr_posx=?, cor_nr_posy=?, reg_nr_id=?, cor_dt_corrigido=?, pag_nr_id=?  where  cor_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cor_correcaoT.getTic_nr_id());
            pStmt.setObject(2, cor_correcaoT.getCor_tx_observacao());
            pStmt.setObject(3, cor_correcaoT.getSet_nr_id());
            pStmt.setObject(4, cor_correcaoT.getUsu_nr_id());
            pStmt.setObject(5, cor_correcaoT.getCor_tx_status());
            pStmt.setObject(6, cor_correcaoT.getCor_nr_posx());
            pStmt.setObject(7, cor_correcaoT.getCor_nr_posy());
            pStmt.setObject(8, cor_correcaoT.getReg_nr_id());
            pStmt.setObject(9, cor_correcaoT.getCor_dt_corrigido());
            pStmt.setObject(10, cor_correcaoT.getPag_nr_id());
            pStmt.setObject(11, cor_correcaoT.getCor_nr_id());
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

    public void delete(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.cor_correcao where  cor_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cor_correcaoT.getCor_nr_id());
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

    /**
     * Excluir um comentário sem utilizar a chave
     * @param cor_correcaoT
     * @throws Exception
     */
    public void deleteSemChave(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.cor_correcao where  tic_nr_id=?, cor_tx_observacao=?, set_nr_id=?, usu_nr_id=?, cor_tx_status=?, cor_nr_posx=?, cor_nr_posy=?, reg_nr_id=?, cor_dt_corrigido=?, pag_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cor_correcaoT.getTic_nr_id());
            pStmt.setObject(2, cor_correcaoT.getCor_tx_observacao());
            pStmt.setObject(3, cor_correcaoT.getSet_nr_id());
            pStmt.setObject(4, cor_correcaoT.getUsu_nr_id());
            pStmt.setObject(5, cor_correcaoT.getCor_tx_status());
            pStmt.setObject(6, cor_correcaoT.getCor_nr_posx());
            pStmt.setObject(7, cor_correcaoT.getCor_nr_posy());
            pStmt.setObject(8, cor_correcaoT.getReg_nr_id());
            pStmt.setObject(10, cor_correcaoT.getPag_nr_id());
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

    private List<Cor_correcaoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Cor_correcaoT> objs = new Vector();
        while (rs.next()) {
            Cor_correcaoT cor_correcaoT = new Cor_correcaoT();
            cor_correcaoT.setCor_nr_id(rs.getInt("cor_nr_id"));
            cor_correcaoT.setTic_nr_id(rs.getInt("tic_nr_id"));
            cor_correcaoT.setCor_tx_observacao(rs.getString("cor_tx_observacao"));
            cor_correcaoT.setSet_nr_id(rs.getInt("set_nr_id"));
            cor_correcaoT.setUsu_nr_id(rs.getInt("usu_nr_id"));
            cor_correcaoT.setCor_tx_status(rs.getString("cor_tx_status"));
            cor_correcaoT.setCor_nr_posx(rs.getInt("cor_nr_posx"));
            cor_correcaoT.setCor_nr_posy(rs.getInt("cor_nr_posy"));
            cor_correcaoT.setCor_nr_posx2(rs.getInt("cor_nr_posx2"));
            cor_correcaoT.setCor_nr_posy2(rs.getInt("cor_nr_posy2"));
            cor_correcaoT.setReg_nr_id(rs.getInt("reg_nr_id"));
            cor_correcaoT.setCor_dt_corrigido(rs.getTimestamp("cor_dt_corrigido"));
            cor_correcaoT.setPag_nr_id(rs.getInt("pag_nr_id"));
            objs.add(cor_correcaoT);
        }
        return objs;
    }

    public List<Cor_correcaoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cor_correcao";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Cor_correcaoT> list = resultSetToObjectTransfer(rs);
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

    public List<Cor_correcaoT> getByPK(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cor_correcao where  cor_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cor_correcaoT.getCor_nr_id());
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

    public List<Cor_correcaoT> getByCor_nr_id(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cor_correcao where  cor_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cor_correcaoT.getCor_nr_id());
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

    public List<Cor_correcaoT> getByTic_nr_id(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cor_correcao where  tic_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cor_correcaoT.getTic_nr_id());
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

    public List<Cor_correcaoT> getByCor_tx_observacao(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cor_correcao where  Upper(cor_tx_observacao) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cor_correcaoT.getCor_tx_observacao() + '%');
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

    public List<Cor_correcaoT> getBySetorPagina(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cor_correcao where  set_nr_id = ? and pag_nr_id=? order by cor_dt_corrigido";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cor_correcaoT.getSet_nr_id());
            pStmt.setObject(2, cor_correcaoT.getPag_nr_id());
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

    public List<Cor_correcaoT> getByUsuarioPagina(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cor_correcao where  usu_nr_id = ? and pag_nr_id=? order by cor_dt_corrigido";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cor_correcaoT.getUsu_nr_id());
            pStmt.setObject(2, cor_correcaoT.getPag_nr_id());
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

    private List<Usu_usuarioT> resultSetToObjectTransferUsuario(ResultSet rs) throws Exception {
        List<Usu_usuarioT> objs = new Vector();
        while (rs.next()) {
            Usu_usuarioT usu_usuarioT = new Usu_usuarioT();
            usu_usuarioT.setUsu_nr_id(rs.getInt("usu_nr_id"));
            usu_usuarioT.setUsu_tx_nome(rs.getString("usu_tx_nome"));
            usu_usuarioT.setUsu_tx_login(rs.getString("usu_tx_login"));
            usu_usuarioT.setUsu_tx_senha("");
            usu_usuarioT.setUsu_tx_status(rs.getString("usu_tx_status"));
            usu_usuarioT.setUsu_tx_email(rs.getString("usu_tx_email"));
            objs.add(usu_usuarioT);
        }
        return objs;
    }

    public List<Usu_usuarioT> getUsuariosByPagina(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select distinct usu.* from i9im.cor_correcao cor, portal.usu_usuario usu where cor.pag_nr_id=? and cor.usu_nr_id=usu.usu_nr_id order by usu.usu_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cor_correcaoT.getPag_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransferUsuario(rs);
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

    public List<Cor_correcaoT> getBySet_nr_id(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cor_correcao where  set_nr_id = ? order by cor_dt_corrigido";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cor_correcaoT.getSet_nr_id());
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

    public List<Cor_correcaoT> getByUsu_nr_id(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cor_correcao where  usu_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cor_correcaoT.getUsu_nr_id());
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

    public List<Cor_correcaoT> getByCor_tx_status(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cor_correcao where  Upper(cor_tx_status) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cor_correcaoT.getCor_tx_status() + '%');
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

    public List<Cor_correcaoT> getByCor_nr_posx(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cor_correcao where  cor_nr_posx = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cor_correcaoT.getCor_nr_posx());
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

    public List<Cor_correcaoT> getByCor_nr_posy(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cor_correcao where  cor_nr_posy = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cor_correcaoT.getCor_nr_posy());
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

    public List<Cor_correcaoT> getByReg_nr_id(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cor_correcao where  reg_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cor_correcaoT.getReg_nr_id());
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

    public List<Cor_correcaoT> getByCor_dt_corrigido(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cor_correcao where  cor_dt_corrigido = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cor_correcaoT.getCor_dt_corrigido());
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

    public List<Cor_correcaoT> getByPag_nr_id(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cor_correcao where  pag_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cor_correcaoT.getPag_nr_id());
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
    public List<Cor_correcaoT> getByUse_usuario_setor(Cor_correcaoT cor_correcaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.cor_correcao where use_usuario_setor.set_nr_id=? and use_usuario_setor.usu_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cor_correcaoT.getSet_nr_id());
            pStmt.setObject(2, cor_correcaoT.getUsu_nr_id());
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
