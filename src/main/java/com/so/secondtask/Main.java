/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.secondtask;

import java.util.ArrayList;
import java.util.List;

public class Main {

    List<City> cities;
    List<Connection> connections;

    
    public void execute() {
        cities = new ArrayList<>();
        connections = new ArrayList<>();
        Input in = new Input(cities, connections);
        System.out.println("Input quantity of tests");
        int testQuant = in.ifExist(10);
        for (int i = 0; i < testQuant; i++) {
            System.out.println("Test number " + (i + 1));
            in.input();
            System.out.println("Input index of the start city ");
            int from = in.ifExist(cities.size());
            System.out.println("Input index of the end city ");
            int to = in.ifExist(cities.size());

            CitiesMap map = new CitiesMap(cities, connections);
            CityDij dijkstra = new CityDij(map);
            dijkstra.execute(cities.get(from - 1));
            int result = dijkstra.getPath(cities.get(to - 1));
            if (result < 0) {
                System.out.println("No path found");
            }
            System.out.println("The legth of the path is " + dijkstra.getPath(cities.get(to - 1)));
        }

    }

    public static void main(String[] args) {
        Main m = new Main();
        m.execute();
    }
}
