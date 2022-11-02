## CS441 - Engineering Distributed Objects for Cloud Computing

## HomeWork 1 - Log File Analyzer

### Introduction
The goal of this homework is for students to gain experience with solving a distributed computational problem using cloud computing technologies.

Video Link : 

The video explains deployment of hadoop application in AWS EMR Instance

### Environment
OS: Ubuntu

IDE: IntelliJ IDEA 2022.2.3 (Ultimate Edition)

SCALA Version: 3.2.0

SBT Version: 1.7.1

Hadoop Version: 3.3.4

### Running the test file

Test Files can be found under /src/test/scala/*

````
sbt clean compile test
````

### Running the project

1) Clone this repository

```
repo <TODO>
```
```
cd LogFileAnalyzer
```

2) Open the project in intelliJ

3) Generate jar file by running the following command in the terminal

````
sbt clean compile assembly
````

4) Run the Jar file by running below command

```
sbt run
```