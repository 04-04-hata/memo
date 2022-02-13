〜配列について〜

配列…同一種類の複数データを並び順で格納するデータ構造。<br>
箱の中身を要素、箱を識別する番号を添字という。<br>
添字は、0から始まり、最後の添字は要素数より一小さい。<br>
配列の各要素には同一種類のデータしか格納出来ないので、
0番目の要素にはStringのデータを、1番目の要素にはintのデータを入れると言ったことは出来ない。<br>
int型ならint型のデータしか入れる事が出来ない。<br>

配列の作成<br>
1.配列変数の宣言<br>
要素の型[] 配列変数名<br>
例:int[] scores;<br>

2.要素の作成と代入<br>
要素を作成して宣言した配列変数に代入。<br>
例:int型の要素を5個作り、配列変数scoresに代入する<br>
scores = new int[5];<br>

上記↑2つをまとめる事もできる。<br>
int[] scores = new int[5];<br>

newはnew演算子と呼ばれるもので、指定された型の要素を[]内に指定された数だけ作成する。<br>
作成された要素は、代入演算子(=)で配列変数に代入する事が出来る。<br>

配列の要素数の取得:配列変数名.length<br>

配列の要素に値を代入<br>
例↓<br>
int scores = new int[5];<br>
scores[1] = 30; // 2つ目の要素scores[1]に代入。(添字は0から始まる為、添字1の要素は2つ目の要素となる。)<br>
System.out.println(scores[1]); // 2つ目の要素scores[1]の中身を表示<br>

配列の初期化<br>
配列の要素は初期化しないとコンパイルエラーになるが、自動的に初期化されるのでエラーにはならない。<br>
要素がどのような値で初期化されるかは、要素の方によって決められている。<br>

intやdoubleなどの数値の型:0<br>
boolean型:false<br>

配列の作成と初期値の代入までをまとめて行う方法↓<br>

1.要素の型[] 配列変数名 = new 要素の型[] {値1, 値2, 値3, …};<br>

2.要素の型[] 配列変数名 = {値1, 値2, 値3, …};<br>

for文を使う配列の扱い方<br>

1.forループで配列を回す<br>
for (int i = 0; i < 配列変数名.length; i++) {<br>
  配列変数名[i]を使った処理<br>
}<br>

例↓<br>
int[] scores = [20, 30, 40, 50, 80];<br>
for (int = 0; i < scores.length; i++) {<br>
  System.out.println(scores[i]);<br>
}<br>

2.ループによる集計<br>
int[] scores = [20, 30, 40, 50, 80];<br>
int sum = 0; //集計結果を入れる為の変数を初期化して準備<br>
for (int = 0; i < scores.length; i++) {<br>
  sum += scores[i]; //一科目ずつ変数sumに合算する<br>
}<br>

カウント集計<br>
int[] scores = [20, 30, 40, 50, 80];<br>
int count = 0;
for (int = 0; i < scores.length; i++) {<br>
  if (scores[i] >= 50) {<br>
    count++;<br>
  }<br>
// if文の中身は条件に合致する要素があればカウントする<br>
}<br>

3.添字に対応した情報の利用<br>
例:DNAの記号をランダムに表示する<br>
int seq[] = new int[10];<br>
// ↑DNAの記号をランダムに10個表示する為の変数を用意する<br>
char[] base = {'A', 'T', 'G', 'C'};<br>
// ↑DNAの記号のデータが入った配列を用意する<br>

for (int i = 0; i < seq.length; i++) {<br>
  seq[i] = new java.util.Random().nextInt(4);<br>
  // ↑baseの添字をループさせる(添字0〜3まで数える為の配列変数)<br>
  System.out.println(base[seq[i]] + " ");<br>
  // ↑baseのデータをseq分(10個)表示する(DNAの記号をランダムに10個表示する)<br>
}<br>

拡張for文(配列専用のループ文)<br>
for (要素の型 任意の変数名 : 配列変数名) {<br>

}<br>

拡張for文ではループが一周するたびに「任意の変数名」に指定した変数に配列の要素の内容が格納される。<br>

例↓<br>
int[] scores = [20, 30, 40, 50, 80];<br>
for (int value : scores) {<br>
// ↑変数valueに配列変数scoresのデータが入ってる<br>
  System.out.println(value);<br>
// ↑valueの中身を表示する<br>
}<br>