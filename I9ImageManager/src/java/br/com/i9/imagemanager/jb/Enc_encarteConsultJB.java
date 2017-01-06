package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Enc_encarteConsultJB extends SystemBase {

  // Atributos e propriedades
    private Enc_encarteT enc_encarteT = new Enc_encarteT();

  public void setEnc_encarteT(Enc_encarteT enc_encarteT) {
    this.enc_encarteT = enc_encarteT;
  }

  public Enc_encarteT getEnc_encarteT() {	
    return enc_encarteT;
  }


	
  private List<Enc_encarteT> list;

  public List<Enc_encarteT> getList() {
    return list;
  }
  
  public void setList(List<Enc_encarteT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        consult();
  }

  public void consult() throws Exception {
    try {
      Enc_encarteDAO enc_encarteDAO = getEnc_encarteDAO();
      list = enc_encarteDAO.getAll();	 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Enc_encarteDAO enc_encarteDAO = getEnc_encarteDAO();
      enc_encarteDAO.delete(enc_encarteT);	 
      setMsg("Exclusao efetuada com sucesso!");
      enc_encarteT = new Enc_encarteT();
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
	  String page = "enc_encarteInsert.jsp";// defina aqui a p?gina que deve ser chamada  
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
