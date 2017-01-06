package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cls_classificacao_seloUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Cls_classificacao_seloT cls_classificacao_seloT = new Cls_classificacao_seloT();

  public void setCls_classificacao_seloT(Cls_classificacao_seloT cls_classificacao_seloT) {
    this.cls_classificacao_seloT = cls_classificacao_seloT;
  }

  public Cls_classificacao_seloT getCls_classificacao_seloT() {	
    return cls_classificacao_seloT;
  }

	
  private List<Cls_classificacao_seloT> list;

  public List<Cls_classificacao_seloT> getList() {
    return list;
  }
  
  public void setList(List<Cls_classificacao_seloT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      cls_classificacao_seloT = new Cls_classificacao_seloT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Cls_classificacao_seloDAO cls_classificacao_seloDAO = getCls_classificacao_seloDAO();
        cls_classificacao_seloDAO.delete(cls_classificacao_seloT);	 
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
      Cls_classificacao_seloDAO cls_classificacao_seloDAO = getCls_classificacao_seloDAO();
      List<Cls_classificacao_seloT> listTemp  = cls_classificacao_seloDAO.getByPK( cls_classificacao_seloT);	 

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
        Cls_classificacao_seloDAO cls_classificacao_seloDAO = getCls_classificacao_seloDAO();
        cls_classificacao_seloDAO.update(cls_classificacao_seloT);	 
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
      Cls_classificacao_seloDAO cls_classificacao_seloDAO = getCls_classificacao_seloDAO();
      List<Cls_classificacao_seloT> listTemp  = cls_classificacao_seloDAO.getByPK( cls_classificacao_seloT);	 

      cls_classificacao_seloT= listTemp.size()>0?listTemp.get(0):new Cls_classificacao_seloT();
      
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
	  String page = "cls_classificacao_seloConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "cls_classificacao_seloConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
