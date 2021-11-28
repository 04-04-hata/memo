namespaceとは

namespaceとは、コントローラー名が重複した時に衝突を防ぐ為に使用するもの。<br>
ルーティングで使用する。<br>

使用方法<br>

namespace :コントローラー名 do<br>
  resources :コントローラー名<br>
end<br>

resources :コントローラー名 には、namespace :コントローラー名の直下に置きたい<br>
コントローラー名を書く<br>

使用例<br>

ショッピングサイトでcustomers(顧客側のコントローラー)と<br>
adminsコントローラー(管理者側のコントローラー)で<br>
同じ名前のコントローラー(items)があった場合

namespace :customers do
  resources :items
end

namespace :admins do
  resources :items
end


