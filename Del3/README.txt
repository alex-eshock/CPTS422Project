Project Description:

This is a program that implments custom checkstyle checks to a new eclipse instance.

src/main/java = hosts the packages that run the checkstyle tests
    - blackBoxTests
        --- small snippits of code that simulate programming so src/test/java/blackboxTests can run blackbox tests.
    - halsteadPackage
        --- Each class in here implements a halstead check for checkstyle.
    - numComPackage
        --- Each class in here implements a comment check and other checkstyle checks related to the assignment that aren't halstead related.

src/test/java
    - blackBoxTests
        --- Each class here Reads the code in src/main/java/blackBoxTests
        --- Each name is linked to a check within src/main/java/blackBoxTest
    - halsteadTestPackage
        --- Each class in here is a test for each respective class in src/main/java/halsteadPackage
    - numTestPackage
        --- Each class in here is a test for each respective class in src/main/java/numComPackage
    - testEnginePackage
        --- Holds the TestEngine.cs class. This class allows us to run the blackbox tests used in src/main/java/blackboxTests

IMPORTANT INFO REGARDING CODE COVERAGE:

src/main/java/blackBoxTests shows 0% code coverage. This should be the case because the code in this package only exists for blackbox testing purposes from src/test/java/blackBoxTests and it does not need to be covered. 





        