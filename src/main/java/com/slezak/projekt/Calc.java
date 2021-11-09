package com.slezak.projekt;

import java.text.DecimalFormat;

public class Calc {
    public static float kredyt(float wynagrodzenie, float ilerat){

        float wysokosckredytu = wynagrodzenie * 15;
        float rata = wysokosckredytu / ilerat;

        return rata;
    }
    public static  float wysokosc(float wynagrodzenie){

        float wysokosckredytu = wynagrodzenie * 15;
        float wysokosckredytuodsetki = wysokosckredytu + wysokosckredytu * 0.6f;
        return wysokosckredytuodsetki;
    }
}