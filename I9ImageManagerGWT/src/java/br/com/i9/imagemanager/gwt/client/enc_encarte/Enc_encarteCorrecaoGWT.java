/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.enc_encarte;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.dao.Cor_correcaoDAOGWT;
import br.com.i9.imagemanager.gwt.client.dao.Pag_paginaDAOGWT;
import br.com.i9.imagemanager.gwt.client.dao.Tic_tipo_correcaoDAOGWT;
import br.com.i9.imagemanager.gwt.client.dao.Uco_usuarioCorrecaoDAOGWT;
import br.com.i9.imagemanager.gwt.client.icons.ExampleIcons;
import br.com.i9.imagemanager.gwt.client.transfer.Cor_correcaoTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Enc_encarteTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Pag_paginaTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Tic_tipo_correcaoTGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Usu_usuarioTGWT;
import com.extjs.gxt.ui.client.Style.IconAlign;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.CheckBoxListView;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonGroup;
import com.extjs.gxt.ui.client.widget.button.ToggleButton;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ListField;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ListBox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.vaadin.gwtgraphics.client.DrawingArea;
import org.vaadin.gwtgraphics.client.VectorObject;

/**
 *
 * @author geoleite
 */
public class Enc_encarteCorrecaoGWT extends Window implements IEventCanvas {

    private Enc_encarteTGWT enc_encarteTGWT;
    private ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private String urlImage = Constantes.URL + "i9im/i9im/encarte/downloadEncarte.jsp";
    private String urlUsuarios = Constantes.URL + "i9im/i9im/cor_correcao/uco_usuarioCorrecaoConsultGWT.jsp";
    private Image img;
    private Button btn = new Button("");
    private BorderLayoutData bldEast = new BorderLayoutData(LayoutRegion.EAST, 160, 160, 160);
    private BorderLayoutData bldCenter = new BorderLayoutData(LayoutRegion.CENTER);
    private ContentPanel cpEast = new ContentPanel();
    private ContentPanel cpCenter = new ContentPanel();
    private ContentPanel cpPalheta = new ContentPanel();
    private ContentPanel cpUsuarios = new ContentPanel();
    private ContentPanel cpEncartes = new ContentPanel();
    private List<ToggleButton> tgbTic = new ArrayList<ToggleButton>();
    private ButtonGroup btgGrupo = new ButtonGroup(1);
    private Tic_tipo_correcaoDAOGWT ticDao = new Tic_tipo_correcaoDAOGWT();
    private org.vaadin.gwtgraphics.client.Image image;
    //private GWTCanvas canvas;
    private DrawingArea canvas = new DrawingArea(400, 400);
    private final static String COMENTARIO = "Comentario";
    private final static String PRECO = "Preco";
    private final static String POSICAO = "Posicao";
    private PalhetaOpcao palhetaOpcao;
    private Pag_paginaDAOGWT pagDao = new Pag_paginaDAOGWT();
    private ListBox lbPaginas = new ListBox();
    private ListBox lbUsuarios = new ListBox();
    private Cor_correcaoDAOGWT corDao = new Cor_correcaoDAOGWT();
    private HashMap<Integer, Tic_tipo_correcaoTGWT> mapTic = new HashMap<Integer, Tic_tipo_correcaoTGWT>();
    private String msgTitulo = "";
    private Uco_usuarioCorrecaoDAOGWT ucoDAOGWT = new Uco_usuarioCorrecaoDAOGWT();

    public Enc_encarteCorrecaoGWT() {
        //setBodyStyle("background: url(encarte/01.jpg);");


        ticDao.consultarTodos();

        setModal(true);

        setScrollMode(Scroll.ALWAYS);

        //setLayout(new RowLayout(Orientation.VERTICAL));
        setLayout(new BorderLayout());
        add(cpEast, bldEast);
        add(cpCenter, bldCenter);
        cpCenter.setHeaderVisible(false);
        cpEast.setHeaderVisible(false);
        cpCenter.setScrollMode(Scroll.AUTO);
        cpCenter.add(canvas);

        //cpEast.setLayout(new FillLayout(Orientation.VERTICAL));
        //cpEast.add(btgGrupo);
        cpPalheta.setHeading("Palheta");
        cpEncartes.setHeading("Encartes");
        cpUsuarios.setHeading("Usuarios");
        cpEast.setLayout(new AccordionLayout());
        cpEast.add(cpPalheta);
        cpEast.add(cpEncartes);
        cpEast.add(cpUsuarios);
        cpPalheta.setLayout(new FillLayout(Orientation.VERTICAL));
        cpEncartes.setLayout(new FillLayout(Orientation.VERTICAL));
        cpUsuarios.setLayout(new FillLayout(Orientation.VERTICAL));
        cpPalheta.add(btgGrupo);
        cpEncartes.add(lbPaginas);
        cpUsuarios.add(lbUsuarios);



        //Esperando a lista dos Tipos de correcoes
        Timer timerTic = new Timer() {

            @Override
            public void run() {
                ListStore<Tic_tipo_correcaoTGWT> list = ticDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    for (int i = 0; i < list.getCount(); i++) {
                        final Tic_tipo_correcaoTGWT ticT = list.getAt(i);
                        mapTic.put(ticT.getTic_nr_id(), ticT);
                        ToggleButton tg = new ToggleButton();
                        tg.setIconAlign(IconAlign.BOTTOM);
                        tg.setTitle(ticT.getTic_tx_nome());
                        tg.setWidth(70);
                        tg.setHeight(70);
                        if (COMENTARIO.equalsIgnoreCase(ticT.getTic_tx_nome())) {
                            tg.setIcon(ICONS.comentario());
                        } else if (PRECO.equalsIgnoreCase(ticT.getTic_tx_nome())) {
                            tg.setIcon(ICONS.preco());
                        } else if (POSICAO.equalsIgnoreCase(ticT.getTic_tx_nome())) {
                            tg.setIcon(ICONS.posicao());
                        } else {
                            tg.setText(ticT.getTic_tx_nome());
                        }
                        tg.addListener(Events.OnClick, new Listener<ButtonEvent>() {

                            public void handleEvent(ButtonEvent be) {
                                ToggleButton tb = (ToggleButton) be.getButton();

                                if (tb.isPressed()) {
                                    if (COMENTARIO.equalsIgnoreCase(tb.getTitle())) {
                                        palhetaOpcao = new CorrecaoTexto(Enc_encarteCorrecaoGWT.this);
                                    } else if (PRECO.equalsIgnoreCase(tb.getTitle())) {
                                        palhetaOpcao = new CorrecaoPreco(Enc_encarteCorrecaoGWT.this);
                                    } else if (POSICAO.equalsIgnoreCase(tb.getTitle())) {
                                        palhetaOpcao = new CorrecaoPosicao(Enc_encarteCorrecaoGWT.this);
                                    }
                                    palhetaOpcao.setTicNrId(ticT.getTic_nr_id());
                                }
                            }
                        });
                        tg.setToggleGroup("grupo1");
                        btgGrupo.add(tg);
                    }
                    layout();
                }
            }
        };
        timerTic.schedule(100);
    }

    private void lerUsuarios(final int pagNrId) {
        //final String urlImageTemp = urlUsuarios + "?op=consultByPagina&cor_correcaoT.pag_nr_id=" + pagNrId;
        Cor_correcaoTGWT corT = new Cor_correcaoTGWT();
        corT.setPag_nr_id(pagNrId);
        ucoDAOGWT.consultUsuariosByPagina(corT);

        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Usu_usuarioTGWT> list = ucoDAOGWT.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    lbUsuarios.clear();
                    lbUsuarios.setVisibleItemCount(10);
                    for (int i = 0; i < list.getCount(); i++) {
                        Usu_usuarioTGWT usuT = list.getAt(i);
                        lbUsuarios.addItem(usuT.getUsu_tx_nome(), usuT.getUsu_nr_id() + "");
                    }
                    lbUsuarios.addChangeHandler(new ChangeHandler() {

                        public void onChange(ChangeEvent event) {
                            int idx = lbUsuarios.getSelectedIndex();
                            int usuNrId = Integer.parseInt(lbUsuarios.getValue(idx));
                            Cor_correcaoTGWT corT = new Cor_correcaoTGWT();
                            corT.setUsu_nr_id(usuNrId);
                            corT.setPag_nr_id(pagNrId);
                            corDao.consultByUsuarioPagina(corT);
                            Timer timer = new Timer() {

                                @Override
                                public void run() {
                                    ListStore<Cor_correcaoTGWT> list = corDao.getList();
                                    if (list == null) {
                                        schedule(500);
                                    } else {
                                        importarCorrecoes(list);
                                    }
                                }
                            };
                            timer.schedule(500);
                        }
                    });
                }
            }
        };
        timer.schedule(500);
       /*

        Cor_correcaoTGWT corT = new Cor_correcaoTGWT();
        corT.setPag_nr_id(pagNrId);
        corT.setSet_nr_id(9);
        corDao.consultBySetorPagina(corT);
        Timer timer = new Timer() {

        @Override
        public void run() {
        ListStore<Cor_correcaoTGWT> list = corDao.getList();
        if (list == null) {
        schedule(500);
        } else {
        importarCorrecoes(list);
        }
        }
        };
        timer.schedule(500);
        }
        };
        timer.schedule(2000);
         */
    }

    private void lerImagem(final int pagNrId) {
        lerUsuarios(pagNrId);
        final String urlImageTemp = urlImage + "?pag_paginaT.pag_nr_id=" + pagNrId;
        img = new Image(urlImageTemp);

        Timer timer = new Timer() {

            @Override
            public void run() {
                setPagePosition(10, 10);
                Enc_encarteCorrecaoGWT.this.setSize(img.getWidth() + 190, com.google.gwt.user.client.Window.getClientHeight() - 50);
                Enc_encarteCorrecaoGWT.this.layout();

                //Enc_encarteCorrecaoGWT.this.maximize();
                //setPagePosition(10, 10);
                canvas.setWidth(img.getWidth());
                canvas.setHeight(img.getHeight());
                image = new org.vaadin.gwtgraphics.client.Image(0, 0, img.getWidth(), img.getHeight(), urlImageTemp);
                canvas.add(image);
                image.addClickHandler(new ClickHandler() {

                    public void onClick(ClickEvent event) {
                        int x = event.getClientX();// + Enc_encarteCorrecaoGWT.this.getHScrollPosition();
                        int y = event.getClientY();// + Enc_encarteCorrecaoGWT.this.getVScrollPosition();

                        //CorrecaoTexto correcaoTexto = new CorrecaoTexto(Enc_encarteCorrecaoGWT.this, x, y);
                        palhetaOpcao.setPagNrId(pagNrId);
                        palhetaOpcao.inicialize();
                        palhetaOpcao.setPosX(x);
                        palhetaOpcao.setPosY(y);
                        palhetaOpcao.setPosScrollX(Enc_encarteCorrecaoGWT.this.getHScrollPosition() + cpCenter.getHScrollPosition());
                        palhetaOpcao.setPosScrollY(Enc_encarteCorrecaoGWT.this.getVScrollPosition() + cpCenter.getVScrollPosition());

                        palhetaOpcao.setVisible(true);
                        Enc_encarteCorrecaoGWT.this.layout();

                    }
                });
                Enc_encarteCorrecaoGWT.this.layout();
            }
        };
        timer.schedule(2000);

    }

    private void importarCorrecoes(ListStore<Cor_correcaoTGWT> listCor) {
        for (int i = 0; i < listCor.getCount(); i++) {
            Cor_correcaoTGWT corT = listCor.getAt(i);
            Tic_tipo_correcaoTGWT ticT = mapTic.get(corT.getTic_nr_id());
            PalhetaOpcao po = null;
            if (COMENTARIO.equalsIgnoreCase(ticT.getTic_tx_nome())) {
                po = new CorrecaoTexto(Enc_encarteCorrecaoGWT.this);
            } else if (PRECO.equalsIgnoreCase(ticT.getTic_tx_nome())) {
                po = new CorrecaoPreco(Enc_encarteCorrecaoGWT.this);
            } else if (POSICAO.equalsIgnoreCase(ticT.getTic_tx_nome())) {
                po = new CorrecaoPosicao(Enc_encarteCorrecaoGWT.this);
            }
            po.importar(corT);
        }
    }

    public void remover(VectorObject componente) {
        canvas.remove(componente);
        layout();
    }

    public void add(VectorObject componente) {
        canvas.add(componente);
        layout();
    }

    /**
     * @return the enc_encarteTGWT
     */
    public Enc_encarteTGWT getEnc_encarteTGWT() {
        return enc_encarteTGWT;
    }

    /**
     * @param enc_encarteTGWT the enc_encarteTGWT to set
     */
    public void setEnc_encarteTGWT(Enc_encarteTGWT enc_encarteTGWT) {
        this.enc_encarteTGWT = enc_encarteTGWT;
        msgTitulo = "Correção de Encarte: " + enc_encarteTGWT.getEnc_tx_nome();
        setHeading(msgTitulo);
        Pag_paginaTGWT pagT = new Pag_paginaTGWT();
        pagT.setEnc_nr_id(enc_encarteTGWT.getEnc_nr_id());
        pagDao.consultByEncarte(pagT);
        Timer timer = new Timer() {

            @Override
            public void run() {
                ListStore<Pag_paginaTGWT> list = pagDao.getList();
                if (list == null) {
                    schedule(500);
                } else {
                    if (list.getCount() > 0) {
                        Pag_paginaTGWT pagT = list.getAt(0);
                        setHeading(msgTitulo + ": " + pagT.getPag_tx_nome());
                        lbPaginas.clear();
                        for (int i = 0; i < list.getCount(); i++) {
                            Pag_paginaTGWT pagTemp = list.getAt(i);
                            lbPaginas.addItem(pagTemp.getPag_tx_nome(), pagTemp.getPag_nr_id() + "");
                        }
                        lbPaginas.setVisibleItemCount(10);
                        lbPaginas.addChangeHandler(new ChangeHandler() {

                            public void onChange(ChangeEvent event) {
                                int idx = lbPaginas.getSelectedIndex();
                                setHeading(msgTitulo + ": " + lbPaginas.getItemText(idx));
                                int pagNrId = Integer.parseInt(lbPaginas.getValue(idx));
                                lerImagem(pagNrId);

                            }
                        });

                        lerImagem(pagT.getPag_nr_id());
                    }
                }
            }
        };
        timer.schedule(500);
    }
}
