package Rokia;
import java.time.LocalDate;
public class Main
{
	
public static void checkout (Customer customer, Cart cart)
{
	if (cart.isEmpty())
		throw new RuntimeException ("Cart is Empty");
	
	double subTotal = cart.getSubTotal();
	double shipping = cart.getShippableItems().isEmpty() ? 0 : 30;
	double total = subTotal + shipping;
	
	if (!customer.affordable(total))
	{
		throw new RuntimeException("Insufficient Balance");
	}
	
	for (cartItem item : cart.getItems())
	{
        if (item.product.isExpired()) 
        {
            throw new RuntimeException(item.product.getName() + " is expired!");
        }
	}
	for (cartItem item : cart.getItems())
	{
        item.product.reduceQuantity(item.quantity);
    }
    customer.reduceBalance(total);

    // Ship
    Shipping.shipItems(cart.getShippableItems());

    // Print receipt
    System.out.println("\n** Checkout receipt **");
    for (cartItem item : cart.getItems())
    {
        System.out.printf("%dx %s\t%.0f\n", item.quantity, item.product.getName(), item.getPrice());
    }
    System.out.println("----------------------");
    System.out.printf("Subtotal\t%.0f\n", subTotal);
    System.out.printf("Shipping\t%.0f\n", shipping);
    System.out.printf("Amount\t\t%.0f\n", total);
    System.out.printf("Remaining Balance\t%.0f\n", customer.getBalance());
}


public static void main(String[] args) throws Exception
{
	Customer customer = new Customer("Ali", 500);

    ExpirableProduct cheese = new ExpirableProduct("Cheese", 100, 5, LocalDate.of(2025, 12, 1), true, 0.2);
    ExpirableProduct biscuits = new ExpirableProduct("Biscuits", 150, 2, LocalDate.of(2026, 1, 1), true, 0.7);
    NonShippableProduct scratchCard = new NonShippableProduct("ScratchCard", 50, 10);

    Cart cart = new Cart();
    cart.addToCart(cheese, 2);
    cart.addToCart(biscuits, 1);
    cart.addToCart(scratchCard, 1);
    
    checkout(customer, cart);
}
}
