package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Pro_selConsultJB extends SystemBase {

  // Atributos e propriedades
    private Pro_selT pro_selT = new Pro_selT();

  public void setPro_selT(Pro_selT pro_selT) {
    this.pro_selT = pro_selT;
  }

  public Pro_selT getPro_selT() {	
    return pro_selT;
  }


	
  private List<Pro_selT> list;

  public List<Pro_selT> getList() {
    return list;
  }
  
  public void setList(List<Pro_selT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Pro_selDAO pro_selDAO = getPro_selDAO();
      list = pro_selDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Pro_selDAO pro_selDAO = getPro_selDAO();
      pro_selDAO.delete(pro_selT);	 
      setMsg("Exclusao efetuada com sucesso!");
      pro_selT = new Pro_selT();
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
	  String page = "pro_selInsert.jsp";// defina aqui a p?gina que deve ser chamada  
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
