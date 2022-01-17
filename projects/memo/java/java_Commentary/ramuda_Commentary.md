〜ラムダ式について〜

ラムダ式…関数型言語のような記述を可能にする記法。

〜関数型インターフェース〜

関数型インターフェース…実装すべき抽象メソッドが一つしかないインターフェースの事。<br>

// インターフェースA
@FunctionalInterface
public interface A {
  public String hello();
}

// インターフェースB
public interface B {
  public String hello();
  public String goodbye();  // 抽象メソッドが2つあるので、関数型インターフェースではない
}

// インターフェースA
public interface A {
  public String hello();
  public static String hi() { // 抽象メソッドは1つしかないので、関数型インターフェース
    return "Hi!";
  }
}

ラムダ式のポイント
- メソッドが一つの関数型インターフェースにおいては、インターフェースを特定すればメソッドも必ず特定される
- 関数型インターフェースであると明示するための@FunctionalInterfaceというアノテーションが用意されている

<br>

〜関数型インターフェースとラムダ式〜

ラムダ式の基本形↓

(引数) -> {処理}

※ラムダ式だけを書いても文とは看做されないため、メソッドの引数として渡したり、変数に格納したりする必要がある。<br>

〜関数型インターフェースを作る〜

例:Greetingというインターフェースに、実装すべきメソッドを一つだけ用意する。

@FunctionalInterface
public interface Greeting {
  public String hello();

 Greeting greeting = () -> {
	return "こんにちは";
 };
}

↑ラムダ式を使ってhelloを実装している

今回は引数が無いため()だけ書き、先と同様に{}無いに実装を書けば完了。<br>
Greetingは引数の型としても使う事ができるので、↓のようなメソッドも用意出来る
<br>

public static void sayHello(Greeting g) { // 引数で渡す Greeting の実装によって、sayHelloの挙動も変わる
  System.out.print(g.hello()); // このような、g.helloを用いた何らかの処理を書く
}
<br>

〜メソッド参照〜

例:helloメソッドが文字列の引数を取る場合を考える

@FunctionalInterface
public interface Greeting {
  public String hello(String word);

  Greeting greeting = (String word) -> {
  System.out.print(word);
  };
// ラムダ式を使って引数を出力する実装をする↑
}
<br>

メソッド参照という仕組みを使うと↑は以下のように↓書くことも出来る

Greeting greeting = System.out::print;

<br>

ラムダ式の中で呼び出すメソッドが一つだけの場合、ラムダ式を使わずとも
上記のようにクラスとメソッド名を指定することで直接使う事が出来る。<br>

〜ラムダ式の省略記法〜

ラムダ式の基本形は(引数) -> {処理} だが、条件に応じ省略した記法を用いる事が出来る。

例1↓

// サンプル1
(Integer x, Integer y) -> {
  return x + y;
};

<br>例2↓

// サンプル2
(Integer x) -> {
  return x * 5;
};

<br>

※引数の型は省略出来る↓

// サンプル1
(x, y) -> {
  return x + y;
};

{}とreturn…{}内の処理が１行の場合、{}とreturnは省略出来る。ただし、片方のみならず両方とも省略する必要がある。<br>

// サンプル1
(Integer x, Integer y) -> x + y;

()…()は引数が一つの場合、型とともに省略出来る↓

// サンプル2
x -> {
  return x * 5;
};

<br>
例:複数の省略ルールを適用

// サンプル1 {}と型とreturnを省略
(x, y) -> x + y;

<br>
// サンプル2 ()と{}とreturnと型を省略
x -> x * 5;
