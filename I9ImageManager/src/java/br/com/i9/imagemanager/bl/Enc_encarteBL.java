package br.com.i9.imagemanager.bl	;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import br.com.easynet.bl.BusinessException;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Enc_encarteBL  extends SystemBusinessBase {


  /**
   * Insere um registro na tabela
   */	  
  public boolean insert(Enc_encarteT enc_encarteT) throws Exception {
    
    try {
      if (!valide("insert")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Enc_encarteDAO enc_encarteDAO =  getEnc_encarteDAO();
      enc_encarteDAO.insert(enc_encarteT);	 
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
  public List<Enc_encarteT> consult() throws Exception {
    try {
      if (!valide("consult")) {
	throw new BusinessException("Falha na seguranca !");
      }
      Enc_encarteDAO enc_encarteDAO = getEnc_encarteDAO();
      return enc_encarteDAO.getAll();	 
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
  public boolean delete(Enc_encarteT enc_encarteT) throws Exception {
    try {
      if (!valide("delete")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(enc_encarteT)) {
        Enc_encarteDAO enc_encarteDAO = getEnc_encarteDAO();
        enc_encarteDAO.delete(enc_encarteT);	 
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
  public boolean exist(Enc_encarteT enc_encarteT) throws Exception {
   try {
	
      Enc_encarteDAO enc_encarteDAO = getEnc_encarteDAO();
      List<Enc_encarteT> listTemp  = enc_encarteDAO.getByPK(enc_encarteT);	 

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
  public boolean update(Enc_encarteT enc_encarteT) throws Exception {
    try {
      if (!valide("update")) {
	throw new BusinessException("Falha na seguranca !");
      }

      if (exist(enc_encarteT)) {
        Enc_encarteDAO enc_encarteDAO = getEnc_encarteDAO();
        enc_encarteDAO.update(enc_encarteT);	 
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
  public Enc_encarteT findbyid(Enc_encarteT enc_encarteT) throws Exception {
    try {
      Enc_encarteDAO enc_encarteDAO = getEnc_encarteDAO();
      List<Enc_encarteT> listTemp  = enc_encarteDAO.getByPK( enc_encarteT);	 

      return listTemp.size()>0?listTemp.get(0):new Enc_encarteT();      
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
	close();
    }
  }    

}
