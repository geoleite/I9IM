/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.jb;

import br.com.easynet.jb.EasyDownloadJB;
import br.com.i9.imagemanager.transfer.Pro_produtoT;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

/**
 *
 * @author geoleite
 */
public class DownloadJB extends SystemBase {

    private Pro_produtoT pro_produtoT = new Pro_produtoT();

    private byte[] readFile() {
        File file = new File(PASTA_BASE.concat(getSession().getId().concat(".zip")));
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int controle = -1;
            byte[] buffer = new byte[1024];
            while ((controle = fis.read(buffer)) != -1) {
                byte[] bufferTemp = new byte[controle];
                System.arraycopy(buffer, 0, bufferTemp, 0, controle);
                baos.write(bufferTemp);
            }
            fis.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                file.delete();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public void pageLoad() {
        try {
            pro_produtoT = findbyIdPro_produto(pro_produtoT);
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "application/zip");          
            String fileName = pro_produtoT.getPro_tx_nome();
            fileName = fileName.replaceAll( "\\W*", "" ) ;
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, fileName.concat(".zip"));
            getRequest().setAttribute(EasyDownloadJB.DATA, readFile());
            getPage().forward("../../portal/easydownload.jsp");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * @return the pro_produtoT
     */
    public Pro_produtoT getPro_produtoT() {
        return pro_produtoT;
    }

    /**
     * @param pro_produtoT the pro_produtoT to set
     */
    public void setPro_produtoT(Pro_produtoT pro_produtoT) {
        this.pro_produtoT = pro_produtoT;
    }
}
