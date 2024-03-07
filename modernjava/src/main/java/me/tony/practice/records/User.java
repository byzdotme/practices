package me.tony.practice.records;

/**
 * @author tony.zhuby
 */
public record User(Long userId, String userName, String avatar) {
    public User {
        userId = 1000 + userId;
        userName = "name_" + userName;
    }

    public User(Long userId, String userName) {
        this(userId, userName, null);
    }
}
