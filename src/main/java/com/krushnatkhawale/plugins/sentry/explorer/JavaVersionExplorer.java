package com.krushnatkhawale.plugins.sentry.explorer;

import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.jvm.toolchain.JavaLanguageVersion;

public class JavaVersionExplorer implements InfoExplorer {
    @Override
    public JavaInfo explore(Project project) {
        JavaPluginExtension javaPluginExtension = project.getExtensions().getByType(JavaPluginExtension.class);

        if (javaPluginExtension != null) {

            JavaLanguageVersion languageVersion = javaPluginExtension.getToolchain().getLanguageVersion().getOrNull();

            if (languageVersion != null) {
                int javaVersionAsInteger = languageVersion.asInt();
                String javaVersionAsString = languageVersion.toString();
                return new JavaInfo(javaVersionAsInteger, javaVersionAsString);
            } else {
                project.getLogger().lifecycle("Java languageVersion is not specified for this project.");
                return new JavaInfo(0, "UNKNOWN");
            }
        } else {
            project.getLogger().lifecycle("Java toolchain is not specified for this project.");
            return new JavaInfo(0, "UNKNOWN");
        }
    }
}
