import java.awt.*;  
import java.awt.event.*;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;  
public class MouseHandler extends JFrame  implements MouseListener{  
   JLabel l,l2,l3,l4,l5,node[],weight[];  
	JTextField t1,t2,t3;
	Graphics g;
	JButton b,b1;
	Graph curr;
	static HashMap<Integer, MouseEvent> hm=new HashMap<>();
int i=0,path[]=new int[20];
    int clickCount=0,vertices;
     
    public void mouseClicked(MouseEvent e) {  
    	
    	g=getGraphics(); hm.put(clickCount, e);
    int x=e.getX();
    int y=e.getY();
    l.setText("X= "+x+"  "+"Y= "+y);
    g.fillOval(x, y, 7, 7);
    
 	
	 node[clickCount]=new JLabel();
	 add(  node[clickCount]);
	    node[clickCount].setText(""+clickCount);
	    node[clickCount].setBounds(x-30, y-5, 50, 20);
	    node[clickCount].setForeground(Color.blue);
	    System.out.println(clickCount);
	    
    	clickCount++;

if(clickCount==vertices) {
	removeMouseListener(this);
}
      }  
    public void mouseEntered(MouseEvent e) {  
    }  
    public void mouseExited(MouseEvent e) {  
            }  
    public void mousePressed(MouseEvent e) {  
      }  
    public void mouseReleased(MouseEvent e) {  
        }  
    
    void setBasic() {
    	 getContentPane().setBackground(Color.WHITE); 
		node=new JLabel[20];
		weight=new JLabel[20];
b=new JButton("Print edge");
b.setBounds(80, 300, 150, 50);
b1=new JButton("Print Shortest  Path");
b1.setBounds(80, 400, 150, 50);
    	  l=new JLabel();  
    	   l.setBounds(800,20,150,100);  
    	   add(l);  
   		l2=new JLabel("Start node");
   		l2.setBounds(80, 80, 200, 30);
   		l3=new JLabel("End node");
		l3.setBounds(80, 150, 200, 30);
		l4=new JLabel("Weight");
   		l4.setBounds(80, 200, 200, 30);
   		l5=new JLabel("Give edges data");
   		l5.setBounds(80, 50, 200, 30);
   		
    		t1=new JTextField();
    		t1.setBounds(160, 80, 100, 30);
    		add(t1);
    		t2=new JTextField();
    		t2.setBounds(160, 150, 100, 30);
    		t3=new JTextField();
    		t3.setBounds(160, 200, 100, 30);
    		add(t2);add(l2);
    		add(l3);add(t3);add(l4);add(l5);add(b);add(b1);
    	   setSize(1000,1000);  
    	   setLayout(null);  
    	   setVisible(true);
    	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 }
    
    void addedge(Graph curr) {
    	
    	int start=Integer.parseInt(t1.getText());
    	int end=Integer.parseInt(t2.getText());
    	int weig= Integer.parseInt(t3.getText());
    	
    	int x1=hm.get(start).getX();
    	int y1= hm.get(start).getY();
    	int x2= hm.get(end).getX();
    	int y2= hm.get(end).getY();
    
g.drawLine(x1,y1,x2,y2);    

weight[i]=new JLabel();
add(weight[i]);
	
weight[i].setText(""+weig);
weight[i].setForeground(Color.RED);
weight[i].setBounds((x1+x2)/2,(y1+y2)/2,20,20);
    	i++;
    	curr.addpath(start,end,weig);
    }
    
  void  prinShorttPath(int path[],Graph cur){
    	for(int i=0;i<cur.p;i++) {
    		int x1=hm.get(path[i]).getX();
        	int y1= hm.get(path[i]).getY();
        	int x2= hm.get(path[i+1]).getX();
        	int y2= hm.get(path[i+1]).getY();
        	//setForeground(Color.GREEN);
    		g.setColor(Color.ORANGE);
  Graphics2D g2 = (Graphics2D) g;
  g2.setStroke(new BasicStroke(5));
    g.drawLine(x1-10,y1-10,x2-10,y2-10); 
    	}}}  