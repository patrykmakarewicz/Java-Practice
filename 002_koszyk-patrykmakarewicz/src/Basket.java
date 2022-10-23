import java.util.*;
import java.util.Comparator;

public class Basket {
    Product[] basket;
    double price;

    Basket(Product... products){
        this.basket = new Product[products.length+1];
        for (Product product : products){
            this.basket[Arrays.asList(products).indexOf(product)] = product;
            this.price += product.discountPrice;
        }
        Product[] basketCopy = Arrays.copyOfRange(this.basket, 0, this.basket.length - 1);
        Arrays.sort(basketCopy, Comparator.comparing(Product::getPrice).reversed().thenComparing(Product::getName));

        for (int i = 0; i < basketCopy.length; i++){
            this.basket[i] = basketCopy[i];
        }
    }

    public void checkDiscounts(){
        if (this.price > 200){
            this.basket[this.basket.length - 1] = new Product("CXZ12", "Kubek firmowy", 20);
            this.basket[this.basket.length - 1].discountPrice = 0;
        }
        if (this.basket.length == 4){
            Product theCheapestProduct = this.basket[0];
            for (Product product : Arrays.copyOfRange(this.basket, 0, this.basket.length - 1)){
                if (product.price < theCheapestProduct.price){
                    theCheapestProduct = product;
                }
            }
            this.basket[Arrays.asList(this.basket).indexOf(theCheapestProduct)].discountPrice = 0;
            this.price -= theCheapestProduct.price;
        }
        if (this.price > 300) {
            this.price = this.price * 0.95;
        }
    }

    public void useDiscountCoupon(double percentage, String code){
        for (Product product : this.basket){
            if (product.code.equals(code)){
                product.discountPrice = product.discountPrice * (1 - percentage);
                this.price = this.price - (product.price - product.discountPrice);
                break;
            }
        }
    }

    public Product findCheapest(){
        Product theCheapestProduct = this.basket[0];
        for (Product product : Arrays.copyOfRange(this.basket, 0, this.basket.length - 1)){
            if (product.price < theCheapestProduct.price){
                theCheapestProduct = product;
            }
        }
        return theCheapestProduct;
    }

    public Product findMostExpensive(){
        Product theMostExpensiveProduct = this.basket[0];
        for (Product product : Arrays.copyOfRange(this.basket, 0, this.basket.length - 1)){
            if (product.price > theMostExpensiveProduct.price){
                theMostExpensiveProduct = product;
            }
        }
        return theMostExpensiveProduct;
    }

    public Product[] findNCheapest(int n){
        Product[] cheapestProducts = new Product[n];
        List<Product> productList = new LinkedList<Product>(Arrays.asList(Arrays.copyOfRange(this.basket, 0, this.basket.length - 1)));
        for (int i = 0; i < n; i++){
            Product theCheapestProduct = productList.get(0);
            for (Product product : productList){
                if (product.price < theCheapestProduct.price){
                    theCheapestProduct = product;
                }
            }
            cheapestProducts[i] = theCheapestProduct;
            productList.remove(theCheapestProduct);
        }
        return cheapestProducts;
    }

    public Product[] findNMostExpensive(int n){
        Product[] mostExpensiveProducts = new Product[n];
        List<Product> productList = new LinkedList<Product>(Arrays.asList(Arrays.copyOfRange(this.basket, 0, this.basket.length - 1)));
        for (int i = 0; i < n; i++){
            Product mostExpensiveProduct = productList.get(0);
            for (Product product : productList){
                if (product.price > mostExpensiveProduct.price){
                    mostExpensiveProduct = product;
                }
            }
            mostExpensiveProducts[i] = mostExpensiveProduct;
            productList.remove(mostExpensiveProduct);
        }
        return mostExpensiveProducts;
    }
}
