# Diet Manager（ダイエット管理アプリ）

## 概要

Diet Managerは、日々の体重・BMI・食事・運動内容を記録できるダイエット管理Webアプリです。

職業訓練で学習したJava、Servlet/JSP、MySQLを活用し、授業で制作した「どこつぶ」の構成を参考にして制作します。  
ユーザーごとにダイエット記録を管理し、日々の体重変化や目標体重との差を確認できるアプリを目指します。

## アーキテクチャ図

```mermaid
flowchart TD
    User["ユーザー"]
    Browser["ブラウザ"]
    JSP["JSP<br>画面表示"]
    Servlet["Servlet<br>リクエスト処理"]
    Logic["Logic<br>入力チェック・BMI計算"]
    DAO["DAO<br>データベース操作"]
    DB[("MySQL<br>users / diet_records")]

    User --> Browser
    Browser --> JSP
    JSP --> Servlet
    Servlet --> Logic
    Logic --> DAO
    DAO --> DB
    DB --> DAO
    DAO --> Logic
    Logic --> Servlet
    Servlet --> JSP
    JSP --> Browser
