# cs458-project1-selenium

test code is on src/fakeflixTest/fakeflixTestApplication.java which includes 5 test cases, you can run each test case individually from their corresponding classes

you may need to edit run configuration, if you get  "TestNG by default disables loading DTD from unsecured Urls." error 
Go to Edit Configuration->fakeflixTestApplication->VM Options-> set "-ea" to "-ea -Dtestng.dtd.http=true"