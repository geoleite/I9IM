package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Gru_grupoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Gru_grupoT gru_grupoT = new Gru_grupoT();

  public void setGru_grupoT(Gru_grupoT gru_grupoT) {
    this.gru_grupoT = gru_grupoT;
  }

  public Gru_grupoT getGru_grupoT() {	
    return gru_grupoT;
  }


	
  private List<Gru_grupoT> list;

  public List<Gru_grupoT> getList() {
    return list;
  }
  
  public void setList(List<Gru_grupoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Gru_grupoDAO gru_grupoDAO = getGru_grupoDAO();
      list = gru_grupoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Gru_grupoDAO gru_grupoDAO = getGru_grupoDAO();
      gru_grupoDAO.delete(gru_grupoT);	 
      setMsg("Exclusao efetuada com sucesso!");
      gru_grupoT = new Gru_grupoT();
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
	  String page = "gru_grupoInsert.jsp";// defina aqui a p?gina que deve ser chamada  
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
