〜オーバーロードについて〜

オーバーロード…同じ名前のメソッドを定義する事。<br>
仮引数(型 引数名)が異なったり、個数が違う場合は同じ名前のメソッドを複数定義する事が出来る。<br>
引数は同じで、戻り値の型だけが異なるものは定義出来ない<br>


例:引数の型が異なる場合<br>

public static int add(int x, int y) {<br>
  return x + y;<br>
}<br>

public static double add(double x, double y) {<br>
  return x + y;<br>
}<br>

public static String add(String x, String y) {<br>
  return x + y;<br>
}<br>

public static void main(String[] args) {<br>
  System.out.println(add(10, 20));<br>
  // int型のaddメソッドが呼び出される<br>
  System.out.println(add(3.5, 2.7));<br>
  // double型のaddメソッドが呼び出される<br>
  System.out.println(add("Hello", "World"));<br>
  // String型のaddメソッドが呼び出される<br>
}<br>

例:引数の個数が違う場合<br>

public static int add(int x, int y) {<br>
  return x + y;<br>
}<br>

public static int add(int x, int y, int z) {<br>
  return x + y + z;<br>
}<br>

public static void main(String[] args) {<br>
  System.out.println("10 + 20 = " + add(10, 20));<br>
  // 引数が2個のaddメソッドが呼び出される<br>
  System.out.println("10 + 20 + 30 = " + add(10, 20, 30));
  // 引数が3個のaddメソッドが呼び出される<br>
}<br>