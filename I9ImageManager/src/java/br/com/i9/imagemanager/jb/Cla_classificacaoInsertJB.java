package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cla_classificacaoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Cla_classificacaoT cla_classificacaoT = new Cla_classificacaoT();

  public void setCla_classificacaoT(Cla_classificacaoT cla_classificacaoT) {
    this.cla_classificacaoT = cla_classificacaoT;
  }

  public Cla_classificacaoT getCla_classificacaoT() {	
    return cla_classificacaoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Cla_classificacaoDAO cla_classificacaoDAO =  getCla_classificacaoDAO();
      cla_classificacaoDAO.insert(cla_classificacaoT);	 
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
    
      cla_classificacaoT = new Cla_classificacaoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "cla_classificacaoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
