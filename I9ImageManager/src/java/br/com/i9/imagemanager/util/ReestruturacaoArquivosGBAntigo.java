/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 *
 * @author geoleite
 */
public class ReestruturacaoArquivosGBAntigo {

    private static int totalpasta = 500;

    private static void moverArquivo(File origem, File destino) throws Exception {
        Runtime run = Runtime.getRuntime();
        run.exec("mv " + origem.getPath() + " " + destino.getPath());
    }

    private static void copiarArquivo(File origem, File destino) throws Exception {
// Cria channel na origem
        FileChannel oriChannel = new FileInputStream(origem).getChannel();
// Cria channel no destino
        FileChannel destChannel = new FileOutputStream(destino).getChannel();
// Copia conteúdo da origem no destino
        destChannel.transferFrom(oriChannel, 0, oriChannel.size());

// Fecha channels
        oriChannel.close();
        destChannel.close();
        origem.delete();
    }

    private static String getPasta(int id) {
        boolean calculando = true;
        String pasta = "";
        int tt = 0;
        int inicio = 0;
        while (calculando) {
            tt += totalpasta;
            if (id < tt) {
                pasta = inicio + "_" + (tt - 1);
                break;
            }
            inicio = tt;
        }
        return pasta;
    }

    public static void main(String[] p) {
        try {
            String[] t = {"/tmp/teste"};
            p = t;
            String pathBase = p[0];
            File file = new File(pathBase);
            if (file.exists()) {
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    File file1 = files[i];
                    try {
                        if (file1.isDirectory()) {
                            File[] arqs = file1.listFiles();                            
                            for (int j = 0; j < arqs.length; j++) {
                                File file2 = arqs[j];
                                File destino = new File(file1.getParentFile().getPath() + "/" + file2.getName() ) ;
                                copiarArquivo(file2, destino);
                            }
                            file1.delete();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
