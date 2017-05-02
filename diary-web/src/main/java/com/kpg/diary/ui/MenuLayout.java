/*
 * Copyright 2000-2014 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.kpg.diary.ui;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.annotation.Scope;

import com.kpg.diary.constants.IConstants;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

/**
 * The Class MenuLayout.
 *
 * @author Ankit Sood Dec 6, 2016
 */
@org.springframework.stereotype.Component
//@Scope("prototype")
@UIScope
public class MenuLayout extends HorizontalLayout {

    /**
     * 
     */
    private static final long serialVersionUID = 8686924363838198204L;

    private Map<String, String> menuItems = null;
    private CssLayout menu = new CssLayout();
    private CssLayout menuItemsLayout = new CssLayout();
    private CssLayout contentArea = new CssLayout();
    private CssLayout menuArea = new CssLayout();

    public CssLayout getMenu() {
	return menu;
    }

    /**
     * Instantiates a new menu layout.
     */
    public MenuLayout() {
	setSizeFull();
	menuArea.setPrimaryStyleName(ValoTheme.MENU_ROOT);
	contentArea.setPrimaryStyleName("valo-content");
	contentArea.addStyleName("v-scrollable");
	contentArea.setSizeFull();
	addComponents(menuArea, contentArea);
	setExpandRatio(contentArea, 1);
    }

    /**
     * Gets the content container.
     *
     * @return the content container
     */
    public ComponentContainer getContentContainer() {
	return contentArea;
    }

    /**
     * Adds the menu.
     *
     * @param menu
     *            the menu
     */
    private void addMenu(Component menu) {
	menu.addStyleName(ValoTheme.MENU_PART);
	menuArea.addComponent(menu);
    }

    /**
     * Creates the menu.
     *
     * @param navigator
     *            the navigator
     */
    public void createMenu(Navigator navigator) {
	addMenu(buildMenu(navigator));
    }

    /**
     * Builds the menu.
     *
     * @param navigator
     *            the navigator
     * @return the css layout
     */
    private CssLayout buildMenu(Navigator navigator) {
	// Add items
	menuItemsMap();
	HorizontalLayout top = new HorizontalLayout();
	top.setWidth("100%");
	top.addStyleName(ValoTheme.MENU_TITLE);

	top.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
	top.addStyleName(ValoTheme.MENU_TITLE);
	menu.addComponent(top);
	// menu.addComponent(createThemeSelect());
	menu.addComponent(top);
	Button showMenu = new Button("Menu", new ClickListener() {
	    @Override
	    public void buttonClick(ClickEvent event) {
		if (menu.getStyleName().contains("valo-menu-visible")) {
		    menu.removeStyleName("valo-menu-visible");
		} else {
		    menu.addStyleName("valo-menu-visible");
		}
	    }
	});
	showMenu.addStyleName(ValoTheme.BUTTON_PRIMARY);
	showMenu.addStyleName(ValoTheme.BUTTON_SMALL);
	showMenu.addStyleName("valo-menu-toggle");
	showMenu.setIcon(FontAwesome.LIST);
	menu.addComponent(showMenu);

	Label title = new Label("<h2>Diary</h2>", ContentMode.HTML);
	title.setSizeUndefined();
	top.addComponent(title);
	top.setExpandRatio(title, 1);
	menuItemsLayout.setPrimaryStyleName("valo-menuitems");
	menu.addComponent(menuItemsLayout);
	for (final Entry<String, String> item : menuItems.entrySet()) {
	    Button b = new Button(item.getValue(), new ClickListener() {
		@Override
		public void buttonClick(ClickEvent event) {
		    navigator.navigateTo(item.getKey());
		}
	    });
	    b.setHtmlContentAllowed(true);
	    b.setPrimaryStyleName(ValoTheme.MENU_ITEM);
	    if (IConstants.NavigationMenu.ADDRESS.getKey().equals(item.getKey())) {
		b.setIcon(FontAwesome.BOOK);
	    } else if (IConstants.NavigationMenu.PERSON.getKey().equals(item.getKey())) {
		b.setIcon(FontAwesome.USER);
	    }else{
		b.setIcon(FontAwesome.APPLE);
	    }
	    menuItemsLayout.addComponent(b);
	}
	return menu;
    }

    /**
     * add items in navigation menu section.
     */
    private void menuItemsMap() {
	menuItems = new java.util.LinkedHashMap<String, String>();
	menuItems.put(IConstants.NavigationMenu.PERSON.getKey(), IConstants.NavigationMenu.PERSON.getLblName());
	menuItems.put(IConstants.NavigationMenu.ADDRESS.getKey(), IConstants.NavigationMenu.ADDRESS.getLblName());
	/*
	 * menuItems.put(IConstants.NavigationMenu.ADDRESS_VIEW.getKey(),
	 * IConstants.NavigationMenu.ADDRESS_VIEW.getLblName());
	 */
    }

}
