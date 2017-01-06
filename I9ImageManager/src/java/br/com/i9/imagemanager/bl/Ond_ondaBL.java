package br.com.i9.imagemanager.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ond_ondaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Ond_ondaT ond_ondaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Ond_ondaDAO ond_ondaDAO =  getOnd_ondaDAO();
      ond_ondaDAO.insert(ond_ondaT);	 
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
  public List<Ond_ondaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Ond_ondaDAO ond_ondaDAO = getOnd_ondaDAO();
      return ond_ondaDAO.getAll();	 
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
  public boolean delete(Ond_ondaT ond_ondaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(ond_ondaT)) {
        Ond_ondaDAO ond_ondaDAO = getOnd_ondaDAO();
        ond_ondaDAO.delete(ond_ondaT);	 
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
  public boolean exist(Ond_ondaT ond_ondaT) throws Exception {
   try {
	
      Ond_ondaDAO ond_ondaDAO = getOnd_ondaDAO();
      List<Ond_ondaT> listTemp  = ond_ondaDAO.getByPK(ond_ondaT);	 

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
  public boolean update(Ond_ondaT ond_ondaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(ond_ondaT)) {
        Ond_ondaDAO ond_ondaDAO = getOnd_ondaDAO();
        ond_ondaDAO.update(ond_ondaT);	 
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
  public Ond_ondaT findbyid(Ond_ondaT ond_ondaT) throws Exception {
    try {
      Ond_ondaDAO ond_ondaDAO = getOnd_ondaDAO();
      List<Ond_ondaT> listTemp  = ond_ondaDAO.getByPK( ond_ondaT);	 

      return listTemp.size()>0?listTemp.get(0):new Ond_ondaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
