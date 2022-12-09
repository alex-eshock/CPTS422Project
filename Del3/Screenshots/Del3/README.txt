IMPORTANT INFO REGARDING CODE COVERAGE:

src/main/java/blackBoxTests shows 0% code coverage. This should be the case because the code in this package only exists for blackbox testing purposes from src/test/java/blackBoxTests and it does not need to be covered. 

Why this happens:

The "check" variable being made in each of these classes is using a check implmented within src/main/java/halsteadPackage OR src/main/java/numComPackage. This means that the checks are going through the code in src/main/java/blackboxTests and not the junit tests themselves. Hence why the code coverage is at 0%. Because of this reason, i'm excluding src/main/java/blackBoxTests from this report. Ignoring those files means that I 100% line coverage. 





        