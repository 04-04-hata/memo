#indexアクションの定義の仕方

@変数名 = 一覧化したいデータ<br>

全データを一覧化したい場合は、<br>
モデル名.find(params[:id])とする。<br>

データを一覧化する場合の条件を付ける場合、<br>
whereメソッドを使う。<br>

例:現在のユーザーの分だけのデータを取得する場合<br>
@変数名 = モデル名.where(ユーザーのid: current_user.id)