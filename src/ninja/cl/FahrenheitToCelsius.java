package ninja.cl;

public class FahrenheitToCelsius {
    public float FAHRENHEIT = 64;

    public float convert(int fahrenheit) {
        float celsius = ((FAHRENHEIT - 32) * 5) / 9;
        return celsius;
    }
}
