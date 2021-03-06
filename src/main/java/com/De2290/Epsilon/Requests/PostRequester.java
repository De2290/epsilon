package com.De2290.Epsilon.Requests;

import com.De2290.Epsilon.EpsilonResponse;
import com.De2290.Epsilon.Requests.Interfaces.Requester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

public class PostRequester implements Requester {
    private String inputString;
    private URL url;

    public PostRequester(String inputString, URL url) {
        this.inputString = inputString;
        this.url = url;
    }

    public EpsilonResponse request() {
            HttpURLConnection con = null;
            try {
                con = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                con.setRequestMethod("POST");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            try {
                try (OutputStream os = con.getOutputStream()) {
                    byte[] input = inputString.getBytes(StandardCharsets.UTF_8);
                    os.write(input, 0, input.length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String inputLine = null;
            StringBuffer response = new StringBuffer();
            while(true) {
                try {
                    if (!((inputLine = in.readLine()) != null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                response.append(inputLine);
            }
            StringBuffer status = new StringBuffer();
            try {
                status.append(con.getResponseCode())
                        .append(" ")
                        .append(con.getResponseMessage())
                        .append("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

            String headers = con.getHeaderFields().toString();
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return new EpsilonResponse(response.toString(), status.toString(), headers);

    }
}
