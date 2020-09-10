package support;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.CarrinhoComprasPage;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;

    @Parameters("environment")
    @BeforeMethod
    public void beforeMethod(Method method, @Optional("") String environment) {
        driver = Browsers.setBrowser(environment);
        driver.get("https://shopcart-challenge.4all.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        ExtentTestManager.startTest(method.getName());
    }

    @AfterMethod
    protected void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
        } else {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
        }
        ExtentTestManager.getTest().log(LogStatus.INFO, ExtentTestManager.getTest()
                .addBase64ScreenShot(captureEvidence(driver)));

        new CarrinhoComprasPage(driver).clickClose();

        ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
        ExtentManager.getReporter().flush();

        driver.quit();
    }

    public static String captureEvidence(WebDriver driver){
        TakesScreenshot newScreen = (TakesScreenshot) driver;
        String scnShot = newScreen.getScreenshotAs(OutputType.BASE64);
        return "data:image/jpg;base64, " + scnShot ;
    }
}
