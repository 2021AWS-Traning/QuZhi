## 微服务跨时代的产物

- 1.0：从集中式应用走向分布式应用，从单个进程拆分成为多个进程。从大块业务拆分成为小块业务。从中心应用走向去中心应用。
- 2.0：Docker容器时代。
- 3.0：从业务模式上来说，微服务的各个服务之间实际上采用事件驱动的模式，用户事件出现时， 会催生一系列后续业务行为。换句话说，没事件，没行为。
  伴随着云时代的来到，事件驱动在技术层面上上升到了更高的层次，将业务逻辑，拆分成为一个个的函数代码块，用户事件将依序调用各个处理函数，输出结果。
  在这种case中，开发者只关心数据如何接收，如何处理，如何调用下一个函数即可。不需要做太多额外的工作。
  这种函数之间的调用模式，就是Serverless架构思想。无服务，无运行实例的这么一个概念。

aws lambda create-function --function-name my_lambda \
--zip-file fileb://Project.zip --handler app.handler --runtime nodejs:12 \
--role arn:aws:iam::160071257600:role/aws-homework-lambda-quzhi
arn:aws:iam::160071257600:group/devops-test
