package br.com.i9.imagemanager.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Pag_paginaBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Pag_paginaT pag_paginaT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Pag_paginaDAO pag_paginaDAO =  getPag_paginaDAO();
      pag_paginaDAO.insert(pag_paginaT);	 
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
  public List<Pag_paginaT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Pag_paginaDAO pag_paginaDAO = getPag_paginaDAO();
      return pag_paginaDAO.getAll();	 
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
  public boolean delete(Pag_paginaT pag_paginaT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(pag_paginaT)) {
        Pag_paginaDAO pag_paginaDAO = getPag_paginaDAO();
        pag_paginaDAO.delete(pag_paginaT);	 
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
  public boolean exist(Pag_paginaT pag_paginaT) throws Exception {
   try {
	
      Pag_paginaDAO pag_paginaDAO = getPag_paginaDAO();
      List<Pag_paginaT> listTemp  = pag_paginaDAO.getByPK(pag_paginaT);	 

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
  public boolean update(Pag_paginaT pag_paginaT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(pag_paginaT)) {
        Pag_paginaDAO pag_paginaDAO = getPag_paginaDAO();
        pag_paginaDAO.update(pag_paginaT);	 
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
  public Pag_paginaT findbyid(Pag_paginaT pag_paginaT) throws Exception {
    try {
      Pag_paginaDAO pag_paginaDAO = getPag_paginaDAO();
      List<Pag_paginaT> listTemp  = pag_paginaDAO.getByPK( pag_paginaT);	 

      return listTemp.size()>0?listTemp.get(0):new Pag_paginaT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
