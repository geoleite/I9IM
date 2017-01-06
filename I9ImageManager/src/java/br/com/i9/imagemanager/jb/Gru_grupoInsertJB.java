package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Gru_grupoInsertJB extends SystemBase {

  // Atributos e propriedades
    private Gru_grupoT gru_grupoT = new Gru_grupoT();

  public void setGru_grupoT(Gru_grupoT gru_grupoT) {
    this.gru_grupoT = gru_grupoT;
  }

  public Gru_grupoT getGru_grupoT() {	
    return gru_grupoT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultSes_sessao();

  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Gru_grupoDAO gru_grupoDAO =  getGru_grupoDAO();
      gru_grupoDAO.insert(gru_grupoT);	 
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
	private List<Ses_sessaoT> listses_sessao;
	public List<Ses_sessaoT> getListses_sessao() {
		return listses_sessao;
	}

	 public void setListses_sessao(List<Ses_sessaoT> list) {
		this.listses_sessao=list;
	}
	public void consultSes_sessao() throws Exception {
		try {
			Ses_sessaoDAO ses_sessaoDAO = getSes_sessaoDAO();
			listses_sessao=ses_sessaoDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}


  
  public void clear() throws Exception {
    
      gru_grupoT = new Gru_grupoT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "gru_grupoConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
