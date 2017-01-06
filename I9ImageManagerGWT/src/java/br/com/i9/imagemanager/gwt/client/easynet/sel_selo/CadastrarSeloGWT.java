/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.easynet.sel_selo;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.easynet.bo.Cls_classificacao_seloConsultGWT;
import br.com.i9.imagemanager.gwt.client.easynet.upload.UploadMultiplosSeloGWT;
import br.com.i9.imagemanager.gwt.client.icons.ExampleIcons;
import br.com.i9.imagemanager.gwt.client.transfer.Cls_classificacao_seloTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Pro_produtoTGWT;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.DateTimePropertyEditor;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
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
public class CadastrarSeloGWT extends com.extjs.gxt.ui.client.widget.Window implements Listener<ButtonEvent> {

    private static ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private Cls_classificacao_seloConsultGWT clsConsult = new Cls_classificacao_seloConsultGWT();
    //private Tid_tipodocumentoConsultGWT tidConsult = new Tid_tipodocumentoConsultGWT();
    private Timer timer;
    private ListStore<Cls_classificacao_seloTGWT> listCls;
    //private ListStore<Tid_tipodocumentoTGWT> listTid;
    private static int QNT_FORM = 1;
    private Pro_produtoTGWT pro_produtoTGWT;
    private CadastrarSeloGWT cadSeloReferencia;
    private ContentPanel cpFile = new ContentPanel();

    public CadastrarSeloGWT() {
        setScrollMode(Scroll.AUTO);
        setHeaderVisible(true);
        setHeading("Inserir Selos");
        setBorders(false);
        setWidth("100%");
        setSize(420, 230);
        setResizable(false);
        setModal(true);
        setLayout(new FillLayout());

        cadSeloReferencia = this;
/*
        ListStore<QuantidadeUpload> states = new ListStore<QuantidadeUpload>();
        states.add(TestData.getQuantidadeUploads());

        ToolBar tb = new ToolBar();
        Button btn = new Button("Quantidade Upload");
        Menu menu = new Menu();

        cpFile.setHeading("Campos Upload");
        cpFile.setLayout(new FillLayout(Orientation.VERTICAL));
        SelectionListener eventMenu = new SelectionListener<MenuEvent>() {

            @Override
            public void componentSelected(MenuEvent ce) {
                MenuItem mi = (MenuItem) ce.getItem();
                int op = Integer.parseInt(mi.getText());
                switch (op) {
                    case 1:
                        setHeight(230);
                        break;
                    case 2:
                        setHeight(255);
                        break;
                    case 3:
                        setHeight(280);
                        break;
                    case 4:
                        setHeight(305);
                        break;
                    case 5:
                        setHeight(330);
                        break;
                    case 6:
                        setHeight(355);
                        break;
                    case 7:
                        setHeight(380);
                        break;
                }
                cpFile.removeAll();
                for (int i = 1; i <= op; i++) {
                    FileUploadField file = new FileUploadField();
                    file.setWidth(10);

                    file.setName("arquivoT.arq" + i);
                    file.setLabelSeparator("");
                    //file.setFieldLabel("Arquivo");
                    cpFile.add(file);
                }
                layout();
            }
        };

        for (int i = 1; i < 8; i++) {
            MenuItem mi = new MenuItem("" + i);
            mi.addSelectionListener(eventMenu);
            menu.add(mi);
        }
        btn.setMenu(menu);
        tb.add(btn);
        setTopComponent(tb);
 */
    }

    public void criarForm() {
        timer = new Timer() {

            @Override
            public void run() {
                listCls = clsConsult.getStore();
                //listTid = tidConsult.getStore();
                if (listCls == null /*|| listTid == null*/) {
                    timer.schedule(500);
                } else {
                    // montando os forms para upload
                    for (int i = 1; i <= QNT_FORM; i++) {
                        add(createFormPanel1(i));
                    }
                    layout();
                }
            }
        };
        timer.schedule(1000);

    }

    private FormPanel createFormPanel1(int cont) {
        final FormPanel fp = new FormPanel();
        fp.setHeaderVisible(false);
        //Definindo campos obrigatorios
        HiddenField<String> hfOp = new HiddenField<String>();
        hfOp.setName("op");
        hfOp.setValue("insert");
        fp.add(hfOp);

        //HiddenField<String> hfIdProduto = new HiddenField<String>();
        //hfIdProduto.setName("arq_arquivoT.pro_nr_id");
        //hfIdProduto.setValue(pro_produtoTGWT.getPro_nr_id() + "");
        //fp.add(hfIdProduto);

        fp.setFrame(true);
        fp.setHeading("Selo ");
        fp.setAnimCollapse(true);
        fp.setCollapsible(true);
        String page = "i9im/i9im/sel_selo/sel_seloInsertGWT.jsp";
        fp.setAction(Constantes.URL + page);
        fp.setEncoding(FormPanel.Encoding.MULTIPART);
        fp.setMethod(FormPanel.Method.POST);
        // Lista de classificacao
        final ComboBox<Cls_classificacao_seloTGWT> comboCls = new ComboBox<Cls_classificacao_seloTGWT>();
        comboCls.setLabelSeparator("");
        comboCls.setForceSelection(true);
        comboCls.setName("cls_classificacao_seloT.cls_tx_tipo");
        comboCls.setEmptyText("Selecione a classificacão...");
        comboCls.setDisplayField("cls_tx_tipo");
        comboCls.setValueField("cls_tx_tipo");
        //comboCla.set
        comboCls.setWidth(150);
        comboCls.setStore(listCls);
        comboCls.setTypeAhead(true);
        comboCls.setTriggerAction(ComboBox.TriggerAction.ALL);
        fp.add(comboCls);

//        fp.add(cpFile);
        /*
        for (int i = 0; i < op; i++) {
        FileUploadField file = new FileUploadField();
        file.setWidth(10);

        //file.setAllowBlank(false);
        file.setName("sel_seloT.sel_bt_arquivo");
        file.setLabelSeparator("");
        //file.setFieldLabel("Arquivo");
        fp.add(file);
        }
        Button btn = new Button("Enviar");
        btn.setIcon(ICONS.upload());
        fp.addButton(btn);
         */
        Button btnMultiplosArquivos = new Button("Multiplos Arquivos");
        Button btnFechar = new Button("Fechar");
        btnMultiplosArquivos.setIcon(ICONS.upload());
        btnFechar.setIcon(ICONS.delete());
        fp.addButton(btnMultiplosArquivos);
        fp.addButton(btnFechar);


        //Dados sobre promocao
        final FieldSet fieldSet = new FieldSet();
        fieldSet.setLayout(new TableLayout(4));
        fieldSet.setHeading("Imagem Promocional - Definir Vigencia");
        fieldSet.setCheckboxToggle(true);
        fieldSet.collapse();


        DateTimePropertyEditor dtpe = new DateTimePropertyEditor("dd/MM/yyyy");
        final DateField dtInicio = new DateField();
        dtInicio.setPropertyEditor(dtpe);
        dtInicio.setFieldLabel("Data Inicio");
        dtInicio.setFormatValue(true);
        dtInicio.setName("sel_seloT.sel_dt_validadeinicio");
        dtInicio.setFieldLabel("Inicio Valid.");
        dtInicio.setAllowBlank(false);
        dtInicio.setWidth(150);
        fieldSet.add(new LabelField("Inicio:"));
        fieldSet.add(dtInicio);

        final DateField dtFim = new DateField();
        dtFim.setFieldLabel("Data Fim");
        dtFim.setPropertyEditor(dtpe);
        dtFim.setName("sel_seloT.sel_dt_validadefim");
        dtFim.setFieldLabel("Fim Valid.");
        dtFim.setAllowBlank(false);
        dtFim.setWidth(150);
        fieldSet.add(new LabelField("Fim:"));
        fieldSet.add(dtFim);

        final HiddenField<String> hfPromo = new HiddenField<String>();
        hfPromo.setName("sel_seloT.sel_tx_promocional");
        //hfPromo.setValue(promocional ? "S" : "N");
        hfPromo.setValue("S");
        fp.add(hfPromo);

        fp.add(fieldSet);

        //Definindo campo para upload do arquivo
        btnMultiplosArquivos.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                UploadMultiplosSeloGWT uploadMultiplos = new UploadMultiplosSeloGWT();
                uploadMultiplos.setClsT(comboCls.getValue());
                uploadMultiplos.setPromocional(fieldSet.isExpanded());
                if (fieldSet.isExpanded()) {
                    uploadMultiplos.setDtInicio(dtInicio.getValue());
                    uploadMultiplos.setDtFim(dtFim.getValue());
                }
                uploadMultiplos.show();

            }
        });

/*        btn.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                fp.setHeading("Enviando Arquivo...");
                hfPromo.setValue(fieldSet.isExpanded() ? "S" : "N");
                enviarImagem(fp);
                fp.reset();
                fp.clear();
            }
        });
 */
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
                        criarForm();
                    } else {
                        MessageBox.alert("Erro ao enviar arquivo: " + fpTemp.getTitle(), resultado, null);
                    }

                }
                fp.clear();
                //cadSeloReferencia.setVisible(false);
                //cadSeloReferencia.hide();

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
}
