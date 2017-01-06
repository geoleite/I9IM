package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tid_tipodocumentoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Tid_tipodocumentoT tid_tipodocumentoT = new Tid_tipodocumentoT();

  public void setTid_tipodocumentoT(Tid_tipodocumentoT tid_tipodocumentoT) {
    this.tid_tipodocumentoT = tid_tipodocumentoT;
  }

  public Tid_tipodocumentoT getTid_tipodocumentoT() {	
    return tid_tipodocumentoT;
  }

	
  private List<Tid_tipodocumentoT> list;

  public List<Tid_tipodocumentoT> getList() {
    return list;
  }
  
  public void setList(List<Tid_tipodocumentoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      tid_tipodocumentoT = new Tid_tipodocumentoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Tid_tipodocumentoDAO tid_tipodocumentoDAO = getTid_tipodocumentoDAO();
        tid_tipodocumentoDAO.delete(tid_tipodocumentoT);	 
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
      Tid_tipodocumentoDAO tid_tipodocumentoDAO = getTid_tipodocumentoDAO();
      List<Tid_tipodocumentoT> listTemp  = tid_tipodocumentoDAO.getByPK( tid_tipodocumentoT);	 

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
        Tid_tipodocumentoDAO tid_tipodocumentoDAO = getTid_tipodocumentoDAO();
        tid_tipodocumentoDAO.update(tid_tipodocumentoT);	 
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


  //Method Download Image ? montando se houver algum campo do tipo bin?rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Tid_tipodocumentoDAO tid_tipodocumentoDAO = getTid_tipodocumentoDAO();
      List<Tid_tipodocumentoT> listTemp  = tid_tipodocumentoDAO.getByPK( tid_tipodocumentoT);	 

      tid_tipodocumentoT= listTemp.size()>0?listTemp.get(0):new Tid_tipodocumentoT();
      
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
	  String page = "tid_tipodocumentoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "tid_tipodocumentoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
