package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Reg_regiaoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Reg_regiaoT reg_regiaoT = new Reg_regiaoT();

  public void setReg_regiaoT(Reg_regiaoT reg_regiaoT) {
    this.reg_regiaoT = reg_regiaoT;
  }

  public Reg_regiaoT getReg_regiaoT() {	
    return reg_regiaoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Reg_regiaoDAO reg_regiaoDAO =  getReg_regiaoDAO();
      reg_regiaoDAO.insert(reg_regiaoT);	 
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
    
      reg_regiaoT = new Reg_regiaoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "reg_regiaoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
