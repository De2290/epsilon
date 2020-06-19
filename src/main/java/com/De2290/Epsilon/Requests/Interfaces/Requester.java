package com.De2290.Epsilon.Requests.Interfaces;

import com.De2290.Epsilon.EpsilonResponse;

import java.net.URL;
import java.util.concurrent.CompletableFuture;

public interface Requester {
    EpsilonResponse request();
}
