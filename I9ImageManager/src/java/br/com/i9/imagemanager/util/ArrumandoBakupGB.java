/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.imagemanager.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author geoleite
 */
public class ArrumandoBakupGB {
    public static void main(String[] p) {
        try {
            FileReader fr = new FileReader("/backup/Download/GBarbosa/arquivo.txt");
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("/backup/Download/GBarbosa/arquivo_alterado.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            while (br.ready()) {
                String linha = br.readLine();
                String[] campos = linha.split("\\|");
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < campos.length; i++) {
                    campos[i] = campos[i].trim();
                    sb.append(campos[i]).append("@");
                }
                sb.append("-");
                bw.write(sb.toString().replaceAll("@-", ""));
                bw.newLine();
                bw.flush();
            }
            br.close();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
