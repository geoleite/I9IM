package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Use_usuario_setorUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Use_usuario_setorT use_usuario_setorT = new Use_usuario_setorT();

  public void setUse_usuario_setorT(Use_usuario_setorT use_usuario_setorT) {
    this.use_usuario_setorT = use_usuario_setorT;
  }

  public Use_usuario_setorT getUse_usuario_setorT() {	
    return use_usuario_setorT;
  }

	
  private List<Use_usuario_setorT> list;

  public List<Use_usuario_setorT> getList() {
    return list;
  }
  
  public void setList(List<Use_usuario_setorT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultSet_setor();

  }

  public void clear() throws Exception {
    
      use_usuario_setorT = new Use_usuario_setorT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Use_usuario_setorDAO use_usuario_setorDAO = getUse_usuario_setorDAO();
        use_usuario_setorDAO.delete(use_usuario_setorT);	 
        setMsg("Exclusao efetuada com sucesso!");
        clear();
      } else {  
	setMsg(ERROR, "Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      Use_usuario_setorDAO use_usuario_setorDAO = getUse_usuario_setorDAO();
      List<Use_usuario_setorT> listTemp  = use_usuario_setorDAO.getByPK( use_usuario_setorT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
    return false;
	
  }

  public void update() throws Exception {
    try {
      if (exist()) {
        Use_usuario_setorDAO use_usuario_setorDAO = getUse_usuario_setorDAO();
        use_usuario_setorDAO.update(use_usuario_setorT);	 
        setMsg("Alteracao efetuada com sucesso!");	
      } else {  
	setMsg(ERROR,"Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar alteracao!");	
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



  //Method Download Image ? montando se houver algum campo do tipo bin?rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Use_usuario_setorDAO use_usuario_setorDAO = getUse_usuario_setorDAO();
      List<Use_usuario_setorT> listTemp  = use_usuario_setorDAO.getByPK( use_usuario_setorT);	 

      use_usuario_setorT= listTemp.size()>0?listTemp.get(0):new Use_usuario_setorT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a p?gina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "use_usuario_setorConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "use_usuario_setorConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
