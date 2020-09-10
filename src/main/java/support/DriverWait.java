package support;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DriverWait {

    private WebDriverWait wait;

    public DriverWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
    }

    public WebElement waitElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement findElementInList(List<WebElement> elementList, String value){
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        for(WebElement element : elements) {
            if(element.getText().equalsIgnoreCase(value)) {
                return element;
            }
        }
        ExtentTestManager.getTest().log(LogStatus.FAIL, value + "nao encontrado!");
        return null;
    }

    public WebElement findElementByPosition(List<WebElement> elementList, int position){
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        return elements.get(position);
    }

    public List<WebElement> waitElements(List<WebElement> elements) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}