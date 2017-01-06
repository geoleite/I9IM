package br.com.i9.imagemanager.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Classe que encapsula v�rias funcionalidades para trabalhar com 
 * arquivo zip.
 * 
 * @author Daniel Destro do Carmo
 * @author Java Magazine
 */
public class Zipper {

    public Zipper() {
    }

    /**
     * Abre o arquivo zip e extrai a lista de entradas do zip.
     * @param arquivo File que representa o arquivo zip em disco.
     * @return List com objetos ZipEntry.
     * @throws ZipException
     * @throws IOException
     */
    public List listarEntradasZip(File arquivo) throws ZipException, IOException {
        List entradasDoZip = new ArrayList();
        ZipFile zip = null;
        try {
            zip = new ZipFile(arquivo);
            Enumeration e = zip.entries();
            ZipEntry entrada = null;
            while (e.hasMoreElements()) {
                entrada = (ZipEntry) e.nextElement();
                entradasDoZip.add(entrada);
            }
            setArquivoZipAtual(arquivo);
        } finally {
            if (zip != null) {
                zip.close();
            }
        }
        return entradasDoZip;
    }

    /**
     * Cria um arquivo zip em disco.
     * @param arquivoZip Arquivo zip a ser criado.
     * @param arquivos Arquivos e diret�rio a serem compactados dentro do zip.
     * @return Retorna um List com as entradas (ZipEntry) salvas.
     * @throws ZipException
     * @throws IOException
     */
    public List criarZip(File arquivoZip, File[] arquivos) throws ZipException, IOException {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        setArquivoZipAtual(null);
        try {
            //adiciona a extens�o .zip no arquivo, caso n�o exista
            if (!arquivoZip.getName().toLowerCase().endsWith(".zip")) {
                arquivoZip = new File(arquivoZip.getAbsolutePath() + ".zip");
            }
            fos = new FileOutputStream(arquivoZip);
            bos = new BufferedOutputStream(fos, TAMANHO_BUFFER);
            List listaEntradasZip = criarZip(bos, arquivos);
            setArquivoZipAtual(arquivoZip);
            return listaEntradasZip;
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (Exception e) {
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                }
            }
        }
    }

    public void criarZipDiretorioLinux(File arquivoZip, String diretorio) throws ZipException, IOException {


        Runtime run = Runtime.getRuntime();
        String command = "zip -r ".concat(arquivoZip.getAbsolutePath()).concat(" ").concat(diretorio);
        Process p = run.exec(command);

        try {
            run.wait(10000);
        } catch (Exception e) {
        }

    }

    /**
     * Cria um zip gravando os dados no OutputStream passado como argumento,
     * adicionando os arquivos informados.
     * @param os OutputStream onde ser� gravado o zip.
     * @param arquivos Arquivos e diret�rio a serem compactados dentro do zip.
     * @return Retorna um List com as entradas (ZipEntry) salvas.
     * @throws ZipException
     * @throws IOException
     */
    public List criarZip(OutputStream os, File[] arquivos) throws ZipException, IOException {
        if (arquivos == null || arquivos.length < 1) {
            throw new ZipException("Adicione ao menos um arquivo ou diret�rio");
        }
        List listaEntradasZip = new ArrayList();
        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(os);
            for (int i = 0; i < arquivos.length; i++) {
                String caminhoInicial = arquivos[i].getParent();
                List novasEntradas = adicionarArquivoNoZip(zos, arquivos[i], caminhoInicial);
                if (novasEntradas != null) {
                    listaEntradasZip.addAll(novasEntradas);
                }
            }
        } finally {
            if (zos != null) {
                try {
                    zos.close();
                } catch (Exception e) {
                }
            }
        }
        return listaEntradasZip;
    }

    /**
     * Adiciona o arquivo ou arquivos dentro do diret�rio no output do zip.
     * @param zos
     * @param arquivo
     * @param caminhoInicial
     * @return Retorna um List de entradas (ZipEntry) salvas no zip.
     * @throws IOException
     */
    private List adicionarArquivoNoZip(ZipOutputStream zos, File arquivo, String caminhoInicial) throws IOException {
        List listaEntradasZip = new ArrayList();
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        byte buffer[] = new byte[TAMANHO_BUFFER];
        try {
            //diret�rios n�o s�o adicionados
            if (arquivo.isDirectory()) {
                //recursivamente adiciona os arquivos dos diret�rios abaixo
                File[] arquivos = arquivo.listFiles();
                for (int i = 0; i < arquivos.length; i++) {
                    List novasEntradas = adicionarArquivoNoZip(zos, arquivos[i], caminhoInicial);
                    if (novasEntradas != null) {
                        listaEntradasZip.addAll(novasEntradas);
                    }
                }
                return listaEntradasZip;
            }
            String caminhoEntradaZip = null;
            int idx = arquivo.getAbsolutePath().indexOf(caminhoInicial);
            if (idx >= 0) {
                //calcula os diret�rios a partir do diret�rio inicial
                //isso serve para n�o colocar uma entrada com o caminho completo
                caminhoEntradaZip = arquivo.getAbsolutePath().substring(idx + caminhoInicial.length() + 1);
            }
            ZipEntry entrada = new ZipEntry(caminhoEntradaZip);

            zos.putNextEntry(entrada);
            zos.setMethod(ZipOutputStream.DEFLATED);
            fis = new FileInputStream(arquivo);
            bis = new BufferedInputStream(fis, TAMANHO_BUFFER);
            int bytesLidos = 0;
            while ((bytesLidos = bis.read(buffer, 0, TAMANHO_BUFFER)) != -1) {
                zos.write(buffer, 0, bytesLidos);
            }
            listaEntradasZip.add(entrada);
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (Exception e) {
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                }
            }
        }
        return listaEntradasZip;
    }

    /**
     * Extrai o zip aberto atualmente para o diret�rio informado.
     * @param diretorio Diret�rio onde o zip ser� extraido.
     * @throws ZipException
     * @throws IOException
     */
    public void extrairZip(File diretorio) throws ZipException, IOException {
        extrairZip(this.getArquivoZipAtual(), diretorio);
    }

    /**
     * Extrai o zip informado para o diret�rio informado.
     * @param arquivoZip Arquivo zip a ser extra�do.
     * @param diretorio Diret�rio onde o zip ser� extraido.
     * @throws ZipException
     * @throws IOException
     */
    public void extrairZip(File arquivoZip, File diretorio) throws ZipException, IOException {
        ZipFile zip = null;
        File arquivo = null;
        InputStream is = null;
        OutputStream os = null;
        byte[] buffer = new byte[TAMANHO_BUFFER];
        try {
            //cria diret�rio informado, caso n�o exista
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }
            if (!diretorio.exists() || !diretorio.isDirectory()) {
                throw new IOException("Informe um diret�rio v�lido");
            }
            zip = new ZipFile(arquivoZip);
            Enumeration e = zip.entries();
            while (e.hasMoreElements()) {
                ZipEntry entrada = (ZipEntry) e.nextElement();
                arquivo = new File(diretorio, entrada.getName());
                //se for diret�rio inexistente, cria a estrutura
                //e pula pra pr�xima entrada
                if (entrada.isDirectory() && !arquivo.exists()) {
                    arquivo.mkdirs();
                    continue;
                }
                //se a estrutura de diret�rios n�o existe, cria
                if (!arquivo.getParentFile().exists()) {
                    arquivo.getParentFile().mkdirs();
                }
                try {
                    //l� o arquivo do zip e grava em disco
                    is = zip.getInputStream(entrada);
                    os = new FileOutputStream(arquivo);
                    int bytesLidos = 0;
                    if (is == null) {
                        throw new ZipException("Erro ao ler a entrada do zip: " + entrada.getName());
                    }
                    while ((bytesLidos = is.read(buffer)) > 0) {
                        os.write(buffer, 0, bytesLidos);
                    }
                } finally {
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Exception ex) {
                        }
                    }
                    if (os != null) {
                        try {
                            os.close();
                        } catch (Exception ex) {
                        }
                    }
                }
            }
        } finally {
            if (zip != null) {
                try {
                    zip.close();
                } catch (Exception e) {
                }
            }
        }
    }

    /**
     * Fecha a refer�ncia para o zip em uso atualmente.
     */
    public void fecharZip() {
        setArquivoZipAtual(null);
    }

    public File getArquivoZipAtual() {
        return arquivoZipAtual;
    }

    private void setArquivoZipAtual(File arquivoZipAtual) {
        this.arquivoZipAtual = arquivoZipAtual;
    }
    private File arquivoZipAtual;
    private static final int TAMANHO_BUFFER = 2048; // 2 Kbytes
}