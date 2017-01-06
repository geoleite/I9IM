package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ond_ondaUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Ond_ondaT ond_ondaT = new Ond_ondaT();

  public void setOnd_ondaT(Ond_ondaT ond_ondaT) {
    this.ond_ondaT = ond_ondaT;
  }

  public Ond_ondaT getOnd_ondaT() {	
    return ond_ondaT;
  }

	
  private List<Ond_ondaT> list;

  public List<Ond_ondaT> getList() {
    return list;
  }
  
  public void setList(List<Ond_ondaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultEve_evento();

  }

  public void clear() throws Exception {
    
      ond_ondaT = new Ond_ondaT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Ond_ondaDAO ond_ondaDAO = getOnd_ondaDAO();
        ond_ondaDAO.delete(ond_ondaT);	 
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
      Ond_ondaDAO ond_ondaDAO = getOnd_ondaDAO();
      List<Ond_ondaT> listTemp  = ond_ondaDAO.getByPK( ond_ondaT);	 

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
        Ond_ondaDAO ond_ondaDAO = getOnd_ondaDAO();
        ond_ondaDAO.update(ond_ondaT);	 
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
	private List<Eve_eventoT> listeve_evento;
	public List<Eve_eventoT> getListeve_evento() {
		return listeve_evento;
	}

	 public void setListeve_evento(List<Eve_eventoT> list) {
		this.listeve_evento=list;
	}
	public void consultEve_evento() throws Exception {
		try {
			Eve_eventoDAO eve_eventoDAO = getEve_eventoDAO();
			listeve_evento=eve_eventoDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}



  //Method Download Image ? montando se houver algum campo do tipo bin?rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Ond_ondaDAO ond_ondaDAO = getOnd_ondaDAO();
      List<Ond_ondaT> listTemp  = ond_ondaDAO.getByPK( ond_ondaT);	 

      ond_ondaT= listTemp.size()>0?listTemp.get(0):new Ond_ondaT();
      
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
	  String page = "ond_ondaConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "ond_ondaConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
