# Project Title

Digiturk Test Automation

## Before Starting

* Cucumber and Junit are used for this project.

* Test is running on Chrome web browser by default.

## Test Covarage

1) Navigate to https://connect-au.beinsports.com/en

2) Click Subscribe button
 
3) Register to One Month(Monthly Plan with Two Week Free Trial) package
   
4) Validate package price
   
5) Fill Create Account form with a random email

6) Make Payment with Credit Card

7) Expect for a total charge of 1.00 since this is a free trial package

8) Provide a test card data and confirm payment(Do not enter a real card data)

9) Expect for a error text and finish test with success

## How to Run Tests and Get Report

After cloning the project "mvn clean verify" command can be used via using command line.

Example : <projectFolderLocation> mvn clean verify

Report Location : <projectFolderLocation>
\subscriptionTest\target\cucumber-report-html\cucumber-html-reports\file-src-test-resources-features-test-feature.html

Report file need to be opened with a browser.

## How To Run Only Test

After cloning the project you need to run TestRunner class or "mvn clean test" command can be used via using command
line.

Example : <projectFolderLocation> mvn clean test

## How to Get Report

After test run "mvn verify -DskipTest" line need to be executed via using command line.

Report Location : <projectFolderLocation>
\subscriptionTest\target\cucumber-report-html\cucumber-html-reports\file-src-test-resources-features-test-feature.html

Report file need to be opened with a browser.

## Structure

MAVEN - Project Structure.

## Project Owner

Batur Türkmen [ustadlostad](https://github.com/ustadlostad)
