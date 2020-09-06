package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CarrinhoComprasPage;
import pages.HomePage;
import support.TestBase;

public class DesafioDoisTest extends TestBase {

    @Test
    public void desafioDois(){
        HomePage home = new HomePage(driver);
        home.clickCategory()
                .selectCategory("Bebidas")
                .clickAllProducts()
                .clickCategory()
                .selectCategory("Todos")
                .clickAddProduct("Rissole médio")
                .clickShoppingCart();

        CarrinhoComprasPage carrinhoCompras = new CarrinhoComprasPage(driver);
        carrinhoCompras.clickAddProduct("Rissole médio", 8)
                .clickRemoveProduct("Rissole médio", 5);

        Assert.assertEquals("R$ 30,50", carrinhoCompras.getValue());

        carrinhoCompras.clickFinish();

        Assert.assertEquals("Pedido realizado com sucesso!", carrinhoCompras.getMessage());
    }
}
