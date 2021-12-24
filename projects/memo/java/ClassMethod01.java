/*

public class ClassMethod01 {
    public static void main(String[] args) {
        Human01(メソッド名) yamada(インスタンス名) = new Human01()←クラス名。; //Human01クラスのインスタンスを生成
        System.out.println("名前は" + yamada.name + "で、年齢は" + yamada.age + "です。");

        Human01 sato = new Human01("佐藤", 25); //Human01クラスのインスタンスを生成
        System.out.println("名前は" + sato.name + "で、年齢は" + sato.age + "です。");

    }
}

〜パッケージについて〜

パッケージ…クラスをまとめて分類する為の仕組み。

基本構文↓
package パッケージ名;
複数の階層から成るパッケージの場合は、階層の上から順に.でパッケージ名を連結する。

使用例↓(classMethod.humanというパッケージにHuman02というクラスがある)

package classMethod.human;

public class Human02 {
	public String name;
	public int age;
	
	public Human02() {
		name = "山田";
		age = 20;
	}
	
	public Human02(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

インポート…パッケージ外のクラスにアクセスする時に使う。
対象のクラスの場所を明示する為のもの。

基本構文↓
import パッケージ名.クラス名;

import パッケージ名.*
(クラス名の所に*を使うと指定したパッケージ下の全てのクラスがインポートされる)

使用例↓

package classMethod;

import classMethod.human.Human02;
//class.Methodというパッケージの下humanというパッケージがあってその下にHuman02というクラスがある

public class ClassMethod02 {
	public static void main(String[] args) {
		Human02 yamada = new Human02();
		System.out.println("名前は" + yamada.name + "で、年齢は" + yamada.age + "です。");
		
		Human02 sato = new Human02("佐藤", 25);
		System.out.println("名前は" + sato.name + "で、年齢は" + sato.age + "です。");
	}

}

〜メソッドについて〜

メソッド…定義した処理をさせるもの。

メソッドの基本構文↓

修飾子 戻り値の型　メソッド名(引数) {
	//処理
	return 戻り値;
}

メソッドが戻り値を返さない場合は、戻り値の型にvoidを指定。

使用例↓

Human03.java
package classMethod.human;

public class Human03 {
	public String name;
	public int age;
	public String profession;
	
	public Human03() {
		this.name = "山田";
		this.age = 20;
		this.profession = "プログラマー";
		
	}
	//String型の戻り値を返す引数なしのメソッドを定義
	public String getProfile() {
		return "年齢は" + this.age + "、職業は" + this.profession;
	}
	//戻り値を返さない、String型の引数を一つ取るメソッドを定義
	public void greet(String friend) {
		if (friend == null) { //String型の値はnullの可能性があるのでチェック
			System.out.println("挨拶する友達がわかりません!");
			return;
		}
		System.out.println(friend + "さん、こんにちは!");
	}
}

ClassMethod03.java
package classMethod;

import classMethod.human.Human03;

public class ClassMethod03 {
	public static void main(String[] args) {
		Human03 yamada = new Human03();
		
		System.out.println("私の名前は、" + yamada.name + "です。");
		String profile = yamada.getProfile();
		System.out.println(profile + "です。");
		
		yamada.greet("田辺");
		yamada.greet(null);
	}
}

*/

public class ClassMethod01 {
    public static void main(String[] args) {
        Human01 yamada = new Human01(); //Human01クラスのインスタンスを生成
        System.out.println("名前は" + yamada.name + "で、年齢は" + yamada.age + "です。");

        Human01 sato = new Human01("佐藤", 25); //Human01クラスのインスタンスを生成
        System.out.println("名前は" + sato.name + "で、年齢は" + sato.age + "です。");
    }
}