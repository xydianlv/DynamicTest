Android 项目，在子模块中集成 RN 流程:

* 配置 RN 开发环境
  必须安装的依赖有：Node、JDK、Android-SDK，Android 开发环境下默认支持 JDK、Android-SDK，只需要配置 Node 即可
  在 Node 官网，下载最新的 Node（LTS）版本 「必须是 LTS 标签的」，建议下载压缩包格式
  下载完成后，在 .zshrc 中手动配置 Node 环境变量，执行命令
  $ node -v
  查看是否配置成功。执行命令
  $ npx nrm use taobao
  切换到淘宝国内镜像，可加速后续配置，要切回官方源，执行命令
  $ npx nrm use npm
  即可。执行命令
  $ npm install -g yarn
  配置 Facebook 提供的 yarn 命令，可替代 npm 命令

* 开发环境配置完成后，开始集成 RN 项目
  在 Android 项目中新建一个 Android 子模块 module-ard，放在 /module-rn 目录中
  在 /module-rn 目录下，执行命令
  $ npx @react-native-community/cli init module-nod --version 0.74.0
  将会在 /module-rn 目录下新建一个 /module-nod 目录，该目录中包含 RN 项目的所有必须文件

  在 Android 项目的 settings.gradle 配置文件中，添加
  includeBuild('./module-rn/module_nod/node_modules/@react-native/gradle-plugin')
  配置项，注意括号中的路径，要和自己的项目目录名称一致

  再在 module-ard 模块儿的 build.gradle 配置文件中，添加
  implementation libs.facebook.react.android
  implementation libs.facebook.hermes.android
  配置项，注意这两个引入的库，必须要含有版本号，且版本号要和 /module-nod/package.json 中的版本号一致

  添加完以上配置即可！官方文档的引入方式有问题！无需引入 plugin

* 完成 RN 集成后，开始构建并打包
  在 /module-rn/module-nod 目录下，执行命令
  $ yarn start
  启动 RN 项目，启动后不用管，就放在那儿，重启一个命令行窗口，执行命令
  $ yarn start npx react-native bundle --platform android --dev false --entry-file index.js --bundle-output ./../module-ard/src/main/assets/index.android.bundle --assets-dest ./../module-ard/src/main/res/
  该命令将在 module-ard 模块儿的 /assets 目录中，生成一个 index.android.bundle 文件，该文件就是 RN 与 Android 建立联系的核心文件
  最后在构建 Android 项目