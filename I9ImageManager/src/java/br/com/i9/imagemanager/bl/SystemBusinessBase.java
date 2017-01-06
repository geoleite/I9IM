package br.com.i9.imagemanager.bl;

import br.com.easynet.bl.BusinessBase;
import br.com.jdragon.dao.*;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import java.util.List;
import javax.sql.DataSource;

public class SystemBusinessBase extends BusinessBase {

    private int typeDatabase = DAOFactory.POSTGRESQL;
    private String url = "jdbc:postgresql://127.0.0.1:5432/i9imagemanager";
    private String user = "postgres";
    private String pass = "postgres";
    private DAOFactory dao;
    private String datasourceName = "java:comp/env/jdbc/NOME_CONEXAO";

    public DAOFactory getDAO() throws Exception {
        if (dao != null) {
            return dao;
        }
        return getDAO(typeDatabase, url, user, pass);
    }

    public DAOFactory getDAODataSource() throws Exception {

        DataSource ds = getDataSource(datasourceName);
        return DAOFactory.getDAOFactory(typeDatabase, ds.getConnection());
    }

    public DAOFactory getDAO(int typeDatabase, String url, String user, String pass) throws Exception {
        if (dao != null) {
            return dao;
        }
        return DAOFactory.getDAOFactory(typeDatabase, url, user, pass);
    }

    public void close() {
        try {
            dao.close();
            dao = null;
        } catch (Exception e) {
        }
    }

    /**
     * M�todo para validar a seguranca
     */
    public boolean valide(String metodo) throws Exception {
        // Logica da seguranca
        return true;
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

    public Sug_subgrupoDAO getSug_subgrupoDAO() throws Exception {
        dao = getDAO();
        return new Sug_subgrupoDAO(dao);
    }

    public Tid_tipodocumentoDAO getTid_tipodocumentoDAO() throws Exception {
        dao = getDAO();
        return new Tid_tipodocumentoDAO(dao);
    }

    public Ond_ondaDAO getOnd_ondaDAO() throws Exception {
        dao = getDAO();
        return new Ond_ondaDAO(dao);
    }

    public Ond_ondaT findbyIdOnd_onda(Ond_ondaT ond_ondaT) throws Exception {
        try {
            Ond_ondaDAO ond_ondaDAO = getOnd_ondaDAO();

            List<Ond_ondaT> listTemp = ond_ondaDAO.getByPK(ond_ondaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
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
