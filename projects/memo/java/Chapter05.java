/*
プリミティブ型…直接データを保持保持している型の事。
プリミティブとは「原始的、素朴な」という意味である。

参照型…直接データを保持するのではなく、番地でデータを保存する型の事。

〜プリミティブ型と参照型の違い〜
変数mに'みかん'という文字データが入っているとして、
プリミティブ型だと「みかん」が直接入っている事になり、
参照型だと番地(今回は200番地とする)に「みかん」という文字データが
入っている事になる。

null…データが存在しない事。参照型の変数にnullを入れるとエラーになる。

ラッパークラス…プリミティブ型を参照型として扱えるように出来るクラスの事。
プリミティブ型の値を参照型の値に変える行為をボクシングと呼び、
ラッパークラス型の値からプリミティブ型へ値を変換する行為をアンボクシングと呼ぶ。

配列…同じ型の複数のデータをひとつの変数で扱えるようにしたもの。
配列内のデータの事を要素といい、0番から始まる。
例えば、int[] array1 = {10, 20, 30, 40, 50};の場合、
0番が10で4番が50になる。
*/

public class Chapter05 {
	public static void main(String[] args) {
		
		//プリミティブ型変数宣言と初期化
		long long1 = 9223372036854775807L;
		double double1 = 123.12;
		boolean boolean1 = true;
		
		//ラッパークラス変数宣言と初期化
		Float float1 = 0.123f;
		Integer int1 = 1;
		Character char1 = 'あ';
		
		//配列変数宣言と初期化
		int[] array1 = {10, 20, 30, 40, 50};
		int int2 = array1[3];
		
		//プリミティブ型変数出力
		System.out.println(long1);
		System.out.println(double1);
		System.out.println(boolean1);
		
		//ラッパークラス変数出力
		System.out.println(float1);
		System.out.println(int1);
		System.out.println(char1);
		
		//配列変数出力
		System.out.println(int2);
	}
}
