import java.util.Scanner;

public class summerHeltall {

	public static void main(String[] args) {
		Scanner tall= new Scanner(System.in);
		
		int nyttall, sum=0;
		while(true)
		{
			System.out.println("Skriv inn et positivt heltall: ");
			nyttall = tall.nextInt();
			if (nyttall>0)
			{
				sum +=nyttall;
			}
			else
			{
				break;
			}
		
		
		}
		System.out.println("Summen av alle tallene er: " + sum);
	}

}
