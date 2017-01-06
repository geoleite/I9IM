/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.util;

import br.com.i9.imagemanager.jb.SystemBase;
import br.com.i9.imagemanager.transfer.Arq_arquivoT;
import br.com.i9.imagemanager.transfer.Tid_tipodocumentoT;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author geoleite
 */
public class TesteStress {

    static Arq_arquivoT arq_arquivoT = new Arq_arquivoT();
    static SystemBase sb = new SystemBase();

    private static byte[] getArquivo(File file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int controle = -1;
        while ((controle = fis.read(buffer)) != -1) {
            byte[] bufferTemp = new byte[controle];
            System.arraycopy(buffer, 0, bufferTemp, 0, controle);
            baos.write(bufferTemp);
        }
        fis.close();
        return baos.toByteArray();

    }

    /**
     * obtem o tipo do arquivo pela extensao
     * @param arquivo
     * @return
     */
    private static Tid_tipodocumentoT getTipoDocumento(String arquivo) throws Exception {
        Tid_tipodocumentoT tid_tipodocumentoT = new Tid_tipodocumentoT();
        if (arquivo != null) {
            StringTokenizer stk = new StringTokenizer(arquivo, ".");
            if (stk.hasMoreElements()) {
                stk.nextElement();
                String extensao = (String) stk.nextElement();
                tid_tipodocumentoT.setTid_tx_sigla(extensao);
                List<Tid_tipodocumentoT> listTid = sb.getTid_tipodocumentoDAO().getByTid_tx_sigla(tid_tipodocumentoT);
                if (listTid.size() == 0) {
                    tid_tipodocumentoT.setTid_tx_descricao(tid_tipodocumentoT.getTid_tx_sigla());
                    tid_tipodocumentoT.setTid_tx_reduzir("N");
                    sb.getTid_tipodocumentoDAO().insert(tid_tipodocumentoT);
                    listTid = sb.getTid_tipodocumentoDAO().getByTid_tx_sigla(tid_tipodocumentoT);
                }
                tid_tipodocumentoT = listTid.get(0);
            }
        }
        return tid_tipodocumentoT;
    }

    public static String getNomeArquivo(String path) {
        StringTokenizer stk = new StringTokenizer(path, "\\");
        String nomeArquivo = "";
        while (stk.hasMoreTokens()) {
            nomeArquivo = stk.nextToken();
        }
        return nomeArquivo;
    }

    public static void insertArquivo(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                System.out.println("Pasta: " + file.getName());
                File[] arqs = file.listFiles();
                for (File file1 : arqs) {
                    
                    insertArquivo(file1);
                    
                }
            } else {
                System.out.println("Arquivo: " + file.getName());
                arq_arquivoT.setPro_nr_id(85871);
                arq_arquivoT.setCla_nr_id(1);
                arq_arquivoT.setArq_dt_cadastro(new Date());
                arq_arquivoT.setArq_dt_validadefim(new Date());
                arq_arquivoT.setArq_dt_validadeinicio(new Date());
                arq_arquivoT.setArq_tx_descricao("arq_teste");
                arq_arquivoT.setArq_tx_promocional("N");
                arq_arquivoT.setArq_tx_situacao("A");
                try {
                    arq_arquivoT.setArq_tx_nome(getNomeArquivo(file.getName()));
                    arq_arquivoT.setTid_nr_id(getTipoDocumento(file.getName()).getTid_nr_id());
                    arq_arquivoT.setArq_bt_arquivo(getArquivo(file));
                    sb.getArq_arquivoDAO().insert(arq_arquivoT);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] param) {
        File file = new File("/home/geoleite/NovosProjetos");
        insertArquivo(file);
        System.out.println("Fim");
    }
}
