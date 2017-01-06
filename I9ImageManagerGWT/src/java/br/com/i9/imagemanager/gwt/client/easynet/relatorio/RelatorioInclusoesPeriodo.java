package br.com.i9.imagemanager.gwt.client.easynet.relatorio;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author ${user}
 */
public class RelatorioInclusoesPeriodo extends Window implements Listener<ButtonEvent>, IListenetResponse {

    private LabelField lfTotalImagens = new LabelField();
    private LabelField lfTotalProdutos = new LabelField();
    private LabelField lfPercentual = new LabelField();
    private DateField dtInicio = new DateField();
    private DateField dtFim = new DateField();
    private Button btnPesquisar = new Button("Consultar");
    private Button btnFechar = new Button("Fechar");
    private String PAGE = "i9im/i9im/relatorio/relatorio.jsp";

    public RelatorioInclusoesPeriodo() {
        try {
            DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
            dtInicio.getPropertyEditor().setFormat(dtf);
            dtFim.getPropertyEditor().setFormat(dtf);

            setResizable(false);
            setSize(350, 200);
            setLayout(new TableLayout(2));
            setHeading("Total de Imagens Incluídas por Período");
            add(new LabelField("Data Inicio:"));
            dtInicio.setValue(new Date());
            dtFim.setValue(new Date());

            add(dtInicio);
            add(new LabelField("Data Fim:"));
            add(dtFim);

            add(new LabelField("Total de Imagens:"));
            add(lfTotalImagens);
            add(new LabelField("Total de Produtos:"));
            add(lfTotalProdutos);
            //add(new LabelField("Percentual:"));
            //add(lfPercentual);

            addButton(btnPesquisar);
            addButton(btnFechar);
            btnPesquisar.addListener(Events.OnClick, this);
            btnFechar.addListener(Events.OnClick, this);
        } catch (Exception ex) {
        }
    }

    private void consultar() {
        try {
            EasyAccessURL access = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
            param.put("op", "calcularImagensPeriodo");
            param.put("dtInicio", dtf.format(dtInicio.getValue()));
            param.put("dtFim", dtf.format(dtFim.getValue()));

            access.accessJSonMap(Constantes.URL + PAGE, param);

        } catch (Exception e) {
        }

    }

    public void handleEvent(ButtonEvent be) {
        if (be.getButton() == btnPesquisar) {
            consultar();
        } else if (btnFechar == be.getButton()) {
            setVisible(false);
        }


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

            layout();
        }
    }
}
