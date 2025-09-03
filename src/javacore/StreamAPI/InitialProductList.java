package javacore.StreamAPI;

import java.math.BigDecimal;
import java.util.ArrayList;

public class InitialProductList {
    public ArrayList<Product> getProductList() {
        ArrayList<Product> products = new ArrayList<>();
        Product bread = new Product(1, "bread", "food", new BigDecimal(122));
        Product milk = new Product(2, "milk", "food", new BigDecimal(300));
        Product eggs = new Product(3, "eggs", "food", new BigDecimal(678));
        Product meat = new Product(4, "meat", "food", new BigDecimal(77));
        Product sausage = new Product(5, "sausage", "food", new BigDecimal(49));

        Product pyramid = new Product(6, "pyramid", "toy", new BigDecimal(50));
        Product carToy = new Product(7, "carToy", "toy", new BigDecimal(100));
        Product markers = new Product(8, "markers", "toy", new BigDecimal(600));
        Product doll = new Product(9, "doll", "toy", new BigDecimal(400));
        Product electronicpiano = new Product(10, "electronicpiano", "toy", new BigDecimal(170));

        Product alphabet = new Product(11, "alphabet", "books", new BigDecimal(200));
        Product catInBoots = new Product(12, "cat in boots", "books", new BigDecimal(300));
        Product funnyStories = new Product(13, "funnyStories", "books", new BigDecimal(40));
        Product english = new Product(14, "english", "books", new BigDecimal(300));
        Product comics = new Product(15, "comics", "books", new BigDecimal(166));

        Product kidBoots = new Product(16, "kidBoots", "Children's products", new BigDecimal(200));
        Product kidShorts = new Product(17, "kidShorts", "Children's products", new BigDecimal(122));
        Product kidShirt = new Product(18, "kidShirt", "Children's products", new BigDecimal(234));
        Product kidSunglasses = new Product(19, "kidSunglasses", "Children's products", new BigDecimal(1222));
        Product kidBackPack = new Product(20, "kidBackPack", "Children's products", new BigDecimal(270));

        products.add(bread);
        products.add(milk);
        products.add(eggs);
        products.add(meat);
        products.add(sausage);

        products.add(pyramid);
        products.add(carToy);
        products.add(markers);
        products.add(doll);
        products.add(electronicpiano);

        products.add(alphabet);
        products.add(catInBoots);
        products.add(funnyStories);
        products.add(english);
        products.add(comics);

        products.add(kidBoots);
        products.add(kidShorts);
        products.add(kidShirt);
        products.add(kidSunglasses);
        products.add(kidBackPack);

        return products;
    }
}
