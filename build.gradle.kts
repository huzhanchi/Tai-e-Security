plugins {
    java
}

repositories {
    mavenCentral()
    maven { url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/") }
}

group = "org.oarmour.security"
description = "tai-e-security"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

// prepare
tasks.register<JavaExec>("jsp_convert") {
    group = "TaiE-prepare"
    javaLauncher = javaToolchains.launcherFor {
        languageVersion = JavaLanguageVersion.of(17)
    }
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("org.oarmour.security.main.JspConverterMain")
    args = listOf("java-benchmarks/webshell/0x00.jsp","java-benchmarks/webshell")
}

tasks.register<JavaExec>("servlet_codegen") {
    group = "TaiE-prepare"

    javaLauncher = javaToolchains.launcherFor {
        languageVersion = JavaLanguageVersion.of(17)
    }
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("org.oarmour.security.main.MockServlet4SpringMain")
    args = listOf("java-benchmarks/java-sec-code/java-sec-code-1.0.0.jar","java-benchmarks/java-sec-code/MyServlet.java")
}

tasks.register<JavaCompile>("compile_servlet") {
    group = "TaiE-prepare"

    source("java-benchmarks/java-sec-code/MyServlet.java")
    destinationDirectory.set(file("java-benchmarks/java-sec-code"))
    classpath = sourceSets["main"].runtimeClasspath.plus(files("java-benchmarks/java-sec-code/java-sec-code-1.0.0.jar"))

    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
}

tasks.register<JavaCompile>("compile_log4j_entry") {
    group = "TaiE-prepare"

    source("java-benchmarks/log4j/2.14.0/Entry.java")
    destinationDirectory.set(file("java-benchmarks/log4j/2.14.0"))
    classpath = sourceSets["main"].runtimeClasspath.plus(files("java-benchmarks/log4j/2.14.0/log4j-api-2.14.0.jar","java-benchmarks/log4j/2.14.0/log4j-core-2.14.0.jar"))

    sourceCompatibility = "1.8"
    targetCompatibility = "1.8"
}

//detections
tasks.register<JavaExec>("webshell") {
    group = "TaiE-detection"
    javaLauncher = javaToolchains.launcherFor {
        languageVersion = JavaLanguageVersion.of(17)
    }
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("pascal.taie.Main")
    dependsOn("jsp_convert")
    args = listOf("--options-file","java-benchmarks/webshell/options.yml")
}

tasks.register<JavaExec>("log4j") {
    group = "TaiE-detection"
    javaLauncher = javaToolchains.launcherFor {
        languageVersion = JavaLanguageVersion.of(17)
    }
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("pascal.taie.Main")
    args = listOf("--options-file","java-benchmarks/log4j/2.14.0/options.yml")

    dependsOn("compile_log4j_entry")
}


tasks.register<JavaExec>("java-sec-code") {
    group = "TaiE-detection"
    javaLauncher = javaToolchains.launcherFor {
        languageVersion = JavaLanguageVersion.of(17)
    }
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("pascal.taie.Main")
    dependsOn("compile_servlet")
    args = listOf("--options-file","java-benchmarks/java-sec-code/options.yml")
}

val taieVersion = "0.5.1-SNAPSHOT"
val jasperVersion = "9.0.36"
val antVersion = "1.10.14"
dependencies {
    implementation("net.pascal-lab:tai-e:$taieVersion")
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper:$jasperVersion")
    implementation("org.apache.ant:ant:$antVersion")
    "org.soot-oss:soot:4.4.1".let {
        // Disable transitive dependencies from Soot in compile classpath
        compileOnly(it) { isTransitive = false }
        testCompileOnly(it) { isTransitive = false }
        runtimeOnly(it)
    }
    implementation("org.apache.velocity:velocity:1.7")
}