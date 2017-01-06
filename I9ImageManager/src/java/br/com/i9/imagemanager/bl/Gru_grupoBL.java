package br.com.i9.imagemanager.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Gru_grupoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Gru_grupoT gru_grupoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Gru_grupoDAO gru_grupoDAO =  getGru_grupoDAO();
      gru_grupoDAO.insert(gru_grupoT);	 
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
  public List<Gru_grupoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Gru_grupoDAO gru_grupoDAO = getGru_grupoDAO();
      return gru_grupoDAO.getAll();	 
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
  public boolean delete(Gru_grupoT gru_grupoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(gru_grupoT)) {
        Gru_grupoDAO gru_grupoDAO = getGru_grupoDAO();
        gru_grupoDAO.delete(gru_grupoT);	 
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
  public boolean exist(Gru_grupoT gru_grupoT) throws Exception {
   try {
	
      Gru_grupoDAO gru_grupoDAO = getGru_grupoDAO();
      List<Gru_grupoT> listTemp  = gru_grupoDAO.getByPK(gru_grupoT);	 

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
  public boolean update(Gru_grupoT gru_grupoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(gru_grupoT)) {
        Gru_grupoDAO gru_grupoDAO = getGru_grupoDAO();
        gru_grupoDAO.update(gru_grupoT);	 
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
  public Gru_grupoT findbyid(Gru_grupoT gru_grupoT) throws Exception {
    try {
      Gru_grupoDAO gru_grupoDAO = getGru_grupoDAO();
      List<Gru_grupoT> listTemp  = gru_grupoDAO.getByPK( gru_grupoT);	 

      return listTemp.size()>0?listTemp.get(0):new Gru_grupoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
