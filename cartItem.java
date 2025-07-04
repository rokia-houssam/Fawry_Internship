package Rokia;

public class cartItem {
    Products product;
    int quantity;
  
public cartItem(Products product, int quantity)
{
	this.product = product;
	this.quantity = quantity;
}

public double getPrice()
{
	return product.getPrice() * quantity;
}
}
