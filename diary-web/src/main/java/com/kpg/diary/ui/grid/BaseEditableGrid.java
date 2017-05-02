package com.kpg.diary.ui.grid;

import javax.annotation.PostConstruct;

import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
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
 * @author Jatinder Pal Singh
 * @since 08-Dec-2016
 */
public abstract class BaseEditableGrid extends VerticalLayout implements View {

    private static final long serialVersionUID = 2478263562456995010L;

    public Grid grid;

    protected Button editButton;

    protected View view;

    public Grid getGrid() {
	return grid;
    }

    public void setGrid(Grid grid) {
	this.grid = grid;
    }

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
	VerticalLayout mainLayout = new VerticalLayout(grid);
	addComponent(mainLayout);
	// Configure layouts and components
	mainLayout.setMargin(true);
	mainLayout.setSpacing(true);
	grid.setSizeFull();
	grid.setSelectionMode(SelectionMode.SINGLE);
	SingleSelectionModel selection = (SingleSelectionModel) grid.getSelectionModel();
	selection.isSelected(grid.getContainerDataSource().getItemIds());
    }

    @Override
    public void enter(ViewChangeEvent event) {
	// TODO Auto-generated method stub

    }

    /**
     * Sets the view.
     *
     * @param view
     *            the new view
     */
    public void setView(View view) {
	this.view = view;
    }

}
