This project is a Quality Assurance Product test for a simulated Flight and Hotel Booking Website. It covers both manual and automated testing of core user journeys such as account creation, login, flight search, and hotel booking using Selenium WebDriver with Java and TestNG.

This project demonstrates: end-to-end manual and automated test coverage, testing of realistic user flows on a booking website, Practice and present skills in Selenium automation, test design, and framework usage

# Tested Features:
## Manual Testing:
- Account Creation & Login (positive and negative scenarios)
- One-way, Round-trip  and Multi-City Flight Search
- Hotel Booking Functionality
- Validation Messages (invalid input, required fields)
- UI response (date pickers, filters)

## Automated Testing (Selenium + Java + TestNG)
- Valid login with correct credentials
- Invalid login with incorrect password
-  One-way, Round Trip and Multi-City flight search with valid data
- Hotel booking with valid inputs
- Form validation tests for invalid data
- Regression and smoke test tagging using TestNG groups

## Test Deliverables
- [Test Summary Report](https://docs.google.com/document/d/1kq0lUnEchO4in9Uo_E_VYhAiws3Qa4ItLbOt-vFYIJQ/edit?tab=t.lndx8pmf1fzt)
- [Test Plan Document](https://docs.google.com/document/d/1kq0lUnEchO4in9Uo_E_VYhAiws3Qa4ItLbOt-vFYIJQ/edit?tab=t.0)
- [Test Design Techniques](https://docs.google.com/spreadsheets/d/13YrHYP88K2DE1zkTQo0TKhn4Vp-No0_MXYGlOzjdRaQ/edit?gid=0#gid=0)
- [Test Cases](https://docs.google.com/spreadsheets/d/13YrHYP88K2DE1zkTQo0TKhn4Vp-No0_MXYGlOzjdRaQ/edit?gid=1820225942#gid=1820225942)
- [Bug Report](https://docs.google.com/spreadsheets/d/13YrHYP88K2DE1zkTQo0TKhn4Vp-No0_MXYGlOzjdRaQ/edit?gid=160664166#gid=160664166)

# 🎥 Automation Demo

Watch the full test automation demo 👉 [MakeMyTrip.AutomationDemo](https://www.loom.com/share/ccd4f37297d64e54b695be56cd5d44f1?sid=3659a3d0-a04c-48af-b9f5-a00047784a65)




# GETTING STARTED
Follow the steps below to set up and run the automation tests:

 ## 1. Clone the Repository
```bash
git clone https://github.com/tashatemmy/MakeMyTrip.git
cd MakeMyTrip
```
## 2. Open in Eclipse
Launch Eclipse IDE

Go to File → Import → Existing Maven Project

Select the cloned project folder

## 3. Install Dependencies
Maven will auto-download dependencies. If not, run:
```bash
mvn clean install
```
 ## 4. Configure & Run Tests
Ensure TestNG is installed in Eclipse

Run all tests via testng.xml
or
Right-click any test class → Run As → TestNG Test

## 5. View Test Results
Results appear in the Eclipse Console

Test reports are saved under the /test-output folder (HTML format)



