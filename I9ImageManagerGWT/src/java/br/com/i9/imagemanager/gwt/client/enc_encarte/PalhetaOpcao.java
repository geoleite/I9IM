/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client.enc_encarte;

import br.com.i9.imagemanager.gwt.client.dao.Cor_correcaoDAOGWT;
import br.com.i9.imagemanager.gwt.client.icons.ExampleIcons;
import br.com.i9.imagemanager.gwt.client.transfer.Cor_correcaoTGWT;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import org.vaadin.gwtgraphics.client.VectorObject;

/**
 *
 * @author geoleite
 */
public class PalhetaOpcao extends Window {

    public final static int ERRO_X = 15, ERRO_Y = 50;
    private int posX;
    private int posY;
    private int posScrollX;
    private int posScrollY;
    protected Button btnSalvar = new Button("Salvar");
    protected Button btnExcluir = new Button("Excluir");
    protected Button btnAlterar = new Button("Alterar");
    protected Button btnFechar = new Button("Fechar");
    protected ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private IEventCanvas eventCanvas;
    private int ticNrId;
    private int pagNrId;
    private Cor_correcaoDAOGWT corDao = new Cor_correcaoDAOGWT();
    protected Cor_correcaoTGWT corT;

    public PalhetaOpcao(IEventCanvas eventCanvasTemp) {
        setResizable(false);
        addButton(btnSalvar);
        addButton(btnAlterar);
        addButton(btnExcluir);
        addButton(btnFechar);
        btnExcluir.setVisible(false);
        btnAlterar.setVisible(false);
        btnSalvar.setIcon(ICONS.atualizar());
        btnFechar.setIcon(ICONS.exit());
        btnExcluir.setIcon(ICONS.delete());
        btnAlterar.setIcon(ICONS.atualizar());
        setEventCanvas(eventCanvasTemp);
        setModal(true);
        btnAlterar.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                alterar(be);
            }
        });
        btnFechar.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                setVisible(false);
            }
        });
        btnSalvar.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                salvar(be);
            }
        });
    }

    public void esperarResposta(final VectorObject obj) {
        Timer timer = new Timer() {

            @Override
            public void run() {
                String msg = corDao.getMsg();
                if (msg == null ) {
                    schedule(500);
                } else {
                    if (msg.indexOf("Falha") > -1) {
                        MessageBox.alert("Falha", msg, null);
                        eventCanvas.remover(obj);
                    } else {
                        Info.display("Enviando", "Comentário salvo com sucesso");
                    }
                }
            }
        };
        timer.schedule(500);
    }


    public void inicialize() {
        btnSalvar.setVisible(true);
        btnAlterar.setVisible(false);
        btnExcluir.setVisible(false);
    }

    public void salvar(ButtonEvent be) {
    }

    public void alterar(ButtonEvent be) {
    }

    public void limpar() {
    }

    public void importar(Cor_correcaoTGWT corT) {
    }

    /**
     * @return the posX
     */
    public int getPosX() {
        return posX;
    }

    /**
     * @param posX the posX to set
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * @return the posY
     */
    public int getPosY() {
        return posY;
    }

    /**
     * @param posY the posY to set
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * @return the posScrollX
     */
    public int getPosScrollX() {
        return posScrollX;
    }

    /**
     * @param posScrollX the posScrollX to set
     */
    public void setPosScrollX(int posScrollX) {
        this.posScrollX = posScrollX;
    }

    /**
     * @return the posScrollY
     */
    public int getPosScrollY() {
        return posScrollY;
    }

    /**
     * @param posScrollY the posScrollY to set
     */
    public void setPosScrollY(int posScrollY) {
        this.posScrollY = posScrollY;
    }

    /**
     * @return the eventCanvas
     */
    public IEventCanvas getEventCanvas() {
        return eventCanvas;
    }

    /**
     * @param eventCanvas the eventCanvas to set
     */
    public void setEventCanvas(IEventCanvas eventCanvas) {
        this.eventCanvas = eventCanvas;
    }

    /**
     * @return the corDao
     */
    public Cor_correcaoDAOGWT getCorDao() {
        return corDao;
    }

    /**
     * @param corDao the corDao to set
     */
    public void setCorDao(Cor_correcaoDAOGWT corDao) {
        this.corDao = corDao;
    }

    /**
     * @return the ticNrId
     */
    public int getTicNrId() {
        return ticNrId;
    }

    /**
     * @param ticNrId the ticNrId to set
     */
    public void setTicNrId(int ticNrId) {
        this.ticNrId = ticNrId;
    }

    /**
     * @return the pagNrId
     */
    public int getPagNrId() {
        return pagNrId;
    }

    /**
     * @param pagNrId the pagNrId to set
     */
    public void setPagNrId(int pagNrId) {
        this.pagNrId = pagNrId;
    }
}
