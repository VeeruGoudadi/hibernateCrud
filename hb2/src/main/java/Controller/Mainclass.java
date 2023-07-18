package Controller;

import java.util.Scanner;

import dao.Demo;

public class Mainclass {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		Demo d=new Demo();
		while (flag) 
		{
			System.out.println("1.Add\n2.Fetch\n3.Update\n4.Remove\n5.FetchAll\n6.Delete hAll\n7.Exit");
			switch (sc.nextInt()) {
			case 1:
			{
				System.out.println("Enter the id");
				int id=sc.nextInt();
				System.out.println("Enter the name");
				String name=sc.next();
				System.out.println("Enter the city");
				String city=sc.next();
				d.addStd(id, name, city);
			}break;
			case 2:
			{
				System.out.println("Enter the id");
				int id=sc.nextInt();
				d.fetchStd(id);
			}break;
			
			case 3:
			{
				System.out.println("eneter the id");
				int id=sc.nextInt();
				System.out.println("Enter the name");
				String name=sc.next();
				d.updateStd(id, name);
			}break;
			
			case 4:
			{
				System.out.println("Enter the id");
				int id=sc.nextInt();
				d.removeStd(id);
			}break;
			
			case 5:
			{
				d.fetchAll();
			}break;
			
			case 6:
			{
				d.removeAll();
				
			}break;
			
			case 7:
			{
				flag=false;
				System.out.println("Thank you");
			}break;

			default:
			{
				System.out.println("Enter valid option");
			}
				break;
			}	
		}
	}
}
