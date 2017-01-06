package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cls_classificacao_seloInsertJB extends SystemBase {

  // Atributos e propriedades
    private Cls_classificacao_seloT cls_classificacao_seloT = new Cls_classificacao_seloT();

  public void setCls_classificacao_seloT(Cls_classificacao_seloT cls_classificacao_seloT) {
    this.cls_classificacao_seloT = cls_classificacao_seloT;
  }

  public Cls_classificacao_seloT getCls_classificacao_seloT() {	
    return cls_classificacao_seloT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Cls_classificacao_seloDAO cls_classificacao_seloDAO =  getCls_classificacao_seloDAO();
      cls_classificacao_seloDAO.insert(cls_classificacao_seloT);	 
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
    
      cls_classificacao_seloT = new Cls_classificacao_seloT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "cls_classificacao_seloConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
