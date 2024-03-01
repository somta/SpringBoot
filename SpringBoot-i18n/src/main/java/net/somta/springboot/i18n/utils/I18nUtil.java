package net.somta.springboot.i18n.utils;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class I18nUtil {

    public static String getI18nMessage(String i18nKey){

        Locale defaultLocale = Locale.getDefault();
        Locale chinaLocale = Locale.CHINA;
        Locale usLocale = Locale.US;
        Locale usLocale1 = new Locale("en", "US");
        System.out.println(defaultLocale);
        System.out.println(defaultLocale.getLanguage());
        System.out.println(defaultLocale.getCountry());
        System.out.println(chinaLocale);
        System.out.println(usLocale);
        System.out.println(usLocale1);

        //Locale chinaLocale = Locale.CHINA;
        String i18nMsg = null;
        ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n/message", chinaLocale,new Utf8Control());
        try {
            i18nMsg = resourceBundle.getString(i18nKey);
        }catch (MissingResourceException exception) {
            i18nMsg = i18nKey;
        }
        System.out.println(i18nMsg);
        return i18nMsg;
    }
}
