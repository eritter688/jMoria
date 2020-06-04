//package jMoria.game.player;
//
//import static jMoria.game.utils.Math.randInt;
//import static jMoria.game.utils.Math.randNor;
//
//import jMoria.game.ResourcePackage;
//import jMoria.game.player.enums.Sex;
//import jMoria.game.utils.CSVReader;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class PlayerCreator {
//
//  private CSVReader csvReader;
//  private Player player;
//  private Map<String, Integer> values = new HashMap<>();
//
//  public PlayerCreator(ResourcePackage gameResources) {
//    this.player = gameResources.player;
//    this.csvReader = new CSVReader(gameResources);
//    readAllData();
//  }
//
//  private void readAllData() {
//    readAgeHeightWeightData();
//  }
//
//  public void rollPlayerValues() {
//    setAgeHeightWeight();
//  }
//
//  private void readAgeHeightWeightData() {
//    csvReader.setFileName("PlayerAgeWeightHeight.csv");
//    List<Integer> data = csvReader.getLineDataFromKey(player.race.getRace());
//
//    values.put("baseAge", data.get(0));
//    values.put("ageMod", data.get(1));
//
//    if (player.sex == Sex.MALE) {
//      values.put("baseHeight", data.get(2));
//      values.put("modHeight", data.get(3));
//      values.put("baseWeight", data.get(4));
//      values.put("modWeight", data.get(5));
//    } else {
//      values.put("baseHeight", data.get(6));
//      values.put("modHeight", data.get(7));
//      values.put("baseWeight", data.get(8));
//      values.put("modWeight", data.get(9));
//    }
//
//  }
//
//  private void readHistoryData() {
//
//  }
//
//  private void setAgeHeightWeight() {
//    player.age = values.get("baseAge") + randInt(values.get("ageMod"));
//    player.height = randNor(values.get("baseHeight"), values.get("modHeight"));
//    player.weight = randNor(values.get("baseWeight"), values.get("modWeight"));
//  }
//
//  private void setHistoryData() {
//
//  }
//
//}
//
////temp
////    CSVReader reader = new CSVReader(gameResources, "PlayerAgeWeightHeight.csv");
////    List<Integer> data = reader.getLineDataFromKey("Dwarf");
////    for (Integer x : data) {
////            System.out.println(x);
////
////            }
//
////
