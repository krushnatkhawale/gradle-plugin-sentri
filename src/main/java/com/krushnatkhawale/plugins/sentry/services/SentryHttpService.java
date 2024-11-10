package com.krushnatkhawale.plugins.sentry.services;

import com.krushnatkhawale.plugins.sentry.report.SentryReport;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SentryHttpService {

    public void post(SentryReport sentryReport, String reportFilePath) {

        String url = "http://localhost:8080/sentryReports";

        try {
            HttpRequest sentryReportPostRequest = HttpRequest.newBuilder()
                .uri(new URI(url))
                .PUT(HttpRequest.BodyPublishers.ofString(sentryReport.toString()))
                .build();

            HttpResponse<String> httpResponse = HttpClient.newHttpClient().send(sentryReportPostRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println("  Sentry report publish request  URL    : " + url);
            System.out.println("  Sentry report publish request  BODY   : file://" + reportFilePath);
            System.out.println("  Sentry report publish response STATUS : " + httpResponse.statusCode());
            System.out.println("  Sentry report publish response BODY   : " + httpResponse.body());

        } catch (Exception e) {
            System.out.println("  Error while posting Sentry report to host: " + url);
        }
    }
}