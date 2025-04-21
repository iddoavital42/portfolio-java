package tar55;
import java.util.Scanner;
public class ATMProgram {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ATM a1 = new ATM();
		int balance = 20000,Deposite,Attraction,num;
		while(true) {
			System.out.println("welcome to ATM machine");
			System.out.println("select your option");
			System.out.println("1. Attraction");
			System.out.println("2.Dposite");
			System.out.println("3.Balance");
			System.out.println("4.Exit");
			num = s.nextInt();
			switch(num) {
			
			case 1:
				System.out.println("enter amount to Attract");
				Attraction = s.nextInt();
				if(balance>= Attraction) {
					balance = balance-Attraction;
					System.out.println("balance amount is: "+ Attraction);
					System.out.println("please collect the money");

				}
				else {
				System.out.println("you dont have enough of money in your account");
				}
				System.out.println(" ");
				break;
			case 2:
				System.out.println("Enter amount to Deposite");
				Deposite = s.nextInt();
				balance = balance+Deposite;
				System.out.println("balance amount is" + balance);
				System.out.println("money has been Deposited succssfully");
				System.out.println(" ");
				break;
			case 3:
				System.out.println("balance in your account is:" + balance);
				System.out.println(" ");
				break;
			case 4:
				System.exit(0);
				break;
				}
			}
		}
	}


