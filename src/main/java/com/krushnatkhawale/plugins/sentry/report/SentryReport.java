package com.krushnatkhawale.plugins.sentry.report;

import com.krushnatkhawale.plugins.sentry.explorer.Info;

import java.util.HashMap;
import java.util.Map;

public class SentryReport{

    private Map<String, Info>  report = new HashMap<>();

    public void addInfo(Info info) {
        report.put(info.getInfoType(), info);
    }

    public Info get(String infoType) {
        return report.get(infoType);
    }

    public Map<String, Info> getReport() {
        return report;
    }
}