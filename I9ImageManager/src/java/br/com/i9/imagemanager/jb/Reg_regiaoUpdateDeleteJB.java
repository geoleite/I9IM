package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Reg_regiaoUpdateDeleteJB extends SystemBase {

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
	//
  }

  public void clear() throws Exception {
    
      reg_regiaoT = new Reg_regiaoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Reg_regiaoDAO reg_regiaoDAO = getReg_regiaoDAO();
        reg_regiaoDAO.delete(reg_regiaoT);	 
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
      Reg_regiaoDAO reg_regiaoDAO = getReg_regiaoDAO();
      List<Reg_regiaoT> listTemp  = reg_regiaoDAO.getByPK( reg_regiaoT);	 

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
        Reg_regiaoDAO reg_regiaoDAO = getReg_regiaoDAO();
        reg_regiaoDAO.update(reg_regiaoT);	 
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


  //Method Download Image ? montando se houver algum campo do tipo bin?rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Reg_regiaoDAO reg_regiaoDAO = getReg_regiaoDAO();
      List<Reg_regiaoT> listTemp  = reg_regiaoDAO.getByPK( reg_regiaoT);	 

      reg_regiaoT= listTemp.size()>0?listTemp.get(0):new Reg_regiaoT();
      
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
	  String page = "reg_regiaoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "reg_regiaoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
