〜staticについて〜

staticメソッド…staticがついているメソッドの事。<br>

例↓<br>
static void staticMethod(){<br>
  //処理<br>
}<br>

staticメソッドは、インスタンスを生成しなくても呼び出せる。<br>
※通常、メソッドを呼び出す時はnewを使ってインスタンスを生成した後に呼び出さないといけない<br>
説明を求められないと「今はまだその時ではない」って言えない感じ。
事柄の説明がインスタンスで、呼び出しが説明を求める行為。で、「今はまだその時ではない」メソッド発動。<br>

staticメソッドはメソッド名を指定するだけで呼び出す事が出来、インスタンス化の影響を一切受けない。<br>
どのクラスから呼び出されても、staticメソッドの処理内容は全く同じ.
<br>

mainメソッドには必ずstaticがついている。<br>
public static void main(String[] args){<br>
  //処理<br>
}<br>

mainメソッドはプログラムが実行されると最初に動く部分なのでインスタンス化を行うことが出来ない為、必ずstaticをつけておく。<br>

staticメソッドを使用するメリット<br>

クラス単体で何かを実行したい時<br>

staticメソッドはインスタンス化しなくても利用出来るので、インスタンス化による影響を受けない。その為、クラス単体で何かを実行したい場合に便利。<br>

〜static変数について〜<br>

static変数…インスタンスを生成せずに使える変数の事。<br>
変数を宣言する時にstaticとつけるとstatic変数にする事が可能。<br>

staticメソッドとstatic変数の使用例↓<br>

Human04.java↓<br>

package classMethod.human;<br>

public class Human04 {<br>
		
		//static変数
		static public int humanCount = 0;
		public String name;
		//定数
		public static final String GREETING = "こんにちは";
		
		public Human04(String name) {
			this.name = name;
			//インスタンス生成ごとにstatic変数をインクリメント
			Human04.humanCount++;
		}
		
		static public void staticMethodPrint() {
			//staticメソッドからインスタンス変数は使用できない(コンパイルエラー)
			//System.out.print("名前は、" + name);
			//static変数のhumanCountを表示
			System.out.print("人の数は" + Human04.humanCount);
		}
		
		public void instanceMethodPrint() {
			//インスタンス変数のnameを表示
			System.out.print("名前は" + name);
		}

}<br>

ClassMethod04.java↓<br>

package classMethod;<br>

import classMethod.human.Human04;<br>

public class ClassMethod04 {<br>

	public static void main(String[] args) {
        // Human04インスタンスを生成すると、コンストラクタ内の処理が実行される
        Human04 yamada = new Human04("山田");

        // 静的メンバーは、インスタンス生成せずに直接使用できる
        Human04.staticMethodPrint();

        // staticなクラス定数もインスタンスを生成せずに参照できる
        System.out.print(Human04.GREETING);

        // インスタンスメンバーは直接使用できない（コンパイルエラーになる）
        // Human04.instanceMethodPrint();
        // System.out.print(Human04.name);

        // インスタンスメンバーはインスタンス生成してから使用する
        yamada.instanceMethodPrint();
    }
}<br>

〜まとめ〜

staticメソッド…インスタンスを生成しなくても呼び出せるメソッド.<br>
static変数…インスタンス化の影響を受けない変数.<br>
staticなクラスとかメソッドとか変数とか要は鯖で言うなら擬似鯖の依代(今を生きる人類)みたいなもんかな。<br>





