package br.com.i9.imagemanager.dao;

import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.transfer.*;
import java.awt.SystemColor;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Arq_arquivoDAO extends ObjectDAO {

    int total = 500;
    private String sinal = "sinalizacao_arquivo";
    private String path = "/opt/i9im/arq_arquivo/";
    private String path_thumb = "/opt/i9im/arq_arquivo_thumb/";

    public Arq_arquivoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public int getAutoIncremento() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select max(arq_nr_id) from i9im.arq_arquivo";
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

    public void insert(Arq_arquivoT arq_arquivoT) throws Exception {
        arq_arquivoT.setArq_dt_validadefim(new java.sql.Date(System.currentTimeMillis()));
        arq_arquivoT.setArq_dt_validadeinicio(arq_arquivoT.getArq_dt_validadefim());
        insertPromocional(arq_arquivoT);
    }

    public void insertPromocional(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into i9im.arq_arquivo (pro_nr_id, cla_nr_id, tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_bt_arquivo, arq_dt_validadeinicio, arq_dt_validadefim, arq_tx_promocional, arq_bt_thumb) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?, ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arq_arquivoT.getPro_nr_id());
            pStmt.setObject(2, arq_arquivoT.getCla_nr_id());
            pStmt.setObject(3, arq_arquivoT.getTid_nr_id());
            pStmt.setObject(4, arq_arquivoT.getArq_tx_nome());
            pStmt.setObject(5, arq_arquivoT.getArq_tx_descricao());
            java.sql.Timestamp dt6 = new java.sql.Timestamp(arq_arquivoT.getArq_dt_cadastro().getTime());
            pStmt.setObject(6, dt6);
            pStmt.setObject(7, arq_arquivoT.getArq_tx_situacao());
            pStmt.setObject(8, "".getBytes());
            java.sql.Timestamp dt9 = new java.sql.Timestamp(arq_arquivoT.getArq_dt_validadeinicio().getTime());
            pStmt.setObject(9, dt9);
            //pStmt.setObject(9, arq_arquivoT.getArq_dt_validadeinicio());
            //java.sql.Date dt10 = new java.sql.Date(arq_arquivoT.getArq_dt_cadastro().getTime());
            java.sql.Date dt10 = new java.sql.Date(System.currentTimeMillis());
            pStmt.setObject(10, dt10);
            //pStmt.setObject(10, arq_arquivoT.getArq_dt_validadefim());
            pStmt.setObject(11, arq_arquivoT.getArq_tx_promocional());
            pStmt.setObject(12, "".getBytes());
//            FileOutputStream fos1 = new FileOutputStream("/tmp/teste.png");
//            fos1.write(arq_arquivoT.getArq_bt_thumb());
//            fos1.flush();
//            fos1.close();
            synchronized (sinal) {
                pStmt.execute();
                arq_arquivoT.setArq_nr_id(getAutoIncremento());
                setFileBytes(arq_arquivoT.getArq_nr_id(), arq_arquivoT.getArq_bt_arquivo(), false);
                setFileBytes(arq_arquivoT.getArq_nr_id(), arq_arquivoT.getArq_bt_thumb(), true);
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

    public void update(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.arq_arquivo set  cla_nr_id=?, tid_nr_id=?, arq_tx_nome=?, arq_tx_descricao=?, arq_tx_situacao=?, arq_dt_validadeinicio=?, arq_dt_validadefim=?, arq_tx_promocional=?  where  pro_nr_id=? and arq_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arq_arquivoT.getCla_nr_id());
            pStmt.setObject(2, arq_arquivoT.getTid_nr_id());
            pStmt.setObject(3, arq_arquivoT.getArq_tx_nome());
            pStmt.setObject(4, arq_arquivoT.getArq_tx_descricao());
//            java.sql.Timestamp dt5 = new java.sql.Timestamp(arq_arquivoT.getArq_dt_cadastro().getTime());
//            pStmt.setObject(5, dt5);
            pStmt.setObject(5, arq_arquivoT.getArq_tx_situacao());
            pStmt.setObject(6, arq_arquivoT.getArq_dt_validadeinicio());
            pStmt.setObject(7, arq_arquivoT.getArq_dt_validadefim());
            pStmt.setObject(8, arq_arquivoT.getArq_tx_promocional());
            pStmt.setObject(9, arq_arquivoT.getPro_nr_id());
            pStmt.setObject(10, arq_arquivoT.getArq_nr_id());
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

    public void updateThumb(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.arq_arquivo set  arq_bt_thumb=?  where  pro_nr_id=? and arq_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, "".getBytes());
            pStmt.setObject(2, arq_arquivoT.getPro_nr_id());
            pStmt.setObject(3, arq_arquivoT.getArq_nr_id());
            pStmt.execute();
            setFileBytes(arq_arquivoT.getArq_nr_id(), arq_arquivoT.getArq_bt_thumb(), true);

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void substituirArquivo(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update i9im.arq_arquivo set  tid_nr_id=?, arq_tx_nome=?, arq_tx_descricao=?, arq_dt_cadastro=?, arq_bt_arquivo=?  where  pro_nr_id=? and arq_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arq_arquivoT.getTid_nr_id());
            pStmt.setObject(2, arq_arquivoT.getArq_tx_nome());
            pStmt.setObject(3, arq_arquivoT.getArq_tx_descricao());
            pStmt.setObject(4, new Date(System.currentTimeMillis()));
            pStmt.setObject(5, "".getBytes());
            pStmt.setObject(6, arq_arquivoT.getPro_nr_id());
            pStmt.setObject(7, arq_arquivoT.getArq_nr_id());
            pStmt.execute();
            setFileBytes(arq_arquivoT.getArq_nr_id(), arq_arquivoT.getArq_bt_arquivo(), false);
            setFileBytes(arq_arquivoT.getArq_nr_id(), arq_arquivoT.getArq_bt_thumb(), true);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public void delete(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from i9im.arq_arquivo where  pro_nr_id=? and arq_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arq_arquivoT.getPro_nr_id());
            pStmt.setObject(2, arq_arquivoT.getArq_nr_id());
            pStmt.execute();
            StringBuffer pathArquivo = new StringBuffer(path);
            pathArquivo.append(arq_arquivoT.getArq_nr_id());
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

    /**
     * Marca o arquivo como Excluido
     * @param ids
     * @throws Exception
     */
    public void deleteVarios(String ids) throws Exception {
        PreparedStatement pStmt = null;
        try {
            if (ids != null && ids.trim().length() > 0) {
//                StringBuffer sql = new StringBuffer("delete from i9im.arq_arquivo where arq_nr_id in (");
//                sql.append(ids).append(")");
                StringBuffer sql = new StringBuffer("update i9im.arq_arquivo set arq_tx_situacao='E' where arq_nr_id in (");
                sql.append(ids).append(")");
                pStmt = con.prepareStatement(sql.toString());
                pStmt.execute();
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

    /**
     * Marcar arquivo como inativo
     * @param ids
     * @throws Exception
     */
    public void inativarVarios(String ids) throws Exception {
        PreparedStatement pStmt = null;
        try {
            if (ids != null && ids.trim().length() > 0) {
//                StringBuffer sql = new StringBuffer("delete from i9im.arq_arquivo where arq_nr_id in (");
//                sql.append(ids).append(")");
                StringBuffer sql = new StringBuffer("update i9im.arq_arquivo set arq_tx_situacao='I' where arq_nr_id in (");
                sql.append(ids).append(")");
                pStmt = con.prepareStatement(sql.toString());
                pStmt.execute();
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

    /**
     * Marcar arquivo como ativo
     * @param ids
     * @throws Exception
     */
    public void reativarVarios(String ids) throws Exception {
        PreparedStatement pStmt = null;
        try {
            if (ids != null && ids.trim().length() > 0) {
//                StringBuffer sql = new StringBuffer("delete from i9im.arq_arquivo where arq_nr_id in (");
//                sql.append(ids).append(")");
                StringBuffer sql = new StringBuffer("update i9im.arq_arquivo set arq_tx_situacao='A' where arq_nr_id in (");
                sql.append(ids).append(")");
                pStmt = con.prepareStatement(sql.toString());
                pStmt.execute();
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

    private List<Arq_arquivoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Arq_arquivoT> objs = new Vector();
        while (rs.next()) {
            Arq_arquivoT arq_arquivoT = new Arq_arquivoT();
            arq_arquivoT.setPro_nr_id(rs.getInt("pro_nr_id"));
            arq_arquivoT.setArq_nr_id(rs.getInt("arq_nr_id"));
            arq_arquivoT.setCla_nr_id(rs.getInt("cla_nr_id"));
            arq_arquivoT.setTid_nr_id(rs.getInt("tid_nr_id"));
            arq_arquivoT.setArq_tx_nome(rs.getString("arq_tx_nome"));
            arq_arquivoT.setArq_tx_descricao(rs.getString("arq_tx_descricao"));
            arq_arquivoT.setArq_dt_cadastro(rs.getDate("arq_dt_cadastro"));
            arq_arquivoT.setArq_tx_situacao(rs.getString("arq_tx_situacao"));
            arq_arquivoT.setArq_dt_validadeinicio(rs.getDate("arq_dt_validadeinicio"));
            arq_arquivoT.setArq_dt_validadefim(rs.getDate("arq_dt_validadefim"));
            arq_arquivoT.setArq_tx_promocional(rs.getString("arq_tx_promocional"));
            objs.add(arq_arquivoT);
        }
        return objs;
    }

    private List<Arq_arquivoT> resultSetToObjectTransferBackup(ResultSet rs) throws Exception {
        List<Arq_arquivoT> objs = new Vector();
        while (rs.next()) {
            Arq_arquivoT arq_arquivoT = new Arq_arquivoT();
            arq_arquivoT.setPro_nr_id(rs.getInt("pro_nr_id"));
            arq_arquivoT.setArq_nr_id(rs.getInt("arq_nr_id"));
            arq_arquivoT.setCla_nr_id(rs.getInt("cla_nr_id"));
            arq_arquivoT.setArq_tx_nome(rs.getString("arq_tx_nome"));
            objs.add(arq_arquivoT);
        }
        return objs;
    }

    private List<Arq_arquivoT> resultSetToObjectTransferImagem(ResultSet rs) throws Exception {
        List<Arq_arquivoT> objs = new Vector();
        while (rs.next()) {
            Arq_arquivoT arq_arquivoT = new Arq_arquivoT();
            arq_arquivoT.setPro_nr_id(rs.getInt("pro_nr_id"));
            arq_arquivoT.setArq_nr_id(rs.getInt("arq_nr_id"));
            arq_arquivoT.setArq_tx_nome(rs.getString("arq_tx_nome"));
            //arq_arquivoT.setArq_bt_arquivo(rs.getBytes("arq_bt_arquivo"));
            //arq_arquivoT.setArq_bt_thumb(rs.getBytes("arq_bt_thumb"));
            byte[] bytes = {};
            try {
                String pathArq = new String(rs.getBytes("arq_bt_arquivo"));
                bytes = getFileBytes(arq_arquivoT.getArq_nr_id(), pathArq, false);
            } catch (Exception e) {
                bytes = getFileBytes(arq_arquivoT.getArq_nr_id(), null, false);
            }
            arq_arquivoT.setArq_bt_arquivo(bytes);

            //bytes = getFileBytes(arq_arquivoT.getArq_nr_id(), true);
            //arq_arquivoT.setArq_bt_thumb(bytes);
            objs.add(arq_arquivoT);
        }
        return objs;
    }

    private List<Arq_arquivoT> resultSetToObjectTransferThumb(ResultSet rs) throws Exception {
        List<Arq_arquivoT> objs = new Vector();
        while (rs.next()) {
            Arq_arquivoT arq_arquivoT = new Arq_arquivoT();
            arq_arquivoT.setPro_nr_id(rs.getInt("pro_nr_id"));
            arq_arquivoT.setArq_nr_id(rs.getInt("arq_nr_id"));
            arq_arquivoT.setArq_tx_nome(rs.getString("arq_tx_nome"));
            //arq_arquivoT.setArq_bt_thumb(rs.getBytes("arq_bt_thumb"));

            byte[] bytes = {};
            try {
                String pathThumb = new String(rs.getBytes("arq_bt_thumb"));
                bytes = getFileBytes(arq_arquivoT.getArq_nr_id(), pathThumb, true);
            } catch (Exception e) {
                bytes = getFileBytes(arq_arquivoT.getArq_nr_id(), null, true);
            }
            arq_arquivoT.setArq_bt_thumb(bytes);
            objs.add(arq_arquivoT);
        }
        return objs;
    }

    public List<Arq_arquivoT> getArquivosIntervalosCodigo(int codigoInicio, int codigoFinal) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from i9im.arq_arquivo arq where arq.arq_nr_id between ? and ? and arq_bt_thumb is null and arq_tx_situacao='A' order by arq_nr_id";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, codigoInicio);
            pStmt.setObject(2, codigoFinal);
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
     * Obtém o maior código cadastrado
     * @return
     * @throws Exception
     */
    public int getMaiorCodigo() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select max(arq_nr_id) from arq_arquivo";
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

    public int getCountTotal() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(arq_nr_id) from i9im.arq_arquivo";
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

    /**
     * Obtém a quantidade de imagens inserida em um intervalo
     * @param dtInicio
     * @param dtFim
     * @return
     * @throws Exception
     */
    public int getCountIntervalo(java.util.Date dtInicio, java.util.Date dtFim) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(arq_nr_id) from i9im.arq_arquivo where arq_dt_cadastro between ? and ?";
            pStmt = con.prepareStatement(sql);
            Date dt = new Date(dtInicio.getTime());
            pStmt.setObject(1, dt);
            dt = new Date(dtFim.getTime());
            pStmt.setObject(2, dt);
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

    public int getCountIntervaloSetor(Set_setorT setT, java.util.Date dtInicio, java.util.Date dtFim) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(arq.arq_nr_id) from ses_sessao ses, gru_grupo gru, pro_produto pro, i9im.arq_arquivo arq where ses.set_nr_id=? and ses.ses_nr_id = gru.ses_nr_id and gru.gru_nr_id = pro.gru_nr_id and gru.ses_nr_id = pro.ses_nr_id and arq.pro_nr_id = pro.pro_nr_id  and arq.arq_dt_cadastro between ? and ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, setT.getSet_nr_id());
            Date dt = new Date(dtInicio.getTime());
            pStmt.setObject(2, dt);
            dt = new Date(dtFim.getTime());
            pStmt.setObject(3, dt);
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

    public List<Arq_arquivoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from i9im.arq_arquivo order by arq_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Arq_arquivoT> list = resultSetToObjectTransfer(rs);
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

    public List<Arq_arquivoT> getAllBackup(Date dtUltimoBackup) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,arq_tx_nome from i9im.arq_arquivo where arq_tx_situacao<>'E' and arq_dt_cadastro >= ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, dtUltimoBackup);
            rs = pStmt.executeQuery();
            List<Arq_arquivoT> list = resultSetToObjectTransferBackup(rs);
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
     * Obtém todos os arquivos promocionais que estao fora da vigencia
     * @param arqT
     * @return
     * @throws Exception
     */
    public List<Arq_arquivoT> getAllPromocionaisForaVigencia() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from i9im.arq_arquivo where  arq_tx_promocional='S' and arq_tx_situacao='A' and arq_dt_validadefim < ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, new Date(new java.util.Date().getTime()));
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
     * Obtém a quantidade de imagens de um produto para uma determinada classificacao
     * @param arqT
     * @return
     * @throws Exception
     */
    public int getContImagemClassificacao(Arq_arquivoT arqT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(arq_nr_id) from i9im.arq_arquivo where pro_nr_id=? and arq_tx_situacao='A' and cla_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arqT.getPro_nr_id());
            pStmt.setObject(2, arqT.getCla_nr_id());
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

    public List<Arq_arquivoT> getAllPromocionais(Arq_arquivoT arqT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from i9im.arq_arquivo where pro_nr_id=? and cla_nr_id=? and arq_tx_promocional='S' and arq_tx_situacao=? order by arq_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arqT.getPro_nr_id());
            pStmt.setObject(2, arqT.getCla_nr_id());
            pStmt.setObject(3, arqT.getArq_tx_situacao());
            rs = pStmt.executeQuery();
            List<Arq_arquivoT> list = resultSetToObjectTransfer(rs);
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

    public List<Arq_arquivoT> getAllSituacaoPromocao(Arq_arquivoT arqT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from i9im.arq_arquivo where pro_nr_id=? and cla_nr_id=? and arq_tx_situacao=? and arq_tx_promocional=? order by arq_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arqT.getPro_nr_id());
            pStmt.setObject(2, arqT.getCla_nr_id());
            pStmt.setObject(3, arqT.getArq_tx_situacao());
            pStmt.setObject(4, arqT.getArq_tx_promocional());
            rs = pStmt.executeQuery();
            List<Arq_arquivoT> list = resultSetToObjectTransfer(rs);
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

    public List<Arq_arquivoT> getAllSituacao(Arq_arquivoT arqT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from i9im.arq_arquivo where pro_nr_id=? and cla_nr_id=? and arq_tx_situacao=? order by arq_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arqT.getPro_nr_id());
            pStmt.setObject(2, arqT.getCla_nr_id());
            pStmt.setObject(3, arqT.getArq_tx_situacao());
            rs = pStmt.executeQuery();
            List<Arq_arquivoT> list = resultSetToObjectTransfer(rs);
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

    public List<Arq_arquivoT> getByPK(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from i9im.arq_arquivo where  pro_nr_id=? and arq_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arq_arquivoT.getPro_nr_id());
            pStmt.setObject(2, arq_arquivoT.getArq_nr_id());
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
     * Obtém todos os arquivos de um evento com data superior à data da ultima exportacao do evento
     * @param eveT
     * @return
     * @throws Exception
     */
    public List<Arq_arquivoT> getEvento(Eve_eventoT eveT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select arq.pro_nr_id, arq.arq_nr_id, arq.cla_nr_id,arq.tid_nr_id, arq.arq_tx_nome, arq.arq_tx_descricao, arq.arq_dt_cadastro, arq.arq_tx_situacao, arq.arq_dt_validadeinicio, arq.arq_dt_validadefim,arq.arq_tx_promocional from i9im.eve_evento eve , i9im.arq_arquivo arq, i9im.pro_eve pe, i9im.pro_produto pro where pe.eve_nr_id=? and pe.pro_nr_id=pro.pro_nr_id and pro.pro_tx_situacao='A' and arq.pro_nr_id = pro.pro_nr_id and arq.arq_tx_situacao='A' and arq.cla_nr_id in (2) and eve.eve_nr_id=pe.eve_nr_id and arq.arq_dt_cadastro > coalesce ((select max(ond_dt_criacao) from i9im.ond_onda where eve.eve_nr_id=eve_nr_id), '01/01/2000' )  ";
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

    public List<Arq_arquivoT> getByPro_nr_id(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from i9im.arq_arquivo where  pro_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arq_arquivoT.getPro_nr_id());
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

    public List<Arq_arquivoT> getByArq_nr_id(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from i9im.arq_arquivo where  arq_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arq_arquivoT.getArq_nr_id());
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

    public List<Arq_arquivoT> getByClaPro(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from i9im.arq_arquivo where pro_nr_id=? and  cla_nr_id = ? order by arq_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arq_arquivoT.getPro_nr_id());
            pStmt.setObject(2, arq_arquivoT.getCla_nr_id());
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

    public List<Arq_arquivoT> getByTid_nr_id(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from i9im.arq_arquivo where  tid_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arq_arquivoT.getTid_nr_id());
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

    public List<Arq_arquivoT> getByArq_tx_nome(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from i9im.arq_arquivo where  Upper(arq_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + arq_arquivoT.getArq_tx_nome() + '%');
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

    public List<Arq_arquivoT> getByArq_tx_descricao(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from i9im.arq_arquivo where  Upper(arq_tx_descricao) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + arq_arquivoT.getArq_tx_descricao() + '%');
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

    public List<Arq_arquivoT> getByArq_dt_cadastro(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from i9im.arq_arquivo where  arq_dt_cadastro = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(arq_arquivoT.getArq_dt_cadastro().getTime());
            pStmt.setObject(1, dt1);
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

    public List<Arq_arquivoT> getByArq_tx_situacao(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from i9im.arq_arquivo where  Upper(arq_tx_situacao) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + arq_arquivoT.getArq_tx_situacao() + '%');
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

    private void updatePathArquivo(boolean thumb, String pathArq, int arqNrId) {
        PreparedStatement ps = null;
        try {
            String sql = "update i9im.arq_arquivo set arq_bt_arquivo=? where arq_nr_id=?";
            if (thumb) {
                sql = "update i9im.arq_arquivo set arq_bt_thumb=? where arq_nr_id=?";
            }
            ps = con.prepareStatement(sql);
            ps.setObject(1, pathArq.getBytes());
            ps.setObject(2, arqNrId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (Exception e) {
            }
        }

    }

    private void setFileBytes(int arqNrId, byte[] dados, boolean thumb) {
        try {
            StringBuffer pathArquivo = new StringBuffer(thumb ? path_thumb : path);
            pathArquivo.append(getPasta(arqNrId));
            File file = new File(pathArquivo.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            pathArquivo.append("/").append(arqNrId);
            file = new File(pathArquivo.toString());
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bos.write(dados);
            bos.flush();
            bos.close();
            updatePathArquivo(thumb, pathArquivo.toString(), arqNrId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] getFileBytes(int arqNrId, String pathArq, boolean thumb) {
        try {
            StringBuffer pathArquivo;
            if (pathArq == null || pathArq.trim().isEmpty()) {
                pathArquivo = new StringBuffer(thumb ? path_thumb : path);
                pathArquivo.append(getPasta(arqNrId)).append("/").append(arqNrId);
            } else {
                pathArquivo = new StringBuffer(pathArq);
            }

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

    /**
     * Obtém apenas imagem
     * @param arq_arquivoT
     * @return
     * @throws Exception
     */
    public List<Arq_arquivoT> getByArq_bt_arquivo(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, arq_bt_arquivo, arq_tx_nome from i9im.arq_arquivo where  arq_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arq_arquivoT.getArq_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransferImagem(rs);

//            List<Arq_arquivoT> list = new ArrayList<Arq_arquivoT>();
//            StringBuffer pathArquivo = new StringBuffer(path);
//            pathArquivo.append(arq_arquivoT.getArq_nr_id());
//            arq_arquivoT.setArq_bt_arquivo(getFileBytes(pathArquivo.toString()));
//            list.add(arq_arquivoT);
//            return list;
//            return 
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

    public List<Arq_arquivoT> getByArq_bt_thumb(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, arq_bt_thumb, arq_tx_nome from i9im.arq_arquivo where  arq_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arq_arquivoT.getArq_nr_id());
            rs = pStmt.executeQuery();

            return resultSetToObjectTransferThumb(rs);
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

    public List<Arq_arquivoT> getByArq_bt_thumbNotNull(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, arq_bt_thumb, arq_tx_nome from i9im.arq_arquivo where  arq_nr_id = ? and arq_ bt_thumb is not null";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arq_arquivoT.getArq_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransferThumb(rs);
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

    public boolean getByArq_bt_arquivoStream(Arq_arquivoT arq_arquivoT, OutputStream os) throws Exception {
        List<Arq_arquivoT> list = getByArq_bt_arquivo(arq_arquivoT);
        if (list.size() > 0) {
            arq_arquivoT = list.get(0);
            if (arq_arquivoT.getArq_bt_arquivo() != null) {
                os.write(arq_arquivoT.getArq_bt_arquivo());
                os.flush();
                os.close();
                return true;
            } 
        }
        return false;
//        PreparedStatement pStmt = null;
//        ResultSet rs = null;
//        try {
//            String sql = "select arq_bt_arquivo from i9im.arq_arquivo where  arq_nr_id = ? ";
//            pStmt = con.prepareStatement(sql);
//            pStmt.setObject(1, arq_arquivoT.getArq_nr_id());
//            rs = pStmt.executeQuery();
//            //return resultSetToObjectTransferImagem(rs);
//            if (rs.next()) {
//                InputStream is = rs.getBinaryStream("arq_bt_arquivo");
//                int controle = -1;
//                byte[] buffer = new byte[1024];
//                while ((controle = is.read(buffer)) != -1) {
//                    byte[] bufferTmp = new byte[controle];
//                    System.arraycopy(buffer, 0, bufferTmp, 0, controle);
//                    os.write(bufferTmp);
//                }
//                os.flush();
//                os.close();
//            }
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            try {
//                rs.close();
//                pStmt.close();
//            } catch (Exception e) {
//            }
//
//        }
    }

    public List<Arq_arquivoT> getArq_bt_arquivoVarios(String ids) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer sql = new StringBuffer("select pro_nr_id, arq_nr_id, arq_tx_nome, arq_bt_arquivo, arq_bt_thumb from i9im.arq_arquivo where  arq_nr_id in (");
            sql.append(ids).append(")");
            pStmt = con.prepareStatement(sql.toString());
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

    public List<Arq_arquivoT> getByArq_dt_validadeinicio(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from i9im.arq_arquivo where  arq_dt_validadeinicio = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arq_arquivoT.getArq_dt_validadeinicio());
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

    public List<Arq_arquivoT> getByArq_dt_validadefim(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from i9im.arq_arquivo where  arq_dt_validadefim = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arq_arquivoT.getArq_dt_validadefim());
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

    public List<Arq_arquivoT> getByArq_tx_promocional(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from i9im.arq_arquivo where  Upper(arq_tx_promocional) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + arq_arquivoT.getArq_tx_promocional() + '%');
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
    public List<Arq_arquivoT> getByPro_produto(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from arq_arquivo, pro_produto pro where pro.pro_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arq_arquivoT.getPro_nr_id());
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

    public List<Arq_arquivoT> getArquivosTratadosEletro() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select arq.pro_nr_id, arq.arq_nr_id, arq.cla_nr_id,arq.tid_nr_id, arq.arq_tx_nome, arq.arq_tx_descricao, arq.arq_dt_cadastro, arq.arq_tx_situacao, arq.arq_dt_validadeinicio, arq.arq_dt_validadefim,arq.arq_tx_promocional from ses_sessao ses, gru_grupo gru, sug_subgrupo sug, pro_produto pro, i9im.arq_arquivo arq where ses.set_nr_id=8 and ses.ses_nr_id=gru.ses_nr_id and sug.ses_nr_id=gru.ses_nr_id and sug.gru_nr_id=gru.gru_nr_id and pro.ses_nr_id=sug.ses_nr_id and pro.gru_nr_id=sug.gru_nr_id and pro.sug_nr_id=sug.sug_nr_id and arq.pro_nr_id=pro.pro_nr_id and cla_nr_id=2";
            pStmt = con.prepareStatement(sql);
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

    public List<Arq_arquivoT> getArquivosByExtensao(String extensaoTipo) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select arq.pro_nr_id, arq.arq_nr_id, arq.cla_nr_id,arq.tid_nr_id, arq.arq_tx_nome, arq.arq_tx_descricao, arq.arq_dt_cadastro, arq.arq_tx_situacao, arq.arq_dt_validadeinicio, arq.arq_dt_validadefim,arq.arq_tx_promocional from i9im.arq_arquivo arq where upper(arq_tx_nome) like upper(?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, "%.".concat(extensaoTipo));
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
     * Obtém os arquivos de imagens tratadas do setor especificado pelo usuário
     * @param set_nr_id
     * @return
     * @throws Exception
     */
    public List<Arq_arquivoT> getArquivosTratadosSetor(int set_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select arq.pro_nr_id, arq.arq_nr_id, arq.cla_nr_id,arq.tid_nr_id, arq.arq_tx_nome, arq.arq_tx_descricao, arq.arq_dt_cadastro, arq.arq_tx_situacao, arq.arq_dt_validadeinicio, arq.arq_dt_validadefim,arq.arq_tx_promocional from ses_sessao ses, gru_grupo gru, sug_subgrupo sug, pro_produto pro, i9im.arq_arquivo arq where ses.set_nr_id=? and ses.ses_nr_id=gru.ses_nr_id and sug.ses_nr_id=gru.ses_nr_id and sug.gru_nr_id=gru.gru_nr_id and pro.ses_nr_id=sug.ses_nr_id and pro.gru_nr_id=sug.gru_nr_id and pro.sug_nr_id=sug.sug_nr_id and arq.pro_nr_id=pro.pro_nr_id and cla_nr_id=2";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_nr_id);
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
     * Obtém os arquivos de imagens tratadas do setor especificado pelo usuário
     * @param set_nr_id
     * @return
     * @throws Exception
     */
    public List<Arq_arquivoT> getArquivosTratadosSetorSemImagemWeb(int set_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select arq.pro_nr_id, arq.arq_nr_id, arq.cla_nr_id,arq.tid_nr_id, arq.arq_tx_nome, arq.arq_tx_descricao, arq.arq_dt_cadastro, arq.arq_tx_situacao, arq.arq_dt_validadeinicio, arq.arq_dt_validadefim,arq.arq_tx_promocional from i9im.arq_arquivo arq ,pro_produto pro, ses_sessao ses, gru_grupo gru, sug_subgrupo sug where cla_nr_id<>3 and arq.pro_nr_id=pro.pro_nr_id  and ses.set_nr_id=? and ses.ses_nr_id=gru.ses_nr_id and sug.ses_nr_id=gru.ses_nr_id and sug.gru_nr_id=gru.gru_nr_id and pro.ses_nr_id=sug.ses_nr_id and pro.gru_nr_id=sug.gru_nr_id and pro.sug_nr_id=sug.sug_nr_id  and arq.pro_nr_id>=416120  order by pro.pro_nr_id";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_nr_id);
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

    public List<Arq_arquivoT> getArquivosSetor(int set_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select arq.pro_nr_id, arq.arq_nr_id, arq.cla_nr_id,arq.tid_nr_id, arq.arq_tx_nome, arq.arq_tx_descricao, arq.arq_dt_cadastro, arq.arq_tx_situacao, arq.arq_dt_validadeinicio, arq.arq_dt_validadefim,arq.arq_tx_promocional from ses_sessao ses, gru_grupo gru, sug_subgrupo sug, pro_produto pro, i9im.arq_arquivo arq where ses.set_nr_id=? and ses.ses_nr_id=gru.ses_nr_id and sug.ses_nr_id=gru.ses_nr_id and sug.gru_nr_id=gru.gru_nr_id and pro.ses_nr_id=sug.ses_nr_id and pro.gru_nr_id=sug.gru_nr_id and pro.sug_nr_id=sug.sug_nr_id and arq.pro_nr_id=pro.pro_nr_id ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, set_nr_id);
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
    public List<Arq_arquivoT> getByCla_classificacao(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from i9im.arq_arquivo where cla_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arq_arquivoT.getCla_nr_id());
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
    public List<Arq_arquivoT> getByTid_tipodocumento(Arq_arquivoT arq_arquivoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select pro_nr_id, arq_nr_id, cla_nr_id,tid_nr_id, arq_tx_nome, arq_tx_descricao, arq_dt_cadastro, arq_tx_situacao, arq_dt_validadeinicio, arq_dt_validadefim,arq_tx_promocional from arq_arquivo, tid_tipodocumento tid where tid.tid_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, arq_arquivoT.getTid_nr_id());
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

    /**
     * @return the path_thumb
     */
    public String getPath_thumb() {
        return path_thumb;
    }

    /**
     * @param path_thumb the path_thumb to set
     */
    public void setPath_thumb(String path_thumb) {
        if (path_thumb != null) {
            this.path_thumb = path_thumb;
        }
    }
}
