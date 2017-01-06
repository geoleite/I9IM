package br.com.i9.imagemanager.bl;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Arq_arquivoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Arq_arquivoT arq_arquivoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Arq_arquivoDAO arq_arquivoDAO =  getArq_arquivoDAO();
      arq_arquivoDAO.insert(arq_arquivoT);	 
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
  public List<Arq_arquivoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();
      return arq_arquivoDAO.getAll();	 
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
  public boolean delete(Arq_arquivoT arq_arquivoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(arq_arquivoT)) {
        Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();
        arq_arquivoDAO.delete(arq_arquivoT);	 
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
  public boolean exist(Arq_arquivoT arq_arquivoT) throws Exception {
   try {
	
      Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();
      List<Arq_arquivoT> listTemp  = arq_arquivoDAO.getByPK(arq_arquivoT);	 

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
  public boolean update(Arq_arquivoT arq_arquivoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(arq_arquivoT)) {
        Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();
        arq_arquivoDAO.update(arq_arquivoT);	 
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
  public Arq_arquivoT findbyid(Arq_arquivoT arq_arquivoT) throws Exception {
    try {
      Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();
      List<Arq_arquivoT> listTemp  = arq_arquivoDAO.getByPK( arq_arquivoT);	 

      return listTemp.size()>0?listTemp.get(0):new Arq_arquivoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
