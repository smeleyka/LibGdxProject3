package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by smeleyka on 07.07.17.
 */

public class Emmiter {

    ArrayList<Object> activeObjects;
    ArrayList<Object> deactiveObjects;

    public Emmiter(ArrayList<Object> activeObjects, ArrayList<Object> deactiveObjects) {
        this.activeObjects = activeObjects;
        this.deactiveObjects = deactiveObjects;
    }

    public void render(SpriteBatch batch){

    }

    public void update(float dt){

    }

    public void create (){

    }

    public void activate(){}

    public void deactivate(){}



}
