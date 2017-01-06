package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Emp_empresaInsertJB extends SystemBase {

  // Atributos e propriedades
    private Emp_empresaT emp_empresaT = new Emp_empresaT();

  public void setEmp_empresaT(Emp_empresaT emp_empresaT) {
    this.emp_empresaT = emp_empresaT;
  }

  public Emp_empresaT getEmp_empresaT() {	
    return emp_empresaT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Emp_empresaDAO emp_empresaDAO =  getEmp_empresaDAO();
      emp_empresaDAO.insert(emp_empresaT);	 
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

  
  public void clear() throws Exception {
    
      emp_empresaT = new Emp_empresaT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "emp_empresaConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
