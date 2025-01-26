构建 .jar 文件流程

* 在 /DynamicTest 目录下，执行命令
  $ ./gradlew :module-jar:clean
  $ ./gradlew :module-jar:assembleDebug
  该命令会在 /DynamicTest/module-jar/build/outputs/arr 目录下，生成 module-jar-debug.aar 文件

* 在 /DynamicTest/module-jar/build/outputs/arr 目录下，执行命令
  $ d8 --output jarTest-dex.jar module-jar-debug.aar
  该命令会在 /DynamicTest/module-jar/build/outputs/arr 目录下，生成 jarTest-dex.jar 文件
  将生成的 jarTest-dex.jar 文件，发送到手机应用外部存储目录下，即可采用 DexClassLoader 动态加载使用