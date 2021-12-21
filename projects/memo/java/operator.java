/*
〜演算子とオペランド〜
演算子…計算をする時に使う 「+」や、代入する時に使う「=」などの記号。
オペランド…演算の対象となる部分。
例えば、「a = b + 3」なら、bや3がオペランドという事になる。
「a = b + 3」自体は式になる。

〜算術演算子〜
+…足し算。例:a + b
-…引き算。例:a - b
*…掛け算。例:a * b
/…割り算。例:a / b
%…割り算の余り。例:a % b

〜インクリメント〜
インクリメント…1増加させる演算子。前に置くのと後ろに置くのでは処理が変わる。

前置インクリメント
例:int a;
   int b;
   a = 5;
   b = ++a;
↑aを1増加させた後に、aがbに代入される。それぞれの値はaが6でcも6。

後置インクリメント
例:a = 5;
   b = a++;
↑aをbに代入した後に、aが1増加される。それぞれの値はaが6でbが5。

〜代入演算子〜
代入演算子…変数に値を入力したい場合や計算した結果を代入したい場合に使用する。

使用例:int a;
      a = 10;(代入。aに10を代入している)
      a += 5;(加算代入。aにa + 5の結果を代入している。結果は10 + 5で15)
      a -= 5;(減算代入。aにa - 5の結果を代入している。結果は15 - 5で10)
      a *= 5;(乗算代入。aにa * 5の結果を代入している。結果は10 * 5で50)
      a /= 5;(除算代入。aにa / 5の結果を代入している。結果は50 / 5で10)
      a %= 5;(剰余代入。aにa % 5の結果を代入している。結果は10 % 5で余りは0)

〜比較演算子〜
比較演算子…2つの値が大きいか小さいか等しいかを調べる場合に使用する。結果はboolean型になる。
<…小なり。例:a < b 解説:aがbより小さい場合true
<=…小なりイコール。例:a <= b 解説:aがbより小さいか等しい場合true
>…大なり。例:a > b 解説:aがbより大きい場合true
>=…大なりイコール。例:a <= b 解説:aがbより大きいか等しい場合true
==…等価。例:a == b 解説:aとbが等しい場合true
!=…不等価。例:a != b 解説:aとbが等しくない場合true

〜論理演算子〜
複数の式を条件とする場合に使用する。結果はboolean型。
&&…AND。例:a && b
||…OR。例:a || b
!…NOT。例: !a

〜文字列の連結〜
+で文字を連結する。
例:String a = "あ"
   String b = "い"
   String c = "100"
   String d = "200"
   System.out.println(a + b); 結果:あい
   System.out.println(c + d); 結果:100200
*/

public class operator {
	public static void main(String[] args) {
		
		int val = 2 + 5;
	    System.out.println(val);

	    val++;
	    System.out.println(val);

	    val *= 5;
	    System.out.println(val);

	    boolean bool = val == 50;
	    System.out.println(bool);

	    bool = (val < 50) && (val % 10 == 0);
	    System.out.println(bool);

      String a = "あ";
      String b = "い";
      String c = "100";
      String d = "200";
      System.out.println(a + b);
      System.out.println(c + d);

	}
}
