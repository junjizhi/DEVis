package junji;

import processing.core.PImage;

public class TextToDisplay
{
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public float getTextWidth() {
		return textWidth;
	}

	public void setTextWidth(float textWidth) {
		this.textWidth = textWidth;
	}

	public float getTextHeight() {
		return textHeight;
	}

	public void setTextHeight(float textHeight) {
		this.textHeight = textHeight;
	}

	public PImage getBackupImage() {
		return backupImage;
	}

	public void setBackupImage(PImage piBack) {
		this.backupImage = piBack;
	}

	public float gettPosX() {
		return tPosX;
	}

	public void settPosX(float tPosX) {
		this.tPosX = tPosX;
	}

	public float gettPosY() {
		return tPosY;
	}

	public void settPosY(float tPosY) {
		this.tPosY = tPosY;
	}

	public boolean isbDisplay() {
		return bDisplay;
	}

	public void setbDisplay(boolean bDisplay) {
		this.bDisplay = bDisplay;
	}

	public float getTtH() {
		return ttH;
	}

	public void setTtH(float ttH) {
		this.ttH = ttH;
	}

	private String text = null;
	private float textWidth, textHeight;
	private PImage backupImage = null; // Off-screen graphic buffer
	public float gettColorR() {
		return tColorR;
	}

	public void settColorR(float tColorR) {
		this.tColorR = tColorR;
	}

	public float gettColorG() {
		return tColorG;
	}

	public void settColorG(float tColorG) {
		this.tColorG = tColorG;
	}

	public float gettColorB() {
		return tColorB;
	}

	public void settColorB(float tColorB) {
		this.tColorB = tColorB;
	}

	private float tPosX ,tPosY;
	private boolean bDisplay = false;
	private float ttH ;
	
	//default text color: purple(200,0,255);
	private float tColorR = 200, tColorG = 0, tColorB = 255;
	
//	private boolean bInitPiBack = false;
	public TextToDisplay(String txt, float tPosX ,float tPosY,float textWidth, 
			float textLeading, float textAscent, float textDescent)
	{
		//by default, the number of lines is 1
		this(txt,tPosX,tPosY,textWidth,textLeading,textAscent,textDescent,1);
	}
	
	public TextToDisplay(String txt, float tPosX ,float tPosY, float textWidth, float textLeading, float textAscent, float textDescent,int nLine)
	{
		this.tPosX = tPosX;
		this.tPosY = tPosY;
		text = txt;
		// Width of text
		this.textWidth = textWidth;
		// Height of a text line
		this.textHeight = textAscent + textDescent;
		
		ttH = textLeading*3;
		//number of lines
		ttH*=nLine;
	}
	
	public void setColor(float r, float g, float b)
	{
		this.tColorB = b;
		this.tColorG = g;
		this.tColorR = r;
	}
	
	public boolean isDisplayed()
	{
		return bDisplay;
	}
	
	public void setDisplay(boolean d)
	{
		bDisplay = d;
	}
	

}
