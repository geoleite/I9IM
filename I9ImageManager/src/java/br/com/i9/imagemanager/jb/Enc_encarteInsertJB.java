package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Enc_encarteInsertJB extends SystemBase {

  // Atributos e propriedades
    private Enc_encarteT enc_encarteT = new Enc_encarteT();

  public void setEnc_encarteT(Enc_encarteT enc_encarteT) {
    this.enc_encarteT = enc_encarteT;
  }

  public Enc_encarteT getEnc_encarteT() {	
    return enc_encarteT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
  }

  // M?todos de Eventos
  public void insert() throws Exception {
    
    try {
      Enc_encarteDAO enc_encarteDAO =  getEnc_encarteDAO();
      enc_encarteDAO.insert(enc_encarteT);	 
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

  
  public void clear() throws Exception {
    
      enc_encarteT = new Enc_encarteT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "enc_encarteConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
