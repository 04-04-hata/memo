〜メソッドとは〜

Javaをはじめとする多くのプログラミング言語では、一つのプログラムを複数の部品に分けて作る事ができる仕組みを備えている。<br>
メソッドは、複数の文をまとめ、それを一つの処理として名前をつけたもので、部品の最小単位になる。<br>

メソッド利用によるメリット<br>
- プログラムの見通しが良くなり、全体を把握しやすくなる。
- 機能単位に記述するため、修正範囲を限定出来る
- 同じ処理を一つのメソッドにまとめる事で、作業効率が上がる<br>

メソッドを使用するにはまずメソッドを作成し、作成したメソッドを使用するという二つの工程が必要。<br>
メソッドを作成する事をメソッドの定義といい、クラスブロックでは以下の構文↓を使用する。<br>

メソッドの定義<br>
public static 戻り値の型 メソッド名(引数) {<br>
  メソッドが呼び出された時に実行される具体的な処理<br>
}<br>

例<br>
public static void hello() { // helloというメソッド名(メソッドの定義)<br>
  System.out.println("こんにちは"); // helloメソッドが呼び出された時の処理<br>
}<br>

メソッドの呼び出し(メソッドを使用する)<br>
メソッド名(引数)<br>

例<br>
public static void main(String[] args) {<br>
  System.out.println("メソッドを呼び出します"); // mainメソッドが先に実行される<br>
  hello(); // helloメソッドを呼び出す<br>
  System.out.println("メソッドの呼び出しが終わりました"); // 呼び出されたメソッドの処理が終了すると、メソッドの呼び出し元に戻って処理の続きが実行されていく<br>
}<br>

public static void hello() { // helloというメソッド名(メソッドの定義)<br>
  System.out.println("こんにちは"); // helloメソッドが呼び出された時の処理<br>
}<br>

mainメソッド以外からのメソッドの呼び出し<br>
メソッドはmainメソッド以外のメソッドからも呼び出す事ができる。<br>

例<br>
public static void methodA() {<br>
  System.out.println("methodA");<br>
  methodB();<br>
  // methodAという文字列を出力してからmethodBを呼び出している<br>
}<br>

public static void methodB() {<br>
  System.out.println("methodB");<br>
}<br>

public static void main(String[] args) {<br>
  methodA(); // methodAを呼び出しているため、methodAの処理が実行される<br>
}<br>