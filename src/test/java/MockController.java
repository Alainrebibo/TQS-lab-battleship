import model.Coordinate;
import model.Direction;
import model.Game;
import model.Ship;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class MockInputShips {

    private Game model;
    private ArrayList<Ship> ships;

    public ArrayList<Ship> getShips(){
        return ships;
    }
    public MockInputShips(Game model){
        //this.model = model;
        ships = new ArrayList<Ship>();

    }

    public void setInputShips(){
        // Size 1
        Ship ship = new Ship(new Coordinate(1,1), 1, Direction.VERTICAL);
        this.ships.add(ship);

        ship = new Ship(new Coordinate(1,2), 1, Direction.VERTICAL);
        this.ships.add(ship);

        ship = new Ship(new Coordinate(1,4), 1, Direction.VERTICAL);
        this.ships.add(ship);

        ship = new Ship(new Coordinate(1,6), 1, Direction.VERTICAL);
        this.ships.add(ship);

        //SIZE 2
        ship = new Ship(new Coordinate(3,1), 2, Direction.VERTICAL);
        this.ships.add(ship);

        ship = new Ship(new Coordinate(3,4), 2, Direction.VERTICAL);
        this.ships.add(ship);

        ship = new Ship(new Coordinate(3,6), 2, Direction.VERTICAL);
        this.ships.add(ship);

        //SIZE 3
        ship = new Ship(new Coordinate(5,1), 1, Direction.VERTICAL);
        this.ships.add(ship);

        ship = new Ship(new Coordinate(5,3), 1, Direction.VERTICAL);
        this.ships.add(ship);

        //SIZE 4
        ship = new Ship(new Coordinate(7,4), 1, Direction.VERTICAL);
        this.ships.add(ship);
    }

    public void setInputShipsFail(){

        Ship ship = new Ship(new Coordinate(-1,-1), 1, Direction.VERTICAL);
        this.ships.add(ship);

        ship = new Ship(new Coordinate(1,2), 1, Direction.VERTICAL);
        this.ships.add(ship);

        ship = new Ship(new Coordinate(1,2), 1, Direction.VERTICAL);
        this.ships.add(ship);

        ship = new Ship(new Coordinate(1,6), 4, Direction.VERTICAL);
        this.ships.add(ship);
        ship = new Ship(new Coordinate(1,6), 4, Direction.VERTICAL);
        this.ships.add(ship);
    }

    public void scanner(Integer dir){
        InputStream in = new ByteArrayInputStream(dir.toString().getBytes());
        System.setIn(in);
    }
}
