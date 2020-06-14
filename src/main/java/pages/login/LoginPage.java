package pages.login;

public class LoginPage   {

	private LoginController step;
	private LoginVerifyController check;
	
	public LoginController step()
	{
		return step;
	}
	public LoginVerifyController check()
	{
		return check;
	}
	private LoginPage()
	{
		
	}
	private LoginPage(LoginController step, LoginVerifyController check)
	{
		this.step=step;
		this.check=check;
	}
	public static LoginPage getLoginPage()
	{
		return new LoginPage(new LoginController() , new LoginVerifyController());
	}


}
