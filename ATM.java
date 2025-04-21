package tar55;

public class ATM {
	private int Dposite;
	private int Attraction;
	private int Balance;
	

	public int getDposite() {
		return Dposite;
	}

	public int getAttraction() {
		return Attraction;
	}
	public int getBalance() {
		return Balance;
	}
	
	public void setDposite(int d) {
		Dposite = d;

	}
	public void setAttraction(int a) {
		Attraction = a;
		if(Attraction > 2000)
			System.out.println("this is the maximal Attraction");
		else
			System.out.println("you can attract money");
	}
	public void setBalance(int b) {
		Balance = b;
		if(Balance < 0)
			System.out.println("you dont have money in your account");
		else
			System.out.println("you have a money in your account");
	}
	
	
	public void show() {
		System.out.println(Dposite + "Dposite");
		System.out.println(Attraction + "Attraction");
		System.out.println(Balance + "Balance");
		
	}
}
