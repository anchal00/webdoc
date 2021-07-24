package com.example.webdoc.pingUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebsiteAvailabilityChecker {

    private static final int HTTP_STATUS_OK_RESPONSE_CODE = 200;
    private static final int DEFAULT_CONNECTION_TIMEOUT = 5000;

    public static boolean isWebsiteUp(String websiteUrlString) {

        try {
            int statusOfWebsite = getStatusOfWebsite(websiteUrlString);

            if (statusOfWebsite == HTTP_STATUS_OK_RESPONSE_CODE) {
                return true;
            }

        } catch (IOException e) {

            System.err.println("Cannot ping the website");

        }
        return false;

    }

    private static int getStatusOfWebsite(String websiteUrlString) throws IOException {

        URL websiteURL = new URL(websiteUrlString);

        HttpURLConnection connection = (HttpURLConnection) websiteURL.openConnection();

        connection.setRequestMethod("GET");
        connection.setConnectTimeout(DEFAULT_CONNECTION_TIMEOUT);
        connection.connect();

        Integer responseCode = connection.getResponseCode();
        System.out.println("Response Code : " + responseCode);
        return responseCode;
    }
}
