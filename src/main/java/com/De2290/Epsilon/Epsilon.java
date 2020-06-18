package com.De2290.Epsilon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

public class Epsilon {
    private URL url = null;

    /**
     *
     * @return Returns a CompletableFuture that can be completed.
     * @throws IOException
     */
    public CompletableFuture<EpsilonResponse> getRequest() throws IOException {
        return CompletableFuture.supplyAsync(() -> {
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
        });
    }

    /**
     *
     * @param inputString
     * @return Returns a CompletableFuture that can be completed.
     * @throws IOException
     */
    public CompletableFuture<EpsilonResponse> postRequest(String inputString) throws IOException {
        return CompletableFuture.supplyAsync(() -> {
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
        });



    }

    /**
     *
     * @param url
     * @throws MalformedURLException
     */
    public Epsilon(String url) throws MalformedURLException {
        this.url = new URL(url);
    }
}
