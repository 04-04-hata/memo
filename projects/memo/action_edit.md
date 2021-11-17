editアクションの定義の仕方

def edit<br>
  @変数名 = モデル名.find(params[:id])<br>
end<br>

モデル名.find(params[:id])で特定のid(カラム)のデータを探す<br>