package pages;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.DriverWait;
import support.ExtentTestManager;

import java.util.List;

public class CarrinhoComprasPage {

    private DriverWait wait;

    public CarrinhoComprasPage(WebDriver driver){
        wait = new DriverWait(driver);
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
        ExtentTestManager.getTest().log(LogStatus.INFO, "adicionar " + product + " por " + quantidade + "x");
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
        ExtentTestManager.getTest().log(LogStatus.INFO, "adicionar " + product + " por " + quantidade + "x");
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

    By produtos = By.xpath("//div[contains(@id,'name')]");
    By adicionarProduto = By.xpath("//div[contains(@id,'add-product')]");
    By removeProduto = By.xpath("//div[contains(@id,'remove-product')]");
    By valorTotal = By.id("price-total-checkout");
    By finalizarPedido = By.id("finish-checkout-button");
    By menssagem = By.cssSelector("div[role=\"dialog\"] > div > h2");
    By fechar = By.xpath("//button[text()='Fechar']");
}
