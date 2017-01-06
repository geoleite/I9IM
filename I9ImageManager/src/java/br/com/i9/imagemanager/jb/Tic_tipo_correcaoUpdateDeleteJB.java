package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tic_tipo_correcaoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Tic_tipo_correcaoT tic_tipo_correcaoT = new Tic_tipo_correcaoT();

  public void setTic_tipo_correcaoT(Tic_tipo_correcaoT tic_tipo_correcaoT) {
    this.tic_tipo_correcaoT = tic_tipo_correcaoT;
  }

  public Tic_tipo_correcaoT getTic_tipo_correcaoT() {	
    return tic_tipo_correcaoT;
  }

	
  private List<Tic_tipo_correcaoT> list;

  public List<Tic_tipo_correcaoT> getList() {
    return list;
  }
  
  public void setList(List<Tic_tipo_correcaoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  public void clear() throws Exception {
    
      tic_tipo_correcaoT = new Tic_tipo_correcaoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Tic_tipo_correcaoDAO tic_tipo_correcaoDAO = getTic_tipo_correcaoDAO();
        tic_tipo_correcaoDAO.delete(tic_tipo_correcaoT);	 
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
      Tic_tipo_correcaoDAO tic_tipo_correcaoDAO = getTic_tipo_correcaoDAO();
      List<Tic_tipo_correcaoT> listTemp  = tic_tipo_correcaoDAO.getByPK( tic_tipo_correcaoT);	 

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
        Tic_tipo_correcaoDAO tic_tipo_correcaoDAO = getTic_tipo_correcaoDAO();
        tic_tipo_correcaoDAO.update(tic_tipo_correcaoT);	 
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
      Tic_tipo_correcaoDAO tic_tipo_correcaoDAO = getTic_tipo_correcaoDAO();
      List<Tic_tipo_correcaoT> listTemp  = tic_tipo_correcaoDAO.getByPK( tic_tipo_correcaoT);	 

      tic_tipo_correcaoT= listTemp.size()>0?listTemp.get(0):new Tic_tipo_correcaoT();
      
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
	  String page = "tic_tipo_correcaoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "tic_tipo_correcaoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
