〜クラス型と参照〜

インスタンスの事は「操作と属性を持ち、コンピューター内の仮想世界に生み出される登場人物」という概念的な表現をしてきたが
実際は勇者やばけばけばーのような存在がコンピューターの中に住んでおり、あれこれ活躍する訳ではない。<br>
Javaの仮想世界と表現してきたものは実際にはコンピューターのメモリ領域で、この領域は、javaのプログラムを実行する際に
JVMが大量にメモリ領域(通常は数百MB〜数GB)を使って準備するもので、ヒープという。<br>
そして、私たちがnewを用いてインスタンスを生み出すたびにヒープの一部の領域(通常は数十〜数百バイト)が確保され、
インスタンスの情報を格納するために利用される。<br>
そのため、多くの属性を持った大きなクラスをインスタンス化すると、消費されるヒープ領域は必要とする容量に従って大きくなる。<br>

インスタンスとは、「ヒープの中に確保されたメモリ領域」に過ぎない<br>

クラス型変数とその内容
インスタンスが生まれる際に、コンピューターの中で何が起こっているか、以下のコード↓を例に探っていく<br>

public class Buttle {<br>
  public static void main (String args) {<br>
  // 勇者を生成<br>
    Hero h = new Hero(); // Heroクラスからインスタンスを生成し、変数hに入れる<br>
    h = new Hero();<br>
    h.hp = 100;<br>
  }<br>
}<br>

1.Hero型変数の確保<br>
最初に動くのはHero h;<br>
この行↑を実行するとJVMはHero型の変数hをメモリ内に準備する。<br>
JVMは広いヒープ領域の中から現在利用していないメモリ領域を探し出して自動的にそこを確保してくれる。<br>
1928番地が空いていたとして、ここが変数h用に確保されたとする。<br>

この段階↑ではまだ勇者自体は生まれていない。<br>
Hero型の箱が準備されるだけで、この箱には数値や文字列を入れる事は出来ないし、Hero型でないばけばけばーインスタンスを入れる事も出来ない。<br>

2.Heroインスタンスの生成<br>
Hero h = new Hero();は代入文。代入の場合は左辺より先に右辺が評価される。<br>
(つまりnew Hero();が先に評価される)<br>
new Hero();が実行されるとJVMはヒープ領域から必要な量のメモリを確保する。<br>
今回は仮に3922番地から24バイト分(3922〜3945番地)が確保出来たとする。<br>

1928番地が変数hの場所と考える。<br>
3922番地は生まれたHeroインスタンスの情報領域。<br>
3922〜3945番地(24バイト分)には名前フィールドの保存領域やHPフィールドの保存領域が入っている。<br>
new Hero();をすることにより、仮想世界に勇者という存在が生まれる。<br>
しかし、まだHeroインスタンスには属性が設定されていない為、名前は空っぽ、HPは0となる。<br>

3.参照の代入
参照…変数に入っているアドレス情報。<br>

右辺(new Hero();)が実行された後の事について<br>
右辺の実行が終了した後、h = new Hero();とは「h = 右辺の実行結果」という状態になる。<br>
つまり、右辺の実行結果を変数hに代入するという事が行われる。<br>
変数hに代入される右辺の実行結果は、newによって生成されるインスタンスのために確保されたメモリの先頭番地(3922番地)。
今回の場合はnew Hero();により勇者インスタンスが3922〜3945番地に生成されているので、変数hには3922という数値が代入される。<br>
変数hに入っている3922はただの数値に過ぎず、Heroインスタンスに関する名前やHPなどの様々な情報は変数hの中ではなく、別のところにある。<br>
見方を変えれば、この変数hにはHeroインスタンスの情報の全部は入りきらないから、詳しくは3922番地を参照(見る)してとも捉える事が出来る。<br>
このようなことから、変数hに入っているアドレス情報を参照という。<br>

int[]型やString[]型と言った配列型も、変数に入っているのは「実際の配列内の各データが保存されているメモリ領域の先頭番地」。<br>
Hero型のようなクラス型も原理は同じ。このことからクラス型と配列型は総称して参照型と呼ばれる。<br>

4.フィールドへの値の代入<br>
h.hp = 100;では、変数hに格納されている勇者のHPを100に設定する。この行をJVMは以下のように↓解釈して実行する。<br>

1.変数hの内容を調べると、「3922番地を参照しろ」と書かれている。<br>
2.メモリ内の3922番地にあるインスタンスのメモリ領域にアクセスし、その中のhpフィールド部分を100に書き換える。<br>

2でやってることの具体例:3922〜3945番地のHPフィールドの保存領域を100に書き換える。<br>

↑上記のように、まず変数から番地情報を取り出し、次にその番地にアクセスするというJVMの動作を参照の解決やアドレス解決という<br>

同一インスタンスを指す変数<br>
もし仮想世界に勇者が二人生成され、それぞれh1、h2という変数に格納されていたとする。<br>
当然、勇者h1のhpフィールドを10減らしても、勇者h2のhpフィールドの値は減らない。<br>
同じクラスから生まれても、異なるインスタンスであれば互いに影響を受けないことをインスタンスの独立性という。<br>

2つのHero型変数を利用する<br>
public class Multiplehero {<br>
  public static void main(String args) {<br>
    Hero h1;<br>
    h1 = new Hero();<br>
    h1.hp = 100;<br>
    Hero h2;<br>
    h2 = h1;<br>
    h2.hp = 200;<br>
    System.out.println(h1.hp);<br>
  }<br>
}<br>

このプログラムを正しく理解するためのポイントはh2 = h1;。<br>
これは変数h1の内容をh2にコピーする文だが、ここでコピーされているのは勇者インスタンスそのものではなく、3922などの番地情報。<br>
代入の結果、h1とh2の両方に番地情報の3922が入る。ということは、h1とh2はどちらも全く同じ一人の勇者インスタンスを指している。<br>
そのため、h1のhpフィールドへ代入しても、h2のhpフィールドへ代入しても結局は同じ勇者インスタンスのHPに代入する事になる。<br>

h1.hp = 100; 意味:変数h1の中身(3922)が指す番地にいるインスタンスのhpを100に書き換えろ<br>
h2.hp = 200; 意味:変数h2の中身(3922)が指す番地にいるインスタンスのhpを200に書き換えろ<br>

勇者インスタンスのhpフィールドへはh1経由(h1.hp = 100;)で100が代入されるが、
その後に同じhpフィールドにはh2経由(h2.hp = 200;)で200が上書きされる。<br>

いくつかの特殊な例を除いて基本的にインスタンスを生み出す方法はnewしかない。<br>
new Hero()した回数が勇者の人数。(今回は一回しかしてないので一人)<br>
インスタンスの独立性はインスタンスが複数いる場合に成り立つので今回のようにインスタンスが一つ(勇者が一人)の場合は関係ない。<br>

クラス型をフィールドに用いる<br>

例:Sword型フィールドを持つHeroクラス<br>

まず、Swordクラスを定義しておく<br>
public class Sword {<br>
  String name; // 剣の名前<br>
  int damage; // 剣の攻撃力<br>
}<br>

次にHeroクラスを定義する<br>
public class Hero {<br>
  String name;<br>
  int hp;<br>
  Sword sword; // 勇者が装備している剣の情報<br>
  public void attack() {<br>
    System.out.println(this.name(勇者の名前) + "は攻撃した!");<br>
    System.out.println("敵に5ポイントのダメージを与えた!");<br>
  }<br>
}<br>

Heroクラスに新しく追加されたフィールドSwordは、int型やString型ではなくSword型です。<br>
このように↑、フィールドにクラス型の変数を宣言することも出来る。<br>
なお、今回の例のようにあるクラスが別のクラスをフィールドとして利用している関係(上記の例だとSwordクラスがHeroクラスをフィールドとして利用している関係)を
has-aの関係という。<br>

has-aと呼ぶ理由は↓のような英文が自然に成立するから。<br>
Hero has-a Sword(勇者は剣を持っている)<br>

剣を装備した勇者を生み出す<br>

public class Buttle {<br>
	public static void main(String[] args) {
		
		Sword s = new Sword(); // 剣を生み出す
	    s.name = "炎の剣";
	    s.damage = 10;
	    
		// 勇者よ、この仮想世界に生まれよ
		Hero h = new Hero(); // Heroクラスからインスタンスを生成し、変数hに入れる。
		// 実際にインスタンスを生成しているのはnew Hero()の部分であり、=によって生成したインスタンスを変数hに代入している
		h.name = "ミナト"; // 変数hのnameに代入
	    h.hp = 100; // 変数hのhpに代入
	    h.sword = s; //swordフィールドに生成済みの剣インスタンス(の番地)を代入
	    System.out.println("現在の武器は" + h.sword.name); // h.sword.nameは勇者「の」剣「の」名前
	}
}<br>

822番地にある変数hには、勇者インスタンスのアドレス情報(1011番地)が入っている。<br>
そして勇者インスタンスに含まれるsword領域には、剣インスタンスのアドレス情報(2465番地)が
格納されている。<br>
すなわち先ほどの「Hero has-a Sword」の関係が成立しており、HeroクラスがSwordクラスをフィールドとして利用している事がわかる。<br>

クラス型をメソッド引数や戻り値に用いる<br>

クラス型はフィールドの型として用いる事が出来るだけではなく、メソッドの引数や戻り値の型として利用することも出来る。<br>
例:既にある勇者クラスに加え、魔法使い(Wizard)のクラスを作る<br>

魔法使いは勇者のHPを回復させる魔法(heal)を使う事が出来る<br>

public class Wizard {<br>
  String name; // 魔法使いの名前<br>
  int hp; // 魔法使いのHP<br>
  public void heal(Hero h) { // 引数はHero型<br>
    h.hp += 10; // 勇者のHPに10を加える(10回復する)<br>
    System.out.println(h.name + "のHPを10回復した!");<br>
  }<br>
}<br>

healメソッドが呼び出されると、魔法使いインスタンスは勇者のHPを10回復させる。<br>
ただし、仮想世界には勇者が二人以上生み出されている(2回以上newされている)可能性もあるから、
呼び出される時に「どの勇者を回復させるのか」を引数hとして受け取る必要がある(public void heal(Hero h)の所)<br>
実際にこのWizardクラスを利用したプログラムは以下↓のようになる。<br>

public class Battle {<br>
  public static void main(String args) {<br>
    Hero h1 = new Hero(); // 一人目の勇者作成<br>
    h1.name = "ミナト "; // 一人目の勇者の名前<br>
    h1.hp = 100; // 一人目の勇者のhp<br>
    Hero h2 = new hero(); // 二人目の勇者誕生<br>
    h2.name = "アサカ"; // 二人目の勇者の名前<br>
    h2.hp = 100; // 二人目の勇者のHP<br>
    Wizard w = new Wizard(); // 魔法使い誕生<br>
    w.name = "スガワラ"; // 魔法使いの名前<br>
    w.hp = 50; // 魔法使いのHP<br>
    w.heal(h1); // h1(ミナト)のHPを10回復(100 + 10 = 110)<br>
    w.heal(h2); // h2(アサカ)のHPを10回復(100 + 10 = 110)<br>
    w.heal(h2); // h2(アサカ)のHPを10回復(110 + 10 = 120)<br>
  }<br>
}<br>

String型の真相<br>

String型はint型やdouble型の仲間ではなく、Hero型と同じクラス型。<br>

String型<br>
例:String型の変数sがあるとする<br>
String s = "こんにちは"<br>
そのsは1121番地(例)に入っているが、Stringインスタンスの「こんにちは」と言う文字列は1829番地(例)に入っている。<br>

Hero型<br>
1928番地が変数hの場所と考える。<br>
3922番地は生まれたHeroインスタンスの情報領域。<br>
3922〜3945番地(24バイト分)には名前フィールドの保存領域やHPフィールドの保存領域が入っている。<br>
new Hero();をすることにより、仮想世界に勇者という存在が生まれる。<br>

Hero型やSword型は自分自身がHeroクラスやSwordクラスを定義したので利用可能になった。<br>
しかし、Stringクラスを定義していないにもかかわらず自分らがString型を利用できるのは、<br>
StringクラスをJavaが用意してくれてたから。<br>

自分らがこれまでString型をint型と似たようなものとして扱い続け、実はJavaが用意してくれていたクラスを利用していたと気づかなかった理由は<br>
Javaというプログラミング言語が作られる時に、下記のような↓特別の配慮がされていた為。<br>

Java.langパッケージに宣言されている<br>
java.langパッケージに所属するクラスを利用する場合、特例としてimport文を記述する必要がない<br>
この特例のおかげで本来、java.lang.String.s;と宣言する必要があるところを、単に「String s;」と書けば利用できるようになっている。<br>

二重引用符で文字列を囲めばインスタンスを生成して利用出来る<br>
通常、インスタンスを生成するにはnew演算子を利用する必要がある。<br>
しかし文字列はプログラムの中で多用される為、その都度newを書いていてはソースコードがnewだらけになってしまうので、<br>
二重引用符で文字列を囲めば、その文字列情報を持ったStringインスタンスを利用出来るよいう特例が設けられた。<br>
この特例のおかげでnew演算子を使う事なく「String s = "こんにちは"」というシンプルな記述が可能になっている。<br>
