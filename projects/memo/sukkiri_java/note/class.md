〜複数のクラスに分けて開発する〜

例:足し算と引き算をするプログラム<br>
public class CalcLogic {<br>
  public static int tasu(int a, int b) {<br>
    return (a + b);<br>
  }<br>
  public static int hiku(int a, int b) {<br>
    return (a - b);<br>
  }<br>
}<br>

public class Calc {<br>
  public static void main(String[] args) {<br>
    int a = 10;<br>
    int b = 2;<br>
    // ↑引数に使うための変数を用意<br>
    int total = CalcLogic.tasu(a, b);<br>
    int delta = CalcLogic.hiku(a, b);<br>
    // tasuとhikuはCalcLogicクラス(別のソースファイル)にある為、クラス名.メソッド名(引数, 引数)を指定する。<br>
    System.out.println("足すと" + total + "、引くと" + delta);<br>
  }<br>
}<br>

手順1:まず計算用のメソッドが詰め込まれたクラス・CalcLogicを作る<br>
手順2:足し算用のメソッド・tasuと引き算用のメソッド・hikuをCalcLogicクラス内に作る。<br>
手順3:mainメソッド(実行用ファイル)を入れるクラス・Calcを作る。<br>
手順4:mainメソッド内に処理を書く。<br>

別のクラスからメソッドを呼び出す方法<br>
クラス名.メソッド名(引数, 引数)<br>
※.は〜のという意味。