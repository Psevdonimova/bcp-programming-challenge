package de.bcxp.challenge.country;

public class CountryInfo {
    private final String country;
    private final double population;
    private final double area;

    public CountryInfo(String country, double density, double area) {
        this.country = country;
        this.population = density;
        this.area = area;
    }

    public String getCountry() {
        return country;
    }

    public Double getPopulation() {
        return population;
    }

    public double getArea() {
        return area;
    }
}
