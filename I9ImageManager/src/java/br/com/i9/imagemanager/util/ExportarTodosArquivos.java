/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.util;

import br.com.i9.imagemanager.dao.Arq_arquivoDAO;
import br.com.i9.imagemanager.dao.Set_setorDAO;
import br.com.i9.imagemanager.transfer.Arq_arquivoT;
import br.com.i9.imagemanager.transfer.Set_setorT;
import br.com.jdragon.dao.DAOFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author geoleite
 */
public class ExportarTodosArquivos {

    public static String url = "jdbc:postgresql://127.0.0.1:5432/i9imagemanager";
    public static String user = "i9im";
    public static String pass = "i9im@)!)";
    //public static String user = "postgres";
    //  public static String pass = "postgres";

    public static void main(String[] param) {

        //int codigoSetor = Integer.parseInt(param[0]);
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(ExportarTodosArquivos.url, ExportarTodosArquivos.user, ExportarTodosArquivos.pass);
            Set_setorDAO setDao = new Set_setorDAO(DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL, con));
            List<Set_setorT> lista = setDao.getAll();
        for (Set_setorT set_setorT : lista) {
                ThreadExportacaoTodasImagensSetor threadExportacao = new ThreadExportacaoTodasImagensSetor();
                int codigoSetor = set_setorT.getSet_nr_id();
                threadExportacao.setSet_nr_id(codigoSetor);
                threadExportacao.start();
                System.out.printf("Arquivo %1s salvo", "FIM");

            }
        } catch (Exception e) {
            try {
                con.close();
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(ExportarTodosArquivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class ThreadExportacaoTodasImagensSetor extends Thread {

    private int cont = 0;
    private int set_nr_id;

    private void salvar(String classificacao, String produto, String nomeArquivo, byte[] arquivo) throws Exception {
        String path = "/media/hd_externo/arquivos_todos/";
        File file = new File(path);
        file.mkdirs();
        path = path.concat("/").concat(produto).concat("/").concat(classificacao);
        file = new File(path);
        file.mkdirs();
        FileOutputStream fos = new FileOutputStream(path.concat("/").concat(nomeArquivo));
        fos.write(arquivo);
        fos.flush();
        fos.close();
        System.out.println("Arquivo " + produto + " " + nomeArquivo + " " + ++cont);
    }

    public void run() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(ExportarTodosArquivos.url, ExportarTodosArquivos.user, ExportarTodosArquivos.pass);
            Arq_arquivoDAO arqDao = new Arq_arquivoDAO(DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL, con));
            List<Arq_arquivoT> lista = arqDao.getArquivosSetor(getSet_nr_id());
            //for (Arq_arquivoT arq_arquivoT : lista) {
            Arq_arquivoT arq_arquivoT = null;
            for (int i = 0; i < lista.size(); i++) {
                arq_arquivoT = lista.get(i);
                System.out.println("Preparando copiar " + arq_arquivoT.getPro_nr_id());
                try {
                    List<Arq_arquivoT> arquivo = arqDao.getByArq_bt_arquivo(arq_arquivoT);
                    if (arquivo.size() > 0) {
                        String codProduto = String.valueOf(arq_arquivoT.getPro_nr_id());
                        String nomeArq = arq_arquivoT.getArq_tx_nome();
                        byte[] arquivoBytes = arquivo.get(0).getArq_bt_arquivo();
                        String classificacao = "tratada";
                        switch (arq_arquivoT.getCla_nr_id()) {
                            case 1:
                                classificacao = "bruta";
                                break;
                            case 2:
                                classificacao = "tratada";
                                break;
                            case 3:
                                classificacao = "web";
                                break;
                        }
                        salvar(classificacao, codProduto, nomeArq, arquivoBytes);
                        sleep(100);
                        System.gc();
                    }
                } catch (Exception e) {
                    System.out.println("erro: " + e.getMessage() + " (" + arq_arquivoT.getArq_nr_id() + " " + arq_arquivoT.getArq_tx_nome());
                    //e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }

        }

    }

    /**
     * @return the set_nr_id
     */
    public int getSet_nr_id() {
        return set_nr_id;
    }

    /**
     * @param set_nr_id the set_nr_id to set
     */
    public void setSet_nr_id(int set_nr_id) {
        this.set_nr_id = set_nr_id;
    }
}
