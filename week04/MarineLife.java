package week04;

// 父類別：不加 public，因為檔名是 MarineLife.java
class MarineBase {
    protected String name;
    protected String habitat;

    public MarineBase(String name, String habitat) {
        this.name = name;
        this.habitat = habitat;
    }

    public String info() {
        return name + "，棲息地：" + habitat;
    }

    public String move() {
        return name + " 在水中移動";
    }
}

// TODO 1: Fish 繼承 MarineBase
class Fish extends MarineBase {
    private String scaleColor; // 鱗片顏色

    public Fish(String name, String habitat, String scaleColor) {
        // 使用 super 呼叫父類別建構子
        super(name, habitat);
        this.scaleColor = scaleColor;
    }

    // 覆寫 move() 方法
    @Override
    public String move() {
        return name + " 擺動魚鰭游泳";
    }

    // 新增 fishInfo() 方法
    public String fishInfo() {
        return info() + " 鱗片：" + scaleColor;
    }
}

// TODO 2: Whale 繼承 MarineBase
class Whale extends MarineBase {
    private double length; // 體長

    public Whale(String name, String habitat, double length) {
        // 使用 super 呼叫父類別建構子
        super(name, habitat);
        this.length = length;
    }

    // 覆寫 move() 方法
    @Override
    public String move() {
        return name + " 擺動尾鰭前進";
    }

    // 新增 whaleInfo() 方法
    public String whaleInfo() {
        return info() + " 體長：" + length + " 公尺";
    }
}

// 注意：檔名是 MarineLife.java，所以這個 class 要加 public
public class MarineLife {
    public static void main(String[] args) {
        // TODO 3: 建立 Fish 和 Whale 各一個
        Fish clownfish = new Fish("小丑魚", "珊瑚礁", "橘白相間");
        Whale blueWhale = new Whale("藍鯨", "太平洋", 30.0);

        // 印出結果
        System.out.println(clownfish.fishInfo());
        System.out.println(clownfish.move());

        System.out.println(blueWhale.whaleInfo());
        System.out.println(blueWhale.move());
    }
}