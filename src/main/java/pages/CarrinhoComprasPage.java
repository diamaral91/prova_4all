package pages;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.DriverWait;
import support.ExtentTestManager;

import java.util.List;

public class CarrinhoComprasPage {

    private DriverWait wait;

    public CarrinhoComprasPage(WebDriver driver){
        wait = new DriverWait(driver);
        PageFactory.initElements(driver, this);
    }

    public CarrinhoComprasPage clickAddProduct(String product, int quantidade){
        List<WebElement> elements = wait.waitElements(produtos);
        for(int count =0; count < elements.size(); count++) {
            if(elements.get(count).getText().equalsIgnoreCase(product)){
                for(int add=0; add < quantidade; add++) {
                    wait.findElementByPosition(adicionarProduto, count).click();
                }
                break;
            }
        }
        ExtentTestManager.getTest().log(LogStatus.INFO, "adicionar +" + quantidade + product);
        return this;
    }

    public CarrinhoComprasPage clickRemoveProduct(String product, int quantidade){
        List<WebElement> elements = wait.waitElements(produtos);
        for(int count =0; count < elements.size(); count++) {
            if(elements.get(count).getText().equalsIgnoreCase(product)){
                for(int add=0; add < quantidade; add++) {
                    wait.findElementByPosition(removeProduto, count).click();
                }
                break;
            }
        }
        ExtentTestManager.getTest().log(LogStatus.INFO, "remover +" + quantidade + product);
        return this;
    }

    public String getValue(){
        return wait.waitElement(valorTotal).getText();
    }

    public CarrinhoComprasPage clickFinish(){
        wait.waitElement(finalizarPedido).click();
        return this;
    }

    public String getMessage(){
        return wait.waitElement(menssagem).getText();
    }

    public CarrinhoComprasPage clickClose(){
        wait.waitElement(fechar).click();
        return this;
    }

    @FindBy(xpath = "//div[contains(@id,'name')]")
    private List<WebElement> produtos;

    @FindBy(xpath = "//div[contains(@id,'add-product')]")
    private List<WebElement> adicionarProduto;

    @FindBy(xpath = "//div[contains(@id,'remove-product')]")
    private List<WebElement> removeProduto;

    @FindBy(id = "price-total-checkout")
    private WebElement valorTotal;

    @FindBy(id = "finish-checkout-button")
    private WebElement finalizarPedido;

    @FindBy(css = "div[role=\"dialog\"] > div > h2")
    private WebElement menssagem;

    @FindBy(xpath = "//button[text()='Fechar']")
    private WebElement fechar;
}
