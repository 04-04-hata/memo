特定のページをルートパスにする方法

routes.rb(ルーティングをする為のファイル)に<br>

root to: 'コントローラー名#アクション名'<br>

↑と書くだけ<br>

使用例<br>

homesコントローラーのtopアクションをルートパスにする<br>
homesコントローラーはトップページの為のコントローラーとする<br>

root to: 'homes#top'