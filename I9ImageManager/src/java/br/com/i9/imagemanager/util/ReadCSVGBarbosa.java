/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.util;

import br.com.i9.imagemanager.dao.Gru_grupoDAO;
import br.com.i9.imagemanager.dao.Ses_sessaoDAO;
import br.com.i9.imagemanager.dao.Set_setorDAO;
import br.com.i9.imagemanager.dao.Sug_subgrupoDAO;
import br.com.i9.imagemanager.jb.SystemBase;
import br.com.i9.imagemanager.transfer.Gru_grupoT;
import br.com.i9.imagemanager.transfer.Ses_sessaoT;
import br.com.i9.imagemanager.transfer.Set_setorT;
import br.com.i9.imagemanager.transfer.Sug_subgrupoT;
import br.com.jdragon.dao.DAOFactory;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author geoleite
 */
public class ReadCSVGBarbosa {

    private final static String CARACTER_CSV=";";
    private String arquivo;
    private final static int CD_SESSAO = 0;
    private final static int CD_GRUPO = 1;
    private final static int CD_SUBGRUPO = 2;
    private final static int DS_SETOR = 3;
    private final static int DS_SESSAO = 4;
    private final static int DS_GRUPO = 5;
    private final static int DS_SUBGRUPO = 6;
    private Ses_sessaoDAO sesDao;
    private Set_setorDAO setDao;
    private Gru_grupoDAO gruDao;
    private Sug_subgrupoDAO sugDao;
    private int cont = 1;// simulando o código da sessao
    private Properties prop = new Properties();

    private void processarLinha(String linha) throws Exception {
        String[] linhaSplit = linha.split(CARACTER_CSV);
        if (linhaSplit.length < 7) {
            return;
        }
        //System.out.println("linha: " + linha);
        // Criando o setor com os dados da importacao

        Set_setorT setT = new Set_setorT();
        setT.setSet_tx_nome(linhaSplit[DS_SETOR]);
        if (setT.getSet_tx_nome().indexOf("dsSetor") > -1) {
            return;
        }
        setT = insertSetor(setT);
        // Criando sessao com os dados da importacao
        Ses_sessaoT sesT = new Ses_sessaoT();
        sesT.setSes_nr_id(Integer.parseInt(linhaSplit[CD_SESSAO]));
        sesT.setSes_tx_nome(linhaSplit[DS_SESSAO]);
        sesT.setSet_nr_id(findSetor(linhaSplit[DS_SETOR]).getSet_nr_id());
        insertSessao(sesT);


        // Criando o grupo com os dados da importacao
        Gru_grupoT gruT = new Gru_grupoT();
        gruT.setGru_nr_id(Integer.parseInt(linhaSplit[CD_GRUPO]));
        gruT.setGru_tx_nome(linhaSplit[DS_GRUPO]);
        gruT.setSes_nr_id(sesT.getSes_nr_id());
        if (gruT.getGru_nr_id() != 0) {
            insertGrupo(gruT);

            // Só insere o subgrupo se o codigo do grupo for diferente de 0

            //Criando o subgrupo com os dados da importacao
            Sug_subgrupoT sugT = new Sug_subgrupoT();
            sugT.setSes_nr_id(sesT.getSes_nr_id());
            sugT.setGru_nr_id(gruT.getGru_nr_id());
            sugT.setSug_nr_id(Integer.parseInt(linhaSplit[CD_SUBGRUPO]));
            sugT.setSug_tx_nome(linhaSplit[DS_SUBGRUPO]);
            if (sugT.getSug_nr_id() != 0) {
                insertSubGrupo(sugT);
            }
        }
    }

    /**
     * Verifica se o setor já existe na base de dados
     * @param setT
     * @return
     * @throws Exception
     */
    private Set_setorT insertSetor(Set_setorT setT) throws Exception {
        Set_setorT setTemp = findSetor(setT.getSet_tx_nome());
        if (setTemp != null) {//A sessão não existe
            setT = setTemp;
        } else {
            setT.setSet_nr_id(cont++);
            setDao.insert(setT);
        }
        return setT;
    }

    /**
     * Pesquisar o setor pela descricao, pq nao vem o código no arquivo de importacao
     * @param dsSetor
     * @return
     */
    private Set_setorT findSetor(String dsSetor) throws Exception {
        Set_setorT setT = new Set_setorT();
        setT.setSet_tx_nome(dsSetor);
        List<Set_setorT> list = setDao.getBySet_tx_nome(setT);
        return list.size() > 0 ? list.get(0) : null;
    }

    /**
     * Verifica se a sessão existe antes de inserir na base
     * @param sesT
     */
    private void insertSessao(Ses_sessaoT sesT) throws Exception {
        List<Ses_sessaoT> list = sesDao.getByPK(sesT);
        if (list.size() > 0) {//A sessão não existe
            sesDao.update(sesT);
        } else {
            sesDao.insert(sesT);
        }

    }

    /**
     * Verifica se o grupo existe antes de inserir na base
     * @throws Exception
     */
    private void insertGrupo(Gru_grupoT gruT) throws Exception {
        List<Gru_grupoT> list = gruDao.getByPK(gruT);
        if (list.size() > 0) {//A sessão já existe na base
            gruDao.update(gruT);
        } else { // A sessao não existe na base            
            gruDao.insert(gruT);
        }
    }

    /**
     * Verifica se o grupo existe antes de inserir na base
     * @param sugT
     * @throws Exception
     */
    private void insertSubGrupo(Sug_subgrupoT sugT) throws Exception {
        List<Sug_subgrupoT> list = sugDao.getByPK(sugT);
        if (list.size() > 0) {//A sessão já existe na base
            sugDao.update(sugT);
        } else { // A sessao não existe na base
            sugDao.insert(sugT);
        }
    }

    /**
     * Inicia processo de leitura
     * @throws Exception
     */
    public void start() throws Exception {
        SystemBase sb = new SystemBase();
        BufferedReader br = null;
        DAOFactory dao = null;
        try {
            Class.forName(getProp().getProperty("driver"));
            Connection con = DriverManager.getConnection(getProp().getProperty("url"), getProp().getProperty("user"), getProp().getProperty("pass"));
            dao = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL, con);
            sesDao = new Ses_sessaoDAO(dao);
            setDao = new Set_setorDAO((dao));
            gruDao = new Gru_grupoDAO(dao);
            sugDao = new Sug_subgrupoDAO(dao);

            FileReader fr = new FileReader(arquivo);
            br = new BufferedReader(fr);
//            if (br.ready()) { // pulando o cabecalho do csv
//                br.readLine();
//                br.readLine();
//            }
            String linha = "";
            while (br.ready()) {
                try {
                    linha = br.readLine();
                    linha = linha.replace("\"", "");
                    processarLinha(linha);
                } catch (Exception e) {
                    System.err.println("LInha invalida: " + linha + " " + e.getMessage());
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                sb.close();
                br.close();
            } catch (Exception e) {
            }

        }

    }

    public static void main(String[] p) {
        try {
            ReadCSVGBarbosa csv = new ReadCSVGBarbosa();
            csv.getProp().load(new FileInputStream("config.properties"));
            csv.setArquivo(csv.getProp().getProperty("pathEstrutura"));
            csv.start();
        } catch (Exception ex) {
            ex.printStackTrace();
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

    /**
     * @return the prop
     */
    public Properties getProp() {
        return prop;
    }

    /**
     * @param prop the prop to set
     */
    public void setProp(Properties prop) {
        this.prop = prop;
    }

}
