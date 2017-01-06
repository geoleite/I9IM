package br.com.i9.imagemanager.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Emp_empresaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Emp_empresaT emp_empresaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Emp_empresaDAO emp_empresaDAO =  getEmp_empresaDAO();
      emp_empresaDAO.insert(emp_empresaT);	 
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  } 

  /**
   * Consulta todos os registros da tabela
   */	
  public List<Emp_empresaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
      return emp_empresaDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }

  }  

  /**
   * Deletar um registro
   */	
  public boolean delete(Emp_empresaT emp_empresaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(emp_empresaT)) {
        Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
        emp_empresaDAO.delete(emp_empresaT);	 
        return true;
      } else {  
	return false;
      } 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  } 

  /**
   * Verifica se o objeto existe na base
   */
  public boolean exist(Emp_empresaT emp_empresaT) throws Exception {
   try {
	
      Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
      List<Emp_empresaT> listTemp  = emp_empresaDAO.getByPK(emp_empresaT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
	
  }

  /**
   * Realiza uma alterac?o na tabela
   */	
  public boolean update(Emp_empresaT emp_empresaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(emp_empresaT)) {
        Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
        emp_empresaDAO.update(emp_empresaT);	 
	return true;        
      } else {  
	return false;
      } 
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }   

  /**
   * Obt?m os dados de um registro
   */	
  public Emp_empresaT findbyid(Emp_empresaT emp_empresaT) throws Exception {
    try {
      Emp_empresaDAO emp_empresaDAO = getEmp_empresaDAO();
      List<Emp_empresaT> listTemp  = emp_empresaDAO.getByPK( emp_empresaT);	 

      return listTemp.size()>0?listTemp.get(0):new Emp_empresaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
