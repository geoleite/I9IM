package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Sug_subgrupoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Sug_subgrupoT sug_subgrupoT = new Sug_subgrupoT();

  public void setSug_subgrupoT(Sug_subgrupoT sug_subgrupoT) {
    this.sug_subgrupoT = sug_subgrupoT;
  }

  public Sug_subgrupoT getSug_subgrupoT() {	
    return sug_subgrupoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultGru_grupo();

		consultSet_setor();

  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Sug_subgrupoDAO sug_subgrupoDAO =  getSug_subgrupoDAO();
      sug_subgrupoDAO.insert(sug_subgrupoT);	 
      setMsg(INFO,"Cadastro efetuado com sucesso!");
      clear();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar cadastro!");	
    } finally {
	close();
    }
  } 

// Method de lookup
// 
	private List<Gru_grupoT> listgru_grupo;
	public List<Gru_grupoT> getListgru_grupo() {
		return listgru_grupo;
	}

	 public void setListgru_grupo(List<Gru_grupoT> list) {
		this.listgru_grupo=list;
	}
	public void consultGru_grupo() throws Exception {
		try {
			Gru_grupoDAO gru_grupoDAO = getGru_grupoDAO();
			listgru_grupo=gru_grupoDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	private List<Set_setorT> listset_setor;
	public List<Set_setorT> getListset_setor() {
		return listset_setor;
	}

	 public void setListset_setor(List<Set_setorT> list) {
		this.listset_setor=list;
	}
	public void consultSet_setor() throws Exception {
		try {
			Set_setorDAO set_setorDAO = getSet_setorDAO();
			listset_setor=set_setorDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}


  
  public void clear() throws Exception {
    
      sug_subgrupoT = new Sug_subgrupoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "sug_subgrupoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
