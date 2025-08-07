package makemytriptests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.net.MalformedURLException;
import java.net.URI;
import java.lang.reflect.Method;


public class Base {
	

	    protected WebDriver driver;
	    protected String browser;
	    protected String env;
	    protected String url;
	    
	    @BeforeMethod
	    @Parameters({"env", "browser", "os", "osVersion", "device", "realMobile"})
	    public void browserSetup(
	    		@Optional("local") String env,
	    		@Optional("chrome") String browser,
                @Optional("Windows") String os,
                @Optional("11") String osVersion,
                @Optional("") String device,
                @Optional("false") String realMobile,
                Method method
                ) throws MalformedURLException {
	    	
	    	this.env = env;
	    	this.browser = browser;
	       
	        url = "https://makemytrip.global";

	        if (env.equalsIgnoreCase("useBrowserStack")) {
	        	// ✅ Create correct capabilities structure (REQUIRED by BrowserStack)
	            HashMap<String, Object> browserstackOptions = new HashMap<>();
	            browserstackOptions.put("osVersion", osVersion);
	            browserstackOptions.put("projectName", "MakeMyTrip QA");
	            browserstackOptions.put("idleTimeout", 180);  // in seconds
	            
	            String methodName = method.getName();
	            String className = method.getDeclaringClass().getSimpleName();
	            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	            String buildName = "Cross Platform Build - " + browser + " - " + className + " - " + timestamp;
	            String sessionName = "Test: " + method.getClass() + " - " + methodName + " - " + timestamp;
	            
	            

	            browserstackOptions.put("buildName", buildName);
	            browserstackOptions.put("sessionName", sessionName);

	            
	         // 🔍 Enable logs for better debugging
	            browserstackOptions.put("debug", true); // Visual logs
	            browserstackOptions.put("consoleLogs", "info"); // Console logs: info|debug|errors
	            browserstackOptions.put("networkLogs", true); // Capture network logs


	            if (!device.isEmpty()) {
	                browserstackOptions.put("deviceName", device);
	                browserstackOptions.put("realMobile", Boolean.parseBoolean(realMobile));
	            }else {
	            	browserstackOptions.put("os", os);
	            }
	            
	            DesiredCapabilities caps = new DesiredCapabilities();
	            caps.setCapability("browserName", browser);
	            caps.setCapability("bstack:options", browserstackOptions); // ✅ Must be in 'bstack:options'
	            
	            String username = "temiodey_QnwJWA";
	            String accessKey = "uFS2paa7xTSUzM7fq2A5";

	            URI uri = URI.create("https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub");
	            URL browserstackUrl = uri.toURL();

	            driver = new RemoteWebDriver(browserstackUrl, caps);
	            
	        } else if (env.equalsIgnoreCase("local")){
	            // --- Local Setup ---
	            if (browser.equalsIgnoreCase("chrome")) {
	                WebDriverManager.chromedriver().setup();
	                driver = new ChromeDriver();
	            } else if (browser.equalsIgnoreCase("firefox")) {
	                WebDriverManager.firefoxdriver().setup();
	                driver = new FirefoxDriver();
	            } else if (browser.equalsIgnoreCase("safari")) {
	                WebDriverManager.safaridriver().setup();
	                driver = new SafariDriver();
	            }
	            driver.manage().window().maximize();
	        }else {
	        	System.out.println("Select env local or browserstack");
	        }
	        System.out.println("Running tests in environment: " + env);

	        driver.get(url);
	    }

	   
}