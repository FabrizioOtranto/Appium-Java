package PageObjectModel.pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjectModel.pages.CreateTaskPage;
import PageObjectModel.pages.LoginPage;
import PageObjectModel.pages.TestListPage;
import PageObjectModel.pages.TestPage;

import java.net.MalformedURLException;

public class todoAndroid extends PageObjectModel{
    CreateTaskPage createTaskPage;
    TestListPage testListPage;
    LoginPage login;
    TestPage testPage;

    @Test
    public void  test_add_task() throws MalformedURLException {
        setUp();
        login = new LoginPage(driver);
        testListPage = new TestListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        testPage = new TestPage(driver);
        login.sendUsername("Fabryotranto@hotmail.com");
        login.singInLogin();
        login.sendPassword("Juanyputo123.");
        login.singInPassword();
        testListPage.clickAddTaskBtn();
        createTaskPage.sendTitle("Mirar GOT");
        createTaskPage.colorPurple();
        createTaskPage.createTask();
        testPage.goBack();

        String actualResult = "Mirar GOT";
        String expectedResult = testListPage.getTitle();
        Assert.assertEquals(actualResult,expectedResult);
    }
}
