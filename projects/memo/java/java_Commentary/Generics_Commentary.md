〜ジェネリクスについて〜

ジェネリクス…型をパラメータとして抽象的に扱う事で、プログラムを汎用的に用いるための仕組み。<br>

〜コレクションでのジェネリクスの使い方〜

Listを生成する際、<>で型情報を付与する事が出来る。これにより、追加する要素の方が限定されるが、ここで活用されているのがジェネリクスの仕組み。<br>

例:String型の要素から成るArrayList↓

import java.util.List;<br>
import java.util.ArrayList;<br>

List<String> items = new ArrayList<String>();

<>に囲まれた型を型パラメーターと呼ぶ。型パラメーターにはプリミティブ型(数値や文字のデータそのものを保持している型)が出来ないので、参照型(データがある場所を保持する型)で宣言する。<br>

型パラメーターにString型以外の要素は追加できなく、要素を取り出して使う際も、異なる型の変数に代入することが出来ない。<br>

↓要素を取り出す際はキャスト(型変換)が出来る<br>

String item1 = (String)items.get(0);<br>

なお、new演算子側の型パラメーターは省略する事が出来る。<>はその形状からダイヤモンド演算子と呼ばれる。<br>

〜ジェネリクスを使ったクラス〜

例題:Basket(籠)というクラスを生成する。籠には特定の型の中身を一つ入れる事が出来、中身を入れ替えても同じ型しか受け付けないものとする。<br>

class Basket<E> {
  private E element; // Eっていう型があるとする。変数はelement

  Basket(E e) {
    element = e;
  }

  void replace(E e) {
    element = e;
  }

  E get() {
    return element;
  }
}<br>

籠の中身としてApple、Peachというクラスを用意する↓<br>

class Apple {
	private String name;

	Apple(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}
}

class Peach {
	private String name;
	
	Peach(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}
}

まずはApple用のBasketを用意する。Listで要素の型を制限した時と同様に、
↓のように宣言する。<br>

Basket<Apple> appleBasket = new Basket<>(new Apple(“ふじ”));
System.out.print(appleBasket.get().getName());

中身を置き換えるために用意したreplaceも使ってみる↓<br>

appleBasket.replace(new Apple(“紅玉”));
System.out.print(appleBasket.get().getName());

一方で、replaceの引数にPeachクラスのインスタンスを渡そうとするとコンパイルエラーになる↓<br>

appleBasket.replace(new Peach(“黄金桃”));

解説:Basket自体にはAppleという型は登場していないが、使用する側が型パラメーターとしてAppleという情報を渡すことで上記のような挙動を実現している。<br>

コンパイル後のBasketクラスは以下のようになっていると考えると分かり易いかもしれない↓<br>

class Basket {
  private Apple element;

  Basket(Apple e) {
    element = e;
  }

  void replace(Apple e) {
    element = e;
  }

  Apple get() {
    return element;
  }
}<br>

AppleやPeachという具体的な型をEとして抽象的に扱い、結果として汎用的に使えるBasketクラスが用意できた。ListやMapの要素を型で限定する仕組みもこれと同様。<br>

〜境界型パラメーター〜

型パラメーターとして受け取れるクラスを特定のインターフェースや抽象クラスを継承(実装)したクラスに限定することも出来る。<br>

AppleやPeachがFruitという抽象クラスを継承しているとして実装してみる↓<br>

abstract class Fruit {
	String name;

	Fruit(String name) {
		this.name = name;
 	}

	abstract protected String getName();
}
<br>

class Apple extends Fruit {
	Apple(String name) {
		super(name);
	}

	@Override
	protected String getName() {
		return name;
	}
}

class Peach extends Fruit {
	Peach(String name) {
		super(name);
	}
	
	@Override
	protected String getName() {
		super(name);
	}
}

<br>
先ほどと同じようにBasket型を用意するが、Fruitのサブクラスしか受け取れないよう、extendsキーワードを用いて以下のように定義する。なお、インターフェースで制限する場合も、implementsではなくextendsと書く。<br>

class Basket<E extends Fruit> {
  private E element;

  Basket(E e) {
    element = e;
  }

  void replace(E e) {
    element = e;
  }

  E get() {
    return element;
  }

  void printName() {
    System.out.print("籠の中身は" + element.getName() + "です"); // EはFruitのサブクラスなので、getNameが使えると保証されている
  }
}

注目していただきたいのは、 getName メソッドを呼び出すコードを含んでいてもコンパイルできることです。もし、 Eがどんなクラスか分からない場合、そのクラスに getNameメソッドが存在するか予め分からないので、メソッドが見つからずコンパイルエラーとなります。しかし、Fruitに抽象メソッド getName が存在する以上、 EはgetNameの実装を持っていることが保証され、コンパイル可能となるのです。<br>

〜境界ワイルドカード〜

境界型パラメーターで?を使う事ができる。<br>

例:Fruitクラスを継承したAppleクラス

import java.util.ArrayList;
import java.util.List;

List<Fruit> fruits = new ArrayList<>();
List<Apple> apples = new ArrayList<>();

↑Fruitを要素にもつListとAppleを要素にもつListを用意する
この時、FruitとAppleには親子関係があるが、List<Fruit>とList<Apple>に親子関係はない。その為、fruitsにapplesを代入しようとするとコンパイルエラーになる。
<br>

↓代入だけでなく、List<Fruit>を引数にもつメソッドの利用も出来ない<br>
void doSomething(List<Fruit> fruits) {
  // 何らかの処理
}

doSomething(apples); // コンパイルエラー
<br>

ここで活用できるのがワイルドカード。?を使ってFruitを継承したクラスであれば要素として認めるコードを書く事ができる。↓<br>

List<? extend Fruit> fruits; // 型パラメータとして、Fruitを継承したクラスを指定
List<Apple> apples = new ArrayList<>();

fruits = apples;// コンパイルエラーにならない
<br>
void doSomething(List<? extends Fruit> fruits) {  // 型パラメータとして、Fruitを継承したクラスを指定
  // 何らかの処理
}

doSomething(apples); // コンパイルエラーにならない
<br>
Fruitを継承した要素を持つList用に共通するロジックを用意したい場合などには便利。
