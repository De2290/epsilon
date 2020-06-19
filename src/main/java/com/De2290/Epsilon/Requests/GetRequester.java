package com.De2290.Epsilon.Requests;

import com.De2290.Epsilon.EpsilonResponse;
import com.De2290.Epsilon.Requests.Interfaces.Requester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

public class GetRequester implements Requester {
    private URL url;
    public EpsilonResponse request() {
            HttpURLConnection con = null;
            try {
                con = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                con.setRequestMethod("GET");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String inputLine = null;
            StringBuffer content = new StringBuffer();
            while (true) {
                try {
                    if (!((inputLine = in.readLine()) != null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                content.append(inputLine);
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
            return new EpsilonResponse(content.toString(), status.toString(), headers);
    }

    public GetRequester(URL url) {
        this.url = url;
    }
}
