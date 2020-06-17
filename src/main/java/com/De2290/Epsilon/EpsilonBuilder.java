package com.De2290.Epsilon;

import java.net.MalformedURLException;

public class EpsilonBuilder {

    public static Epsilon createNewRequest(String url) throws MalformedURLException {
        return new Epsilon(url);
    }
}
