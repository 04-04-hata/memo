〜再帰について〜

再帰…あるメソッドの中から自分自身のメソッドを呼び出す処理の事。

例↓<br>

package practice;

public class Chapter15_1 {
	public static void main(String[] args) {
        int a = 976;
        int b = 427;
        System.out.print(a + " と " + b + " の最大公約数は、" + gcd(a, b) + "です。");
    }

    // ユークリッドの互除法で最大公約数を計算するメソッド
    static int gcd(int a, int b) {
    	// a % bの結果を入れておくための変数を定義
    	int result = a % b;
    	// もしa % b (a ÷ bの余りが0の場合、戻り値はresult)
    	if (result == 0) {
    		return result;
    	} else {
    		return b % result;
    	}
    	// a % bが0じゃない場合、bをresultで割る。
    }
}

/*模範解答
//ユークリッドの互除法で最大公約数を計算するメソッド
static int gcd(int a, int b) {
    // b(余り)が0になった時のaが最大公約数
    if (b == 0) {
        return a;
    }
    // 再帰呼び出し
    return gcd(b, a % b);
}
*/

〜キャストについて〜

キャスト…型変換の事。

型 変数名 = (型)変数名

↑でキャスト出来る。