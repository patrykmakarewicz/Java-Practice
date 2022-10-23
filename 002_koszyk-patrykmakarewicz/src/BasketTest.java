import org.junit.Test;
import static org.junit.Assert.assertEquals;



public class BasketTest {
    @Test
    public void testSort(){
        Product product1 = new Product("Code32", "Bbb", 10);
        Product product2 = new Product("Code32", "Name22", 20);
        Product product3 = new Product("Code4231", "Aaa", 10);
        Basket basket = new Basket(product1, product2, product3);
        assertEquals("Name22", basket.basket[0].name);
        assertEquals("Aaa", basket.basket[1].name);
        assertEquals("Bbb", basket.basket[2].name);
    }

    @Test
    public void testBasket(){
        Product product1 = new Product("Code", "Name", 10);
        Product product2 = new Product("Code2", "Name3", 20);
        Basket basket = new Basket(product1, product2);
        assertEquals(3, basket.basket.length);
        assertEquals(30, basket.price, 0);
    }

    @Test
    public void testCheckDiscountsMoreThan200(){
        Product product = new Product("Code", "Name", 250);
        Basket basket = new Basket(product);
        basket.checkDiscounts();
        assertEquals("Kubek firmowy", basket.basket[1].name);
    }

    @Test
    public void testCheckDiscountsMoreThan300(){
        Product product = new Product("Code", "Name", 400);
        Basket basket = new Basket(product);
        basket.checkDiscounts();
        assertEquals("Kubek firmowy", basket.basket[1].name);
        assertEquals(380, basket.price, 0);
    }

    @Test
    public void testCheckDiscountsTwoProducts(){
        Product product1 = new Product("Code12", "Name43", 30);
        Product product2 = new Product("Code32", "Name22", 20);
        Product product3 = new Product("Code4231", "Name12", 10);
        Basket basket = new Basket(product1, product2, product3);
        basket.checkDiscounts();
        assertEquals(50, basket.price, 0);
    }

    @Test
    public void testCheckDiscounts(){
        Product product1 = new Product("Code12", "Name43", 300);
        Product product2 = new Product("Code32", "Name22", 200);
        Product product3 = new Product("Code4231", "Name12", 100);
        Basket basket = new Basket(product1, product2, product3);
        basket.checkDiscounts();
        assertEquals("Kubek firmowy", basket.basket[3].name);
    }

    @Test
    public void testUseDiscountCoupon(){
        Product product = new Product("Code", "Name", 100);
        Basket basket = new Basket(product);
        basket.useDiscountCoupon(0.3, "Code");
        assertEquals(70, basket.basket[0].discountPrice, 0);
        assertEquals(70, basket.price, 0);

    }

    @Test
    public void testFindCheapest(){
        Product product1 = new Product("Code12", "Name43", 300);
        Product product2 = new Product("Code32", "Name22", 200);
        Basket basket = new Basket(product1, product2);
        assertEquals(product2, basket.findCheapest());
    }

    @Test
    public void testFindMostExpensive(){
        Product product1 = new Product("Code12", "Name43", 300);
        Product product2 = new Product("Code32", "Name22", 200);
        Basket basket = new Basket(product1, product2);
        assertEquals(product1, basket.findMostExpensive());
    }

    @Test
    public void testFindNCheapest(){
        Product product1 = new Product("Code12", "Name43", 10);
        Product product2 = new Product("Code32", "Name22", 200);
        Product product3 = new Product("Code32", "Name22", 20);
        Product product4 = new Product("Code32", "Name22", 300);
        Basket basket = new Basket(product1, product2, product3, product4);
        assertEquals(2, basket.findNCheapest(2).length);
        assertEquals(product1, basket.findNCheapest(2)[0]);
        assertEquals(product3, basket.findNCheapest(2)[1]);
    }

    @Test
    public void testFindNMostExpensive(){
        Product product1 = new Product("Code12", "Name43", 10);
        Product product2 = new Product("Code32", "Name22", 200);
        Product product3 = new Product("Code32", "Name22", 20);
        Product product4 = new Product("Code32", "Name22", 300);
        Basket basket = new Basket(product1, product2, product3, product4);
        assertEquals(2, basket.findNMostExpensive(2).length);
        assertEquals(product4, basket.findNMostExpensive(2)[0]);
        assertEquals(product2, basket.findNMostExpensive(2)[1]);
    }



}





