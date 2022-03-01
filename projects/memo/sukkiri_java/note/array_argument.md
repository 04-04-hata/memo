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