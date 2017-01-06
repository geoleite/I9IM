package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import java.sql.Timestamp;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Eve_eventoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Eve_eventoT eve_eventoT = new Eve_eventoT();

  public void setEve_eventoT(Eve_eventoT eve_eventoT) {
    this.eve_eventoT = eve_eventoT;
  }

  public Eve_eventoT getEve_eventoT() {	
    return eve_eventoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Eve_eventoDAO eve_eventoDAO =  getEve_eventoDAO();
      eve_eventoT.setEve_dt_criacao(new Timestamp(System.currentTimeMillis()));
      eve_eventoDAO.insert(eve_eventoT);	 
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

  
  public void clear() throws Exception {
    
      eve_eventoT = new Eve_eventoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "eve_eventoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
