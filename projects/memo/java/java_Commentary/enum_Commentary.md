〜列挙型(Enum)について〜

JavaのEnum(列挙型)とは、プログラムの中で定義する定数を拡張し、さらに安全かつ便利にする仕組み。<br>

列挙型の書き方↓<br>

public enum Dessert(列挙型の名前) { <br>
	APPLE,ICE_CREAM,CAKE,…
	// ↑定数
}<br>

呼び出し↓<br>

System.out.print(Dessert.APPLE);
System.out.print(Dessert.ICE_CREAM);
System.out.print(Dessert.CAKE);

出力結果↓(実際のとは少し違う)<br>
APPLE、ICE_CREAM、CAKE
<br>

〜列挙型の特徴〜

1.変数として使える<br>

例<br>
Dessert apple = Dessert.APPLE;
Dessert iceCream = Dessert.ICE_CREAM;
Dessert cake = Dessert.CAKE;

呼び出し<br>

System.out.print(apple);
System.out.print(iceCream);
System.out.print(cake);

<br>

2.メソッドの引数の型に用いれられる

static void printDessertName(Dessert dessert){
    System.out.print(dessert);
}<br>

static void メソッド名(列挙型名 変数名?)

呼び出し↓ <br>

printDessertName(Dessert.APPLE);

※列挙型は新しいインスタンスを生成出来ない

==で比較出来る

Dessert x = Dessert.APPLE;
Dessert y = Dessert.APPLE;
System.out.print(x == y); // trueを返す
System.out.print(x.equals(y));    // trueを返す

〜列挙型の機能〜

name()

列挙した定数名そのものをString型で返す。

例:System.out.print(Dessert.APPLE.name());<br>
出力:APPLE;

基本構文:列挙名.定数名.name();

valueOf(String name)

name()とは逆にString型の名称から列挙型のインスタンスを取得したい場合は、valueOf()を使う。

例:Dessert apple = Dessert.valueOf(“APPLE”);
     System.out.print(apple);
出力:APPLE

基本構文:列挙型名 変数名 = 列挙型名.valueOf(“文字列”);

ordinal()

列挙した順序をint型で返す(0からスタート)

例:public enum Dessert {
    APPLE, ICE_CREAM, CAKE,
}<br>

例ではAPPLE, ICE_CREAM, CAKE,の順に列挙してるので

System.out.print(Dessert.APPLE.ordinal());
System.out.print(Dessert.ICE_CREAM.ordinal());
System.out.print(Dessert.CAKE.ordinal());

実行例:0、1、2

※列挙する順番を変えるとordinal()の値も変わるので注意が必要。

〜列挙型の更なる活用〜

値を追加出来る

列挙型は列挙したそれぞれのインスタンスにさらに値を持たせる事が出来る。<br>

例↓<br>

public enum Dessert {

  // それぞれに値段を指定する
    APPLE(100), ICE_CREAM(200), CAKE(300),;

  // 値段を保持するフィールド
    private int price;

  // コンストラクタを追加。引数はint型の値段。
    private Dessert(int price) {
        this.price = price;
    }

  // 値段を取得するメソッドを追加
    public int getPrice() {
        return price;
    }
}<br>

実行例↓<br>

System.out.print(Dessert.APPLE.getPrice());
System.out.print(Dessert.ICE_CREAM.getPrice());
System.out.print(Dessert.CAKE.getPrice());

結果:100、200、300

メソッドを追加出来る

インスタンスごとにメソッドを追加することも出来る。抽象メソッドを用意し、各インスタンスでそれを継承すると、インスタンスごとに実行したいコードの内容を変える事が出来る。<br>

例↓<br>

public enum Dessert {

  APPLE(100) {
    @Override
    void advertise() {
      // りんご用のadvertiseの実装
      System.out.print("まっかなりんごが" + getPrice() + "円！"); // getPriceメソッドも活用できる
    }
  },

  ICE_CREAM(200) {
    @Override
    void advertise() {
      // アイスクリーム用のadvertiseの実装
      System.out.print("夏にぴったりアイスクリームが" + getPrice() + "円！");
    }
  },

  CAKE(300) {
    @Override
    void advertise() {
      // ケーキ用のadvertiseの実装
      System.out.print("皆大好き甘いケーキが" + getPrice() + "円！");
    }
  },
  ;

  private int price;

  private Dessert(int price) {
    this.price = price;
  }

  public int getPrice() {
    return price;
  }

  // 宣伝文句を出力する抽象メソッド。各インスタンスで実装する
  abstract void advertise();
}<br>

実行例↓<br>

Dessert.APPLE.advertise(); // 「まっかなりんごが100円！」と出力
Dessert.ICE_CREAM.advertise(); // 「夏にぴったりアイスクリームが200円！」と出力
Dessert.CAKE.advertise(); // 「皆大好き甘いケーキが300円！」と出力