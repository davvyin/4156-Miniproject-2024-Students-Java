# Welcome Students of 4156

Please follow the assignment specifications on Courseworks when completing this project.

How to run the run the (PMD) static code analyzer(under ./IndividualProject):
<!-- mvn pmd:check -->
```
pmd check -d ./src/main/java -R rulesets/java/quickstart.xml -f text
```

How to run the java test suit:

```
mvn test
```

How to generate jacoco code coverage report:

```
mvn jacoco:report
```

How to check the code style:

```
mvn checkstyle:checkstyle
```
