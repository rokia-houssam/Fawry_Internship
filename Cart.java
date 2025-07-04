package Rokia;
import java.util.*;

public class Cart {
    private List<cartItem> CartItems = new ArrayList<>();
  
public boolean isEmpty() 
{
	return CartItems.isEmpty();
}

public void addToCart(Products product, int quantity) throws Exception
{
	if (product.isAvailable(quantity))
			{
		     CartItems.add(new cartItem(product,quantity));
			}
	else
	{
      throw new Exception ("Quantity Exceeds the Amount in Stock")	;	
	}
}

public List<cartItem> getItems()
{
	return CartItems;
}

public double getSubTotal()
{
	double total = 0;
	for(cartItem item : CartItems)
	{
		total+=item.getPrice();
	}
	return total;
}

public List<Shippable> getShippableItems()
{
	List<Shippable> shippableItems = new ArrayList<>();
	for(cartItem item : CartItems) 
	{
		if(item.product.ShippingRequired() )
		{
			for(int i = 0; i< item.quantity; i++)
			{
				shippableItems.add((Shippable) item.product);
			}
		}
	}
	return shippableItems;
}

}
