package Rokia;

public abstract class Products 
{
     protected String name;
     protected double price;
     protected int quantity;
     
public Products (String name, double price, int quantity) 
{
	 this.name= name;
	 this.price= price;
	 this.quantity= quantity;
}

public String getName()
{
	return name;
}

public double getPrice()
{
	return price;
}

public double getQuantity()
{
	return quantity;
}

public void reduceQuantity(int q) 
{
   this.quantity-=q;	
}

public boolean isAvailable(int wantedQuantity)
{
	return wantedQuantity <= quantity;
}

public abstract boolean isExpired();
public abstract boolean ShippingRequired();

}
