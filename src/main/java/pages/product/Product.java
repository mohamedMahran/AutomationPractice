package pages.product;

import java.io.IOException;

public class Product {
	/*Method Chaining: calling a method returns some object on which further methods can be called.
	 	Static Factory Methods and Imports
	 	Named parameters - can be simulated in Java using static factory methods.*/
	
	private ProductController step;
	private ProductVerifyController check;
	

	private Product()
	{
		
	}
	private Product(ProductController step, ProductVerifyController check)
	{
		this.step=step;
		this.check=check;
	}
	
	public ProductController step()
	{
		return step;
	}
	public ProductVerifyController check()
	{
		return check;
	}
	// 	Static Factory Methods and Imports
	public static Product getProductPage() throws IOException
	{
		return new Product(new ProductController() , new ProductVerifyController());
	}


}
