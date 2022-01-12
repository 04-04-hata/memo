API…アプリケーションプログラミングインターフェースの略。何かしらの機能をアプリケーションから簡単に呼び出せるようにした仕様の事。

〜コレクションについて〜

コレクションAPI…オブジェクトの集合を管理、操作するためのJava標準のAPI。
このオブジェクトの集合をコレクション、コレクションの中身一つ一つを要素という。<br>

〜Listについて〜

List…配列と同じようにインデックス番号の順序に要素(オブジェクト)を管理するコレクション。重複した要素を保持する事が出来る。配列との違いは、オブジェクト生成時に要素数の指定は必要なく、要素を追加・削除するたびにサイズが増減する事。<br>

Listはインターフェース(定数と抽象メソッドだけを持つクラスのようなもの)なので、使用する場合はListを実装しているクラスを使用する必要がある。Listを実装しているクラスにはArrayListやLinkedListなどがある。<br>

〜Listの生成〜

実装したいクラスによって異なるが、生成は↓以下のように行う。<br>

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// ArrayListを生成する場合
List<String> list1 = new ArrayList<String>();

// LinkedListを生成する場合
List<Integer> list2 = new LinkedList<Integer>();

〜Listの操作〜

要素の追加<br>
要素を追加するにはaddメソッドを使う。位置を指定できるが、指定しなかった場合は末尾に要素が追加される。 <br>

例↓<br>

// 要素を追加する
list1.add("りんご");<br>
list1.add("みかん");<br>

// 位置を指定して要素を追加する
list1.add(1, "バナナ");<br>

↑はりんご、バナナ、みかんの順に要素を持つ。<br>

※位置を指定する際は要素数より大きくならないように注意。コンパイルエラーになる。<br>

要素の取得<br>
要素を取得するにはgetメソッドを使う。<br>

// 要素を取得する
list1.get(0);<br>

要素の存在チェック<br>
ある要素がリストに含まれるか確認するにはcontainsメソッドを使う。戻り値はboolean。<br>

// 存在チェック (trueを返す)
list1.contains("バナナ");<br>

// 存在チェック (falseを返す)
list1.contains("なし”);<br>

要素数の取得<br>
コレクションの要素数の合計を取得するには、sizeメソッドを使う。<br>

list1.size(); // 3を返す<br>

要素の削除<br>
要素を削除するにはremoveメソッドを使う。要素の中身か位置を指定できるが、存在しない中身を指定すると何もせず、エラーも発生しない。<br>
一方、位置を指定する際は、要素数より大きい数にするとエラーが発生する。<br>

// 要素を削除する (要素が文字列の場合、文字列として同じであれば削除されます)<br>
list1.remove("バナナ");<br>
list1.remove("なし"); // 何もしない<br>

// 位置を指定して要素を削除する<br>
list1.remove(0);<br>
list1.remove(5); // コレクションの要素数より大きい位置を指定すると実行時エラー<br>

〜ArrayListとLinkedList〜
- インデックス指定で要素を取り出すのはArrayListの方が速い
- 先頭から順に処理をするのはArrayListの方が速い
- 要素の挿入はLinkedListの方が速い
- 要素の削除はLinkedListの方が速い

〜MAP~

MAP…キーと値の組み合わせで要素を管理するコレクション。<br>
MAPは一つのキーに対して一つの値が存在するため、キーは重複して持つ事ができないが、値は重複して持つ事ができる。追加した要素の順番は保証されない。<br>
MAPもList同様にインターフェースの為、HashMapやTreeMapなどのMapを実装したクラスを使用する必要がある。<br>

Mapの生成

import java.util.HashMap;<br>
import java.util.Map;<br>
import java.util.TreeMap;<br>

// HashMapを生成する場合<br>
Map<Integer, String> map1 = new HashMap<Integer, String>();

// TreeMapを生成する場合<br>
Map<String, String> map2 = new TreeMap<String, String>();

<br>

要素の追加<br>
要素を追加するにはputメソッドを使う。既に追加済みのキーを用いると後から追加した値で上書きされる。<br>

// 要素を追加する<br>
map1.put(0, "ぶどう");
map1.put(3, "もも");

// 登録済みのキーで追加すると上書きされる<br>
map1.put(0, "マスカット");

<br>
要素の取得<br>
要素を取得するにはgetメソッドを使う。存在しないキーを指定した場合は戻り値がnullになる。<br>

// 要素を取得する
map1.get(0); // マスカットを返す
map1.get(1); // nullを返す

<br>

要素の存在チェック
ある要素が含まれる確認するにはcontainsKeyやcontainsValueを使う。<br>
キーと値のチェックが出来るメソッドで、戻り値はboolean。<br>

// キーの存在チェック (trueを返す)
map1.containsKey(0);

// 値の存在チェック (falseを返す)
map1.containsValue("ぶどう");

<br>

要素数の取得<br>

コレクションの要素数の合計を取得するにはsizeメソッドを使う。<br>
map1.size();<br>

要素の削除<br>
要素を削除するにはremoveメソッドを使う。<br>
キーのみか、キーと値の両方の指定ができる。キーを指定するとそれで特定される要素が削除され、両方を指定した場合はキーも値もともに一致する要素が削除される。いずれも、該当する要素が存在しなければ何もせず、エラーも発生しない。<br>

// キーを指定して要素を削除する<br>
map1.remove(0);
map1.remove(1); // 何もしない

// キーと値を指定して要素を削除する
map1.remove(3, "もも");
map1.remove(3, "なし"); // 何もしない

<br>
〜Set〜

Set…重複のない要素を管理するコレクション。重複した要素を保持する事ができず、要素の順番も保証されない。Setもインターフェースの為、HashSetやLinkedHashSetなどのSetを実装したクラスを使用する必要がある。<br>

import java.util.HashSet;<br>
import java.util.LinkedHashSet;<br>
import java.util.Set;<br>

// HashSetを生成する場合<br>
Set<String> set1 = new HashSet<String>();

// LinkedHashSetを生成する場合<br>
Set<Integer> set2 = new LinkedHashSet<Integer>();

<br>

要素の追加<br>
要素を追加するにはaddメソッドを使う。<br>

// 要素を追加する<br>
set1.add("スイカ");
set1.add("メロン");

<br>

要素の取得<br>
Setには位置(インデックス)やキーなどの要素を特定する考え方がなく、あくまで集合に過ぎない為、要素を取り出したい時はループ処理を用いる。拡張for文やラムダ式などを使う。<br>

要素の存在チェック<br>
ある要素がSetに含まれるか確認するにはcontainsメソッドを使う。戻り値はboolean。<br>

// 存在チェック (trueを返す)<br>
set1.contains("スイカ");

// 存在チェック (falseを返す)<br>
set1.contains("なし");

<br>

要素数の取得<br>
コレクションの要素数の合計を取得するにはsizeメソッドを使う。<br>

set1.size();

<br>

要素の削除<br>
要素を削除するにはremoveメソッドを使う。存在しない要素を指定すると何もせず、エラーも発生しない。<br>

// 要素を削除する (要素が文字列の場合、文字列として同じであれば削除されます)<br>
set1.remove("スイカ");
set1.remove("なし"); // 何もしない

<br>

〜拡張for文〜

拡張for文…配列やコレクションのループ処理に使えるfor文。<br>

どのコレクションも拡張for文を用いることで順番に要素を取り出し処理を行う事が出来る。<br>

// Listの例
List<String> prefectures = new ArrayList<>();
prefectures.add("北海道");
prefectures.add("青森県");
prefectures.add("秋田県");

for (String prefecture : prefectures) {
  System.out.print(prefecture); // 北海道、青森県、秋田県の順に表示
}<br>

Mapの場合、キーのみ、値のみ、キーと値のペアのいずれかをループの対象にする事が出来る。<br>

Map<Integer, String> classmates = new HashMap<>();
classmates.put(1, "青木");
classmates.put(2, "石坂");
classmates.put(3, "小野田");

// キーのみ<br>
for (Integer key : classmates.keySet()) {
  System.out.print(key); // 1, 2, 3の順に表示
}<br>

// 値のみ<br>
for (String name : classmates.values()) {
  System.out.print(name); // 青木、石坂、小野田の順に表示
}<br>

// キーと値のペア<br>
for (Map.Entry<Integer, String> classmate : classmates.entrySet()) {
  System.out.print(classmate.getKey() + "番は" + classmate.getValue() + "さん"); // 1番は青木さん、2番は石坂さん、3番は小野田さんの順に表示
}<br>
