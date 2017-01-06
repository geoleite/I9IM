/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;

/**
 *
 * @author geoleite
 */
public class TesteBanco {

    public static String url = "jdbc:postgresql://192.168.0.186:5432/i9imagemanager";
    public static String user = "postgres";
    public static String pass = "postgres";

    public static byte[] getImagem() throws Exception {
        BufferedImage bi = ImageIO.read(new File("/tmp/tela.png"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, "PNG", baos);
        return baos.toByteArray();
    }

    public static void inserir() throws Exception {

        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement ps = con.prepareStatement("update i9im.arq_arquivo set arq_bt_arquivo=? where arq_nr_id=109141");
        ps.setBytes(1, getImagem());
        ps.close();
        con.close();

    }

    public static void consultar() throws Exception {
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement ps1 = con.prepareStatement("SET bytea_output = 'escape'");
        ps1.execute();
        ps1.close();
        PreparedStatement ps = con.prepareStatement("select arq_bt_arquivo from arq_arquivo");
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            byte[] arq = rs.getBytes("arq_bt_arquivo");
            FileOutputStream fos = new FileOutputStream("/tmp/arq.png");
            fos.write(arq);
            fos.flush();
            fos.close();
        }
        rs.close();
        ps.close();
        con.close();
    }

    public static void main(String[] param) {
        try {
            Class.forName("org.postgresql.Driver");
            //inserir();
            consultar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
