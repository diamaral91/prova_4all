package pages;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;
import support.DriverWait;
import support.ExtentTestManager;

import java.util.List;

public class HomePage {

    private DriverWait wait;

    public HomePage(WebDriver driver) {
        wait = new DriverWait(driver);
    }

    public HomePage clickCategory(){
        wait.waitElement(selecioneCategoria).click();
        return this;
    }

    public HomePage selectCategory(String category){
        wait.findElementInList(categorias, category).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "categoria: " + category);
        return this;
    }

    public HomePage clickAllProducts(){
        List<WebElement> elements = wait.waitElements(adicionarAoCarrinho);
        for(WebElement element : elements) {
            element.click();
        }
        ExtentTestManager.getTest().log(LogStatus.INFO, "adicionar todos os produtos");
        return this;
    }

    public HomePage clickShoppingCart(){
        wait.waitElement(carrinho).click();
        ExtentTestManager.getTest().log(LogStatus.INFO, "carrinho de compras");
        return this;
    }

    public HomePage clickAddProduct(String produto) {
        List<WebElement> elements = wait.waitElements(nomeProduto);
        for(int count=0; count < elements.size(); count++) {
            if(elements.get(count).getText().equalsIgnoreCase(produto)) {
                wait.findElementByPosition(adicionarAoCarrinho, count).click();
                break;
            }
        }
        ExtentTestManager.getTest().log(LogStatus.INFO, "adicionar produto: " + produto);
        return this;
    }

    By selecioneCategoria = By.id("open-categories-btn");
    By categorias = By.xpath("//li[contains(@id,'category')]");
    By carrinho = By.id("cart-btn");
    By nomeProduto = By.xpath("//h1[contains(@data-id,'name')]");
    By adicionarAoCarrinho = By.xpath("//button[contains(@id,'add-product')]");

}
