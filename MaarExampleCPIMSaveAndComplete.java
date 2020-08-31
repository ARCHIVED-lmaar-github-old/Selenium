/*
 * Laurence Maar
 * https://www.linkedin.com/in/laurencemaar/
 * https://github.com/laurencemaar/
 */

// Junit 5
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;




@RunWith(JUnitPlatform.class)
public class MaarExampleCPIMSaveAndComplete {

    // Define variables
    public static WebElement element;
    public static WebDriver driver;
    public static WebDriverWait wait;

    // Settings
    public static boolean Sleepy = true;
    public static boolean Verbose = true;

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



    @AfterAll
    public static void selenium_99_CloseBrowser()
    {
        System.out.printf("========================================\n");
        System.out.printf("= %-36.36s =\n", "QUIT");
        System.out.printf("========================================\n");

        //Close the browser
        driver.quit();
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
    @CsvFileSource(resources = "/MaarExampleSaveAndComplete.csv")
    /*
    @CsvSource(
            {
                    "AWNFH7FGH5"
            }
    )
    */
    public void selenium_01_MaarExample_SaveAndComplete(String CaseID)
    {
        System.out.printf("========================================\n");
        System.out.printf("= %-45.45s =\n", ANSI_YELLOW + CaseID + ANSI_RESET);
        System.out.printf("========================================\n");

        try {
            boolean OVERRIDE_MISSING_FIELDS = false;

            if(Verbose) System.out.println("TEST :: Case Form");

            wait = new WebDriverWait(driver, 6);
            driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);

            // Test
            //driver.get("http://zlty10032.vci.test.com:32316/search/" + CaseID);
            // Production
            //driver.get("http://zlp47514.vci.test.com:31596/search/" + CaseID);
            //driver.get("http://patlshr01.prod.sci.test.com:31596/search/" + CaseID);
            driver.get("https://cpimui.web.test.com/search/" + CaseID);


            if(driver.findElements(By.xpath("//input[@class='k-textbox ng-untouched ng-pristine ng-valid']")).size() > 0)
            {
                org.junit.Assert.assertTrue(driver.findElements(By.xpath("//input[@class='k-textbox ng-untouched ng-pristine ng-valid']")).size() > 0); // Assertion
                String SupplierURL = driver.findElement(By.xpath("//div[contains(text(),'Supplier URL')]//following::input[@class='k-textbox ng-untouched ng-pristine ng-valid']")).getAttribute("value");

                if( SupplierURL.length() < 10)
                {
                    if(Verbose) System.out.println("TEST :: Supplier Link = '" + SupplierURL + "' " + ANSI_RED + "(Size = " + SupplierURL.length() + ")" + ANSI_RESET);

                    System.out.println("TEST :: " + ANSI_RED + "FAILED - BLANK SUPPLIER URL" + ANSI_RESET);

                    Thread.sleep(500);
                    org.junit.Assert.assertTrue( false ); // Assertion
                    return;
                }
                else
                {
                    if(Verbose) System.out.println("TEST :: Supplier Link = '" +SupplierURL + "' " + ANSI_YELLOW + "(Size = " + SupplierURL.length() + ")" + ANSI_RESET);
                }

            }


            // Sleep
            Thread.sleep(1000);





            // ************************************************
            // Form
            // ************************************************

            if(Verbose) System.out.println("TEST :: Save And Complete");

            element = driver.findElement(By.xpath("//button[contains(text(),'Save and Complete')]"));

            element.click();

            // OVERRIDE MISSING DATA
            // OVERRIDE MISSING DATA
            // OVERRIDE MISSING DATA
            // OVERRIDE MISSING DATA
            // OVERRIDE MISSING DATA
            Thread.sleep(500);

            wait = new WebDriverWait(driver, 1);
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);

            if( driver.findElements(By.xpath("//button[contains(text(),'Yes')]")).size() > 0 )
            {
                if(Verbose) System.out.println("TEST :: " + ANSI_YELLOW + "Mandatory Fields Missing" + ANSI_RESET);

                if(OVERRIDE_MISSING_FIELDS)
                {
                    driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
                }
            }

            System.out.println("TEST :: " + ANSI_CYAN + "COMPLETE" + ANSI_RESET);

            // Give the system time to complete the save
            Thread.sleep(3000);





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
