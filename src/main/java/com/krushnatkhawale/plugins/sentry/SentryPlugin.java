package com.krushnatkhawale.plugins.sentry;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

public class SentryPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {

        SentryTask sentryTask = project.getTasks()
                .create("sentryTask", SentryTask.class);

        Task buildTask = project.getTasks().findByName("build");

        buildTask.finalizedBy(sentryTask);

    }
}