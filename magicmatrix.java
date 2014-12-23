import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class magicmatrix implements ActionListener
{
	Frame f;
	Button b,b1;
	TextArea tf,tf1;
	magicmatrix()
	{	
		f=new Frame("MAGIC MATRIX");
		b=new Button("Equal");
		b1=new Button("clear");
		b.addActionListener(this);
		b1.addActionListener(this);
		b.setBounds(80,50,50,50);
		b1.setBounds(170,50,50,50);
		f.add(b);
		f.add(b1);
		tf=new TextArea();
		tf1=new TextArea();
		tf.setBounds(20,50,50,50);
		tf1.setBounds(20,100,700,400);
		f.add(tf);
		f.add(tf1);
		f.setLayout(null);
		f.addWindowListener(new WindowEventListener());
		f.setSize(800,600);
		f.setBackground(Color.orange);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b)
		{
			String s1=tf.getText();
			int m=Integer.parseInt(s1);
			int n,i=0,j=0,c=2,y=1,z=1;
			int a[][]=new int[100][100];
			for(i=0;i<m;i++)
			{
				for(j=0;j<m;j++)
				{
					a[i][j]=0;
				}
			}
			if(m%2!=0)
			{
				j=(m-1)/2;
				i=0;
				while(y<=m*m)
				{
					a[i][j]=y;
					if(y%m==0)
					{
						i=i+1;
					}
					else
					{
						if(i==0)
						{
							i=m-1;
						}
						else
						{
							i=i-1;
						}
						if(j==m-1)
						{
							j=0;
						}
						else
						{
							j=j+1;
						}
					}
					y++;
				}
				int sum=0,k=0;
				for(i=0;i<m;i++)
				{
					tf1.append("\n");
					for(j=0;j<m;j++)
					{
						//System.out.print(+a[i][j]+" ");
						tf1.append(String.valueOf(a[i][j])+"\t");
						if(i==j)
						{
							sum=sum+a[i][i];
						}
						k++;
					}
				}
				tf1.append("\n");
				tf1.append("Sum is :"+String.valueOf(sum));
			}
			else
			{   
				tf1.setText("Magic Matrix do not exist for even square matrix..");
			}
		}
		else
		{
			tf1.setText("");
		}
	}
	public static void main(String[] args)
	{
		new magicmatrix();
	}
	 class WindowEventListener extends WindowAdapter
    {
        public void windowClosing(WindowEvent e1)
        {
            System.exit(0);
        }
    }
}