package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cla_classificacaoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Cla_classificacaoT cla_classificacaoT = new Cla_classificacaoT();

  public void setCla_classificacaoT(Cla_classificacaoT cla_classificacaoT) {
    this.cla_classificacaoT = cla_classificacaoT;
  }

  public Cla_classificacaoT getCla_classificacaoT() {	
    return cla_classificacaoT;
  }

	
  private List<Cla_classificacaoT> list;

  public List<Cla_classificacaoT> getList() {
    return list;
  }
  
  public void setList(List<Cla_classificacaoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      cla_classificacaoT = new Cla_classificacaoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Cla_classificacaoDAO cla_classificacaoDAO = getCla_classificacaoDAO();
        cla_classificacaoDAO.delete(cla_classificacaoT);	 
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
      Cla_classificacaoDAO cla_classificacaoDAO = getCla_classificacaoDAO();
      List<Cla_classificacaoT> listTemp  = cla_classificacaoDAO.getByPK( cla_classificacaoT);	 

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
        Cla_classificacaoDAO cla_classificacaoDAO = getCla_classificacaoDAO();
        cla_classificacaoDAO.update(cla_classificacaoT);	 
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
      Cla_classificacaoDAO cla_classificacaoDAO = getCla_classificacaoDAO();
      List<Cla_classificacaoT> listTemp  = cla_classificacaoDAO.getByPK( cla_classificacaoT);	 

      cla_classificacaoT= listTemp.size()>0?listTemp.get(0):new Cla_classificacaoT();
      
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
	  String page = "cla_classificacaoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "cla_classificacaoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
