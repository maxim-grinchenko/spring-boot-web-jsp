package com.resolution.Utils;

import com.resolution.domain.entity.User;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author maxima - 30.07.2018
 */

public class Util {

    public static User createUser() {
        User user = new User();
        user.setName(RandomStringUtils.randomAlphabetic(3, 6));
        user.setEmail(RandomStringUtils.randomAlphabetic(4,7)
            + "@"
            + RandomStringUtils.randomAlphabetic(3,5)
            + ".com");
        user.setPhone("096"+RandomStringUtils.randomNumeric(7));
        user.setPassword("*****");

        return user;
    }
}
