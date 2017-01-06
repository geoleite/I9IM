/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * br.com.i9.imagemanager.util.ImportacaoMercadorias
 */
package br.com.i9.imagemanager.util.evento;

import br.com.i9.imagemanager.util.*;
import br.com.i9.imagemanager.dao.Pro_eveDAO;
import br.com.i9.imagemanager.dao.Pro_produtoDAO;
import br.com.i9.imagemanager.dao.Set_setorNewDAO;
import br.com.i9.imagemanager.transfer.Pro_eveT;
import br.com.i9.imagemanager.transfer.Set_setorNewT;
import br.com.jdragon.dao.DAOFactory;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author geoleite
 */
public class ImportacaoEvento {

    private Properties properties = new Properties();
    private int eveNrId;
    private Pro_eveDAO peDao;
    private Pro_produtoDAO proDao;

    private void createConnection() throws Exception {
//        String driver = properties.getProperty("driver");
//        String url = properties.getProperty("url");
//        String user = properties.getProperty("user");
//        String pass = properties.getProperty("pass");
//        Class.forName(driver);
//        Connection con = DriverManager.getConnection(url, user, pass);
//        DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL, con);
//        setPeDao(new Pro_eveDAO(dao));
    }

    private void lerMercadoria(String[] dadosMercadoria) throws Exception {
        Pro_eveT peT = new Pro_eveT();
        peT.setPro_nr_id(Integer.parseInt(dadosMercadoria[0]));
        peT.setEve_nr_id(eveNrId);
        peDao.insert(peT);
    }

    private void lerLinha(String linha) {
        if (linha != null && !linha.isEmpty()) {
            String[] campos = linha.split(";");
            if (campos.length > 0) {
                try {

                    String codSap = campos[0];
                    //String codEstrutura = campos[3];
                    //String descMercadoria = campos[4];
                    //String codAntigo = campos[7];
                    System.out.println("Cod produto " + codSap);
                    String[] dadosMercadoria = {codSap};//, codEstrutura, descMercadoria, codAntigo};

                    lerMercadoria(dadosMercadoria);
                } catch (Exception e) {
                    System.out.println("ATENCAO " + e.getMessage());
                }
            }
//            if (campos.length == 2) {
//                try {
//                String codSap = campos[0];
//                //String codEstrutura = campos[3];
//                //String descMercadoria = campos[4];
//                //String codAntigo = campos[7];
//                System.out.println("Cod sap " + codSap);
//                String[] dadosMercadoria = {codSap};//, codEstrutura, descMercadoria, codAntigo};
//
//                lerMercadoria(dadosMercadoria);
//                } catch (Exception e) {
//                    System.out.println("ATENCAO " + e.getMessage());
//                }
//            } else if (campos.length == 10) {
//                try {
//                    String codSap = campos[1];
//                    //String codEstrutura = campos[3];
//                    //String descMercadoria = campos[4];
//                    //String codAntigo = campos[7];
//                    System.out.println("Cod sap " + codSap);
//                    String[] dadosMercadoria = {codSap};//, codEstrutura, descMercadoria, codAntigo};
//
//                    lerMercadoria(dadosMercadoria);
//                } catch (Exception e) {
//                    System.out.println("ATENCAO " + e.getMessage());
//                    //e.printStackTrace();
//                }
//            } else if (linha.trim().length() > 7) {
//                try {
//
//                    // Tetando ler no formato antigo
//                    String codAntigo = linha.substring(0, 7).trim();
//                    int codigo = Integer.parseInt(codAntigo);
//                    int codSap = proDao.getByIdSapAntigoId(codigo);
//                    if (codSap > 0) {
//                        String[] dadosMercadoria = {String.valueOf(codSap)};
//                        lerMercadoria(dadosMercadoria);
//                        System.out.println(codAntigo);
//                    }
//                } catch (Exception e) {
//                }
//            }
        }
    }

    public void lerArquivo(String nomeArquivo) {
        try {
            //properties.load(new FileInputStream("config.properties"));
            String path = nomeArquivo;// properties.getProperty("path");
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            createConnection();
            while (br.ready()) {
                String linha = br.readLine();
                if (!linha.trim().isEmpty()) {
                    lerLinha(linha);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getPeDao().close();
        }
    }

    /**
     * @return the eveNrId
     */
    public int getEveNrId() {
        return eveNrId;
    }

    /**
     * @param eveNrId the eveNrId to set
     */
    public void setEveNrId(int eveNrId) {
        this.eveNrId = eveNrId;
    }

    /**
     * @return the peDao
     */
    public Pro_eveDAO getPeDao() {
        return peDao;
    }

    /**
     * @param peDao the peDao to set
     */
    public void setPeDao(Pro_eveDAO peDao) {
        this.peDao = peDao;
    }

    /**
     * @return the proDao
     */
    public Pro_produtoDAO getProDao() {
        return proDao;
    }

    /**
     * @param proDao the proDao to set
     */
    public void setProDao(Pro_produtoDAO proDao) {
        this.proDao = proDao;
    }
}
