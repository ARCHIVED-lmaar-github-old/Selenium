/*
 * Laurence Maar
 * https://www.linkedin.com/in/laurencemaar/
 * https://github.com/laurencemaar/
  */

// Junit 5
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;



@RunWith(JUnitPlatform.class)
public class MaarExampleContingencyPortalDataGenerator {

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


    /*
    Junit 4 Code
    *****

    private String UID;
    private String Product;
    private String Authentication;
    private String UserBAN;
    private String UserPhone;

    public MaarExampleSeleniumTest(String UID, String Product, String Authentication, String UserBAN, String UserPhone){
        this.UID = UID;
        this.Product = Product;
        this.Authentication = Authentication;
        this.UserBAN = UserBAN;
        this.UserPhone = UserPhone;
    }

    @Parameterized.Parameters
    public static Collection<Object[] > data(){
        Object[][] data = new Object[][]
                {
                        {"laurencemaar", "UTEST", "2FA", "111111111111", "111-222-3333"},
                        {"laurencemaar", "UTEST", "2FA", "111111111111", "111-222-3333"},
                        {"laurencemaar", "UTEST", "2FA", "111111111111", "111-222-3333"},
                        {"laurencemaar", "MTEST", "2FA", "111111111111", "111-222-3333"},
                        {"laurencemaar", "MTEST", "2FA", "111111111111", "111-222-3333"},
                        {"laurencemaar", "MTEST", "2FA", "111111111111", "111-222-3333"}
                };
        return Arrays.asList(data);
    }
    */


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
            wait = new WebDriverWait(driver, 20);

            //driver.manage().window().maximize();
            //driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

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
        driver.get("http://test.test.com:30437/MaarExample/index.html#/MaarExampleLogin");
    }



    //@Test
    @ParameterizedTest
    //@CsvFileSource(resources = "/word-lengths.csv")
    @CsvSource(
            {
                    "laurencemaar, DTEST, 2FA, 1231231234, 1231231234",
                    "laurencemaar, DTEST, 2FA, 1231231234, 1231231234",
                    "laurencemaar, DTEST, 2FA, 1231231234, 1231231234"/*,
                    "laurencemaar, MTEST, 2FA, 1231231234, 1231231234"/*,
                    "laurencemaar, UTEST, 2FA, 111111111111, 3523421119"/*,
                    "laurencemaar, MTEST, 2FA, 111111111111, 3523421119",
                    "laurencemaar, UTEST, 2FA, 111111111111, 3523421119",
                    "laurencemaar, MTEST, 2FA, 111111111111, 3523421119",
                    "laurencemaar, UTEST, 2FA, 111111111111, 3523421119",
                    "laurencemaar, MTEST, 2FA, 111111111111, 3523421119",
                    "laurencemaar, UTEST, 2FA, 111111111111, 3523421119",
                    "laurencemaar, MTEST, 2FA, 111111111111, 3523421119",
                    "laurencemaar, UTEST, 2FA, 111111111111, 3523421119"*/
            }
    )
    public void selenium_01_MaarExample_Intake_Test(String UID, String Product, String Authentication, String UserBAN, String UserPhone)
    {
        if(true)
        {
            System.out.printf("= %-45.45s =\n", ANSI_YELLOW + "This bot is turned off - Laurence" + ANSI_RESET);
            Assert.fail();
            return;
        }

        System.out.printf("========================================\n");
        System.out.printf("= %-36.36s =\n", "TEST Contingency Form - ACC");
        System.out.printf("========================================\n");

        try {
            // Go to URL
            if(Verbose) System.out.println("TEST :: Go to URL");
            //driver.get("http://test.test.com:30437/MaarExample/index.html#/MaarExampleLogin");
            //driver.get("http://laurencemaar.test.com:31352/MaarExample/index.html#/MaarExampleLogin");
            driver.get("http://laurencemaar.test.com:30804/MaarExample/index.html#/MaarExampleLogin");

            // Wait Until Expected Conditions
            wait = new WebDriverWait(driver, 10);
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("MaarExampleContDiv")));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'customer')]")));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'employee')]")));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Non Customer')]")));

            // ************************************************
            // Customer Type Selection
            // - Customer / Former / Non-Customer
            // ************************************************

            if(Verbose) System.out.println(
                    "TEST :: PAGE = " +
                            driver.getTitle() +
                            " / " +
                            driver.getCurrentUrl()
            );

            // Assertions
            if(Verbose) System.out.println("TEST :: Assertions");
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//label[contains(text(),'customer')]")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//label[contains(text(),'employee')]")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//label[contains(text(),'Non Customer')]")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//button[@id='continueBtnId']")).size() > 0 ); // Assertion

            // Click - Radio Button
            element = driver.findElement(By.xpath("//label[contains(text(),'customer')]"));
            //System.out.printf("TEST :: Radio = %s\n", element.getText());
            element.click();

            // Sleep
            // Short pause so that a human viewer can validate the script is working
            if(Sleepy)
                Thread.sleep(500);

            // Click - Submit Button
            element = driver.findElement(By.xpath("//button[@id='continueBtnId']"));
            //System.out.printf("TEST :: Button = %s\n", element.getText());
            element.click();



            // ************************************************
            // Customer Page
            // - Select Request Type
            // ************************************************

            if(Verbose) System.out.println(
                    "TEST :: PAGE = " +
                            driver.getTitle() +
                            " / " +
                            driver.getCurrentUrl()
            );

            // Assertions
            if(Verbose) System.out.println("TEST :: Assertions");
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//label[contains(text(),'Data Access Request')]")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//label[contains(text(),'Data Removal Request')]")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//label[contains(text(),'Download My Report')]")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//label[contains(text(),'Do Not Sell')]")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//button[@id='continueBtnId']")).size() > 0 ); // Assertion

            // Click - Radio Button
            element = driver.findElement(By.xpath("//label[contains(text(),'Data Access Request')]"));
            //System.out.printf("TEST :: Radio = %s\n", element.getText());
            element.click();

            // Sleep
            // Short pause so that a human viewer can validate the script is working
            if(Sleepy)
                Thread.sleep(500);

            // Click - Submit Button
            element = driver.findElement(By.xpath("//button[@id='continueBtnId']"));
            //System.out.printf("TEST :: Button = %s\n", element.getText());
            element.click();



            // ************************************************
            // Data Access Request Page
            // ************************************************

            if(Verbose) System.out.println(
                    "TEST :: PAGE = " +
                            driver.getTitle() +
                            " / " +
                            driver.getCurrentUrl()
            );

            // Assertions
            if(Verbose) System.out.println("TEST :: Assertions");
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//input[@id='firstName']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//input[@id='lastName']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//input[@id='userAddress1']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//input[@id='userCity']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//select[@id='userState']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//input[@id='userZip']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//select[@id='userCountry']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//select[@id='productDropDownId']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//input[@id='userBan']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//input[@id='userPhoneNumber']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//input[@id='userEmail']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//input[@id='acctOwnerNameInpId']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//input[@id='mobileNumberIPId']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//select[@id='authOptionId']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//select[@id='requesterTypeId']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//select[@id='resdntLocnDropDownId']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//input[@id='commonLinkKeyId']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//input[@id='accUserId']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//input[@id='repAgentsId']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//label[contains(text(),'Unified Bill Indicator :')]")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.name("unifiedBillInd")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//input[@id='secProdKeyId']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//select[@id='methodOfDeliveryId']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//select[@id='accRespFormattingId']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//select[@id='statUpdatedMethodId']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//label[contains(text(),'Active Account Indicator :')]")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.name("openAcctInd")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//label[contains(text(),'Message Tablet Indicator :')]")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.name("messageTabInd")).size() > 0 ); // Assertion

            // Text Fields
            if(Verbose) System.out.println("TEST :: Text Fields");
            driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(UID);
            driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(Product + " TEST");
            driver.findElement(By.xpath("//input[@id='userAddress1']")).sendKeys("123 Main St");
            driver.findElement(By.xpath("//input[@id='userAddress2']")).sendKeys("Addr 2 Line");
            driver.findElement(By.xpath("//input[@id='userCity']")).sendKeys("Los Angeles");
            driver.findElement(By.xpath("//input[@id='userZip']")).sendKeys("12345");
            driver.findElement(By.xpath("//input[@id='userBan']")).sendKeys(UserBAN);
            driver.findElement(By.xpath("//input[@id='userPhoneNumber']")).sendKeys(UserPhone);
            driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("laurencemaar@test.com");
            driver.findElement(By.xpath("//input[@id='acctOwnerNameInpId']")).sendKeys(UID);
            driver.findElement(By.xpath("//input[@id='mobileNumberIPId']")).sendKeys(UserPhone);
            driver.findElement(By.xpath("//input[@id='commonLinkKeyId']")).sendKeys(UserBAN);
            driver.findElement(By.xpath("//input[@id='accUserId']")).sendKeys(UID);
            driver.findElement(By.xpath("//input[@id='repAgentsId']")).sendKeys(UID);
            driver.findElement(By.xpath("//input[@id='secProdKeyId']")).sendKeys(UserPhone);
            driver.findElement(By.xpath("//input[@id='adCookieId']")).sendKeys(UID);

            // Drop-Downs
            if(Verbose) System.out.println("TEST :: Drop-Downs");
            new Select(driver.findElement(By.xpath("//select[@id='userState']"))).selectByValue("California");
            new Select(driver.findElement(By.xpath("//select[@id='userCountry']"))).selectByValue("United States");
            new Select(driver.findElement(By.xpath("//select[@id='productDropDownId']"))).selectByValue(Product);

            new Select(driver.findElement(By.xpath("//select[@id='authOptionId']"))).selectByValue(Authentication);
            new Select(driver.findElement(By.xpath("//select[@id='requesterTypeId']"))).selectByValue("OWNER");
            new Select(driver.findElement(By.xpath("//select[@id='resdntLocnDropDownId']"))).selectByValue("California");

            new Select(driver.findElement(By.xpath("//select[@id='methodOfDeliveryId']"))).selectByValue("WEB");
            new Select(driver.findElement(By.xpath("//select[@id='accRespFormattingId']"))).selectByValue("NONE");
            new Select(driver.findElement(By.xpath("//select[@id='statUpdatedMethodId']"))).selectByValue("EMAIL");

            new Select(driver.findElement(By.xpath("//select[@id='methodAuthId']"))).selectByValue("Passcode");

            // Radio Buttons
            if(Verbose) System.out.println("TEST :: Radio Buttons");
            driver.findElement(By.xpath("//tr[23]//td[2]//div[1]//div[1]//label[1]//span[1]")).click();
            driver.findElement(By.xpath("//tr[28]//td[2]//div[1]//div[1]//label[1]//span[1]")).click();
            driver.findElement(By.xpath("//tr[29]//td[2]//div[1]//div[1]//label[1]//span[1]")).click();

            // Dropdown (UTEST Only)
            if(Product.equalsIgnoreCase("UTEST"))
            {
                if(Verbose) System.out.println("TEST :: UTEST");
                driver.findElement(By.xpath("//select[@id='UTESTOptDropDownId']//option[1]")).click();
                driver.findElement(By.xpath("//option[contains(text(),'PHONE')]")).click();
                driver.findElement(By.xpath("//option[contains(text(),'INTERNET')]")).click();
            }

            // DTEST
            if(Product.equalsIgnoreCase("DTEST"))
            {
                if(Verbose) System.out.println("TEST :: DTEST");
                driver.findElement(By.id("dtvArchitectureIPId")).sendKeys("1234");
            }

            // Click - Submit Button
            if(Verbose) System.out.printf("TEST :: Submit Button\n");
            driver.findElement(By.id("submitCcpsFormId")).click();



            // ************************************************
            // Detailed Confirmation Window
            // ************************************************

            if(Verbose) System.out.println("TEST :: Detailed Confirmation Window");

            // Assertions
            if(Verbose) System.out.println("TEST :: Assertions");
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//h4[@class='modal-title cmlpModHeader']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//div[@class='modal-body']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.id("submitBtnId")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.id("okRegProjCodeCld")).size() > 0 ); // Assertion

            // Sleep
            // Short pause so that a human viewer can validate the script is working
            if(Sleepy)
                Thread.sleep(1000);

            // Click - Submit Button
            if(Verbose) System.out.printf("TEST :: Submit Button\n");
            driver.findElement(By.id("submitBtnId")).click();




            // ************************************************
            // Success Pop-Up
            // ************************************************

            if(Verbose) System.out.println("TEST :: Success Pop-Up Window");

            // Wait
            // Wait until Ticket Created text is located and populated
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-body text-info ng-binding ng-scope']")));
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.findElement(By.xpath("//div[@class='modal-body text-info ng-binding ng-scope']")).getText().length() > 10;
                }
            });

            // Assertions
            if(Verbose) System.out.println("TEST :: Assertions");
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//h4[@class='modal-title text-info ng-binding']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//div[@class='modal-body text-info ng-binding ng-scope']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//div[@class='modal-content']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//button[@class='btn btn-primary ng-binding']")).size() > 0 ); // Assertion



            // ************************************************
            // Test Result
            // ************************************************

            if(Verbose)
            {
                System.out.printf("========================================\n");
                System.out.printf("= %-36.36s =\n", "TEST RESULT");
                System.out.printf("========================================\n");
            }

            String MaarExampleTicketNumber =
                    driver.findElement(By.xpath("//div[@class='modal-body text-info ng-binding ng-scope']"))
                            .getText()
                            .replaceAll(".* - ", "")    // Remove everything before dash
                            .replaceAll("\\.", "")      // Remove trailing period
                    ;

            System.out.println(ANSI_CYAN + "Ticket Created: " + ANSI_YELLOW + MaarExampleTicketNumber + ANSI_RESET );

            // Click - OK Button
            //System.out.printf("TEST :: Submit Button\n");
            driver.findElement(By.xpath("//button[@class='btn btn-primary ng-binding']")).click();

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








    //@Test
    @ParameterizedTest
    @CsvSource(
            {
                    "laurencemaar, MTEST, 111111111111, 111-222-3333",
                    "laurencemaar, UTEST, 133321650, 123-456-7890",
                    "laurencemaar, DTEST STMS, 69870407, 123-456-7890"/*,
                    "laurencemaar, UTEST, 133321650, 123-456-7890",
                    "laurencemaar, DTEST STMS, 69870407, 123-456-7890",
                    "laurencemaar, UTEST, 133321650, 123-456-7890",
                    "laurencemaar, DTEST STMS, 69870407, 123-456-7890",
                    "laurencemaar, UTEST, 133321650, 123-456-7890",
                    "laurencemaar, DTEST STMS, 69870407, 123-456-7890"
                    */
            }
    )
    public void selenium_02_MaarExample_Inquiry_Test(String UID, String Product, String UserBAN, String UserPhone)
    {
        if(true)
        {
            System.out.printf("= %-45.45s =\n", ANSI_YELLOW + "This bot is turned off - Laurence" + ANSI_RESET);
            Assert.fail();
            return;
        }

        System.out.printf("========================================\n");
        System.out.printf("= %-36.36s =\n", "TEST Contingency Form - INQ");
        System.out.printf("========================================\n");

        try {
            // Go to URL
            if(Verbose) System.out.println("TEST :: Go to URL");
            driver.get("http://test.test.com:30437/MaarExample/index.html#/MaarExampleLogin");

            // Wait Until Expected Conditions
            wait = new WebDriverWait(driver, 10);
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("MaarExampleContDiv")));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'customer')]")));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'employee')]")));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(text(),'Non Customer')]")));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'File Complaint')]")));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("File Complaint")));

            // ************************************************
            // Customer Type Selection
            // - Customer / Former / Non-Customer
            // ************************************************

            System.out.println(
                    "TEST :: PAGE = " +
                            driver.getTitle() +
                            " / " +
                            driver.getCurrentUrl()
            );

            // Assertions
            if(Verbose) System.out.println("TEST :: Assertions");
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//label[contains(text(),'customer')]")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//label[contains(text(),'employee')]")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//label[contains(text(),'Non Customer')]")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//button[@id='continueBtnId']")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.linkText("File Complaint")).size() > 0 ); // Assertion

            // File Complaint
            //element = driver.findElement(By.linkText("File Complaint"));
            //System.out.printf("TEST :: Complaint = %s\n", element.getText());
            //element.click();

            driver.get(driver.findElement(By.linkText("File Complaint")).getAttribute("href"));


            // Sleep
            // Short pause so that a human viewer can validate the script is working
            if(Sleepy)
                Thread.sleep(500);



            // ************************************************
            // Inquiry Request Page
            // ************************************************

            System.out.println(
                    "TEST :: PAGE = " +
                            driver.getTitle() +
                            " / " +
                            driver.getCurrentUrl()
            );

            // Assertions
            if(Verbose) System.out.println("TEST :: Assertions");
            org.junit.Assert.assertTrue( driver.findElements(By.id("subjectTypesDSARElement")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//span[contains(text(),'Non Customer')]")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//span[contains(text(),'Employee')]")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.xpath("//span[contains(text(),'Inquiry Request')]")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.id("firstNameDSARElement")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.id("lastNameDSARElement")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.id("emailDSARElement")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.id("formField12DSARElement")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.id("formField13DSARElement")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.id("formField14DSARElement")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.id("formField56DSARElement")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.id("formField53DSARElement")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.id("formField54DSARElement")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.id("formField21DSARElement")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.id("formField61DSARElement")).size() > 0 ); // Assertion
            org.junit.Assert.assertTrue( driver.findElements(By.id("dsar-webform-submit-button")).size() > 0 ); // Assertion


            // Buttons
            if(Verbose) System.out.println("TEST :: Buttons");
            driver.findElement(By.xpath("//div[@id='subjectTypesDSARElement']//label[1]//span[1]")).click();
            driver.findElement(By.xpath("//span[contains(text(),'Inquiry Request')]")).click();


            // Text Fields
            if(Verbose) System.out.println("TEST :: Text Fields");
            driver.findElement(By.id("firstNameDSARElement")).sendKeys(UID);
            driver.findElement(By.id("lastNameDSARElement")).sendKeys(String.format("%3.3s %s",Product,"INQUIRY"));

            driver.findElement(By.id("addressDSARElement")).sendKeys("123 Main St");
            driver.findElement(By.id("cityDSARElement")).sendKeys("Los Angeles");
            driver.findElement(By.id("formField48DSARElement")).sendKeys("CA"); // State
            driver.findElement(By.id("zipDSARElement")).sendKeys("12345");

            driver.findElement(By.id("formField11DSARElement")).sendKeys(UserBAN);
            driver.findElement(By.id("formField12DSARElement")).sendKeys(UserPhone);
            driver.findElement(By.id("formField13DSARElement")).sendKeys(UserPhone);

            driver.findElement(By.id("emailDSARElement")).sendKeys(UID + "@test.com");
            driver.findElement(By.id("formField14DSARElement")).sendKeys("en-us"); // Language

            driver.findElement(By.id("formField21DSARElement")).sendKeys("EMAIL"); // Method of Communication

            driver.findElement(By.id("formField24DSARElement")).sendKeys(UID); // Agent ID

            String Description = "This is a test inquiry submitted by " + UID;
            driver.findElement(By.id("formField22DSARElement")).sendKeys(Description); // Desc. of Inquiry
            driver.findElement(By.id("formField29DSARElement")).sendKeys(Description); // Agent Notes
            driver.findElement(By.id("formField46DSARElement")).sendKeys(Description); // Additional Info

            driver.findElement(By.id("formField68DSARElement")).sendKeys(Product); // Product



            // Drop-Downs
            if(Verbose) System.out.println("TEST :: Drop-Downs");
            driver.findElement(By.id("formField56DSARElement")).click(); // Type of Inquiry
            driver.findElement(By.id("formField56DSARElement")).click(); // Type of Inquiry
            driver.findElement(By.xpath("//span[contains(text(),'Submitting a new request or other data concerns')]")).click(); // Request Channel

            driver.findElement(By.id("formField53DSARElement")).click(); // Source of Inquiry
            driver.findElement(By.id("formField53DSARElement")).click(); // Source of Inquiry
            driver.findElement(By.xpath("//span[@class='vt-option__text'][contains(text(),'Customer')]")).click(); // Request Channel

            driver.findElement(By.id("formField54DSARElement")).click(); // Sub-Source of Inquiry
            driver.findElement(By.id("formField54DSARElement")).click(); // Sub-Source of Inquiry
            driver.findElement(By.xpath("//span[@class='vt-option__text'][contains(text(),'Customer')]")).click(); // Request Channel

            driver.findElement(By.id("formField61DSARElement")).click(); // Request Channel
            driver.findElement(By.id("formField61DSARElement")).click(); // Request Channel
            driver.findElement(By.xpath("//span[contains(text(),'EMAIL')]")).click(); // Request Channel



            // Click - Submit Button
            if(Verbose) System.out.printf("TEST :: Submit Button\n");
            driver.findElement(By.id("dsar-webform-submit-button")).click();



            // ************************************************
            // Success Screen
            // ************************************************

            if(Verbose) System.out.println("TEST :: Success Window");

            // Wait
            // Wait until Ticket Created text is located and populated
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Thank you')]")));




            // ************************************************
            // Test Result
            // ************************************************

            if(Verbose)
            {
                System.out.printf("========================================\n");
                System.out.printf("= %-36.36s =\n", "TEST RESULT");
                System.out.printf("========================================\n");
            }

            System.out.println(ANSI_CYAN + "Inquiry Created: " + ANSI_YELLOW + "SUCCESS" + ANSI_RESET );

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
