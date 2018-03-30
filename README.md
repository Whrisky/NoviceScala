# NoviceScala

inspect tree compile:compile

在任意一个 sbt 项目中运行 
sbt "inspect tree compile:compile" ，
能够看到 sbt 将 compile 这个 Task 所依赖的其它 Setting 及 Task 信息以文本树的形式显示出来。
本月的试题就是实现文本树的生成。

#printTree 中 asciiDisplay 实现此功能