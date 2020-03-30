/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *
 * @author ua39472
 */
public class Product {
    private Integer id;
    private String name;
    private String category;
    private Double price;
    
    public Product(Integer id, String name, String category, Double price)
    {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
    
    @Override
    public String toString() {
	return id + " " + name + " " + category + " " + price;
    }
}
