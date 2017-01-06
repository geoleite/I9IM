/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.i9.imagemanager.gwt.client;

import com.extjs.gxt.ui.client.event.MenuEvent;

/**
 *
 * @author geoleite
 */
public abstract class AMenuHandler {

    public static final String MENU_HANDLER="menu_handler";
    public static final String MENU_ACTION="menu_action";
    public abstract void actionEventMenu(Object me, String acao);
}
