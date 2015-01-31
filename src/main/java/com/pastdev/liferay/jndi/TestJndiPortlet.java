package com.pastdev.liferay.jndi;


import java.io.IOException;


import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;


public class TestJndiPortlet extends GenericPortlet {
    private static final Logger logger = LoggerFactory.getLogger( TestJndiPortlet.class );

    private static final String ATTRIBUTE_TEST_VALUE = "com.pastdev.liferay.jndi.TestJndiPortlet.testValue";
    private static final String JSP_VIEW = "/view.jsp";

    /** {@inheritDoc} */
    @Override
    protected void doView( RenderRequest request, RenderResponse response )
            throws PortletException, IOException {
        ApplicationContext applicationContext =
                (ApplicationContext) getPortletContext().getAttribute(
                        WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE );
        request.setAttribute( ATTRIBUTE_TEST_VALUE,
                applicationContext.getBean( ATTRIBUTE_TEST_VALUE ) );
        logger.debug( "Forwarding request to {}", JSP_VIEW );
        PortletRequestDispatcher requestDispatcher = getPortletContext()
                .getRequestDispatcher( JSP_VIEW );
        requestDispatcher.forward( request, response );
    }
}
