package com.easymoney.tradingnet.service.http;

import com.easymoney.tradingnet.vo.FoundInformationVO;

public interface HttpService {

    FoundInformationVO getFoundInformation(String foundCode, String foundName);

}
