package br.com.i9.imagemanager.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cor_correcaoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Cor_correcaoT cor_correcaoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Cor_correcaoDAO cor_correcaoDAO =  getCor_correcaoDAO();
      cor_correcaoDAO.insert(cor_correcaoT);	 
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
  public List<Cor_correcaoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Cor_correcaoDAO cor_correcaoDAO = getCor_correcaoDAO();
      return cor_correcaoDAO.getAll();	 
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
  public boolean delete(Cor_correcaoT cor_correcaoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(cor_correcaoT)) {
        Cor_correcaoDAO cor_correcaoDAO = getCor_correcaoDAO();
        cor_correcaoDAO.delete(cor_correcaoT);	 
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
  public boolean exist(Cor_correcaoT cor_correcaoT) throws Exception {
   try {
	
      Cor_correcaoDAO cor_correcaoDAO = getCor_correcaoDAO();
      List<Cor_correcaoT> listTemp  = cor_correcaoDAO.getByPK(cor_correcaoT);	 

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
  public boolean update(Cor_correcaoT cor_correcaoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(cor_correcaoT)) {
        Cor_correcaoDAO cor_correcaoDAO = getCor_correcaoDAO();
        cor_correcaoDAO.update(cor_correcaoT);	 
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
  public Cor_correcaoT findbyid(Cor_correcaoT cor_correcaoT) throws Exception {
    try {
      Cor_correcaoDAO cor_correcaoDAO = getCor_correcaoDAO();
      List<Cor_correcaoT> listTemp  = cor_correcaoDAO.getByPK( cor_correcaoT);	 

      return listTemp.size()>0?listTemp.get(0):new Cor_correcaoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
