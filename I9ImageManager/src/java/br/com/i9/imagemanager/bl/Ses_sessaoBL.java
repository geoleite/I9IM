package br.com.i9.imagemanager.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ses_sessaoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Ses_sessaoT ses_sessaoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Ses_sessaoDAO ses_sessaoDAO =  getSes_sessaoDAO();
      ses_sessaoDAO.insert(ses_sessaoT);	 
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
  public List<Ses_sessaoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Ses_sessaoDAO ses_sessaoDAO = getSes_sessaoDAO();
      return ses_sessaoDAO.getAll();	 
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
  public boolean delete(Ses_sessaoT ses_sessaoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(ses_sessaoT)) {
        Ses_sessaoDAO ses_sessaoDAO = getSes_sessaoDAO();
        ses_sessaoDAO.delete(ses_sessaoT);	 
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
  public boolean exist(Ses_sessaoT ses_sessaoT) throws Exception {
   try {
	
      Ses_sessaoDAO ses_sessaoDAO = getSes_sessaoDAO();
      List<Ses_sessaoT> listTemp  = ses_sessaoDAO.getByPK(ses_sessaoT);	 

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
  public boolean update(Ses_sessaoT ses_sessaoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(ses_sessaoT)) {
        Ses_sessaoDAO ses_sessaoDAO = getSes_sessaoDAO();
        ses_sessaoDAO.update(ses_sessaoT);	 
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
  public Ses_sessaoT findbyid(Ses_sessaoT ses_sessaoT) throws Exception {
    try {
      Ses_sessaoDAO ses_sessaoDAO = getSes_sessaoDAO();
      List<Ses_sessaoT> listTemp  = ses_sessaoDAO.getByPK( ses_sessaoT);	 

      return listTemp.size()>0?listTemp.get(0):new Ses_sessaoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
