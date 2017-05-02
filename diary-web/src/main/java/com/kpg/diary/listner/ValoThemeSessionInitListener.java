package com.kpg.diary.listner;

import javax.servlet.annotation.WebServlet;

import org.jsoup.nodes.Element;

import com.kpg.diary.ui.DiaryUI;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.BootstrapFragmentResponse;
import com.vaadin.server.BootstrapListener;
import com.vaadin.server.BootstrapPageResponse;
import com.vaadin.server.CustomizedSystemMessages;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionDestroyEvent;
import com.vaadin.server.SessionDestroyListener;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.SystemMessages;
import com.vaadin.server.SystemMessagesInfo;
import com.vaadin.server.SystemMessagesProvider;
import com.vaadin.server.VaadinServlet;

/*@WebServlet(value = "/", asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = DiaryUI.class)*/
public class ValoThemeSessionInitListener extends VaadinServlet implements SessionInitListener, SessionDestroyListener {

    /**
     * 
     */
    private static final long serialVersionUID = -6866213269399268607L;

    @Override
    public void sessionInit(final SessionInitEvent event) throws ServiceException {
	event.getService().setSystemMessagesProvider(new SystemMessagesProvider() {

	    /**
	     * 
	     */
	    private static final long serialVersionUID = 748353046436036504L;

	    @Override
	    public SystemMessages getSystemMessages(final SystemMessagesInfo systemMessagesInfo) {
		CustomizedSystemMessages csm = new CustomizedSystemMessages();
		csm.setSessionExpiredNotificationEnabled(false);
		return csm;
	    }
	});
	event.getSession().addBootstrapListener(new BootstrapListener() {

	    /**
	     * 
	     */
	    private static final long serialVersionUID = -2316016789680654912L;

	    @Override
	    public void modifyBootstrapPage(final BootstrapPageResponse response) {
		final Element head = response.getDocument().head();
		head.appendElement("meta").attr("name", "viewport").attr("content",
			"width=device-width, initial-scale=1");
		head.appendElement("meta").attr("name", "apple-mobile-web-app-capable").attr("content", "yes");
		head.appendElement("meta").attr("name", "apple-mobile-web-app-status-bar-style").attr("content",
			"black");
	    }

	    @Override
	    public void modifyBootstrapFragment(final BootstrapFragmentResponse response) {
		// TODO Auto-generated method stub
	    }
	});
    }

    @Override
    public void sessionDestroy(SessionDestroyEvent event) {
	// TODO Auto-generated method stub

    }

}
