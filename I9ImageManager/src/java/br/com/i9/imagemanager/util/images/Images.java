/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.util.images;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 *
 * @author geoleite
 */
public class Images {

    public static void main(String[] p) {
        try {
            byte[] img = Images.getCDR_MAIOR();
            System.out.println(img.length);
        } catch (Exception e) {
        }
    }

    public static byte[] getImage(String nome) throws Exception {
        InputStream is = Images.class.getResourceAsStream(nome);
        byte[] buffer = new byte[1024];
        int controle = -1;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((controle = is.read(buffer)) != -1) {
            byte[] bufferTemp = new byte[controle];
            System.arraycopy(buffer, 0, bufferTemp, 0, controle);
            baos.write(bufferTemp);
        }
        return baos.toByteArray();
    }

    public static byte[] getSEM_IMAGEM() throws Exception {
        String nome = "sem_imagem.png";
        return getImage(nome);
    }

    public static byte[] getPDF_MAIOR() throws Exception {
        String nome = "pdf_maior.png";
        return getImage(nome);
    }

    public static byte[] getPDF() throws Exception {
        String nome = "pdf.png";
        return getImage(nome);
    }

    public static byte[] getAI_MAIOR() throws Exception {
        String nome = "ai_maior.png";
        return getImage(nome);
    }

    public static byte[] getAI() throws Exception {
        String nome = "ai_maior.png";
        return getImage(nome);
    }

    public static byte[] getCDR_MAIOR() throws Exception {
        String nome = "cdr_maior.png";
        return getImage(nome);
    }

    public static byte[] getCDR() throws Exception {
        String nome = "cdr.png";
        return getImage(nome);
    }

    public static byte[] getPS_MAIOR() throws Exception {
        String nome = "ps_maior.png";
        return getImage(nome);
    }

    public static byte[] getPS() throws Exception {
        String nome = "ps.png";
        return getImage(nome);
    }
}
