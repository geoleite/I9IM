package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Pro_selUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Pro_selT pro_selT = new Pro_selT();

  public void setPro_selT(Pro_selT pro_selT) {
    this.pro_selT = pro_selT;
  }

  public Pro_selT getPro_selT() {	
    return pro_selT;
  }

	
  private List<Pro_selT> list;

  public List<Pro_selT> getList() {
    return list;
  }
  
  public void setList(List<Pro_selT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultPro_produto();

		consultSel_selo();

  }

  public void clear() throws Exception {
    
      pro_selT = new Pro_selT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Pro_selDAO pro_selDAO = getPro_selDAO();
        pro_selDAO.delete(pro_selT);	 
        setMsg("Exclusao efetuada com sucesso!");
        clear();
      } else {  
	setMsg(ERROR, "Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar exclusao!");	
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      Pro_selDAO pro_selDAO = getPro_selDAO();
      List<Pro_selT> listTemp  = pro_selDAO.getByPK( pro_selT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
    return false;
	
  }

  public void update() throws Exception {
    try {
      if (exist()) {
        Pro_selDAO pro_selDAO = getPro_selDAO();
        pro_selDAO.update(pro_selT);	 
        setMsg("Alteracao efetuada com sucesso!");	
      } else {  
	setMsg(ERROR,"Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar alteracao!");	
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



  //Method Download Image ? montando se houver algum campo do tipo bin?rio
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Pro_selDAO pro_selDAO = getPro_selDAO();
      List<Pro_selT> listTemp  = pro_selDAO.getByPK( pro_selT);	 

      pro_selT= listTemp.size()>0?listTemp.get(0):new Pro_selT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg(ERROR,"Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a p?gina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "pro_selConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "pro_selConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
