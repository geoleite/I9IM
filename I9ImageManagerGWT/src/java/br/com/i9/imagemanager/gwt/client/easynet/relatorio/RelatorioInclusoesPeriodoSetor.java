package br.com.i9.imagemanager.gwt.client.easynet.relatorio;

import br.com.i9.imagemanager.gwt.client.Constantes;
import br.com.i9.imagemanager.gwt.client.EasyContainer;
import br.com.i9.imagemanager.gwt.client.easynet.EasyAccessURL;
import br.com.i9.imagemanager.gwt.client.easynet.IListenetResponse;
import br.com.i9.imagemanager.gwt.client.easynet.bo.Set_setorConsultGWT;
import br.com.i9.imagemanager.gwt.client.transfer.Set_setorTGWT;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author ${user}
 */
public class RelatorioInclusoesPeriodoSetor extends Window implements Listener<ButtonEvent>, IListenetResponse {

    private DateField dtInicio = new DateField();
    private DateField dtFim = new DateField();
    private Button btnPesquisar = new Button("Consultar");
    private Button btnFechar = new Button("Fechar");
    private String PAGE = "i9im/i9im/relatorio/relatorioSetor.jsp";
    private ContentPanel cpFiltro = new ContentPanel();
    private ContentPanel cpGrid = new ContentPanel();
    private Set_setorConsultGWT setConsult = new Set_setorConsultGWT();
    private ListStore<Set_setorTGWT> listSet;
    private int cont = 0;

    public RelatorioInclusoesPeriodoSetor() {
        DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
        dtInicio.getPropertyEditor().setFormat(dtf);
        dtFim.getPropertyEditor().setFormat(dtf);

        setResizable(false);
        setSize(400, 490);
        cpFiltro.setLayout(new TableLayout(2));
        TableLayout tableLayout = new TableLayout(3);
        tableLayout.setBorder(0);
        cpGrid.setLayout(tableLayout);
        setHeading("Total de Imagens Incluídas por Período nos Setores");
        cpFiltro.setHeading("Filtro");
        dtInicio.setValue(new Date());
        dtFim.setValue(new Date());

        cpFiltro.add(new LabelField("Data Inicio:"));
        cpFiltro.add(dtInicio);
        cpFiltro.add(new LabelField("Data Fim:"));
        cpFiltro.add(dtFim);

        add(cpFiltro);
        add(cpGrid);

        cpGrid.setHeading("Resultado");
        addButton(btnPesquisar);
        addButton(btnFechar);

        btnPesquisar.addListener(Events.OnClick, this);
        btnFechar.addListener(Events.OnClick, this);


    }

    private void consultar() {
        try {
            EasyAccessURL access = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
            param.put("op", "calcularImagensPeriodoSetor");
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
            JSONArray resultado = jsonObject.get("resultado").isArray();
            cpGrid.removeAll();
            cpGrid.add(new LabelField("Setor"));
            cpGrid.add(new LabelField("Qnt Img Inputadas"));
            //cpGrid.add(new LabelField("%"));
            cpGrid.add(new LabelField("Total Prod Afetados"));
            cpGrid.setScrollMode(Scroll.AUTO);
            //ListStore<Set_setorTGWT> store = new ListStore<Set_setorTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                JSONObject registro = resultado.get(i).isObject();
                Integer set_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("set_nr_id").toString()));
                String set_tx_nome = EasyContainer.clearAspas(registro.get("set_tx_nome").toString());
                String quantidade = EasyContainer.clearAspas(registro.get("quantidade").toString());
                //String produtos = EasyContainer.clearAspas(registro.get("produtos").toString());
                String produtosAfetados = EasyContainer.clearAspas(registro.get("produtosAfetados").toString());
                //float qntArq = Float.parseFloat(quantidade);
                //float qntPro = Float.parseFloat(produtos);
                //float percentual = (qntArq/qntPro)*100;
                //store.add(set_setorTGWT);
                cpGrid.add(new LabelField(set_tx_nome));
                cpGrid.add(new LabelField(quantidade));
                //cpGrid.add(new LabelField(produtos));
                cpGrid.add(new LabelField(produtosAfetados));
            }
            cpGrid.layout();
        }
    }
}
