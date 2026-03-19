package week04;

// 父類別：不加 public，因為檔名是 SavingsAccount.java
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
        System.out.println("帳戶：" + accountId + " 戶名：" + owner + " 餘額：" + balance);
    }
}

// TODO: SavingsAccount 繼承 BankAccount
class SavingsAccountImpl extends BankAccount {
    // 新增屬性：年利率
    private double interestRate;

    // 建構子
    public SavingsAccountImpl(String owner, String accountId, double interestRate) {
        // 使用 super 呼叫父類別建構子
        super(owner, accountId);
        this.interestRate = interestRate;
    }

    // addInterest() 方法
    public void addInterest() {
        // 利息 = 目前餘額 * 利率
        double interest = getBalance() * interestRate;
        System.out.println("利息 " + interest + " 已存入");
        
        // 呼叫父類別的 deposit 方法存入利息
        deposit(interest);
    }
}

// 主程式：檔名必須與 public class 名稱一致
public class SavingsAccount {
    public static void main(String[] args) {
        // TODO: 建立 SavingsAccount，年利率 0.02 (2%)
        SavingsAccountImpl acc = new SavingsAccountImpl("李小華", "S001", 0.02);
        
        // 存入 10000 元
        acc.deposit(10000);
        acc.showInfo();
        
        // 呼叫 addInterest()
        acc.addInterest();
        
        // 印出帳戶資訊
        acc.showInfo();
    }
}