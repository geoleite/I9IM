/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client;

import br.com.i9.imagemanager.gwt.client.arq_arquivo.SubstituirArquivo;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.easynet.bo.Arq_arquivoConsultGWT;
import br.com.i9.imagemanager.gwt.client.easynet.bo.Cla_classificacaoConsultGWT;
import br.com.i9.imagemanager.gwt.client.icons.ExampleIcons;
import br.com.i9.imagemanager.gwt.client.transfer.Arq_arquivoTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Cla_classificacaoTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Pro_produtoTGWT;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.TabPanelEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class ExibirImagensGWT extends ContentPanel implements IListenetResponse, Listener<TabPanelEvent>, ClickHandler {

    private Pro_produtoTGWT pro_produtoTGWT;
    private Cla_classificacaoConsultGWT claConsult = new Cla_classificacaoConsultGWT();
    private ListStore<Cla_classificacaoTGWT> listCla;
    private Timer timer;
    private ListStore<Arq_arquivoTGWT> listArq;
    public final static String PAGE_DOWNLOAD_IMAGE = "i9im/i9im/arq_arquivo/arq_arquivoUpdateDeleteGWT.jsp";
    public final static String TIPO_INATIVA = "Inativa";
    public final static String TIPO_PROMOCIONAL = "Promocional";
    public final static String TIPO_IMAGEM = "Imagem";
    private ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private TabPanel tab = new TabPanel();
    private String tipoImagem = null;//Imagems, Promocional, Inativas
    private boolean exibirBtnInativar = true;
    private ExibirImagensGWT exibirImagensGWT;

    public ExibirImagensGWT() {

        setLayout(new FillLayout());
        setScrollMode(Scroll.AUTO);
        setHeaderVisible(true);
        setBorders(false);
        setFrame(false);
        setBodyBorder(false);
        setWidth("100%");
        setHeaderVisible(false);
        exibirImagensGWT = this;
    }

    public void load() {
        tab.removeAll();
        final ExibirImagensGWT eigwt = this;
        timer = new Timer() {

            @Override
            public void run() {
                listCla = claConsult.getStore();

                if (listCla == null) {
                    timer.schedule(500);
                } else {
                    for (int i = 0; i < listCla.getCount(); i++) {
                        Cla_classificacaoTGWT claT = listCla.getAt(i);
                        TabItem ti = new TabItem(tipoImagem + ":" + claT.getCla_tx_tipo());
                        ti.setBorders(false);
                        ti.setLayout(new FillLayout());
                        ti.setItemId(claT.getCla_nr_id() + "");
                        ti.setWidth("100%");
                        tab.add(ti);

                        ti.layout();
                    }
                    tab.addListener(Events.Select, eigwt);
                    tab.setSelection(tab.getItem(0));
                    tab.setAutoHeight(true);

                    add(tab);
                    layout();
                }
            }
        };
        timer.schedule(500);
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
        setHeading("Imagens do Produto: " + pro_produtoTGWT.getPro_tx_nome());
    }

    public void handleEvent(TabPanelEvent be) {
        if (tipoImagem != null) {
            String str = be.getItem().getItemId();
            //Button btn = be.getButton();
            //String str = btn.getItemId();
            consultarImagens(str, be.getItem());
        }
    }

    private void consultarImagens(final String tipos, final TabItem ti) {
        final Arq_arquivoConsultGWT arqConsult = new Arq_arquivoConsultGWT();

        arqConsult.load(tipos, pro_produtoTGWT.getPro_nr_id() + "", tipoImagem);
        Timer timer = new Timer() {

            @Override
            public void run() {

                listArq = arqConsult.getStore();
                if (listArq == null) {
                    schedule(500);
                } else {
                    //Info.display("Debug", "Exibindo Imagem " + listArq.getCount());
                    exibirImagens(ti);
                    Timer t = new Timer() {

                        @Override
                        public void run() {
                            layout();
                        }
                    };
                    t.schedule(2000);
                }
            }
        };
        timer.schedule(500);
    }

    private void exibirImagens(TabItem ti) {
        ti.removeAll();
        TableLayout tl = new TableLayout(5);
        tl.setCellPadding(10);
        tl.setCellSpacing(10);

        ContentPanel cp = new ContentPanel(tl);
        cp.setScrollMode(Scroll.AUTO);
        cp.setHeight(PrincipalGWT.height_size - 130);
        setBorders(false);
        setFrame(false);

        final IListenetResponse responseLivre = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
            }
        };
        cp.setHeaderVisible(false);
        final List<CheckBox> listCh = new ArrayList<CheckBox>();
        for (int i = 0; i < listArq.getCount(); i++) {
            Arq_arquivoTGWT arqT = listArq.getAt(i);
            String url = Constantes.URL + PAGE_DOWNLOAD_IMAGE + "?idtime=" + System.currentTimeMillis() + "&op=downloadImage&arq_arquivoT.arq_nr_id=" + arqT.getArq_nr_id();
            Image img = new Image(url);

            img.setTitle(arqT.getArq_tx_nome());
            img.addClickHandler(this);
            CheckBox cb = new CheckBox();
            cb.setItemId(arqT.getArq_nr_id() + "");

            LayoutContainer container = new LayoutContainer();

            container.setBorders(false);
            TableLayout tlImg = new TableLayout(1);
            tlImg.setCellHorizontalAlign(HorizontalAlignment.CENTER);
            container.setLayout(tlImg);
            container.add(img);
            container.add(cb);
            listCh.add(cb);
            //ti.add(img);

            cp.add(container);
        }
        if (listArq.getCount() > 0) {
            final Button btnInativar = new Button();
            final Button btnReativar = new Button();
            final Button btnDelete = new Button();
            final Button btnDownload = new Button();



            final ExibirImagensGWT exibirImagens = this;
            Listener<ButtonEvent> listenerBtn = new Listener<ButtonEvent>() {

                public void handleEvent(ButtonEvent be) {
                    String ids = "0";
                    for (int i = 0; i < listCh.size(); i++) {
                        CheckBox cb = listCh.get(i);
                        if (cb.isDirty()) {
                            ids += ", " + cb.getItemId();
                        }
                    }
                    final String codigos = ids;
                    if (be.getSource() == btnReativar) {
                        if (codigos.trim().length() == 0) {
                            MessageBox.alert("Mensagem de Aviso", "É necessário selecionar pelo menos uma imagem.", null);
                        } else {
                            MessageBox.confirm("Confirmacao de Reativacão", "Tem certeza que deseja reativar essas imagens?", new Listener<MessageBoxEvent>() {

                                public void handleEvent(MessageBoxEvent be) {
                                    if ("Yes".equalsIgnoreCase(be.getButtonClicked().getText())) {
                                        String page = "i9im/i9im/arq_arquivo/arq_arquivoUpdateDeleteGWT.jsp";
                                        HashMap<String, String> param = new HashMap<String, String>();
                                        param.put("op", "reativarIds");
                                        param.put("ids", codigos);
                                        String url = Constantes.URL + page;
                                        try {
                                            EasyAccessURL access = new EasyAccessURL(responseLivre);
                                            access.accessJSonMap(url, param);
                                        } catch (Exception ex) {
                                        }
                                        load();
                                    }
                                }
                            });
                        }
                    }
                    if (be.getSource() == btnInativar) {
// Só excluir se for selecionado pelo menos um produto
                        if (codigos.trim().length() == 0) {
                            MessageBox.alert("Mensagem de Aviso", "É necessário selecionar pelo menos uma imagem.", null);
                        } else {
                            MessageBox.confirm("Confirmacao de Inativacão", "Tem certeza que deseja inativar essas imagens?", new Listener<MessageBoxEvent>() {

                                public void handleEvent(MessageBoxEvent be) {
                                    if ("Yes".equalsIgnoreCase(be.getButtonClicked().getText())) {
                                        String page = "i9im/i9im/arq_arquivo/arq_arquivoUpdateDeleteGWT.jsp";
                                        HashMap<String, String> param = new HashMap<String, String>();
                                        param.put("op", "inativarIds");
                                        param.put("ids", codigos);
                                        String url = Constantes.URL + page;
                                        try {
                                            EasyAccessURL access = new EasyAccessURL(responseLivre);
                                            access.accessJSonMap(url, param);
                                        } catch (Exception ex) {
                                        }
                                        load();
                                    }
                                }
                            });
                        }
                    } else if (be.getSource() == btnDelete) {
                        // Só excluir se for selecionado pelo menos um produto
                        if (codigos.trim().length() > 1) {
                            MessageBox.confirm("Confirmacao de Exclusao", "Tem certeza que deseja excluir essas imagens?", new Listener<MessageBoxEvent>() {

                                public void handleEvent(MessageBoxEvent be) {
                                    if ("Yes".equalsIgnoreCase(be.getButtonClicked().getText())) {
                                        String page = "i9im/i9im/arq_arquivo/arq_arquivoUpdateDeleteGWT.jsp";
                                        HashMap<String, String> param = new HashMap<String, String>();
                                        param.put("op", "deleteIds");
                                        param.put("ids", codigos);
                                        String url = Constantes.URL + page;
                                        try {
                                            EasyAccessURL access = new EasyAccessURL(exibirImagens);
                                            access.accessJSonMap(url, param);
                                        } catch (Exception ex) {
                                        }
                                        load();
                                    }
                                }
                            });
                        } else {
                            MessageBox.alert("Mensagem de Aviso", "É necessário selecionar pelo menos uma imagem.", null);
                        }

                    } else if (be.getSource() == btnDownload) {
                        // Só excluir se for selecionado pelo menos um produto
                        if (codigos.trim().length() > 1) {
                            String page = "i9im/i9im/arq_arquivo/arq_arquivoUpdateDeleteGWT.jsp";
                            HashMap<String, String> param = new HashMap<String, String>();
                            param.put("op", "downloadImagesZip");
                            //param.put("pro_produtoT.pro_nr_id", "" + pro_produtoTGWT.getPro_nr_id());
                            param.put("ids", codigos);
                            String url = Constantes.URL + page;
                            try {

                                EasyAccessURL access = new EasyAccessURL(responseLivre);
                                access.accessJSonMap(url, param);
                                final MessageBox mb = MessageBox.wait("Download Imagens", "Esperando a compactacão das imagens", "Compactando...");
                                Timer timer = new Timer() {

                                    @Override
                                    public void run() {
                                        mb.close();
                                        final com.extjs.gxt.ui.client.widget.Window winDownload = new com.extjs.gxt.ui.client.widget.Window();
                                        winDownload.setUrl(Constantes.URL + "i9im/download/download.jsp?pro_produtoT.pro_nr_id=" + pro_produtoTGWT.getPro_nr_id());
                                        winDownload.setSize(5, 5);
                                        winDownload.setResizable(false);
                                        winDownload.show();
                                        Timer t = new Timer() {

                                            @Override
                                            public void run() {
                                                winDownload.setVisible(false);                                               
                                            }
                                        };
                                        t.schedule(5000);
                                    }
                                };
                                timer.schedule(10000);// espera 3 segundos para poder exibir a janela para download do arquivo
                            } catch (Exception ex) {
                            }

                        }

                    }
                }
            };
            btnDownload.setTitle("Baixar Imagem");
            btnDownload.setText("Download");
            btnDownload.setIcon(ICONS.download());
            btnDownload.addListener(Events.OnClick, listenerBtn);
            if (PrincipalGWT.mapPerfis.containsKey("I9IM.Admin")) {

                btnInativar.setTitle("Inativar Imagens");
                btnInativar.setText("Inativar");
                btnInativar.setIcon(ICONS.inaImagens());
                btnInativar.setHeight(20);

                btnReativar.setTitle("Reativar Imagens");
                btnReativar.setText("Reativar");
                btnReativar.setIcon(ICONS.tick());
                btnReativar.setHeight(20);


                btnDelete.setTitle("Excluir Imagens");
                btnDelete.setText("Excluir");
                btnDelete.setIcon(ICONS.remover());
                btnDelete.setHeight(20);


                cp.setButtonAlign(HorizontalAlignment.CENTER);
                if (!TIPO_INATIVA.equalsIgnoreCase(tipoImagem)) {
                    cp.addButton(btnInativar);
                } else {
                    cp.addButton(btnReativar);
                }
                cp.addButton(btnDelete);
            }

            btnInativar.addListener(Events.OnClick, listenerBtn);
            btnReativar.addListener(Events.OnClick, listenerBtn);
            btnDelete.addListener(Events.OnClick, listenerBtn);

            cp.addButton(btnDownload);
        }
        ti.add(cp);
        ti.layout();
    }

    public void onClick(ClickEvent event) {

        Image imgThumb = (Image) event.getSource();
        final String urlArq = imgThumb.getUrl();
        String url = imgThumb.getUrl() + "&thumb=N";
        Image img = new Image(url);

        IListenetResponse listener = new IListenetResponse() {

            public void read(JSONValue jsonValue) {
            }
        };

        final Dialog simple = new Dialog();
        simple.setModal(true);
        simple.setLayout(new FitLayout());
        simple.setHeading("Imagem Ampliada");
        Button btnSubstituir = new Button("Substituir");
        btnSubstituir.setIcon(ICONS.atualizar());
        if (PrincipalGWT.mapPerfis.containsKey("I9IM.Admin")) {
            simple.addButton(btnSubstituir);
            btnSubstituir.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                public void handleEvent(ButtonEvent be) {
                    SubstituirArquivo subArquivo = new SubstituirArquivo();
                    subArquivo.setExibirImagensGWT(exibirImagensGWT);
                    subArquivo.setDialog(simple);
                    subArquivo.setPro_produtoTGWT(pro_produtoTGWT);
                    int tam = "arq_arquivoT.arq_nr_id=".length();
                    int pos = urlArq.indexOf("arq_arquivoT.arq_nr_id=") + tam;
                    String arqNrId = urlArq.substring(pos, urlArq.length());
                    Arq_arquivoTGWT arqT = new Arq_arquivoTGWT();
                    arqT.setArq_nr_id(Integer.parseInt(arqNrId));
                    subArquivo.setArq_arquivoTGWT(arqT);
                    subArquivo.show();
                }
            });
        }
        simple.setBodyStyleName("pad-text");
        simple.add(img);
        simple.setScrollMode(Scroll.AUTO);
        simple.setHideOnButtonClick(true);
        simple.setWidth(365);
        simple.setHeight(325);
        simple.show();
    }

    /**
     * @return the tipoImagem
     */
    public String getTipoImagem() {
        return tipoImagem;
    }

    /**
     * @param tipoImagem the tipoImagem to set
     */
    public void setTipoImagem(String tipoImagem) {
        this.tipoImagem = tipoImagem;
    }

    public void read(JSONValue jsonValue) {
        //Window.alert(jsonValue + "");

        JSONObject jsonObject = null;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONObject resultado = jsonObject.get("resultado").isObject();
            String msg = EasyContainer.clearAspas(resultado.get("msg").toString());
            if (msg.toUpperCase().indexOf("SUCESSO") > -1) {
                Info.display("Resultado", msg);
            } else {
                MessageBox.alert("Erro ao excluir arquivo.", msg, null);
            }
        }
    }

    /**
     * @return the exibirBtnInativar
     */
    public boolean isExibirBtnInativar() {
        return exibirBtnInativar;
    }

    /**
     * @param exibirBtnInativar the exibirBtnInativar to set
     */
    public void setExibirBtnInativar(boolean exibirBtnInativar) {
        this.exibirBtnInativar = exibirBtnInativar;
    }
}
