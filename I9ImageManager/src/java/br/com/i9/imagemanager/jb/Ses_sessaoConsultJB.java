package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Ses_sessaoConsultJB extends SystemBase  {

  // Atributos e propriedades
    private Ses_sessaoT ses_sessaoT = new Ses_sessaoT();

  public void setSes_sessaoT(Ses_sessaoT ses_sessaoT) {
    this.ses_sessaoT = ses_sessaoT;
  }

  public Ses_sessaoT getSes_sessaoT() {	
    return ses_sessaoT;
  }


	
  private List<Ses_sessaoT> list;

  public List<Ses_sessaoT> getList() {
    return list;
  }
  
  public void setList(List<Ses_sessaoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Ses_sessaoDAO ses_sessaoDAO = getSes_sessaoDAO();
      list = ses_sessaoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Ses_sessaoDAO ses_sessaoDAO = getSes_sessaoDAO();
      ses_sessaoDAO.delete(ses_sessaoT);	 
      setMsg("Exclusao efetuada com sucesso!");
      ses_sessaoT = new Ses_sessaoT();
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
	  String page = "ses_sessaoInsert.jsp";// defina aqui a p?gina que deve ser chamada  
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
