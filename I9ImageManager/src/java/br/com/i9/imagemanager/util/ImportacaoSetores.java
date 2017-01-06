/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * br.com.i9.imagemanager.util.ImportacaoSetores
 */
package br.com.i9.imagemanager.util;

import br.com.i9.imagemanager.dao.Set_setorNewDAO;
import br.com.i9.imagemanager.transfer.Set_setorNewT;
import br.com.jdragon.dao.DAOFactory;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author geoleite
 */
public class ImportacaoSetores {

    private Properties properties = new Properties();
    private Set_setorNewDAO setDao;

    public static void main(String[] p) {
        try {
            ImportacaoSetores importacaoSetores = new ImportacaoSetores();
            importacaoSetores.lerArquivo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Set_setorNewT getSetor(String setTxIdSap) throws Exception {
        Set_setorNewT setT = new Set_setorNewT();
        setT.setSet_tx_idsap(setTxIdSap);
        List<Set_setorNewT> listSet = setDao.getBySet_tx_idsap(setT);
        return listSet.size()>0?listSet.get(0):null;
    }

    private void insertUpdateSetor(Set_setorNewT setT) throws Exception {
        if (getSetor(setT.getSet_tx_idsap()) == null) {
            setDao.insertImportacao(setT);
        } else {
            setDao.update(setT);
        }
    }

    private void lerSetor(String[] codigoNome) throws Exception  {
        String txSetNrId = codigoNome[0];
        String setTxNome = codigoNome[1];
        Set_setorNewT setT = new Set_setorNewT();
        if (txSetNrId.length() == 2) {//Nível 0
            int setNrId = Integer.parseInt(txSetNrId);
            setT.setSet_tx_idsap(txSetNrId);
            setT.setSet_nr_idsetorpai(0);
            setT.setSet_tx_visivel("S");
        } else if (txSetNrId.length() == 4) {//Nível 1
            String setNrIdPai = txSetNrId.substring(0, 2);
            Set_setorNewT setTPai = getSetor(setNrIdPai);
            setT.setSet_nr_idsetorpai(setTPai.getSet_nr_id());
            setT.setSet_tx_idsap(txSetNrId);
            setT.setSet_tx_visivel("S");
        } else if (txSetNrId.length() == 6) {//Nível 2
            String setNrIdPai = txSetNrId.substring(0, 4);
            Set_setorNewT setTPai = getSetor(setNrIdPai);
            setT.setSet_nr_idsetorpai(setTPai.getSet_nr_id());
            setT.setSet_tx_idsap(txSetNrId);
            setT.setSet_tx_visivel("N");
        } else if (txSetNrId.length() == 9) {//Nível 3
            String setNrIdPai = txSetNrId.substring(0, 6);
            Set_setorNewT setTPai = getSetor(setNrIdPai);
            setT.setSet_nr_idsetorpai(setTPai.getSet_nr_id());
            setT.setSet_tx_idsap(txSetNrId);
            setT.setSet_tx_visivel("N");
        } else {
            return;
        }
        setT.setSet_tx_nome(setTxNome.replaceAll("SECAO ", "").replaceAll("GRUPO", "").replaceAll("SUBGRUPO", "").trim());
        setT.setSet_tx_status("A");
        //setT.setSet_tx_visivel("S");
        setT.setEmp_nr_id(1);
        insertUpdateSetor(setT);
    }

    private void lerLinha(String linha) {
        if (linha != null && !linha.isEmpty()) {
            String[] campos = linha.split(";");
            if (campos.length == 9) {
                try {
                    int cont = 0;
                    for (int i = 0; i < campos.length-1; i+=2) {
                        String[] setor = {campos[i], campos[i+1]};
                        lerSetor(setor);
                    }
                } catch (Exception e) {
                    System.out.println("mudanca na estrutura " + e.getMessage() + " " + campos.length);
                }
            }
        }
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
    }

    private void lerArquivo() {
        try {
            properties.load(new FileInputStream("config.properties"));
            String path = properties.getProperty("pathEstrutura");
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            createConnection();
            while (br.ready()) {
                String linha = br.readLine();
                lerLinha(linha);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            setDao.close();
        }
    }
}
