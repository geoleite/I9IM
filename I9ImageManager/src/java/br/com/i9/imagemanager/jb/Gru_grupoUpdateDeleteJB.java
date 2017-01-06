package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Gru_grupoUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Gru_grupoT gru_grupoT = new Gru_grupoT();

  public void setGru_grupoT(Gru_grupoT gru_grupoT) {
    this.gru_grupoT = gru_grupoT;
  }

  public Gru_grupoT getGru_grupoT() {	
    return gru_grupoT;
  }

	
  private List<Gru_grupoT> list;

  public List<Gru_grupoT> getList() {
    return list;
  }
  
  public void setList(List<Gru_grupoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultSes_sessao();

  }

  public void clear() throws Exception {
    
      gru_grupoT = new Gru_grupoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Gru_grupoDAO gru_grupoDAO = getGru_grupoDAO();
        gru_grupoDAO.delete(gru_grupoT);	 
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
      Gru_grupoDAO gru_grupoDAO = getGru_grupoDAO();
      List<Gru_grupoT> listTemp  = gru_grupoDAO.getByPK( gru_grupoT);	 

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
        Gru_grupoDAO gru_grupoDAO = getGru_grupoDAO();
        gru_grupoDAO.update(gru_grupoT);	 
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
	private List<Ses_sessaoT> listses_sessao;
	public List<Ses_sessaoT> getListses_sessao() {
		return listses_sessao;
	}

	 public void setListses_sessao(List<Ses_sessaoT> list) {
		this.listses_sessao=list;
	}
	public void consultSes_sessao() throws Exception {
		try {
			Ses_sessaoDAO ses_sessaoDAO = getSes_sessaoDAO();
			listses_sessao=ses_sessaoDAO.getAll();
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
      Gru_grupoDAO gru_grupoDAO = getGru_grupoDAO();
      List<Gru_grupoT> listTemp  = gru_grupoDAO.getByPK( gru_grupoT);	 

      gru_grupoT= listTemp.size()>0?listTemp.get(0):new Gru_grupoT();
      
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
	  String page = "gru_grupoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  //getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "gru_grupoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  //getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
