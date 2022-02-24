〜引数について〜

引数…メソッドを呼び出す際に、呼び出し元から渡す値。<br>
呼び出されたメソッド側では、渡された値(引数)を受け取って処理に使用する事が出来る。<br>
引数には数値や文字列などを指定でき、その値や型、渡す引数の数は自由に決めれる。<br>

例<br>
public static void main(String[] args) {<br>
  System.out.println("メソッドを呼び出します");<br>
  hello("愛歌"); // hello()の()内に「愛歌」を入れることで、愛歌 = nameとなる<br>
  hello("綾香"); // hello()の()内に「綾香」を入れることで、綾香 = nameとなる<br>
  System.out.println("メソッドの呼び出しが終わりました");<br>
}<br>

public static void hello(String name) {<br>
  System.out.println(name + "さん、こんにちは");<br>
  // helloメソッドを呼び出す際に渡した値(引数) = nameとなる。<br>
}<br>

例:引数(渡す値が複数の場合)<br>
public static void main(String[] args) {<br>
  add(100, 20);<br>
  // add()の()内に100と20を渡す事で、x = 100、y = 20となる<br>
  add(200, 50);<br>
  // add()の()内に200と50を渡す事で、x = 200、y = 50となる<br>
}<br>

public static void add(int x, int y) {<br>
  int ans = x + y;<br>
  System.out.println(x + "+" + y + "=" + ans);<br>
  // addメソッドを呼び出す際に渡した値(引数) = x(左)、y(右)となる<br>
}<br>

引数の渡し方<br>
- 何も渡さない場合:メソッド名()
- 値を一つ渡す場合:メソッド名(値)
- 値を複数渡す場合:メソッド名(値, 値…)

引数の与え方<br>
- 引数が一つの場合:メソッド名(型 引数名)
- 引数が複数の場合:メソッド名(型 引数名, 型 引数名…)

仮引数と実引数<br>

実引数…渡す値の事。メソッド名(値)の()の値が実引数である。<br>

仮引数…受け取る引数の事。メソッド名(型 引数名)の引数名が仮引数。<br>

ローカル変数について<br>

ローカル変数…main()やadd()といったメソッド内で宣言した変数の事。<br>
仮引数もローカル変数の一種。<br>
別のメソッドに属する同名のローカル変数とは全くの別物。<br>