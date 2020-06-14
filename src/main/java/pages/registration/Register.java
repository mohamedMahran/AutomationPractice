package pages.registration;

import java.io.IOException;

public class Register {
	private RegsitrationController step;
	private RegsitrationVerifyController check;
	
	public RegsitrationController step()
	{
		return step;
	}
	public RegsitrationVerifyController check()
	{
		return check;
	}
	private Register()
	{
		
	}
	private Register(RegsitrationController step, RegsitrationVerifyController check)
	{
		this.step=step;
		this.check=check;
	}
	public static Register getRegisterPage() throws IOException
	{
		return new Register(new RegsitrationController() , new RegsitrationVerifyController());
	}
	
}
