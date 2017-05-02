package com.kpg.diary.ui.grid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.vaadin.dialogs.ConfirmDialog;

import com.kpg.diary.dto.AddressDto;
import com.kpg.diary.dto.PersonDto;
import com.kpg.diary.service.AddressService;
import com.kpg.diary.ui.AddressUi;
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
@Component("addressGrid")
@UIScope
public class AddressGrid extends BaseEditableGrid {

    private static final long serialVersionUID = 9076054810139352999L;

    @Autowired
    private AddressService addressService;

    private BeanItemContainer beanItemContainer;

    @Override
    public void initiate() {
	super.initiate();
	grid.setColumns("addressId", "number", "line1", "line2", "city", "personName","state","country","zip","phone", "edit", "delete");
	beanItemContainer = new BeanItemContainer<AddressDto>(AddressDto.class, addressService.findAllAddressDto());
	addActionBtnsInGrid();
	SingleSelectionModel selection = (SingleSelectionModel) grid.getSelectionModel();
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
	this.listAddress();
    }

    public void listAddress() {
	beanItemContainer = new BeanItemContainer<AddressDto>(AddressDto.class, addressService.findAllAddressDto());
	grid.setContainerDataSource(beanItemContainer);
    }

    /**
     * For add action btns in grid
     */
    public void addActionBtnsInGrid() {
	grid.getDefaultHeaderRow().join("edit", "delete").setText("Actions");

	grid.getColumn("delete").setWidth(100);
	grid.getColumn("delete").setRenderer(new ButtonRenderer(e -> {
	    ConfirmDialog.show(getUI(), "Delete", "Are you really sure?", "Yes", "No", new ConfirmDialog.Listener() {

		public void onClose(ConfirmDialog dialog) {
		    if (dialog.isConfirmed()) {
			 grid.getContainerDataSource().removeItem(e.getItemId());
			    addressService.deleteById(((AddressDto) e.getItemId()).getAddressId());
			    // Otherwise out of sync with container
			    grid.getSelectionModel().reset();
			// Confirmed to continue
		    } else {
			// User did not confirm
		    }
		}
	    });
//	    grid.getContainerDataSource().removeItem(e.getItemId());
//	    addressService.deleteById(((AddressDto) e.getItemId()).getAddressId());
//	    // Otherwise out of sync with container
//	    grid.getSelectionModel().reset();
	}

	));
	grid.getColumn("edit").setWidth(80);
	grid.getColumn("edit").setRenderer(new ButtonRenderer(e -> {
	    AddressDto addressdto = (AddressDto) e.getItemId();
	    AddressUi ui = (AddressUi) view;
	    ui.getStreet1().setValue(addressdto.getLine1());
	    ui.getStreet2().setValue(addressdto.getLine2());
	    ui.getCity().setValue(addressdto.getCity());
	    ui.getPersonSelect().setValue(addressdto.getPersonId());
	    ui.getAddressId().setValue(String.valueOf(addressdto.getAddressId()));
	  /*  ui.getAddressState().setValue(addressdto.getState());
	    ui.getCountry().setValue(addressdto.getCountry());
	    ui.getZip().setValue(addressdto.getZip());
	    ui.getPhone().setValue(addressdto.getPhone());
	    ui.getNumber().setValue(addressdto.getNumber());*/
	}));
    }
}
