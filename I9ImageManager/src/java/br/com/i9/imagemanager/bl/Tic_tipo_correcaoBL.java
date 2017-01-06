package br.com.i9.imagemanager.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tic_tipo_correcaoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Tic_tipo_correcaoT tic_tipo_correcaoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Tic_tipo_correcaoDAO tic_tipo_correcaoDAO =  getTic_tipo_correcaoDAO();
      tic_tipo_correcaoDAO.insert(tic_tipo_correcaoT);	 
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
  public List<Tic_tipo_correcaoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Tic_tipo_correcaoDAO tic_tipo_correcaoDAO = getTic_tipo_correcaoDAO();
      return tic_tipo_correcaoDAO.getAll();	 
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
  public boolean delete(Tic_tipo_correcaoT tic_tipo_correcaoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(tic_tipo_correcaoT)) {
        Tic_tipo_correcaoDAO tic_tipo_correcaoDAO = getTic_tipo_correcaoDAO();
        tic_tipo_correcaoDAO.delete(tic_tipo_correcaoT);	 
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
  public boolean exist(Tic_tipo_correcaoT tic_tipo_correcaoT) throws Exception {
   try {
	
      Tic_tipo_correcaoDAO tic_tipo_correcaoDAO = getTic_tipo_correcaoDAO();
      List<Tic_tipo_correcaoT> listTemp  = tic_tipo_correcaoDAO.getByPK(tic_tipo_correcaoT);	 

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
  public boolean update(Tic_tipo_correcaoT tic_tipo_correcaoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(tic_tipo_correcaoT)) {
        Tic_tipo_correcaoDAO tic_tipo_correcaoDAO = getTic_tipo_correcaoDAO();
        tic_tipo_correcaoDAO.update(tic_tipo_correcaoT);	 
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
  public Tic_tipo_correcaoT findbyid(Tic_tipo_correcaoT tic_tipo_correcaoT) throws Exception {
    try {
      Tic_tipo_correcaoDAO tic_tipo_correcaoDAO = getTic_tipo_correcaoDAO();
      List<Tic_tipo_correcaoT> listTemp  = tic_tipo_correcaoDAO.getByPK( tic_tipo_correcaoT);	 

      return listTemp.size()>0?listTemp.get(0):new Tic_tipo_correcaoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
