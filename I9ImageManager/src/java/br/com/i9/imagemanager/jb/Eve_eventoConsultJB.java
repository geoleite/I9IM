package br.com.i9.imagemanager.jb;

import java.util.List;
import br.com.i9.imagemanager.dao.*;
import br.com.i9.imagemanager.transfer.*;
import java.util.Calendar;
import java.util.Date;
import java.util.TreeMap;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Eve_eventoConsultJB extends SystemBase {

    // Atributos e propriedades
    private Eve_eventoT eve_eventoT = new Eve_eventoT();
    private TreeMap<Integer, String> gerarNovaOnda = new TreeMap<Integer, String>();

    public void setEve_eventoT(Eve_eventoT eve_eventoT) {
        this.eve_eventoT = eve_eventoT;
    }

    public Eve_eventoT getEve_eventoT() {
        return eve_eventoT;
    }
    private List<Eve_eventoT> list;

    public List<Eve_eventoT> getList() {
        return list;
    }

    public void setList(List<Eve_eventoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //consult();
    }

    private void consultarSituacaoOndasEventos() {
        try {
            List<Eve_eventoT> listEveModificados = getEve_eventoDAO().getAllEventosModificados();
            for (Eve_eventoT eve_eventoT : listEveModificados) {
                gerarNovaOnda.put(eve_eventoT.getEve_nr_id(), "S");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void consult() throws Exception {
        try {
            consultarSituacaoOndasEventos();
            Eve_eventoDAO eve_eventoDAO = getEve_eventoDAO();
            list = eve_eventoDAO.getAll();
            
            Calendar cal = Calendar.getInstance();
            Date dtAtual = new Date();

            for (Eve_eventoT eve_eventoT : list) {
                cal.setTime(eve_eventoT.getEve_dt_fim());
                cal.add(Calendar.DAY_OF_MONTH, 3);
                if (dtAtual.after(cal.getTime())) {
                    eve_eventoT.setEve_tx_status("I");
                    eve_eventoDAO.updateStatus(eve_eventoT);
                    list.remove(eve_eventoT);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultByNome() throws Exception {
        try {
            consultarSituacaoOndasEventos();
            Eve_eventoDAO eve_eventoDAO = getEve_eventoDAO();
            list = eve_eventoDAO.getByEve_tx_nome(eve_eventoT);

            Calendar cal = Calendar.getInstance();
            Date dtAtual = new Date();

            //for (Eve_eventoT eve_eventoT : list) {
            for (int i = 0; i < list.size(); i++) {
                Eve_eventoT eve_eventoT = list.get(i);
                cal.setTime(eve_eventoT.getEve_dt_fim());
                cal.add(Calendar.DAY_OF_MONTH, 3);
                if (dtAtual.after(cal.getTime())) {
                    eve_eventoT.setEve_tx_status("I");
                    eve_eventoDAO.updateStatus(eve_eventoT);
                    list.remove(eve_eventoT);                    
                } else {
                    if (!gerarNovaOnda.containsKey(eve_eventoT.getEve_nr_id())) {
                        gerarNovaOnda.put(eve_eventoT.getEve_nr_id(), "S");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Eve_eventoDAO eve_eventoDAO = getEve_eventoDAO();
            eve_eventoDAO.delete(eve_eventoT);
            setMsg("Exclusao efetuada com sucesso!");
            eve_eventoT = new Eve_eventoT();
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar exclusao!");
        } finally {
            close();
        }
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "eve_eventoInsert.jsp";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "";// defina aqui a p?gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the gerarNovaOnda
     */
    public TreeMap<Integer, String> getGerarNovaOnda() {
        return gerarNovaOnda;
    }

    /**
     * @param gerarNovaOnda the gerarNovaOnda to set
     */
    public void setGerarNovaOnda(TreeMap<Integer, String> gerarNovaOnda) {
        this.gerarNovaOnda = gerarNovaOnda;
    }
}
