# WebUITestAutomation

***Objectives of the Assignment***
```
1. Automation test for a website or a desktop application.
2. At least 5 test cases including these: 
    a Search feature
    b Upload a file
3. Add an HTML report of test results
4. Report any bugs you find by writing a bug ticket
5. A document with the test flows.
6. Run tests in a continuous integration tool and optionally in the cloud
```
***Tech Stack used in the project***
```
1. Programming Language : Java
2. Design Pattern: Page Object Model with Page Factory
3. BDD layer: Cucumber
4. Unit Testing framework: JUnit
5. Dependency Management: Maven
6. Continuous Integration: CircleCI
7. Reporting: Extent Reporting
8. Source code Management: Gitlab
```
***Pre-requisites to run the Project***
```
1. Java to be installed > 1.8
2. Maven to be installed to run the tests locally from the terminal
3. Any IDE (Jetbeans/Eclipse) -Good to have but not mandatory`
```

***Set up & Execution Instructions***
```
1. Set Up Instructions
  a. Clone the repo into local using the command
     `git clone https://git.toptal.com/screening/Madhuri-Nallamothu.git`
  b. Change directory into the root of the project
     `cd WebTest`  
2. Execution Instructions
  a. Local Mode ( Executes in the local machine)
     run the command 
     `mvn test`    

```
 ***Reporting***
```
The HTML reports are automatically stored in the Extent Reports folder under `target/cucumber-reports/advanced-reports/extentreports` folder with the name `extent.html` in the project after every execution
``` 
***ContinousIntegration***
```
To achieve the continuous integration with cloud based CI tool, I have mirrored the code repo in to github and I used the Circles CI to integrate the project for CI, which would run all the tests and certify the build before any code is committed and merged.
Github repository link:
`https://github.com/MadhuriN84/WebUITests`
Below is the Circles-CI dashboard which shows the Circles CI integration and the builds status for every commit into master
`https://app.circleci.com/pipelines/github/MadhuriN84/WebUITests`

````\


