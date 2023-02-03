namespace java.swift com.sankuai.sgmerchant.control.thrift.demo

struct Foo {
1: required string foo
2: required i32 num
3: optional string ext
}

union Demo {
1: required string strVal
2: required i32 intVal
3: required Foo fooVal
}

service FooSvr {
bool foo(1: required string foo, 2: required i32 num, 3: optional i32 cnt)
}