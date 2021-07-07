package com.sg.mthree.webstore.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {

    Profile profile = new Profile();

    @Test
    void getBasicInformation() {
        profile.getBasicInformation(0);
    }

    @Test
    void getPaymentInformation() {

    }

    @Test
    void getSecurityInformation() {

    }
}