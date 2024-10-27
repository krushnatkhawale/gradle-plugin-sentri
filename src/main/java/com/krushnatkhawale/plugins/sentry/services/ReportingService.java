package com.krushnatkhawale.plugins.sentry.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.krushnatkhawale.plugins.sentry.report.SentryReport;
import com.krushnatkhawale.plugins.sentry.explorer.ProjectInfo;

public class ReportingService {
    public void printReport(SentryReport sentryReport) {
        System.out.println("  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!>   S E N T R Y    P L U G I N   <!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("    Application name                : " + ((ProjectInfo)sentryReport.get("projectInfo")).getName());
        System.out.println("    Group                           : " + ((ProjectInfo)sentryReport.get("projectInfo")).getGroup());
        System.out.println("    Artifact name                   : " + ((ProjectInfo)sentryReport.get("projectInfo")).getName());
        System.out.println("    Version                         : " + ((ProjectInfo)sentryReport.get("projectInfo")).getVersion());
        System.out.println("  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public void logReport(SentryReport sentryReport) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sentryReport.getReport());
            System.out.println("Json report:\n" + s);
        } catch (JsonProcessingException e) {
            System.out.println("Couldn't convert sentryReport to JSON, exception was: " + e);
        }
    }
}