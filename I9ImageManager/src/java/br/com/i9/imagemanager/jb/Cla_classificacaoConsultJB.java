package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Cla_classificacaoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Cla_classificacaoT cla_classificacaoT = new Cla_classificacaoT();

  public void setCla_classificacaoT(Cla_classificacaoT cla_classificacaoT) {
    this.cla_classificacaoT = cla_classificacaoT;
  }

  public Cla_classificacaoT getCla_classificacaoT() {	
    return cla_classificacaoT;
  }


	
  private List<Cla_classificacaoT> list;

  public List<Cla_classificacaoT> getList() {
    return list;
  }
  
  public void setList(List<Cla_classificacaoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Cla_classificacaoDAO cla_classificacaoDAO = getCla_classificacaoDAO();
      list = cla_classificacaoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Cla_classificacaoDAO cla_classificacaoDAO = getCla_classificacaoDAO();
      cla_classificacaoDAO.delete(cla_classificacaoT);	 
      setMsg("Exclusao efetuada com sucesso!");
      cla_classificacaoT = new Cla_classificacaoT();
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
	  String page = "cla_classificacaoInsert.jsp";// defina aqui a p?gina que deve ser chamada  
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
