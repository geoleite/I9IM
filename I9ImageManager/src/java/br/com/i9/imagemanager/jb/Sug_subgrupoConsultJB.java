package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Sug_subgrupoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Sug_subgrupoT sug_subgrupoT = new Sug_subgrupoT();

  public void setSug_subgrupoT(Sug_subgrupoT sug_subgrupoT) {
    this.sug_subgrupoT = sug_subgrupoT;
  }

  public Sug_subgrupoT getSug_subgrupoT() {	
    return sug_subgrupoT;
  }


	
  private List<Sug_subgrupoT> list;

  public List<Sug_subgrupoT> getList() {
    return list;
  }
  
  public void setList(List<Sug_subgrupoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Sug_subgrupoDAO sug_subgrupoDAO = getSug_subgrupoDAO();
      list = sug_subgrupoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Sug_subgrupoDAO sug_subgrupoDAO = getSug_subgrupoDAO();
      sug_subgrupoDAO.delete(sug_subgrupoT);	 
      setMsg("Exclusao efetuada com sucesso!");
      sug_subgrupoT = new Sug_subgrupoT();
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
	  String page = "sug_subgrupoInsert.jsp";// defina aqui a p?gina que deve ser chamada  
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
