package com.krushnatkhawale.plugins.sentry.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.krushnatkhawale.plugins.sentry.explorer.ProjectInfo;
import com.krushnatkhawale.plugins.sentry.report.SentryReport;
import groovy.transform.Undefined;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;

public class ReportingService {

    public void logReport(SentryReport sentryReport) {
        System.out.println("  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!>   S E N T R Y    P L U G I N   <!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("    Application name                : " + ((ProjectInfo)sentryReport.get("projectInfo")).getName());
        System.out.println("    Group                           : " + ((ProjectInfo)sentryReport.get("projectInfo")).getGroup());
        System.out.println("    Artifact name                   : " + ((ProjectInfo)sentryReport.get("projectInfo")).getName());
        System.out.println("    Version                         : " + ((ProjectInfo)sentryReport.get("projectInfo")).getVersion());
        System.out.println("  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public void writeReportToFile(SentryReport sentryReport)  {
        String s = transformToJson(sentryReport);
        String fileName = "a-file";
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Files.writeString(Paths.get(fileName), s, StandardOpenOption.WRITE);
            System.out.println("SentryReport could be found at: " + fileName);
        } catch (Exception e) {
            System.out.println("Couldn't write SentryReport to file '" + fileName + "', error was: " + e);
        }
    }

    private static String transformToJson(SentryReport sentryReport) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sentryReport.getReport());
        } catch (JsonProcessingException e) {
            System.out.println("Couldn't convert sentryReport to JSON, exception was: " + e);
            return "EMPTY REPORT";
        }
    }

    public void logAndWriteToFile(SentryReport sentryReport) {
        logReport(sentryReport);
        writeReportToFile(sentryReport);
    }
}