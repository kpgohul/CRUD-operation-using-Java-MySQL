import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        outer:
        while(true)
        {
            System.out.println("---------------");
            System.out.println("1.Display");
            System.out.println("2.Insert");
            System.out.println("3.delate");
            System.out.println("4.search");
            System.out.println("5.exit");
            System.out.println("-----------");
            System.out.println("Enter your choice");
            int a=s.nextInt();
            switch (a)
            {
                case 1:
                    Displayresult dr=new Displayresult();
                    dr.display();
                    break;
                case 2:
                    new AddRecord();
                    break;
                case 3:
                    new Delete();
                    break;
                case 4:
                    new SearchStudent();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice!!!!!");

            }
        }
        }
    }
