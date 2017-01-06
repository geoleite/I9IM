package br.com.i9.imagemanager.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Sel_seloDAO extends ObjectDAO {

    private static int total = 500;
    private String sinal = "sinalizacao_selo";
    private String path = "/opt/i9im/sel_selo/";

    public Sel_seloDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public int getAutoIncremento() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select max(sel_nr_id) from i9im.sel_selo";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                rs = null;
            } catch (Exception e) {
            }
            try {
                ps.close();
                ps = null;
            } catch (Exception e) {
            }
        }
        return 0;
    }

    public void insert(Sel_seloT sel_seloT) throws Exception {
        sel_seloT.setSel_dt_validadefim(new java.sql.Date(System.currentTimeMillis()));
        sel_seloT.setSel_dt_validadeinicio(sel_seloT.getSel_dt_validadefim());
        insertPromocional(sel_seloT);
    }

    public void insertPromocional(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.sel_selo  ( cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_bt_arquivo, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sel_seloT.getCls_nr_id());
            pStmt.setObject(2, sel_seloT.getTid_nr_id());
            pStmt.setObject(3, sel_seloT.getSel_tx_nome());
            pStmt.setObject(4, sel_seloT.getSel_tx_descricao());
            java.sql.Date dt = new java.sql.Date(sel_seloT.getSel_dt_cadastro().getTime());
            pStmt.setObject(5, dt);
            pStmt.setObject(6, sel_seloT.getSel_tx_situacao());
            pStmt.setObject(7, "".getBytes());
            dt = new java.sql.Date(sel_seloT.getSel_dt_validadeinicio().getTime());
            pStmt.setObject(8, dt);
            dt = new java.sql.Date(sel_seloT.getSel_dt_validadefim().getTime());
            pStmt.setObject(9, dt);
            pStmt.setObject(10, sel_seloT.getSel_tx_promocional());
            synchronized (sinal) {
                pStmt.execute();
                sel_seloT.setSel_nr_id(getAutoIncremento());
                setFileBytes(sel_seloT.getSel_nr_id(), sel_seloT.getSel_bt_arquivo());
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

    public void insertPromocionalOld(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.sel_selo  ( cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_bt_arquivo, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sel_seloT.getCls_nr_id());
            pStmt.setObject(2, sel_seloT.getTid_nr_id());
            pStmt.setObject(3, sel_seloT.getSel_tx_nome());
            pStmt.setObject(4, sel_seloT.getSel_tx_descricao());
            java.sql.Date dt = new java.sql.Date(sel_seloT.getSel_dt_cadastro().getTime());
            pStmt.setObject(5, dt);
            pStmt.setObject(6, sel_seloT.getSel_tx_situacao());
            pStmt.setObject(7, sel_seloT.getSel_bt_arquivo());
            dt = new java.sql.Date(sel_seloT.getSel_dt_validadeinicio().getTime());
            pStmt.setObject(8, dt);
            dt = new java.sql.Date(sel_seloT.getSel_dt_validadefim().getTime());
            pStmt.setObject(9, dt);
            pStmt.setObject(10, sel_seloT.getSel_tx_promocional());
            pStmt.execute();
            synchronized (sinal) {
                pStmt.execute();
                sel_seloT.setSel_nr_id(getAutoIncremento());
                StringBuffer pathArquivo = new StringBuffer(getPath());
                pathArquivo.append(sel_seloT.getSel_nr_id());
                setFileBytes(sel_seloT.getSel_nr_id(), sel_seloT.getSel_bt_arquivo());
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

    public void insert1(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.sel_selo  ( cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_bt_arquivo, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sel_seloT.getCls_nr_id());
            pStmt.setObject(2, sel_seloT.getTid_nr_id());
            pStmt.setObject(3, sel_seloT.getSel_tx_nome());
            pStmt.setObject(4, sel_seloT.getSel_tx_descricao());
            pStmt.setObject(5, sel_seloT.getSel_dt_cadastro());
            pStmt.setObject(6, sel_seloT.getSel_tx_situacao());
            pStmt.setObject(7, "");
            pStmt.setObject(8, sel_seloT.getSel_dt_validadeinicio());
            pStmt.setObject(9, sel_seloT.getSel_dt_validadefim());
            pStmt.setObject(10, sel_seloT.getSel_tx_promocional());
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

    public void update(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.sel_selo set  cls_nr_id=?, tid_nr_id=?, sel_tx_nome=?, sel_tx_descricao=?, sel_dt_cadastro=?, sel_tx_situacao=?, sel_bt_arquivo=?, sel_dt_validadeinicio=?, sel_dt_validadefim=?, sel_tx_promocional=?  where  sel_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sel_seloT.getCls_nr_id());
            pStmt.setObject(2, sel_seloT.getTid_nr_id());
            pStmt.setObject(3, sel_seloT.getSel_tx_nome());
            pStmt.setObject(4, sel_seloT.getSel_tx_descricao());
            pStmt.setObject(5, sel_seloT.getSel_dt_cadastro());
            pStmt.setObject(6, sel_seloT.getSel_tx_situacao());
            pStmt.setObject(7, sel_seloT.getSel_bt_arquivo());
            pStmt.setObject(8, sel_seloT.getSel_dt_validadeinicio());
            pStmt.setObject(9, sel_seloT.getSel_dt_validadefim());
            pStmt.setObject(10, sel_seloT.getSel_tx_promocional());
            pStmt.setObject(11, sel_seloT.getSel_nr_id());
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

    public void substituirArquivo(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.sel_selo set  tid_nr_id=?, sel_tx_nome=?, sel_tx_descricao=?, sel_dt_cadastro=?, sel_tx_situacao=?, sel_bt_arquivo=? where  sel_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sel_seloT.getTid_nr_id());
            pStmt.setObject(2, sel_seloT.getSel_tx_nome());
            pStmt.setObject(3, sel_seloT.getSel_tx_descricao());
            pStmt.setObject(4, sel_seloT.getSel_dt_cadastro());
            pStmt.setObject(5, sel_seloT.getSel_tx_situacao());
            pStmt.setObject(6, "");
            pStmt.setObject(7, sel_seloT.getSel_nr_id());
            pStmt.execute();
            setFileBytes(sel_seloT.getSel_nr_id(), sel_seloT.getSel_bt_arquivo());
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void delete(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.sel_selo where  sel_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sel_seloT.getSel_nr_id());
            pStmt.execute();
            StringBuffer pathArquivo = new StringBuffer(getPath());
            pathArquivo.append(sel_seloT.getSel_nr_id());
            deleteFileBytes(pathArquivo.toString());
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void updateSituacaoSelo(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.sel_selo set sel_tx_situacao=? where  sel_nr_id=? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sel_seloT.getSel_tx_situacao());
            pStmt.setObject(2, sel_seloT.getSel_nr_id());
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

    private List<Sel_seloT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Sel_seloT> objs = new Vector();
        while (rs.next()) {
            Sel_seloT sel_seloT = new Sel_seloT();
            sel_seloT.setSel_nr_id(rs.getInt("sel_nr_id"));
            sel_seloT.setCls_nr_id(rs.getInt("cls_nr_id"));
            sel_seloT.setTid_nr_id(rs.getInt("tid_nr_id"));
            sel_seloT.setSel_tx_nome(rs.getString("sel_tx_nome"));
            sel_seloT.setSel_tx_descricao(rs.getString("sel_tx_descricao"));
            sel_seloT.setSel_dt_cadastro(rs.getDate("sel_dt_cadastro"));
            sel_seloT.setSel_tx_situacao(rs.getString("sel_tx_situacao"));
            //sel_seloT.setSel_bt_arquivo(rs.getBytes("sel_bt_arquivo"));
            sel_seloT.setSel_dt_validadeinicio(rs.getDate("sel_dt_validadeinicio"));
            sel_seloT.setSel_dt_validadefim(rs.getDate("sel_dt_validadefim"));
            sel_seloT.setSel_tx_promocional(rs.getString("sel_tx_promocional"));
            objs.add(sel_seloT);
        }
        return objs;
    }

    private List<Sel_seloT> resultSetToObjectTransferArquivo(ResultSet rs) throws Exception {
        List<Sel_seloT> objs = new Vector();
        while (rs.next()) {
            Sel_seloT sel_seloT = new Sel_seloT();
            sel_seloT.setSel_nr_id(rs.getInt("sel_nr_id"));
            //sel_seloT.setSel_bt_arquivo(rs.getBytes("sel_bt_arquivo"));
            sel_seloT.setSel_tx_nome(rs.getString("sel_tx_nome"));
            byte[] bytes = getFileBytes(sel_seloT.getSel_nr_id());
            sel_seloT.setSel_bt_arquivo(bytes);
            objs.add(sel_seloT);
        }
        return objs;
    }

    /**
     * Obtém todos os arquivos de um evento com data superior à data da ultima exportacao do evento
     * @param eveT
     * @return
     * @throws Exception
     */
    public List<Sel_seloT> getEvento(Eve_eventoT eveT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel.sel_nr_id, sel.cls_nr_id, sel.tid_nr_id, sel.sel_tx_nome, sel.sel_tx_descricao, sel.sel_dt_cadastro, sel.sel_tx_situacao, sel.sel_dt_validadeinicio, sel.sel_dt_validadefim, sel.sel_tx_promocional from i9im.eve_evento eve , i9im.pro_eve pe, i9im.pro_produto pro, i9im.pro_sel ps, i9im.sel_selo sel where pe.eve_nr_id=? and pe.pro_nr_id=pro.pro_nr_id and pro.pro_tx_situacao='A' and ps.pro_nr_id = pro.pro_nr_id and ps.sel_nr_id=sel.sel_nr_id and sel.sel_tx_situacao='A' and eve.eve_nr_id=pe.eve_nr_id and (sel.sel_dt_cadastro > coalesce ((select max(ond_dt_criacao) from i9im.ond_onda where eve.eve_nr_id=eve_nr_id), '01/01/2000' )  or ps.ps_dt_criacao > coalesce ((select max(ond_dt_criacao) from i9im.ond_onda where eve.eve_nr_id=eve_nr_id), '01/01/2000' )  )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eveT.getEve_nr_id());
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

    public int getCountTotal() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(sel_nr_id) from i9im.sel_selo";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
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

    private void deleteFileBytes(String pathArquivo) {
        try {
            File file = new File(pathArquivo);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getPasta(int id) {
        boolean calculando = true;
        String pasta = "";
        int tt = 0;
        int inicio = 0;
        while (calculando) {
            tt += total;
            if (id < tt) {
                pasta = inicio + "_" + (tt - 1);
                break;
            }
            inicio = tt;
        }
        return pasta;
    }

    private void setFileBytes(int selNrId, byte[] dados) {
        try {
            StringBuffer pathArquivo = new StringBuffer(getPath());
            pathArquivo.append(getPasta(selNrId));

            File file = new File(pathArquivo.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            pathArquivo.append("/").append(selNrId);

            file = new File(pathArquivo.toString());
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bos.write(dados);
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] getFileBytes(int selNrId) {
        try {
            StringBuffer pathArquivo = new StringBuffer(getPath());
            pathArquivo.append(getPasta(selNrId)).append("/").append(selNrId);

            File file = new File(pathArquivo.toString());
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] dados = new byte[2048];
            int controle = -1;
            while ((controle = bis.read(dados)) > -1) {
                byte[] temp = new byte[controle];
                System.arraycopy(dados, 0, temp, 0, controle);
                baos.write(temp);
            }
            bis.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Sel_seloT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel_nr_id, cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional from i9im.sel_selo";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Sel_seloT> list = resultSetToObjectTransfer(rs);
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

    public List<Sel_seloT> getAllPromocionaisForaVigencia() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel_nr_id, cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional from i9im.sel_selo where  sel_tx_promocional='S' and sel_tx_situacao='A' and sel_dt_validadefim < ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, new java.sql.Date(new java.util.Date().getTime()));
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

    /**
     * Obtém todos os selos de um produto
     * @param proT
     * @return
     * @throws Exception
     */
    public List<Sel_seloT> getSelosProdutos(Pro_produtoT proT, Cls_classificacao_seloT clsT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel_nr_id, cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional from  i9im.sel_selo sel where sel.cls_nr_id=? and sel.sel_tx_situacao='A' and sel.sel_nr_id in (select sel_nr_id from i9im.pro_sel ps where ps.pro_nr_id=?) order by sel_tx_nome ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, clsT.getCls_nr_id());
            pStmt.setObject(2, proT.getPro_nr_id());
            rs = pStmt.executeQuery();
            List<Sel_seloT> list = resultSetToObjectTransfer(rs);
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
     * Obtém todos os selos que não pertence a um determinado prouduto
     * @param proT
     * @return
     * @throws Exception
     */
    public List<Sel_seloT> getSelosNaoProdutos(Sel_seloT selT, Pro_produtoT proT, Cls_classificacao_seloT clsT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel_nr_id, cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional from i9im.sel_selo sel where sel.cls_nr_id=?  and sel.sel_tx_situacao='A' and upper(sel.sel_tx_nome) like upper(?) and sel.sel_nr_id not in (select sel_nr_id from i9im.pro_sel ps where ps.pro_nr_id=?) order by sel_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, clsT.getCls_nr_id());
            pStmt.setObject(2, "%".concat(selT.getSel_tx_nome()).concat("%"));
            pStmt.setObject(3, proT.getPro_nr_id());
            rs = pStmt.executeQuery();
            List<Sel_seloT> list = resultSetToObjectTransfer(rs);
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

    public List<Sel_seloT> getByPK(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel_nr_id, cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional from i9im.sel_selo where  sel_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sel_seloT.getSel_nr_id());
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

    public List<Sel_seloT> getBySel_nr_id(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel_nr_id, cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional from i9im.sel_selo where  sel_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sel_seloT.getSel_nr_id());
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

    public List<Sel_seloT> getByCls_nr_id(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel_nr_id, cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional from i9im.sel_selo where  cls_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sel_seloT.getCls_nr_id());
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

    public List<Sel_seloT> getByTid_nr_id(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel_nr_id, cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional from i9im.sel_selo where  tid_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sel_seloT.getTid_nr_id());
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

    public List<Sel_seloT> getBySel_tx_nome(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel_nr_id, cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional from i9im.sel_selo where  Upper(sel_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + sel_seloT.getSel_tx_nome() + '%');
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

    public List<Sel_seloT> getBySel_tx_descricao(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel_nr_id, cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional from i9im.sel_selo where  Upper(sel_tx_descricao) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + sel_seloT.getSel_tx_descricao() + '%');
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

    public List<Sel_seloT> getBySel_dt_cadastro(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel_nr_id, cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional from i9im.sel_selo where  sel_dt_cadastro = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sel_seloT.getSel_dt_cadastro());
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

    public List<Sel_seloT> getBySel_tx_situacao(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel_nr_id, cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional from i9im.sel_selo where  Upper(sel_tx_situacao) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + sel_seloT.getSel_tx_situacao() + '%');
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

    public List<Sel_seloT> getBySel_bt_arquivo(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel_nr_id, sel_tx_nome, sel_bt_arquivo from i9im.sel_selo  where  sel_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sel_seloT.getSel_nr_id());
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

    public void getBySel_bt_arquivoStream(Sel_seloT sel_seloT, OutputStream os) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel_bt_arquivo from i9im.sel_selo  where  sel_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sel_seloT.getSel_nr_id());
            rs = pStmt.executeQuery();
            if (rs.next()) {
                InputStream is = rs.getBinaryStream("sel_bt_arquivo");
                int controle = -1;
                byte[] buffer = new byte[1024];
                while ((controle = is.read(buffer)) != -1) {
                    byte[] bufferTmp = new byte[controle];
                    System.arraycopy(buffer, 0, bufferTmp, 0, controle);
                    os.write(bufferTmp);
                }
                os.flush();
                os.close();
            }

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

    public List<Sel_seloT> getBySel_dt_validadeinicio(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel_nr_id, cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional from i9im.sel_selo where  sel_dt_validadeinicio = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sel_seloT.getSel_dt_validadeinicio());
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

    public List<Sel_seloT> getBySel_dt_validadefim(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel_nr_id, cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional from i9im.sel_selo where  sel_dt_validadefim = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sel_seloT.getSel_dt_validadefim());
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

    public List<Sel_seloT> getBySel_tx_promocional(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel_nr_id, cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional from i9im.sel_selo where  Upper(sel_tx_promocional) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + sel_seloT.getSel_tx_promocional() + '%');
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
    public List<Sel_seloT> getByCls_classificacao_selo(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel_nr_id, cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional from i9im.sel_selo where cls_nr_id=? order by sel_tx_nome ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sel_seloT.getCls_nr_id());
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

    public List<Sel_seloT> getByCls_classificacao_seloNomeArquivo(Sel_seloT sel_seloT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sel_nr_id, cls_nr_id, tid_nr_id, sel_tx_nome, sel_tx_descricao, sel_dt_cadastro, sel_tx_situacao, sel_dt_validadeinicio, sel_dt_validadefim, sel_tx_promocional from i9im.sel_selo where sel_tx_situacao='A' and cls_nr_id=? and upper(sel_tx_nome) like upper(?) order by sel_tx_nome ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, sel_seloT.getCls_nr_id());
            pStmt.setObject(2, "%".concat(sel_seloT.getSel_tx_nome()).concat("%"));
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

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        if (path != null) {
            this.path = path;
        }
    }
}
