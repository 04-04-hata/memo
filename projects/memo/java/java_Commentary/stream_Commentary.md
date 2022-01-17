〜ストリーム処理について〜

ストリーム処理…StreamAPI(java.util.stream.Stream)がある。<br>
これは、コレクションや配列に対するループ処理を実現するストリーム処理を可能とするもの。for文やwhile文もループ処理を実現出来るが、これらは一つ一つ要素を取り出した後処理していくのに対し、ストリーム処理では処理を繋げたパイプラインに要素の集合を通していくようなイメージを持つといい。<br>

〜ストリーム処理の流れ〜

ストリーム処理は3段階に分けて行われる。<br>

1.ストリームを生成する
2.要素の集合に対する処理を行う:中間操作
3.最終的な処理結果を得る:終端操作

<br>
中間操作は「条件に見合う要素を抽出する」「全ての要素を2枚する」「要素を指定した順番でソートする」など、検索や変換の処理にあたるもので、ストリーム処理の肝とも言える。中間操作は複数、終端操作は一つ指定する事が出来る。<br>

題材:フルーツのリスト。フルーツの在庫数管理をしてる設定。
1.在庫数が10こ以下のフルーツを抽出する
2.抽出したものに対し、20個ずつ発注(個数を加算)する
3.個数が少ない順に並び替える
という処理をする場合を考える。<br>

〜ストリーム処理の実装〜

まず、名前と値段を持ったフルーツクラスを用意し、そのオブジェクトのリストを作る。<br>

// フルーツクラス
public class Fruit {

  // 名前
  public String name;

  // 在庫数
  public int quantity;

  // 名前と在庫数を引数にしたコンストラクタ
  public Fruit(String name, int quantity) {
    this.name = name;
    this.quantity = quantity;
  }

  // 在庫数を増やしたフルーツを返すメソッド
  public Fruit order(int quantityToAdd) {
    return new Fruit(this.name, this.quantity + quantityToAdd);
  }

  // 出力用にtoStringをオーバーライド
  @Override
  public String toString() {
    return name + ": " + quantity + "個";
  }
}

java.util.Listクラスを使って、フルーツのリストを作る<br>

List<Fruit> fruits = new ArrayList<>();
fruits.add(new Fruit("りんご", 7));
fruits.add(new Fruit("みかん", 15));
fruits.add(new Fruit("いちご", 4));
fruits.add(new Fruit("メロン", 8));
fruits.add(new Fruit("ぶどう", 20));
<br>

ラムダ式を使わない場合↓

// 10個以下に絞り込まれたリストを作る
List<Fruit> filtered = new ArrayList<>();
// 拡張for文でfruitsをループ
for (Fruit fruit : fruits) {
  // if文で10個以下に絞る
  if (fruit.quantity <= 10) {
    // 絞り込まれたリストに追加
    filtered.add(fruit);
  }
}
// 20個ずつ追加する
List<Fruit> ordered = new ArrayList<>();
for (Fruit fruit : filtered) {
  ordered.add(fruit.order(20));
}
// 個数が少ない順に並べ替える
ordered.sort(new Comparator<Fruit>() {
  @Override
  public int compare(Fruit f1, Fruit f2) {
    return f1.quantity - f2.quantity;
  }
});

// 絞り込んで並べ替えたリストを拡張for文でループしながら出力する
for (Fruit fruit : ordered) {
  // 標準出力
  System.out.print(fruit);
}

<br>

ラムダ式を使った場合↓

fruits.stream() // Streamを生成
    .filter(f -> f.quantity <= 10) // 中間操作1: 個数が10個以下のものを抽出
    .map(f -> f.order(20)) // 中間操作2: 20個ずつ発注
    .sorted((f1, f2) -> f1.quantity - f2.quantity) // 中間操作3: 個数の少ない順に並び替え
    .forEach(System.out::print); // 終端操作: 標準出力

<br>

ストリームの生成<br>
処理を開始するには、まずストリームを生成する必要がある。
コレクションに対しstreamメソッドを呼ぶ<br>

fruits.stream()<br>

中間操作<br>

中間操作ができるメソッド一覧↓

- filter:要素を条件で絞り込む
- map:要素を変換する
- mapToInt:要素をInteger型に変換する
- mapToLong:要素をLong型に変換する
- mapToDouble:要素をDouble型に変換する
- flatMap:mapに似た処理だが、ストリームが入れ子になっていたら平坦化する
- flatMapToLong: flatMap +mapToLongに相当する処理を行う
- flatMapToDouble: flatMap + mapToDoubleに相当する処理を行う
- distinct:要素の重複を取り除く
- sorted:要素を並び替える
- limit:指定した要素数で切り出す
- skip:指定した要素数を先頭から切り捨てた残りの要素を残す
- peek:要素を出力するなどしてデバッグに用いる

<br>

先の例では、まずfilterを用いて要素の抽出を行なった。絞り込みの条件として、ラムダ式に判定用の関数を渡しているのが特徴。<br>

.filter(f -> f.quantity <= 10)<br>

続いて、mapは引数で渡した関数による変換処理を適用するメソッドで、ここでは全ての要素に対し発注メソッドを呼び出す事で新たに生成された在庫数20が加算済みのFruitオブジェクトがStreamの中身となる。<br>

.map(f -> f.order(20))<br>

最後の並べ替え処理にはsorted()を使う。<br>

.sorted((f1, f2) -> f1.price - f2.price)<br>

負の値を返すと第一引数のf1が、正の値を返すと第２引数のf2がリストの上に来るので、フルーツ(Fruit)の値段(price)の引き算を返している。<br>

終端処理<br>
終端処理が出来るメソッド一覧↓

- forEach:各要素に対し順に処理する
- forEachOrdered:各要素に対し順に処理するが、要素を検出する順番を指定出来る
- toArray:配列に変換する
- reduce:任意の集約処理を行う汎用的なメソッド
- collect:ストリーム処理の結果を任意の形式で返す汎用的なメソッド(よくあるusecaseとして、結果をコレクションとして返したい場合などはこれを使う)
- min:最初内を返す
- max:最大値を返す
- count:要素数を返す
- anyMatch:条件がいずれかの要素に合致するかどうかを返す
- allMatch:条件が全ての要素に合致するかどうかを返す
- noneMatch:条件がいずれの要素にも合致しないかどうかを返す
- findFirst:最初の要素を返す
- findAny:初めに見つけた要素を返す

<br>
今回はforEachを用いて要素を一つずつ標準出力した。メソッド参照も使われている。<br>

.forEach(System.out::print)

その他、例えば結果をリストとして返したい場合は終端操作を↓で置き換えると可能になる。<br>
.collect(Collectors.toList())<br>

結果にりんごが含まれるかが知りたければ↓のように書く。<br>

.anyMatch(f -> f.name.equals(“りんご”)
