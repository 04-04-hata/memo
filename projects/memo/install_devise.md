deviseについて

deviseとは、ログイン関係の実装を楽にする為のgemである。<br>

〜deviseのインストールの仕方〜<br>

1.gemfileに gem 'devise' と記述し、<br>
ターミナルで bundle install する<br>

2.rails g devise:install でdeviseをインストールする<br>

〜deviseを使う上での注意点〜<br>

deviseのコントローラーでの処理は、
application.controllerに書く事。<br>

deviseのビューをカスタマイズする時は<br>
rails g devise:views をし、<br>
routes.rbに↓以下のように記述する事。<br>

devise_for :deviseでのモデル名, controllers: {<br>
    sessions: 'deviseでのモデル名/sessions',<br>
    registrations: 'deviseでのモデル名/registrations'<br>
}<br>

↑これらをしないとdeviseのviewがカスタマイズ出来ない<br>

使用例<br>

モデル名はuserとする。<br>
deviseでモデルを作る際は、↓下記のようにする。<br>

rails g devise モデル名<br>

↑上記のようにモデルを作った後は必ず<br>
rails db:migrate をする<br>

今回はモデル名はuserなので<br>
rails g devise user となる<br>

以下↓routes.rbでの記述<br>

devise_for :users, controllers: {<br>
    sessions: 'users/sessions',<br>
    registrations: 'users/registrations'<br>
}<br>






