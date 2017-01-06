/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.util;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author geoleite
 */
public class TesteBackup {

    public static String url = "jdbc:postgresql://127.0.0.1:5432/testebackup";
    public static String user = "postgres";
    public static String pass = "postgres";

    public static byte[] getArquivo() throws Exception {
        int qnt = 0;
        try {
            byte[] arquivo = null;
            FileInputStream fis = new FileInputStream("/backup/Microsoft/xp/XRMPVOL_BR.iso");
            int controle = -1;
            byte[] buffer = new byte[1024];

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((controle = fis.read(buffer)) != -1) {
                qnt += controle;
                byte[] temp = new byte[controle];
                System.arraycopy(buffer, 0, temp, 0, controle);
                System.out.println("qnt " + qnt);
                baos.write(temp);
                if (qnt > 422947840) {
                    break;
                }
            }
            return baos.toByteArray();
        } catch (Exception e) {
            System.out.println("erro " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] param) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

//            PreparedStatement ps = con.prepareStatement("insert into tabela1 (arquivo) values (?)");
//            FileInputStream fis = new FileInputStream("/backup/Microsoft/xp/XRMPVOL_BR.iso");
//            //ps.setAsciiStream(1, fis);
//            ps.setBytes(1, getArquivo());
//            ps.executeUpdate();

            PreparedStatement ps = con.prepareStatement("select * from tabela1");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                FileOutputStream fos = new FileOutputStream("/tmp/arq.bin");
                int controle = -1;
                byte[] buffer = new byte[1024];
                InputStream is = rs.getBinaryStream("arquivo");
                while ((controle = is.read(buffer)) != -1) {

                    byte[] temp = new byte[controle];
                    System.arraycopy(buffer, 0, temp, 0, controle);
                    fos.write(temp);
                }
                fos.flush();
                fos.close();
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
