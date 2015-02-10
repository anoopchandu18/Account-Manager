import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Account_Manager extends Frame implements ActionListener,WindowListener{
	
	private static final long serialVersionUID = 1L;
	private Panel summary;
	private Panel addnew;
	private Panel panel2;
	private Label balancel;
	private Label debitl;
	private Label creditl;
	private Label empty;
	private TextField balancet;
	private TextField debitt;
	private TextField creditt;
	private Label dscrptnl;
	private Label debitln;
	private Label creditln;
	private TextField dscrptnt;
	private TextField debittn;
	private TextField credittn;
	private Button enter;
	private Button clear;
	private JTable table;
	private JScrollPane tablec;
	private int debitv;
	private int creditv;
	private int i;
	private DefaultTableModel dtm;
	
	public Account_Manager() {
		
		setLayout(new GridLayout(2,1,10,10));
		setTitle("Account Manager");
		setSize(500,350);
		//setBackground(Color.grey);
		addWindowListener(this);
		setResizable(false);
	
		summary=new Panel();
		summary.setLayout(new GridLayout(3,3));
		add(summary);
		
			balancel=new Label("balance",Label.LEFT);
			summary.add(balancel);
		
			balancet=new TextField("0",5);
			balancet.setEditable(false);
			summary.add(balancet);

			empty =new Label("              ");
			summary.add(empty);

			creditl=new Label("credit",Label.LEFT);
			summary.add(creditl);
	
			creditt=new TextField("0",5);
			creditt.setEditable(false);
			summary.add(creditt);

			empty =new Label("              ");
			summary.add(empty);

			debitl=new Label("debit",Label.LEFT);
			summary.add(debitl);

			debitt=new TextField("0",5);
			debitt.setEditable(false);
			summary.add(debitt);

			empty =new Label("              ");
			summary.add(empty);
	
			panel2=new Panel();
			panel2.setLayout(new GridLayout(1,2));
			add(panel2);
			
				String[] header={"Description","debit","credit"};
				Object[][] data={};
				dtm=new DefaultTableModel(data,header)
				{
				    public boolean isCellEditable(int row, int column)
				    {
				      return false;//This causes all cells to be not editable
				    }
				  };
				table=new JTable(dtm);
				tablec=new JScrollPane(table);
				table.setModel(dtm);
				//dtm.addRow(new Object[]{"xxx","0000","0000"});
				panel2.add(tablec);
		
				addnew =new Panel();
				addnew.setLayout(new GridLayout(4,2));
				panel2.add(addnew);
					
					dscrptnl=new Label("Description",Label.CENTER);
					addnew.add(dscrptnl);
					
					dscrptnt=new TextField(10);
					addnew.add(dscrptnt);
					
					debitln=new Label("Debit",Label.CENTER);
					addnew.add(debitln);
				
					creditln=new Label("Credit",Label.CENTER);
					addnew.add(creditln);
					
					debittn=new TextField(10);
					addnew.add(debittn);

					credittn=new TextField(10);
					addnew.add(credittn);

					enter=new Button("enter");
					enter.addActionListener(this);
					addnew.add(enter);
		
					clear=new Button("clear");
					clear.addActionListener(this);
					addnew.add(clear);
			setVisible(true);
	}
	public void construct(){
		setVisible(true);
		//clear.removeActionListener(this);
		//clear.addActionListener(this);
		/*try {
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("Account_Manager.ser"));
			out.writeObject(this);
			out.close();
		} catch (IOException e1) {
			System.out.println("ioexception found at window closing function");
		}
		
	System.exit(0);	*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Button clicked=(Button)e.getSource();
		

		if(clicked==enter){
			debitv=debitv+Integer.parseInt(debittn.getText());
			creditv=creditv+Integer.parseInt(credittn.getText());
			Object[] rowdata={dscrptnt.getText(),debittn.getText(),credittn.getText()};
			dtm.addRow(rowdata);
		} else if(clicked==clear){
			creditv=0;
			debitv=0;
			for(i=dtm.getRowCount()-1;i>=0;i--)
				dtm.removeRow(i);
		}

		creditt.setText(Integer.toString(creditv));
		debitt.setText(Integer.toString(debitv));
		balancet.setText(Integer.toString(creditv-debitv));
		/*dscrptnt.setText("");
		credittn.setText("");
		debittn.setText("");*/
	}
	
	@Override
	
	public void windowActivated(WindowEvent e) {	
	}
	
	@Override
	public void windowClosed(WindowEvent e) {	
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
			try {
				ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("Account_Manager.ser"));
				out.writeObject(this);
				out.close();
			} catch (IOException e1) {
				System.out.println("ioexception found at window closing function");
			}
			
		System.exit(0);		
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {	
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {		
	}
	
	@Override
	public void windowIconified(WindowEvent e) {	
	}
	
	@Override
	public void windowOpened(WindowEvent e) {		
	}

}