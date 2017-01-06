package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Tic_tipo_correcaoConsultJB extends SystemBase {

  // Atributos e propriedades
    private Tic_tipo_correcaoT tic_tipo_correcaoT = new Tic_tipo_correcaoT();

  public void setTic_tipo_correcaoT(Tic_tipo_correcaoT tic_tipo_correcaoT) {
    this.tic_tipo_correcaoT = tic_tipo_correcaoT;
  }

  public Tic_tipo_correcaoT getTic_tipo_correcaoT() {	
    return tic_tipo_correcaoT;
  }


	
  private List<Tic_tipo_correcaoT> list;

  public List<Tic_tipo_correcaoT> getList() {
    return list;
  }
  
  public void setList(List<Tic_tipo_correcaoT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Tic_tipo_correcaoDAO tic_tipo_correcaoDAO = getTic_tipo_correcaoDAO();
      list = tic_tipo_correcaoDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Tic_tipo_correcaoDAO tic_tipo_correcaoDAO = getTic_tipo_correcaoDAO();
      tic_tipo_correcaoDAO.delete(tic_tipo_correcaoT);	 
      setMsg("Exclusao efetuada com sucesso!");
      tic_tipo_correcaoT = new Tic_tipo_correcaoT();
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
	  String page = "tic_tipo_correcaoInsert.jsp";// defina aqui a p?gina que deve ser chamada  
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
