namespace java me.tonyirl.api.common

struct PageRequest {
    1: required i32 pageNum
    2: required i32 pageSize
}

struct PageInfo {
    1: required i32 pageNum
    2: required i32 pageSize
    3: optional i32 total
    4: optional i32 pageCount
}

struct ApiStatus {
    1: required i32 code = 200
    2: required string msg = "ok"
    99: optional map<string, string> ext
}

exception ApiException {
    1: required i32 code = 500
    2: optional string msg
    99: optional map<string, string> ext
}