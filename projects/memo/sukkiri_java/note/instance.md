〜インスタンスの利用方法〜

Heroクラスだけではプログラムは動かず、勇者に指示を出す天の声が必要。<br>

神様のクラス(勇者などへの指示を書くクラス)を作る<br>
public class Buttle {<br>
  public static void main (String args) {<br>

  }<br>
}<br>

mainメソッドに書く内容
- 仮想世界に勇者を生み出す
- 生み出された勇者に、最初の名前とHPを設定する
- 勇者に5秒座れ、転べ、25秒座れ、逃げろと指示を出す

インスタンスの生成
クラス名 変数名 = new クラス名();<br>

勇者インスタンスを生成
public class Buttle {<br>
  public static void main (String args) {<br>
  // 勇者を生成<br>
    Hero h = new Hero(); // Heroクラスからインスタンスを生成し、変数hに入れる<br>
  }<br>
}<br>

ここで実際にインスタンスを生成しているのは、右辺のnew Hero()という部分であり、
=によって生成したインスタンスをHero型変数hに代入している。<br>

インスタンスのフィールド利用
生み出されたばかりの勇者hには、名前もHPもまだないのでそれぞれのフィールドに値を代入する。<br>
勇者hのフィールドに値を代入するには↓以下のような文法を使う<br>

フィールドへの値の代入:変数名.フィールド名 = 値;

public class Buttle {<br>
  public static void main (String args) {<br>
  // 勇者を生成<br>
    Hero h = new Hero(); // Heroクラスからインスタンスを生成し、変数hに入れる<br>
    h.name = "ミナト"; // 変数hのnameに代入<br>
    h.hp = 100; // 変数hのhpに代入<br>
    System.out.println("勇者" + h.name + "を生み出しました!"); // 変数hのnameを取り出す<br>
  }<br>
}<br>

インスタンスのメソッド呼び出し
勇者に指示を送る = メソッド呼び出し<br>

public class Buttle {<br>
  public static void main (String args) {<br>
  // 勇者を生成<br>
    Hero h = new Hero(); // Heroクラスからインスタンスを生成し、変数hに入れる<br>
    h.name = "ミナト"; // 変数hのnameに代入<br>
    h.hp = 100; // 変数hのhpに代入<br>
    System.out.println("勇者" + h.name + "を生み出しました!"); // 変数hのnameを取り出す<br>
    // 勇者のメソッドを呼び出していく<br>
    h.sit(5); // 5秒座れ<br>
    h.slip(); // 転べ<br>
    h.sit(25); // 25秒座れ<br>
    h.run(); // 走れ<br>
  }<br>
}<br>
