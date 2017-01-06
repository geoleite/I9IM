package br.com.i9.imagemanager.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Imt_imagemthumbBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Imt_imagemthumbT imt_imagemthumbT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Imt_imagemthumbDAO imt_imagemthumbDAO =  getImt_imagemthumbDAO();
      imt_imagemthumbDAO.insert(imt_imagemthumbT);	 
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
  public List<Imt_imagemthumbT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Imt_imagemthumbDAO imt_imagemthumbDAO = getImt_imagemthumbDAO();
      return imt_imagemthumbDAO.getAll();	 
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
  public boolean delete(Imt_imagemthumbT imt_imagemthumbT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(imt_imagemthumbT)) {
        Imt_imagemthumbDAO imt_imagemthumbDAO = getImt_imagemthumbDAO();
        imt_imagemthumbDAO.delete(imt_imagemthumbT);	 
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
  public boolean exist(Imt_imagemthumbT imt_imagemthumbT) throws Exception {
   try {
	
      Imt_imagemthumbDAO imt_imagemthumbDAO = getImt_imagemthumbDAO();
      List<Imt_imagemthumbT> listTemp  = imt_imagemthumbDAO.getByPK(imt_imagemthumbT);	 

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
  public boolean update(Imt_imagemthumbT imt_imagemthumbT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(imt_imagemthumbT)) {
        Imt_imagemthumbDAO imt_imagemthumbDAO = getImt_imagemthumbDAO();
        imt_imagemthumbDAO.update(imt_imagemthumbT);	 
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
  public Imt_imagemthumbT findbyid(Imt_imagemthumbT imt_imagemthumbT) throws Exception {
    try {
      Imt_imagemthumbDAO imt_imagemthumbDAO = getImt_imagemthumbDAO();
      List<Imt_imagemthumbT> listTemp  = imt_imagemthumbDAO.getByPK( imt_imagemthumbT);	 

      return listTemp.size()>0?listTemp.get(0):new Imt_imagemthumbT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
