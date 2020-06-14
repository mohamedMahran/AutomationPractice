package pages.order;

public class OrderPage {
	
	private OrderController step;
	private OrderVerifyController check;
	
	public OrderController step()
	{
		return step;
	}
	public OrderVerifyController check()
	{
		return check;
	}
	private OrderPage()
	{
		
	}
	private OrderPage(OrderController step, OrderVerifyController check)
	{
		this.step=step;
		this.check=check;
	}
	public static OrderPage getOrderPage()
	{
		return new OrderPage(new OrderController() , new OrderVerifyController());
	}
	
}
