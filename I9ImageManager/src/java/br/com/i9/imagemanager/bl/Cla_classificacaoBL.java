package br.com.i9.imagemanager.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cla_classificacaoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Cla_classificacaoT cla_classificacaoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Cla_classificacaoDAO cla_classificacaoDAO =  getCla_classificacaoDAO();
      cla_classificacaoDAO.insert(cla_classificacaoT);	 
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
  public List<Cla_classificacaoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Cla_classificacaoDAO cla_classificacaoDAO = getCla_classificacaoDAO();
      return cla_classificacaoDAO.getAll();	 
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
  public boolean delete(Cla_classificacaoT cla_classificacaoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(cla_classificacaoT)) {
        Cla_classificacaoDAO cla_classificacaoDAO = getCla_classificacaoDAO();
        cla_classificacaoDAO.delete(cla_classificacaoT);	 
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
  public boolean exist(Cla_classificacaoT cla_classificacaoT) throws Exception {
   try {
	
      Cla_classificacaoDAO cla_classificacaoDAO = getCla_classificacaoDAO();
      List<Cla_classificacaoT> listTemp  = cla_classificacaoDAO.getByPK(cla_classificacaoT);	 

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
  public boolean update(Cla_classificacaoT cla_classificacaoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(cla_classificacaoT)) {
        Cla_classificacaoDAO cla_classificacaoDAO = getCla_classificacaoDAO();
        cla_classificacaoDAO.update(cla_classificacaoT);	 
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
  public Cla_classificacaoT findbyid(Cla_classificacaoT cla_classificacaoT) throws Exception {
    try {
      Cla_classificacaoDAO cla_classificacaoDAO = getCla_classificacaoDAO();
      List<Cla_classificacaoT> listTemp  = cla_classificacaoDAO.getByPK( cla_classificacaoT);	 

      return listTemp.size()>0?listTemp.get(0):new Cla_classificacaoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
