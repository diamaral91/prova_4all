package pages;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.DriverWait;
import support.ExtentTestManager;

import java.util.List;

public class HomePage {

    private DriverWait wait;

    public HomePage(WebDriver driver) {
        wait = new DriverWait(driver);
        PageFactory.initElements(driver, this);
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

    @FindBy(id = "open-categories-btn")
    private WebElement selecioneCategoria;

    @FindBy(xpath = "//li[contains(@id,'category')]")
    private List<WebElement> categorias;

    @FindBy(id = "cart-btn")
    private WebElement carrinho;

    @FindBy(xpath = "//h1[contains(@data-id,'name')]")
    private List<WebElement> nomeProduto;

    @FindBy(xpath = "//button[contains(@id,'add-product')]")
    private List<WebElement> adicionarAoCarrinho;
}
