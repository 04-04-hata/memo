〜無名クラスについて〜

無名クラス…名前を持たない(クラス定義しない)クラスの作り方で、既に存在するクラスを利用する際に暫定的に変更を加えたい場合や、あるインターフェースを実装する時にあえて名前をつけてクラスファイルにするまでもない場合に使う。<br>

〜無名クラスの使い方〜

例↓

まずAのインスタンスを作る際に、{}を追加する。

A a = new A(){}; // ()のあとに{}を追加
System.out.print(a.hello());

クラスAを書き換えずに無名クラスを使ってHello B!と出力させる

A b = new A() {
	// {}の中にメソッドを追加

	// クラスAのhelloメソッドをオーバーライドする
	@Override
	public String hello() {
	//“Hello B!を返す
	return “Hello B!”;
	}
};
System.out.print(b.hello());

〜インターフェイスを実装する無名クラスの使い方〜

無名クラスはクラスだけではなくインターフェイスを実装する時にも使える。

例:先のクラスAに似た、インターフェイスBを作る

public interface B {

　// ()の後に{}を追加
　B b = new B() {
	// helloメソッドを実装
	@Override
   	public String hello() {
		return “Hello B!”;
	}
};
System.out.print(b.hello());

〜無名クラスを使うメリット〜

無名クラスは、システム内で一度しか使わないような処理を実装するケースに向いている。<br>

無名クラスを使う定番のパターン:コレクションの要素をソートする際にComparatorインターフェースを実装する場合、Runnableインターフェースを用いてマルチスレッドプログラミングをする場合<br>

// 並び替え対象のリスト
List<Integer> numbers = Arrays.asList(1, -8, 4, 2);

Collections.sort(
    numbers,
    new Comparator<Integer>() {
      @Override
      public int compare(Integer x, Integer y) {
        // 数値が小さい順に並べる
        return Integer.compare(x, y);
      }
    });

System.out.print(numbers);
