import java.util.Scanner;

public class Electric{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float oldFee, newFee, Total = 0, Payment = 0;
        
        System.out.print("Enter Value OldFee : ");
        oldFee = sc.nextFloat();
        System.out.print("Enter Value NewFee : ");
        newFee = sc.nextFloat();
        
        if (newFee > oldFee) {
            Total = newFee - oldFee;
            if (Total <= 50) {
                Payment = Total * 750;
            } else if (Total > 50 && Total < 100) {
                Payment = (50 * 750) + (Total - 50) * 550;
            } else if (Total >= 100 && Total < 200) {
                Payment = (50 * 750) + (50 * 550) + (Total - 100) * 450;
            } else{
                Payment = (50 * 750) + (50 * 550) + (100 * 450) + (Total - 200) * 350;
            }
            
            // Output the Total and Payment
            System.out.println("Total: " + Total);
            System.out.println("Payment: " + Payment+"KHR");
        } else {
            System.out.println("Invalid Input! Please try again...!");
        }
    }
}