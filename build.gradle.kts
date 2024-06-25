plugins {
    java
}

repositories {
    mavenCentral()
    maven { url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/") }
}

group = "org.example"
description = "tai-e-for-cve-2021-44228"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

val taieVersion = "0.5.1-SNAPSHOT"
val jasperVersion = "9.0.36"
val antVersion = "1.10.14"

tasks.register<JavaExec>("jsp_convert") {
    javaLauncher = javaToolchains.launcherFor {
        languageVersion = JavaLanguageVersion.of(17)
    }
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("org.example.JspMain")
}

tasks.register<JavaExec>("webshell") {
    group = "detections"
    javaLauncher = javaToolchains.launcherFor {
        languageVersion = JavaLanguageVersion.of(17)
    }
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("org.example.MyMain")
    mustRunAfter("jsp_convert")
    dependsOn("jsp_convert")
    args = listOf("java-benchmarks/webshell/options.yml")
}

tasks.register<JavaExec>("log4j") {
    group = "detections"
    javaLauncher = javaToolchains.launcherFor {
        languageVersion = JavaLanguageVersion.of(17)
    }
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("org.example.MyMain")
    args = listOf("java-benchmarks/log4j/2.14.0/options.yml")
}

dependencies {
    implementation("net.pascal-lab:tai-e:$taieVersion")
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper:$jasperVersion")
    implementation("org.apache.ant:ant:$antVersion")
}