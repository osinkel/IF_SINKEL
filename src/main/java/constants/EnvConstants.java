package constants;

import config.ConfigReader;

public class EnvConstants {

    public static final String RICKANDMORTY_URL = ConfigReader.getProp("rickandmorty.api.url");
    public static final String REQRES_URL = ConfigReader.getProp("reqres.api.url");
}
