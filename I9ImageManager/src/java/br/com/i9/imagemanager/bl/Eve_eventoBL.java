package br.com.i9.imagemanager.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Eve_eventoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Eve_eventoT eve_eventoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Eve_eventoDAO eve_eventoDAO =  getEve_eventoDAO();
      eve_eventoDAO.insert(eve_eventoT);	 
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
  public List<Eve_eventoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Eve_eventoDAO eve_eventoDAO = getEve_eventoDAO();
      return eve_eventoDAO.getAll();	 
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
  public boolean delete(Eve_eventoT eve_eventoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(eve_eventoT)) {
        Eve_eventoDAO eve_eventoDAO = getEve_eventoDAO();
        eve_eventoDAO.delete(eve_eventoT);	 
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
  public boolean exist(Eve_eventoT eve_eventoT) throws Exception {
   try {
	
      Eve_eventoDAO eve_eventoDAO = getEve_eventoDAO();
      List<Eve_eventoT> listTemp  = eve_eventoDAO.getByPK(eve_eventoT);	 

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
  public boolean update(Eve_eventoT eve_eventoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(eve_eventoT)) {
        Eve_eventoDAO eve_eventoDAO = getEve_eventoDAO();
        eve_eventoDAO.update(eve_eventoT);	 
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
  public Eve_eventoT findbyid(Eve_eventoT eve_eventoT) throws Exception {
    try {
      Eve_eventoDAO eve_eventoDAO = getEve_eventoDAO();
      List<Eve_eventoT> listTemp  = eve_eventoDAO.getByPK( eve_eventoT);	 

      return listTemp.size()>0?listTemp.get(0):new Eve_eventoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
