package com.De2290.Epsilon;

import com.De2290.Epsilon.Requests.GetRequester;
import com.De2290.Epsilon.Requests.PostRequester;
import com.De2290.Epsilon.Requests.PutRequester;

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
        GetRequester getRequester = new GetRequester(url);
        return CompletableFuture.supplyAsync(getRequester::request);
    }

    /**
     *
     * @param inputString
     * @return Returns a CompletableFuture that can be completed.
     * @throws IOException
     */
    public CompletableFuture<EpsilonResponse> postRequest(String inputString) throws IOException {
        PostRequester postRequester = new PostRequester(inputString, url);
        return CompletableFuture.supplyAsync(postRequester::request);
    }

    /**
     *
     * @param inputString
     * @return Returns a CompletableFuture that can be completed.
     * @throws IOException
     */
    public CompletableFuture<EpsilonResponse> putRequest(String inputString) throws IOException {
        PutRequester putRequester = new PutRequester(url, inputString);
        return CompletableFuture.supplyAsync(putRequester::request);
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
