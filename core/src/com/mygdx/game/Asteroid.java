package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import static com.mygdx.game.MyGdxGame.SCREEN_H;
import static com.mygdx.game.MyGdxGame.SCREEN_W;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toDegrees;

/**
 * Created by smeleyka on 05.07.17.
 */

public class Asteroid {
    int shipH;
    int shipW;
    Texture texture;
    Vector2 position;
    Vector2 velocity;
    float angle;
    float angleSpeed;
    float enginePower;

    public Asteroid(Texture texture, Vector2 position, Vector2 velocity) {
        this.texture = texture;
        this.position = position;
        this.velocity = velocity;
        angleSpeed = 3f;
        enginePower = 600;
        shipH = texture.getHeight();
        shipW = texture.getWidth();
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture,position.x-shipW/2,position.y-shipH/2,shipW/2,shipH/2,shipW,shipH,1,1,(float)toDegrees(angle),0,0,shipW,shipH,false,false);
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
