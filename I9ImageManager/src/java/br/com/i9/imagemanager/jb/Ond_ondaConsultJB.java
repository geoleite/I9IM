package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ond_ondaConsultJB extends SystemBase {

  // Atributos e propriedades
    private Ond_ondaT ond_ondaT = new Ond_ondaT();

  public void setOnd_ondaT(Ond_ondaT ond_ondaT) {
    this.ond_ondaT = ond_ondaT;
  }

  public Ond_ondaT getOnd_ondaT() {	
    return ond_ondaT;
  }


	
  private List<Ond_ondaT> list;

  public List<Ond_ondaT> getList() {
    return list;
  }
  
  public void setList(List<Ond_ondaT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Ond_ondaDAO ond_ondaDAO = getOnd_ondaDAO();
      list = ond_ondaDAO.getByEve_evento(ond_ondaT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Ond_ondaDAO ond_ondaDAO = getOnd_ondaDAO();
      ond_ondaDAO.delete(ond_ondaT);	 
      setMsg("Exclusao efetuada com sucesso!");
      ond_ondaT = new Ond_ondaT();
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
	  String page = "ond_ondaInsert.jsp";// defina aqui a p?gina que deve ser chamada  
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
