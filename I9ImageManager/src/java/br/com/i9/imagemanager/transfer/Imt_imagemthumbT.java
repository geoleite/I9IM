package br.com.i9.imagemanager.transfer;

import br.com.easynet.annotation.Conversion;

public class Imt_imagemthumbT { 
	 private int arq_nr_id;
	 private int pro_nr_id;
	 private int imt_nr_id;
	 private byte[] imt_bt_thumb;
 	 public void setImt_nr_id(int imt_nr_id) {
		 this.imt_nr_id=imt_nr_id;
	}
 
	 public int getImt_nr_id() {
		 return imt_nr_id;
 	} 
 	 public void setImt_bt_thumb(byte[] imt_bt_thumb) {
		 this.imt_bt_thumb=imt_bt_thumb;
	}
 
	 public byte[] getImt_bt_thumb() {
		 return imt_bt_thumb;
 	}

    /**
     * @return the arq_nr_id
     */
    public int getArq_nr_id() {
        return arq_nr_id;
    }

    /**
     * @param arq_nr_id the arq_nr_id to set
     */
    public void setArq_nr_id(int arq_nr_id) {
        this.arq_nr_id = arq_nr_id;
    }

    /**
     * @return the pro_nr_id
     */
    public int getPro_nr_id() {
        return pro_nr_id;
    }

    /**
     * @param pro_nr_id the pro_nr_id to set
     */
    public void setPro_nr_id(int pro_nr_id) {
        this.pro_nr_id = pro_nr_id;
    }
 }