/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.util;

import br.com.i9.imagemanager.dao.Arq_arquivoDAO;
import br.com.i9.imagemanager.dao.Pro_produtoDAO;
import br.com.i9.imagemanager.jb.SystemBase;
import br.com.i9.imagemanager.transfer.Arq_arquivoT;
import br.com.jdragon.dao.DAOFactory;
import com.sun.org.apache.bcel.internal.util.Class2HTML;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class CriarImagemThumb {

    public static String url = "jdbc:postgresql://127.0.0.1:5432/i9imagemanager";
    public static String user = "i9im";
    public static String pass = "i9im@)!)";
    //public static String user = "postgres";
    //public static String pass = "postgres";
    private static SystemBase systemBase = new SystemBase();
    private static Arq_arquivoDAO arqDao;

    private static boolean tipoArquivoImg(Arq_arquivoT arqT) throws Exception {
        String type = arqT.getArq_tx_nome();
        String[] partes = type.split("\\.");
        String tipo = partes[partes.length - 1];
        if ("_PNG_JPG_JPEG".indexOf(tipo.toUpperCase()) > 0) {
            return true;
        }
        return false;
    }

    public static void processandoLista(List<Arq_arquivoT> lista) throws Exception {
        for (Arq_arquivoT arqT : lista) {
            if (tipoArquivoImg(arqT)) {
                List<Arq_arquivoT> listTemp = arqDao.getByArq_bt_arquivo(arqT);
                Arq_arquivoT arqImgT = listTemp.get(0);
                systemBase.bytesToImagePNGThumb(arqImgT);
                arqT.setArq_bt_thumb(arqImgT.getArq_bt_thumb());
                arqDao.updateThumb(arqT);
            }
        }
    }

    public static void main(String[] param) {
        DAOFactory dao = null;
        try {
            dao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL, url, user, pass);
            arqDao = new Arq_arquivoDAO(dao);
            int qnt = arqDao.getCountTotal();
            int total = arqDao.getMaiorCodigo();
            int limite = 20;
            int indiceInicio = 0;
            int qntVez = total / limite;
            int indiceFinal = qntVez;
            dao.close();
            for (int i = 0; i < qntVez; i++) {
                dao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL, url, user, pass);
                arqDao = new Arq_arquivoDAO(dao);
                List<Arq_arquivoT> lista = arqDao.getArquivosIntervalosCodigo(indiceInicio, indiceFinal);
                if (lista.size() > 0 ) {
                    processandoLista(lista);
                }
                indiceInicio = indiceFinal;
                indiceFinal += qntVez;
                dao.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dao.close();
            } catch (Exception e) {
            }
        }


    }
}
