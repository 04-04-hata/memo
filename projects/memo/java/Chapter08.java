public class Chapter08 {
  public static void main(String[] args){
    double number = 1; //2乗する数字
    double index = 2;
    //2乗する数字が4になるまで処理↓
    while (number <= 4) {
      //Math.powで累乗の計算が出来る。先にどの数字を累乗するか、後にどの位累乗するかを書く。
      double answer = Math.pow(number, index);
      System.out.println(number + "の二乗は" + answer);
      number++;//numberを1足していく
    }

    /*
    模範解答↓
    int num = 1;
    while (num < 5) {
        System.out.println(num * num);
        num++;
    }
    */

    //通常for文
    
    int[] array = {11, 50, 43, 30};
    //配列の要素の長さ分、要素を表示↓
    for (int count = 0; count < array.length; count++) {
      System.out.println(array[count]);//配列の要素を表示
    }//ok

    //拡張for文

    int[] array2 = {11, 50, 43, 30};
    for (int w : array2) {
      if (w % 2 == 0) {
        continue;
      }
        System.out.println(w);
    }//ok

  }
}