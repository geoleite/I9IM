/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.jb;

import br.com.i9.imagemanager.dao.Eve_eventoDAO;
import br.com.i9.imagemanager.transfer.Eve_eventoT;
import br.com.i9.imagemanager.transfer.Pro_eveT;
import br.com.i9.imagemanager.util.evento.ImportacaoEvento;
import br.com.i9.imagemanager.util.evento.ReadEventoGBarbosa;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.EventObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author geoleite
 */
public class ImportarEventoJB extends SystemBase {

    private Eve_eventoT eve_eventoT = new Eve_eventoT();
    private Eve_eventoDAO eveDao;

    public void pageLoad() {
        try {
            eveDao = getEve_eventoDAO();
        } catch (Exception ex) {
            Logger.getLogger(ImportarEventoJB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String getNomeEvento() {
        try {
            Eve_eventoT eveT = new Eve_eventoT();
            eveT.setEve_nr_id(eve_eventoT.getEve_nr_id());
            //List<Eve_eventoT> listEve = getEve_eventoDAO().getByPK(eveT);
            List<Eve_eventoT> listEve = eveDao.getByPK(eveT);
            eveT = listEve.size() > 0 ? listEve.get(0) : new Eve_eventoT();
            return eveT.getEve_tx_nome();
        } catch (Exception e) {
        }
        return "";
    }

    private String saveArquivoImportavao() throws Exception {
        File file = new File(PASTA_BASE.concat(getNomeEvento().concat(".txt")) );
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(eve_eventoT.getArquivoImportacao());
        fos.flush();
        fos.close();
        return file.getPath();
    }

    private void deleteProdutosEvento() throws Exception {
        Pro_eveT peT = new Pro_eveT();
        peT.setEve_nr_id(eve_eventoT.getEve_nr_id());
        getPro_eveDAO().deleteProdutosByEvento(peT);
    }

    /**
     * Método chamado pelo GWT
     */
    public void importar() {
        try {
            String nomeArquivo = saveArquivoImportavao();
            ImportacaoEvento importacaoEvento = new ImportacaoEvento();
            importacaoEvento.setEveNrId(eve_eventoT.getEve_nr_id());
            importacaoEvento.setPeDao(getPro_eveDAO());
            importacaoEvento.setProDao(getPro_produtoDAO());
            //ReadEventoGBarbosa evento = new ReadEventoGBarbosa(nomeArquivo);
//            evento.setEve_eventoT(eve_eventoT);
//            evento.setProEveDao(getPro_eveDAO());

//            evento.setEveDao(getEve_eventoDAO());
//            evento.setProEveDao(getPro_eveDAO());
            // Excluir os produtos atuais do evento
            deleteProdutosEvento();
            // Inicia a importacao do evento
            //evento.start();
            importacaoEvento.lerArquivo(nomeArquivo);
            setMsg("Importacao realizada com sucesso!");
            // Define uma data retroativa para poder exportar todas as imagens dos produtos
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            eve_eventoT.setEve_dt_criacao(new Timestamp(sdf.parse("01/01/2009").getTime()));
            close();
            getEve_eventoDAO().updateDataCriacao(eve_eventoT);

            //getDAO().getConnection().commit();
        } catch (Exception ex) {
            setMsg("Falha ao importar evento: ".concat(ex.getMessage()));
            Logger.getLogger(ImportarEventoJB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }

    }

    /**
     * @return the eve_eventoT
     */
    public Eve_eventoT getEve_eventoT() {
        return eve_eventoT;
    }

    /**
     * @param eve_eventoT the eve_eventoT to set
     */
    public void setEve_eventoT(Eve_eventoT eve_eventoT) {
        this.eve_eventoT = eve_eventoT;
    }
}
