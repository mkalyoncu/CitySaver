package com.citysaver.apps.data;

import org.apache.commons.lang3.StringUtils;

public class DataValidator {
    public static boolean isRetrievedDataValid(RetrievedData retrievedData) {
        return StringUtils.isNotBlank(retrievedData.getCity()) && StringUtils.isNotBlank(retrievedData.getDistrict());
    }
}
