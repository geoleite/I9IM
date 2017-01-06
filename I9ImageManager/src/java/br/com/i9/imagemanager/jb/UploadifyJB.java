/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.jb;

import br.com.easynet.jb.EasyFileUpload;
import br.com.i9.imagemanager.dao.Arq_arquivoDAO;
import br.com.i9.imagemanager.transfer.Arq_arquivoT;
import java.util.Date;

/**
 *
 * @author geoleite
 */
public class UploadifyJB extends SystemBase {

    private byte[] Filedata;
    private int codigo;

    public void pageLoad() throws Exception {
        super.pageLoad();
        try {
            String nome = "Filedata";
            EasyFileUpload efu = (EasyFileUpload) getRequest().getAttribute(nome);
            Arq_arquivoT arqT = (Arq_arquivoT) getSession().getAttribute(ARQUIVO_UPLOAD_MULTIPLO);
            if (arqT != null) {
                String nomeArq = efu.getPath();
                nomeArq = getNomeArquivo(nomeArq);
                arqT.setArq_tx_nome(nome);

                arqT.setTid_nr_id(getTipoDocumento(nomeArq).getTid_nr_id());

                Arq_arquivoDAO arq_arquivoDAO = getArq_arquivoDAO();
                arqT.setArq_dt_cadastro(new Date());
                arqT.setArq_bt_arquivo(Filedata);
                if ("N".equals(arqT.getArq_tx_promocional())) {
                    arq_arquivoDAO.insert(arqT);
                } else {
                    arq_arquivoDAO.insertPromocional(arqT);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the Filedata
     */
    public byte[] getFiledata() {
        return Filedata;
    }

    /**
     * @param Filedata the Filedata to set
     */
    public void setFiledata(byte[] Filedata) {
        this.Filedata = Filedata;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
