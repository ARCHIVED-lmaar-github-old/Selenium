/*
 * Laurence Maar
 * https://www.linkedin.com/in/laurencemaar/
 * https://github.com/laurencemaar/
 */

// Junit 5
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

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

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;




@RunWith(JUnitPlatform.class)
public class MaarExamplelaurencemaar45DayExtension {

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
            driver.get("http://laurencemaar.test.com/");

            // Assertions
            if(Verbose) System.out.println("TEST :: Assertions");
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//input[@id='Username']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//input[@id='PW']")).size() > 0 ); // Assertion

            // Text Fields
            if(Verbose) System.out.println("TEST :: Text Fields");
            driver.findElement(By.xpath("//input[@id='Username']")).sendKeys("testusername");
            driver.findElement(By.xpath("//input[@id='PW']")).sendKeys("testtesttest");

            // Click - Submit Button
            if(Verbose) System.out.printf("TEST :: Submit Button\n");
            driver.findElement(By.id("PWSubmit")).click();

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
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//input[@id='successButtonId']")).size() > 0 ); // Assertion

            // Click - Submit Button
            if(Verbose) System.out.printf("TEST :: Submit Button\n");
            driver.findElement(By.id("successButtonId")).click();

            // PRISM OK Button
            if(Verbose) System.out.printf("TEST :: PRISM OK Button\n");
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//input[@id='btnok']")).size() > 0 ); // Assertion

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
            org.junit.Assert.assertTrue(driver.findElements(By.id("ot_form-element_0")).size() > 0); // Assertion

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
            org.junit.Assert.assertTrue(driver.findElements(By.xpath("//a[@class='slds-button slds-button_brand']")).size() > 0); // Assertion

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
        driver.quit();
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
    @CsvFileSource(resources = "/MaarExample45DayExtension.csv")
    /*
    @CsvSource(
            {
                    "AWNFH7FGH5"
            }
    )
    */
    public void selenium_01_MaarExample_45DayExtension(String CaseID, int ExtensionReasonCode)
    {
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
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//div[@class='ot-sidebar__nav ot-sidebar__nav--default']//span[@class='ot-sidebar__anchor-text'][contains(text(),'Requests')]")).size() > 0 ); // Assertion

            // Sleep
            // Short pause so that a human viewer can validate the script is working
            if(Sleepy)
                Thread.sleep(500);

            // Click
            if(Verbose) System.out.println("TEST :: Click");
            element = driver.findElement(By.xpath("//div[@class='ot-sidebar__nav ot-sidebar__nav--default']//span[@class='ot-sidebar__anchor-text'][contains(text(),'Requests')]"));
            element.click();





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
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//div[@class='slds-search']//input[@placeholder='Search']")).size() > 0 ); // Assertion

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

            Thread.sleep(2000);

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
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//div[@class='text-xlarge margin-bottom-half']")).size() > 0 ); // Assertion

            String CaseStage = driver.findElement(By.xpath("//div[@class='text-xlarge margin-bottom-half']")).getText().toUpperCase();

            // Sleep
            // Short pause so that a human viewer can validate the script is working
            if(Sleepy)
                Thread.sleep(500);





            // Customer Name
            String CustomerName = driver.findElement(By.xpath("//div[@class='text-bold text-large flex align-center']")).getText();

            // Deadline
            element = driver.findElement(By.xpath("//div[contains(text(),'Deadline')]//following::div[contains(text(),' ')]"));
            if(Verbose) System.out.println("TEST :: Deadline = " + element.getText().split(" ")[0]);

            Date ds=new SimpleDateFormat("MM/dd/yyyy").parse( element.getText().split(" ")[0] );

            ds = addDays(ds,45);

            String Deadline = new SimpleDateFormat("M/d/yyyy").format(ds);

            if(Verbose) System.out.println("TEST :: Deadline = " + Deadline);





            // Subtasks
            if(Verbose) System.out.println("TEST :: Subtasks");
            element = driver.findElement(By.linkText("Subtasks"));
            element.click();



            // Check if case has already been extended
            if(true) {
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

                if (driver.findElements(By.xpath("//a[contains(text(),'FQA-12')]")).size() > 0) {
                    System.out.println("TEST :: Case " + CaseID + " = " + ANSI_RED + "Existing Subtask" + ANSI_RESET);

                    Assert.fail();
                    return;
                } else {
                    System.out.println("TEST :: Case " + CaseID + " = " + ANSI_YELLOW + "No Existing Subtask" + ANSI_RESET);
                }

                if (driver.findElements(By.xpath("//a[contains(text(),'Extend Case in CPIM')]")).size() > 0) {
                    System.out.println("TEST :: Case " + CaseID + " = " + ANSI_RED + "Case Already Extended" + ANSI_RESET);

                    Assert.fail();
                    return;
                } else {
                    System.out.println("TEST :: Case " + CaseID + " = " + ANSI_YELLOW + "No Existing Extension" + ANSI_RESET);
                }

                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }





            // Mouse Over
            /*
            Actions action = new Actions(driver);
            WebElement we = driver.findElement(By.xpath("//body//td[12]"));
            action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//i[@class='media-middle ot ot-ellipsis-h']"))).click().build().perform();
            */

            /*
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(By.xpath("//body//td[12]"))).build().perform();

            Thread.sleep(500);
             */

            // Elipses
            driver.findElement(By.xpath("//i[@class='ot ot-ellipsis-h']")).click();

            // Sleep
            // Short pause so that a human viewer can validate the script is working
            if(Sleepy)
                Thread.sleep(500);



            // Extend
            driver.findElement(By.xpath("//li[@class='slds-dropdown__item']//a[contains(text(),'Extend')]")).click();

            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/ot-modal[1]/ot-modal-base[1]/div[1]/request-queue-extend-modal[1]/ot-modal-content[1]/div[1]/div[1]/input[1]")).clear();
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/ot-modal[1]/ot-modal-base[1]/div[1]/request-queue-extend-modal[1]/ot-modal-content[1]/div[1]/div[1]/input[1]")).sendKeys("45");

            driver.findElement(By.xpath("//label[contains(text(),'Enter a reason for extending the request:')]//following::div[@class='ql-editor ql-blank']")).sendKeys(
                    "Hi " + CustomerName + ",\n" +
                            "\n" +
                            "We’re working on your request, but it may take up to an additional 45 days. You should expect to hear from us no later than " + Deadline + ".\n" +
                            "\n" +
                            "Want to stay updated? Go to test.com/mydatarequest/track-a-request and have your case ID [" + CaseID + "] handy."
            ); // Task Desc

            // Sleep
            // Short pause so that a human viewer can validate the script is working
            if(Sleepy)
                Thread.sleep(500);

            driver.findElement(By.xpath("//button[contains(text(),'Send')]")).click();

            Thread.sleep(1000);






            // System Subtasks
            if(Verbose) System.out.println("TEST :: System Subtasks");
            driver.findElement(By.xpath("//button[contains(text(),'System Subtask')]")).click();

            // Input
            if(Verbose) System.out.println("TEST :: Input");

            driver.findElement(By.name("taskName")).sendKeys("FQA-12-45 Day Extension"); // Task Name

            driver.findElement(By.xpath("//label[contains(text(),'Task Description')]//following::div[@class='ql-editor ql-blank']")).sendKeys(
                    "Hi " + CustomerName + ",\n" +
                            "\n" +
                            "We’re working on your request, but it may take up to an additional 45 days. You should expect to hear from us no later than " + Deadline + ".\n" +
                            "\n" +
                            "Want to stay updated? Go to test.com/mydatarequest/track-a-request and have your case ID [" + CaseID + "] handy."
            ); // Task Desc

            // Drop-Down
            if(Verbose) System.out.println("TEST :: Drop-Down");
            driver.findElement(By.xpath("//input[@placeholder='Select']")).sendKeys("xxx"); // Assignee
            driver.findElement(By.xpath("//button[@id='listbox-option-unique-id-[object Object]']")).click();

            // Drop-Down
            if(Verbose) System.out.println("TEST :: Drop-Down");
            driver.findElement(By.xpath("//label[contains(text(),'Workflow')]//following::input")).sendKeys("45"); // Assignee

            if( ExtensionReasonCode == 2)
                driver.findElement(By.xpath("//button[contains(text(),'More complex')]")).click();
            else if( ExtensionReasonCode == 3)
                driver.findElement(By.xpath("//button[contains(text(),'Detailed Analysis')]")).click();
            else
                driver.findElement(By.xpath("//button[contains(text(),'High Volume')]")).click();



            // Sleep
            // Short pause so that a human viewer can validate the script is working
            if(Sleepy)
                Thread.sleep(500);

            // Submit
            element = driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand'][contains(text(),'Send')]"));
            element.click();

            System.out.println("TEST :: Case " + CaseID + " = " + ANSI_YELLOW + "COMPLETE" + ANSI_RESET);

            Thread.sleep(1000);



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
