package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CarrinhoComprasPage;
import pages.HomePage;
import support.TestBase;

public class DesafioUmTest extends TestBase {

    @Test
    public void desafioUm(){
        HomePage home = new HomePage(driver);
        home.clickCategory()
                .selectCategory("Doces")
                .clickAddProduct("Brigadeiro")
                .clickAddProduct("Alfajor de chocolate")
                .clickCategory().selectCategory("Todos")
                .clickShoppingCart();

        CarrinhoComprasPage carrinhoCompras = new CarrinhoComprasPage(driver);
        carrinhoCompras.clickAddProduct("Brigadeiro", 3).clickFinish();

        Assert.assertEquals("Pedido realizado com sucesso!", carrinhoCompras.getMessage());
    }
}
