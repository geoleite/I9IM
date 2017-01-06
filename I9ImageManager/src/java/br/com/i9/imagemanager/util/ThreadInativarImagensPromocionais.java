/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.util;

import br.com.i9.imagemanager.dao.Arq_arquivoDAO;
import br.com.i9.imagemanager.dao.Sel_seloDAO;
import br.com.i9.imagemanager.jb.SystemBase;
import br.com.i9.imagemanager.transfer.Arq_arquivoT;
import br.com.i9.imagemanager.transfer.Sel_seloT;
import br.com.jdragon.dao.DAOFactory;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class ThreadInativarImagensPromocionais extends Thread {

    private SystemBase sbI9IM = new SystemBase();
    private Arq_arquivoDAO arqDAO;
    private Sel_seloDAO selDAO;
    private long tempoDormindo = 43200000;// Tempo de chacagem 12 horas

    private void checandoImagens() throws Exception {
        arqDAO = new Arq_arquivoDAO(getDAO());
        List<Arq_arquivoT> listArq = getArquivosPromocionaisForaVigencia();
        for (Arq_arquivoT arq_arquivoT : listArq) {
            arq_arquivoT.setArq_tx_situacao("E");
            arqDAO.update(arq_arquivoT);
        }

    }

    private void checandoSelos() throws Exception {
        selDAO = new Sel_seloDAO(getDAO());
        List<Sel_seloT> listSel = getSelosPromocionaisForaVigencia();
        for (Sel_seloT sel_seloT : listSel) {
            sel_seloT.setSel_tx_situacao("E");
            selDAO.update(sel_seloT);
        }

    }

    public void run() {
        for (;;) {
            try {
                System.out.println("Procurando Imagens fora da vigencia");
                checandoImagens();
                System.out.println("Procurando Selos fora da vigencia");
                checandoSelos();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    sleep(tempoDormindo);
                } catch (Exception e) {
                }
            }
        }

    }

    private DAOFactory getDAO() throws Exception {
        return sbI9IM.getDAO(sbI9IM.typeDatabase, sbI9IM.url, sbI9IM.user, sbI9IM.pass);
    }

    private List<Arq_arquivoT> getArquivosPromocionaisForaVigencia() throws Exception {
        return arqDAO.getAllPromocionaisForaVigencia();
    }

    private List<Sel_seloT> getSelosPromocionaisForaVigencia() throws Exception {
        return selDAO.getAllPromocionaisForaVigencia();
    }

}
