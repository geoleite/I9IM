package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tid_tipodocumentoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Tid_tipodocumentoT tid_tipodocumentoT = new Tid_tipodocumentoT();

  public void setTid_tipodocumentoT(Tid_tipodocumentoT tid_tipodocumentoT) {
    this.tid_tipodocumentoT = tid_tipodocumentoT;
  }

  public Tid_tipodocumentoT getTid_tipodocumentoT() {	
    return tid_tipodocumentoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Tid_tipodocumentoDAO tid_tipodocumentoDAO =  getTid_tipodocumentoDAO();
      tid_tipodocumentoDAO.insert(tid_tipodocumentoT);	 
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
    
      tid_tipodocumentoT = new Tid_tipodocumentoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "tid_tipodocumentoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
