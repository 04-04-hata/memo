〜TypeScriptとは〜<br>

- マイクロソフトが開発したスクリプト言語
- オープンソース
- TypeScriptのソースコードはJavaScriptのソースコードにコンパイル(変換)される

※ オープンソース…ソースコードがはっきりしていて、誰でも見れる事。<br>

TypeScriptの基本的な文法はJavaScriptと同じだが、以下のような点が追加されている。<br>

- 変数のデータ型を予め決めておける
- クラスを簡単に記述できる
- 一つの関数定義で異なるデータ型の引数を処理できる
- 引数の文字列によって異なる関数を実行できる

TypeScriptのコードの説明<br>

例:alert("Hello TypeScript");<br>

alert…ポップアップの警告文を出すメソッド(命令)。<br>
結果:Hello TypeScriptと書かれた警告文がポップアップで出る<br>

上記のコード↑で分かること<br>

- alertメソッドで表示する内容は()に囲んで指定してある
- 「Hello TypeScript」という文字列は引用符""で囲まれている
- 文の終わりには;が付けられている

解説
メソッドは命令のようなものだが、命令を実行する時には何らかのデータを与える事が出来る。<br>
()の中に書かれたものがメソッドに与えるデータで、引数と呼ぶ。<br>

決まり事
文字列は引用符""で囲む。<br>
"123"と書けば文字列として扱われるが、「123」と書けば数値として扱われる。<br>

文の終わりには;を付ける。<br>

〜TypeScriptとJavaScriptを見比べる〜<br>

TypeScriptとJavaScriptの違い<br>

- 変数のデータ型を予め決めておける
- クラスを簡単に記述出来る

例<br>
var Message:string;<br>
Message = "Hello TypeScript";<br>
alert(Message);<br>

解説<br>
var…変数を宣言する為に使うキーワード。<br>
Messageが変数名。<br>
Stringがデータ型。<br>

Javaだと、<br>
String Message = "Hello TypeScript";<br>
となる。<br>

比較
TypeScriptでは、変数のデータ型を:の後に指定出来る。<br>
JavaScriptではデータ型が指定されていない。<br>

TypeScriptのコード↓<br>
var Message:string;<br>
Message = "うんこ"<br>
alert(Message);<br>

JavaScriptのコード↓<br>
var Message;<br>
Message = "うんこ";<br>
alert(Message);<br>

TypeScriptでは予め変数のデータ型を指定しておけるが、<br>
JavaScriptでは実行時にどのようなデータが入れられるかによってデータ型が決まる<br>

クラスの定義<br>

TypeScriptのコード<br>

var Message:string;<br>
class Cat{<br>
    age:number;<br>
    weight:number;<br>
}<br>
var myCat = new Cat();<br>
myCat.age = 3;<br>
myCat.weight = 5.1;<br>
Message = "うちの猫は" + myCat.age + "歳で、体重は" + myCat.weight + "kgです";<br>
alert(Message);<br>

解説<br>
var Message:string;<br>
変数の定義。Messageという変数は文字列型だと定義<br>
class Cat{<br>
    age:number;<br>
    weight:number;<br>
}<br>
クラスの定義。<br>
Catクラスで使われる変数ageとweightは数字型と定義している<br>
var myCat = new Cat();<br>
クラスからオブジェクトの作成。
仮想世界にCat(オブジェクト)を生み出している。その際の変数名はmyCat。<br>
Message = "うちの猫は" + myCat.age + "歳で、体重は" + myCat.weight + "kgです";<br>
alert(Message);<br>
クラスのメンバーの利用。<br>
私が作成したJavaのコードだとCatクラスに書かれたMessage()メソッドを
Mainの方で出力する形になっている。<br>

※メンバー…フィールドとメソッドの事。<br>
Javaだとthis.変数がフィールドとなる。<br>
例だとMessageメソッドとmyCat.変数がメンバーとなる。<br>

JavaScriptのコード<br>

var Message;<br>
class Cat {<br>
}<br>
var myCat = new Cat();<br>
myCat.age = 3;<br>
myCat.weight = 5.1;<br>
Message = "うちの猫は" + myCat.age + "歳で、体重は" + myCat.weight + "kgです";
alert(Message);<br>

Javaのコード<br>

クラス側<br>
public class Cat {<br>
	int age;
	double weight;
	
	public void Message() {
		System.out.println("うちの猫は" + this.age + "歳で、体重は" + this.weight + "kgです");
	}
}<br>

実行側<br>
public class Main {<br>
	public static void main(String[] args) {
		Cat myCat = new Cat();
		
		myCat.age = 3;
		myCat.weight = 5.1;
		
		myCat.Message();
	}
}<br>



