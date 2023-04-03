package com.example.konversisuhu.Rumus;

import android.content.Context;

public class Temperatures {
    private Context context;
    
    public Temperatures(Context Context) {
        this.context = context;
    }

    //    =========
    //     CELCIUS
    //    =========

    //     (formula conversion celcius to reamur)
    public String CelciusToReamur(double celcius) {
        double R = (4.0 / 5.0) * celcius;
        return check_after_decimal_point(R);
    }
    //    (formula conversion celcius to fahrenheit)
    public String CelciusToFahrenheit(double celcius) {
        double F = (9.0 / 5.0) * celcius + 32;
        return check_after_decimal_point(F);
    }

    //    (formula conversion celcius to kelvin)
    public String CelciusToKelvin(double celcius) {
        double K = celcius + 273.15;
        return check_after_decimal_point(K);
    }

    //    ========
    //     REAMUR
    //    ========

    //    (formula conversion celcius to reamur)
    public String ReamurToCelcius(double reamur) {
        double C = reamur / 0.8;
        return check_after_decimal_point(C);
    }
    //    (formula conversion celcius to fahrenheit)
    public String ReamurToFahrenheit(double reamur) {
        double F = reamur * 2.25 + 32;
        return check_after_decimal_point(F);
    }

    //    (formula conversion celcius to kelvin)
    public String ReamurToKelvin(double reamur) {
        double K = reamur / 0.8 + 273.15;
        return check_after_decimal_point(K);
    }

    //    ============
    //     FAHRENHEIT
    //    ============

    //    (formula conversion fahrenheit to celcius)
    public String FahrenheitToCelcius(double fahrenheit) {
        double C = (fahrenheit - 32) / 0.8;
        return check_after_decimal_point(C);
    }

    //    (formula conversion fahrenheit to reamur)
    public String FahrenheitToReamur(double fahrenheit) {
        double R = (fahrenheit - 32) / 0.44;
        return check_after_decimal_point(R);
    }

    //    (formula conversion fahrenheit to kelvin)
    public String FahrenheitToKelvin(double fahrenheit) {
        double K = (fahrenheit + 459.67) / 1.8;
        return check_after_decimal_point(K);
    }

    public String check_after_decimal_point(double decimal) {
        String result = null;
        String[] after_point = String.valueOf(decimal).split("[:.]");
        if (after_point[after_point.length - 1].equals("0")) {
            result = after_point[0];
        } else {
            result = String.valueOf(decimal).replace(".", ",");
        }
        return result;
    }
}
