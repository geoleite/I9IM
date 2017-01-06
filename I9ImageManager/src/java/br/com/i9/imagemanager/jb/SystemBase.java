package br.com.i9.imagemanager.jb;

import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import java.util.List;
import br.com.easynet.easyportal.jb.EasySecurityJB;
import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.easyportal.transfer.Par_parametroT;
import br.com.i9.imagemanager.util.ThreadInativarImagensPromocionais;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.sql.DataSource;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;

public class SystemBase extends EasySecurityJB implements INotSecurity {

    public static final String PATH_ARQUIVO = "path_arquivo";
    public static final String PATH_ARQUIVO_THUMB = "path_arquivo_thumb";
    public static final String NOME_SISTEMA = "I9IM";
    public final static String SETOR = "setor_session";
    public static final String PASTA_BASE = "/tmp/";
    public static final int CODIGO_BRUTA = 1;
    public static final int CODIGO_TRATADA = 2;
    public static final int CODIGO_WEB = 3;
    public static final String ARQUIVO_UPLOAD_MULTIPLO = "arquivo multiplos upload";
    public static int typeDatabase = DAOFactory.POSTGRESQL;
    public final static String PERFIL_SETOR = "perfil_setor";

    /* *
    public static String url = "jdbc:postgresql://200.199.117.82:5432/i9imagemanager";
    public static String user = "i9im";
    public static String pass = "i9im@)!)";

    /* */
    public static String url = "jdbc:postgresql://127.0.0.1:5432/i9imagemanager";
    public static String user = "i9im";
    public static String pass = "i9im@)!)";
    /* *
    public static String url = "jdbc:postgresql://127.0.0.1:5432/i9imagemanager";
    public static String user = "postgres";
    public static String pass = "postgres";

    /* *
    public static String url = "jdbc:postgresql://banco.nfeinbox.com.br:5432/i9im";
    public static String user = "geoleite";
    public static String pass = "eusoumuitobom";
    /* */
    private DAOFactory dao;
    private String datasourceName = "java:comp/env/jdbc/i9imds";
    private static ThreadInativarImagensPromocionais tiip;
    private static String sinal = "converter_thumb";

    public String getExecute() throws Exception {
        if (tiip == null) {
            tiip = new ThreadInativarImagensPromocionais();
            tiip.start();
        }
        return super.getExecute();
    }

    public String getParametro(String nomeParam) throws Exception {
//        Par_parametroT parT = super.getParametro(NOME_SISTEMA, nomeParam);
//        return parT == null ? null : parT.getPar_tx_valor();
        return null;
    }

    /**
     * COnfigura o tipo bytea para o postgresql da versao 9.0
     */
    private void configureByteaPostgresql() {
        PreparedStatement ps = null;
        try {
            dao.create();
            ps = dao.getConnection().prepareStatement("SET bytea_output = 'escape'");
            ps.execute();
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (Exception e) {
            }
        }
    }

    public Set_setorNewT verificaSetorEPai(Set_setorNewT setT) throws Exception {
        if (setT != null) {
            if (setT.getSet_nr_idsetorpai() == 0) {
                return setT;
            } else {
                try {
                    Set_setorNewT setTTemp = new Set_setorNewT();
                    setTTemp.setSet_nr_id(setT.getSet_nr_idsetorpai());
                    List<Set_setorNewT> listSet = getSet_setorNewDAO().getBySet_nr_id(setTTemp);
                    if (listSet.size() > 0) {
                        return verificaSetorEPai(listSet.get(0));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                } finally {
                    close();
                }
            }
        }
        return null;
    }

    public String getTodosSetoresFilhos(Set_setorNewT setT) throws Exception {
        StringBuffer sql = new StringBuffer();
        sql.append(setT.getSet_nr_id());
        List<Set_setorNewT> list = getSet_setorNewDAO().getAllFilhos(setT);
        for (int i = 0; i < list.size(); i++) {
            Set_setorNewT set_setorT = list.get(i);
            sql.append(",").append(getTodosSetoresFilhos(set_setorT));
        }
        return sql.toString();
    }

    public DAOFactory getDAO() throws Exception {
        if (dao != null) {
            return dao;
        }

        //dao = getDAO(typeDatabase, url, user, pass);
        DataSource ds = getDataSource(datasourceName);
        dao = DAOFactory.getDAOFactory(typeDatabase, ds.getConnection());
        configureByteaPostgresql();
        return dao;
    }

    public DAOFactory getDAO(int typeDatabase, String url, String user, String pass) throws Exception {
        if (dao != null) {
            return dao;
        }
        dao = DAOFactory.getDAOFactory(typeDatabase, url, user, pass);
        configureByteaPostgresql();
        return dao;
    }

    public void close() {
        try {
            dao.close();
            dao = null;
        } catch (Exception e) {
        }
//        try {
//            closeDatasourceEasyPortal();
//        } catch (Exception e) {
//        }
    }

    /**
     * Extrai a extansao do arquivo
     * @param arquivo
     * @return
     */
    private String getExtensaoArquivo(String arquivo) {
        arquivo = arquivo.replaceAll("\\(", "").replaceAll("\\)", "");
        StringTokenizer stk = new StringTokenizer(arquivo, ".");
        String extensao = "sem_extenao";
        while (stk.hasMoreTokens()) {
            extensao = stk.nextToken();
        }
        return extensao;
    }

    /**
     * obtem o tipo do arquivo pela extensao
     * @param arquivo
     * @return
     */
    public Tid_tipodocumentoT getTipoDocumento(String arquivo) throws Exception {
        Tid_tipodocumentoT tid_tipodocumentoT = new Tid_tipodocumentoT();
        if (arquivo != null) {
            String extensao = getExtensaoArquivo(arquivo);
            tid_tipodocumentoT.setTid_tx_sigla(extensao.toLowerCase());
            List<Tid_tipodocumentoT> listTid = getTid_tipodocumentoDAO().getByTid_tx_sigla(tid_tipodocumentoT);
            if (listTid.size() == 0) {
                tid_tipodocumentoT.setTid_tx_descricao(tid_tipodocumentoT.getTid_tx_sigla());
                tid_tipodocumentoT.setTid_tx_reduzir("N");
                getTid_tipodocumentoDAO().insert(tid_tipodocumentoT);
                listTid = getTid_tipodocumentoDAO().getByTid_tx_sigla(tid_tipodocumentoT);
            }
            tid_tipodocumentoT = listTid.get(0);
        }
        return tid_tipodocumentoT;
    }

    public byte[] imageToBytes(BufferedImage bi) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, "PNG", baos);
        return baos.toByteArray();
    }

    public BufferedImage bytesToImageJPEG(byte[] img) throws Exception {
        //File f = new File("/home/geoleite/Download/431735_fogao 5 bocas atlas atenas automatico branco copy.jpg");
        Iterator<ImageReader> iter = ImageIO.getImageReadersByFormatName("JPEG");
        ImageReader reader = null;
        while (iter.hasNext()) {
            reader = (ImageReader) iter.next();
            if (reader.canReadRaster()) {
                break;
            }
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(img);
        ImageInputStream iis = ImageIO.createImageInputStream(bais);
        reader.setInput(iis);
        Raster raster = reader.readRaster(0, null);
        BufferedImage bi = new BufferedImage(raster.getWidth(), raster.getHeight(),
                BufferedImage.TYPE_INT_ARGB);

        //Fill the new image with the old raster
        bi.getRaster().setRect(raster);
        //ImageIO.write(bi, "JPG", new File("/home/geoleite/Download/fogoes2.jpg"));
        return bi;
    }

    /**
     * Converte a image jpg em png e reduz o tamanho de acordo com o thumb
     * @param thumb
     * @param img
     * @return
     * @throws Exception
     */
    public BufferedImage bytesToImagePNG(String thumb, Arq_arquivoT arqT) throws Exception {
        BufferedImage bi = null;
        File filePng = null;
        File fileJpg = null;
        try {
            long idImg = System.currentTimeMillis();
            String path = PASTA_BASE.concat(String.valueOf(idImg));
            ConvertCmd cmd = new ConvertCmd();

// create the operation, add images and operators/options
            IMOperation op = new IMOperation();
            String pathJpg = path.concat(arqT.getArq_tx_nome());
            fileJpg = new File(pathJpg);
            FileOutputStream fos = new FileOutputStream(fileJpg);
            fos.write(arqT.getArq_bt_arquivo());
            fos.flush();
            fos.close();
            op.addImage(pathJpg);
            if ("S".equals(thumb)) {
                op.resize(120, 100);
            } else if ("I".equals(thumb)) {
                op.resize(30, 25);
            } else {
                op.resize(320, 240);
            }
            String pathPng = path.concat(".png");
            op.addImage(pathPng);
// execute the operation
            cmd.run(op);
            filePng = new File(pathPng);
            bi = ImageIO.read(filePng);

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                fileJpg.delete();
                filePng.delete();
            } catch (Exception e) {
            }
        }
        return bi;
    }

    /**
     * Converte a imagem na hora do cadastro e cria um thumbnail
     * @param arqT
     * @throws Exception
     */
    public void bytesToImagePNGThumb(Arq_arquivoT arqT) throws Exception {
        BufferedImage bi = null;
        File filePng = null;
        File fileJpg = null;
        try {
            synchronized (sinal) {
                long idImg = System.currentTimeMillis();
                String path = PASTA_BASE.concat(String.valueOf(idImg));
                ConvertCmd cmd = new ConvertCmd();
                //bi = bytesToImage(arqT.getArq_bt_arquivo());
// create the operation, add images and operators/options
                IMOperation op = new IMOperation();
                String pathJpg = path.concat(idImg + ".jpg");
                fileJpg = new File(pathJpg);
                FileOutputStream fos = new FileOutputStream(fileJpg);
                fos.write(arqT.getArq_bt_arquivo());
                fos.flush();
                fos.close();
                op.addImage(pathJpg);
                //op.resize(bi.getWidth(), bi.getHeight());
                op.resize(120, 100);
                String pathPng = path.concat(".png");
                op.addImage(pathPng);
// execute the operation
                cmd.run(op);
                filePng = new File(pathPng);
                bi = ImageIO.read(filePng);

                arqT.setArq_bt_thumb(imageToBytes(bi));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                fileJpg.delete();
                filePng.delete();
            } catch (Exception e) {
            }
        }
    }

    public BufferedImage bytesToImage(byte[] img) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(img);
        BufferedImage bi = ImageIO.read(bais);
        return bi;
    }

    /**
     * Cria a imagen em miniatura
     * @param image
     * @return
     */
    public BufferedImage createScaledImage(BufferedImage image, int width, int heigth) {
        int cachedWidth = width;
        int cachedHeight = heigth;

        BufferedImage scaledImage;
        scaledImage = new BufferedImage(cachedWidth, cachedHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = scaledImage.createGraphics();
        g.drawImage(image, 0, 0, cachedWidth, cachedHeight, null);
        return scaledImage;
    }

    public Arq_arquivoDAO getArq_arquivoDAO() throws Exception {
        dao = getDAO();
        return new Arq_arquivoDAO(dao);
    }

    public Cla_classificacaoDAO getCla_classificacaoDAO() throws Exception {
        dao = getDAO();
        return new Cla_classificacaoDAO(dao);
    }

    public Eve_eventoDAO getEve_eventoDAO() throws Exception {
        dao = getDAO();
        return new Eve_eventoDAO(dao);
    }

    public Gru_grupoDAO getGru_grupoDAO() throws Exception {
        dao = getDAO();
        return new Gru_grupoDAO(dao);
    }

    public Imt_imagemthumbDAO getImt_imagemthumbDAO() throws Exception {
        dao = getDAO();
        return new Imt_imagemthumbDAO(dao);
    }

    public Obe_observacaoexclusaoDAO getObe_observacaoexclusaoDAO() throws Exception {
        dao = getDAO();
        return new Obe_observacaoexclusaoDAO(dao);
    }

    public Pro_eveDAO getPro_eveDAO() throws Exception {
        dao = getDAO();
        return new Pro_eveDAO(dao);
    }

    public Pro_produtoDAO getPro_produtoDAO() throws Exception {
        dao = getDAO();
        return new Pro_produtoDAO(dao);
    }

    public Ses_sessaoDAO getSes_sessaoDAO() throws Exception {
        dao = getDAO();
        return new Ses_sessaoDAO(dao);
    }

    public Set_setorDAO getSet_setorDAO() throws Exception {
        dao = getDAO();
        return new Set_setorDAO(dao);
    }

    public Set_setorNewDAO getSet_setorNewDAO() throws Exception {
        dao = getDAO();
        return new Set_setorNewDAO(dao);
    }

    public Sug_subgrupoDAO getSug_subgrupoDAO() throws Exception {
        dao = getDAO();
        return new Sug_subgrupoDAO(dao);
    }

    public Tid_tipodocumentoDAO getTid_tipodocumentoDAO() throws Exception {
        dao = getDAO();
        return new Tid_tipodocumentoDAO(dao);
    }

    public Arq_arquivoT findbyIdArq_arquivo(Arq_arquivoT arq_arquivoT) throws Exception {
        try {
            Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();

            List<Arq_arquivoT> listTemp = arq_arquivoDAO.getByPK(arq_arquivoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Cla_classificacaoT findbyIdCla_classificacao(Cla_classificacaoT cla_classificacaoT) throws Exception {
        try {
            Cla_classificacaoDAO cla_classificacaoDAO = getCla_classificacaoDAO();

            List<Cla_classificacaoT> listTemp = cla_classificacaoDAO.getByPK(cla_classificacaoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Eve_eventoT findbyIdEve_evento(Eve_eventoT eve_eventoT) throws Exception {
        try {
            Eve_eventoDAO eve_eventoDAO = getEve_eventoDAO();
            List<Eve_eventoT> listTemp = eve_eventoDAO.getByPK(eve_eventoT);
            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Gru_grupoT findbyIdGru_grupo(Gru_grupoT gru_grupoT) throws Exception {
        try {
            Gru_grupoDAO gru_grupoDAO = getGru_grupoDAO();

            List<Gru_grupoT> listTemp = gru_grupoDAO.getByPK(gru_grupoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Imt_imagemthumbT findbyIdImt_imagemthumb(Imt_imagemthumbT imt_imagemthumbT) throws Exception {
        try {
            Imt_imagemthumbDAO imt_imagemthumbDAO = getImt_imagemthumbDAO();

            List<Imt_imagemthumbT> listTemp = imt_imagemthumbDAO.getByPK(imt_imagemthumbT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Obe_observacaoexclusaoT findbyIdObe_observacaoexclusao(Obe_observacaoexclusaoT obe_observacaoexclusaoT) throws Exception {
        try {
            Obe_observacaoexclusaoDAO obe_observacaoexclusaoDAO = getObe_observacaoexclusaoDAO();

            List<Obe_observacaoexclusaoT> listTemp = obe_observacaoexclusaoDAO.getByPK(obe_observacaoexclusaoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Pro_eveT findbyIdPro_eve(Pro_eveT pro_eveT) throws Exception {
        try {
            Pro_eveDAO pro_eveDAO = getPro_eveDAO();

            List<Pro_eveT> listTemp = pro_eveDAO.getByPK(pro_eveT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Pro_produtoT findbyIdPro_produto(Pro_produtoT pro_produtoT) throws Exception {
        try {
            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();

            List<Pro_produtoT> listTemp = pro_produtoDAO.getByPK(pro_produtoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Ses_sessaoT findbyIdSes_sessao(Ses_sessaoT ses_sessaoT) throws Exception {
        try {
            Ses_sessaoDAO ses_sessaoDAO = getSes_sessaoDAO();

            List<Ses_sessaoT> listTemp = ses_sessaoDAO.getByPK(ses_sessaoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Set_setorT findbyIdSet_setor(Set_setorT set_setorT) throws Exception {
        try {
            Set_setorDAO set_setorDAO = getSet_setorDAO();

            List<Set_setorT> listTemp = set_setorDAO.getByPK(set_setorT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Sug_subgrupoT findbyIdSug_subgrupo(Sug_subgrupoT sug_subgrupoT) throws Exception {
        try {
            Sug_subgrupoDAO sug_subgrupoDAO = getSug_subgrupoDAO();

            List<Sug_subgrupoT> listTemp = sug_subgrupoDAO.getByPK(sug_subgrupoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Tid_tipodocumentoT findbyIdTid_tipodocumento(Tid_tipodocumentoT tid_tipodocumentoT) throws Exception {
        try {
            Tid_tipodocumentoDAO tid_tipodocumentoDAO = getTid_tipodocumentoDAO();

            List<Tid_tipodocumentoT> listTemp = tid_tipodocumentoDAO.getByPK(tid_tipodocumentoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Ond_ondaDAO getOnd_ondaDAO() throws Exception {
        dao = getDAO();
        return new Ond_ondaDAO(dao);
    }

    public Cls_classificacao_seloDAO getCls_classificacao_seloDAO() throws Exception {
        dao = getDAO();
        return new Cls_classificacao_seloDAO(dao);
    }

    public Pro_selDAO getPro_selDAO() throws Exception {
        dao = getDAO();
        return new Pro_selDAO(dao);
    }

    public Sel_seloDAO getSel_seloDAO() throws Exception {
        dao = getDAO();
        return new Sel_seloDAO(dao);
    }

    public Cls_classificacao_seloT findbyIdCls_classificacao_selo(Cls_classificacao_seloT cls_classificacao_seloT) throws Exception {
        try {
            Cls_classificacao_seloDAO cls_classificacao_seloDAO = getCls_classificacao_seloDAO();

            List<Cls_classificacao_seloT> listTemp = cls_classificacao_seloDAO.getByPK(cls_classificacao_seloT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Pro_selT findbyIdPro_sel(Pro_selT pro_selT) throws Exception {
        try {
            Pro_selDAO pro_selDAO = getPro_selDAO();

            List<Pro_selT> listTemp = pro_selDAO.getByPK(pro_selT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Sel_seloT findbyIdSel_selo(Sel_seloT sel_seloT) throws Exception {
        try {
            Sel_seloDAO sel_seloDAO = getSel_seloDAO();

            List<Sel_seloT> listTemp = sel_seloDAO.getByPK(sel_seloT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public String getNomeArquivo(String path) {
        StringTokenizer stk = new StringTokenizer(path, "\\");
        String nomeArquivo = "";
        while (stk.hasMoreTokens()) {
            nomeArquivo = stk.nextToken();
        }
        return nomeArquivo;
    }

    public Enc_encarteDAO getEnc_encarteDAO() throws Exception {
        dao = getDAO();
        return new Enc_encarteDAO(dao);
    }

    public Enc_encarteT findbyIdEnc_encarte(Enc_encarteT enc_encarteT) throws Exception {
        try {
            Enc_encarteDAO enc_encarteDAO = getEnc_encarteDAO();

            List<Enc_encarteT> listTemp = enc_encarteDAO.getByPK(enc_encarteT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Reg_regiaoDAO getReg_regiaoDAO() throws Exception {
        dao = getDAO();
        return new Reg_regiaoDAO(dao);
    }

    public Reg_regiaoT findbyIdReg_regiao(Reg_regiaoT reg_regiaoT) throws Exception {
        try {
            Reg_regiaoDAO reg_regiaoDAO = getReg_regiaoDAO();

            List<Reg_regiaoT> listTemp = reg_regiaoDAO.getByPK(reg_regiaoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Tic_tipo_correcaoDAO getTic_tipo_correcaoDAO() throws Exception {
        dao = getDAO();
        return new Tic_tipo_correcaoDAO(dao);
    }

    public Tic_tipo_correcaoT findbyIdTic_tipo_correcao(Tic_tipo_correcaoT tic_tipo_correcaoT) throws Exception {
        try {
            Tic_tipo_correcaoDAO tic_tipo_correcaoDAO = getTic_tipo_correcaoDAO();

            List<Tic_tipo_correcaoT> listTemp = tic_tipo_correcaoDAO.getByPK(tic_tipo_correcaoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Pag_paginaDAO getPag_paginaDAO() throws Exception {
        dao = getDAO();
        return new Pag_paginaDAO(dao);
    }

    public Pag_paginaT findbyIdPag_pagina(Pag_paginaT pag_paginaT) throws Exception {
        try {
            Pag_paginaDAO pag_paginaDAO = getPag_paginaDAO();

            List<Pag_paginaT> listTemp = pag_paginaDAO.getByPK(pag_paginaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Cor_correcaoDAO getCor_correcaoDAO() throws Exception {
        dao = getDAO();
        return new Cor_correcaoDAO(dao);
    }

    public Use_usuario_setorDAO getUse_usuario_setorDAO() throws Exception {
        dao = getDAO();
        return new Use_usuario_setorDAO(dao);
    }

    public Cor_correcaoT findbyIdCor_correcao(Cor_correcaoT cor_correcaoT) throws Exception {
        try {
            Cor_correcaoDAO cor_correcaoDAO = getCor_correcaoDAO();

            List<Cor_correcaoT> listTemp = cor_correcaoDAO.getByPK(cor_correcaoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Use_usuario_setorT findbyIdUse_usuario_setor(Use_usuario_setorT use_usuario_setorT) throws Exception {
        try {
            Use_usuario_setorDAO use_usuario_setorDAO = getUse_usuario_setorDAO();

            List<Use_usuario_setorT> listTemp = use_usuario_setorDAO.getByPK(use_usuario_setorT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Emp_empresaDAO getEmp_empresaDAO() throws Exception {
        dao = getDAO();
        return new Emp_empresaDAO(dao);
    }

    public Emp_empresaT findbyIdEmp_empresa(Emp_empresaT emp_empresaT) throws Exception {
        try {
            Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();

            List<Emp_empresaT> listTemp = emp_empresaDAO.getByPK(emp_empresaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }
}
