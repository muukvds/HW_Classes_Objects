package wave_generator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 * @author Bob van der Putten
 * 
 */
public class AiiCanvas extends JComponent 
{
	private static final long serialVersionUID = 7L;
	private WuppyWaver m_Model;
	private static boolean m_NeverDrawnAWuppy;
	BufferedImage  image;
	
	private static Font monoFont = new Font("Monospaced", Font.BOLD | Font.ITALIC, 36);

	/**
	 * Constructs this special canvas after it constructs the default (super) JComponent
	 * 
	 * @param game		A handle to the game so we can question it's objects later on.
	 * 
	 */
	public AiiCanvas(WuppyWaver model)
	{
		super();
		m_Model = model;
		m_NeverDrawnAWuppy = true;
		
		try 
		{
			File input = new File("resources\\wuppy_small.png");
			image = ImageIO.read(input);
		} 
		catch (IOException ie) 
		{
			System.out.println("Error:"+ie.getMessage());
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (m_Model != null)
		{
			Wuppy[] wuppies = m_Model.aiiGetWuppies();

			if (wuppies != null)
			{
				int amount = wuppies.length;
				
				g.setColor(Color.WHITE);
			    g.fillRect(0, 0, getWidth(), getHeight());
			    
			    for (int i = 0; i < amount; ++i)
			    {
			    	if (image != null)
			    	{
			    		g.drawImage( image, wuppies[i].m_XPos, wuppies[i].m_YPos, null);
			    	}
			    	else
			    	{
			    		g.setColor(Color.RED);
			    		g.fillRect(wuppies[i].m_XPos, wuppies[i].m_YPos, 10, 10);
			    		if (m_NeverDrawnAWuppy)
			    		{
			    			System.out.println("AII - Hey, your wuppy image is missing. I'll just use a rectangle then.");
			    		}
			    	}
			    	if (m_NeverDrawnAWuppy)
			    	{
			    		System.out.println("Wuppy drawn at startpos: x:" + wuppies[i].m_XPos + ", " + wuppies[i].m_YPos + ".");
			    	}
			    }
			    if (m_NeverDrawnAWuppy)
			    {
			    	m_NeverDrawnAWuppy = false;
			    }
			}
		}

		g.setColor(Color.ORANGE);
		
		g.setFont(monoFont);
		FontMetrics fm = g.getFontMetrics();
		int h = fm.getAscent();
		g.drawString("Wuppy Waver EXTREME!", 10,  h);
	}

	public Dimension getPreferredSize() {
		return new Dimension(600,600);
	}

	public Dimension getMinimumSize() {
		return getPreferredSize();
	}
}
