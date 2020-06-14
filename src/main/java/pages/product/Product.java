package pages.product;




public class Product {
	
	private ProductController step;
	private ProductVerifyController check;
	
	public ProductController step()
	{
		return step;
	}
	public ProductVerifyController check()
	{
		return check;
	}
	private Product()
	{
		
	}
	private Product(ProductController step, ProductVerifyController check)
	{
		this.step=step;
		this.check=check;
	}
	public static Product getProductPage()
	{
		return new Product(new ProductController() , new ProductVerifyController());
	}


}
