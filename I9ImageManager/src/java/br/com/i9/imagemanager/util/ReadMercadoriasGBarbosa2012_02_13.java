/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.util;

import br.com.i9.imagemanager.dao.Pro_produtoDAO;
import br.com.i9.imagemanager.dao.Set_setorNewDAO;
import br.com.i9.imagemanager.jb.SystemBase;
import br.com.i9.imagemanager.transfer.Pro_produtoT;
import br.com.i9.imagemanager.transfer.Set_setorNewT;
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
public class ReadMercadoriasGBarbosa2012_02_13 {

    private String arquivo;
    private Pro_produtoDAO proDao;
    private Set_setorNewDAO setDao;
    private Properties prop = new Properties();

    public ReadMercadoriasGBarbosa2012_02_13(String arquivo) {

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

    private Set_setorNewT getSetor(String idSetorSap) throws Exception {
        Set_setorNewT setT = new Set_setorNewT();
        setT.setSet_tx_idsap(idSetorSap);
        List<Set_setorNewT> listSet = setDao.getBySet_tx_idsap(setT);
        return listSet.size() > 0 ? listSet.get(0) : null;

    }

    /**
     * Processa linha do arquivo para insercao na base
     * @param linha
     * @throws Exception
     */
    private void processarLinha(String linha) throws Exception {
//35561       LAPIS J FABER F PEN PR SM/030072    LAPIS J FABER F PE47   4    1    7204   E                                                              0
//30176       VASILHAME TAI 1000 ML               VAS TAI 1000 ML   89   1    1    8770   E                                                              0
        String[] dados = linha.split(";");
        int cdProduto = Integer.parseInt(dados[0]);
        String dsProduto = dados[2];
        String dsProdutoPDV = dados[2];
        if (dados[1].trim().length() < 9) {
            dados[1] = "0" + dados[1];
        }

        String cdSetorSap = dados[1];
        //System.out.println(cdProduto + ";" + dsProduto + ";" + dsProdutoPDV + ";" + cdSessao + ";" + cdGrupo + ";" + cdSubGrupo + ";" + cdFamila + ";" + situacao);
        Set_setorNewT setT = getSetor(cdSetorSap);
        if (setT == null) {
            System.err.println("ERRO: setor nao existe  -" + linha);
        } else {
            Pro_produtoT proT = new Pro_produtoT();
            proT.setPro_nr_id(cdProduto);
            proT.setPro_tx_nome(dsProduto);
            proT.setPro_nr_cdfamilia(0);
            proT.setPro_tx_situacao("A");
            proT.setSet_nr_id(setT.getSet_nr_id());
            proT.setPro_dt_atualizacao(new java.sql.Date(System.currentTimeMillis()));
            insertProduto(proT);
        }
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
            setDao = new Set_setorNewDAO(dao);
            FileReader fr = new FileReader(arquivo);
            br = new BufferedReader(fr);
            int cont = 1;
            while (br.ready()) {
                String linha = br.readLine();
                try {
                    processarLinha(linha);
                } catch (Exception e) {
                    System.err.println("ERRO " + cont++ + "-" + linha);
//                    try {
//                        processarLinhaFormato2(linha);
//                    } catch (Exception ex) {
//                        System.err.println(cont++ + "-" + linha);
//                    }

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
            //
//            ReadCSVGBarbosa estrutura = new ReadCSVGBarbosa();
//            try {
//                estrutura.getProp().load(new FileInputStream("config.properties"));
//                estrutura.setArquivo(estrutura.getProp().getProperty("pathEstrutura"));
//                estrutura.start();
//            } catch (Exception ex) {
//            }
            ReadMercadoriasGBarbosa2012_02_13 rmgb = new ReadMercadoriasGBarbosa2012_02_13("");
            rmgb.prop.load(new FileInputStream("config.properties"));
            rmgb.setArquivo(rmgb.prop.getProperty("path"));
            rmgb.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
