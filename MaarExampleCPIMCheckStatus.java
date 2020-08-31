/*
 * Laurence Maar
 * https://www.linkedin.com/in/laurencemaar/
 * https://github.com/laurencemaar/
 */

// Junit 5

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
public class MaarExampleCPIMCheckStatus {

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
    @CsvFileSource(resources = "/CPIMCheckStatus.csv")
    /*
    @CsvSource(
            {
                    "AWNFH7FGH5"
            }
    )
    */
    public void selenium_01_MaarExample_CheckCPIMStatus(String CaseID)
    {
        System.out.printf("========================================\n");
        System.out.printf("= %-45.45s =\n", ANSI_YELLOW + CaseID + ANSI_RESET);
        System.out.printf("========================================\n");

        try {
            boolean OVERRIDE_MISSING_FIELDS = false;

            //if(Verbose) System.out.println("TEST :: Case Form");

            wait = new WebDriverWait(driver, 10);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

            // Test
            //driver.get("http://zlty10032.vci.test.com:32316/search/" + CaseID);
            // Production
            //driver.get("http://zlp47514.vci.test.com:31596/search/" + CaseID);
            //driver.get("http://patlshr01.prod.sci.test.com:31596/search/" + CaseID);
            driver.get("https://cpimui.web.test.com/search/" + CaseID);

            driver.findElement(By.xpath("//div[contains(text(),'" + CaseID + "')]"));

            String CPIMStatus;

            CPIMStatus = driver.findElement(By.xpath(
                    "//body/app-root/app-home[@class='ng-star-inserted']/div[@class='container-fluid']/div/app-dashboard[@class='ng-star-inserted']/div[@class='row']/kendo-tabstrip[@class='ng-tns-c3-0 k-widget k-tabstrip k-floatwrap k-header k-tabstrip-top']/div[@id='k-tabstrip-tabpanel-1']/app-search-result[@class='ng-star-inserted']/div[@class='ng-star-inserted']/div[1]/div[2]/div[2]/div[1]"
                            + "//following::div[@class='text']"))
                    .getText();

            System.out.println("CPIM Status = " + ANSI_YELLOW + CPIMStatus + ANSI_RESET);

            if(!CPIMStatus.equals("LOCKED"))
            {
                fail();
            }





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
