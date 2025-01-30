# java_base_ui

## _Setup gradle project_

Add dependency to build.gradle

```gradle
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.whitemaks:java_base_ui:1.0.0")
}
```

## _Setup maven project_

Add dependency to pom.xml.

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.whitemaks</groupId>
    <artifactId>java_base_ui</artifactId>
    <version>1.0.0</version>
</dependency>
```