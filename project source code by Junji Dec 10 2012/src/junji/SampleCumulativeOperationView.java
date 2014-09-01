package junji;

import processing.core.PApplet;

//a demo class only, not used in real purpose
public class SampleCumulativeOperationView extends PApplet{
	
	private static final String setupFilePath = "..\\setup.txt";
	private int ChangedWordColor;
	private int AddedWordColor;
	private int DeletedWordColor;
	private float textLeading;	//display text leading
	
	public void setup()
	{
		readSetupFile();
		size(650,650);
		background(255);
		smooth();
		  
		// Create the font
	    textFont(createFont("Georgia", 16));
		textLeading(textLeading);
	}

	private void readSetupFile() {
		//read the setup file and prepare all the parameters
		SetupFileReader sfr = SetupFileReader.getSetupFileReader(setupFilePath);
		
		this.ChangedWordColor = convertColorToInt(sfr.getChangedWordColor());
		this.AddedWordColor = convertColorToInt(sfr.getAddedWordColor());
		this.DeletedWordColor = convertColorToInt(sfr.getDeletedWordColor());
		
		this.textLeading = sfr.getTextLeading();
	}
	
	private int convertColorToInt(Color c) {
		return super.color(c.getR(),c.getG(),c.getB());
	}
	
	public void draw()
	{
		fill(DeletedWordColor);
		
		//y axis
		line(40+45,30,40+45,530);
		text("Word#", 40+45-60,40);
		
		//draw grids
		for(int i=0; i<(530-30)/40; ++i)
		{
			int x = 40+45;
			int y = 530-i*40;
			line(x,y,x+6,y);
			
			if(i>0)
			{
				String str = ""+(i)*1000;
				text(str, x-60, y);
			}
		}
		
		
		//x axis
		line(530,530,40+45,530);
		text("Date",515,555 );
		
		
		//arrow
		line(30+45,43,40+45,30);
		line(50+45,43,40+45,30);
		
		float rectW = 40;
		
		//first column
		fill(DeletedWordColor);
		rect(85+45,470,rectW,530-470);
		
		fill(this.ChangedWordColor);
		rect(85+45,430,rectW,470-430);
		
		fill(this.AddedWordColor);
		rect(85+45,395,rectW,430-395);
		
		fill(DeletedWordColor);
		text("09/03/01",85+45-10,550);
		
		
		//second column
		fill(DeletedWordColor);
		rect(85+45+60+50,450,rectW,530-450);
		
		fill(this.ChangedWordColor);
		rect(85+45+60+50,415,rectW,450-415);
		
		//the white one
		fill(255);
		rect(85+45+60+50,395,rectW,415-395);
		
		fill(this.AddedWordColor);
		rect(85+45+60+50,280,rectW,395-280);
		
		fill(DeletedWordColor);
		text("09/05/14",85+45+60+50-10,550);
		
		
		
		//third column
		fill(DeletedWordColor);
		rect(85+45+(60+50)*2,390,rectW,530-390);
		
		fill(this.ChangedWordColor);
		rect(85+45+(60+50)*2,360,rectW,390-360);
		
		//the white one
		fill(255);
		rect(85+45+(60+50)*2,280,rectW,360-280);
		
		fill(this.AddedWordColor);
		rect(85+45+(60+50)*2,123,rectW,280-123);
		
		fill(DeletedWordColor);
		text("09/08/24",85+45+220-10,550);
		
		//draw small rectangles
		fill(this.AddedWordColor);
		rect(500, 30, 20, 20);
		fill(DeletedWordColor);
		text("Added",530,40);
		
		fill(this.ChangedWordColor);
		rect(500, 70, 20, 20);
		fill(DeletedWordColor);
		text("Changed",530,80);
		
		fill(DeletedWordColor);
		rect(500, 110, 20, 20);
		fill(DeletedWordColor);
		text("Deleted",530,120);
		
		fill(255);
		rect(500, 150, 20, 20);
		fill(DeletedWordColor);
		text("Unchanged",530,160);
		
	}
}
