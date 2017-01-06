/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.i9.imagemanager.gwt.client;


import br.com.i9.imagemanager.gwt.client.set_setorNew.Set_setorConsultGWT;
import com.extjs.gxt.ui.client.widget.Window;
import com.google.gwt.core.client.EntryPoint;

/**
 * Main entry point.
 *
 * @author geoleite
 */
public class MainEntryPoint implements EntryPoint {
    /** 
     * Creates a new instance of MainEntryPoint
     */
    public MainEntryPoint() {
    }

    /** 
     * The entry point method, called automatically by loading a module
     * that declares an implementing class as an entry-point
     */
    public void onModuleLoad() {
//        Set_setorConsultGWT set = new Set_setorConsultGWT();
//        Window win = new Window();
//        win.add(set);
//        win.setSize(600, 400);
//        win.setVisible(true);
        AuthenticationGWT winAutenticacao = new AuthenticationGWT();
        winAutenticacao.show();
        
        //PrincipalGWT principalGWT = new PrincipalGWT();
        //RootPanel.get("gwt").add(principalGWT);

    }
}
