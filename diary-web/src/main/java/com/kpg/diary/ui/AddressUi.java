package com.kpg.diary.ui;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpg.diary.bean.AddressBean;
import com.kpg.diary.constants.IConstants;
import com.kpg.diary.dto.PersonDto;
import com.kpg.diary.service.AddressService;
import com.kpg.diary.service.PersonService;
import com.kpg.diary.ui.grid.AddressGrid;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@Component("addressUi")
@UIScope
public class AddressUi extends VerticalLayout implements View {

    /**
     * 
     */
    private static final long serialVersionUID = 8552999927245369803L;

    private Label screenHeading = null;
    private TextField addressId = null;
    private TextField city = null;
    private TextField street1 = null;
    private TextField street2 = null;
    private Button saveAddressFormBtn = null;
    private NativeSelect personSelect = null;
    private TextField number = null;
    private TextField state = null;
    private TextField country = null;
    private TextField zip;
    private TextField phone;

    @Autowired
    private AddressGrid addressGrid;

    @Autowired
    AddressService addressService;

    @Autowired
    PersonService personService;
    
    @Autowired
    private Notifications notifications;

    @PostConstruct
    public void init() {
	setPageLayout();
	viewHeader();
	viewContent();
	viewFooter();
    }

    /**
     * Method is use for apply custom settings to view
     */
    private void setPageLayout() {
	setWidth("100%");
	setMargin(true);
    }

    private void viewFooter() {

    }

    private void viewContent() {
	addressForm();
	listingData();
    }

    /**
     * Add Multi select table in view
     */
    private void listingData() {
	addressGrid.setView(this);
	addComponent(addressGrid);
    }

    /**
     * Method is use for create address form in {@link AddressUi} screen
     */
    private void addressForm() {
	FormLayout form = new FormLayout();
	form.setSizeFull();
	form.setIcon(FontAwesome.BOOK);
	addressId = new TextField("Address Id");
	addressId.setVisible(false);
	addressId.setWidth("70%");
	form.addComponent(addressId);
	// form.setWidth("100%");
	number = new TextField("House Number");
	number.setWidth("70%");
	form.addComponent(number);

	state = new TextField("State");
	state.setWidth("70%");
	form.addComponent(state);

	zip = new TextField("Zip");
	zip.setWidth("70%");
	form.addComponent(zip);

	phone = new TextField("Phone");
	phone.setWidth("70%");
	form.addComponent(phone);

	country = new TextField("Country");
	country.setWidth("70%");
	form.addComponent(country);

	city = new TextField("City");
	city.setWidth("70%");
	form.addComponent(city);

	street1 = new TextField("Street 1");
	street1.setWidth("70%");
	form.addComponent(street1);

	street2 = new TextField("Street 2");
	street2.setWidth("70%");
	form.addComponent(street2);

	personSelect = new NativeSelect("Select Person");
	List<PersonDto> persons = personService.findAllPersonDto();
	for (PersonDto p : persons) {
	    personSelect.addItem(p.getId());
	    personSelect.setItemCaption(p.getId(), p.getFirstName() + " " + p.getLastName());
	}

	personSelect.setValue("");
	form.addComponent(personSelect);

	saveAddressFormBtn = createBtn("SAVE", FontAwesome.SAVE);
	form.addComponent(saveAddressFormBtn);

	saveAddressFormBtn.addClickListener(click -> {
	    AddressBean addressBean = new AddressBean();
	    String saveMessage = "Address Data Saved Sucessfully.";
	    String addressCity = city.getValue();
	    String addressStreet1 = street1.getValue();
	    String addressStreet2 = street2.getValue();
	    addressBean = new AddressBean(addressStreet1, addressStreet2, addressCity);
	    
	    String titleString = personSelect.getItemCaption(personSelect.getValue());
	    if (null == titleString || titleString.isEmpty()) {
		notifications.displayErrorNotification("Title field should not be empty");
		return;
	    }
	    
	    // personSelect = null;
	    if (null != personSelect.getValue() || !(personSelect.getValue().equals(""))) {
		addressBean.setPersonId((Integer) personSelect.getValue());
	    }
	    if (!addressId.isEmpty()) {
		System.out.println("start");
		addressBean.setAddressId(Integer.parseInt(addressId.getValue()));
		saveMessage = "Address Data Updated Sucessfully.";
	    }
	    
	    
	    
	    
	    addressBean.setPhone(phone.getValue());
	    addressBean.setNumber(number.getValue());
	    addressBean.setCountry(country.getValue());
	    addressBean.setState(state.getValue());
	    addressBean.setZip(zip.getValue());
	    addressService.saveAddress(addressBean);
	    addressGrid.listAddress();
	    emptyFields();
	    Notification.show("", saveMessage, Notification.Type.TRAY_NOTIFICATION);
	});
	addComponent(form);
    }

    /**
     * Empty fields.
     */
    public void emptyFields() {
	addressId.clear();
	city.clear();
	street1.clear();
	street2.clear();
	personSelect.clear();
	number.clear();
	phone.clear();
	zip.clear();
	state.clear();
	country.clear();
    }

    /**
     * Method is for create header in view
     */
    private void viewHeader() {
	HorizontalLayout layout = new HorizontalLayout();
	screenHeading = createLbl(IConstants.AddressSceeen.PAGE_HEADING, ValoTheme.LABEL_H2);
	setDefaultComponentAlignment(Alignment.TOP_LEFT);
	layout.setSizeFull();
	layout.setHeightUndefined();
	layout.addComponent(screenHeading);
	layout.setExpandRatio(screenHeading, 3);
	addComponent(layout);
    }

    /**
     * Method is use to create label with custom settings
     * 
     * @param text
     * @param style
     * @return
     */
    private Label createLbl(String text, String style) {

	// style : ValoTheme.LABEL_H1
	Label lbl = new Label(text);
	lbl.setSizeUndefined();
	lbl.setStyleName(style);
	return lbl;
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

    @Override
    public void enter(ViewChangeEvent event) {
	// TODO Auto-generated method stub
    }

    public TextField getCity() {
	return city;
    }

    public TextField getStreet1() {
	return street1;
    }

    public TextField getStreet2() {
	return street2;
    }

    public NativeSelect getPersonSelect() {
	return personSelect;
    }

    public Button getSaveAddressFormBtn() {
	return saveAddressFormBtn;
    }

    public TextField getAddressId() {
	return addressId;
    }

    public TextField getNumber() {
	return number;
    }

    public TextField getAddressState() {
	return state;
    }

    public TextField getCountry() {
	return country;
    }

    public TextField getZip() {
	return zip;
    }

    public TextField getPhone() {
	return phone;
    }

    public void updateDropDown() {
	//personSelect = new NativeSelect("Select Person");
	personSelect.clear();
	List<PersonDto> persons = personService.findAllPersonDto();
	for (PersonDto p : persons) {
	    personSelect.addItem(p.getId());
	    personSelect.setItemCaption(p.getId(), p.getFirstName() + " " + p.getLastName());
	}
    }

}
