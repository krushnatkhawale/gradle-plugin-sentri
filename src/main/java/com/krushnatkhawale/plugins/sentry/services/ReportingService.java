package com.krushnatkhawale.plugins.sentry.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krushnatkhawale.plugins.sentry.report.SentryReport;
import com.krushnatkhawale.plugins.sentry.explorer.ProjectInfo;

public class ReportingService {
    public void printReport(SentryReport sentryReport) {
        System.out.println("  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!>   S E N T R Y    P L U G I N   <!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("    Application name                : " + ((ProjectInfo)sentryReport.info()).getName());
        System.out.println("    Group                           : " + ((ProjectInfo)sentryReport.info()).getGroup());
        System.out.println("    Artifact name                   : " + ((ProjectInfo)sentryReport.info()).getName());
        System.out.println("    Version                         : " + ((ProjectInfo)sentryReport.info()).getVersion());
        System.out.println("  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public void logReport(SentryReport sentryReport) {
        try {
            String s = new ObjectMapper().writeValueAsString(sentryReport);
            System.out.println("Json report: " + s);
        } catch (JsonProcessingException e) {
            System.out.println("Couldn't convert sentryReport to JSON, exception was: " + e);
        }
    }
}