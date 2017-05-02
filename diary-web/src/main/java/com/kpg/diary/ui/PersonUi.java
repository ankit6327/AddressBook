package com.kpg.diary.ui;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kpg.diary.bean.PersonBean;
import com.kpg.diary.constants.IConstants;
import com.kpg.diary.service.PersonService;
import com.kpg.diary.ui.grid.PersonGrid;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Ankit Sood Dec 6, 2016
 */

@Component("personUi")
// @Scope("prototype")
@UIScope
public class PersonUi extends VerticalLayout implements View {

    /**
     * 
     */
    private static final long serialVersionUID = -4295105167069514520L;

    private Label screenHeading = null;
    private TextField firstName = null;
    private TextField lastName = null;
    private Button savePersonFormBtn = null;
    private DateField dob = null;
    private TextField personId = null;
    private NativeSelect title = null;
    private TextField mobile = null;
    private TextField email = null;

    @Autowired
    private PersonGrid personGrid;

    @Autowired
    private PersonService personService;

    @Autowired
    private Notifications notifications;

    @Autowired
    private AddressUi addressUi;

    /**
     * initiate view
     */
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
	// setSpacing(true);
	setMargin(true);
	// setMargin(true);
    }

    /**
     * Components to be display in footer area.
     */
    private void viewFooter() {

    }

    /**
     * Components to be display in content area.
     */
    private void viewContent() {
	addressForm();
	listingData();
    }

    /**
     * Add Multi select table in view
     */
    private void listingData() {
	personGrid.setView(this);
	addComponent(personGrid);
    }

    /**
     * Method is use for create address form in {@link PersonUi} screen
     */
    private void addressForm() {

	FormLayout form = new FormLayout();
	form.setSizeFull();
	form.setIcon(FontAwesome.USER);
	personId = new TextField("Person Id");
	personId.setVisible(false);
	personId.setWidth("70%");
	form.addComponent(personId);

	title = new NativeSelect("Title");
	title.addItem("Mr.");
	title.addItem("Mrs.");
	form.addComponent(title);
	// form.setWidth("100%");
	firstName = new TextField("First Name");
	firstName.setWidth("70%");
	form.addComponent(firstName);

	lastName = new TextField("Last Name");
	lastName.setWidth("70%");
	form.addComponent(lastName);

	dob = new DateField("DOB");
	dob.setWidth("70%");
	form.addComponent(dob);

	mobile = new TextField("Mobile Number");
	mobile.setWidth("70%");
	form.addComponent(mobile);

	email = new TextField("Email");
	email.setWidth("70%");
	form.addComponent(email);

	savePersonFormBtn = createBtn("SAVE", FontAwesome.SAVE);
	form.addComponent(savePersonFormBtn);

	savePersonFormBtn.addClickListener(click -> {
	    String saveMessage = "Person Data Saved Sucessfully.";
	    String fName = firstName.getValue();
	    String lName = lastName.getValue();
	    Date dofb = dob.getValue();
	    String titleString = title.getItemCaption(title.getValue());
	    String mobileNum = mobile.getValue();
	    String emailString = email.getValue();

	    if (null == titleString || titleString.isEmpty()) {
		notifications.displayErrorNotification("Title field should not be empty");
		return;
	    }

	    if (null == fName || fName.isEmpty()) {
		notifications.displayErrorNotification("First Name field should not be empty");
		return;
	    }
	    if (null == lName || lName.isEmpty()) {
		notifications.displayErrorNotification("Last Name field should not be empty");
		return;
	    }

	    if (!StringUtils.isNumeric(mobileNum)) {
		notifications.displayErrorNotification("Mobile Number Must be Numeric.");
		return;
	    }
	    if (!emailString.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
		notifications.displayErrorNotification("Not Valid Email");
		return;
	    }
	    PersonBean bean = new PersonBean(fName, lName, dofb);
	    bean.setTitle(titleString);
	    bean.setMobile(mobileNum);
	    bean.setEmail(emailString);
	    if (!personId.isEmpty()) {
		bean.setId(Integer.parseInt(personId.getValue()));
		saveMessage = "Person Data Updated Sucessfully.";
	    }
	    personService.savePerson(bean);
	    personGrid.listPersons();
	    emptyFields();
	    Notification.show("", saveMessage, Notification.Type.TRAY_NOTIFICATION);
	    addressUi.updateDropDown();
	});
	addComponent(form);
    }

    /**
     * set all fields empty.
     */
    public void emptyFields() {
	personId.clear();
	firstName.setValue("");
	lastName.setValue("");
	dob.setValue(null);
	title.clear();
	mobile.clear();
	email.clear();
    }

    /**
     * Method is for create header in view
     */
    private void viewHeader() {
	HorizontalLayout layout = new HorizontalLayout();
	// addPersonBtn = createBtn("ADD ADDRESS", FontAwesome.PLUS);
	screenHeading = createLbl(IConstants.PersonSceeen.PAGE_HEADING, ValoTheme.LABEL_H2);
	setDefaultComponentAlignment(Alignment.TOP_LEFT);
	layout.setSizeFull();
	layout.setHeightUndefined();
	layout.addComponent(screenHeading);
	// layout.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
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
	lbl.setWidth("100%");
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

    public TextField getFirstName() {
	return firstName;
    }

    public TextField getLastName() {
	return lastName;
    }

    public DateField getDob() {
	return dob;
    }

    public TextField getPersonId() {
	return personId;
    }

    public NativeSelect getTitle() {
	return title;
    }

    public TextField getMobile() {
	return mobile;
    }

    public TextField getEmail() {
	return email;
    }

    public Button getSavePersonFormBtn() {
	return savePersonFormBtn;
    }

}
