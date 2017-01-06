package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Obe_observacaoexclusaoUpdateDeleteJB extends SystemBase {

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
	//
		consultArq_arquivo();

  }

  public void clear() throws Exception {
    
      obe_observacaoexclusaoT = new Obe_observacaoexclusaoT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Obe_observacaoexclusaoDAO obe_observacaoexclusaoDAO = getObe_observacaoexclusaoDAO();
        obe_observacaoexclusaoDAO.delete(obe_observacaoexclusaoT);	 
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
      Obe_observacaoexclusaoDAO obe_observacaoexclusaoDAO = getObe_observacaoexclusaoDAO();
      List<Obe_observacaoexclusaoT> listTemp  = obe_observacaoexclusaoDAO.getByPK( obe_observacaoexclusaoT);	 

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
        Obe_observacaoexclusaoDAO obe_observacaoexclusaoDAO = getObe_observacaoexclusaoDAO();
        obe_observacaoexclusaoDAO.update(obe_observacaoexclusaoT);	 
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
	private List<Arq_arquivoT> listarq_arquivo;
	public List<Arq_arquivoT> getListarq_arquivo() {
		return listarq_arquivo;
	}

	 public void setListarq_arquivo(List<Arq_arquivoT> list) {
		this.listarq_arquivo=list;
	}
	public void consultArq_arquivo() throws Exception {
		try {
			Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();
			listarq_arquivo=arq_arquivoDAO.getAll();
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
      Obe_observacaoexclusaoDAO obe_observacaoexclusaoDAO = getObe_observacaoexclusaoDAO();
      List<Obe_observacaoexclusaoT> listTemp  = obe_observacaoexclusaoDAO.getByPK( obe_observacaoexclusaoT);	 

      obe_observacaoexclusaoT= listTemp.size()>0?listTemp.get(0):new Obe_observacaoexclusaoT();
      
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
	  String page = "obe_observacaoexclusaoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "obe_observacaoexclusaoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
