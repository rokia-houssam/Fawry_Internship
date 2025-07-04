package Rokia;

public class ShippableProduct extends Products 
{
	private double weight;
	
 public ShippableProduct(String name, double price, int quantity, double weight)
 {
	 super(name, price, quantity);
	 this.weight = weight;
 }

@Override
public boolean isExpired()
{
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean ShippingRequired()
{
	// TODO Auto-generated method stub
	return true;
}
public double getWeight()
{
	return weight;
}

}
