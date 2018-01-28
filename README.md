# SvmSentiment
情感分析 机器学习 微博 libsvm
 
原理：

1.本项目为基于机器学习的短文本情感分析。

2.本项目根据中科院分词和训练好的词袋对训练的文本进行编号，去停用词，过滤噪音，编号，数据预处理，做成测试集（i_data_test.txt）

3.通过训练好的模型model.txt对i_data_test.txt进行测试。

4.其中模型model.txt、词袋wordss.txt的训练请看另一个项目：https://github.com/18846194802/libsvm_weibo_sentiment_train

使用：

1.将文本放入initial_data.txt里面，运行Start.java即可

注意：

1.initial_data.txt 编码为ANSI，请勿保存为utf8，如若如若想改为
utf8请将各个类代码中的GBK进行修改。

2.中科院分词可能过期，若过期，请到官网更新更新license（更换NLPIR.user）
地址：https://github.com/NLPIR-team/NLPIR/tree/master/License
