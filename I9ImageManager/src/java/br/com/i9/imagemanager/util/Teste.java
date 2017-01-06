/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.imagemanager.util;

/**
 *
 * @author geoleite
 */
public class Teste {

    public static void main(String[] p) {
        String str = "92227	MASSA PUBA/CARIMA	MASSA PUBA/CARIMA	94	1	15		A			940115	0	92227";
        String campos[] = str.split("\t");
        int cdProduto = Integer.parseInt(campos[0].trim());
        String dsProduto = campos[1].trim();
        String dsProdutoPDV = campos[2].trim();
        int cdSessao = Integer.parseInt(campos[3].trim());
        int cdGrupo = Integer.parseInt(campos[4].trim());
        int cdSubGrupo = Integer.parseInt(campos[5].trim());
        String cdFamilaStr = campos[6].trim();
        int cdFamila = -1;
        if (cdFamilaStr.length() > 0) {
            cdFamila = Integer.parseInt(cdFamilaStr);
        }
        String situacao = campos[7].trim();

        System.out.println(campos.length);
    }
}
