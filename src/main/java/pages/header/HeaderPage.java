package pages.header;


public class HeaderPage {
	private HeaderController step;
	private HeaderVerifyController check;
	
	public HeaderController step()
	{
		return step;
	}
	public HeaderVerifyController check()
	{
		return check;
	}
	private HeaderPage()
	{
		
	}
	private HeaderPage(HeaderController step, HeaderVerifyController check)
	{
		this.step=step;
		this.check=check;
	}
	public static HeaderPage getHeaderPage()
	{
		return new HeaderPage(new HeaderController() , new HeaderVerifyController());
	}
	
}
