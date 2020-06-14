package pages.landing;

public class LandingPage   {

	private LandingController step;
	private LandingVerifyController check;
	
	public LandingController step()
	{
		return step;
	}
	public LandingVerifyController check()
	{
		return check;
	}
	private LandingPage()
	{
		
	}
	private LandingPage(LandingController step, LandingVerifyController check)
	{
		this.step=step;
		this.check=check;
	}
	public static LandingPage getLandingPage()
	{
		return new LandingPage(new LandingController() , new LandingVerifyController());
	}


}
