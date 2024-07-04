package com.panel.LRapp.utill;

import java.security.SecureRandom;

public class OTPUtil {
    private static final SecureRandom random = new SecureRandom();
    private static final int OTP_LENGTH = 6;

    public static int generateOTP() {
        // Calculate the range for the OTP length 6 digits -> 100000 to 999999
        int min = (int) Math.pow(10, OTP_LENGTH - 1);
        int max = (int) Math.pow(10, OTP_LENGTH) - 1;
        return random.nextInt(max - min + 1) + min;
    }
}
