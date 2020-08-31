/*
 * Laurence Maar
 * https://www.linkedin.com/in/laurencemaar/
 * https://github.com/laurencemaar/
 */

// Junit 5

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.fail;

/*
Junit 4
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.fail;
import java.util.Arrays;
import java.util.Collection;
 */


@RunWith(JUnitPlatform.class)
public class MaarExamplelaurencemaarCustomerToFormerCustomer {

    // Define variables
    public static WebElement element;
    public static WebDriver driver;
    public static WebDriverWait wait;

    // Settings
    public static boolean Sleepy = true;
    public static boolean Verbose = false;

    // ANSI Colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    @BeforeAll
    public static void selenium_00_StartBrowser()
    {
        try {
            // Initiate Chrome Driver
            System.out.printf("========================================\n");
            System.out.printf("= %-36.36s =\n", "START");
            System.out.printf("= %-36.36s =\n", "TEST :: Initiate Driver");
            System.out.printf("========================================\n");

            // Chrome Driver
            //System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
            //driver = new ChromeDriver();

            // Firefox Driver
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            driver = new FirefoxDriver();

            // Wait
            wait = new WebDriverWait(driver, 30);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

            //driver.manage().window().maximize();
            //driver.manage().deleteAllCookies();

        } catch (Exception e) {
            // Exception
            System.out.println("****************************************");
            System.out.println("EXCEPTION :: Start Browser");
            System.out.println("EXCEPTION :: " + e.getClass());
            System.out.println("EXCEPTION :: " + e.getMessage());
            System.out.println("EXCEPTION :: " + e.getCause());
            System.out.println("****************************************");
            e.printStackTrace();
            fail(e.getMessage());
        }

        selenium_00_StartLogin();

        selenium_00_StartLogin_MaarExample();

    }


    public static void selenium_00_StartLogin()
    {

        try {
            // Login 1
            System.out.printf("========================================\n");
            System.out.printf("= %-36.36s =\n", "TEST :: Laurence Maar Login 1");
            System.out.printf("========================================\n");

            // Go to URL
            if(Verbose) System.out.println("TEST :: Go to URL");
            driver.get("http://xxx.test.com/");

            // Assertions
            if(Verbose) System.out.println("TEST :: Assertions");
            Assert.assertTrue( driver.findElements(By.xpath("//input[@id='uid']")).size() > 0 ); // Assertion
            Assert.assertTrue( driver.findElements(By.xpath("//input[@id='pwd']")).size() > 0 ); // Assertion

            // Text Fields
            if(Verbose) System.out.println("TEST :: Text Fields");
            driver.findElement(By.xpath("//input[@id='uid']")).sendKeys("uid");
            driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("pwd");

            // Click - Submit Button
            if(Verbose) System.out.printf("TEST :: Submit Button\n");
            driver.findElement(By.id("Submit")).click();

        } catch (Exception e) {
            // Exception
            System.out.println("****************************************");
            System.out.println("EXCEPTION :: Login 1");
            System.out.println("EXCEPTION :: " + e.getClass());
            System.out.println("EXCEPTION :: " + e.getMessage());
            System.out.println("EXCEPTION :: " + e.getCause());
            System.out.println("****************************************");
            e.printStackTrace();
            fail(e.getMessage());
        }



        try {
            // Login 2
            System.out.printf("========================================\n");
            System.out.printf("= %-36.36s =\n", "TEST :: Laurence Maar Login 2");
            System.out.printf("========================================\n");

            // Assertions
            if(Verbose) System.out.println("TEST :: Assertions");
            Assert.assertTrue( driver.findElements(By.xpath("//input[@id='successButtonId']")).size() > 0 ); // Assertion

            // Click - Submit Button
            if(Verbose) System.out.printf("TEST :: Submit Button\n");
            driver.findElement(By.id("successButtonId")).click();

            // PRISM OK Button
            if(Verbose) System.out.printf("TEST :: PRISM OK Button\n");
            Assert.assertTrue( driver.findElements(By.xpath("//input[@id='btnok']")).size() > 0 ); // Assertion

        } catch (Exception e) {
            // Exception
            System.out.println("****************************************");
            System.out.println("EXCEPTION :: Login 2");
            System.out.println("EXCEPTION :: " + e.getClass());
            System.out.println("EXCEPTION :: " + e.getMessage());
            System.out.println("EXCEPTION :: " + e.getCause());
            System.out.println("****************************************");
            e.printStackTrace();
            fail(e.getMessage());
        }

    }


    public static void selenium_00_StartLogin_MaarExample()
    {
        System.out.printf("========================================\n");
        System.out.printf("= %-36.36s =\n", "TEST Contingency Form - ACC");
        System.out.printf("========================================\n");

        try {
            // Go to URL
            if (Verbose) System.out.println("TEST :: Go to URL");
            driver.get("https://laurencemaar.test.com/");

            // Set Wait Timeout
            wait = new WebDriverWait(driver, 20);

            // Wait Until Expected Conditions
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ot_form-element_0")));

            // ************************************************
            // Customer Type Selection
            // - Customer / Former / Non-Customer
            // ************************************************

            if (Verbose) System.out.println(
                    "TEST :: PAGE = " +
                            driver.getTitle() +
                            " / " +
                            driver.getCurrentUrl()
            );

            // Assertions
            if (Verbose) System.out.println("TEST :: Assertions");
            Assert.assertTrue(driver.findElements(By.id("ot_form-element_0")).size() > 0); // Assertion

            // Login
            if (Verbose) System.out.println("TEST :: Login");
            driver.findElement(By.xpath("//input[@id='ot_form-element_0']")).sendKeys("laurencemaar@test.com");

            // Sleep
            // Short pause so that a human viewer can validate the script is working
            if (Sleepy)
                Thread.sleep(500);

            // Click
            if (Verbose) System.out.println("TEST :: Login Click");
            element = driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_brand')]"));
            element.click();


            // ************************************************
            // Get Started
            // ************************************************

            if (Verbose) System.out.println(
                    "TEST :: PAGE = " +
                            driver.getTitle() +
                            " / " +
                            driver.getCurrentUrl()
            );

            // Assertions
            if (Verbose) System.out.println("TEST :: Assertions");
            Assert.assertTrue(driver.findElements(By.xpath("//a[@class='slds-button slds-button_brand']")).size() > 0); // Assertion

            // Sleep
            // Short pause so that a human viewer can validate the script is working
            if (Sleepy)
                Thread.sleep(500);

            /*

            // Click
            if(Verbose) System.out.println("TEST :: Login Click");
            element = driver.findElement(By.xpath("//a[@class='slds-button slds-button_brand']"));
            element.click();



            // ************************************************
            // Go To Product
            // ************************************************

            if(Verbose) System.out.println(
                    "TEST :: PAGE = " +
                            driver.getTitle() +
                            " / " +
                            driver.getCurrentUrl()
            );

            // Assertions
            if(Verbose) System.out.println("TEST :: Assertions");
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//a[@class='margin-top-bottom-2 slds-button slds-button_brand']")).size() > 0 ); // Assertion

            // Sleep
            // Short pause so that a human viewer can validate the script is working
            if(Sleepy)
                Thread.sleep(500);

            // Click
            if(Verbose) System.out.println("TEST :: Login Click");
            element = driver.findElement(By.xpath("//a[@class='margin-top-bottom-2 slds-button slds-button_brand']"));
            element.click();


         */

        } catch (Exception e) {
            // Exception
            System.out.println("****************************************");
            System.out.println("EXCEPTION :: TEST");
            System.out.println("EXCEPTION :: " + e.getClass());
            System.out.println("EXCEPTION :: " + e.getMessage());
            System.out.println("EXCEPTION :: " + e.getCause());
            System.out.println("****************************************");
            e.printStackTrace();
            fail(e.getMessage());
            return;
        }

    }


    @AfterAll
    public static void selenium_99_CloseBrowser()
    {
        System.out.printf("========================================\n");
        System.out.printf("= %-36.36s =\n", "QUIT");
        System.out.printf("========================================\n");

        //Close the browser
        //driver.quit();
    }





    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }





    //@Test
    public void selenium_00_Stub()
    {
        // This method exists only for spawning the WebDriver window for troubleshooting purposes
        // This is not an actual test

        // Go to URL
        driver.get("https://laurencemaar.test.com/");
    }



    //@Test
    @ParameterizedTest
    @CsvFileSource(resources = "/MaarExampleFormerCustomer.csv")
    /*
    @CsvSource(
            {
                    "AWNFH7FGH5"
            }
    )
    */
    public void selenium_01_MaarExample_CustomerToFormerCustomer(String CaseID)
    {
        if(true)
        {
            System.out.printf("= %-45.45s =\n", ANSI_YELLOW + "This bot is turned off because it is not finished - Laurence" + ANSI_RESET);
            Assert.fail();
            return;
        }

        System.out.printf("========================================\n");
        System.out.printf("= %-45.45s =\n", ANSI_YELLOW + CaseID + ANSI_RESET);
        System.out.printf("========================================\n");

        try {
            // ************************************************
            // Requests
            // ************************************************

            driver.get("https://laurencemaar.test.com/app/queue");

            if(Verbose) System.out.println(
                    "TEST :: PAGE = " +
                            driver.getTitle() +
                            " / " +
                            driver.getCurrentUrl()
            );

            // Assertions
            if(Verbose) System.out.println("TEST :: Assertions");
            Assert.assertTrue( driver.findElements(By.xpath("//div[@class='ot-sidebar__nav ot-sidebar__nav--default']//span[@class='ot-sidebar__anchor-text'][contains(text(),'Requests')]")).size() > 0 ); // Assertion

            // Sleep
            // Short pause so that a human viewer can validate the script is working
            if(Sleepy)
                Thread.sleep(500);

            // Click
            if(Verbose) System.out.println("TEST :: Click");
            element = driver.findElement(By.xpath("//div[@class='ot-sidebar__nav ot-sidebar__nav--default']//span[@class='ot-sidebar__anchor-text'][contains(text(),'Requests')]"));
            element.click();




            // ************************************************
            // **
            // ************************************************

            wait = new WebDriverWait(driver, 5);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);





            // ************************************************
            // Search
            // ************************************************

            if(Verbose) System.out.println(
                    "TEST :: PAGE = " +
                            driver.getTitle() +
                            " / " +
                            driver.getCurrentUrl()
            );

            // Assertions
            if(Verbose) System.out.println("TEST :: Assertions");
            Assert.assertTrue( driver.findElements(By.xpath("//div[@class='slds-search']//input[@placeholder='Search']")).size() > 0 ); // Assertion

            // Sleep
            // Short pause so that a human viewer can validate the script is working
            if(Sleepy)
                Thread.sleep(500);

            // Input
            if(Verbose) System.out.println("TEST :: Input");
            driver.findElement(By.xpath("//div[@class='slds-search']//input[@placeholder='Search']")).clear();
            driver.findElement(By.xpath("//div[@class='slds-search']//input[@placeholder='Search']")).sendKeys(CaseID + Keys.RETURN);


            // Wait Until Expected Conditions
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(CaseID)));

            Thread.sleep(1000);


            String CaseStage = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/ui-view[1]/ui-view[1]/ui-view[1]/div[1]/div[1]/div[1]/dsar-wrapper[1]/div[1]/div[1]/section[1]/ui-view[1]/downgrade-dsar-request-queue-wrapper[1]/section[1]/dsar-request-queue[1]/div[1]/section[1]/dsar-request-queue-table[1]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/span[1]")).getText().toUpperCase();

            System.out.println("TEST :: STAGE = " + ANSI_YELLOW + CaseStage + ANSI_RESET);

            if(CaseStage.equals("CLOSED") || CaseStage.contains("ARCHIV"))
                return;


            // Get Link
            if(Verbose) System.out.println("TEST :: Get Link 1");
            element = driver.findElement(By.linkText(CaseID));
            if(Verbose) System.out.println("TEST :: Get Link 2");
            //if(Verbose) System.out.println("TEST :: Link = " + element.getAttribute("href"));
            element.click();





            // ************************************************
            // Case Screen
            // ************************************************

            if(Verbose) System.out.println(
                    "TEST :: PAGE = " +
                            driver.getTitle() +
                            " / " +
                            driver.getCurrentUrl()
            );

            // Assertions
            if(Verbose) System.out.println("TEST :: Assertions");
            Assert.assertTrue( driver.findElements(By.xpath("//div[@class='text-xlarge margin-bottom-half']")).size() > 0 ); // Assertion
            Assert.assertTrue( driver.findElements(By.xpath("//span[contains(text(),'Customer')]")).size() > 0 ); // Assertion

            if( driver.findElements(By.xpath("//span[contains(text(),'Former Customer')]")).size() > 0 )
            {
                System.out.println("TEST :: " + ANSI_YELLOW + "FORMER CUSTOMER" + ANSI_RESET);
                return;
            }

            if(Verbose) System.out.println("TEST :: Assertions OK");

            //String CaseStage = driver.findElement(By.xpath("//div[@class='text-xlarge margin-bottom-half']")).getText().toUpperCase();

            // Sleep
            Thread.sleep(100);




            // ************************************************
            // WORKFLOW
            // ************************************************

            if(Verbose) System.out.println("TEST :: WORKFLOW");

            // Elipses
            driver.findElement(By.xpath("//i[@class='ot ot-ellipsis-h']")).click();

            // Sleep
            Thread.sleep(100);

            // Change Workflow
            driver.findElement(By.xpath("//li[@class='slds-dropdown__item']//a[contains(text(),'Change Workflow')]")).click();

            // Drop-Down
            driver.findElement(By.xpath("//label[contains(text(),'Workflow')]//following::button")).click(); // Workflow

            driver.findElement(By.xpath("//span[contains(text(),'MAKE A CASE EDITABLE')]")).click(); // Workflow

            driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click(); // Workflow

            // Sleep
            Thread.sleep(500);




            // ************************************************
            // EDIT REQUEST
            // ************************************************

            if(Verbose) System.out.println("TEST :: EDIT REQUEST");

            // Elipses
            driver.findElement(By.xpath("//i[@class='ot ot-ellipsis-h']")).click();

            // Sleep
            Thread.sleep(300);

            // Change Workflow
            driver.findElement(By.xpath("//li[@class='slds-dropdown__item']//a[contains(text(),'Edit Request')]")).click();

            Thread.sleep(1200);

            if(Verbose) System.out.println("TEST :: EDIT REQUEST REMOVE");

            // Remove
            driver.findElement(By.xpath("//span[contains(text(),'Customer')]//following::i")).click(); // REMOVE

            Thread.sleep(100);

            // Drop-Down
            if(Verbose) System.out.println("TEST :: Drop-Down");
            driver.findElement(By.xpath("//label[contains(text(),'I am a (an)')]//following::input")).click(); // Workflow

            driver.findElement(By.xpath("//button[contains(text(),'Former Customer')]")).click(); // Workflow

            driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click(); // Workflow

            // Sleep
            Thread.sleep(500);




            // ************************************************
            // REWORK
            // ************************************************

            if(Verbose) System.out.println("TEST :: REWORK");

            // Elipses
            driver.findElement(By.xpath("//i[@class='ot ot-ellipsis-h']")).click();

            // Sleep
            Thread.sleep(300);

            // Change Workflow
            driver.findElement(By.xpath("//li[@class='slds-dropdown__item']//a[contains(text(),'Change Workflow')]")).click();

            // Drop-Down
            driver.findElement(By.xpath("//label[contains(text(),'Workflow')]//following::button")).click(); // Workflow

            driver.findElement(By.xpath("//span[contains(text(),'ACCESS FAILED QA WORKFLOW')]")).click(); // Workflow

            driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click(); // Workflow

            // Sleep
            Thread.sleep(100);

            System.out.println("TEST :: " + ANSI_GREEN + "Complete" + ANSI_RESET);



        } catch (Exception e) {
            // Exception
            System.out.println("****************************************");
            System.out.println("EXCEPTION :: TEST");
            System.out.println("EXCEPTION :: " + e.getClass());
            System.out.println("EXCEPTION :: " + e.getMessage());
            System.out.println("EXCEPTION :: " + e.getCause());
            System.out.println("****************************************");
            e.printStackTrace();
            fail(e.getMessage());
            return;
        }




        try
        {
            // Sleep
            // Short pause so that a human viewer can validate the script is working
            if(Sleepy)
                Thread.sleep(1000);
        } catch (Exception e) {
            // Exception
            System.out.println("****************************************");
            System.out.println("EXCEPTION :: Sleep");
            System.out.println("EXCEPTION :: " + e.getClass());
            System.out.println("EXCEPTION :: " + e.getMessage());
            System.out.println("EXCEPTION :: " + e.getCause());
            System.out.println("****************************************");
            e.printStackTrace();
            fail(e.getMessage());
            return;
        }

    }



}
