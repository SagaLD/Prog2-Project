package Exempelkoder;

public class TestExample {

    public static void main(String[] args) {
        CityExample stockholm = new CityExample("Stockholm");
        CityExample malmö = new CityExample("Malmö");
        CityExample oslo = new CityExample("Oslo");
        CityExample kiruna = new CityExample("Kiruna");
        CityExample köpenhamn = new CityExample("Köpenhamn");
        CityExample berlin = new CityExample("Berlin");

        ListGraphExample graph = new ListGraphExample();
        graph.add(stockholm);
        graph.add(malmö);
        graph.add(oslo);
        graph.add(kiruna);
        graph.add(köpenhamn);
        graph.add(berlin);


        graph.connect(köpenhamn, berlin, "Autobahn", 1000);
        graph.connect(stockholm, malmö, "E20", 660);
        graph.connect(stockholm, oslo, "E18", 400);
        graph.connect(oslo, malmö, "E5", 777);
        graph.connect(stockholm, kiruna, "E4", 1700);
        graph.connect(malmö, köpenhamn, "Broen", 7);

        //System.out.println(graph);

        System.out.println(graph.getShortestPath(malmö, kiruna));
        //System.out.println(graph.pathExists(stockholm, berlin));
        //System.out.println(graph.pathExists(malmö, kiruna));
    }
}
