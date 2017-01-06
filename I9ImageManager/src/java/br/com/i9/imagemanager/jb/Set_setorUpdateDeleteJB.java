package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Set_setorUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Set_setorT set_setorT = new Set_setorT();

  public void setSet_setorT(Set_setorT set_setorT) {
    this.set_setorT = set_setorT;
  }

  public Set_setorT getSet_setorT() {	
    return set_setorT;
  }

	
  private List<Set_setorT> list;

  public List<Set_setorT> getList() {
    return list;
  }
  
  public void setList(List<Set_setorT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      set_setorT = new Set_setorT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Set_setorDAO set_setorDAO = getSet_setorDAO();
        set_setorDAO.delete(set_setorT);	 
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
      Set_setorDAO set_setorDAO = getSet_setorDAO();
      List<Set_setorT> listTemp  = set_setorDAO.getByPK( set_setorT);	 

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
        Set_setorDAO set_setorDAO = getSet_setorDAO();
        set_setorDAO.update(set_setorT);	 
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


  //Method Download Image ? montando se houver algum campo do tipo bin?rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Set_setorDAO set_setorDAO = getSet_setorDAO();
      List<Set_setorT> listTemp  = set_setorDAO.getByPK( set_setorT);	 

      set_setorT= listTemp.size()>0?listTemp.get(0):new Set_setorT();
      
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
	  String page = "set_setorConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "set_setorConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
