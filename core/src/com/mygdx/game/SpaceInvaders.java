package com.mygdx.game;

import GameObjects.PlayerShip;
import Helpers.TakePhoto;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import Helpers.AssetLoader;
import Screens.GameScreen;

public class SpaceInvaders extends Game{
	private static String name;
	private static boolean android;
	private static TakePhoto takePhoto;

	@Override
	public void create() {
		Gdx.app.log("SpaceInvadersGame", "created");
		AssetLoader.loadBg();
		setScreen(new GameScreen());
		android=false;

	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
	public static String askForName(){
		Input.TextInputListener textListener = new Input.TextInputListener()
		{

			@Override
			public void input(String input)
			{
				System.out.println(input);
				name =input;
			}

			@Override
			public void canceled()
			{
				System.out.println("Aborted");


			}
		};
		Gdx.input.getTextInput(textListener, "Introduce your Name: ", "", "");


		return name;
	}

	public static String getName(){
		return name;
	}

	public static void setName(String n){
		name=n;
	}

    public static void setTakePhoto(TakePhoto takePhoto) {
        SpaceInvaders.takePhoto = takePhoto;
    }

	public static void hacerFoto(PlayerShip player){
		takePhoto.takePhoto(player);
	}
}
