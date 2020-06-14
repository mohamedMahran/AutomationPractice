package pages.menu;

public class MainMenu {
	private MainMenuController step;
	private MainMenuVerifyController check;
	
	public MainMenuController step()
	{
		return step;
	}
	public MainMenuVerifyController check()
	{
		return check;
	}
	private MainMenu()
	{
		
	}
	private MainMenu(MainMenuController step, MainMenuVerifyController check)
	{
		this.step=step;
		this.check=check;
	}
	public static MainMenu getMainMenuPage()
	{
		return new MainMenu(new MainMenuController() , new MainMenuVerifyController());
	}
}
