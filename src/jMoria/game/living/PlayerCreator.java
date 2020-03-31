package jMoria.game.living;

import jMoria.game.ResourcePackage;
import jMoria.game.enums.Sex;
import jMoria.game.utils.CSVReader;

import java.util.List;

import static jMoria.game.utils.Math.randInt;
import static jMoria.game.utils.Math.randNor;

public class PlayerCreator {

    private CSVReader csvReader;
    private Player player;

    // RACE and SEX are chosen by this point.
    public PlayerCreator(ResourcePackage gameResources) {
        this.player = gameResources.player;
        this.csvReader = new CSVReader(gameResources);
    }

    public void setAgeHeightWeight() {

        csvReader.setFileName("PlayerAgeWeightHeight.csv");
        List<Integer> data = csvReader.getLineDataFromKey(player.race.getRace());

        int baseAge = data.get(0);
        int ageMod = data.get(1);
        int baseHeight;
        int modHeight;
        int baseWeight;
        int modWeight;

        if (player.sex == Sex.MALE) {
            baseHeight = data.get(2);
            modHeight = data.get(3);
            baseWeight = data.get(6);
            modWeight = data.get(7);
        } else {
            baseHeight = data.get(4);
            modHeight = data.get(5);
            baseWeight = data.get(8);
            modWeight = data.get(9);
        }

        player.age = baseAge + randInt(ageMod);
        player.height = randNor(baseHeight, modHeight);
        player.weight = randNor(baseWeight, modWeight);

    }

}


//temp
//    CSVReader reader = new CSVReader(gameResources, "PlayerAgeWeightHeight.csv");
//    List<Integer> data = reader.getLineDataFromKey("Dwarf");
//    for (Integer x : data) {
//            System.out.println(x);
//
//            }

//
