package com.krushnatkhawale.plugins.sentry.services;

import com.krushnatkhawale.plugins.sentry.report.SentryReport;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SentryHttpService {

    public void post(SentryReport sentryReport) {

        String url = "http://localhost:8080/sentryReport";

        try {
        HttpRequest sentryReportPostRequest = HttpRequest.newBuilder()
                .uri(new URI(url))
                .POST(HttpRequest.BodyPublishers.ofString(sentryReport.toString()))
                .build();

            HttpResponse<String> httpResponse = HttpClient.newHttpClient().send(sentryReportPostRequest, HttpResponse.BodyHandlers.ofString());

            if(httpResponse.statusCode()==200){
                System.out.println("  Sentry report posted successfully to host: " + url);
            } else {
                System.out.println("  Couldn't post Sentry report, response status: " + url + ", response body: " + httpResponse.body());
            }

        } catch (Exception e) {
            System.out.println("  Error while posting Sentry report to host: " + url);
        }
    }
}