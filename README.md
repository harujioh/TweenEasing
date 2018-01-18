# TweenEasing

イージングを表現するJavaライブラリ

参考: jQuery Easing Plugin: <http://gsgd.co.uk/sandbox/jquery/easing/>

|name|IN|OUT|IN-OUT|
|---|---|---|---|
|LINEAR|![LINEAR](./images/0_LINEAR.png)|||
|QUAD|![LINEAR](./images/1_IN_QUAD.png)|![LINEAR](./images/2_OUT_QUAD.png)|![LINEAR](./images/3_IN_OUT_QUAD.png)
|CUBIC|![LINEAR](./images/4_IN_CUBIC.png)|![LINEAR](./images/5_OUT_CUBIC.png)|![LINEAR](./images/6_IN_OUT_CUBIC.png)
|QUART|![LINEAR](./images/7_IN_QUART.png)|![LINEAR](./images/8_OUT_QUART.png)|![LINEAR](./images/9_IN_OUT_QUART.png)
|QUINT|![LINEAR](./images/10_IN_QUINT.png)|![LINEAR](./images/11_OUT_QUINT.png)|![LINEAR](./images/12_IN_OUT_QUINT.png)
|SINE|![LINEAR](./images/13_IN_SINE.png)|![LINEAR](./images/14_OUT_SINE.png)|![LINEAR](./images/15_IN_OUT_SINE.png)
|EXPO|![LINEAR](./images/16_IN_EXPO.png)|![LINEAR](./images/17_OUT_EXPO.png)|![LINEAR](./images/18_IN_OUT_EXPO.png)
|CIRC|![LINEAR](./images/19_IN_CIRC.png)|![LINEAR](./images/20_OUT_CIRC.png)|![LINEAR](./images/21_IN_OUT_CIRC.png)
|ELASTIC|![LINEAR](./images/22_IN_ELASTIC.png)|![LINEAR](./images/23_OUT_ELASTIC.png)|![LINEAR](./images/24_IN_OUT_ELASTIC.png)
|BACK|![LINEAR](./images/25_IN_BACK.png)|![LINEAR](./images/26_OUT_BACK.png)|![LINEAR](./images/27_IN_OUT_BACK.png)
|BOUNCE|![LINEAR](./images/28_IN_BOUNCE.png)|![LINEAR](./images/29_OUT_BOUNCE.png)|![LINEAR](./images/30_IN_OUT_BOUNCE.png)


## Javaバージョン

* Java Platform version 8以上


## ビルド

ビルドツールに Gradleを使っている。Gradlewを使うことで、JDKが入った環境であればビルドできる。
以下のコマンドを実行すると、Jarでパッケージングされて `/build/libs/MessageData-{version}.jar` に配置される。

```
./gradlew build
```


## フォーマット

以下のコマンドを実行すると、ソースコードがフォーマットさせる。
```
./gradlew spotlessApply
```


## テスト

以下のコマンドを実行すると、テストが実行される。`/build/reports/tests/index.html` をブラウザで開くと見られる。

```
./gradlew test
```


## ドキュメント

以下のコマンドを実行すると、Javadocが作成される。`/build/docs/javadoc/index.html` をブラウザで開くと見られる。

```
./gradlew javadoc
```


## 依存ライブラリ

Gradleで依存ライブラリを管理している。
`build.gradle` の `dependencies` に必要なライブラリを列挙する。

```
dependencies {
    compile 'org.slf4j:slf4j-api:1.7.25'

    // JUnit
    testCompile 'junit:junit:4.12'
}
```


## メンテナー

* 平田良太 <hirata@team-lab.com>

