/*

〜do while文について〜

do while文…while文と同じように指定の条件がtrueの間ループ処理を
行う制御文。while文と違うのは、まずブロックの処理を実行し、処理が完了した後に条件式を評価するので
条件式の結果がfalseでも最低1回はブロックの処理が実行される。
結果がtrueの場合はまた最初からブロック内の処理を実行して結果がfalseになるまで
ループする。

基本構文↓
do {
  ブロック(ループ処理)
}　while (条件式);

*/

public class DoWhile01 {
  public static void main(String[] args){
    int number = 100;
    // do while文:ループ開始
    do {
      number *= 2;
      System.out.println("DoWhile01 = " + number);
    } while (number < 50);
  }
}