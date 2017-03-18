import java.util.ArrayList;

/**
 * Created by Space 5 on 28.02.2017.
 */
public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<>();
    private int numOfGuesses = 0;
    private String[] ar_string = {"a", "b", "c", "d", "e", "f", "g"};
    private int[] ar_int = {0, 1, 2, 3, 4, 5, 6};
    public static ArrayList array = new ArrayList();


    private void setUpGame(){
        DotCom one = new DotCom();
        one.setName("USS Jiguli");
        DotCom two = new DotCom();
        two.setName("USS Normandy");
        DotCom three = new DotCom();
        three.setName("USS Enterprise");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        for (int i = 0; i < ar_string.length; i++){
            for (int j = 0; j < ar_string.length; j++){
                array.add(ar_string[i]+ar_int[j]);
            }
        }

        System.out.println("Ваша цель - уничтожить этот мир.");
        System.out.println("Попытайтесь сделать это быстро...");

        for (DotCom dotComToSet : dotComsList){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying(){
        while (!dotComsList.isEmpty()){
            String userGuess = helper.getUserInput("Скайнет сделал ход: ");
            checkUserGuess(userGuess);
        }
        finishGame();
    }
    public  void checkUserGuess(String userGuess){
        String result = "Мимо";
        numOfGuesses++;
        for (DotCom dotComToTest : dotComsList){
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("Попал")){
                break;
            }
            if (result.equals("Корабль уничтожен")){
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame(){
        System.out.println();
        System.out.println("Скайнет уничтожил весь флот!");
        if (numOfGuesses <= 18){
            System.out.println("Неплохо. Эта игра заняла: "  + numOfGuesses +" ходов.");
        } else {
            System.out.println("Это всё заняло много времени. Но Скайнет уничтожил флот за "  + numOfGuesses +" выстрелов.");
            //System.out.println("Рыбы водят хороводы вокруг вокруг ваших промахов.");
        }
    }

    public static void main(String[] args) {
        double start = System.currentTimeMillis();
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
        double finish = System.currentTimeMillis();
        System.out.println("Уничтожение флота заняло: "+ (finish-start) + " мс");
    }
}
