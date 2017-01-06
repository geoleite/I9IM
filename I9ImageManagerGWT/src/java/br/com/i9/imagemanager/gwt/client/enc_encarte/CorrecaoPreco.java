/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.enc_encarte;

import br.com.easynet.gwt.client.EasyAccessURL;
import br.com.easynet.gwt.client.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.dao.Reg_regiaoDAOGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Cor_correcaoTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Reg_regiaoTGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.vaadin.gwtgraphics.client.shape.Text;

/**
 *
 * @author geoleite
 */
public class CorrecaoPreco extends PalhetaOpcao {

    private List<TextField<String>> listTextField = new ArrayList<TextField<String>>();
    private List<LabelField> listLabelField = new ArrayList<LabelField>();
    private Reg_regiaoDAOGWT regDao = new Reg_regiaoDAOGWT();
    private List<Text> texts = new ArrayList<Text>();
    private Text text;
    private final static HashMap<Integer, Reg_regiaoTGWT> mapReg = new HashMap<Integer, Reg_regiaoTGWT>();
    private final static HashMap<String, Reg_regiaoTGWT> mapRegLabel = new HashMap<String, Reg_regiaoTGWT>();

    public CorrecaoPreco(IEventCanvas eventCanvas) {
        super(eventCanvas);
        setHeading("Adicionando Preços");
        setResizable(false);
        if (mapReg.size() == 0) {
            regDao.consultarTodos();
            Timer timer = new Timer() {

                @Override
                public void run() {
                    ListStore<Reg_regiaoTGWT> list = regDao.getList();
                    if (list == null) {
                        schedule(500);
                    } else {
                        FormPanel fp = new FormPanel();
                        fp.setHeaderVisible(false);
                        fp.setLayout(new TableLayout(2));
                        for (int i = 0; i < list.getCount(); i++) {
                            Reg_regiaoTGWT regT = list.getAt(i);
                            mapReg.put(regT.getReg_nr_id(), regT);
                            
                            TextField<String> tf = new TextField<String>();
                            LabelField lf = new LabelField(regT.getReg_tx_nome() + ":");
                            mapRegLabel.put(lf.getText(), regT);
                            listTextField.add(tf);
                            listLabelField.add(lf);
                            fp.add(lf);
                            fp.add(tf);
                        }
                        add(fp);
                    }
                }
            };
            timer.schedule(500);
        }
    }

    public void importar(Cor_correcaoTGWT corT) {
        this.corT = corT;
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (mapReg.size() == 0) {
                    schedule(500);
                } else {
                    Reg_regiaoTGWT regTTemp = mapReg.get(CorrecaoPreco.this.corT.getReg_nr_id());
                    text = new Text(CorrecaoPreco.this.corT.getCor_nr_posx(), CorrecaoPreco.this.corT.getCor_nr_posy(), regTTemp.getReg_tx_nome() + ":" + CorrecaoPreco.this.corT.getCor_tx_observacao());
                    text.addClickHandler(new ClickHandler() {

                        public void onClick(ClickEvent event) {
                            AlterarPreco alterarPreco = new AlterarPreco(getEventCanvas());
                            alterarPreco.corT = CorrecaoPreco.this.corT;
                            alterarPreco.setText(text);
                            alterarPreco.setVisible(true);
                            setVisible(true);
                        }
                    });
                    getEventCanvas().add(text);
                }
            }
        };
        timer.schedule(500);
    }

    public void limpar() {
        for (int j = 0; j < listTextField.size(); j++) {
            listTextField.get(j).setValue("");
        }
    }

    public void alterar(ButtonEvent be) {
        //text.setText(tex.getValue());
        limpar();
        setVisible(false);
    }

    private int getPosicaoPreco(String label) {
        int pos = -1;
        for (int i = 0; i < listLabelField.size(); i++) {
            if (label.equalsIgnoreCase(listLabelField.get(i).getText())) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public void salvar(ButtonEvent be) {
        int posFinalX = getPosX() + getPosScrollX() - ERRO_X;
        int posFinalY = getPosY() + getPosScrollY() - ERRO_Y;
        int cont = 0;
        for (int i = 0; i < listLabelField.size(); i++) {
            final LabelField lf = listLabelField.get(i);
            final TextField<String> tf = listTextField.get(i);
            if (tf.getValue() != null && tf.getValue().trim().length() > 0) {
                String texto = lf.getText() + tf.getValue();
                posFinalY += cont;
                cont = 25;
                Text text = new Text(posFinalX, posFinalY, texto);
                text.setFillColor("#FFFFFF");
                text.setFontFamily("arial");
                text.addClickHandler(new ClickHandler() {

                    public void onClick(ClickEvent event) {
                        Text text = (Text) event.getSource();
                        AlterarPreco alterarPreco = new AlterarPreco(getEventCanvas());
                        alterarPreco.corT = corT;
                        alterarPreco.setText(text);
                        alterarPreco.setVisible(true);
                    }
                });
                getEventCanvas().add(text);
                Reg_regiaoTGWT regTemp = mapRegLabel.get(listLabelField.get(i).getText());
                
                Cor_correcaoTGWT corT = new Cor_correcaoTGWT();
                corT.setCor_nr_posx(posFinalX);
                corT.setCor_nr_posy(posFinalY);
                corT.setCor_nr_posx2(posFinalX);
                corT.setCor_nr_posy2(posFinalY);
                corT.setCor_tx_observacao(tf.getValue());
                corT.setTic_nr_id(getTicNrId());
                corT.setPag_nr_id(getPagNrId());
                corT.setReg_nr_id(regTemp.getReg_nr_id());
                //corT.setUsu_nr_id(592);
                //corT.setSet_nr_id(9);
                corT.setCor_tx_status("A");
                getCorDao().inserir(corT);
                esperarResposta(text);
                layout();
            }
        }
        
        limpar();
        
        setVisible(false);
    }
}
