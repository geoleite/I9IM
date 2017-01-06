package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ses_sessaoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Ses_sessaoT ses_sessaoT = new Ses_sessaoT();

  public void setSes_sessaoT(Ses_sessaoT ses_sessaoT) {
    this.ses_sessaoT = ses_sessaoT;
  }

  public Ses_sessaoT getSes_sessaoT() {	
    return ses_sessaoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Ses_sessaoDAO ses_sessaoDAO =  getSes_sessaoDAO();
      ses_sessaoDAO.insert(ses_sessaoT);	 
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
    
      ses_sessaoT = new Ses_sessaoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "ses_sessaoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
