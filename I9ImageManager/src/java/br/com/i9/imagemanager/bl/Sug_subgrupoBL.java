package br.com.i9.imagemanager.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Sug_subgrupoBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Sug_subgrupoT sug_subgrupoT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Sug_subgrupoDAO sug_subgrupoDAO =  getSug_subgrupoDAO();
      sug_subgrupoDAO.insert(sug_subgrupoT);	 
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
  public List<Sug_subgrupoT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Sug_subgrupoDAO sug_subgrupoDAO = getSug_subgrupoDAO();
      return sug_subgrupoDAO.getAll();	 
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
  public boolean delete(Sug_subgrupoT sug_subgrupoT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(sug_subgrupoT)) {
        Sug_subgrupoDAO sug_subgrupoDAO = getSug_subgrupoDAO();
        sug_subgrupoDAO.delete(sug_subgrupoT);	 
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
  public boolean exist(Sug_subgrupoT sug_subgrupoT) throws Exception {
   try {
	
      Sug_subgrupoDAO sug_subgrupoDAO = getSug_subgrupoDAO();
      List<Sug_subgrupoT> listTemp  = sug_subgrupoDAO.getByPK(sug_subgrupoT);	 

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
  public boolean update(Sug_subgrupoT sug_subgrupoT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(sug_subgrupoT)) {
        Sug_subgrupoDAO sug_subgrupoDAO = getSug_subgrupoDAO();
        sug_subgrupoDAO.update(sug_subgrupoT);	 
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
  public Sug_subgrupoT findbyid(Sug_subgrupoT sug_subgrupoT) throws Exception {
    try {
      Sug_subgrupoDAO sug_subgrupoDAO = getSug_subgrupoDAO();
      List<Sug_subgrupoT> listTemp  = sug_subgrupoDAO.getByPK( sug_subgrupoT);	 

      return listTemp.size()>0?listTemp.get(0):new Sug_subgrupoT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
