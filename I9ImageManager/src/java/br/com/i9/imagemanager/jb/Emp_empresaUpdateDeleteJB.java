package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Emp_empresaUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Emp_empresaT emp_empresaT = new Emp_empresaT();

  public void setEmp_empresaT(Emp_empresaT emp_empresaT) {
    this.emp_empresaT = emp_empresaT;
  }

  public Emp_empresaT getEmp_empresaT() {	
    return emp_empresaT;
  }

	
  private List<Emp_empresaT> list;

  public List<Emp_empresaT> getList() {
    return list;
  }
  
  public void setList(List<Emp_empresaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      emp_empresaT = new Emp_empresaT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
        emp_empresaDAO.delete(emp_empresaT);	 
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
      Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
      List<Emp_empresaT> listTemp  = emp_empresaDAO.getByPK( emp_empresaT);	 

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
        Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
        emp_empresaDAO.update(emp_empresaT);	 
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


  //Method Download Image e montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
      List<Emp_empresaT> listTemp  = emp_empresaDAO.getByPK( emp_empresaT);	 

      emp_empresaT= listTemp.size()>0?listTemp.get(0):new Emp_empresaT();
      
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
	  String page = "emp_empresaConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "emp_empresaConsult.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
