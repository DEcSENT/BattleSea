import java.util.ArrayList;

/**
 * Created by Space 5 on 25.02.2017.
 */
public class DotCom {

    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> cellLocations){
        locationCells = cellLocations;
    }

    public void setName(String n){
        name = n;
    }

    public String checkYourself(String userInput){
        String result = "Мимо";
        int index = locationCells.indexOf(userInput);
        if (index >= 0){
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "Корабль уничтожен";
                System.out.println("Упс, Скайнет потопил "+ name + " ");
            } else {
                result = "Попал";
            }
        }
        return result;
    }



}