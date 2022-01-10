〜内部クラスについて〜

内部クラス…クラスの中にあるクラスの事。<br>
クラスは通常、一ファイルの中に一つだけ定義する事が多いが、言語仕様上は一ファイルの中に複数のクラスを持つ事が出来る。その中で、クラスの中に定義するクラスを内部クラスと言う。<br>
鯖で言うならダブルサモン(二重召喚)みたいなもんかな。<br>

クラスAの中に、内部クラスBを持つ例↓<br>
public class A {
    public class B {
    }
}<br>

内部クラスBの中に、さらに内部クラスCを持つ例↓
public class A {
    public class B {
        public class C {
        }
    }
}<br>

内部クラスではなくても、1ファイルに複数のクラスを持つことも出来る。<br>この場合は↓内部クラスではない<br>
public class A {

}

class B {

}<br>

〜内部クラスの使い方〜

内部クラスもクラスと同じようにインスタンス化できますが、以下のような制限があります。<br>
* staticクラスは、クラス外から直接インスタンス化できる
* 非staticクラスは、外部クラスのインスタンスからのみインスタンス化できる<br>
なお、非staticな場合のみ内部クラスと呼び、それ以外は「ネストしたクラス」として扱う場合もあります。<br>
では、使用例を見てみましょう。以下のクラス Outer、 Inner を、インスタンス化してみます。<br>

package inner_class_sample;

public class Outer {
    public class Inner {
    }
}<br>

このクラスA、Bを、別のクラスCからインスタンス化してみましょう。<br>

public class Example {
    public static void main(String[] args) {
        Outer outer = new Outer(); // クラスOuterをインスタンス化
        Outer.Inner inner = outer.new Inner(); // クラスOuterの内部クラスInnerをインスタンス化
    }
}<br>

クラスOuterは外部クラスですので、 Outer outer = new Outer(); でインスタンス化できますが、クラスInnerは、非staticな内部クラスですので、インスタンス化するときは、 outer.new Inner() のように、外部クラスAのインスタンス outerを使ってインスタンスを作る必要があります。<br>また、クラスを直接参照することができないため、型として用いる際は Outer.Inner と外部クラス名とともに指定するか、import inner_class_sample.Outer.Inner; といったimport文を書かなくてはなりません。<br>

次に、staticな内部クラスBの例を見てみましょう。<br>

package inner_class_sample;

public class Outer {
    public static class Inner {
    }
}<br>

このクラスA、Bを、別のクラスCからインスタンス化してみましょう。<br>

public class Example {
    public static void main(String[] args) {
        Outer outer = new Outer(); // クラスOuterをインスタンス化
        Outer.Inner inner = new Outer.Inner(); // クラスOuterの内部クラスInnerをインスタンス化
    }
}<br>

staticな内部クラスBをインスタンス化する場合は、 new Outer.Inner() のように書くことで直接インスタンス化できます。先ほどと同様で、 import inner_class_sample.Outer.Inner; とimport文を書けばnew Inner() のみでインスタンスを生成することが可能です。<br>

非staticなクラスのインスタンス化↓(別のクラスCから)<br>
Outer.Inner inner = outer.new Inner();<br>
外部クラスAのインスタンス↑Outerを使ってインスタンスを作る<br>

staticなクラスのインスタンス化↓(別のクラスCから)<br>
Outer.Inner inner = new Outer.Inner();<br>
直接インスタンス化してる↑<br>

import文<br>

import inner_class_sample.Outer.Inner;

↑このインポート文を書いた上で、staticな内部クラスをインスタンス化するなら、new Inner()のみでインスタンス生成が可能。<br>

〜内部クラスと外部クラスの関係性〜

内部クラスを外部クラスのフィールド(変数)を直接参照する事が出来る。<br>

public class Outer {

  // 外部クラスに定義したフィールドgreeting
    private String greeting = "こんにちは";

    public class Inner {

        public String hello() {
      // 内部クラスInnerから、外部クラスOuterのフィールドgreetingを参照
            return greeting;
        }
}<br>

↑の例では、外部クラスOuterのフィールド(変数)greetingを内部クラスInnerから参照している。ここからわかるように、privateな変数も内側からであれば参照可能。<br>

ただし、内部クラスInnerがstaticな場合は参照出来ずにコンパイルエラーとなる。<br>
つまり、変数と内部クラスが同じ関係ならコンパイルエラーにならない。<br>
- 変数と内部クラスが非static→参照可能
- 変数と内部クラスがstatic→参照可能
- 変数がstatic、内部クラスが非static→コンパイルエラー
- 変数が非static、内部クラスがstatic→コンパイルエラー

<br>

〜内部クラスを使うケース〜

case1.定数クラスを読みやすくするケース<br>

↓の4つを定数化するとする。<br>

- 猫の名前
- 猫の足の本数
- タコの名前
- タコの足の本数

<br>

public class Constants {

  //内部クラスCatの中に、猫関係の定数を定義
    public static class Cat {
        public static final String NAME = "猫";
        public static final int LEG_COUNT = 4;
    }

  //内部クラスOctopusの中に、タコ関係の定数を定義
    public static class Octopus {
        public static final String NAME = "タコ";
        public static final int LEG_COUNT = 8;
    }

}<br>

処理↓<br>

System.out.print(Constants.Cat.NAME); // “猫”<br>
System.out.print(Constants.Cat.LEG_COUNT); // 4<br>
System.out.print(Constants.Octopus.NAME);  // "タコ"<br>
System.out.print(Constants.Octopus.LEG_COUNT);  // 8<br>

case2.クラス間の関連性を強調するケース<br>

↓の4クラスを作るとする。<br>

- 猫クラス
- 猫の爪クラス
- タコクラス
- タコの吸盤クラス

// 猫クラス<br>
public class Cat {
  // 猫の爪クラス<br>
  public class CatNail {
  }<br>
}<br>

// タコクラス<br>
public class Tako {
  // タコの吸盤クラス<br>
  public class TakoSucker {
  }<br>
}<br>
