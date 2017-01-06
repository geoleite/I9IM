package br.com.i9.imagemanager.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Obe_observacaoexclusaoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Obe_observacaoexclusaoT obe_observacaoexclusaoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Obe_observacaoexclusaoDAO obe_observacaoexclusaoDAO =  getObe_observacaoexclusaoDAO();
      obe_observacaoexclusaoDAO.insert(obe_observacaoexclusaoT);	 
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
  public List<Obe_observacaoexclusaoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Obe_observacaoexclusaoDAO obe_observacaoexclusaoDAO = getObe_observacaoexclusaoDAO();
      return obe_observacaoexclusaoDAO.getAll();	 
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
  public boolean delete(Obe_observacaoexclusaoT obe_observacaoexclusaoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(obe_observacaoexclusaoT)) {
        Obe_observacaoexclusaoDAO obe_observacaoexclusaoDAO = getObe_observacaoexclusaoDAO();
        obe_observacaoexclusaoDAO.delete(obe_observacaoexclusaoT);	 
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
  public boolean exist(Obe_observacaoexclusaoT obe_observacaoexclusaoT) throws Exception {
   try {
	
      Obe_observacaoexclusaoDAO obe_observacaoexclusaoDAO = getObe_observacaoexclusaoDAO();
      List<Obe_observacaoexclusaoT> listTemp  = obe_observacaoexclusaoDAO.getByPK(obe_observacaoexclusaoT);	 

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
  public boolean update(Obe_observacaoexclusaoT obe_observacaoexclusaoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(obe_observacaoexclusaoT)) {
        Obe_observacaoexclusaoDAO obe_observacaoexclusaoDAO = getObe_observacaoexclusaoDAO();
        obe_observacaoexclusaoDAO.update(obe_observacaoexclusaoT);	 
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
  public Obe_observacaoexclusaoT findbyid(Obe_observacaoexclusaoT obe_observacaoexclusaoT) throws Exception {
    try {
      Obe_observacaoexclusaoDAO obe_observacaoexclusaoDAO = getObe_observacaoexclusaoDAO();
      List<Obe_observacaoexclusaoT> listTemp  = obe_observacaoexclusaoDAO.getByPK( obe_observacaoexclusaoT);	 

      return listTemp.size()>0?listTemp.get(0):new Obe_observacaoexclusaoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
