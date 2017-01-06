package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Emp_empresaConsultJB extends SystemBase {

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
        consult();
  }

  public void consult() throws Exception {
    try {
      Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
      list = emp_empresaDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
      emp_empresaDAO.delete(emp_empresaT);	 
      setMsg("Exclusao efetuada com sucesso!");
      emp_empresaT = new Emp_empresaT();
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  }  

 public void insert() throws Exception {
	// TODO Insert
	try {
	  String page = "emp_empresaInsert.jsp";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a pagina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

}
