package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.i9.imagemanager.transfer.Set_setorNewT;
import br.com.jdragon.dao.*;

public class Set_setorNewDAO extends ObjectDAO {

    public Set_setorNewDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Set_setorNewT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.set_setor  ( set_tx_nome, set_tx_status, set_nr_idsetorpai, set_tx_visivel, emp_nr_id) values ( ? , ? , ?, ?, ?  )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_setorT.getSet_tx_nome());
            pStmt.setObject(2, set_setorT.getSet_tx_status());
            pStmt.setObject(3, set_setorT.getSet_nr_idsetorpai());
            pStmt.setObject(4, set_setorT.getSet_tx_visivel());
            pStmt.setObject(5, set_setorT.getEmp_nr_id());
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
    public void insertImportacao(Set_setorNewT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.set_setor  (set_tx_idsap, set_tx_nome, set_tx_status, set_nr_idsetorpai, set_tx_visivel, emp_nr_id) values ( ? , ? , ?, ?, ?, ?  )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_setorT.getSet_tx_idsap());
            pStmt.setObject(2, set_setorT.getSet_tx_nome());
            pStmt.setObject(3, set_setorT.getSet_tx_status());
            pStmt.setObject(4, set_setorT.getSet_nr_idsetorpai());
            pStmt.setObject(5, set_setorT.getSet_tx_visivel());
            pStmt.setObject(6, set_setorT.getEmp_nr_id());
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

    public void update(Set_setorNewT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.set_setor set  set_tx_nome=?, set_tx_status=?, set_nr_idsetorpai=?, set_tx_visivel=?, emp_nr_id=?, set_tx_idsap=?  where  set_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_setorT.getSet_tx_nome());
            pStmt.setObject(2, set_setorT.getSet_tx_status());
            pStmt.setObject(3, set_setorT.getSet_nr_idsetorpai());
            pStmt.setObject(4, set_setorT.getSet_tx_visivel());
            pStmt.setObject(5, set_setorT.getEmp_nr_id());
            pStmt.setObject(6, set_setorT.getSet_tx_idsap());
            pStmt.setObject(7, set_setorT.getSet_nr_id());
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

    public void delete(Set_setorNewT set_setorT) throws Exception {
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

    private List<Set_setorNewT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Set_setorNewT> objs = new Vector();
        while (rs.next()) {
            Set_setorNewT set_setorT = new Set_setorNewT();
            set_setorT.setSet_nr_id(rs.getInt("set_nr_id"));
            set_setorT.setSet_tx_nome(rs.getString("set_tx_nome"));
            set_setorT.setSet_tx_status(rs.getString("set_tx_status"));
            set_setorT.setSet_nr_idsetorpai(rs.getInt("set_nr_idsetorpai"));
            set_setorT.setSet_tx_visivel(rs.getString("set_tx_visivel"));
            set_setorT.setEmp_nr_id(rs.getInt("emp_nr_id"));
            set_setorT.setSet_tx_idsap(rs.getString("set_tx_idsap"));
            objs.add(set_setorT);
        }
        return objs;
    }

    public List<Set_setorNewT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.set_setor where set_tx_status='A' and set_tx_visivel='S' order by set_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Set_setorNewT> list = resultSetToObjectTransfer(rs);
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

    /**
     * Obtendo o nível 0 da hierarquia
     * @return
     * @throws Exception
     */
    public List<Set_setorNewT> getAllSemPai() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.set_setor where set_nr_idsetorpai=0 and set_tx_visivel='S' order by set_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Set_setorNewT> list = resultSetToObjectTransfer(rs);
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

    /**
     * Obtendo o nivel 1 da hierarquia
     * @return
     * @throws Exception
     */
    public List<Set_setorNewT> getAllNivel1() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.set_setor where length(set_tx_idsap)=4  and set_tx_visivel='S' order by set_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Set_setorNewT> list = resultSetToObjectTransfer(rs);
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

    public List<Set_setorNewT> getAllFilhos(Set_setorNewT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.set_setor where set_nr_idsetorpai=? and set_tx_visivel='S' order by set_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_setorT.getSet_nr_id());
            rs = pStmt.executeQuery();
            List<Set_setorNewT> list = resultSetToObjectTransfer(rs);
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

    public List<Set_setorNewT> getByPK(Set_setorNewT set_setorT) throws Exception {
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

    public List<Set_setorNewT> getBySet_nr_id(Set_setorNewT set_setorT) throws Exception {
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

    public List<Set_setorNewT> getBySet_tx_idsap(Set_setorNewT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.set_setor where  set_tx_idsap = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_setorT.getSet_tx_idsap());
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

    public List<Set_setorNewT> getBySet_tx_nome(Set_setorNewT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.set_setor where  Upper(set_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + set_setorT.getSet_tx_nome() + '%');
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

    public List<Set_setorNewT> getBySet_tx_status(Set_setorNewT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.set_setor where  Upper(set_tx_status) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + set_setorT.getSet_tx_status() + '%');
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

    public List<Set_setorNewT> getBySet_nr_idsetorpai(Set_setorNewT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.set_setor where  set_nr_idsetorpai = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_setorT.getSet_nr_idsetorpai());
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

    /** Metodos FK */
    public List<Set_setorNewT> getBySet_setor(Set_setorNewT set_setorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from i9im.set_setor where set_setor.set_nr_id=?  ";
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
}
