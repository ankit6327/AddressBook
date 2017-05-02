package com.kpg.diary.ui;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.kpg.diary.dto.PersonDto;
import com.kpg.diary.service.PersonService;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Grid.SingleSelectionModel;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * The Class MultiSelectTableForPerson.
 */
@org.springframework.stereotype.Component
public class MultiSelectTableForPerson extends VerticalLayout {

    /**
     * 
     */
    private static final long serialVersionUID = -8313782135010273757L;

    @Autowired
    private PersonService personService;

    private Grid grid;

    private Button editButton;

    private Button deleteButton;

    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {
	initiate();
    }

    /**
     * Creates the btn.
     *
     * @param name
     *            the name
     * @param icon
     *            the icon
     * @return the button
     */
    private Button createBtn(String name, FontAwesome icon) {
	Button button = new Button(name);
	button.setIcon(icon);
	button.setSizeUndefined();
	button.setStyleName(ValoTheme.BUTTON_PRIMARY);
	return button;
    }

    /**
     * Initiate.
     */
    public void initiate() {
	grid = new Grid();
	// editButton = createBtn("Edit", FontAwesome.PENCIL);
	deleteButton = createBtn("Delete", FontAwesome.TRASH);
	HorizontalLayout actions = new HorizontalLayout(deleteButton);
	// actions.setComponentAlignment(editButton, Alignment.TOP_RIGHT);
	actions.setComponentAlignment(deleteButton, Alignment.TOP_RIGHT);
	VerticalLayout mainLayout = new VerticalLayout(actions, grid);
	addComponent(mainLayout);
	// Configure layouts and components
	actions.setSpacing(true);
	mainLayout.setMargin(true);
	mainLayout.setSpacing(true);
	grid.setSizeFull();
	// grid.setSelectionMode(SelectionMode.MULTI);
	grid.setSelectionMode(SelectionMode.SINGLE);

	// MultiSelectionModel selection = (MultiSelectionModel)
	// grid.getSelectionModel();
	SingleSelectionModel selection = (SingleSelectionModel) grid.getSelectionModel();

	// selection.setSelected(grid.getContainerDataSource().getItemIds());
	selection.isSelected(grid.getContainerDataSource().getItemIds());

	grid.setColumns("id", "firstName", "lastName", "dob");
	// grid.setEditorEnabled(true);

	grid.addItemClickListener(new ItemClickListener() {

	    @Override
	    public void itemClick(ItemClickEvent event) {
		Object itemId = event.getItemId();
		Component component = event.getComponent();
		grid.setDetailsVisible(itemId, !grid.isDetailsVisible(itemId));
	    }
	});

	grid.addSelectionListener(e -> {
	    System.out.println("start");
	    // Customer selectedCustomer = (Customer) grid.getSelectedRow();
	    for (Object itemId : selection.getSelectedRows()) {
		PersonDto customer = (PersonDto) itemId;
		// itemId.
	    }
	});

	deleteButton.addClickListener(e -> {
	    for (Object itemId : selection.getSelectedRows()) {
		grid.getContainerDataSource().removeItem(itemId);
		personService.deleteById(((PersonDto) itemId).getId());
		// Otherwise out of sync with container
		grid.getSelectionModel().reset();
	    }
	});
	listCustomers(null);
    }

    /**
     * Gets the grid.
     *
     * @return the grid
     */
    public Grid getGrid() {
	return grid;
    }

    /**
     * Gets the edits the button.
     *
     * @return the edits the button
     */
    public Button getEditButton() {
	return editButton;
    }

    /**
     * Gets the delete button.
     *
     * @return the delete button
     */
    public Button getDeleteButton() {
	return deleteButton;
    }

    /**
     * List customers.
     *
     * @param text
     *            the text
     */
    public void listCustomers(String text) {
	if (StringUtils.isEmpty(text)) {
	    grid.setContainerDataSource(
		    new BeanItemContainer<PersonDto>(PersonDto.class, personService.findAllPersonDto()));
	}
    }
}
