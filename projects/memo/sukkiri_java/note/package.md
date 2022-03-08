〜パッケージについて〜

パッケージ…クラスを分類、管理する仕組み。<br>
各クラスをパッケージというグループに所属させて分類、管理できるような仕組みになっている。<br>

クラスをパッケージに所属させる<br>
package 所属させたいパッケージ名;<br>
※package文はソースコードの先頭に記載する必要がある。<br>

パッケージの中にパッケージを入れることは出来ず、
パッケージ名の一部が同じであっても、それぞれのパッケージに関連性はない。<br>

例:正しいパッケージのイメージ<br>

calcapp.mainパッケージ
- Calc.java
- Calcクラス

calcapp.logicsパッケージ
- CalcLogic.java
- CalcLogicクラス

calcappパッケージ

〜デフォルトパッケージについて〜

package文がないクラスはどのパッケージにも所属していないことになる。<br>
どのパッケージにも所属していないことを「無名パッケージに属している」もしくは
「デフォルトパッケージに属している」と表現する事もある。<br>
デフォルトパッケージに属するクラスはimport文でインポートする事はできない。<br>

〜別のパッケージにあるクラスを呼び出す〜

あるクラスから別パッケージのクラスを利用する場合、「パッケージ名を頭につけた完全なクラス名」を使う必要がある。<br>
この完全なクラス名のことを、完全限定クラス名や完全修飾クラス名(FQCN)と呼ぶ。<br>

別のパッケージにあるクラスを呼び出す(完全限定クラス名(FQCN))<br>
パッケージ名.クラス名<br>

例:clacapp.logics(パッケージ名).ClacLogic(クラス名).tasu(a, b);<br>
　 clacapp.logics(パッケージ名).ClacLogic(クラス名).hiku(a, b);

FQCN入力の手間を省く為の宣言<br>
import パッケージ名.クラス名;<br>
※import文はソースコードの先頭に書くが、package文より後に記述する。<br>

例<br>
package calcapp.main;(パッケージ名)<br>
import calcapp.logics(パッケージ名).CalcLogic(クラス名);<br>

public class Calc {<br>
	public static void main(String[] args) {
	    int a = 10;
	    int b = 2;
	    int total = CalcLogic.tasu(a, b); //クラス名.メソッド名
	    int delta = CalcLogic.hiku(a, b); //クラス名.メソッド名
      // FQCN(パッケージ名.クラス名)じゃ無くてもエラーにならない↑
	    System.out.println("足すと" + total + "、引くと" + delta);
	  }
}<br>

import文の意味(例)<br>
このソースコードで単にCalcLogicという表記があったら、
それはcalcapp.logics.(パッケージ名)CalcLogic(クラス名)の事だと解釈しろという指示。<br>

頻繁に利用するクラスはimport文を使ってインポートしておくことで、「パッケージ名.クラス名」を毎回指定する必要がなくなる<br>

パッケージの全クラスをインポートする<br>
import パッケージ名.*;<br>

ただし、「import calcapp.*」という記述では、calcapp.mainとclacapp.logicsに所属する全てのクラスを一度にインポート出来ない。<br>
理由は、calcapp.mainとcalcapp.logicsとcalcappはそれぞれ違うパッケージだから。<br>
「import calcapp.*」という記述では、calcappに所属する全てのクラスを指定しているのにすぎず、
clacapp.mainとcalcapp.logicsの全てのクラスをインポートするには、<br>
import clacapp.main.*;<br>
import clacapp.logics.*;<br>
としなければならない。<br>