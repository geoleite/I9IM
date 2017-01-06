package br.com.i9.imagemanager.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Reg_regiaoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Reg_regiaoT reg_regiaoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Reg_regiaoDAO reg_regiaoDAO =  getReg_regiaoDAO();
      reg_regiaoDAO.insert(reg_regiaoT);	 
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
  public List<Reg_regiaoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Reg_regiaoDAO reg_regiaoDAO = getReg_regiaoDAO();
      return reg_regiaoDAO.getAll();	 
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
  public boolean delete(Reg_regiaoT reg_regiaoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(reg_regiaoT)) {
        Reg_regiaoDAO reg_regiaoDAO = getReg_regiaoDAO();
        reg_regiaoDAO.delete(reg_regiaoT);	 
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
  public boolean exist(Reg_regiaoT reg_regiaoT) throws Exception {
   try {
	
      Reg_regiaoDAO reg_regiaoDAO = getReg_regiaoDAO();
      List<Reg_regiaoT> listTemp  = reg_regiaoDAO.getByPK(reg_regiaoT);	 

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
  public boolean update(Reg_regiaoT reg_regiaoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(reg_regiaoT)) {
        Reg_regiaoDAO reg_regiaoDAO = getReg_regiaoDAO();
        reg_regiaoDAO.update(reg_regiaoT);	 
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
  public Reg_regiaoT findbyid(Reg_regiaoT reg_regiaoT) throws Exception {
    try {
      Reg_regiaoDAO reg_regiaoDAO = getReg_regiaoDAO();
      List<Reg_regiaoT> listTemp  = reg_regiaoDAO.getByPK( reg_regiaoT);	 

      return listTemp.size()>0?listTemp.get(0):new Reg_regiaoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
