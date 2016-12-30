package interfaces;

class Calculation {

    protected double calculate(double value, String from, String to, String conversion) {
        double result = 0;
        //, "Fahrenheit",
        if("Temperature".equals(conversion)) {
            if("Celsius".equals(from)) {
                switch (to) {
                    case "Celsius":
                        result = value;
                        break;
                    case "Fahrenheit":
                        result = (value * 1.8) + 32;
                        break;
                    case "Kelvin":
                        result = value + 273.15;

                }
            }
            if("Fahrenheit".equals(from)) {
                switch (to) {
                    case "Celsius":
                        result = (value - 32) / 1.8;
                        break;
                    case "Fahrenheit":
                        result = value;
                        break;
                    case "Kelvin":
                        result = ((value - 32) / 1.8) + 273.15;
                        break;
                }
            }
            if("Kelvin".equals(from)) {
                switch (to) {
                    case "Celsius":
                        result = value - 273.15;
                        break;
                    case "Fahrenheit":
                        result = ((value - 273.15) * 1.8) + 32;
                        break;
                    case "Kelvin":
                        result = value;
                        break;
                }
            }
        }
        if("Length".equals(conversion)) {
            if("Meter".equals(from)) {
                switch (to) {
                    case "Meter":
                        result = value;
                        break;
                    case "Kilometer":
                        result = value / 1000;
                        break;
                    case "Miles":
                        result = value / 1609.344;
                        break;
                }
            }
            if("Kilometer".equals(from)) {
                switch (to) {
                    case "Meter":
                        result = value * 1000;
                        break;
                    case "Kilometer":
                        result = value;
                        break;
                    case "Miles":
                        result = value * 1000 / 1609.344;
                        break;
                }
            }
            if("Miles".equals(from)) {
                switch (to) {
                    case "Meter":
                        result = value * 1609.344;
                        break;
                    case "Kilometer":
                        result = value * 1609.344 / 1000;
                        break;
                    case "Miles":
                        result = value;
                        break;
                }
            }
        }
        if("Area".equals(conversion)) {
            if("Perch".equals(from)) {
                switch (to) {
                    case "Perch":
                        result = value;
                        break;
                    case "Rood":
                        result = value * 0.0250000001384;
                        break;
                    case "Acre":
                        result = value * 0.00625;
                        break;
                    case "Hectare":
                        result = value * 0.002529285264;
                }
            }
            if("Rood".equals(from)) {
                switch (to) {
                    case "Perch":
                        result = value / 0.0250000001384;
                        break;
                    case "Rood":
                        result = value;
                        break;
                    case "Acre":
                        result = value * 0.249999998616;
                        break;
                    case "Hectare":
                        result = value * 0.10117141;
                }
            }
            if("Acre".equals(from)) {
                switch (to) {
                    case "Perch":
                        result = value / 0.00625;
                        break;
                    case "Rood":
                        result = value * 4.00000002214;
                        break;
                    case "Acre":
                        result = value;
                        break;
                    case "Hectare":
                        result = value * 0.40468564224;
                }
            }
            if("Hectare".equals(from)) {
                switch (to) {
                    case "Perch":
                        result = value / 0.002529285264;
                        break;
                    case "Rood":
                        result = value / 0.10117141;
                        break;
                    case "Acre":
                        result = value / 0.40468564224;
                        break;
                    case "Hectare":
                        result = value;
                }
            }
        }
        if("Volume".equals(conversion)) {
            if("Cubic Decimeter".equals(from) || "Liter".equals(from)) {
                switch (to) {
                    case "Cubic Decimeter":
                        result = value;
                        break;
                    case "Cubic Meter":
                        result = value * 0.001;
                        break;
                    case "Liter":
                        result = value;
                        break;
                }
            }
            if("Cubic Meter".equals(from)) {
                switch (to) {
                    case "Cubic Decimeter":
                        result = value * 1000;
                        break;
                    case "Cubic Meter":
                        result = value;
                        break;
                    case "Liter":
                        result = value * 1000;
                        break;
                }
            }
        }
        if("Weight".equals(conversion)) {
            if("Pound".equals(from)) {
                switch (to) {
                    case "Pound":
                        result = value;
                        break;
                    case "Ounce":
                        result = value * 16;
                        break;
                    case "Kilogram":
                        result = value * 0.453592;
                        break;
                }
            }
            if("Ounce".equals(from)) {
                switch (to) {
                    case "Pound":
                        result = value / 16;
                        break;
                    case "Ounce":
                        result = value;
                        break;
                    case "Kilogram":
                        result = value * 0.0283495;
                        break;
                }
            }
            if("Kilogram".equals(from)) {
                switch (to) {
                    case "Pound":
                        result = value / 0.453592;
                        break;
                    case "Ounce":
                        result = value / 0.0283495;
                        break;
                    case "Kilogram":
                        result = value;
                        break;
                }
            }
        }
        return result;
    }
}
