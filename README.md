# TweenEasing

イージングを表現するJavaライブラリ

参考: jQuery Easing Plugin: <http://gsgd.co.uk/sandbox/jquery/easing/>

|name|IN|OUT|IN-OUT|
|---|---|---|---|
|LINEAR|||[![LINEAR](./images/0_LINEAR.png)](./src/main/java/jp/harujioh/easing/LinearEasing.java)|
|QUAD|[![InQUAD](./images/1_IN_QUAD.png)](./src/main/java/jp/harujioh/easing/in/InQuadEasing.java)|[![OutQUAD](./images/2_OUT_QUAD.png)](./src/main/java/jp/harujioh/easing/out/OutQuadEasing.java)|[![InOutQUAD](./images/3_IN_OUT_QUAD.png)](./src/main/java/jp/harujioh/easing/inout/InOutQuadEasing.java)|
|CUBIC|[![InCUBIC](./images/4_IN_CUBIC.png)](./src/main/java/jp/harujioh/easing/in/InCubicEasing.java)|[![OutCUBIC](./images/5_OUT_CUBIC.png)](./src/main/java/jp/harujioh/easing/out/OutCubicEasing.java)|[![InOutCUBIC](./images/6_IN_OUT_CUBIC.png)](./src/main/java/jp/harujioh/easing/inout/InOutCubicEasing.java)|
|QUART|[![InQUART](./images/7_IN_QUART.png)](./src/main/java/jp/harujioh/easing/in/InQuartEasing.java)|[![OutQUART](./images/8_OUT_QUART.png)](./src/main/java/jp/harujioh/easing/out/OutQuartEasing.java)|[![InOutQUART](./images/9_IN_OUT_QUART.png)](./src/main/java/jp/harujioh/easing/inout/InOutQuartEasing.java)|
|QUINT|[![InQUINT](./images/10_IN_QUINT.png)](./src/main/java/jp/harujioh/easing/in/InQuintEasing.java)|[![OutQUINT](./images/11_OUT_QUINT.png)](./src/main/java/jp/harujioh/easing/out/OutQuintEasing.java)|[![InOutQUINT](./images/12_IN_OUT_QUINT.png)](./src/main/java/jp/harujioh/easing/inout/InOutQuintEasing.java)|
|SINE|[![InSINE](./images/13_IN_SINE.png)](./src/main/java/jp/harujioh/easing/in/InSineEasing.java)|[![OutSINE](./images/14_OUT_SINE.png)](./src/main/java/jp/harujioh/easing/out/OutSineEasing.java)|[![InOutSINE](./images/15_IN_OUT_SINE.png)](./src/main/java/jp/harujioh/easing/inout/InOutSineEasing.java)|
|EXPO|[![InEXPO](./images/16_IN_EXPO.png)](./src/main/java/jp/harujioh/easing/in/InExpoEasing.java)|[![OutEXPO](./images/17_OUT_EXPO.png)](./src/main/java/jp/harujioh/easing/out/OutExpoEasing.java)|[![InOutEXPO](./images/18_IN_OUT_EXPO.png)](./src/main/java/jp/harujioh/easing/inout/InOutExpoEasing.java)|
|CIRC|[![InCIRC](./images/19_IN_CIRC.png)](./src/main/java/jp/harujioh/easing/in/InCircEasing.java)|[![OutCIRC](./images/20_OUT_CIRC.png)](./src/main/java/jp/harujioh/easing/out/OutCircEasing.java)|[![InOutCIRC](./images/21_IN_OUT_CIRC.png)](./src/main/java/jp/harujioh/easing/inout/InOutCircEasing.java)|
|ELASTIC|[![InELASTIC](./images/22_IN_ELASTIC.png)](./src/main/java/jp/harujioh/easing/in/InElasticEasing.java)|[![OutELASTIC](./images/23_OUT_ELASTIC.png)](./src/main/java/jp/harujioh/easing/out/OutElasticEasing.java)|[![InOutELASTIC](./images/24_IN_OUT_ELASTIC.png)](./src/main/java/jp/harujioh/easing/inout/InOutElasticEasing.java)|
|BACK|[![InBACK](./images/25_IN_BACK.png)](./src/main/java/jp/harujioh/easing/in/InBackEasing.java)|[![OutBACK](./images/26_OUT_BACK.png)](./src/main/java/jp/harujioh/easing/out/OutBackEasing.java)|[![InOutBACK](./images/27_IN_OUT_BACK.png)](./src/main/java/jp/harujioh/easing/inout/InOutBackEasing.java)|
|BOUNCE|[![InBOUNCE](./images/28_IN_BOUNCE.png)](./src/main/java/jp/harujioh/easing/in/InBounceEasing.java)|[![OutBOUNCE](./images/29_OUT_BOUNCE.png)](./src/main/java/jp/harujioh/easing/out/OutBounceEasing.java)|[![InOutBOUNCE](./images/30_IN_OUT_BOUNCE.png)](./src/main/java/jp/harujioh/easing/inout/InOutBounceEasing.java)|


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

    // Image
    imageCompile 'org.jfree:jfreechart:1.0.19'
}
```


## メンテナー

* 平田良太 <hirata@team-lab.com>

