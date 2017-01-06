package br.com.i9.imagemanager.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Pro_eveBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Pro_eveT pro_eveT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Pro_eveDAO pro_eveDAO =  getPro_eveDAO();
      pro_eveDAO.insert(pro_eveT);	 
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
  public List<Pro_eveT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Pro_eveDAO pro_eveDAO = getPro_eveDAO();
      return pro_eveDAO.getAll();	 
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
  public boolean delete(Pro_eveT pro_eveT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(pro_eveT)) {
        Pro_eveDAO pro_eveDAO = getPro_eveDAO();
        pro_eveDAO.delete(pro_eveT);	 
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
  public boolean exist(Pro_eveT pro_eveT) throws Exception {
   try {
	
      Pro_eveDAO pro_eveDAO = getPro_eveDAO();
      List<Pro_eveT> listTemp  = pro_eveDAO.getByPK(pro_eveT);	 

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
  public boolean update(Pro_eveT pro_eveT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(pro_eveT)) {
        Pro_eveDAO pro_eveDAO = getPro_eveDAO();
        pro_eveDAO.update(pro_eveT);	 
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
  public Pro_eveT findbyid(Pro_eveT pro_eveT) throws Exception {
    try {
      Pro_eveDAO pro_eveDAO = getPro_eveDAO();
      List<Pro_eveT> listTemp  = pro_eveDAO.getByPK( pro_eveT);	 

      return listTemp.size()>0?listTemp.get(0):new Pro_eveT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
