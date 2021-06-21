# Stream-Pi Action API

![version](https://img.shields.io/badge/Version-1.0.0-green)

API for building actions and/or integrations for the Stream-Pi, see [Stream-Pi Essential Actions](https://github.com/stream-pi/essential-actions) for examples of pre-built actions.

## Prerequisites

- Java >= 11
- Maven >= 3.6.3

## Quick Start

Add the following dependency to your pom.xml if not already

```
<dependency>
  <groupId>com.stream-pi</groupId>
  <artifactId>action-api</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

You also need to include Sonatype Snapshot Repository as a repository

```
<repositories>
  <repository>
    <id>sonatype-snapshot</id>
    <url>https://oss.sonatype.org/content/repositories/snapshots</url>
  </repository>
</repositories>
```

You can also build locally by executing `mvn clean install` from the command line.
