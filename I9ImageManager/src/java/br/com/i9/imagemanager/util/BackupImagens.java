/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.util;

import br.com.i9.imagemanager.dao.Arq_arquivoDAO;
import br.com.i9.imagemanager.dao.Cla_classificacaoDAO;
import br.com.i9.imagemanager.transfer.Arq_arquivoT;
import br.com.i9.imagemanager.transfer.Cla_classificacaoT;
import br.com.jdragon.dao.DAOFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.TreeMap;

/**
 *
 * @author geoleite
 */
public class BackupImagens {

    public static void main(String[] param) {
        ThreadBackup threadExportacao = new ThreadBackup();
        threadExportacao.start();
        System.out.printf("Arquivo %1s salvo", "FIM");
    }
}

class ThreadBackup extends Thread {

    public static String url = "jdbc:postgresql://127.0.0.1:5432/i9imagemanager";
    public static String user = "i9im";
    public static String pass = "i9im@)!)";
//    public static String user = "postgres";
//    public static String pass = "postgres";
    private int cont = 0;
    private int set_nr_id;
    private TreeMap<Integer, String> classificacao = new TreeMap<Integer, String>();
    private String pathArquivoConfig = "./configbackup.properties";
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private void salvar(String classificacaoNome, String produto,
            String nomeArquivo, byte[] arquivo) throws Exception {
        String path = "/media/hd_externo/backup/";
        //File file = new File(path);
        //file.mkdirs();
        path = path.concat("/").concat(produto).concat("/").concat(classificacaoNome);
        File file = new File(path);
        file.mkdirs();
        FileOutputStream fos = new FileOutputStream(path.concat("/").concat(nomeArquivo));
        fos.write(arquivo);
        fos.flush();
        fos.close();
        System.out.println("Arquivo " + produto + " " + nomeArquivo + " " + ++cont);
    }

    private void readClassificacao(Cla_classificacaoDAO claDao) throws Exception {
        List<Cla_classificacaoT> list = claDao.getAll();
        for (Cla_classificacaoT cla_classificacaoT : list) {
            classificacao.put(cla_classificacaoT.getCla_nr_id(), cla_classificacaoT.getCla_tx_tipo());
        }
    }

    private void salvarDataArquivo() {
        try {
            File file = new File(pathArquivoConfig);
            if (file.exists()) {
                file.delete();
            }
            java.util.Date dt = new java.util.Date();
            String st = sdf.format(dt);
            FileWriter fw = new FileWriter(file);
            fw.write("data=" + st);
            fw.flush();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String abrirDataArquivo() {
        try {
            File file = new File(pathArquivoConfig);
            if (file.exists()) {
                Properties props = new Properties();
                props.load(new FileInputStream(file));

                String dt = props.getProperty("data");
                java.util.Date data = sdf.parse(dt);
                Calendar cal = Calendar.getInstance();
                cal.setTime(data);
                cal.add(Calendar.SECOND, 10);
                return sdf.format(cal.getTime());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "01/01/2000 00:00";
    }

    public void run() {
        int cont=0;
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, pass);
            Arq_arquivoDAO arqDao = new Arq_arquivoDAO(DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL, con));
            Cla_classificacaoDAO claDAO = new Cla_classificacaoDAO(DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL, con));
            readClassificacao(claDAO);
            String data = abrirDataArquivo();
            Date dtUltimoBackup = new Date(sdf.parse(data).getTime());
            List<Arq_arquivoT> lista = arqDao.getAllBackup(dtUltimoBackup);
            //for (Arq_arquivoT arq_arquivoT : lista) {

            System.out.println("total:   " + lista.size());
            for (int i = 0; i < lista.size(); i++) {
                Arq_arquivoT arq_arquivoT = lista.get(i);
                try {
                    List<Arq_arquivoT> arquivo = arqDao.getByArq_bt_arquivo(arq_arquivoT);
                    if (arquivo.size() > 0) {
                        String codProduto = String.valueOf(arq_arquivoT.getPro_nr_id());
                        String nomeArq = arquivo.get(0).getArq_tx_nome();
                        String classificacaoNome = classificacao.get(arq_arquivoT.getCla_nr_id());
                        byte[] arquivoBytes = arquivo.get(0).getArq_bt_arquivo();
                        salvar(classificacaoNome, codProduto, nomeArq, arquivoBytes);
                        cont++;
                        try {

                            arquivo = arqDao.getByArq_bt_thumbNotNull(arq_arquivoT);
                            if (arquivo.size() > 0) {
                                arquivoBytes = arquivo.get(0).getArq_bt_thumb();
                                salvar(classificacaoNome + "/thumb", codProduto, nomeArq+"_thumb", arquivoBytes);
                            }
                        } catch (Exception e) {
                        }
                        sleep(100);
                        System.gc();
                        System.out.println("arq: " + cont + " " + codProduto + "-" + nomeArq);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            salvarDataArquivo();
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
