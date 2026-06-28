// 將父類別邏輯與主程式合併至 public class MarineLife 中
public class MarineLife {
    protected String name;
    protected String habitat;

    public MarineLife(String name, String habitat) {
        this.name = name;
        this.habitat = habitat;
    }

    public String info() {
        return name + "，棲息地：" + habitat;
    }

    public String move() {
        return name + " 在水中移動";
    }

    public static void main(String[] args) {
        // 3: 建立 Fish 和 Whale 各一個，印出資訊和移動方式
        Fish nemo = new Fish("小丑魚", "珊瑚礁", "橘白相間");
        System.out.println(nemo.fishInfo());
        System.out.println(nemo.move());

        Whale blueWhale = new Whale("藍鯨", "太平洋", 30.0);
        System.out.println(blueWhale.whaleInfo());
        System.out.println(blueWhale.move());
    }
}

// 1: Fish 繼承 MarineLife
class Fish extends MarineLife {
    private String scaleColor; // 鱗片顏色

    public Fish(String name, String habitat, String scaleColor) {
        super(name, habitat); // 用 super 呼叫父類別建構子
        this.scaleColor = scaleColor;
    }

    @Override
    public String move() {
        return name + " 擺動魚鰭游泳";
    }

    public String fishInfo() {
        return info() + " 鱗片：" + scaleColor;
    }
}

// 2: Whale 繼承 MarineLife
class Whale extends MarineLife {
    private double length; // 體長

    public Whale(String name, String habitat, double length) {
        super(name, habitat); // 用 super 呼叫父類別建構子
        this.length = length;
    }

    @Override
    public String move() {
        return name + " 擺動尾鰭前進";
    }

    public String whaleInfo() {
        return info() + " 體長：" + length + " 公尺";
    }
}
