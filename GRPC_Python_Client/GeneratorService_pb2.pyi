from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from typing import ClassVar as _ClassVar, Optional as _Optional

DESCRIPTOR: _descriptor.FileDescriptor

class GeneratorRequest(_message.Message):
    __slots__ = ("first_value", "last_value")
    FIRST_VALUE_FIELD_NUMBER: _ClassVar[int]
    LAST_VALUE_FIELD_NUMBER: _ClassVar[int]
    first_value: int
    last_value: int
    def __init__(self, first_value: _Optional[int] = ..., last_value: _Optional[int] = ...) -> None: ...

class GeneratorResponse(_message.Message):
    __slots__ = ("generated_value",)
    GENERATED_VALUE_FIELD_NUMBER: _ClassVar[int]
    generated_value: int
    def __init__(self, generated_value: _Optional[int] = ...) -> None: ...
