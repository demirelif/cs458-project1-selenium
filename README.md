# cs458-project1-selenium
The test code can be found in: https://github.com/demirelif/cs458-project1-selenium

To run the test code, you should open it in a Java IDE with VCS. After that, you need to make sure that the main source code is available in localhost in the following directory with mamp or xamp:

http://localhost:8888/cs458-project1

test code is on src/fakeflixTest/fakeflixTestApplication.java which includes 5 test cases. Also, you can run each test case individually from their corresponding classes(testCase1.java, testCase2.java etc.)

you may need to edit run configuration, if you get "TestNG by default disables loading DTD from unsecured Urls." error Go to Edit Configuration->fakeflixTestApplication->VM Options-> set "-ea" to "-ea -Dtestng.dtd.http=true"
