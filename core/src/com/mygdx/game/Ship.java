package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import static java.lang.Math.*;
import static com.mygdx.game.MyGdxGame.*;

/**
 * Created by smeleyka on 05.07.17.
 */

public class Ship {
    int shipH;
    int shipW;
    Texture texture;
    Vector2 position;
    Vector2 velocity;
    float angle;
    float angleSpeed;
    float enginePower;

    public Ship(Texture texture, Vector2 position, Vector2 velocity) {
        this.texture = texture;
        this.position = position;
        this.velocity = velocity;
        angleSpeed = 3f;
        enginePower = 600;
        shipH = texture.getHeight();
        shipW = texture.getWidth();
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture,position.x-shipW/2,position.y-shipH/2,32,32,64,64,1,1,(float)toDegrees(angle),0,0,64,64,false,false);
    }

    public void update(float dt) {
        if (position.x-shipW/2>SCREEN_W) position.x=-shipW/2;
        if (position.x+shipW/2<0) position.x=SCREEN_W+shipW/2;
        if (position.y-shipH/2>SCREEN_H) position.y=-shipH/2;
        if (position.y+shipH/2<0) position.y=SCREEN_H+shipH/2;

        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            velocity.add((float)cos(angle)*enginePower*dt,(float)sin(angle)*enginePower*dt);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            velocity.sub((float)cos(angle)*enginePower*dt,(float)sin(angle)*enginePower*dt);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            angle+=angleSpeed*dt;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            angle-=angleSpeed*dt;
        }



        velocity.scl(0.985f);
        position.mulAdd(velocity,dt);
    }
}
