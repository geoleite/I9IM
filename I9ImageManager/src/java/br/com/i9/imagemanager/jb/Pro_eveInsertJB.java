package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Pro_eveInsertJB extends SystemBase {

  // Atributos e propriedades
    private Pro_eveT pro_eveT = new Pro_eveT();

  public void setPro_eveT(Pro_eveT pro_eveT) {
    this.pro_eveT = pro_eveT;
  }

  public Pro_eveT getPro_eveT() {	
    return pro_eveT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultPro_produto();

		consultEve_evento();

  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Pro_eveDAO pro_eveDAO =  getPro_eveDAO();
      pro_eveDAO.insert(pro_eveT);	 
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

	private List<Eve_eventoT> listeve_evento;
	public List<Eve_eventoT> getListeve_evento() {
		return listeve_evento;
	}

	 public void setListeve_evento(List<Eve_eventoT> list) {
		this.listeve_evento=list;
	}
	public void consultEve_evento() throws Exception {
		try {
			Eve_eventoDAO eve_eventoDAO = getEve_eventoDAO();
			listeve_evento=eve_eventoDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}


  
  public void clear() throws Exception {
    
      pro_eveT = new Pro_eveT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "pro_eveConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
