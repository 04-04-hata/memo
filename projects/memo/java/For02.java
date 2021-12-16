/*

〜拡張for文について〜

拡張for文…配列やコレクションの全要素に対して、ループ処理を行う制御文。

基本構文↓
for (型　変数名:配列やコレクションの変数) {
  ブロック(繰り返し処理)
}

配列やコレクションの変数の要素を順番に取得し、指定した型の変数に代入しながら
ブロック内の処理を行う。
拡張for文は、条件式と変化式を記述しない為、通常のfor文に比べ、プログラムを簡潔に記述出来る。

*/

public class For02 {
  public static void main(String[] args){
    int[] array = { 1, 2, 3, 4, 5 };
    // ↓int型の変数numberにarrayの中の要素を入れる
    for (int number : array){
      // 変数numberの中身を表示する↓
      System.out.println("For02 = " + number);
    }
  }
}