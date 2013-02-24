package com.spring.export.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.spring.export.configuration.UserConfig;
import com.spring.export.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // defaults to "file:src/main/webapp"
//@ContextHierarchy({
//    @ContextConfiguration(name="root", classes = WebAppConfig.class),
//    @ContextConfiguration(name="dispatcher", locations="/spring/user-config.xml")
//})
@ContextConfiguration(classes={UserConfig.class})
public class SetterMessageTest{

    //final Logger logger = LoggerFactory.getLogger(SetterMessageTest.class);

	@Autowired
	@Qualifier("userA")
    private User user = null;

    /**
     * Tests message.
     */
    @Test
    public void testMessage() {   
        assertNotNull("Constructor message instance is null.", user);
        
        String msg = user.getName();
        
        assertNotNull("Message is null.", msg);
        
        String expectedMessage = "userA";
        
        assertEquals("Message should be '" + expectedMessage + "'.", expectedMessage, msg);

        System.out.println("message='{}'"+ msg);
    }
    
}