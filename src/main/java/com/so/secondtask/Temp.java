/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.secondtask;
 
/**
 * It's a class for temporary saving of input data
 */
public class Temp {
    private final int cityFrom;
    private final int cityTo;
    private final int cost;
    public Temp(int cityFrom, int cityTo, int cost){
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.cost = cost;
    }

    public int getCityFrom() {
        return cityFrom;
    }

    public int getCityTo() {
        return cityTo;
    }

    public int getCost() {
        return cost;
    }

    
}
