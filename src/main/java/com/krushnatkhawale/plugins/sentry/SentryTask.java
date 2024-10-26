package com.krushnatkhawale.plugins.sentry;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class SentryTask extends DefaultTask {

    @TaskAction
    public void sentryAction(){

        System.out.println("\n  HelloWorldTask: HELLO WORLD!");

    }
}