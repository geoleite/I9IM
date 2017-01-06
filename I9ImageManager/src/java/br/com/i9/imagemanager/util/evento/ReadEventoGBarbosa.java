/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.util.evento;

import br.com.i9.imagemanager.dao.Eve_eventoDAO;
import br.com.i9.imagemanager.dao.Pro_eveDAO;
import br.com.i9.imagemanager.dao.Pro_produtoDAO;
import br.com.i9.imagemanager.jb.SystemBase;
import br.com.i9.imagemanager.transfer.Eve_eventoT;
import br.com.i9.imagemanager.transfer.Pro_eveT;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class ReadEventoGBarbosa {

    private String arquivo;
    private Eve_eventoDAO eveDao;
    private Pro_eveDAO proEveDao;
    private Pro_produtoDAO proDao;
    private Eve_eventoT eve_eventoT;

    public ReadEventoGBarbosa(String arquivo) {
        setArquivo(arquivo);
    }

    /**
     * Processa as 2 primeiras linhas do arquivo txt de evento
     * @param linha
     * @throws Exception
     */
    private void processarLinhaEvento(String linha1, String linha2) throws Exception {
        String[] ln1 = linha1.split(":");
        String[] ln2 = linha2.split(":");
        String[] datas = ln2[1].split("a");// oobtendo o periodo da vigencia

        Eve_eventoT eveT = new Eve_eventoT();
        eveT.setEve_tx_nome(ln1[1]);// Obtendo o nome do evento

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dtInicio = sdf.parse(datas[0].trim());
        Date dtFim = sdf.parse(datas[1].trim());
        eveT.setEve_dt_inicio(new Timestamp(dtInicio.getTime()));
        eveT.setEve_dt_fim(new Timestamp(dtFim.getTime()));

        eveT.setEve_dt_criacao(new Timestamp(System.currentTimeMillis()));
        List<Eve_eventoT> list = getEveDao().getByNomePeriodo(eveT);
        if (list.size() > 0) {
            eveT = list.get(0);
        } else {
            getEveDao().insert(eveT);
        }
        setEve_eventoT(eveT);
    }

    /**
     * Obtém os dados da linha onde deve estar os produtos
     * @param linha
     * @throws Exception
     */
    private void processarLinha(String linha) throws Exception {
        try {
            int codigo = getCodigoProduto(linha);
            Pro_eveT proEveT = new Pro_eveT();
            proEveT.setEve_nr_id(getEve_eventoT().getEve_nr_id());
            proEveT.setPro_nr_id(codigo);
            List<Pro_eveT> listTemp = getProEveDao().getByPK(proEveT);
            if (listTemp.size() == 0) {
                getProEveDao().insert(proEveT);
            }
            
        } catch (Exception e) {
            //e.printStackTrace();
            System.err.println("Erro! Esta Linha não contem um produto: " + linha + " " + e.getMessage());
        }
    }

    /**
     * Obtém o código do produto
     * @param linha
     * @return
     * @throws Exception
     */
    private int getCodigoProduto(String linha) throws Exception {
        String codigo = linha.substring(0, 6);
        int proNrId = Integer.parseInt(codigo.trim());
        proNrId = proDao.getByIdSapAntigoId(proNrId);
        return proNrId;
    }

    /**
     * Inicia processo de leitura
     * @throws Exception
     */
    public void start() throws Exception {
        SystemBase sb = new SystemBase();
        BufferedReader br = null;
        try {
            if (eveDao == null) {
                setEveDao(sb.getEve_eventoDAO());
            }
            if (proEveDao == null) {
                setProEveDao(sb.getPro_eveDAO());
            }
            if (proDao == null) {
                proDao = sb.getPro_produtoDAO();
            }
            FileReader fr = new FileReader(arquivo);
            br = new BufferedReader(fr);
            if (br.ready()) { // lendo os dados do evento
                String linha1 = br.readLine();
                String linha2 = br.readLine();
                if (eve_eventoT == null || eve_eventoT.getEve_nr_id() == 0) {
                    processarLinhaEvento(linha1, linha2);
                }
            }
            while (br.ready()) {// carrega os produtos do evento
                String linha = br.readLine();
                processarLinha(linha);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                //sb.close();
                //br.close();
            } catch (Exception e) {
            }

        }
    }

    public static void main(String[] p) {
        try {
            ReadEventoGBarbosa evento = new ReadEventoGBarbosa("evento.txt");
            evento.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * @return the arquivo
     */
    public String getArquivo() {
        return arquivo;
    }

    /**
     * @param arquivo the arquivo to set
     */
    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
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

    /**
     * @return the eveDao
     */
    public Eve_eventoDAO getEveDao() {
        return eveDao;
    }

    /**
     * @param eveDao the eveDao to set
     */
    public void setEveDao(Eve_eventoDAO eveDao) {
        this.eveDao = eveDao;
    }

    /**
     * @return the proEveDao
     */
    public Pro_eveDAO getProEveDao() {
        return proEveDao;
    }

    /**
     * @param proEveDao the proEveDao to set
     */
    public void setProEveDao(Pro_eveDAO proEveDao) {
        this.proEveDao = proEveDao;
    }
}
