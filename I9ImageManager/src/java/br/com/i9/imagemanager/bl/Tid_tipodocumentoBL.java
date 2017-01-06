package br.com.i9.imagemanager.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tid_tipodocumentoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Tid_tipodocumentoT tid_tipodocumentoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Tid_tipodocumentoDAO tid_tipodocumentoDAO =  getTid_tipodocumentoDAO();
      tid_tipodocumentoDAO.insert(tid_tipodocumentoT);	 
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
  public List<Tid_tipodocumentoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Tid_tipodocumentoDAO tid_tipodocumentoDAO = getTid_tipodocumentoDAO();
      return tid_tipodocumentoDAO.getAll();	 
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
  public boolean delete(Tid_tipodocumentoT tid_tipodocumentoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(tid_tipodocumentoT)) {
        Tid_tipodocumentoDAO tid_tipodocumentoDAO = getTid_tipodocumentoDAO();
        tid_tipodocumentoDAO.delete(tid_tipodocumentoT);	 
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
  public boolean exist(Tid_tipodocumentoT tid_tipodocumentoT) throws Exception {
   try {
	
      Tid_tipodocumentoDAO tid_tipodocumentoDAO = getTid_tipodocumentoDAO();
      List<Tid_tipodocumentoT> listTemp  = tid_tipodocumentoDAO.getByPK(tid_tipodocumentoT);	 

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
  public boolean update(Tid_tipodocumentoT tid_tipodocumentoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(tid_tipodocumentoT)) {
        Tid_tipodocumentoDAO tid_tipodocumentoDAO = getTid_tipodocumentoDAO();
        tid_tipodocumentoDAO.update(tid_tipodocumentoT);	 
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
  public Tid_tipodocumentoT findbyid(Tid_tipodocumentoT tid_tipodocumentoT) throws Exception {
    try {
      Tid_tipodocumentoDAO tid_tipodocumentoDAO = getTid_tipodocumentoDAO();
      List<Tid_tipodocumentoT> listTemp  = tid_tipodocumentoDAO.getByPK( tid_tipodocumentoT);	 

      return listTemp.size()>0?listTemp.get(0):new Tid_tipodocumentoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
