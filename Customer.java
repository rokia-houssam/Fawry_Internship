package Rokia;

public class Customer {
       String name;
       double balance;

public Customer(String name, double balance)
{
	this.name = name;
	this.balance = balance;
}
public String getName()
{
	return name;
}

public double getBalance()
{
	return balance;
}

public boolean affordable(double total)
{
	if(total<= balance) 
	{
		return true;
	}
	else 
	{
		return false;
	}
}

public double reduceBalance(double amount)
{
	return balance-=amount;
}

}
