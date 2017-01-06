/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.imagemanager.util;

import br.com.i9.imagemanager.dao.Pro_produtoDAO;
import br.com.i9.imagemanager.dao.Set_setorNewDAO;
import br.com.i9.imagemanager.transfer.Pro_produtoT;
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
public class ImportacaoMercadorias2012_04_16 {

    private Properties properties = new Properties();
    private Set_setorNewDAO setDao;
    private Pro_produtoDAO proDao;

    public static void main(String[] param) {
        ImportacaoMercadorias2012_04_16 importacaoMercadorias = new ImportacaoMercadorias2012_04_16();
        importacaoMercadorias.lerArquivo();
    }

    private void createConnection() throws Exception {
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String pass = properties.getProperty("pass");
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, pass);
        DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL, con);
        setDao = new Set_setorNewDAO(dao);
        proDao = new Pro_produtoDAO(dao);
    }

    private Set_setorNewT getSetor(String setTxIdSap) throws Exception {
        Set_setorNewT setT = new Set_setorNewT();
        setT.setSet_tx_idsap(setTxIdSap);
        List<Set_setorNewT> listSet = setDao.getBySet_tx_idsap(setT);
        return listSet.size() > 0 ? listSet.get(0) : null;
    }

    private void lerMercadoria(String[] dadosMercadoria) throws Exception {
        Pro_produtoT proT = new Pro_produtoT();
        proT.setPro_dt_atualizacao(new Date());
        proT.setPro_nr_cdfamilia(0);
        proT.setPro_nr_id(Integer.parseInt(dadosMercadoria[0]));
        proT.setPro_nr_idantigo(0);
        proT.setPro_nr_valor(0);
        proT.setPro_tx_nome(dadosMercadoria[2]);
        proT.setPro_tx_obs("");
        proT.setPro_tx_idsap("");
        Set_setorNewT setT = getSetor(dadosMercadoria[1]);
        if (setT == null) {
            System.out.println("Setor inexistente " + dadosMercadoria[1] + " produto: " + proT.getPro_nr_id() + " " + proT.getPro_tx_nome());
        } else {
            proT.setPro_tx_situacao("A");
            proT.setSet_nr_id(setT.getSet_nr_id());
            List<Pro_produtoT> listPro = proDao.getByPK(proT);
            if (listPro.size() > 0) {
                proDao.updateParcial(proT);
            } else {
                proDao.insert(proT);
            }
        }
    }

    private void lerLinha(String linha) {
        if (linha != null && !linha.isEmpty()) {
            String[] campos = linha.split(";");
            if (campos.length >= 3) {
                try {
                    try {
                        Long.parseLong(campos[0]);
                    } catch (Exception e) {
                        return;
                    }
                    String codSap = campos[0];
                    String codEstrutura = campos[1];
                    String descMercadoria = campos[2];
                    //String codAntigo = campos[7];
                    String[] dadosMercadoria = {codSap, codEstrutura, descMercadoria.trim()};
                    lerMercadoria(dadosMercadoria);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void lerArquivo() {
        try {
//            properties.load(new FileInputStream("config_2012_04_16.properties"));
            properties.load(new FileInputStream("config.properties"));
            String path = properties.getProperty("path");
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            //createConnection();
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
            setDao.close();
        }
    }
}
