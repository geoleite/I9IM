package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Obe_observacaoexclusaoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Obe_observacaoexclusaoT obe_observacaoexclusaoT = new Obe_observacaoexclusaoT();

  public void setObe_observacaoexclusaoT(Obe_observacaoexclusaoT obe_observacaoexclusaoT) {
    this.obe_observacaoexclusaoT = obe_observacaoexclusaoT;
  }

  public Obe_observacaoexclusaoT getObe_observacaoexclusaoT() {	
    return obe_observacaoexclusaoT;
  }


	
  private List<Obe_observacaoexclusaoT> list;

  public List<Obe_observacaoexclusaoT> getList() {
    return list;
  }
  
  public void setList(List<Obe_observacaoexclusaoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Obe_observacaoexclusaoDAO obe_observacaoexclusaoDAO = getObe_observacaoexclusaoDAO();
      list = obe_observacaoexclusaoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Obe_observacaoexclusaoDAO obe_observacaoexclusaoDAO = getObe_observacaoexclusaoDAO();
      obe_observacaoexclusaoDAO.delete(obe_observacaoexclusaoT);	 
      setMsg("Exclusao efetuada com sucesso!");
      obe_observacaoexclusaoT = new Obe_observacaoexclusaoT();
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
	  String page = "obe_observacaoexclusaoInsert.jsp";// defina aqui a p?gina que deve ser chamada  
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
