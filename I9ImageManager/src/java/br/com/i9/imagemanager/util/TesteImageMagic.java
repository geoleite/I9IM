/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.util;

import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;
import org.im4java.process.Pipe;

/**
 *
 * @author geoleite
 */
public class TesteImageMagic {

    public static void main(String[] p) {
        try {
            /*
            IMOperation op = new IMOperation();
            op.addImage("-");                   // read from stdin
            op.addImage("jpg:-");               // write to stdout in tif-format
            

            // set up pipe(s): you can use one or two pipe objects
            FileInputStream fis = new FileInputStream("/home/geoleite/Download/431735_original.jpg");
            FileOutputStream fos = new FileOutputStream("/home/geoleite/Download/431735.jpg");
            // Pipe pipe = new Pipe(fis,fos);
            Pipe pipeIn = new Pipe(fis, null);
            Pipe pipeOut = new Pipe(null, fos);

            // set up command
            ConvertCmd convert = new ConvertCmd();
            convert.setInputProvider(pipeIn);
            convert.setOutputConsumer(pipeOut);
            convert.run(op);
            fis.close();
            fos.close();
             */

            ConvertCmd cmd = new ConvertCmd();

// create the operation, add images and operators/options
            IMOperation op = new IMOperation();
            op.addImage("/home/geoleite/Download/431735_original.jpg");
            op.resize(120, 100);
            op.addImage("/home/geoleite/Download/431735.png");

// execute the operation
            cmd.run(op);

            BufferedImage bi = ImageIO.read(new File("/home/geoleite/Download/431735.png"));
            JFrame frm = new JFrame();
            frm.setSize(400, 400);
            JLabel label = new JLabel(new ImageIcon(bi));
            frm.getContentPane().add(label);
            frm.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
