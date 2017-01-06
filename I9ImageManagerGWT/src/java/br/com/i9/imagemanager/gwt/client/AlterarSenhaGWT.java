/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.imagemanager.gwt.client;

import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import java.util.HashMap;
import org.apache.catalina.InstanceListener;

/**
 *
 * @author geoleite
 */
public class AlterarSenhaGWT extends Window implements Listener<ButtonEvent>, IListenetResponse {
    private LabelField txSenhaAtual = new LabelField("Senha Atual:");
    private TextField<String> tfSenhaAtual = new TextField<String>();
    private LabelField txNovaSenha = new LabelField("Nova Senha:");
    private TextField<String> tfNovaSenha = new TextField<String>();
    private LabelField txConfSenha = new LabelField("Conf. Senha:");
    private TextField<String> tfConfSenha = new TextField<String>();
    private Button btnAlterar = new Button("Alterar");
    private Button btnFechar = new Button("Fechar");

    public AlterarSenhaGWT() {
        setIcon(PrincipalGWT.ICONS.chave());
        setResizable(false);
        setModal(true);
        setClosable(false);
        setLayout(new FitLayout());
        setSize(280, 150);
        tfSenhaAtual.setPassword(true);
        tfNovaSenha.setPassword(true);
        tfConfSenha.setPassword(true);
        setHeaderVisible(true);
        setHeading("Alterar Senha");
        setLayout(new TableLayout(2));
        add(txSenhaAtual);
        add(tfSenhaAtual);
        add(txNovaSenha);
        add(tfNovaSenha);
        add(txConfSenha);
        add(tfConfSenha);
        addButton(btnAlterar);
        addButton(btnFechar);


        btnAlterar.addListener(Events.OnClick, this);
        btnFechar.addListener(Events.OnClick, this);
        //btnCancelar.addListener(Events.OnClick, this);
    }

    private void alterarSenha() {
        try {
            EasyAccessURL access = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "alterarSenha");
            param.put("confnovasenha", tfConfSenha.getValue());
            param.put("senhaatual", tfSenhaAtual.getValue());
            param.put("novasenha", tfNovaSenha.getValue());
            String url = Constantes.URL +  "portalgwt/alterarsenha.jsp";
            access.accessJSonMap(url, param);
        } catch (Exception e) {
        }

    }
    public void handleEvent(ButtonEvent be) {
        if (btnAlterar == be.getButton()) {
            alterarSenha();
        } else if (btnFechar  == be.getButton()) {
            setVisible(false);
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            JSONObject resultado = jsonObject.get("resultado").isObject();
            String valor = resultado.get("mensagem").toString();
            valor = valor.replace('"', ' ').trim();
            String result = resultado.get("result").toString();
            result = result.replace('"', ' ').trim();
            if ("true".equals(result)) {
                //Operacao executadao com sucesso.
                Info.display("Resultado da Operacao.", valor);
                setVisible(false);
            } else {
                MessageBox mb = new MessageBox();
                mb.alert("Falha ao executar operacao.", valor, null);

            }
        }
        
    }
}
