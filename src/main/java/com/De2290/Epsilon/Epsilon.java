package com.De2290.Epsilon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Consumer;
import java.util.function.Function;

public class Epsilon {
    private URL url = null;


    public void get(Consumer<Response> fun) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine = null;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        StringBuffer status = new StringBuffer();
        status.append(con.getResponseCode())
                .append(" ")
                .append(con.getResponseMessage())
                .append("\n");

        String headers = con.getHeaderFields().toString();
        in.close();

        fun.accept(new Response(content.toString(), status.toString(), headers));
    }


    public void post(String inputString, Consumer<Response> fun) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        try (OutputStream os = con.getOutputStream()) {
            byte[] input = inputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
        String inputLine = null;
        StringBuffer response = new StringBuffer();
        while((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        StringBuffer status = new StringBuffer();
        status.append(con.getResponseCode())
                .append(" ")
                .append(con.getResponseMessage())
                .append("\n");

        String headers = con.getHeaderFields().toString();
        in.close();

        fun.accept(new Response(response.toString(), status.toString(), headers));



    }

    public Epsilon(String url) throws MalformedURLException {
        this.url = new URL(url);
    }
}
