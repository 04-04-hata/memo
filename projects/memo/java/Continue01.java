/*

〜continue文について〜

continue文…ループ処理の途中でそのあとの処理をスキップして
ループ処理の最初から実行させたい場合に使用する制御文。

*/

public class Continue01 {
  public static void main(String[] args){
    for (int count = 0; count < 5; count++) {
      if (count == 2) {
        //countが2の時だけ処理を飛ばす
        continue;
      }
      System.out.println("Continue01 = " + count);
    }
  }
}