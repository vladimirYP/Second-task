/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.secondtask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CityDij {

    private final List<City> cities;
    private final List<Connection> connections;
    private Set<City> passedCities;
    private Set<City> unpassedCities;
    private Map<City, City> predecessors;
    private Map<City, Integer> cost;

    public CityDij(CitiesMap graph) {
        this.cities = new ArrayList<>(graph.getCities());
        this.connections = new ArrayList<>(graph.getConnections());
    }

    /**
     * This method calculates all shortest passes from the source
     */
    public void execute(City source) {
        passedCities = new HashSet<>();
        unpassedCities = new HashSet<>();
        cost = new HashMap<>();
        predecessors = new HashMap<>();
        cost.put(source, 0);
        unpassedCities.add(source);
        while (unpassedCities.size() > 0) {
            City node = getMinimum(unpassedCities);
            passedCities.add(node);
            unpassedCities.remove(node);
            findMinimalCosts(node);
            
        }
    }

    /**
     * This method finds the minimum cost of the path from the source to all
     * other adjacent cities, saves it, saves the path itself and marks the
     * target city as unpassed
     *
     */
    private void findMinimalCosts(City source) {
        List<City> adjacentCities = getNeighbors(source);
        for (City target : adjacentCities) {
            if (getLowestCost(target) > getLowestCost(source) + getCost(source, target)) {
                cost.put(target, getLowestCost(source) + getCost(source, target));
                predecessors.put(target, source);
                unpassedCities.add(target);
            }
        }

    }

    /**
     * This method returns the cost of the pass between 2 cities 
     * @param from - the start city
     * @param target- the target city 
     * @return returns the price of the path or -1 if no path found
     */
    private int getCost(City from, City target) {
        for (Connection edge : connections) {
            if (edge.getStart().equals(from) && edge.getDestination().equals(target)) {
                return edge.getCost();
            }
        }
        return -1;
    }

    /**
     * This method creates the list of all adjacent cities of the source one
     *
     * @param source - the source City
     * @return list of all cities
     */
    private List<City> getNeighbors(City source) {
        List<City> neighbors = new ArrayList<>();
        for (Connection edge : connections) {
            if (edge.getStart().equals(source) && !isPassed(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

   
    private City getMinimum(Set<City> cities) {
        City minimum = null;
        for (City city : cities) {
            if (minimum == null) {
                minimum = city;
            } else if (getLowestCost(city) < getLowestCost(minimum)) {
                minimum = city;
            }
        }
        return minimum;
    }

    private boolean isPassed(City city) {
        return passedCities.contains(city);
    }

    /**
     * This method returns the cost of the path to destiion city
     *
     * @param source - the source City
     * @return cost of the path to destiion city 
     * or Integer.MAX_VALUE if the cost is unknown yet
     */
    private int getLowestCost(City destination) {
        Integer d = cost.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

//     This method returns the path from the source to the selected target and
//     -1 if no path exists
    public int getPath(City target) {
        LinkedList<City> path = new LinkedList<>();
        City step = target;
        int price = 0;
        if (predecessors.get(step) == null) {
            return -1;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            price += getCost(predecessors.get(step), step);
            step = predecessors.get(step);
            path.add(step);
        }
        return price;
    }

}
