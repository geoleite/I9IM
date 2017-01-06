/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.imagemanager.gwt.client.model;

import com.extjs.gxt.ui.client.data.BaseModelData;

/**
 *
 * @author geoleite
 */
public class QuantidadeUpload extends BaseModelData{
    public QuantidadeUpload() {

    }

    public QuantidadeUpload(String nomeQnt, int qnt) {
        setNomeQnt(nomeQnt);
        setQnt(qnt);
    }

    /**
     * @return the nomeQnt
     */
    public String getNomeQnt() {
        return get("nomeQnt");
    }

    /**
     * @param nomeQnt the nomeQnt to set
     */
    public void setNomeQnt(String nomeQnt) {
        set("nomeQnt", nomeQnt);
    }

    /**
     * @return the qnt
     */
    public int getQnt() {
        return  ((Integer)get("qnt")).intValue();
        
    }

    /**
     * @param qnt the qnt to set
     */
    public void setQnt(int qnt) {
        set("qnt", qnt);
    }

}
