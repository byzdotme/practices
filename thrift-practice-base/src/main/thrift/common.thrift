namespace java cn.bootz.api.thrift.common

struct PageRequest {
    1: required i32 page_num
    2: required i32 page_size
}

struct PageInfo {
    1: required i32 page_num
    2: required i32 page_size
    3: optional i32 total
    4: optional i32 page_count
}

struct ApiStatus {
    1: required i32 code
    2: required string msg = "ok"
    99: optional map<string, string> ext
}

exception ApiException {
    1: required i32 code
    2: optional i32 sub_code
    3: optional string msg
    99: optional map<string, string> ext
}