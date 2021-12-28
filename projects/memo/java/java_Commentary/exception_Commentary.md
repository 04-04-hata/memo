〜例外処理について〜

例外…プログラム実行中に発生する予想しない事象(エラー)の事。<br>

例外処理…例外が発生した時に実行する処理の事。<br>
例外処理の記述がない場合は、エラーメッセージを出力してプログラムが終了する。<br>

例外の種類

全ての例外関連のクラスは、Throwable(スローアブル)クラスを継承したサブクラス。<br>
サブクラスとは、大元のクラスを企業とすれば、サブクラスはその企業の傘下みたいな感じ?<br>

Errorクラス…例外処理を記述すべきではない、致命的なエラーを表すクラス。<br>
メモリ不足になった時に発生するOutOfMemoryErrorクラスなどがある。<br>

Exceptionクラス(RuntimeExceptionクラス以外)…例外処理を記述する必要がある、一般的な例外を表すクラス。存在しないファイルにアクセスした時に発生するFileNotFoundExceptionクラスなどがある。<br>

RuntimeExceptionクラス…例外処理を記述しなくてもコンパイルエラーにならない、プログラム実行中に発生する例外を表すクラス。RuntimeExceptionが発生する原因の多くは考慮不足や実装漏れによるもの。所謂バグ。<br>

〜例外処理の書き方〜

try-catch文(try-catch-finally文)の基本構文↓<br>

try{<br>
  tryブロック(例外が発生する可能性がある処理)<br>
} catch (例外クラス 変数名) {<br>
  catchブロック(例外が発生した時に実行する処理) {<br>
  } finally {<br>
    finallyブロック(例外発生の有無に関わらず必ず実行する処理)<br>
  }<br>
}<br>

try文<br>
tryブロックには、例外が発生する可能性がある処理を記述する。<br>
※try文は必ず記述すること。<br>

catch文<br>
catchブロックには、例外が発生した時に実行する処理を記述する。<br>
tryブロックで発生した例外のクラスとcatch文に記述した例外クラスの型が一致した場合、そのcatch文のブロックの処理が実行される。<br>
catch文は、例外ごとに処理するが愛は複数記述することも出来る。<br>
実行する例外処理がなければ記述する必要はない。<br>

finally文<br>
finallyブロックに、例外発生の有無に関わらず必ず実行する処理を記述する。<br>
finally文も必ず実行する処理がなければ記述する必要はない。<br>

throw文…意図的に例外を発生させたい場合に使用する。<br>

基本構文↓<br>

throw 例外インスタンス;<br>

もしくは↓<br>

throw new 例外クラス;<br>

throws文…例外が発生した場合にcatch文を記述してメソッド内で例外処理するのではなく、例外をスローして呼び出し元に例外処理させたい場合に使用する。<br>
要は、throw文ではmainメソッドで例外をスローするが、throws文では独自メソッドで例外をスローするかの違い…かな?<br>

基本構文↓<br>

修飾子 戻り値の型 メソッド名(引数) throws 例外クラスの型 {<br>
  //処理<br>
  return 戻り値;<br>
}<br>

メソッド構文の後ろにthrows文を記述する。スローする例外クラスの型は、<br>
,(カンマ)区切りで複数指定出来る。<br>

〜例外クラスの定義〜

javaで予め用意されているもの以外に、自分で例外クラスを定義することも出来る。<br>

例↓<br>
// 独自の例外クラス<br>
public class MyException extends Exception { // Exceptionクラスを継承<br>
  // 引数なしのコンストラクタ<br>
  public MyException() {<br>
  }<br>

  // エラーメッセージを受け取るコンストラクタ<br>
  public MyException(String message) {<br>
    super(message);<br>
  }<br>

  // エラーメッセージおよび発生した例外オブジェクトを受け取るコンストラクタ<br>
  public MyException(String message, Throwable cause) {<br>
    super(message, cause);<br>
  }<br>

  // エラー内容を出力するメソッド<br>
  public void printError(String content) {<br>
    System.out.print("エラーが発生しました:" + content);<br>
  }<br>
}<br>

