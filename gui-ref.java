//Should use an object for this but doing the example like this is for explanation
public int xmod[]= new int[2];//represents the modified location of the gui's x coordinate
public int ymod[] new int[2];//represents the modified location of the gui's y coordinate

public void myGui()
{
mc = modLoader.getMinecraftInstance();//if you're using modloader this is how you could make it update on screen size change

ScaledResolution resolution= new ScaledResolution( this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);

drawRect(xmod[0]-100,
/*******/ymod[0]-100,
/*******/xmod[0]+100,
/*******/ymod[0]+100,
/*******/0x99999999);


drawRect(xmod[1]-75,
/*******/ymod[1]-75,
/*******/xmod[1],
/*******/ymod[1],
/*******/0x99FFFFFF);
}
