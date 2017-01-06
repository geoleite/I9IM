package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Imt_imagemthumbUpdateDeleteJB extends SystemBase {

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
	//
		consultArq_arquivo();

  }

  public void clear() throws Exception {
    
      imt_imagemthumbT = new Imt_imagemthumbT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Imt_imagemthumbDAO imt_imagemthumbDAO = getImt_imagemthumbDAO();
        imt_imagemthumbDAO.delete(imt_imagemthumbT);	 
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
      Imt_imagemthumbDAO imt_imagemthumbDAO = getImt_imagemthumbDAO();
      List<Imt_imagemthumbT> listTemp  = imt_imagemthumbDAO.getByPK( imt_imagemthumbT);	 

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
        Imt_imagemthumbDAO imt_imagemthumbDAO = getImt_imagemthumbDAO();
        imt_imagemthumbDAO.update(imt_imagemthumbT);	 
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
  //
  /**
   * Download de Imagem caso existe sen?o pode remover
   */
  public void downloadImage() throws Exception {

        try {
            findbyid();
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "image/jpg");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, "imt_imagemthumbT.jpg");
            getRequest().setAttribute(EasyDownloadJB.DATA, imt_imagemthumbT.getImt_bt_thumb());
            getPage().forward("easydownload.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }

    }
 


  public void findbyid() throws Exception {
    try {
      Imt_imagemthumbDAO imt_imagemthumbDAO = getImt_imagemthumbDAO();
      List<Imt_imagemthumbT> listTemp  = imt_imagemthumbDAO.getByPK( imt_imagemthumbT);	 

      imt_imagemthumbT= listTemp.size()>0?listTemp.get(0):new Imt_imagemthumbT();
      
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
	  String page = "imt_imagemthumbConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "imt_imagemthumbConsult.jsp";// defina aqui a p?gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
