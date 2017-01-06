package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Obe_observacaoexclusaoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Obe_observacaoexclusaoT obe_observacaoexclusaoT = new Obe_observacaoexclusaoT();

  public void setObe_observacaoexclusaoT(Obe_observacaoexclusaoT obe_observacaoexclusaoT) {
    this.obe_observacaoexclusaoT = obe_observacaoexclusaoT;
  }

  public Obe_observacaoexclusaoT getObe_observacaoexclusaoT() {	
    return obe_observacaoexclusaoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultArq_arquivo();

  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Obe_observacaoexclusaoDAO obe_observacaoexclusaoDAO =  getObe_observacaoexclusaoDAO();
      obe_observacaoexclusaoDAO.insert(obe_observacaoexclusaoT);	 
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


  
  public void clear() throws Exception {
    
      obe_observacaoexclusaoT = new Obe_observacaoexclusaoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "obe_observacaoexclusaoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}