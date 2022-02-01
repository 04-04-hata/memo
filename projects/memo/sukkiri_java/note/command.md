〜命令実行の文〜

命令実行の文の構文:呼び出す命令の名前(引数);

命令の種類<br>
画面に文字を表示する命令<br>
System.out.println(); ←改行あり<br>
System.out.print(); ←改行なし<br>

大きい方の数値を代入する命令:int 変数 = Math.max(①,②);<br>
※①及び②は比較したい値や式<br>

文字列を数値に変換する命令:int 変数 = Integer.parseInt(数値として解釈させたい文字列);<br>

乱数を発生させる命令:int 変数 = new java.util.Random().nextInt(①);<br>
※①は発生させる乱数の上限値。(指定地自体を含まない)<br>

キーボードから1行の文字列の入力を受け付ける命令:String 変数 = new java.util.Scanner(System.in).nextLine();<br>

キーボードから一つの整数の入力を受け付ける命令:int 変数 = new java.util.Scanner(System.in).nextInt();

