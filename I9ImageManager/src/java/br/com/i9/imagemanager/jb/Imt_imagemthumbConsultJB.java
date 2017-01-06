package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Imt_imagemthumbConsultJB extends SystemBase {

  // Atributos e propriedades
    private Imt_imagemthumbT imt_imagemthumbT = new Imt_imagemthumbT();

  public void setImt_imagemthumbT(Imt_imagemthumbT imt_imagemthumbT) {
    this.imt_imagemthumbT = imt_imagemthumbT;
  }

  public Imt_imagemthumbT getImt_imagemthumbT() {	
    return imt_imagemthumbT;
  }


	
  private List<Imt_imagemthumbT> list;

  public List<Imt_imagemthumbT> getList() {
    return list;
  }
  
  public void setList(List<Imt_imagemthumbT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Imt_imagemthumbDAO imt_imagemthumbDAO = getImt_imagemthumbDAO();
      list = imt_imagemthumbDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Imt_imagemthumbDAO imt_imagemthumbDAO = getImt_imagemthumbDAO();
      imt_imagemthumbDAO.delete(imt_imagemthumbT);	 
      setMsg("Exclusao efetuada com sucesso!");
      imt_imagemthumbT = new Imt_imagemthumbT();
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
	  String page = "imt_imagemthumbInsert.jsp";// defina aqui a p?gina que deve ser chamada  
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
