/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.secondtask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    private List<City> cities;
    private List<Connection> connections;

    //It's a class for temporary saving of input data
    private List<Temp> t;
    private Scanner scn;

    public Input(List<City> cities, List<Connection> connections) {
        this.cities = cities;
        this.connections = connections;
    }

    public void input() {
        t = new ArrayList<>();

        System.out.println("Input quantity of cities");

        int cityQuant = ifExist(10000);
        for (int j = 0; j < cityQuant; j++) {
            scn = new Scanner(System.in);
            System.out.println("Input city name");

            String name = scn.nextLine();
            City location = new City(name);
            cities.add(location);

            System.out.println("Input quantity of connections of this city");

            int cityConnectQuant = readPositiveInteger();
            for (int k = 0; k < cityConnectQuant; k++) {

                System.out.println("Input city to");

                int to = ifExist(cityQuant);

                System.out.println("Input cost");

                int cost = readPositiveInteger();
                t.add(new Temp(j, to - 1, cost));

            }
        }

        for (int j = 0; j < t.size(); j++) {
            addConnection(t.get(j).getCityFrom(), t.get(j).getCityTo(), t.get(j).getCost());
        }

    }

    /**
     * This method reads a symbol and checks, whether the symbol
     * is not equal to zero or is greater than a certain bound
     * @return returnes inputed integer
     */
    public int ifExist(int listLength) {
        boolean b = false;
        int index = 0;
        while (!b) {
            index = readPositiveInteger();
            if (index > listLength || index == 0) {
                System.out.println("Index is out of bounds ");
                continue;
            }
            b = true;
        }
        return index;
    }

    /**
     * The method is used for adding a new edge
     *
     * @param sourceLocNum number of city from
     * @param destLocNum number of the destination city
     * @param cost cost of the edge
     */
    private void addConnection(int sourceLocNum, int destLocNum,
            int cost) {
        Connection connection = new Connection(cities.get(sourceLocNum), cities.get(destLocNum), cost);
        connections.add(connection);
    }

    /**
     * This method reads a symbol and checks, whether the symbol is an integer
     * or not
     *
     * @return returnes integer
     */
    private int readPositiveInteger() {
        boolean b = false;
        int res = 0;
        while (!b) {
            scn = new Scanner(System.in);
            if (scn.hasNextInt()) {

                res = scn.nextInt();
                if (res >= 0) {
                    break;
                }
            }
            System.out.println("Input a NUMBER >=0");
        }
        return res;
    }
}
