/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.secondtask;

import java.util.List;

public class CitiesMap {
    private final List<City> cities;
    private final List<Connection> connections;

    public CitiesMap(List<City> cities, List<Connection> connections) {
        this.cities = cities;
        this.connections = connections;
    }

    public List<City> getCities() {
        return cities;
    }

    public List<Connection> getConnections() {
        return connections;
    }
}
