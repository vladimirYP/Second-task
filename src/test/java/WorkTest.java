/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import com.so.secondtask.CitiesMap;
import com.so.secondtask.City;
import com.so.secondtask.CityDij;
import com.so.secondtask.Connection;
import java.util.ArrayList; 
import java.util.List;
import org.junit.Test; 


public class WorkTest {

    List<City> cities;
    List<Connection> connections;

    public WorkTest() {
    }

    @Test
    public void test() {
        cities = new ArrayList<>();
        connections = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cities.add(new City("City number " + i));
        } 
        connections.add(new Connection(cities.get(0), cities.get(1), 2));
        connections.add(new Connection(cities.get(0), cities.get(2), 10));
        connections.add(new Connection(cities.get(0), cities.get(3), 1));
        connections.add(new Connection(cities.get(1), cities.get(2), 1));
        connections.add(new Connection(cities.get(3), cities.get(2), 2));
        connections.add(new Connection(cities.get(2), cities.get(4), 3));
        CitiesMap map = new CitiesMap(cities, connections);
        CityDij dijkstra = new CityDij(map);
        dijkstra.execute(cities.get(0));
        System.out.println(dijkstra.getPath(cities.get(4))+" price");
    }
}
