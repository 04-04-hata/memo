/*
〜while文について〜

while文…指定した条件がtrueの間、ループ処理を行う制御文。
先に条件式を評価して結果がtrueの場合はブロック内の処理を実行する。
ブロック内の処理が完了した後に、再度条件式を評価して結果がfalseになるまで
ブロック内の処理を繰り返し実行する。

基本構文↓
while (条件式){
  ブロック(ループ処理)
}

*/

public class While01 {
  public static void main(String[] args){
    int number = 100;
    // numberが50未満の間、ブロックの処理を行う
    while (number < 50){
      number *= 2;
      System.out.println("While01= " + number);
    }
  }
}