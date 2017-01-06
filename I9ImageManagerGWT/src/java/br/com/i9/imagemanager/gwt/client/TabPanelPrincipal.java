/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.imagemanager.gwt.client;

import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.google.gwt.user.client.Window;

/**
 *
 * @author geoleite
 */
public class TabPanelPrincipal extends TabPanel {

    public TabPanelPrincipal() {
        super();
        TabItem ti = new TabItem("Bem Vindo");
        add(ti);
        setBorders(false);
        //Info.display("DEBUG", PrincipalGWT.height_size + "");
        
    }
}
