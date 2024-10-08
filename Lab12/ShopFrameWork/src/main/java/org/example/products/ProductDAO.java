package org.example.products;

import java.util.HashMap;
import java.util.Map;

public class ProductDAO {
    private Map<Integer, Product> products = new HashMap<Integer, Product>();

    public void save(Product product){
        products.put(product.getProductNumber(), product);
    }

    public Product find(int productNumber){
        return products.get(productNumber);
    }

    public void remove(int productNumber){
        products.remove(productNumber);
    }
}
