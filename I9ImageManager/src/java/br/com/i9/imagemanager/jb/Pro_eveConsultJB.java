package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Pro_eveConsultJB extends SystemBase {

  // Atributos e propriedades
    private Pro_eveT pro_eveT = new Pro_eveT();

  public void setPro_eveT(Pro_eveT pro_eveT) {
    this.pro_eveT = pro_eveT;
  }

  public Pro_eveT getPro_eveT() {	
    return pro_eveT;
  }


	
  private List<Pro_eveT> list;

  public List<Pro_eveT> getList() {
    return list;
  }
  
  public void setList(List<Pro_eveT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Pro_eveDAO pro_eveDAO = getPro_eveDAO();
      list = pro_eveDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Pro_eveDAO pro_eveDAO = getPro_eveDAO();
      pro_eveDAO.delete(pro_eveT);	 
      setMsg("Exclusao efetuada com sucesso!");
      pro_eveT = new Pro_eveT();
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
	  String page = "pro_eveInsert.jsp";// defina aqui a p?gina que deve ser chamada  
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
