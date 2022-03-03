〜引数や戻り値に配列を用いる〜

メソッドの引数には↓のように配列も使う事が出来る。<br>

public class Array {<br>
  // ↓int型配列を受け取り、すべての要素を表示するメソッド<br>
  public static void printArray(int[] array) {<br>
    for (int element : array) {<br>
      System.out.println(element);<br>
    }<br>
  }<br>

  public static void main(String[] args) {<br>
    int[] array = {1, 2, 3};<br>
    printArray(array); // 配列を渡す<br>
  }<br>
}<br>

int[]型のような配列型の変数には、配列の実体を指し示すメモリの番地が格納されている。
(要は住所だけ格納されてる)<br>
従って、printArrayメソッドに引数として渡しているのは配列まるごとでは無く、アドレス情報(住所)のみである。<br>

〜値渡しについて〜

値渡し…値そのものが渡される呼び出し。<br>
メソッドを呼び出す時に引数として通常の変数を指定した場合、メソッドに渡されるのは変数ではなく、変数に入っている値。
(正確には、メソッドを呼び出した時点での変数の値が、メソッドの仮引数(メソッド名(型 引数名))にコピーされる)<br>

例↓<br>
public static void methodA(int x) {<br>
  System.out.println(x);<br>
}<br>
public static void main(String[] args) {<br>
  int x = 100;<br>
  methodA(x);<br>
}<br>

上記の例↑の場合、methodAが呼び出される際にmainメソッドの変数xの内容(100)が仮引数xにコピーされる為、
2つの変数の中身は同じ100になる。<br>
しかし、この二つのxは全く別の存在なのでmethodAの中で仮引数xにどんな値を代入しようとも、
呼び出し元であるmainメソッド内の変数xの中身は100のまま変わることはない。<br>

基本型の変数をメソッド呼び出しで渡すと
- 呼び出し元の変数の内容が、呼び出し先の引数にコピーされる
- 呼び出し先で引数の内容を書き換えても、呼び出し元の変数は変化しない

<br>

〜参照渡しについて〜

参照渡し…引数としてアドレスを渡す事。<br>
配列をメソッド呼び出しで渡すと、配列の内容{1, 2, 3}では無く配列の先頭要素のアドレスがコピーされ、
mainメソッド内の変数arrayとprintArrayメソッド内の引数arrayはどちらも配列の先頭要素のアドレス以降にある配列の実体を参照した状態になる。<br>

参照渡しを行うと呼び出し先で加えた変更が呼び出し元にも影響する。<br>
例として、printArrayメソッド内でarray[0]に100を代入し、printArrayメソッドが終了した後にmainメソッド内でarray[0]を取り出すと、100を取り出すことになる。<br>

配列をメソッド呼び出しで渡すと
- 呼び出し元の配列のアドレスが、呼び出し先の引数にコピーされる
- 呼び出し先で配列の実体を書き換えると、呼び出し元(mainメソッド:実行メソッド)にも影響する。

例:戻り値に配列を用いる<br>
public class Array2 {<br>
  public static int[] makeArray(int size) { // int型配列を作成して戻すメソッド<br>
    int[] newArray = new int[size]; // mainメソッドでint[] array = makeArray(3);と指定してるのでnewArrayの要素数は3となる<br>
    for (int i = 0; i < newArray.length; i++) { // newArrayの要素分繰り返す<br>
      newArray[i] = i;<br>
    }// int iが1ならnewArrayのiも1になる<br>
    return newArray; // 配列を戻す<br>
  }<br>

  public static void main(String[] args) {<br>
    int[] array = makeArray(3); // newArrayの要素数は3つと指定してる<br>
    for (int i : array) {<br>
      System.out.println(i); // arrayの全要素を出力<br>
    }<br>
  }<br>
}<br>

return newArray;によって配列の先頭要素のアドレスがmainメソッドに戻される。<br>
mainメソッドでは、それを自身で宣言した配列変数arrayに代入する。<br>
その結果、makeArrayメソッドで作成された配列を参照出来るようになる。