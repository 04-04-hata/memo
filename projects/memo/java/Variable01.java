/*
javac javaのファイル名.java　でjavaファイルをコンパイルする。
コンパイルは、プログラムの翻訳みたいなもん。
コンパイルが成功するとjavaのクラス名.classというファイルが作成される。
このファイルをクラスファイルという。
作成されたクラスファイルを実行するには、
java クラス名
↑とする。
*/

/*
クラス…鯖で例えるとセイバーとかランサーとかあんなん。
クラス名とjavaファイル名(.java)は一致していなければならない。
public class クラス名で始まる。
*/

/*
メソッド…鯖で例えると宝具とかそんなん。
public static void main(String[] args)で始まる
*/

/*
メソッドの処理…宝具(メソッド)の内容を書く。
例えば、青王ならエクスカリバーからビーム放つとか
*/

/*
変数宣言…javaでは、使う変数を最初に宣言する必要がある。
変数とは中身を入れておく箱で、型を決めておく必要がある。
型はその変数がどのような形なのかを決める為のもの。
型 変数名 = 代入するデータ(箱の中身)で宣言と初期化を同時に出来る。
*/

/*
変数の初期化…変数にどんな中身を入れておくか決める事。
箱の中身を変えることが出来るのが変数で、
一度決めたら中身を変えることが出来ないのが定数。
定数の宣言は↓下記のようにする。
final 定数の型 定数名 = 初期値;
定数の中身を変える(再代入)するとエラーになる。
変数は小文字、定数は大文字にすると区別しやすい。
*/

public class Variable01 {
  public static void main(String[] args){
    int num1; // int(数字型)の変数num1を宣言
    String str1; // String(文字列)の変数str1を宣言
    num1 = 10; // num1を初期化
    str1 = "Hello World!"; // str1を初期化
    System.out.println(num1);
    System.out.println(str1);

    num1 = 20; // num1に20を再代入
    System.out.println(num1);

    int num2 = 30; // int型の変数num2を宣言と同時に初期化
    System.out.println(num2);

    final int MIN_NUMBER = 10;
    System.out.println(MIN_NUMBER);
  }
}