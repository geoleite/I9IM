package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Pro_produtoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Pro_produtoT pro_produtoT = new Pro_produtoT();

  public void setPro_produtoT(Pro_produtoT pro_produtoT) {
    this.pro_produtoT = pro_produtoT;
  }

  public Pro_produtoT getPro_produtoT() {	
    return pro_produtoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultSug_subgrupo();

  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Pro_produtoDAO pro_produtoDAO =  getPro_produtoDAO();
      pro_produtoDAO.insert(pro_produtoT);	 
      setMsg(INFO,"Cadastro efetuado com sucesso!");
      clear();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar cadastro!");	
    } finally {
	close();
    }
  } 

// Method de lookup
// 
	private List<Sug_subgrupoT> listsug_subgrupo;
	public List<Sug_subgrupoT> getListsug_subgrupo() {
		return listsug_subgrupo;
	}

	 public void setListsug_subgrupo(List<Sug_subgrupoT> list) {
		this.listsug_subgrupo=list;
	}
	public void consultSug_subgrupo() throws Exception {
		try {
			Sug_subgrupoDAO sug_subgrupoDAO = getSug_subgrupoDAO();
			listsug_subgrupo=sug_subgrupoDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}


  
  public void clear() throws Exception {
    
      pro_produtoT = new Pro_produtoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "pro_produtoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
