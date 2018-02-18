/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week3.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

/**
 *
 * @author ryan
 */
public class ProductService {


    private List<Product> products = new ArrayList<Product>();
  

//    private List<Product> convertProductDbToProducts(String filename) throws FileNotFoundException, IOException {
//        InputStream is = new FileInputStream(filename);
//        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
//        String line = buf.readLine();
////        StringBuilder sb = new StringBuilder();
//        List<Product> allProductsFromFile = new ArrayList<Product>();
//
//        while (line != null) {
////            sb.append(line).append("\n");
////            line = buf.readLine();
//                
//                String[] productData = line.split("-");
//                String id = productData[0];
//                String name = productData[1];
//                Double price = Double.parseDouble(productData[2]);
//                String description = productData[3];
//                String imageUrl = productData[4];
//                Product currentProduct = new Product(id,name,price,description,imageUrl);
//                allProductsFromFile.add(currentProduct);
//
//        }
//        return allProductsFromFile;
//
//    }

    public Product getID(String id) {
        Product theProduct = null;
        for (Product product : products) {
            if (product.getId().equals(id)) {
                theProduct = product;
            }
        }
        return theProduct;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> findProduct(String search) {
        search = search.toLowerCase();
        List<Product> theProducts = new ArrayList<Product>();
        for (Product product : products) {
            if (product.getId().startsWith(search)) {
                theProducts.add(product);
            }
        }
        return theProducts;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ProductService(String productDatabaseFilename) throws IOException {
        List<Product> allProducts = processDB(productDatabaseFilename);
        setProducts(allProducts);

    }

    private List<Product> processDB(String filename) throws FileNotFoundException, IOException {
                List<Product> allProductsFromFile = new ArrayList<Product>();

//        File dataFile = new File("/web/" + filename + ".txt");
        File dataFile = new File(filename);
        BufferedReader br = null;
        // check if file exists, and if so, loop through and read each line of text
        

            FileInputStream fstream = new FileInputStream(dataFile);
            br = new BufferedReader(new InputStreamReader(fstream));

            String line;

            //Read File Line By Line
            while ((line = br.readLine()) != null) {
                String currentLine = line;
                String[] productData = currentLine.split("#@#");
                String id = productData[0];
                String name = productData[1];
                Double price = Double.parseDouble(productData[2]);
                String description = productData[3];
                String imageUrl = productData[4];
                Product currentProduct = new Product(id,name,price,description,imageUrl);
                allProductsFromFile.add(currentProduct);
                
            


}
            return allProductsFromFile;
    }
    

}
