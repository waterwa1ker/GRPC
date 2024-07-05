import grpc

import GeneratorService_pb2
import GeneratorService_pb2_grpc

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