package br.com.i9.imagemanager.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Use_usuario_setorBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Use_usuario_setorT use_usuario_setorT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Use_usuario_setorDAO use_usuario_setorDAO =  getUse_usuario_setorDAO();
      use_usuario_setorDAO.insert(use_usuario_setorT);	 
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
  public List<Use_usuario_setorT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Use_usuario_setorDAO use_usuario_setorDAO = getUse_usuario_setorDAO();
      return use_usuario_setorDAO.getAll();	 
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
  public boolean delete(Use_usuario_setorT use_usuario_setorT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(use_usuario_setorT)) {
        Use_usuario_setorDAO use_usuario_setorDAO = getUse_usuario_setorDAO();
        use_usuario_setorDAO.delete(use_usuario_setorT);	 
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
  public boolean exist(Use_usuario_setorT use_usuario_setorT) throws Exception {
   try {
	
      Use_usuario_setorDAO use_usuario_setorDAO = getUse_usuario_setorDAO();
      List<Use_usuario_setorT> listTemp  = use_usuario_setorDAO.getByPK(use_usuario_setorT);	 

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
  public boolean update(Use_usuario_setorT use_usuario_setorT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(use_usuario_setorT)) {
        Use_usuario_setorDAO use_usuario_setorDAO = getUse_usuario_setorDAO();
        use_usuario_setorDAO.update(use_usuario_setorT);	 
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
  public Use_usuario_setorT findbyid(Use_usuario_setorT use_usuario_setorT) throws Exception {
    try {
      Use_usuario_setorDAO use_usuario_setorDAO = getUse_usuario_setorDAO();
      List<Use_usuario_setorT> listTemp  = use_usuario_setorDAO.getByPK( use_usuario_setorT);	 

      return listTemp.size()>0?listTemp.get(0):new Use_usuario_setorT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
