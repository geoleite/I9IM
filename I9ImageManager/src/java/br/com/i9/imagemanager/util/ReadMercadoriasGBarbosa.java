/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.util;

import br.com.i9.imagemanager.dao.Pro_produtoDAO;
import br.com.i9.imagemanager.jb.SystemBase;
import br.com.i9.imagemanager.transfer.Pro_produtoT;
import br.com.jdragon.dao.DAOFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author geoleite
 */
public class ReadMercadoriasGBarbosa {

    private String arquivo;
    private Pro_produtoDAO proDao;
    private Properties prop = new Properties();

    public ReadMercadoriasGBarbosa(String arquivo) {

        setArquivo(arquivo);

    }

    private void processarLinhaFormato2(String linha) throws Exception {
//cdMercadoria	dsMercadoria	dsMercadoriaPDV	cdSecao	cdGrupo	cdSubGrupo	cdFamilia	Situacao	cdMercPai	qtSubEmbalagem	cdEstrutura	flOPP	cdFamiliaMercadoria
//30001	        COENTRO MO	COENTRO	           9	7	1	        	A			90701	0	30001
//30018-MILHO VERDE UNIDADE-MILHO VERDE UNIDAD-9-2-16- -A- -90216-0-30018
        String[] campos = linha.split("\t");

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
        //System.out.println(cdProduto + ";" + dsProduto + ";" + dsProdutoPDV + ";" + cdSessao + ";" + cdGrupo + ";" + cdSubGrupo + ";" + cdFamila + ";" + situacao);
        Pro_produtoT proT = new Pro_produtoT();
        proT.setPro_nr_id(cdProduto);
        dsProduto = dsProduto.replaceAll("\"", "'");
        proT.setPro_tx_nome(dsProduto);
        proT.setPro_nr_cdfamilia(cdFamila);
        proT.setPro_tx_situacao(situacao);
        proT.setSet_nr_id(cdSessao);
        proT.setPro_dt_atualizacao(new java.sql.Date(System.currentTimeMillis()));
        insertProduto(proT);
    }

    /**
     * Processa linha do arquivo para insercao na base
     * @param linha
     * @throws Exception
     */
    private void processarLinha(String linha) throws Exception {
//35561       LAPIS J FABER F PEN PR SM/030072    LAPIS J FABER F PE47   4    1    7204   E                                                              0
//30176       VASILHAME TAI 1000 ML               VAS TAI 1000 ML   89   1    1    8770   E                                                              0
        int cdProduto = Integer.parseInt(linha.substring(0, 12).trim());
        String dsProduto = linha.substring(12, 48).trim();
        String dsProdutoPDV = linha.substring(48, 66).trim();
        int cdSessao = Integer.parseInt(linha.substring(66, 71).trim());
        int cdGrupo = Integer.parseInt(linha.substring(71, 76).trim());
        int cdSubGrupo = Integer.parseInt(linha.substring(76, 81).trim());
        String cdFamilaStr = linha.substring(81, 88).trim();
        int cdFamila = -1;
        if (cdFamilaStr.length() > 0) {
            cdFamila = Integer.parseInt(cdFamilaStr);
        }
        String situacao = linha.substring(88, 89).trim();
        //System.out.println(cdProduto + ";" + dsProduto + ";" + dsProdutoPDV + ";" + cdSessao + ";" + cdGrupo + ";" + cdSubGrupo + ";" + cdFamila + ";" + situacao);
        Pro_produtoT proT = new Pro_produtoT();
        proT.setPro_nr_id(cdProduto);
        proT.setPro_tx_nome(dsProduto);
        proT.setPro_nr_cdfamilia(cdFamila);
        proT.setPro_tx_situacao(situacao);
        proT.setSet_nr_id(cdSessao);
        proT.setPro_dt_atualizacao(new java.sql.Date(System.currentTimeMillis()));
        insertProduto(proT);
    }

    /**
     * Verificar se o produto deve ser inserido ou alterado
     * @param proT
     * @throws Exception
     */
    private void insertProduto(Pro_produtoT proT) throws Exception {
        List<Pro_produtoT> list = proDao.getByPK(proT);
        if (list.size() > 0) {
            proDao.update(proT);
        } else {
            proDao.insert(proT);
        }
    }

    public void start() throws Exception {
        BufferedReader br = null;
        //SystemBase sb = new SystemBase();
        DAOFactory dao = null;
        try {
            Class.forName(prop.getProperty("driver"));
            Connection con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("pass"));
            dao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL, con);
            proDao = new Pro_produtoDAO(dao);
            FileReader fr = new FileReader(arquivo);
            br = new BufferedReader(fr);
            int cont = 1;
            while (br.ready()) {
                String linha = br.readLine();
                try {
                    processarLinha(linha);
                } catch (Exception e) {
                    try {
                        processarLinhaFormato2(linha);
                    } catch (Exception ex) {
                        System.err.println(cont++ + "-" + linha);
                    }

                }

            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                dao.close();
                br.close();
                //File file = new File(arquivo);
                //file.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * @return the arquivo
     */
    public String getArquivo() {
        return arquivo;
    }

    /**
     * @param arquivo the arquivo to set
     */
    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public static void main(String[] p) {
        try {
            ReadCSVGBarbosa estrutura = new ReadCSVGBarbosa();
            try {                
                estrutura.getProp().load(new FileInputStream("config.properties"));
                estrutura.setArquivo(estrutura.getProp().getProperty("pathEstrutura"));
                estrutura.start();
            } catch (Exception ex) {
            }
            ReadMercadoriasGBarbosa rmgb = new ReadMercadoriasGBarbosa("");
            rmgb.prop.load(new FileInputStream("config.properties"));
            rmgb.setArquivo(rmgb.prop.getProperty("path"));
            rmgb.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
