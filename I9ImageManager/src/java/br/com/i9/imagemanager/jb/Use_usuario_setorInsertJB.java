package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Use_usuario_setorInsertJB extends SystemBase {

  // Atributos e propriedades
    private Use_usuario_setorT use_usuario_setorT = new Use_usuario_setorT();

  public void setUse_usuario_setorT(Use_usuario_setorT use_usuario_setorT) {
    this.use_usuario_setorT = use_usuario_setorT;
  }

  public Use_usuario_setorT getUse_usuario_setorT() {	
    return use_usuario_setorT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultSet_setor();

  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Use_usuario_setorDAO use_usuario_setorDAO =  getUse_usuario_setorDAO();
      use_usuario_setorDAO.insert(use_usuario_setorT);	 
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
    
      use_usuario_setorT = new Use_usuario_setorT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "use_usuario_setorConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
