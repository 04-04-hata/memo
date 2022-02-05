〜switch文について〜

switch文…条件分岐の一種。
全ての条件式が左辺と右辺が一致するかを比較する式の時に使うことが出来る。<br>

switch文に書き換えることができる条件<br>
- 全ての条件式が「変数 == 値」や「変数 == 変数」のように左辺と右辺が一致するかを比較する式になっており、それ以外の「＞」や「＜」あるいは「!=」などが使われていない。
- 比較する値が整数(byte型、short型、int型のいずれか)、文字列(String型)または文字(char型)であり、小数や真偽値ではない。

switch文記述の際の注意点<br>
- switchの直後に書くのは、条件式(fortune == 1など)ではなく、変数名(今回はfortune)。
- caseの横には値を書き、その後ろには:を記述する。
- case以降の処理の末尾にはbreak文を記述する。
- defaultは条件に合致しない時の処理が不要な場合は省略可能。

例↓<br>
System.out.println("あなたの運勢を占います");
int fortune = new java.util.Random().nextInt(5) + 1; // 普通なら0〜4までの数字しか出ないが、+ 1を付け加えることによって1〜5の数字が出る(例:0 + 1や4 + 1)
switch (fortune) {
  case 1:
  case 2:
    System.out.println("いいね!");
    break;
  case 3:
    System.out.println("普通です");
    break;
  case 4:
  case 5:
    System.out.println("うーん…");
}

※break文を書かないと、次のcase文のブロックに進み、処理が実行されてしまうので注意。
(switch文は条件に一致するcaseラベル(case 値:の事)まで処理をジャンプさせる命令に過ぎないので、break文で明示的に処理を中断してswitch文を抜けるという指示がない限り、
次のcase文に処理が進んでしまう。)
上記のswitch文の例↑だと、最後の条件(case4とcase5)の処理にbreak文を書かなくてもランダムに一つの処理が実行される。