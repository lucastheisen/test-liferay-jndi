<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ page import="javax.portlet.PortletPreferences"%>

<portlet:defineObjects />

<span class="test-jndi">${requestScope['com.pastdev.liferay.view.TestJndiPortlet.value'].stuff}</span>
