package sample;

import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;

public class Sprites {
    private ArrayList<Image> itemSprites;
    private ArrayList<Image> terrainSprites;
    private ArrayList<Image> AESprites;
    private ArrayList<Image> playerSprites;
    private Image mapTransitionSprite;
    private Image obsticleItem;


    private String workingDir;
    public Sprites() {

        workingDir = System.getProperty("user.dir")+"/Game";

        //System.out.println(workingDir);
        itemSprites = new ArrayList<Image>();
        terrainSprites = new ArrayList<Image>();
        AESprites = new ArrayList<Image>();
        playerSprites = new ArrayList<Image>();
        initializeSprites();
    }

    private void initializeSprites() {
        //Load item textures

        itemSprites.add(getImage(workingDir + "/src/sample/sprites/potion2.png"));
        itemSprites.add(getImage(workingDir + "/src/sample/sprites/sword.png"));

        //Load terrain textures

        terrainSprites.add(getImage(workingDir + "/src/sample/sprites/grass.png"));
        terrainSprites.add(getImage(workingDir + "/src/sample/sprites/water.png"));
        terrainSprites.add(getImage(workingDir + "/src/sample/sprites/mountains.png"));

        AESprites.add(getImage(workingDir + "/src/sample/sprites/lava.png"));
        AESprites.add(getImage(workingDir + "/src/sample/sprites/health2.png"));
        AESprites.add(getImage(workingDir + "/src/sample/sprites/star.png"));
        AESprites.add(getImage(workingDir + "/src/sample/sprites/skull.png"));

        playerSprites.add(getImage(workingDir + "/src/sample/sprites/characterGuy.png"));
        playerSprites.add(getImage(workingDir + "/src/sample/sprites/characterGirl.png"));
        playerSprites.add(getImage(workingDir + "/src/sample/sprites/characterAdventurer.png"));
        playerSprites.add(getImage(workingDir + "/src/sample/sprites/characterSoldier.png"));

        mapTransitionSprite = getImage(workingDir + "/src/sample/sprites/door.png");
        obsticleItem = getImage(workingDir + "/src/sample/sprites/rock.png");

        //playerImg = getImage(workingDir + "/src/sample/sprites/pikachu.png");


    }

    public Image getTileObjectSprite(int SN, int spec) {


        if(SN == 1) {//AEHealing
            return AESprites.get(0);
        } else if(SN == 2) {//AEDamage
            return AESprites.get(1);
        } else if(SN == 3) {//AEExperience
            return AESprites.get(2);
        } else if(SN == 4 || SN == 7) {//Item
            return getItemImage(spec);
        } else if(SN == 5){//Map transition
            return mapTransitionSprite;
        } else if(SN == 6){//Instadeath
            return AESprites.get(3);
        } else {
            return obsticleItem;
        }
    }

    public Image getItemImage(int itemID) {
        if(itemID >= itemSprites.size()) {
            return itemSprites.get(0);
        }
        return itemSprites.get(itemID);
    }

    public Image getTerrainImage(char type) {
        if(type == 'G') {
            return terrainSprites.get(0);
        } else if(type == 'W') {
            return terrainSprites.get(1);
        } else {
            return terrainSprites.get(2);
        }
    }

    public Image getPlayerSprite(int ind) {
        return playerSprites.get(ind);
    }

    private Image getImage(String fp) {
        File file = new File(fp);
        Image image = new Image(file.toURI().toString());
        return image;
    }


}