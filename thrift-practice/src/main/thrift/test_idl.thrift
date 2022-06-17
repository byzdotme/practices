namespace java cn.bootz.account.api

include "common.thrift"

enum Gender {
    MALE = 1
    FEMALE = 2
    OTHER = 3
}

enum MemberState {
    VALID = 1
    INVALID = 2
    BANNED = 3
}

struct Member {
    1: required string member_id
    2: optional string name
    3: optional Gender gender
    4: optional i32 age
    5: optional MemberState state
    99: optional map<string, string> ext
}

exception MemberNotValidException {
    1: required string member_id
    2: optional string reason
}

service MemberService{
    Member queryById(1:string memberId) throws (1:MemberNotValidException e, 2:common.ApiException apie)
}