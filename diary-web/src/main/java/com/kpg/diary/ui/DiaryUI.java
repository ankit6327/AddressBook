/**
 * 
 */
package com.kpg.diary.ui;
import org.springframework.beans.factory.annotation.Autowired;
import com.kpg.diary.constants.IConstants;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Ankit Sood Dec 6, 2016
 */
@Theme("valo")
@SpringUI
public class DiaryUI extends UI {

    private static final long serialVersionUID = -1149049882116563172L;

    private boolean testMode = false;

    public static Navigator navigator = null;

    private ComponentContainer viewDisplay = null;

    @Autowired
    
    private AddressUi addressUi;

    @Autowired
    private PersonUi personUi;

    @Autowired
    private MenuLayout menuLayout;

    @Autowired
    private AddressView addressView;

    /*
     * (non-Javadoc)
     * 
     * @see com.vaadin.ui.UI#init(com.vaadin.server.VaadinRequest)
     */
    @Override
    protected void init(VaadinRequest request) {
	responsiveEnable(request);
	addStyleName(ValoTheme.UI_WITH_MENU);
	viewDisplay = menuLayout.getContentContainer();
	setPageTitle("Diary App");
	setContent(menuLayout);
	menuLayout.setWidth("100%");
	addStyleName(ValoTheme.UI_WITH_MENU);
	navigator = new Navigator(this, viewDisplay);
	navigator.addView(IConstants.NavigationMenu.PERSON.getKey(), personUi);
	navigator.addView(IConstants.NavigationMenu.ADDRESS.getKey(), addressUi);
	navigator.addView(IConstants.NavigationMenu.ADDRESS_VIEW.getKey(), addressView);

	String f = Page.getCurrent().getUriFragment();
	if (f == null || f.equals("")) {
	    navigator.navigateTo(IConstants.NavigationMenu.PERSON.getKey());
	}
	menuLayout.createMenu(navigator);
	//clickEvents();
    }

    private boolean browserCantRenderFontsConsistently() {
	return getPage().getWebBrowser().getBrowserApplication().contains("PhantomJS")
		|| (getPage().getWebBrowser().isIE() && getPage().getWebBrowser().getBrowserMajorVersion() <= 9);
    }

    /**
     * For setting title of the application
     * 
     * @param text
     * @timeStamp Dec 8, 2016 11:56:43 PM
     */
    private void setPageTitle(String text) {

    }

    /**
     * For Make application responsive
     * 
     * @param request
     * @timeStamp Dec 8, 2016 11:54:39 PM
     */
    private void responsiveEnable(VaadinRequest request) {
	if (request.getParameter("test") != null) {
	    testMode = true;
	    if (browserCantRenderFontsConsistently()) {
		getPage().getStyles().add(".v-app.v-app.v-app {font-family: Sans-Serif;}");
	    }
	}
	if (getPage().getWebBrowser().isIE() && getPage().getWebBrowser().getBrowserMajorVersion() == 9) {
	    menuLayout.getMenu().setWidth("320px");
	}
	if (!testMode) {
	    Responsive.makeResponsive(this);
	}
    }

}