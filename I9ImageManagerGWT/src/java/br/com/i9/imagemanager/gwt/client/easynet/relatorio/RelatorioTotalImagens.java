package br.com.i9.imagemanager.gwt.client.easynet.relatorio;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

/**
 *
 * @author ${user}
 */
public class RelatorioTotalImagens extends Window implements Listener<ButtonEvent>, IListenetResponse {

    private LabelField lfTotalImagens = new LabelField();
    private LabelField lfTotalProdutos = new LabelField();
    private LabelField lfPercentual = new LabelField();
    private Button btnFechar = new Button("Fechar");
    private String PAGE = "i9im/i9im/relatorio/relatorio.jsp?op=totalImagens";
    public RelatorioTotalImagens() {
        try {
            setModal(true);
            setResizable(false);
            setSize(250, 130);
            setLayout(new TableLayout(2));
            setHeading("Total de Imagens Cadastradas");
            add(new LabelField("Total de Imagens:"));
            add(lfTotalImagens);
            add(new LabelField("Total de Produtos:"));
            add(lfTotalProdutos);
            //add(new LabelField("Percentual:"));
            //add(lfPercentual);


            addButton(btnFechar);
            btnFechar.addListener(Events.OnClick, this);
        } catch (Exception ex) {

        }
    }
    public void load() {
        try {
            EasyAccessURL access = new EasyAccessURL(this);
            access.accessJSon(Constantes.URL + PAGE);

        } catch (Exception e) {
        }
    }

    public void handleEvent(ButtonEvent be) {
        setVisible(false);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONObject resultado = jsonObject.get("resultado").isObject();
            String count = resultado.get("count").toString();
            String produtos = resultado.get("produtos").toString();
            lfTotalImagens.setValue(EasyContainer.clearAspas(count));
            lfTotalProdutos.setValue(EasyContainer.clearAspas(produtos));
            //float f1 = Float.parseFloat(lfTotalImagens.getValue()+ "");
            //float f2 = Float.parseFloat(lfTotalProdutos.getValue()+ "");
            //float perc = (f1/f2)*100;
            //lfPercentual.setValue(perc + "%");
        }
    }
}
