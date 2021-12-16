/*

~for文について~

for文…while文と同じ様に指定の条件がtrueの間ループ処理をする制御文。
主に指定した回数文ループして処理を行いたい時に使用する。

基本構文↓
for (初期化式; 条件式; 変化式)　{
  ブロック(ループ処理)
}

*/

public class For01 {
  public static void main(String[] args) {
    for (int number = 1; number <= 5; number++){
      System.out.println("For01 = " + number);
    }
  }
}