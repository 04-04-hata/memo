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
=によって生成したインスタンスをHero型変数hに代入している。

