package ro.ase.acs.models;

import java.util.HashMap;

public class EnGrosProduct extends Product {
    private float discount;
    private static HashMap<String, EnGrosProduct> productsInStock = new HashMap<>();

    public EnGrosProduct(String name, float price, int quantity) {
        super(name, price, quantity);

        if (quantity < 10) {
            discount = 0f;
        }
        if (quantity >= 10 && quantity < 20) {
            discount = 0.05f;
        }
        if (quantity >= 20) {
            discount = 0.1f;
        }
    }

    public EnGrosProduct(EnGrosProduct e) {
        super(e.getName(), e.getPrice(), e.getQuantity());
        this.discount = e.discount;
    }

    @Override
    public float getDiscount() {

        return this.price * this.discount;
    }

    @Override
    public EnGrosProduct clone() {
        return new EnGrosProduct(this);
    }

    @Override
    public String toString() {

        return "> " + this.getName() + " " + this.getPrice() + " " +
                (int) (discount * 100) + "% " +
                this.getQuantity() * this.getPrice()
                + " " + (this.price * this.quantity - getDiscount() * quantity);
    }

    public static void addProduct(EnGrosProduct e) {
        String key = e.getName() + "#" + e.getPrice();

        if (productsInStock.containsKey(key)) {

            EnGrosProduct existingProduct = productsInStock.get(key);

            int updateQuantity = existingProduct.getQuantity() + e.getQuantity();

            EnGrosProduct updateProduct =
                    new EnGrosProduct(existingProduct.getName(), existingProduct.getPrice(),
                            updateQuantity);

            productsInStock.put(key, updateProduct);
        } else {
            productsInStock.put(key, e.clone());
        }
    }

    ;

    public static String printStock() {
        String result = "";
        float total = 0;

        for (EnGrosProduct p : productsInStock.values()) {
            result += p.toString() + "\n";
            total += p.getPrice() * p.getQuantity();
        }
        result += "\nTotal value of the stock without discount: " + total;

        return result;
    }

    ;
//    10. Use a Java Collection, at your choice, to do the shop's stock management
//    Add the following two static methods in the EnGrosProduct class:
//            - void addProduct(EnGrosProduct)
// 	- String printStock()
//    The stock will not contain duplicates. Example:
//    If I will add the following products to the stock:
//            - name: Flour, price 16, quantity 30
//            - name: Sugar, price 9, quantity 16
//            - name: Flour, price 16, quantity 20
//
//    The printStock method should return the following string (not necessarily in this order):
//            "> Flour 16.0 50 10% 800.0 720.0
//            > Sugar 9.0 16 5% 144.0 136.8
//
//    Total value of the stock without discount: 944.0"
//
//    because the two products had the same name and price,
//    they were considered a single product and the quantities were summed up
}
