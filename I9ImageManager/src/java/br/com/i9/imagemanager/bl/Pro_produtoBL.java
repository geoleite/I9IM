package br.com.i9.imagemanager.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Pro_produtoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Pro_produtoT pro_produtoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Pro_produtoDAO pro_produtoDAO =  getPro_produtoDAO();
      pro_produtoDAO.insert(pro_produtoT);	 
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
  public List<Pro_produtoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
      return pro_produtoDAO.getAll();	 
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
  public boolean delete(Pro_produtoT pro_produtoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(pro_produtoT)) {
        Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
        pro_produtoDAO.delete(pro_produtoT);	 
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
  public boolean exist(Pro_produtoT pro_produtoT) throws Exception {
   try {
	
      Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
      List<Pro_produtoT> listTemp  = pro_produtoDAO.getByPK(pro_produtoT);	 

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
  public boolean update(Pro_produtoT pro_produtoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(pro_produtoT)) {
        Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
        pro_produtoDAO.update(pro_produtoT);	 
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
  public Pro_produtoT findbyid(Pro_produtoT pro_produtoT) throws Exception {
    try {
      Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
      List<Pro_produtoT> listTemp  = pro_produtoDAO.getByPK( pro_produtoT);	 

      return listTemp.size()>0?listTemp.get(0):new Pro_produtoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
