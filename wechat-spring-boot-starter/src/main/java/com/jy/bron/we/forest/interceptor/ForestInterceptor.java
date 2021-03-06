package com.jy.bron.we.forest.interceptor;

import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;

public class ForestInterceptor implements Interceptor<String> {
    @Override
    public boolean beforeExecute(ForestRequest request) {
        return false;
    }

    @Override
    public void onSuccess(String s, ForestRequest forestRequest, ForestResponse forestResponse) {

    }

    @Override
    public void onError(ForestRuntimeException e, ForestRequest forestRequest, ForestResponse forestResponse) {

    }

    @Override
    public void afterExecute(ForestRequest forestRequest, ForestResponse forestResponse) {

    }
}
