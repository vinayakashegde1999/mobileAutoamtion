### Automating Android and IOS APP




####  Framework and Folder Structure overview

    ├── Readme.md                 //Information About project
    |
    ├── pom.xml                  // Dependency management and appliction configuration where main execution controlled 
    ├── testng.xml               // This project uses testNg for execution as runner config , realted configuration can be seen here 
    ├── src
    │   ├── main
    │   │   └── java
    │   │       └── webconnector
    │   │           └── WebConnector.java    // This is the main class for Driver initialization for  android and ios  
    │   └── test
    │       ├── config
    │       │   └── application.properties   //  This file holds necessary configuration for driver infomraion like           capabilities and app paths also  use for storing test data
    │       ├── java
    │       │   ├── ApplicationPages           // This package holds UI properties and implementaion logic
    │       │   │   ├── AndroidPages.java      // This class holds  Implemenation , Page Obejcts and Assertions for Android Apps
    │       │   │   └── IOSPages.java         // This class holds  Implemenation , Page Obejcts and Assertions for IOS Apps
    │       │   ├── ConstantVariables      // This  packages holds constans to be used in Test suits
    │       │   │   └── Constant.java      // This class holds  page objects and Driver related constants like waits and Android and Ios page locators 
    │       │   ├── helper
    │       │   │   └── helper.java     // This class holds Common methods and helper methods used for IOS and Android tests
    │       │   ├── runner
    │       │   │   ├── AbstractTestNGCucumberParallelTests.java   // THis will be helpfull if we need to run in parallel mode
    │       │   │   └── Default.java  This    // This is main class for Cucumber and cucuber settigns 
    │       │   └── stepdefs                    // This package holds step definitions for Cucumber feature files
    │       │       ├── AndrodStepDefs.java   // Setp definition for Android Tests
    │       │       ├── BaseClass.java       // THis holds Cucumber @After and @Before Anotaiton responsible for starting Appium sessions for resepectve tests 
    │       │       └── IOSStepDefs.java     // Setp definition for IOS  Tests
    │       └── resource
    │           └── Feature                     // Cucumber Feature file location
    │               ├── androidTests.feature    // Android BDD Tests
    │               └── iOSTests.feature        // IOS BDD Tests
    