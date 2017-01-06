/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.util;

import java.io.File;

/**
 *
 * @author geoleite
 */
public class ReestruturacaoArquivosGB {

    private static int totalpasta = 500;

    private static void moverArquivo(File origem, File destino) throws Exception {
        Runtime run = Runtime.getRuntime();
        run.exec("mv " + origem.getPath() + " " + destino.getPath());
    }

    private static void copiarArquivo(File origem, File destino) throws Exception {
        Runtime run = Runtime.getRuntime();
        run.exec("cp " + origem.getPath() + " " + destino.getPath());
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

            String pathBase = p[0];
            File file = new File(pathBase);
            if (file.exists()) {
                File[] files = file.listFiles();
                String nomeSubPasta = "";
                int contInicio = 0;
                int totalgeral = files.length;
                int dv = totalgeral / totalpasta;
                int rt = totalgeral % totalpasta;
                for (int i = 0; i < (dv + rt); i++) {
                    contInicio = i * totalpasta;
                    int totalParcial = (contInicio + totalpasta - 1);

                    if (totalParcial > totalgeral) {
                        totalParcial = totalgeral - 1;
                    }
                    for (int j = contInicio; j <= totalParcial; j++) {
                        File origem = files[j];
                        File destPasta = new File(pathBase + "/" + nomeSubPasta);
                        if (!destPasta.exists()) {
                            destPasta.mkdirs();
                        }
                        try {
                            if (origem.isFile()) {
                                int idOrigem = Integer.parseInt(origem.getName());
                                nomeSubPasta = getPasta(idOrigem);
                                File destino = new File(pathBase + "/" + nomeSubPasta + "/" + origem.getName());
                                if ("mv".equalsIgnoreCase(p[1])) {
                                    System.out.println("movendo" + origem.getPath() + " " + destino.getPath());
                                    moverArquivo(origem, destino);
                                } else {
                                    System.out.println("copiando " + origem.getPath() + " " + destino.getPath());
                                    copiarArquivo(origem, destino);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                    File file1 = files[i];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
