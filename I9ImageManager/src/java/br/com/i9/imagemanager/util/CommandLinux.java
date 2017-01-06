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
public class CommandLinux {

    public static void chmod(String permissao, File fileRaiz) {
        try {
            Runtime run = Runtime.getRuntime();
            Process process =  run.exec("chmod -R ".concat(permissao).concat(" ").concat(fileRaiz.getAbsolutePath()));
            Thread.currentThread().sleep(2000);
        } catch (Exception e) {
        }
    }
}
