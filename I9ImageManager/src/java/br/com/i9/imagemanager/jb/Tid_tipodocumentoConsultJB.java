package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tid_tipodocumentoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Tid_tipodocumentoT tid_tipodocumentoT = new Tid_tipodocumentoT();

  public void setTid_tipodocumentoT(Tid_tipodocumentoT tid_tipodocumentoT) {
    this.tid_tipodocumentoT = tid_tipodocumentoT;
  }

  public Tid_tipodocumentoT getTid_tipodocumentoT() {	
    return tid_tipodocumentoT;
  }


	
  private List<Tid_tipodocumentoT> list;

  public List<Tid_tipodocumentoT> getList() {
    return list;
  }
  
  public void setList(List<Tid_tipodocumentoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Tid_tipodocumentoDAO tid_tipodocumentoDAO = getTid_tipodocumentoDAO();
      list = tid_tipodocumentoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Tid_tipodocumentoDAO tid_tipodocumentoDAO = getTid_tipodocumentoDAO();
      tid_tipodocumentoDAO.delete(tid_tipodocumentoT);	 
      setMsg("Exclusao efetuada com sucesso!");
      tid_tipodocumentoT = new Tid_tipodocumentoT();
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
	  String page = "tid_tipodocumentoInsert.jsp";// defina aqui a p?gina que deve ser chamada  
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
