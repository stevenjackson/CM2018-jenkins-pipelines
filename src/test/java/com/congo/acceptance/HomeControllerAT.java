package com.congo.acceptance;

import com.congo.acceptance.pageObjects.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "server.port=8091", webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HomeControllerAT {
    private WebDriver driver;

    @Value("${chrome.driver.path}")
    private String driverPath;

    @Value("${baseUrl}")
    private String baseUrl;
    private HomePage homePage;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--no-sandbox");
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void pageTitleIsCongo() {
        assertThat(homePage.getTitle(), equalTo("Congo"));
    }

    @Test
    public void usersCanGoHome() {
        WebElement homeLink = getLink("Home");

        assertThat(homeLink, not(nullValue()));
        assertThat(homeLink.getTagName(), equalTo("a"));
        assertThat(homeLink.getAttribute("href"), equalTo(baseUrl + "/#"));
    }

    @Test
    public void usersCanViewNewProducts(){
        WebElement newProductLink = getLink("New Products");

        assertThat(newProductLink, not(nullValue()));
        assertThat(newProductLink.getTagName(), equalTo("a"));
        assertThat(newProductLink.getAttribute("href"), equalTo(baseUrl + "/#"));
    }

    @Test
    public void usersCanViewDepartments(){
        WebElement departmentsLink = getLink("Departments");

        assertThat(departmentsLink, not(nullValue()));
        assertThat(departmentsLink.getTagName(), equalTo("a"));
        assertThat(departmentsLink.getAttribute("href"), equalTo(baseUrl + "/#"));
    }

    private WebElement getLink(String linkName){
        return homePage.getMenuLinks().stream().filter((element) -> element.getText().contains(linkName)).findFirst().get();
    }
}
