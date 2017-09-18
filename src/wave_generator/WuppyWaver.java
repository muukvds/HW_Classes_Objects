package wave_generator;

import javax.swing.JFrame;

/**
 * @author <your name dear student!> & Bob van der Putten
 * @version 1
 * 
 */

public class WuppyWaver
{
	private JFrame aii_Frame;
	private AiiCanvas aii_Canvas;

	private Wuppy[] m_Wuppies;

	private int m_WuppyAmount;
	
	
////////////////// YOUR CODE - START ///////////////////////	
	
	// Use this space to declare your own instance 
	// variables if you think you need them:

	
/////////////////// YOUR CODE - END ////////////////////////
	
	/**
	 * Instanciates our WuppyWaver and initializes + runs it.
	 * 
	 * @param args		Arguments (command line input)
	 * 
	 */
	public static void main(String[] args)
	{
		WuppyWaver waver = new WuppyWaver();
		waver.aiiInitialize();
		waver.onInitialize();
		
		waver.aiiRun();
	}
	
////////////////// YOUR CODE - START ///////////////////////
	
	/**
	 * This method is called at the start of the program. 
	 * Here, we set the initial values of our arrays:
	 */
	private void onInitialize()
	{
	    createAray();
		// Use 'm_WuppyAmount' for the amount of wuppies. In aiiInitialize, this variable gets the value 10;
        for(int i=0;i < m_WuppyAmount;i++)
        {
            m_Wuppies[i] = new Wuppy(i*50+50,500);
        }
	}

	private void createAray()
    {
        if (m_WuppyAmount > 0)
        {
            m_Wuppies = new Wuppy[m_WuppyAmount];
        }
    }
	/**
	 * This method is called about 60 times per second. 
	 * Here we change the position of our wuppies so they seem to move:
	 */
	private void performStep()
	{

	}
	
/////////////////// YOUR CODE - END ////////////////////////
	
	private void aiiInitialize()
	{
		// Create a new frame and add our canvas to draw on:
		aii_Canvas = new AiiCanvas(this);
		
		aii_Frame = new JFrame("Wuppyyyy waverrrr.... !!!");
		aii_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aii_Frame.getContentPane().add(aii_Canvas);
		aii_Frame.pack();
		aii_Frame.setVisible(true);
		m_WuppyAmount = 10;
	}
	
	private void aiiRun()
	{
		while(true)
		{
			try
			{
				Thread.sleep(15);
			}
			catch(Exception e)
			{
				System.out.println("AII Thread Exception: " + e.getMessage());
			}
			performStep();
			aii_Frame.repaint();
		}
	}
	
	public Wuppy[] aiiGetWuppies()
	{
		return m_Wuppies;
	}
}
