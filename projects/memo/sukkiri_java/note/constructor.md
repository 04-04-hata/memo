〜コンストラクタ〜

「インスタンスが生まれた直後に自動実行される処理」を予め定義する<br>

生まれた直後の動作を定義したHeroクラス<br>

public class Hero {<br>
	String name;
	int hp;
	Sword sword; // 勇者が装備している剣の情報
	
	public void attack() {
		System.out.println(this.name + "は" + this.sword.name + "で攻撃した");
	}
	
	public Hero() {
    this.hp = 100; // hpフィールドを100で初期化
  }
	
	
}<br>

追加したメソッド:public Hero()<br>
効果:hpフィールドを100で初期化<br>
public Heroの役割:newされた直後に自動的に実行するメソッド<br>

このクラス↑にはHero()というメソッドが追加されている。<br>
attack()などの通常のメソッドは誰かから呼ばれないと動かないものですが、<br>
このHero()だけは「このクラスがnewされた直後に自動的に実行される」という特別な性質を持っている。<br>
このような↑メソッドをコンストラクタと呼ぶ。<br>

コンストラクタ…特定のクラスがnewされた直後に自動的に実行されるメソッド。<br>

上記のHero()はコンストラクタとして定義されており、newされると自動的に実行されてHPに100が代入される。<br>
そのため、mainメソッド側でHPに初期値を代入する必要はない<br>

コンストラクタが定義されたHeroを生み出す<br>

public class Buttle {<br>
  public static void main(String[] args) {<br>
    Hero h = new Hero(); // インスタンス生成と同時にコンストラクタによってHPに100が代入される<br>
    System.out.println(h.hp); // 100と表示される<br>
  }<br>
}<br>

newするだけで自動実行される処理<br>

1.newする(Hero h = new Hero())<br>
2.仮想世界にインスタンスが生まれる<br>
2.自動的にコンストラクタが実行される(今回の場合はHPに100を代入)<br>

ここで意識したいのが、コンストラクタは開発者が直接呼び出すものではないという点。<br>
開発者が直接行うことはあくまでもHero h = new Hero(); でインスタンスを生成することであって、<br>
生成処理の完了後にJVMがHero()を実行してくれる。<br>
h.Hero();のように開発者がコンストラクタを直接呼び出すことは出来ない<br>

コンストラクタは直接呼び出せない<br>
コンストラクタはインスタンスの生成時にJVMによって呼び出されるものであり、
開発者がプログラムで直接呼び出す手段は用意されていない<br>