package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ond_ondaInsertJB extends SystemBase {

  // Atributos e propriedades
    private Ond_ondaT ond_ondaT = new Ond_ondaT();

  public void setOnd_ondaT(Ond_ondaT ond_ondaT) {
    this.ond_ondaT = ond_ondaT;
  }

  public Ond_ondaT getOnd_ondaT() {	
    return ond_ondaT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultEve_evento();

  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Ond_ondaDAO ond_ondaDAO =  getOnd_ondaDAO();
      ond_ondaDAO.insert(ond_ondaT);	 
      setMsg(INFO,"Cadastro efetuado com sucesso!");
      clear();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar cadastro!");	
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


  
  public void clear() throws Exception {
    
      ond_ondaT = new Ond_ondaT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "ond_ondaConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
