package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Enc_encarteUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Enc_encarteT enc_encarteT = new Enc_encarteT();

  public void setEnc_encarteT(Enc_encarteT enc_encarteT) {
    this.enc_encarteT = enc_encarteT;
  }

  public Enc_encarteT getEnc_encarteT() {	
    return enc_encarteT;
  }

	
  private List<Enc_encarteT> list;

  public List<Enc_encarteT> getList() {
    return list;
  }
  
  public void setList(List<Enc_encarteT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      enc_encarteT = new Enc_encarteT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Enc_encarteDAO enc_encarteDAO = getEnc_encarteDAO();
        enc_encarteDAO.delete(enc_encarteT);	 
        setMsg("Exclusao efetuada com sucesso!");
        clear();
      } else {  
	setMsg(ERROR, "Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      Enc_encarteDAO enc_encarteDAO = getEnc_encarteDAO();
      List<Enc_encarteT> listTemp  = enc_encarteDAO.getByPK( enc_encarteT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
    return false;
	
  }

  public void update() throws Exception {
    try {
      if (exist()) {
        Enc_encarteDAO enc_encarteDAO = getEnc_encarteDAO();
        enc_encarteDAO.update(enc_encarteT);	 
        setMsg("Alteracao efetuada com sucesso!");	
      } else {  
	setMsg(ERROR,"Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar alteracao!");	
    } finally {
	close();
    }
  }   

// Method de lookup
// 


 


  public void findbyid() throws Exception {
    try {
      Enc_encarteDAO enc_encarteDAO = getEnc_encarteDAO();
      List<Enc_encarteT> listTemp  = enc_encarteDAO.getByPK( enc_encarteT);	 

      enc_encarteT= listTemp.size()>0?listTemp.get(0):new Enc_encarteT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a p?gina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "enc_encarteConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "enc_encarteConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
