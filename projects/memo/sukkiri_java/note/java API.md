〜APIについて〜

API…javaにはじめから標準添付されているクラス。<br>
およそ200を超えるパッケージ、3500を超える多くのクラスが標準装備されている。<br>
開発者はそれらのクラスを自由に利用する事ができる。<br>

例:5つの要素を持つint型配列に入っている5つの整数を並び替えるプログラム<br>

public class sort {<br>
  public static void main(String[] args) {<br>
    int[] heights = {172, 149, 152, 191, 155};<br>
    java.util.Arrays.sort(heights); // javaが備える並び替え命令を呼び出している<br>
    for (int h : heights) {<br>
      System.out.println(h);<br>
    }<br>
  }<br>
}<br>

〜APIで提供されるパッケージ〜

java.lang javaに欠かせない、重要なクラス群<br>
java.until プログラミングを便利にする様々なクラス群<br>
java.math 数学に関するクラス群<br>
java.net ネットワーク通信などを行う為のクラス群<br>
java.io ファイル読み書きなど、データを逐次処理する為のクラス群<br>

java.langパッケージに属するクラスは頻繁に利用するものが多いので、import文を記述しなくても自動的にインポートされる<br>
java.langパッケージに属する代表的なクラスとしては、System、Integer、Math、Object、String、Runtimeなどがある。<br>
今までずっと画面への表示で使ってきたSystem.out.println()のSystemはjava.lang.Systemクラス。<br>

APIリファレンス…APIの説明書。javaが提供してくれている膨大な数のAPIクラスを調べるために使う。<br>