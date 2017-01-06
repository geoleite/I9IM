/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client;

import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.easynet.bo.PerfilUsuarioConsult;
import br.com.i9.imagemanager.gwt.client.icons.ExampleIcons;
import com.extjs.gxt.ui.client.Style.IconAlign;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootPanel;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author geoleite
 */
public class AuthenticationGWT extends Window implements Listener<ButtonEvent>, IListenetResponse {

    public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);
    private LabelField txLogin = new LabelField("Usuário:");
    private TextField<String> tfLogin = new TextField<String>();
    private LabelField txSenha = new LabelField("Senha:");
    private TextField<String> tfSenha = new TextField<String>();
    private Button btnEntrar = new Button("Entrar");
    private PerfilUsuarioConsult puc = new PerfilUsuarioConsult();
    private String usuario;
    //private Button btnCancelar = new Button("Cancelar");

    public AuthenticationGWT() {
        setIcon(ICONS.chave());
        setResizable(false);
        setModal(true);
        setClosable(false);
        setLayout(new FitLayout());
        setSize(227, 115);
        tfSenha.setPassword(true);
        setHeaderVisible(true);
        setHeading("Login");
        setLayout(new TableLayout(2));
        add(txLogin);
        add(tfLogin);
        add(txSenha);
        add(tfSenha);
        addButton(btnEntrar);

        KeyEvento eventoKey = new KeyEvento();
        eventoKey.setAuthenticationGWT(this);
        tfLogin.addKeyListener(eventoKey);
        tfSenha.addKeyListener(eventoKey);
        btnEntrar.setIconAlign(IconAlign.LEFT);
        btnEntrar.addListener(Events.OnClick, this);
    }

    public void logar() {
        try {
            EasyAccessURL access = new EasyAccessURL(this);
            String url = Constantes.URL + "portalgwt/authentication.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "autenticar");
            param.put("usu_usuarioT.usu_tx_login", tfLogin.getValue());
            param.put("usu_usuarioT.usu_tx_senha", tfSenha.getValue());
            access.accessJSonMap(url, param);
        } catch (Exception ex) {
        }

    }

    public void handleEvent(ButtonEvent be) {
        try {
            if (be.getButton() == btnEntrar) {
                //Entrar
                logar();
            } else {
                //Cancelando
            }
        } catch (Exception e) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONObject resultado = jsonObject.get("resultado").isObject();
            String valor = resultado.get("autenticacao").toString();
            valor = valor.replace('"', ' ').trim();
            usuario = resultado.get("usuario").toString();
            usuario = usuario.replace('"', ' ').trim();
            if ("true".equals(valor)) {
                // Buscando o perfil do usuário
                puc.load();
                Timer timer = new Timer() {

                    @Override
                    public void run() {
                        List<String> perfis = puc.getPerfis();
                        if (perfis == null) {
                            schedule(500);
                        } else {
                            hide();
                            PrincipalGWT principalGWT = new PrincipalGWT();
                            principalGWT.perfis = perfis;
                            principalGWT.setUsuarioLogado(usuario);
                            RootPanel.get("gwt").add(principalGWT);
                            HashMap<String, String> mapPerfis = new HashMap<String, String>();
                            for (int i = 0; i < perfis.size(); i++) {
                                mapPerfis.put(perfis.get(i), perfis.get(i));
                            }
                            principalGWT.mapPerfis = mapPerfis;
                        }
                    }
                };
                timer.schedule(500);
            } else {
                MessageBox mb = new MessageBox();
                String valorMsg = "Usuario ou senha invalidos!";
                mb.alert("Falha ao efetuar login.", valorMsg, null);
            }
        }
    }
}

class KeyEvento extends KeyListener {

    private AuthenticationGWT authenticationGWT;

    /**
     * Fires on key down.
     *
     * @param event the component event
     */
    public void componentKeyDown(ComponentEvent event) {
    }

    /**
     * Fires on key press.
     *
     * @param event the component event
     */
    public void componentKeyPress(ComponentEvent event) {
    }

    /**
     * Fires on key up.
     *
     * @param event the component event
     */
    public void componentKeyUp(ComponentEvent event) {
        if (event.getKeyCode() == 13) {// enter
            authenticationGWT.logar();
        }
    }

    /**
     * @param authenticationGWT the authenticationGWT to set
     */
    public void setAuthenticationGWT(AuthenticationGWT authenticationGWT) {
        this.authenticationGWT = authenticationGWT;
    }
}
