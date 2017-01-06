package br.com.i9.imagemanager.gwt.client.easynet;

import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author geoleite
 */
public class EasyAccessURL {

    protected JSONValue jsonValue = null;
    private Widget source;
    private IListenetResponse listener; 
    private MessageBox mb;

    public EasyAccessURL(IListenetResponse elr)  {
        listener = elr;
    }

    /**
     * Acessa o JSP e envia e recebe dados
     * @param url
     * @throws java.lang.Exception
     */
    public void accessJSon(final String url) {
        //Window.alert(url);
        try {

            mb = MessageBox.wait("Requisicao", "Requisitando a servidor", "Esperando resposta.");

            RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, url);
            rb.sendRequest(null, new RequestCallback() {

                public void onResponseReceived(Request req, Response res) {

                    String dados = res.getText();
                    //Window.alert(dados);
                    dados = dados.trim();
                    mb.close();
//                if (url.indexOf("portalgwt/menu.jsp") > 0) {
//                    Window.alert(dados);
//                }
                    jsonValue = JSONParser.parse(dados);

                    listener.read(jsonValue);

                }

                public void onError(Request arg0, Throwable arg1) {
                    com.google.gwt.user.client.Window.alert("Erro no accessJSON:EasyAccessURL" + arg1.getMessage());
                }
            });
        } catch (Exception e) {
        }

    }

    /**
     * Acessa o JSP e envia e recebe dados sem exebir a mensagem de load
     * @param url
     * @throws java.lang.Exception
     */
    public void accessJSonNoMessage(String url) {
        //      Window.alert(url);
        try {


            RequestBuilder rb = new RequestBuilder(RequestBuilder.GET, url);
            rb.sendRequest(null, new RequestCallback() {

                public void onResponseReceived(Request req, Response res) {
                    String dados = res.getText();
                    //Window.alert(dados);
                    dados = dados.trim();

                    jsonValue = JSONParser.parse(dados);
                    listener.read(jsonValue);

                }

                public void onError(Request arg0, Throwable arg1) {
                    com.google.gwt.user.client.Window.alert("Erro no accessJSON:EasyAccessURL" + arg1.getMessage());
                }
            });
        } catch (Exception e) {
        }

    }

    /**
     * Acessa o JSP e envia e recebe dados
     * @param url
     * @throws java.lang.Exception
     */
    public void accessJSonMap(String url, HashMap map) {
        //Window.alert(url);
            url += "?controlidentity=" + System.currentTimeMillis() + "&";
            Set<String> keys = map.keySet();
            Iterator<String> iter = keys.iterator();

            for (Iterator<String> it = keys.iterator(); it.hasNext();) {
                String key = it.next();

                Object value = null;
                if (map.containsKey(key)) {

                    value = map.get(key);
                }
                if (value != null) {
                    url += key + "=" + value + "&";
                }
                //Window.alert(key + " " + value);
            }
            //Window.alert(url);
            accessJSon(url);

    }

    /**
     * Acessa o JSP e envia e recebe dados sem exibir a mensagem de load
     * @param url
     * @throws java.lang.Exception
     */
    public void accessJSonMapNoMessage(String url, HashMap map)  {
        //Window.alert(url);
        url += "?controlidentity=" + System.currentTimeMillis() + "&";
        Set<String> keys = map.keySet();
        Iterator<String> iter = keys.iterator();
        for (Iterator<String> it = keys.iterator(); it.hasNext();) {
            String key = it.next();
            String value = null;
            if (map.containsKey(key)) {
                value = map.get(key).toString();
            }
            if (value != null) {
                url += key + "=" + value + "&";
            }
        }
//        Window.alert(url);
        accessJSonNoMessage(url);
    }

    public IListenetResponse getListener() {
        return listener;
    }

    public void setListener(IListenetResponse listener) {
        this.listener = listener;
    }

    /**
     * @return the source
     */
    public Widget getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(Widget source) {
        this.source = source;
    }
}
