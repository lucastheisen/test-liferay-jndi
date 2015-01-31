package com.pastdev.liferay.controller;

import javax.portlet.GenericPortlet;

import org.springframework.web.context.WebApplicationContext;

abstract public class AbstractSpringServiceLookupControllerPortlet extends
		GenericPortlet {
	protected <T> T service(Class<T> service) {
		return getWebApplicationContext().getBean(service);
	}

	protected WebApplicationContext getWebApplicationContext() {
		return (WebApplicationContext) getPortletContext().getAttribute(
				WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	}
}
