package com.gpengtao.test.other;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by gpengtao on 15/3/23.
 */
public class TestLocal {

    @Test
    public void test(){
        Locale locale = Locale.getDefault();
        System.out.println(locale.getCountry());
        System.out.println(locale.getLanguage());
        System.out.println(locale.getDisplayCountry());
        System.out.println(locale.getDisplayLanguage());
    }

    @Test
    public void testResourceBundle(){
        ResourceBundle messages = ResourceBundle.getBundle("messages", Locale.CHINA);
        System.out.println(messages);
        System.out.println(messages.getString("login.user"));

        ResourceBundle usMessage = ResourceBundle.getBundle("messages", Locale.US);
        System.out.println(usMessage);
        System.out.println(usMessage.getString("login.user"));
    }

}
