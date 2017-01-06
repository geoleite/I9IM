/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.arq_arquivo;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.ExibirImagensGWT;
import br.com.i9.imagemanager.gwt.client.easynet.bo.Cla_classificacaoConsultGWT;
import br.com.i9.imagemanager.gwt.client.icons.ExampleIcons;
import br.com.i9.imagemanager.gwt.client.transfer.Arq_arquivoTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Cla_classificacaoTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Pro_produtoTGWT;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.DateTimePropertyEditor;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class SubstituirArquivo extends com.extjs.gxt.ui.client.widget.Window implements Listener<ButtonEvent> {

    private static ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private Timer timer;
    private static int QNT_FORM = 1;
    private Pro_produtoTGWT pro_produtoTGWT;
    private Arq_arquivoTGWT arq_arquivoTGWT;
    private SubstituirArquivo subImagemReferencia;
    private ExibirImagensGWT exibirImagensGWT;
    private Dialog dialog;

    public SubstituirArquivo() {
        setScrollMode(Scroll.AUTO);
        setHeaderVisible(true);
        setHeading("Substituir Imagens");
        setBorders(false);
        setWidth("100%");
        setSize(350, 120);
        setResizable(false);
        setModal(true);
        //setLayout(new RowLayout(Orientation.VERTICAL));
        //TableLayout layout = new TableLayout(2);
        //layout.setCellSpacing(10);
        setLayout(new FillLayout());
        subImagemReferencia = this;
        
    }

    public void show() {
        add(createFormPanel1());
        super.show();
    }

    private FormPanel createFormPanel1() {
        final FormPanel fp = new FormPanel();
        fp.setHeaderVisible(false);
        //Definindo campos obrigatorios
        HiddenField<String> hfOp = new HiddenField<String>();
        hfOp.setName("op");
        hfOp.setValue("substituir");
        fp.add(hfOp);

        HiddenField<String> hfIdProduto = new HiddenField<String>();
        hfIdProduto.setName("arq_arquivoT.pro_nr_id");
        hfIdProduto.setValue(pro_produtoTGWT.getPro_nr_id() + "");
        fp.add(hfIdProduto);

        HiddenField<String> hfIdArquivo = new HiddenField<String>();
        hfIdArquivo.setName("arq_arquivoT.arq_nr_id");
        hfIdArquivo.setValue(arq_arquivoTGWT.getArq_nr_id() + "");
        fp.add(hfIdArquivo);

        fp.setHeading("Substituir Imagem ");
        fp.setAnimCollapse(true);
        fp.setCollapsible(true);
        String page = "i9im/i9im/arq_arquivo/arq_arquivoInsertGWT.jsp";
        fp.setAction(Constantes.URL + page);
        fp.setEncoding(FormPanel.Encoding.MULTIPART);
        fp.setMethod(FormPanel.Method.POST);

        FileUploadField file = new FileUploadField();
        file.setWidth(10);

        //file.setAllowBlank(false);
        file.setName("arq_arquivoT.arq_bt_arquivo");
        file.setLabelSeparator("");
        //file.setFieldLabel("Arquivo");
        Button btn = new Button("Enviar");
        Button btnFechar = new Button("Fechar");
        btn.setIcon(ICONS.upload());
        btnFechar.setIcon(ICONS.delete());
        fp.addButton(btn);
        fp.addButton(btnFechar);
        fp.setFrame(true);
        fp.add(file);


        //Definindo campo para upload do arquivo

        btn.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                fp.setHeading("Enviando Arquivo...");
                enviarImagem(fp);
                fp.clear();
            }
        });
        btnFechar.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                setVisible(false);
            }
        });

        return fp;
    }

    /**
     * envia os dados para o servidor
     * @param fp
     * @param claT
     * @param tidT
     * @param promocional
     */
    private void enviarImagem(final FormPanel fp) {
        final FormPanel fpTemp = fp;
        fp.addListener(Events.Submit, new Listener<FormEvent>() {

            public void handleEvent(FormEvent be) {
                //Window.alert(be.getResultHtml());
                String dados = be.getResultHtml();
                dados = dados.trim();
                JSONValue jsonValue = JSONParser.parse(dados);
                JSONObject jsonObject = null;
                if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                    String resultado = EasyContainer.clearAspas(jsonObject.get("resultado").toString());
                    if (resultado.toUpperCase().indexOf("SUCESSO") > -1) {
                        Info.display("Resultado", resultado);
                        removeAll();                        
                    } else {
                        MessageBox.alert("Erro ao enviar arquivo: " + fpTemp.getTitle(), resultado, null);
                    }
                }
                fp.clear();
                subImagemReferencia.setVisible(false);

                exibirImagensGWT.load();
                dialog.setVisible(false);
                //cadImagemReferencia.hide();
            }
        });
        fp.submit();

        //fp.collapse();
    }

    /**
     * @return the pro_produtoTGWT
     */
    public Pro_produtoTGWT getPro_produtoTGWT() {
        return pro_produtoTGWT;
    }

    /**
     * @param pro_produtoTGWT the pro_produtoTGWT to set
     */
    public void setPro_produtoTGWT(Pro_produtoTGWT pro_produtoTGWT) {
        this.pro_produtoTGWT = pro_produtoTGWT;
    }

    public void handleEvent(ButtonEvent be) {
        //fp.submit();
    }

    /**
     * @return the arq_arquivoTGWT
     */
    public Arq_arquivoTGWT getArq_arquivoTGWT() {
        return arq_arquivoTGWT;
    }

    /**
     * @param arq_arquivoTGWT the arq_arquivoTGWT to set
     */
    public void setArq_arquivoTGWT(Arq_arquivoTGWT arq_arquivoTGWT) {
        this.arq_arquivoTGWT = arq_arquivoTGWT;
    }

    /**
     * @return the exibirImagensGWT
     */
    public ExibirImagensGWT getExibirImagensGWT() {
        return exibirImagensGWT;
    }

    /**
     * @param exibirImagensGWT the exibirImagensGWT to set
     */
    public void setExibirImagensGWT(ExibirImagensGWT exibirImagensGWT) {
        this.exibirImagensGWT = exibirImagensGWT;
    }

    /**
     * @return the dialog
     */
    public Dialog getDialog() {
        return dialog;
    }

    /**
     * @param dialog the dialog to set
     */
    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }
}
