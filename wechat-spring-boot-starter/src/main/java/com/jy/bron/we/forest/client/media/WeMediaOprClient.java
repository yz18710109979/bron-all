package com.jy.bron.we.forest.client.media;

import com.dtflys.forest.annotation.DataFile;
import com.dtflys.forest.annotation.Request;
import com.jy.bron.core.utils.HttpMethod;
import com.jy.bron.we.constants.WeConstants;
import com.jy.bron.we.domain.dto.media.WeMediaResultDto;
import com.jy.bron.we.forest.interceptor.ForestInterceptor;

import java.io.File;
import java.io.InputStream;

/**
 * @author yangzhi
 * @create 2021/3/8
 */
public interface WeMediaOprClient {

    @Request(url = WeConstants.MEDIA_UPLOAD,
            type = HttpMethod.POST,
            interceptor = {ForestInterceptor.class})
    WeMediaResultDto mediaUpload(String type, @DataFile("file") File file);


    @Request(url = WeConstants.MEDIA_GET,
            type = HttpMethod.GET,
            interceptor = {ForestInterceptor.class})
//    @DownloadFile()
    InputStream mediaGet(String mediaId);


}
