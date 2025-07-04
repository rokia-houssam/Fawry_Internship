package Rokia;

public class NonShippableProduct extends Products{
	
public NonShippableProduct(String name, double price, int quantity)
{
	super(name,price,quantity);
}

@Override
public boolean isExpired() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean ShippingRequired() {
	// TODO Auto-generated method stub
	return false;
}

}
