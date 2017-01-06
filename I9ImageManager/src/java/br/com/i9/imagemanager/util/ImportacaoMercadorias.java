/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * br.com.i9.imagemanager.util.ImportacaoMercadorias
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
public class ImportacaoMercadorias {

    private Properties properties = new Properties();
    private Set_setorNewDAO setDao;
    private Pro_produtoDAO proDao;

    public static void main(String[] param) {
        ImportacaoMercadorias importacaoMercadorias = new ImportacaoMercadorias();
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
        proT.setPro_nr_idantigo(Integer.parseInt(dadosMercadoria[3]));
        proT.setPro_nr_valor(0);
        proT.setPro_tx_nome(dadosMercadoria[2]);
        proT.setPro_tx_obs("");
        proT.setPro_tx_idsap(dadosMercadoria[1]);
        Set_setorNewT setT = getSetor(dadosMercadoria[1]);
        if (setT == null) {
            System.out.println("Setor inexistente " + dadosMercadoria[1] + " " + proT.getPro_tx_nome());
        } else {
            proT.setPro_tx_situacao("A");
            proT.setSet_nr_id(setT.getSet_nr_id());
            List<Pro_produtoT> listPro = proDao.getByPK(proT);
            if (listPro.size() > 0) {
                proDao.update(proT);
            } else {
                proDao.insert(proT);
            }
        }
    }

    private void lerLinha(String linha) {
        if (linha != null && !linha.isEmpty()) {
            String[] campos = linha.split("	");
            if (campos.length == 8) {
                try {
                    String codSap = campos[1];
                    String codEstrutura = campos[3];
                    String descMercadoria = campos[4];
                    String codAntigo = campos[7];
                    String[] dadosMercadoria = {codSap, codEstrutura, descMercadoria, codAntigo};
                    lerMercadoria(dadosMercadoria);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void lerArquivo() {
        try {
            properties.load(new FileInputStream("config.properties"));
            String path = properties.getProperty("path");
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
            setDao.close();
        }
    }
}
