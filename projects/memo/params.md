paramsとは

paramsとはRailsで送られてきた値を受け取るためのメソッド。<br>
送られてくる情報(リクエストパラメーター)は、<br>
getのクエリパラメーター(params[:カラム名]で検索するデータ)と<br>
Postでformを使って送信されるデータ(フォームで入力したデータ)の<br>
2つ。<br>

params[:カラム名]で値を受け取ることが出来る。<br>
大抵はモデル名.params[:id]で使用される。