/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.secondtask;

public class Connection {
 
    private final City start;
    private final City destination;
    private final int cost;

    public Connection(  City start, City destination, int cost) {
         
        this.start = start;
        this.destination = destination;
        this.cost = cost;
    }

     

    public City getDestination() {
        return destination;
    }

    public City getStart() {
        return start;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return start + " " + destination;
    }

}
