# CURA Healthcare Selenium Automation 🏥
Automated test cases for CURA Healthcare, a demo healthcare website. This repository demonstrates how I use the Selenium framework for end-to-end testing of the appointment booking functionality.

## Features Tested ✅
- User login functionality 
- Appointment booking process 
- Validation for appointment form fields 
- Behavior of Cancel and Confirm buttons during booking 

## Technologies Used 💻
- [Selenium](https://www.selenium.dev/): A framework for automating web browsers.
- Java: Programming language for writing test scripts.
- [JUnit](https://junit.org/): A testing framework for running tests.
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager): Manages WebDriver binaries for Selenium.
- [Cucumber](https://cucumber.io/): A tool for Behavior-Driven Development (BDD).

## Project Structure 📁
- `src/`: Contains the main source code, including the test scripts.
- `target/`: Contains the test execution reports, and including summaries.
- `pom.xml`: Maven configuration file for managing project dependencies and build lifecycle.
  
## How to Run 🚀
To run the tests in this project, follow these steps:

1. Clone this repository:
   ```bash
   git clone https://github.com/vidhapratiwi/cura-selenium-automation.git
   ```
2. Navigate to the project directory:
   ```bash
   cd cura-selenium-automation
   ```
3. Install dependencies and build the project:
   ```bash
   mvn install
   ```
4. Run the tests:
   ```bash
   mvn test
   ```

## Test Cases 📋
This project includes both manual and automated test cases:

- **Manual Test Cases**: Documented in a [Google Sheets file](https://docs.google.com/spreadsheets/d/1AaGihuBk0tsV_MR3iEds_hqclmyuJ69c6CpkOHkHI_s/edit?usp=sharing) to plan and track test coverage before automation.
- **Automated Test Cases**: The scripts for automated tests are stored in the `tests/` directory.

## Related Projects 🔗
This repository is part of a collection of projects designed to showcase my QA engineering skills such as:

- [CURA Healthcare Playwright Automation](https://github.com/vidhapratiwi/cura-playwright-automation.git): Automated tests for CURA Healthcare, focusing on appointment booking functionality.
- [SauceDemo Selenium Automation](https://github.com/vidhapratiwi/saucedemo-selenium-automation.git): Automated tests for SauceDemo using the Selenium framework.
- [SauceDemo Playwright Automation](https://github.com/vidhapratiwi/saucedemo-playwright-automation.git): Automated tests for SauceDemo using the Playwright framework.

For more related projects, visit my [QA Portfolio repository](https://github.com/vidhapratiwi/QA-Portfolio.git) 🗃

## Contributing 🤝
Contributions are welcome! If you have suggestions for improving the test scripts or expanding the test coverage, feel free to open an issue or submit a pull request.

## License 📝
This project is not licensed under any specific license. Please contact the author for permission before using or modifying the code.
