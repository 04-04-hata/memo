/*
〜条件分岐について〜

if文…指定した条件により処理を分岐する制御文。

基本構文↓
if (条件式){
  ブロック(処理文);
}
※ブロック…System.out.printlnとかそういうの。命令文。

複数条件がある場合はelse ifやelse文に書く。
elseはどこにも当てはまらない条件の時に使う。特に何もしなければなくてもいい。
基本構文↓
if (条件式){
  ブロック(処理文);
} else if{
  ブロック(処理文);
} else {
  ブロック(処理文);
}

switch文…変数の値を条件にして処理を分岐する制御文。
基本構文↓
switch(式(変数や値)){
  case 値:
       ブロック(処理);
       break;
  case 値:
       ブロック(処理);
       break;
  default:
       ブロック(処理);
}

変数とcaseの値が一致する場合、ブロック内の処理を実行する。
どこにも当てはまらない条件の時はdefault内に書かれた処理をする。
何も処理をしないのであれば書かなくてもいい。

※caseを書く時は必ずbreakを記述する事。
breakを記述しないと無限ループになる。
breakとは、case内の処理を終わらせる命令文の事。
一度breakが起動すればswitch文は強制終了となる。
*/

public class Chapter07 {
  public static void main(String[] args) {
    int distance = 17;

    if (distance <= 5){
      System.out.println("とても近いです");
    } else if (distance > 5 && distance <= 10) {
      System.out.println("近いです");
    } else if (distance > 10 && distance <= 15) {
      System.out.println("遠いです");
    } else {
      System.out.println("とても遠いです");
    }

    String color = "green";

    switch(color){
      case "red":
           System.out.println("赤信号です");
           break;
      case "yellow":
           System.out.println("黄信号です");
           break;
      case "blue":
           System.out.println("青信号です");
           break;
      default:
           System.out.println("信号の色ではありません");
    }
  }
}