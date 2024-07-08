# gRPC

![Static Badge](https://img.shields.io/badge/Java-white)
![Static Badge](https://img.shields.io/badge/Python-white)
![Static Badge](https://img.shields.io/badge/gRPC-white)
![Static Badge](https://img.shields.io/badge/Maven-white)

## Задача

Разработать клиент-серверное приложение с применением технологий gRPC:

1) Серверная часть:

Сервер по запросу клиента генерирует последовательность чисел.
Запрос от клиента содержит начальное значение (firstValue) и конечное (lastValue).
Раз в две секунды сервер генерирует новое значение и "стримит" его клиенту:
firstValue + 1
firstValue + 2
...
lastValue

2) Клиентская часть:

Клиент отправляет запрос серверу для получения последовательности чисел от 0 до 30.
Клиент запускает цикл от 0 до 50.
Раз в секунду выводит в консоль число (currentValue) по формуле:
currentValue += (число от сервера) + 1

## Запуск

### Java

Для клиента на джаве и сервере в pom.xml есть специальный плагин, который генерирует все нужные классы для grpc:

```bash
mvn clean package
```

Все классы находятся в /target/generated-sources/protobuf.

### Python

Для начала необходимо установить следующие зависимости:

```bash
pip install grpcio
pip install grpcio_tools
```

Генерация grpc файлов:

```bash
python -m grpc_tools.protoc -I./ --python_out=. --pyi_out=. --grpc_python_out=. GeneratorService.proto
```

## Решение

Для предоставления возможностей gRPC в репозитории находится клиенты на двух языках: Java & Python. Сервер только на Java.

### Структуры запроса и ответа (Proto file)

```proto
syntax = "proto3";
package com.example.grpc;

message GeneratorRequest {
  int32 firstValue = 1;
  int32 lastValue = 2;
}

message GeneratorResponse {
  int32 generatedValue = 1;
}

service GeneratorService {
  rpc generate(GeneratorRequest) returns (stream GeneratorResponse);
}
```

Запрос содержит только два поля (см. Задача), ответ - значение из последовательности (firstValue; lastValue]. Так же есть сервис с одним методом, который и генерирует наше значение generatedValue.

### Сервер

Реализации генерации чисел:

```java
 @Override
    public void generate(GeneratorServiceOuterClass.GeneratorRequest request, StreamObserver<GeneratorServiceOuterClass.GeneratorResponse> responseObserver)  {
        int firstValue = request.getFirstValue();
        int lastValue = request.getLastValue();
        for (int i = firstValue; i <= lastValue; ++i) {
            try {
                Thread.sleep(SECOND);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GeneratorServiceOuterClass.GeneratorResponse response = GeneratorServiceOuterClass
                    .GeneratorResponse.newBuilder()
                    .setGeneratedValue(i)
                    .build();
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }
```

Для запуска сервера просто необходимо запустить App.java. Сервер на 8080 порту.

### Клиент

Реализация клиента на Java:

```java
public class Client {

    private static final int FIRST_VALUE = 0;
    private static final int LAST_VALUE = 30;
    private static final int ITERATION_COUNT = 50;

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext()
                .build();

        GeneratorServiceGrpc.GeneratorServiceBlockingStub stub = GeneratorServiceGrpc.newBlockingStub(channel);
        GeneratorServiceOuterClass.GeneratorRequest request = GeneratorServiceOuterClass.GeneratorRequest
                .newBuilder()
                .setFirstValue(FIRST_VALUE)
                .setLastValue(LAST_VALUE)
                .build();
        int currentValue = 0;
        for (int i = 0; i < ITERATION_COUNT; ++i) {
            Iterator<GeneratorServiceOuterClass.GeneratorResponse> response = stub.generate(request);
            while (response.hasNext()) {
                currentValue += response.next().getGeneratedValue() + 1;
                System.out.println(currentValue);
            }
        }
        channel.shutdown();
    }

}
```

Реализация клиента на Python:

```python
FIRST_VALUE = 0
LAST_VALUE = 30
ITERATION_COUNT = 50

def run():
    with grpc.insecure_channel('localhost:8080') as channel:
        stub = GeneratorService_pb2_grpc.GeneratorServiceStub(channel)
        for i in range(ITERATION_COUNT):
            for response in stub.generate(GeneratorService_pb2.GeneratorRequest(first_value=FIRST_VALUE, last_value=LAST_VALUE)):
                print(response)
run()
```

