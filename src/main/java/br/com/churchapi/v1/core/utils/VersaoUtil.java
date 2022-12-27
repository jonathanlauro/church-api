package br.com.churchapi.v1.core.utils;

import java.io.IOException;
import java.util.Properties;

public interface VersaoUtil {



    static String get() throws IOException {
        final Properties properties = new Properties();
        properties.load(VersaoUtil.class.getClassLoader().getResourceAsStream("project.properties"));
        return properties.get("version").toString();
    }
}
