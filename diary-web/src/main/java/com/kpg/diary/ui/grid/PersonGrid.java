package com.kpg.diary.ui.grid;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.vaadin.dialogs.ConfirmDialog;

import com.kpg.diary.constants.IConstants;
import com.kpg.diary.dto.AddressViewDto;
import com.kpg.diary.dto.AddressDto;
import com.kpg.diary.dto.PersonDto;
import com.kpg.diary.model.Address;
import com.kpg.diary.service.AddressService;
import com.kpg.diary.service.PersonService;
import com.kpg.diary.ui.AddressView;
import com.kpg.diary.ui.DiaryUI;
import com.kpg.diary.ui.Notifications;
import com.kpg.diary.ui.PersonUi;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.GeneratedPropertyContainer;
import com.vaadin.data.util.PropertyValueGenerator;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Grid.SingleSelectionModel;
import com.vaadin.ui.renderers.ButtonRenderer;

/**
 * @author Jatinder Pal Singh
 * @since 08-Dec-2016
 */
@Component("personGrid")
// @Scope("prototype")
@UIScope
public class PersonGrid extends BaseEditableGrid {

    private static final long serialVersionUID = 5150866889570109716L;

    private BeanItemContainer<PersonDto> beanItemContainer = null;

    @Autowired
    private PersonService personService;

    private SingleSelectionModel selection;

    private List<AddressDto> addressDtos;

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressView addressView;

    @Autowired
    private Notifications notifications;

    public List<AddressDto> getAddressDtos() {
	return addressDtos;
    }

    @Override
    public void initiate() {
	super.initiate();
	grid.setColumns("id", "title", "firstName", "lastName", "dob", "mobile", "email", "edit", "delete", "show");
	addActionBtnsInGrid();
	selection = (SingleSelectionModel) grid.getSelectionModel();
	beanItemContainer = new BeanItemContainer<PersonDto>(PersonDto.class, personService.findAllPersonDto());
	GeneratedPropertyContainer gpc = new GeneratedPropertyContainer(beanItemContainer);
	gpc.addGeneratedProperty("delete", new PropertyValueGenerator<String>() {
	    @Override
	    public String getValue(Item item, Object itemId, Object propertyId) {
		// TODO Auto-generated method stub
		return "Delete"; // The caption
	    }

	    @Override
	    public Class<String> getType() {
		// TODO Auto-generated method stub
		return String.class;
	    }

	});

	gpc.addGeneratedProperty("edit", new PropertyValueGenerator<String>() {

	    @Override
	    public String getValue(Item item, Object itemId, Object propertyId) {
		// TODO Auto-generated method stub
		return "Edit"; // The caption
	    }

	    @Override
	    public Class<String> getType() {
		// TODO Auto-generated method stub
		return String.class;
	    }

	});

	gpc.addGeneratedProperty("show", new PropertyValueGenerator<String>() {

	    @Override
	    public String getValue(Item item, Object itemId, Object propertyId) {
		// TODO Auto-generated method stub
		return "Show"; // The caption
	    }

	    @Override
	    public Class<String> getType() {
		// TODO Auto-generated method stub
		return String.class;
	    }

	});
	this.listPersons();
    }

    /**
     * Display list of persons
     */
    public void listPersons() {
	beanItemContainer = new BeanItemContainer<PersonDto>(PersonDto.class, personService.findAllPersonDto());
	grid.setContainerDataSource(beanItemContainer);
    }

    /**
     * For add action btns in grid
     */
    public void addActionBtnsInGrid() {
	grid.getDefaultHeaderRow().join("edit", "delete", "show").setText("Actions");
	grid.getColumn("delete").setWidth(100);
	grid.getColumn("delete").setRenderer(new ButtonRenderer(e -> {
	    ConfirmDialog.show(getUI(), "Delete", "Are you really sure?", "Yes", "No", new ConfirmDialog.Listener() {

		public void onClose(ConfirmDialog dialog) {
		    if (dialog.isConfirmed()) {
			grid.getContainerDataSource().removeItem(e.getItemId());
			personService.deleteById(((PersonDto) e.getItemId()).getId());
			// Otherwise out of sync with container
			grid.getSelectionModel().reset();
			// Confirmed to continue
		    } else {
			// User did not confirm
		    }
		}
	    });

//	    grid.getContainerDataSource().removeItem(e.getItemId());
//	    personService.deleteById(((PersonDto) e.getItemId()).getId());
//	    // Otherwise out of sync with container
//	    grid.getSelectionModel().reset();
	}));

	grid.getColumn("edit").setWidth(80);
	// grid.setResponsive(false);
	ButtonRenderer buttonRenderer = new ButtonRenderer(e -> {
	    PersonDto persondto = (PersonDto) e.getItemId();
	    PersonUi ui = (PersonUi) view;
	    ui.getPersonId().setValue(String.valueOf(persondto.getId()));
	    ui.getFirstName().setValue(persondto.getFirstName());
	    ui.getLastName().setValue(persondto.getLastName());
	    ui.getMobile().setValue(persondto.getMobile());
	    ui.getEmail().setValue(persondto.getEmail());
	    ui.getDob().setValue(persondto.getDob());
	    ui.getTitle().select(persondto.getTitle());
	});

	/*
	 * Button button = (Button) buttonRenderer.getUI();
	 * button.setIcon(FontAwesome.TRASH); button.setSizeUndefined();
	 * button.setStyleName(ValoTheme.BUTTON_PRIMARY);
	 */
	grid.getColumn("edit").setRenderer(buttonRenderer);
	grid.getColumn("show").setWidth(100);
	grid.getColumn("show").setRenderer(new ButtonRenderer(e -> {
	    PersonDto personDtoObj = (PersonDto) e.getItemId();
	    List<AddressViewDto> address = addressService.findAllAddressViewDto(personDtoObj.getId());
	    if (null != address && address.size() > 0) {
		// List<AddressViewDto> addressViews =
		// addressService.findAllAddressViewDto(personDtoObj.getId());

		
		addressView.getAddressDtos().addAll(address);
		addressView.init();
		DiaryUI.navigator.navigateTo(IConstants.NavigationMenu.ADDRESS_VIEW.getKey());
	    } else {
		notifications.displayWarningNotification("No addresses are related to this person");
	    }
	}));
    }

}
