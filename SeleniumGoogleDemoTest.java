/*
 * Laurence Maar
 * https://www.linkedin.com/in/laurencemaar/
 * https://github.com/laurencemaar/
 
 This code demostrates basic Selenium concepts and functionality using Google and Bing
 such as doing a basic search, storing results in an array and identifying patterns in
 results. This is intended to be used for training/example purposes.

 * Selenium Quick Demo
 * -----
 * This is demo will do the following:
 * 1) Search on google.com
 *    This first does a search for "Laurence Maar"
 *    Then grabs all of the link results containing the text "Laurence Maar"
 *    Then grabs ALL of the link results (output ignores google.com, etc.)
 *    Filters the List by removing results with google.com and googleusercontent.com
 *    Clicks on Images link
 * 2) Search on bing.com
 *    Just added a simple search on bing.com for variety, no additional processing
 * 3) Search on google.com
 *    Randomly pick a search string from a pre-defined String array.
 *    This is an example of how we can introduce variability into a Selenium script as well as dynamically
 *    change validation conditions as a result.
 *    A more complex version of this could retrieve a list of variables from a CSV document, database, etc.
 * -----
 * Laurence Maar
 * https://www.linkedin.com/in/laurencemaar/
 * https://github.com/laurencemaar/
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import static org.junit.jupiter.api.Assertions.fail;


public class SeleniumGoogleDemoTest {

    // Define variables
    public static WebElement element;
    public static WebElement myDynamicElement;
    public static WebDriver driver;
    public static WebDriverWait wait;


    public void SeleniumGoogleDemoTest() {
        /*
         * Start
         */

        // Initiate Browser Driver
        seleniumStartBrowser();


        /*
         * 1) Search on google.com
         *    First does a search for "Laurence Maar"
         *    Then grabs all of the link results containing the text "Laurence Maar"
         *    Then grabs ALL of the link results (output ignores google.com, etc.)
         *    Filters the List by removing results with google.com and googleusercontent.com
         *    Grabs all visible text in HTML BODY
         *    Shows a count of a specific string within the text (i.e. count of string matches)
         *    Grabs all numbers within the body text and puts them in a linked list
         *    Clicks on Images link
         */
        selenium_01_GoogleSearch();


        /*
         * 2) Search on bing.com
         *    Just added a simple search on bing.com for variety, no additional processing
         */
        selenium_02_BingSimple();


        /*
         * 3) Search on google.com
         *    Randomly pick a search string from a pre-defined String array.
         *    This is an example of how we can introduce variability (aka parameterization) into a Selenium script
         *    as well as dynamically change validation conditions as a result.
         *    A more complex version of this could retrieve a list of variables from a CSV document, database, etc.
         */
        selenium_03_GoogleUsingStringArray();


        /*
         * Quit
         */
        seleniumCloseBrowser();
    }



    @BeforeAll
    public static void seleniumStartBrowser()
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
            driver = new FirefoxDriver();

            // Wait
            wait = new WebDriverWait(driver, 10);

            //driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            // Exception
            System.out.println("****************************************");
            System.out.println("EXCEPTION :: startBrowser()");
            System.out.println("EXCEPTION :: " + e.getClass());
            System.out.println("EXCEPTION :: " + e.getMessage());
            System.out.println("EXCEPTION :: " + e.getCause());
            System.out.println("****************************************");
            e.printStackTrace();
            fail(e.getMessage());
        }
    }



    @AfterAll
    public static void seleniumCloseBrowser()
    {
        System.out.printf("========================================\n");
        System.out.printf("= %-36.36s =\n", "QUIT");
        System.out.printf("========================================\n");

        //Close the browser
        driver.quit();
    }



    @Test
    public void selenium_01_GoogleSearch()
    {
        /*
         * 1) Search on google.com
         *    First does a search for "Laurence Maar"
         *    Then grabs all of the link results containing the text "Laurence Maar"
         *    Then grabs ALL of the link results (output ignores google.com, etc.)
         *    Filters the List by removing results with google.com and googleusercontent.com
         *    Grabs all visible text in HTML BODY
         *    Shows a count of a specific string within the text (i.e. count of string matches)
         *    Grabs all numbers within the body text and puts them in a linked list
         *    Clicks on Images link
         */

        System.out.printf("========================================\n");
        System.out.printf("= %-36.36s =\n", "google.com");
        System.out.printf("========================================\n");

        try {
            // Go to URL
            System.out.println("TEST :: Go to URL");
            driver.get("http://www.google.com");
            // Alternate code:
            // driver.navigate().to("http://www.google.com");

            // Allow time for page to load
            myDynamicElement = (new WebDriverWait(driver, 3))
                    .until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

            // Find Input Element by Name
            org.junit.Assert.assertTrue( driver.findElements(By.name("q")).size() > 0 ); // Assertion
            element = driver.findElement(By.name("q"));

            // Enter Search Query
            System.out.println("TEST :: Search for Laurence Maar");
            element.sendKeys("Laurence Maar");

            // Submit Form
            element.submit();

            // Google's search is rendered dynamically with JavaScript.
            // Wait for the page to load, timeout after 10 seconds
            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith("laurence maar");
                }
            });

            // Validation
            System.out.println("Page title is: " + driver.getTitle());
            System.out.println("Page URL is:   " + driver.getCurrentUrl());

            org.junit.Assert.assertTrue( driver.getTitle().toLowerCase().startsWith("laurence maar") ); // Assertion

        } catch (Exception e) {
            // Exception
            System.out.println("****************************************");
            System.out.println("EXCEPTION :: seleniumGoogleSearch() - Main block");
            System.out.println("EXCEPTION :: " + e.getClass());
            System.out.println("EXCEPTION :: " + e.getMessage());
            System.out.println("EXCEPTION :: " + e.getCause());
            System.out.println("****************************************");
            e.printStackTrace();
            fail(e.getMessage());
            return;
        }


        // This code just grabs the first link matching the partial link text criteria
        System.out.printf("========================================\n");
        System.out.printf("= %-36.36s =\n", "First Link Result");
        System.out.printf("========================================\n");
        try {
            // Find First "Laurence Maar" Link
            org.junit.Assert.assertTrue( driver.findElements(By.partialLinkText("Laurence Maar")).size() > 0 ); // Assertion
            element = driver.findElement(By.partialLinkText("Laurence Maar"));

            System.out.printf("First Link: %s\n", element.getText());
            System.out.printf("First Link: %s\n", element.getAttribute("href"));
        } catch (Exception e) {
            // Exception
            System.out.println("****************************************");
            System.out.println("EXCEPTION :: seleniumGoogleSearch() - Link 1");
            System.out.println("EXCEPTION :: " + e.getClass());
            System.out.println("EXCEPTION :: " + e.getMessage());
            System.out.println("EXCEPTION :: " + e.getCause());
            System.out.println("****************************************");
            e.printStackTrace();
            fail(e.getMessage());
            return;
        }


        // This code takes it one step further and grabs all of the links matching the partial link text criteria
        // and puts them in a List
        System.out.printf("========================================\n");
        System.out.printf("= %-36.36s =\n", "All 'Laurence Maar' Results");
        System.out.printf("========================================\n");
        try {
            // Find ALL "Laurence Maar" Links
            List<WebElement> elements = driver.findElements(By.partialLinkText("Laurence Maar"));
            System.out.println("Number of elements:" +elements.size());

            org.junit.Assert.assertTrue( elements.size() > 0 ); // Assertion

            for (int i=0; i<elements.size();i++){
                System.out.printf("#%d === %s\n", i+1, elements.get(i).getText());
                System.out.printf("#%d === %s\n", i+1, elements.get(i).getAttribute("href"));
            }
        } catch (Exception e) {
            // Exception
            System.out.println("****************************************");
            System.out.println("EXCEPTION :: seleniumGoogleSearch() - LM");
            System.out.println("EXCEPTION :: " + e.getClass());
            System.out.println("EXCEPTION :: " + e.getMessage());
            System.out.println("EXCEPTION :: " + e.getCause());
            System.out.println("****************************************");
            e.printStackTrace();
            fail(e.getMessage());
            return;
        }


        // This code grabs ALL LINKS on the page and puts them in a List
        System.out.printf("========================================\n");
        System.out.printf("= %-36.36s =\n", "All Links on Page");
        System.out.printf("========================================\n");
        try {
            // Find ALL Links
            //List<WebElement> elements = driver.findElements(By.xpath("//a[@href]"));
            //List<WebElement> elements = driver.findElements(By.xpath("//div[@class='srg']//a[@href]"));
            List<WebElement> elements = driver.findElements(By.xpath("//div[@class='r']//a[@href]"));
            System.out.println("Number of elements:" +elements.size());

            org.junit.Assert.assertTrue( elements.size() > 0 ); // Assertion

            if(elements.size()>0) {
                for (int i=0; i<elements.size();i++){
                    if(
                            !elements.get(i).getAttribute("href").contains("google.com")
                                    &&
                                    !elements.get(i).getAttribute("href").contains("googleusercontent.com")
                    )
                    {
                        // System.out.printf("#%d === %s\n", i+1, elements.get(i).getText());
                        System.out.printf("#%d === %s\n", i+1, elements.get(i).getAttribute("href"));
                    }
                }
            }
        } catch (Exception e) {
            // Exception
            System.out.println("****************************************");
            System.out.println("EXCEPTION :: seleniumGoogleSearch() - List");
            System.out.println("EXCEPTION :: " + e.getClass());
            System.out.println("EXCEPTION :: " + e.getMessage());
            System.out.println("EXCEPTION :: " + e.getCause());
            System.out.println("****************************************");
            e.printStackTrace();
            fail(e.getMessage());
            return;
        }


        // This code grabs ALL LINKS on the page, puts them in a List and then removes the superfluous google links
        System.out.printf("========================================\n");
        System.out.printf("= %-36.36s =\n", "Clean LIST numbering");
        System.out.printf("========================================\n");
        try {
            // Find ALL Links
            //List<WebElement> elements = driver.findElements(By.xpath("//a[@href]"));
            //List<WebElement> elements = driver.findElements(By.xpath("//div[@class='srg']//a[@href]"));
            List<WebElement> elements = driver.findElements(By.xpath("//div[@class='r']//a[@href]"));
            System.out.println("Number of elements:" +elements.size() + " (before cleaning)");

            org.junit.Assert.assertTrue( elements.size() > 0 ); // Assertion

            if(elements.size()>0) {
                for (int i=0; i<elements.size();i++){
                    if(elements.get(i).getAttribute("href").contains("google.com")
                            || elements.get(i).getAttribute("href").contains("googleusercontent.com")
                    ) {
                        // Ignore the extra results with google.com
                        // Do not print - I commented out this original code I used for debugging
                        // System.out.printf("#%d === IGNORE %s\n", i+1, elements.get(i).getAttribute("href"));
                        elements.remove(i);
                        i--;
                    }
                }
            }

            System.out.println("Number of elements:" +elements.size() + " (after cleaning)" );

            org.junit.Assert.assertTrue( elements.size() > 0 ); // Assertion

            if(elements.size()>0) {
                for (int i=0; i<elements.size();i++){
                    // System.out.printf("#%d === %s\n", i+1, elements.get(i).getText());
                    System.out.printf("#%d === %s\n", i+1, elements.get(i).getAttribute("href"));
                }
            }

        } catch (Exception e) {
            // Exception
            System.out.println("****************************************");
            System.out.println("EXCEPTION :: seleniumGoogleSearch() - List");
            System.out.println("EXCEPTION :: " + e.getClass());
            System.out.println("EXCEPTION :: " + e.getMessage());
            System.out.println("EXCEPTION :: " + e.getCause());
            System.out.println("****************************************");
            e.printStackTrace();
            fail(e.getMessage());
            return;
        }


        // This code grabs ALL TEXT on the page
        // - First this counts the instances of the word "Laurence" on the page
        // - Then this grabs only all of the distinct numbers on a page
        System.out.printf("========================================\n");
        System.out.printf("= %-36.36s =\n", "ALL TEXT");
        System.out.printf("========================================\n");
        try {
            // Find ALL Text
            org.junit.Assert.assertTrue( driver.findElements(By.tagName("body")).size() > 0 ); // Assertion
            element = driver.findElement(By.tagName("body"));

            System.out.println( element.getText() );

            // Grab count of instances of "Laurence"
            System.out.printf("========================================\n");
            System.out.printf("= %-36.36s =\n", "ALL TEXT - Laurence");
            System.out.printf("========================================\n");

            System.out.println( "Instances of \"Laurence\" in body text: "
                    + StringUtils.countMatches(element.getText().toLowerCase() , "laurence"));

            // Grab just numbers
            System.out.printf("========================================\n");
            System.out.printf("= %-36.36s =\n", "ALL TEXT - Numbers");
            System.out.printf("========================================\n");

            // Filter text to just numbers, decimals, dashes, slashes and parentheses
            String strJustNumbers = element.getText()
                    .replaceAll("[^0-9\\.\\-\\n,\\\\\\/]"," ")
                    .replaceAll(", ", "\n")
                    .replaceAll(" {2,}", "\n")
                    .replaceAll("\\.{2,}", "\n")
                    .replaceAll("[^0-9]+\\n","\n")
                    .replaceAll("\\n{2,}", "\n")
                    ;

            // Put all results into a LinkedList
            List<String> strarrayNumbers = new LinkedList<>(Arrays.asList(strJustNumbers.split("\\n")));

            org.junit.Assert.assertTrue( strarrayNumbers.size() > 0 ); // Assertion

            // Print out all values in the LinkedList and remove any blank entries
            for(int i=0; i<strarrayNumbers.size(); i++)
            {
                if(strarrayNumbers.get(i).length()>0)
                {
                    // Print value from list
                    System.out.println( strarrayNumbers.get(i) );
                }
                else
                {
                    // Remove blank entries
                    strarrayNumbers.remove(i);
                    i--;
                }
            }

            // Print entire List
            System.out.println( strarrayNumbers );

        } catch (Exception e) {
            // Exception
            System.out.println("****************************************");
            System.out.println("EXCEPTION :: seleniumGoogleSearch() - Text");
            System.out.println("EXCEPTION :: " + e.getClass());
            System.out.println("EXCEPTION :: " + e.getMessage());
            System.out.println("EXCEPTION :: " + e.getCause());
            System.out.println("****************************************");
            e.printStackTrace();
            fail(e.getMessage());
            return;
        }


        // This just looks for the "Images for..." link and then clicks on it
        System.out.printf("========================================\n");
        System.out.printf("= %-36.36s =\n", "Click on Image Link");
        System.out.printf("========================================\n");
        try {
            // Find "Images for ..." Link
            org.junit.Assert.assertTrue( driver.findElements(By.partialLinkText("Images for")).size() > 0 ); // Assertion
            element = driver.findElement(By.partialLinkText("Images for"));
            System.out.printf("Images text: %s\n", element.getText());
            element.click();

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Exception
            System.out.println("****************************************");
            System.out.println("EXCEPTION :: seleniumGoogleSearch() - Images for...");
            System.out.println("EXCEPTION :: " + e.getClass());
            System.out.println("EXCEPTION :: " + e.getMessage());
            System.out.println("EXCEPTION :: " + e.getCause());
            System.out.println("****************************************");
            e.printStackTrace();
            fail(e.getMessage());
            return;
        }

    }



    @Test
    public void selenium_02_BingSimple()
    {
        /*
         * 2) Search on bing.com
         *    Just added a simple search on bing.com for variety, no additional processing
         */

        System.out.printf("========================================\n");
        System.out.printf("= %-36.36s =\n", "bing.com");
        System.out.printf("========================================\n");

        try {
            // Go to URL
            System.out.println("TEST :: Go to URL");
            driver.get("http://www.bing.com");
            // Alternate code:
            // driver.navigate().to("http://www.bing.com");

            // Allow time for page to load
            myDynamicElement = (new WebDriverWait(driver, 3))
                    .until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

            // Find Input Element by Name
            org.junit.Assert.assertTrue( driver.findElements(By.name("q")).size() > 0 ); // Assertion
            element = driver.findElement(By.name("q"));

            // Enter Search Query
            System.out.println("TEST :: Search for Laurence Maar");
            element.sendKeys("Laurence Maar");

            // Submit Form
            element.submit();

            // Wait for the page to load, timeout after 10 seconds
            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith("laurence maar");
                }
            });

            // Validation
            System.out.println("Page title is: " + driver.getTitle());
            System.out.println("Page URL is:   " + driver.getCurrentUrl());

            org.junit.Assert.assertTrue( driver.getTitle().toLowerCase().startsWith("laurence maar") ); // Assertion

        } catch (Exception e) {
            // Exception
            System.out.println("****************************************");
            System.out.println("EXCEPTION :: seleniumBingSimple()");
            System.out.println("EXCEPTION :: " + e.getClass());
            System.out.println("EXCEPTION :: " + e.getMessage());
            System.out.println("EXCEPTION :: " + e.getCause());
            System.out.println("****************************************");
            e.printStackTrace();
            fail(e.getMessage());
            return;
        }
    }



    @Test
    public void selenium_03_GoogleUsingStringArray()
    {
        /*
         * 3) Search on google.com
         *    Randomly pick a search string from a pre-defined String array.
         *    This is an example of how we can introduce variability (aka parameterization) into a Selenium script
         *    as well as dynamically change validation conditions as a result.
         *    A more complex version of this could retrieve a list of variables from a CSV document, database, etc.
         */

        System.out.printf("========================================\n");
        System.out.printf("= %-36.36s =\n", "google.com string array search");
        System.out.printf("========================================\n");

        try {
            // Define String array
            String query[] = new String[] {"Testing", "Automation", "SDLC", "Selenium", "AI", "JAVA", "Eclipse"};
            System.out.printf("TEST :: String Array Length = %d\n", query.length );

            // Choose Random String from array
            int randomString = new Random().nextInt(query.length);
            System.out.printf("TEST :: String Array Random = %d - %s\n", randomString+1, query[randomString] );

            // Go to URL
            System.out.println("TEST :: Go to URL");
            driver.get("http://www.google.com");
            // Alternate code:
            // driver.navigate().to("http://www.google.com");

            // Allow time for page to load
            myDynamicElement = (new WebDriverWait(driver, 3))
                    .until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

            // Find Input Element by Name
            org.junit.Assert.assertTrue( driver.findElements(By.name("q")).size() > 0 ); // Assertion
            element = driver.findElement(By.name("q"));

            // Enter Search Query
            System.out.printf("TEST :: Search for %s\n", query[randomString]);
            element.sendKeys(query[randomString]);

            // Submit Form
            element.submit();

            // Get Page Title
            System.out.println("Page title is: " + driver.getTitle());

            // Google's search is rendered dynamically with JavaScript.
            // Wait for the page to load, timeout after 10 seconds
            (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith(query[randomString].toLowerCase());
                }
            });

            // Validation
            System.out.println("Page title is: " + driver.getTitle());

            org.junit.Assert.assertTrue( driver.getTitle().startsWith(query[randomString]) ); // Assertion

        } catch (Exception e) {
            // Exception
            System.out.println("****************************************");
            System.out.println("EXCEPTION :: seleniumGoogleUsingStringArray()");
            System.out.println("EXCEPTION :: " + e.getClass());
            System.out.println("EXCEPTION :: " + e.getMessage());
            System.out.println("EXCEPTION :: " + e.getCause());
            System.out.println("****************************************");
            e.printStackTrace();
            fail(e.getMessage());
            return;
        }



        // This code grabs ALL LINKS on the page and also removes the superfluous google links
        System.out.printf("========================================\n");
        System.out.printf("= %-36.36s =\n", "Clean LIST numbering");
        System.out.printf("========================================\n");
        try {
            // Find ALL Links
            //List<WebElement> elements = driver.findElements(By.xpath("//a[@href]"));
            //List<WebElement> elements = driver.findElements(By.xpath("//div[@class='srg']//a[@href]"));
            List<WebElement> elements = driver.findElements(By.xpath("//div[@class='r']//a[@href]"));
            System.out.println("Number of elements:" +elements.size() + " (before cleaning)");

            org.junit.Assert.assertTrue( elements.size()>0 ); // Assertion

            if(elements.size()>0) {
                for (int i=0; i<elements.size();i++){
                    if(elements.get(i).getAttribute("href").contains("google.com")
                            || elements.get(i).getAttribute("href").contains("googleusercontent.com")
                    ) {
                        // Ignore the extra results with google.com
                        // Do not print - I commented out this original code I used for debugging
                        // System.out.printf("#%d === IGNORE %s\n", i+1, elements.get(i).getAttribute("href"));
                        elements.remove(i);
                        i--;
                    }
                }
            }

            System.out.println("Number of elements:" +elements.size() + " (after cleaning)" );

            org.junit.Assert.assertTrue( elements.size()>0 ); // Assertion

            if(elements.size()>0) {
                for (int i=0; i<elements.size();i++){
                    // System.out.printf("#%d === %s\n", i+1, elements.get(i).getText());
                    System.out.printf("#%d === %s\n", i+1, elements.get(i).getAttribute("href"));
                }
            }

        } catch (Exception e) {
            // Exception
            System.out.println("****************************************");
            System.out.println("EXCEPTION :: seleniumGoogleSearch() - Link 2");
            System.out.println("EXCEPTION :: " + e.getClass());
            System.out.println("EXCEPTION :: " + e.getMessage());
            System.out.println("EXCEPTION :: " + e.getCause());
            System.out.println("****************************************");
            e.printStackTrace();
            fail(e.getMessage());
        }

    }

}
