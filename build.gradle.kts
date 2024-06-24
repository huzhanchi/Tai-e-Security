plugins {
    java
    application
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

application {
    mainClass.set("org.example.MyMain")
}

val taieVersion = "0.5.1-SNAPSHOT"
val jasperVersion = "9.0.36"
val antVersion = "1.10.14"

dependencies {
    implementation("net.pascal-lab:tai-e:$taieVersion")
//    implementation("org.apache.tomcat.embed:tomcat-embed-jasper:$jasperVersion")
//    implementation("org.apache.ant:ant:$antVersion")
}