package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Pro_selInsertJB extends SystemBase {

  // Atributos e propriedades
    private Pro_selT pro_selT = new Pro_selT();

  public void setPro_selT(Pro_selT pro_selT) {
    this.pro_selT = pro_selT;
  }

  public Pro_selT getPro_selT() {	
    return pro_selT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultPro_produto();

		consultSel_selo();

  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Pro_selDAO pro_selDAO =  getPro_selDAO();
      pro_selDAO.insert(pro_selT);	 
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
	private List<Pro_produtoT> listpro_produto;
	public List<Pro_produtoT> getListpro_produto() {
		return listpro_produto;
	}

	 public void setListpro_produto(List<Pro_produtoT> list) {
		this.listpro_produto=list;
	}
	public void consultPro_produto() throws Exception {
		try {
			Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
			listpro_produto=pro_produtoDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	private List<Sel_seloT> listsel_selo;
	public List<Sel_seloT> getListsel_selo() {
		return listsel_selo;
	}

	 public void setListsel_selo(List<Sel_seloT> list) {
		this.listsel_selo=list;
	}
	public void consultSel_selo() throws Exception {
		try {
			Sel_seloDAO sel_seloDAO = getSel_seloDAO();
			listsel_selo=sel_seloDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}


  
  public void clear() throws Exception {
    
      pro_selT = new Pro_selT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "pro_selConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
