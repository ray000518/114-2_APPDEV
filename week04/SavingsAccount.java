class BankAccount {
    private String owner;
    private String accountId;
    private double balance;

    public BankAccount(String owner, String accountId) {
        this.owner = owner;
        this.accountId = accountId;
        this.balance = 0;
    }

    public String getOwner() { return owner; }
    public String getAccountId() { return accountId; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    public void showInfo() {
        System.out.println("帳戶：" + accountId +
            " 戶名：" + owner +
            " 餘額：" + balance);
    }
}

// SavingsAccount 繼承 BankAccount
public class SavingsAccount extends BankAccount {
    
    // 新增 private double interestRate
    private double interestRate;

    // 建構子接收 owner, accountId, interestRate，用 super 呼叫父類別建構子
    public SavingsAccount(String owner, String accountId, double interestRate) {
        super(owner, accountId);
        this.interestRate = interestRate;
    }

    // addInterest() 方法
    public void addInterest() {
        double interest = getBalance() * interestRate;
        System.out.println("利息 " + interest + " 已存入");
        deposit(interest); // 呼叫父類別繼承下來的 deposit 存入利息
    }

    public static void main(String[] args) {
        // 建立 SavingsAccount，年利率 0.02 (2%)
        SavingsAccount myAcc = new SavingsAccount("李小華", "S001", 0.02);
        
        // 存入 10000 元
        myAcc.deposit(10000);
        myAcc.showInfo();
        
        // 呼叫 addInterest()
        myAcc.addInterest();
        
        // 印出帳戶資訊
        myAcc.showInfo();
    }
}
