/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.util;

import br.com.i9.imagemanager.dao.Arq_arquivoDAO;
import br.com.i9.imagemanager.transfer.Arq_arquivoT;
import br.com.jdragon.dao.DAOFactory;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author geoleite
 */
public class ArquivosSemImagem {

    private Properties properties = new Properties();
    private Arq_arquivoDAO arqDao;

    public static void main(String[] param) {
        ArquivosSemImagem arqsi = new ArquivosSemImagem();
        arqsi.iniciar(param[0]);
    }

    private void createConnection() throws Exception {
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String pass = properties.getProperty("pass");
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, pass);
        DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL, con);
        arqDao = new Arq_arquivoDAO(dao);
    }

    private void navegar(File file) throws Exception {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                File file1 = files[i];
                navegar(file1);
            }
        } else {
            consultaArq(Integer.parseInt(file.getName()));
        }
    }
    private void consultaArq(int codigoArq) throws Exception {
        Arq_arquivoT arqT = new Arq_arquivoT();
        arqT.setArq_nr_id(codigoArq);

        if (arqDao.getByArq_nr_id(arqT).size() == 0) {
            System.out.println(codigoArq);
        }
    }

    public void iniciar(String pathBase) {
        try {
            properties.load(new FileInputStream("config.properties"));
            String path = "/opt/i9im/arq_arquivo";
            createConnection();
            File fileBase = new File(pathBase);
            navegar(fileBase);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
