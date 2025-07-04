package Rokia;
import java.time.LocalDate;

public class ExpirableProduct extends Products implements Shippable
{
       private LocalDate expiryDate;
       private boolean shippable;
       private double weight;
       
public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate, boolean shippable, double weight)
{
	super(name, price,quantity);
	this.expiryDate = expiryDate;
	this.shippable = shippable;
	this.weight = weight;
}

@Override
public boolean isExpired() 
{
	if(LocalDate.now().isAfter(expiryDate))
	{
	      return true;
	}
	else 
	{
		return false;
	}
}

@Override
public boolean ShippingRequired() 
{
	// TODO Auto-generated method stub
	return shippable;
}


@Override
public String getName() {
    return name;
}

@Override
public double getWeight() {
    return weight;
}

}