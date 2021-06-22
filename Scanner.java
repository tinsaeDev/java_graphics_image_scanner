
			// Image Scanner Animation
			// Author: Tinsae Belay
			
			
					import java.awt.image.*;
					import java.awt.event.*;
					import java.awt.*;
					import javax.imageio.*;
					import javax.swing.*;
					import java.io.*;
					
			

			public class Scanner extends Component implements ActionListener{
				
				
				JFrame window;
				File theImage;
				
				BufferedImage img;
				BufferedImage oldCopy;
				int imageWidth;
				int imageHeight;
				
				
				int greenScannerY;
				int greenScannerHeight = 100;
				boolean greenScannerToUp;
				Color dimGreen;
				
				
				
				@Override
				public void actionPerformed(ActionEvent event){
					
					
					
					try{
					img = ImageIO.read( theImage  );
					}
					
					
					catch(Exception ex){
						
						// Exception e
						
					}
					if( greenScannerToUp ){ // 
						
						
						greenScannerY-=5;
						
						if(greenScannerY <= 0){
							
							greenScannerToUp = false;
						}
						
						
					}
					
					
					
					else{
						
						greenScannerY+=5;
						
						if(greenScannerY + greenScannerHeight >= imageHeight){
							
							greenScannerToUp = true;
							
						}
						
						
					}
					
					  Graphics2D g = (Graphics2D) this.getGraphics();
					  Graphics2D imageG = (Graphics2D) img.getGraphics();
					
		
					  
					 
						
					  imageG.setColor(dimGreen);					
					  imageG.fillRect( 0,greenScannerY, imageWidth,greenScannerHeight );
					  
					  imageG.setColor( new Color(255,0,0,200) );
					  imageG.setFont( new Font("lucida console",Font.PLAIN,60) );
					  imageG.drawString( "scanning image",50,greenScannerY+40 );
						
					  
					  g.drawImage( img,    0,0,imageWidth,imageHeight ,0,0,imageWidth,imageHeight,  null);
					 
					 
					
					
				}
				
				public Scanner(){
					
					theImage = new File( JOptionPane.showInputDialog(null,"File name") );
					
					try{
						
						
						img = ImageIO.read( theImage  );
						
						
						
						imageWidth = img.getWidth();
						imageHeight = img.getHeight();
						
					}
					
					
					catch(Exception e){
						
						
						JOptionPane.showMessageDialog(null,"File not found!");
						
					}
					
					
				dimGreen = new Color(0,255,0,100);
					
				window = new JFrame("Image Scanner Animation");

				window.add( this );
				window.setSize(imageWidth,imageHeight);
				window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				window.setVisible(true);
					
				}
				
				public static void main(String[]  str){
					
					Scanner sc = new Scanner();
					
					Timer t = new Timer( 100,sc );
					t.start();
				}
			}
		