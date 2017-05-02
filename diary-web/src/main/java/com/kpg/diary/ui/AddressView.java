package com.kpg.diary.ui;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.kpg.diary.dto.AddressDto;
import com.kpg.diary.dto.AddressViewDto;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Ankit Sood
 * @timeStamp Dec 8, 2016 10:51:15 PM
 */
@Component("addressView")
@UIScope
public class AddressView extends VerticalLayout implements View {

    private CssLayout cssLayout;

    private Button addressBtn;

    private List<AddressViewDto> addressDtos = new LinkedList<>();

    public List<AddressViewDto> getAddressDtos() {
	return addressDtos;
    }

    public Button getAddressBtn() {
	return addressBtn;
    }

    public void setAddressBtn(Button addressBtn) {
	this.addressBtn = addressBtn;
    }

    /**
     * @timeStamp Dec 8, 2016 10:17:21 PM
     */
    private static final long serialVersionUID = 1963863521683569735L;

    /**
     * Create {@link AddressView} view.
     */
    public void init() {
	setPageLayout();
	viewHeader();
	viewContent();
	viewFooter();
    }

    /**
     * Display footer
     */
    private void viewFooter() {
	// TODO Auto-generated method stub
    }

    /**
     * Display content area
     */
    private void viewContent() {

	cssLayout = new CssLayout() {

	    /**
	     * @timeStamp Dec 8, 2016 10:27:05 PM
	     */
	    private static final long serialVersionUID = 1L;

	    @Override
	    protected String getCss(com.vaadin.ui.Component c) {
		return "margin-top: 10px";
	    }
	};
	cssLayout.setSizeFull();
	cssLayout.addStyleName("outlined");
	for (int j = 0; j < addressDtos.size(); j++) {
	    AddressViewDto addressDto = addressDtos.get(j);
	    createNewPanel(j, addressDto.toString());
	}
	addComponent(cssLayout);
    }

    /**
     * 
     * Create panel for display addresses
     * 
     * @param count
     * @param lblText
     */
    public void createNewPanel(int count, String lblText) {
	Panel displayPanel = new Panel("Address " + count);
	displayPanel.setHeight(100.0f, Unit.PERCENTAGE);
	displayPanel.setSizeFull();
	final VerticalLayout contentLayout = new VerticalLayout();
	contentLayout.setWidth(500, Unit.PIXELS);
	contentLayout.setMargin(true);
	Label text = new Label(lblText, ContentMode.PREFORMATTED);
	contentLayout.addComponent(text);
	displayPanel.setContent(contentLayout);
	cssLayout.addComponent(displayPanel);
    }

    /**
     * Display header
     */
    private void viewHeader() {
	CssLayout headingLayout = new CssLayout() {
	    /**
	     * @timeStamp Dec 8, 2016 11:13:30 PM
	     */
	    private static final long serialVersionUID = -2171062243847019658L;

	    @Override
	    protected String getCss(com.vaadin.ui.Component c) {
		// TODO Auto-generated method stub
		return super.getCss(c);
	    }
	};
	headingLayout.setSizeFull();
	HorizontalLayout horizontalLayout = new HorizontalLayout();
	horizontalLayout.setSizeFull();
	
	Label headding = new Label(getPersonName());
	headding.setStyleName(ValoTheme.LABEL_H2);
	
	headding.setSizeFull();
	horizontalLayout.addComponent(headding);
	horizontalLayout.setComponentAlignment(headding, Alignment.TOP_LEFT);
	addressBtn = new Button();
	addressBtn = createBtn("Add Address", FontAwesome.BOOK);
	addressBtn.setSizeUndefined();
	horizontalLayout.addComponent(addressBtn);
	headingLayout.addComponent(horizontalLayout);
	horizontalLayout.setComponentAlignment(addressBtn, Alignment.TOP_RIGHT);
	addComponent(headingLayout);
    }

    /**
     * Set page layout
     */
    private void setPageLayout() {
	setSpacing(true);
	setMargin(true);
    }

    @Override
    public void enter(ViewChangeEvent event) {
	// TODO Auto-generated method stub
    }

    /**
     * 
     * Method is use for create button with custom settings
     * 
     * @param name
     * @param icon
     * @return
     */
    private Button createBtn(String name, FontAwesome icon) {
	Button button = new Button(name);
	button.setIcon(icon);
	button.setSizeUndefined();
	button.setStyleName(ValoTheme.BUTTON_PRIMARY);
	return button;
    }

    private String getPersonName() {
	String name = "Person Address";
	if (null != addressDtos && addressDtos.size() > 0) {
	    AddressViewDto addressViewDto = addressDtos.get(0);
	    name = addressViewDto.getFirstName() + " " + addressViewDto.getLastName();
	}
	return name;
    }

}
