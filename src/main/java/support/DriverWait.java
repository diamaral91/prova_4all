package support;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DriverWait {

    private WebDriver driver;
    private WebDriverWait wait;

    public DriverWait(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
    }

    public WebElement waitElement(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement findElementInList(By by, String value){
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        for(WebElement element : elements) {
            if(element.getText().equalsIgnoreCase(value)) {
                return element;
            }
        }
        ExtentTestManager.getTest().log(LogStatus.FAIL, value + "nao encontrado!");
        return null;
    }

    public WebElement findElementByPosition(By by, int position){
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        return elements.get(position);
    }

    public List<WebElement> waitElements(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
}
