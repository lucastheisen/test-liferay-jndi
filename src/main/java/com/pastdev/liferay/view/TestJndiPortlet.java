package com.pastdev.liferay.view;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;

public class TestJndiPortlet extends GenericPortlet {
	private static final Logger logger = LoggerFactory
			.getLogger(TestJndiPortlet.class);

	private static final String ATTRIBUTE_VALUE = "com.pastdev.liferay.view.TestJndiPortlet.value";
	private static final String JSP_VIEW = "/view.jsp";

	/** {@inheritDoc} */
	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		request.setAttribute(ATTRIBUTE_VALUE,
				service(com.pastdev.liferay.service.StuffService.class)
						.getStuff());

		logger.debug("Forwarding request to {}", JSP_VIEW);
		PortletRequestDispatcher requestDispatcher = getPortletContext()
				.getRequestDispatcher(JSP_VIEW);
		requestDispatcher.forward(request, response);
	}

	protected <T> T service(Class<T> service) {
		return getWebApplicationContext().getBean(service);
	}

	protected WebApplicationContext getWebApplicationContext() {
		return (WebApplicationContext) getPortletContext().getAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	}
}
