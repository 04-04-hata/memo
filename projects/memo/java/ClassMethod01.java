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

*/

public class ClassMethod01 {
    public static void main(String[] args) {
        Human01 yamada = new Human01(); //Human01クラスのインスタンスを生成
        System.out.println("名前は" + yamada.name + "で、年齢は" + yamada.age + "です。");

        Human01 sato = new Human01("佐藤", 25); //Human01クラスのインスタンスを生成
        System.out.println("名前は" + sato.name + "で、年齢は" + sato.age + "です。");
    }
}