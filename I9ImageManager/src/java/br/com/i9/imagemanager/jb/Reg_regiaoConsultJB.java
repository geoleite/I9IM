package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Reg_regiaoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Reg_regiaoT reg_regiaoT = new Reg_regiaoT();

  public void setReg_regiaoT(Reg_regiaoT reg_regiaoT) {
    this.reg_regiaoT = reg_regiaoT;
  }

  public Reg_regiaoT getReg_regiaoT() {	
    return reg_regiaoT;
  }


	
  private List<Reg_regiaoT> list;

  public List<Reg_regiaoT> getList() {
    return list;
  }
  
  public void setList(List<Reg_regiaoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Reg_regiaoDAO reg_regiaoDAO = getReg_regiaoDAO();
      list = reg_regiaoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Reg_regiaoDAO reg_regiaoDAO = getReg_regiaoDAO();
      reg_regiaoDAO.delete(reg_regiaoT);	 
      setMsg("Exclusao efetuada com sucesso!");
      reg_regiaoT = new Reg_regiaoT();
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  }  

 public void insert() throws Exception {
	// TODO Insert
	try {
	  String page = "reg_regiaoInsert.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){}   } 

 public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  }

}
