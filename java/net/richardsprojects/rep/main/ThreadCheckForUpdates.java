package net.richardsprojects.rep.main;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class ThreadCheckForUpdates implements Runnable {

	private EntityPlayer player;
	
	public ThreadCheckForUpdates(EntityPlayer player)
	{
		this.player = player;
	}
	
	@Override
	public void run() 
	{
	   String returnData = "";
		  try {
			   URL url = new URL("https://dl.dropboxusercontent.com/u/97875111/RecipeExpansionPack/currentVersion.txt");
			   Scanner s = new Scanner(url.openStream());
				   
			   while (s.hasNextLine())
               {
				   // Read an entire line, which contains all the details for 1 account
		           returnData = s.nextLine();
		       }
			   s.close();

		  }
		  catch(IOException ex) {
			  ex.printStackTrace();
			  returnData = "ERROR";
			}
		  
		  if(!TempData.players.contains(player.getDisplayName())) {
			  player.addChatComponentMessage(new ChatComponentText("\u00a7eThank you for downloading the Recipe Expansion Pack!"));
		  }
		  
		  if(returnData.equals("ERROR"))
		  {
			  if(!TempData.players.contains(player.getDisplayName())) {
				  player.addChatComponentMessage(new ChatComponentText("\u00a7eError checking for updates to the Recipe Expansion Pack."));
			  }
		  }
		  else if(returnData.equals("0.2.5 Alpha"))
		  {
			  if(!TempData.players.contains(player.getDisplayName())) {
				  player.addChatComponentMessage(new ChatComponentText("\u00a7eThe Recipe Expansion Pack is up to date. v0.2.5 Alpha"));
			  }
		  }
		  else
		  {
			  if(!TempData.players.contains(player.getDisplayName())) {
				  player.addChatComponentMessage(new ChatComponentText("\u00a7eA newer version of the mod is available! v" + returnData));
			  }
		  }
		  TempData.players = TempData.players + player.getDisplayName() + ",";
	  }
		
}


