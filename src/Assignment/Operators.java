import java.util.*;
public class Operators {
    static void Sum(){
        Scanner sc = new Scanner(System.in);
        int i,n;
        float[] num = new float[50];
        float sum=0;
        System.out.print("Enter Number You Want to Sum : ");
        n=sc.nextInt();
        for(i=0;i<n;i++){
            System.out.print("Enter Value Number"+(i+1)+" : ");
            num[i]=sc.nextFloat();
            sum+=num[i];
        }
        System.out.println("Sum = "+sum);
    }
    static void Subtract(){
        Scanner sc = new Scanner(System.in);
        int i,n;
        float[] num = new float[50];
        float sub=0;
        System.out.print("Enter Number You Want to Subtract : ");
        n=sc.nextInt();
        for(i=0;i<n;i++){
            System.out.print("Enter Value Number"+(i+1)+" : ");
            num[i]=sc.nextFloat();
            if (i == 0) {
                sub = num[i];
            } else {
                sub -= num[i];
            }
        }
        System.out.println("Subtract = "+sub);
    }
    static void Multiply(){
        Scanner sc = new Scanner(System.in);
        int i,n;
        float[] num = new float[50];
        float Mul=1;
        System.out.print("Enter Number You Want to Multiply : ");
        n=sc.nextInt();
        for(i=0;i<n;i++){
            System.out.print("Enter Value Number"+(i+1)+" : ");
            num[i]=sc.nextFloat();
            Mul*=num[i];
        }
        System.out.println("Multiply = "+Mul);
    }
    static void Division(){
        Scanner sc = new Scanner(System.in);
        int i,n;
        float[] num = new float[50];
        float div=1;
        System.out.print("Enter Number You Want to Division : ");
        n=sc.nextInt();
        for(i=0;i<n;i++){
            System.out.print("Enter Value Number"+(i+1)+" : ");
            num[i]=sc.nextFloat();
            if (i == 0) {
                div = num[i];
            } else {
                if (num[i] != 0) {
                    div /= num[i];
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    return;
                }
            }
        }
        System.out.println("Division = "+div);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1.Sum");
            System.out.println("2.Subtract");
            System.out.println("3.Multiply");
            System.out.println("4.Division");
            System.out.println("5.Exit");
            System.out.print("Please Chose Option : ");
            int chose = sc.nextInt();
            switch(chose){
                case 1:{
                    Sum();
                }break;
                case 2:{
                    Subtract();
                }break;
                case 3:{
                    Multiply();
                }break;
                case 4:{
                    Division();
                }break;
                case 5:{
                    System.out.println("Exiting Program...");
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid choice! Please try again.\n");
            }
            
            
        }
    }
    
}
