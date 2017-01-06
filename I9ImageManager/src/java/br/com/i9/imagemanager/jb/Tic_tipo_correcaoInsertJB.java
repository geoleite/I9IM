package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tic_tipo_correcaoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Tic_tipo_correcaoT tic_tipo_correcaoT = new Tic_tipo_correcaoT();

  public void setTic_tipo_correcaoT(Tic_tipo_correcaoT tic_tipo_correcaoT) {
    this.tic_tipo_correcaoT = tic_tipo_correcaoT;
  }

  public Tic_tipo_correcaoT getTic_tipo_correcaoT() {	
    return tic_tipo_correcaoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Tic_tipo_correcaoDAO tic_tipo_correcaoDAO =  getTic_tipo_correcaoDAO();
      tic_tipo_correcaoDAO.insert(tic_tipo_correcaoT);	 
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
    
      tic_tipo_correcaoT = new Tic_tipo_correcaoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "tic_tipo_correcaoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
