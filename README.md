# Selenium
Selenium Sample Code - Written in JAVA using Eclipse and IntelliJ IDEA 

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
 



************************************************************************



SAMPLE OUTPUT:

========================================
= START                                =
========================================
TEST :: Initiate Chrome Driver
Starting ChromeDriver 77.0.3865.40 (f484704e052e0b556f8030b65b953dce96503217-refs/branch-heads/3865@{#442}) on port 22348
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
[1573249199.722][WARNING]: This version of ChromeDriver has not been tested with Chrome version 78.
[1573249201.727][WARNING]: Timed out connecting to Chrome, retrying...
Nov 08, 2019 1:40:03 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
========================================
= google.com                           =
========================================
TEST :: Go to URL
TEST :: Search for Laurence Maar
Page title is: Laurence Maar - Google Search
Page URL is:   https://www.google.com/search?source=hp&ei=tODFXa-JDJDwsQWlnLy4DQ&q=Laurence+Maar&oq=Laurence+Maar&gs_l=psy-ab.3...152.260..270...0.0..0.0.0.......0....1..gws-wiz.
Page title: Passed!
========================================
= First Link Result                    =
========================================
First Link: Laurence Maar (Y), 41 - Corona, CA Has Court or Arrest ...
https://www.mylife.com › People Search › CA › Corona › Laurence Maar
First Link: https://www.mylife.com/laurence-maar/e495165400656
========================================
= All 'Laurence Maar' Results          =
========================================
Number of elements:8
#1 === Laurence Maar (Y), 41 - Corona, CA Has Court or Arrest ...
https://www.mylife.com › People Search › CA › Corona › Laurence Maar
#1 === https://www.mylife.com/laurence-maar/e495165400656
#2 === Laurence Maar, Class of 1995 - Diamond Bar High School ...
https://www.classmates.com › people › LaurenceMaar
#2 === https://www.classmates.com/people/LaurenceMaar/125098761
#3 === Images for Laurence Maar
#3 === https://www.google.com/search?q=Laurence+Maar&tbm=isch&source=hp&sa=X&ved=2ahUKEwjMmoCAytvlAhUBR6wKHdslB9gQsAR6BAgGEAE
#4 === More images for Laurence Maar
#4 === https://www.google.com/search?q=Laurence+Maar&tbm=isch&source=hp&sa=X&ved=2ahUKEwjMmoCAytvlAhUBR6wKHdslB9gQ7Al6BAgGECQ
#5 === Laurence Maar (@laurencemaar) • Instagram photos and videos
https://www.instagram.com › laurencemaar
#5 === https://www.instagram.com/laurencemaar/
#6 === Laurence Maar Photography | Flickr
https://www.flickr.com › photos
#6 === https://www.flickr.com/photos/80797276@N06/
#7 === laurencemaar (Laurence Maar) · GitHub
https://github.com › laurencemaar
#7 === https://github.com/laurencemaar/
#8 === Laurence Maar - Associate Director - Release Management ...
https://www.linkedin.com › laurencemaar
#8 === https://www.linkedin.com/in/laurencemaar
========================================
= All Links on Page                    =
========================================
Number of elements:18
#1 === https://www.mylife.com/laurence-maar/e495165400656
#4 === https://www.classmates.com/people/LaurenceMaar/125098761
#7 === https://www.instagram.com/laurencemaar/
#8 === https://www.flickr.com/photos/80797276@N06/
#9 === https://www.imdb.com/name/nm9418669/
#10 === https://github.com/laurencemaar/
#13 === https://www.linkedin.com/in/laurencemaar
#16 === https://www.linkedin.com/pub/dir/Laurence/Of+Mar
========================================
= Clean LIST numbering                 =
========================================
Number of elements:18 (before cleaning)
Number of elements:8 (after cleaning)
#1 === https://www.mylife.com/laurence-maar/e495165400656
#2 === https://www.classmates.com/people/LaurenceMaar/125098761
#3 === https://www.instagram.com/laurencemaar/
#4 === https://www.flickr.com/photos/80797276@N06/
#5 === https://www.imdb.com/name/nm9418669/
#6 === https://github.com/laurencemaar/
#7 === https://www.linkedin.com/in/laurencemaar
#8 === https://www.linkedin.com/pub/dir/Laurence/Of+Mar
========================================
= ALL TEXT                             =
========================================
Accessibility Links
Skip to main content
Accessibility help
Accessibility feedback
.
Sign in
Search Modes
All
Images
Videos
News
Maps
More
Settings
Tools
About 8,050,000 results (0.51 seconds) 


Search Results
Web results
Laurence Maar (Y), 41 - Corona, CA Has Court or Arrest ...
https://www.mylife.com › People Search › CA › Corona › Laurence Maar
Laurence Maar's birthday is 11/01/1977 and is 41 years old. Laurence's Reputation Score is 2.65. Corona, CA, is where Laurence Maar lives today.
Laurence Maar, Class of 1995 - Diamond Bar High School ...
https://www.classmates.com › people › LaurenceMaar
Laurence Maar 1995 graduate of Diamond Bar High School in Diamond Bar, CA is on Classmates.com. Get caught up with Laurence Maar and other high ...
Images for Laurence Maar
View all
More images for Laurence Maar
Report images
Web results
Laurence Maar (@laurencemaar) • Instagram photos and videos
https://www.instagram.com › laurencemaar
442 Followers, 782 Following, 88 Posts - See Instagram photos and videos from Laurence Maar (@laurencemaar)
Laurence Maar Photography | Flickr
https://www.flickr.com › photos
Explore Laurence Maar Photography's 1698 photos on Flickr!
Laurence Mar - IMDb
https://www.imdb.com › name
Laurence Mar. + Add or change photo on IMDbPro ». Contribute to IMDb. Add a bio, trivia, and more. Update information for Laurence Mar » ...
laurencemaar (Laurence Maar) · GitHub
https://github.com › laurencemaar
laurencemaar has 4 repositories available. Follow their code on GitHub.
Laurence Maar - Associate Director - Release Management ...
https://www.linkedin.com › laurencemaar
View Laurence Maar's profile on LinkedIn, the world's largest professional community. Laurence has 1 job listed on their profile. See the complete profile on ...
10+ Laurence Of Mar profiles | LinkedIn
https://www.linkedin.com › pub › dir › Laurence › Of+Mar
View the profiles of professionals named Laurence Of Mar on LinkedIn. There are 10+ professionals named Laurence Of Mar, who use LinkedIn to exchange ...
Maurits van Saxen of de Veldslag van Fontenoy, ...
https://books.google.com › books - Translate this page
1811
De oude Laurence. " - - DE MAAR sc HALK. ( . Op de bevestiging hiervan, roept hij nogmaals uit; ,, Dat verwondert mij!” - - * . LAURENcE. Lieve hemel' die ...
Page Navigation
1
2
3
4
5
6
7
8
9
10
Next
Footer Links
92860, Norco, CA - From your Internet address - Use precise location - Learn more
HelpSend feedbackPrivacyTerms
========================================
= ALL TEXT - Laurence                  =
========================================
Instances of "Laurence" in body text: 35
========================================
= ALL TEXT - Numbers                   =
========================================
8,050,000
0.51
41
11/01/1977
41
2.65
1995
1995
442
782
88
1698
4
1
10
10
1811
1
2
3
4
5
6
7
8
9
10
92860
[8,050,000, 0.51, 41, 11/01/1977, 41, 2.65, 1995, 1995, 442, 782, 88, 1698, 4, 1, 10, 10, 1811, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 92860]
========================================
= Click on Image Link                  =
========================================
Images text: Images for Laurence Maar
========================================
= bing.com                             =
========================================
TEST :: Go to URL
TEST :: Search for Laurence Maar
Page title is: Laurence Maar - Bing
Page URL is:   https://www.bing.com/search?q=Laurence+Maar&qs=n&form=QBLH&sp=-1&pq=&sc=0-0&sk=&cvid=E5B456B56A02402E9F224C8D02EEBE47
Page title: Passed!
========================================
= google.com string array search       =
========================================
TEST :: String Array Length = 7
TEST :: String Array Random = 4 - Selenium
TEST :: Go to URL
TEST :: Search for SeleniumPage title is: Selenium - Google Search
Page title is: Selenium - Google Search
Page title: Passed!
========================================
= Clean LIST numbering                 =
========================================
Number of elements:37 (before cleaning)
Number of elements:14 (after cleaning)
#1 === https://www.seleniumhq.org/
#2 === https://www.medicalnewstoday.com/articles/287842.php
#3 === https://www.healthline.com/health/selenium-foods
#4 === https://simple.m.wikipedia.org/wiki/Selenium
#5 === https://www.everydayhealth.com/drugs/selenium
#6 === https://www.seleniumhq.org/projects/webdriver/
#7 === https://www.webmd.com/a-to-z-guides/supplement-guide-selenium
#8 === https://www.healthline.com/nutrition/selenium-benefits
#9 === https://ods.od.nih.gov/factsheets/Selenium-HealthProfessional/
#10 === https://www.medicalnewstoday.com/articles/287842.php
#11 === https://lpi.oregonstate.edu/mic/minerals/selenium
#12 === https://www.guru99.com/introduction-to-selenium.html
#13 === https://en.wikipedia.org/wiki/Selenium_(software)
#14 === https://github.com/SeleniumHQ/selenium
