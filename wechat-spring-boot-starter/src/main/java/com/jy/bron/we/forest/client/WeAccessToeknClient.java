package com.jy.bron.we.forest.client;

import com.dtflys.forest.annotation.Request;
import com.jy.bron.core.utils.HttpMethod;

/**
 * @author Yangz on:
 */
public interface WeAccessToeknClient {

    @Request(url = "http://localhost:8080/test", type = HttpMethod.GET)
    String firstRequest();
}
