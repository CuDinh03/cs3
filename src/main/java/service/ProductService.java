package service;

import dao.CRUD_Product;
import model.Product;

import java.util.List;

public class ProductService implements IService<Product> {
    static List<Product> products = CRUD_Product.getAll();



    @Override
    public List<Product> showAll() {
        for (Product p : products) {
                p.getNameProduct();
                p.getImg();
                p.getPrice();
        }
        return products;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public boolean deleteById(int id, Product product) {
        return false;
    }

    @Override
    public boolean editById(int id, Product product) {
        return false;
    }

    public static void create(Product product) {
        products.add(product);
        CRUD_Product.save(product);
    }

}
