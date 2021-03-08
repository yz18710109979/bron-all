package com.jy.bron.we.forest.client.media;

import com.dtflys.forest.annotation.DataFile;
import com.dtflys.forest.annotation.DataObject;
import com.dtflys.forest.annotation.Request;
import com.dtflys.forest.extensions.DownloadFile;
import com.jy.bron.core.utils.HttpMethod;
import com.jy.bron.we.constants.Constants;
import com.jy.bron.we.domain.dto.media.WeMediaResultDto;

import java.io.File;
import java.io.InputStream;

/**
 * @author yangzhi
 * @create 2021/3/8
 */
public interface WeMediaOprClient {

    @Request(url = Constants.MEDIA_UPLOAD, type = HttpMethod.POST)
    WeMediaResultDto mediaUpload(String type, @DataFile("file") File file);


    @Request(url = Constants.MEDIA_GET, type = HttpMethod.GET)
//    @DownloadFile()
    InputStream mediaGet(String mediaId);


}
