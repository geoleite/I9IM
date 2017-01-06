/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.jb;

import br.com.easynet.jb.EasyDownloadJB;
import br.com.i9.imagemanager.dao.Pag_paginaDAO;
import br.com.i9.imagemanager.transfer.Enc_encarteT;
import br.com.i9.imagemanager.transfer.EncarteT;
import br.com.i9.imagemanager.transfer.Pag_paginaT;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author geoleite
 */
public class DownloadEncarteJB extends SystemBase {
    private Enc_encarteT enc_encarteT = new Enc_encarteT();
    private Pag_paginaT pag_paginaT = new Pag_paginaT();
    public void pageLoad() {
        try {
            Pag_paginaDAO pagDao = getPag_paginaDAO();
            List<Pag_paginaT> list = pagDao.getByPag_bt_arquivo(pag_paginaT);
            pag_paginaT = list.size()> 0?list.get(0):pag_paginaT;
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "image/jpg");
            String fileName = pag_paginaT.getPag_tx_nome();
            fileName = fileName.replaceAll("\\W*", "");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, fileName);
            byte[] encarte = pag_paginaT.getPag_bt_arquivo();//getBytesImage(this.getClass().getResourceAsStream("01.jpg"));
            //encarte = escreveComentarios(encarte);
            getRequest().setAttribute(EasyDownloadJB.DATA, encarte);
            getPage().forward("../../../portal/easydownload.jsp");

        } catch (Exception ex) {
            Logger.getLogger(DownloadEncarteJB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    private byte[] escreveComentarios(byte[] bytes) throws Exception {
        List<EncarteT> list = (List<EncarteT>) getSession().getAttribute("encarte");
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        BufferedImage bi = ImageIO.read(bais);
        if (list != null) {
            for (EncarteT encarteT : list) {
                if (encarteT != null) {
                    byte[] fundo = getBytesImage(this.getClass().getResourceAsStream("fundo.png"));
                    bais = new ByteArrayInputStream(fundo);
                    BufferedImage biFundo = ImageIO.read(bais);
                    Graphics g = biFundo.getGraphics();
                    g.setColor(Color.BLACK);
                    g.drawString(encarteT.getComentario(), 5, 12);
                    bi.getGraphics().drawImage(biFundo, encarteT.getX(), encarteT.getY(), null);
                }
            }
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, "JPG", baos);
        return baos.toByteArray();
    }

    private byte[] getBytesImage(InputStream is) throws Exception {

        BufferedInputStream bis = new BufferedInputStream(is);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int control = -1;
        while ((control = bis.read(buffer)) > -1) {
            byte[] bufferTemp = new byte[control];
            System.arraycopy(buffer, 0, bufferTemp, 0, control);
            baos.write(bufferTemp);
        }
        bis.close();
        return baos.toByteArray();
    }

    /**
     * @return the enc_encarteT
     */
    public Enc_encarteT getEnc_encarteT() {
        return enc_encarteT;
    }

    /**
     * @param enc_encarteT the enc_encarteT to set
     */
    public void setEnc_encarteT(Enc_encarteT enc_encarteT) {
        this.enc_encarteT = enc_encarteT;
    }

    /**
     * @return the pag_paginaT
     */
    public Pag_paginaT getPag_paginaT() {
        return pag_paginaT;
    }

    /**
     * @param pag_paginaT the pag_paginaT to set
     */
    public void setPag_paginaT(Pag_paginaT pag_paginaT) {
        this.pag_paginaT = pag_paginaT;
    }
}
