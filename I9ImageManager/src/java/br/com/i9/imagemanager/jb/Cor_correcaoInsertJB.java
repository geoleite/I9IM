package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import java.sql.Timestamp;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Cor_correcaoInsertJB extends SystemBase {

    // Atributos e propriedades
    private Cor_correcaoT cor_correcaoT = new Cor_correcaoT();

    public void setCor_correcaoT(Cor_correcaoT cor_correcaoT) {
        this.cor_correcaoT = cor_correcaoT;
    }

    public Cor_correcaoT getCor_correcaoT() {
        return cor_correcaoT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
    }

    private int getSetor() {
        Use_usuario_setorT useT = (Use_usuario_setorT) getSession().getAttribute(PERFIL_SETOR);
        if (useT == null) {
            return -1;
        }
        return useT.getSet_nr_id();
    }
    
    // M?todos de Eventos
    public void insert() throws Exception {

        try {
            Cor_correcaoDAO cor_correcaoDAO = getCor_correcaoDAO();
            cor_correcaoT.setCor_dt_corrigido(new Timestamp(System.currentTimeMillis()));
            int setNrId = getSetor();
            if ( setNrId < 0 ) {
                setMsg(INFO, "Falha: o usuário não está alocado a um setor ou sessão expirada! Efetue o login novamente");
                return;
            }
            cor_correcaoT.setSet_nr_id(setNrId);
            cor_correcaoT.setUsu_nr_id(getUsuarioLogado().getUsu_nr_id());
            cor_correcaoT.setReg_nr_id(1);
            cor_correcaoDAO.insert(cor_correcaoT);
            setMsg(INFO, "Cadastro efetuado com sucesso!");
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar cadastro!");
        } finally {
            close();
        }
    }
// Method de lookup
// 
    private List<Tic_tipo_correcaoT> listtic_tipo_correcao;

    public List<Tic_tipo_correcaoT> getListtic_tipo_correcao() {
        return listtic_tipo_correcao;
    }

    public void setListtic_tipo_correcao(List<Tic_tipo_correcaoT> list) {
        this.listtic_tipo_correcao = list;
    }

    public void consultTic_tipo_correcao() throws Exception {
        try {
            Tic_tipo_correcaoDAO tic_tipo_correcaoDAO = getTic_tipo_correcaoDAO();
            listtic_tipo_correcao = tic_tipo_correcaoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    private List<Use_usuario_setorT> listuse_usuario_setor;

    public List<Use_usuario_setorT> getListuse_usuario_setor() {
        return listuse_usuario_setor;
    }

    public void setListuse_usuario_setor(List<Use_usuario_setorT> list) {
        this.listuse_usuario_setor = list;
    }

    public void consultUse_usuario_setor() throws Exception {
        try {
            Use_usuario_setorDAO use_usuario_setorDAO = getUse_usuario_setorDAO();
            listuse_usuario_setor = use_usuario_setorDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    private List<Reg_regiaoT> listreg_regiao;

    public List<Reg_regiaoT> getListreg_regiao() {
        return listreg_regiao;
    }

    public void setListreg_regiao(List<Reg_regiaoT> list) {
        this.listreg_regiao = list;
    }

    public void consultReg_regiao() throws Exception {
        try {
            Reg_regiaoDAO reg_regiaoDAO = getReg_regiaoDAO();
            listreg_regiao = reg_regiaoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    private List<Pag_paginaT> listpag_pagina;

    public List<Pag_paginaT> getListpag_pagina() {
        return listpag_pagina;
    }

    public void setListpag_pagina(List<Pag_paginaT> list) {
        this.listpag_pagina = list;
    }

    public void consultPag_pagina() throws Exception {
        try {
            Pag_paginaDAO pag_paginaDAO = getPag_paginaDAO();
            listpag_pagina = pag_paginaDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void clear() throws Exception {

        cor_correcaoT = new Cor_correcaoT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "cor_correcaoConsult.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
