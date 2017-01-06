/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.imagemanager.gwt.client;

import br.com.i9.imagemanager.gwt.client.transfer.Set_setorNewTGWT;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class Util {
    public static int getCodigoSetorRaiz(List<Set_setorNewTGWT> listSet) {
        int codRaiz = Integer.MAX_VALUE;
        for (int i = 0; i < listSet.size(); i++) {
            Set_setorNewTGWT setT = listSet.get(i);
            if (codRaiz > setT.getSet_nr_idsetorpai()) {
                codRaiz = setT.getSet_nr_idsetorpai();
            }
        }
        return codRaiz;
    }
}
