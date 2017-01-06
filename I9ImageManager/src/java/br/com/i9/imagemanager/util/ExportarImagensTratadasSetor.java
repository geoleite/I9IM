/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.util;

import br.com.i9.imagemanager.dao.Arq_arquivoDAO;
import br.com.i9.imagemanager.transfer.Arq_arquivoT;
import br.com.jdragon.dao.DAOFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class ExportarImagensTratadasSetor {
    public static void main(String[] param) {
        ThreadExportacao threadExportacao = new ThreadExportacao();
        threadExportacao.start();
        System.out.printf("Arquivo %1s salvo", "FIM");
    }

}

class ThreadExportacao extends Thread {

    public static String url = "jdbc:postgresql://127.0.0.1:5432/i9imagemanager";
    public static String user = "i9im";
    public static String pass = "i9im@)!)";
    private int cont = 0;

    private void salvar(String produto, String nomeArquivo, byte[] arquivo) throws Exception {
        String path = "/tmp/arquivos_tratados";
        File file = new File(path);
        file.mkdirs();
        path = path.concat("/").concat(produto);
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
            con = DriverManager.getConnection(url, user, pass);
            Arq_arquivoDAO arqDao = new Arq_arquivoDAO(DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL, con));
            List<Arq_arquivoT> lista = arqDao.getArquivosTratadosEletro();
            //for (Arq_arquivoT arq_arquivoT : lista) {
            for (int i = 0; i < lista.size(); i++) {
                Arq_arquivoT arq_arquivoT = lista.get(i);
                try {
                    List<Arq_arquivoT> arquivo = arqDao.getByArq_bt_arquivo(arq_arquivoT);
                    if (arquivo.size() > 0) {
                        String codProduto = String.valueOf(arq_arquivoT.getPro_nr_id());
                        String nomeArq = arquivo.get(0).getArq_tx_nome();
                        byte[] arquivoBytes = arquivo.get(0).getArq_bt_arquivo();
                        salvar(codProduto, nomeArq, arquivoBytes);
                        //sleep(100);
                        //System.gc();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
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
}
