package org.crashhunter.algorithm.singleInstance;

/**
 * Created by CrashHunter on 2020/9/7.
 */
class User {
    private static User ourInstance = new User();

    static User getInstance() {
        if (ourInstance == null) {
//            synchronized用于加锁
            synchronized (User.class) {
//                再判断一次，是防止new的过程中有个新的获取instance的请求在synchronized外等候
                if (ourInstance == null) {
                    ourInstance = new User();
                }
            }
        }
        return ourInstance;
    }

    private User() {
    }
}
