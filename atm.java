
import java.util.Scanner;
class BankAccount{
    String name;
    String userName;
    String password;
    String accountNo;
    float balance=100000f;
    int transaction=0;
    String transactionHistory="";
    public BankAccount(){}
    BankAccount(String name, String userName, String password, String account , String bankAccount){
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.accountNo = accountNo;

    }
    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Your Name -");
        this.name = sc.nextLine();
        System.out.println("\nEnter Your Username - ");
        this.userName = sc.nextLine();
        System.out.println("\nEnter Your Password - ");
        this.password = sc.nextLine();
        System.out.println("\nEnter Your Account Number - ");
        this.accountNo = sc.nextLine();
        System.out.println("\nRegistration Complete..Kindly login");
    }
    public boolean login(){
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while(!isLogin){
            System.out.println("\nEnter Your Username - ");
            String Username = sc.nextLine();
            if (Username.equals(userName)){
                while(!isLogin){
                    System.out.println("\nEnter YourPassword - ");
                    String Password = sc.nextLine();
                    if (Password.equals(password)){
                        System.out.println("\nLogin Successfully!!");
                        isLogin=true;
                    }
                    else{
                        System.out.println("\nIncorrect Password");
                    }
                }
            }
            else{
                System.out.println("\nUsername not foumd");
            }
        }
        return isLogin;
    }
    public void withdraw(){
        System.out.println("\nEnter amount to withdraw - ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try{
            if (balance>= amount){
                transaction++;
                balance -= amount;
                System.out.println("\nWithdrawSuccessfully");
                String str = amount + "Rs Withdraw SuccessFully\n";
            }
            else{
                System.out.println("\nInsufficient Balance");
            }
        }
        catch(Exception e){
        }
    }
    public void deposit(){
        System.out.println("\nEnter amount to deposite - ");
        Scanner sc = new Scanner(System.in);
        float amount=sc.nextFloat();
        try {
            if (amount <= 100000f){
                transaction++;
                balance += amount;
                System.out.println("\nSuccessfully Depsited");
                String str = amount +"Rs deposited\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else{
                System.out.println("\nSorry limiy is 100000.oo");
            }
        }
        catch (Exception e) {
        }
    }
    public void transfer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Receipent's Name - ");
        String receipent= sc.nextLine();
        System.out.println("\nEnter amount to tranfet - ");
        float amount = sc.nextFloat();
        try {
            if (balance>=amount){
                if( amount<= 50000f){
                    transaction++;
                    balance-=amount;
                    System.out.println("\nSuccessfully Tranferd to "+ receipent);
                    String str = amount+"Rs transfered to"+receipent+"\n";
                    transactionHistory= transactionHistory.concat(str);
                }
                else {
                    System.out.println("\nSorry Limit is 50000.00");
                }
            }


            else{
                System.out.println("\nInsufficient Balance");
            }
        }
        catch (Exception e){
        }
    }

    public void checkBalance(){
        System.out.println("\n"+balance+"Rs");
    }
    public void transHistory(){
        if (transaction==0){
            System.out.println("\nEmpty");
        }
        else{
            System.out.println("\n +transactionHistory");
        }
    }
}

public class atm{

    public static int takeIntegerInput(int limit) {
        int input=0;
        boolean flag = false;
        while (!flag){
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if(flag && input > limit|| input<1){
                    System.out.println("Choose the number between 1 to" +limit);
                    flag = false;
                }
            }
            catch (Exception e) {
                System.out.println("Enter only integer value");
                flag=false;
            }
        };
        return input;
    }
    public static void main(String[] args){
        System.out.println("\n**********WELCOME TO GRAMIN BANK ATM SYSTEM**********\n");
        System.out.println("1. REGISTER\n2.Exit");
        System.out.println("ENTER YOUR CHOICE -");
        int choice = takeIntegerInput(2);

        if (choice==1){
            BankAccount b = new BankAccount();
            b.register();
            while (true) {
                System.out.println("\n1.Login\n2.Exit");
                System.out.println("Enter Your Choice - ");
                int ch = takeIntegerInput(2);
                if(ch==1){
                    if(b.login()) {
                        System.out.println("\n\n**********WELCOME BANk**********"+b.name+"**********\n");
                        boolean isFinished = false;
                        while(!isFinished){
                            System.out.println("\n1. Withdraw \n2.deposit \n3.Transfer \n4.CheckBalance \nBankAccpount");
                            System.out.println("\nEnter Your Choice - ");
                            int c = takeIntegerInput(6);
                            switch(c){
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                }
                else {
                    System.exit(0);
                }

            }
        }
        else {
            System.exit(0);
        }

    }
}




