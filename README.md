# CucumberStarter
Starting with Cucumber Testing Framework with multiple browser

1. Put code to detech browser into Before hook
```
@Before
	public void BeforeScenario() {
		String webdriver = System.getProperty("browser", "firefox");
		switch (webdriver) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\\\Selenium\\\\Driver\\\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
            throw new RuntimeException("Unsupported webdriver: " + webdriver);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
  ```
  2. Start Cmd execute the Maven command
  
  For Chrome:
    mvn test -Dbrowser=chrome
    
   Fore Firefox: 
    mvn test -Dbrowser=firefox
