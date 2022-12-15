# [ドメイン駆動設計(Domain-DrivenDesign)](#参考)

## 方針
1. 業務をオブジェクト指向で整理する
1. 業務の表現と命名を一致させる(顧客、商品、注文、納期など)
1. 開発者は業務知識と言葉を獲得すべき
1. 分析と設計を同一人物が担当する
- ドメイン駆動設計はノンプログラマー向け
<br></br>

## ドメイン駆動設計の前提
- オブジェクト指向
- エクストリーム・プログラミング
<br></br>

## ドメインとは
### ドメイン：ソフトウェアの対象となるビジネス領域のこと
<br></br>

## エリック・エヴァンスのドメイン駆動設計で伝えていること
- ソフトウェアの焦点はドメインに合わせるべき
- ただし、ドメインはそもそもめちゃくちゃ複雑である
- DDDは、その複雑さに立ち向かうアプローチ
- そのためには、ドメインの深い知識が必要
- そして、複雑性との格闘は刺激的
### まとめ
ソフトウェアが難しいのは、そもそも**ドメイン**が難しいからである。しかし、**その複雑さには立ち向かう術があり、それがドメイン駆動設計**である。
<br></br>

## ドメインモデルとは
### ドメインモデル：ドメインから本質的な部分のみを選び抜いたもの(抽象化)
<br></br>

## ドメインの抽象化手順
1. ドメインモデルとは、ドメイン要素(ドメインオブジェクト)とその関係である → オブジェクト指向で表現しやすい
1. [共通言語(ユビキタス言語)](#参考)を使用する → ドメインとコードの言葉が統一される
1. ドメインモデルの詳細はコードに表現される → モデルとコードが一致する
<br></br>

## ドメイン駆動設計とは
### **ドメインの本質を見極め、その複雑さを抑えつつ実装に落とし込む、それをアジャイル的に繰り返すことで、洗練させていく**
<br></br>

## ドメイン駆動設計のメリット
1. プログラムの使いまわしができる
1. 改修の際、修正するものとしないものを分離できる
```
例：ドメイン駆動設計を利用したシステムと処理が同じでUIだけが違うシステムを新規で作成するとする。
この時、UI以外のロジックを使いまわせる。また、この例は改修ではないが修正を行うファイルの分離もUIのみになっている。
```
<br></br>

## リポジトリパターン
リポジトリパターンを採用することで、**ドメイン(リポジトリを使用する側)は、実際のデータの形式や保存方法を気にしないでいい**。つまり、保存先のDBが移行などの変更があったとしても変更するのはリポジトリのみでドメイン層は変更する必要がない。

## 参考
- [ユビキタス言語](https://zenn.dev/leaner_dev/articles/20210922-ubiquitous-language)
- [ドメイン駆動設計参考１](https://www.seplus.jp/dokushuzemi/blog/2022/06/get_started_ddd_patterns.html)
- [ドメイン駆動設計参考２](https://note.com/shift_tech/n/n1e91c68b1473)
- [リポジトリパターン参考１](https://zenn.dev/kohii/articles/e4f325ed011db8)
- [リポジトリパターン参考２](https://qiita.com/mikesorae/items/ff8192fb9cf106262dbf)
- [集約について](https://zenn.dev/takashi_onawa/articles/4648332c035d97)
- [ドメイン駆動設計パッケージ構成](https://zenn.dev/morio_pg/articles/16777261720294644011)
- [ドメイン駆動設計+Repositoryサンプル](https://poppingcarp.com/ddd-repository-sample-program/)
