/*Application Development Started: 
 *November 13, 2020
 *
 *GroupMembers:
 *Niño Louis A. Akut
 *Chris Andrew M.Aranas
 *Kim Joel R. Arellano
 *
 *Section:
 *ITCC11 - A2
 *
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PracticingJavaProgrammingCALENDAR {
	
	//CALENDAR OBJECTS.
	Calendar calendar;
	public static SimpleDateFormat TimeFormat;
	public static String Time;
	public static JFrame frame;
	public static JPanel framepanel, CalendarPanel;
	public static JButton MonthBACKbutton, MonthNEXTbutton, FontColorButton;
	public static JLabel Month, TimeLabel, CurrentTime, FontLabel;
	public static JComboBox YearComboBox, FontComboBox;	
	public static JTable CalendarTable;
	public static DefaultTableModel MainCalendarTable;	
	public static JScrollPane CalendarScroll, TextAreaScroll;
	public static Container pane;
	
	static int realYear, realMonth, realDay, currentYear, currentMonth;
	
	
	//TEXT EDITOR OBJECTS.
	public static JTextArea textArea;
	public static JSpinner fontSizeSpinner;
	public static JMenuBar MenuBar;
	public static JMenu FileMenu;
	public static JMenuItem OpenItem;
	public static JMenuItem SaveItem;
	public static JMenuItem ExitItem;
	
// 	!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!	 [ THIS IS THE MAIN METHOD ]		!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	public static void main(String[] args) {
		
		//Initialization of Fonts.
		Font font = new Font(Font.SANS_SERIF,Font.BOLD,14);
		Font font2 = new Font(Font.SANS_SERIF,Font.BOLD,22);
		Font font3 = new Font (Font.SANS_SERIF,Font.PLAIN,11);
		
		//CALENDAR OBJECTS.
		frame = new JFrame("CALENDAR");
		framepanel = new JPanel();
		CalendarPanel = new JPanel();
		Month = new JLabel("JANUARY");
		
		MonthBACKbutton = new JButton("<");
		MonthNEXTbutton = new JButton(">");
		YearComboBox = new JComboBox();
		TimeLabel = new JLabel();
		CurrentTime = new JLabel("Current Time:");
		
		//TEXT EDITOR OBJECTS.
		textArea = new JTextArea();
		TextAreaScroll = new JScrollPane(textArea);
		fontSizeSpinner = new JSpinner();
		FontLabel = new JLabel("FONT SIZE:");
		FontColorButton = new JButton("Color");
		
		//MENUBAR OBJECTS;
		MenuBar = new JMenuBar();
		FileMenu = new JMenu("File");
		OpenItem = new JMenuItem("Open");
		SaveItem = new JMenuItem("Save");
		ExitItem = new JMenuItem("Exit");
		
		//Array of all fonts available in java.
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		FontComboBox = new JComboBox(fonts);
		
		
		//Initializing the JFrame frame.
		//frame = new JFrame("CALENDAR");		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 400);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		pane = frame.getContentPane();
		pane.setLayout(null);
		pane.add(CalendarPanel);
		
		
		//Initializing the JPanel framePanel
		//framepanel = new JPanel();		
		framepanel.setVisible(true);
		framepanel.setBackground(Color.LIGHT_GRAY);
		framepanel.setBounds(0, 5, 635, 350);
		framepanel.setLayout(null);
		frame.add(framepanel);
		
		
		//JLabel Current Time.
		//CurrentTime = new JLabel("Current Time:");
		CurrentTime.setVisible(true);
		CurrentTime.setBounds(330, 5, 180, 22);
		CurrentTime.setFont(font2);
		framepanel.add(CurrentTime);
		
		
		//Initializing the JTextArea textArea.
		//textArea = new JTextArea();		
		textArea.setVisible(true);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Agency FB",Font.PLAIN,20));
		
		
		//Initializing the JScrollPane TextAreaScroll.
		//TextAreaScroll = new JScrollPane(textArea);
		TextAreaScroll.setBounds(325, 93, 304, 247);
		TextAreaScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		//Initializing the JSpinner fontSizeSpinner.
		//fontSizeSpinner = new JSpinner();
		fontSizeSpinner.setBounds(385, 65, 40, 22);
		fontSizeSpinner.setValue(20);
		fontSizeSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int)fontSizeSpinner.getValue()));
			}
		});
		
		
		//Initializing the JLabel FontLabel.
		//FontLabel = new JLabel("FONT SIZE:");
		FontLabel.setBounds(328, 63, 65, 25);
		FontLabel.setFont(font3);
		FontLabel.setVisible(true);
		
		
		//Setting the JButton FontColorButton
		FontColorButton.setBounds(434, 65, 65, 24);
		FontColorButton.setVisible(true);
		
		
		//FontComboBox ActionListener.
		FontComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==FontComboBox) {
					textArea.setFont(new Font((String)FontComboBox.getSelectedItem(),Font.PLAIN,textArea.getFont().getSize()));
				}
			}
		});
		
		FontComboBox.setSelectedItem("Agency FB");
		FontComboBox.setBounds(511, 65, 114, 24);
		FontComboBox.setVisible(true);
		
		
		//FontColorButton = new JButton("Font Color");
		FontColorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==FontColorButton) {
					JColorChooser colorchooser = new JColorChooser();
							
					Color color = colorchooser.showDialog(null, "Choose a Font Color:", Color.BLACK);
							
					textArea.setForeground(color);
				}
			}
		});		
		
//		!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1!!!! [ MENU BAR ] !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		//ADDING The JMenuItems to the FileMenu.
		FileMenu.add(OpenItem);
		FileMenu.add(SaveItem);
		FileMenu.add(ExitItem);
		MenuBar.add(FileMenu);		
		MenuBar.setBounds(326, 36, 303, 20);
		
		//Initialization of ActionListeners of OpenItem,SaveItem,ExitItem.
		OpenItem.addActionListener(new OpenItem_Action());
		SaveItem.addActionListener(new SaveItem_Action());
		ExitItem.addActionListener(new ExitItem_Action());
		
		//ADDING The Text Editor in the framepanel..												
		framepanel.add(fontSizeSpinner);
		framepanel.add(TextAreaScroll);
		framepanel.add(FontLabel);
		framepanel.add(FontColorButton);
		framepanel.add(FontComboBox);
		framepanel.add(MenuBar);
		
		
//		!!!!!!!!!!!!!!!!!!!!!!!!!	[ THE OTHER HALF OF THE PROGRAM WILL BE CODED DOWN BELOW FROM HERE ]	!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		
		//Initializing the JPanel CalendarPanel.
		//CalendarPanel = new JPanel();		
		CalendarPanel.setVisible(true);
		CalendarPanel.setBackground(Color.GRAY);
		CalendarPanel.setBounds(0, 5, 320, 335);
		CalendarPanel.setLayout(null);
		framepanel.add(CalendarPanel);
		
		
		//Initializing the JLabel Month.
		//Month = new JLabel("JANUARY");		
		Month.setVisible(true);
		Month.setBounds(75,12,80,15);
		Month.setFont(font);
		CalendarPanel.add(Month);
		
		
		//Initializing the JButton MonthBACKbutton.
		//MonthBACKbutton = new JButton("<");		
		MonthBACKbutton.setVisible(true);
		MonthBACKbutton.setBounds(0, 0, 50, 35);
		MonthBACKbutton.addActionListener(new MonthBACKbutton_Press());
		CalendarPanel.add(MonthBACKbutton);
		
		
		//Initializing the JButton MonthNEXTbutton.
		//MonthNEXTbutton = new JButton(">");		
		MonthNEXTbutton.setVisible(true);
		MonthNEXTbutton.setBounds(170, 0, 50, 35);
		MonthNEXTbutton.addActionListener(new MonthNEXTbutton_Press());
		CalendarPanel.add(MonthNEXTbutton);
		
		
		//Initializing the JComboBox YearComboBox.
		//YearComboBox = new JComboBox();		
		YearComboBox.setVisible(true);
		YearComboBox.setBounds(219, 0, 101, 35);
		YearComboBox.addActionListener(new YearComboBox_Press());
		CalendarPanel.add(YearComboBox);
		
		
		MainCalendarTable = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
		CalendarTable = new JTable(MainCalendarTable);
		CalendarScroll = new JScrollPane(CalendarTable);
		CalendarPanel.add(CalendarScroll);
		CalendarScroll.setBounds(10, 50, 300, 250);
		
		
		//Setting the Real Calendar.
		GregorianCalendar calendar = new GregorianCalendar(); 
        realDay = calendar.get(GregorianCalendar.DAY_OF_MONTH); 
        realMonth = calendar.get(GregorianCalendar.MONTH); 
        realYear = calendar.get(GregorianCalendar.YEAR); 
        currentMonth = realMonth;
        currentYear = realYear;		
		
        //Day Variables.
        String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; 
        for (int i=0; i<7; i++){
        	MainCalendarTable.addColumn(headers[i]);
        }        
		
        //Set Table Background.
        CalendarTable.getParent().setBackground(CalendarTable.getBackground());
        
        //No Resize/Reorder of Table and Days in the Calendar.
        CalendarTable.getTableHeader().setResizingAllowed(false);
        CalendarTable.getTableHeader().setReorderingAllowed(false);
        
        //Single cell selection of.
        CalendarTable.setColumnSelectionAllowed(true);
        CalendarTable.setRowSelectionAllowed(true);
        CalendarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Setting the row/column count in the Calendar.
        CalendarTable.setRowHeight(38);
        MainCalendarTable.setColumnCount(7);
        MainCalendarTable.setRowCount(6);
        
        //Populate Table.
        for (int i=realYear-100; i<=realYear+100; i++){
        	YearComboBox.addItem(String.valueOf(i));
        }
        
        //Refresh Calendar.
        refreshCalendar (realMonth, realYear);
                
        //TIME SETTING.
		TimeFormat = new SimpleDateFormat("h:mm:ss a");				
		TimeLabel.setBounds(500, 5, 125, 22);
		TimeLabel.setFont(font2);
		framepanel.add(TimeLabel);
		setTime();
		
		
	}
	
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  [ THIS IS OUTSIDE THE MAIN METHOD ]		!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1	
	
	public static void setTime() {
		
		while(true) {
		Time = TimeFormat.format(Calendar.getInstance().getTime());
		TimeLabel.setText(Time);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		}
		
	}
		
	public static void refreshCalendar(int month, int year){
		
		//Month Variables.
		String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int nod, som; //Number Of Days, Start Of Month
		
		//Allow JButtons
		MonthBACKbutton.setEnabled(true);
		MonthNEXTbutton.setEnabled(true);
        
		if (month == 0 && year <= realYear-10){
			MonthBACKbutton.setEnabled(false);
		} //early
        if (month == 11 && year >= realYear+100){
        	MonthNEXTbutton.setEnabled(false);
        } //late
        
        Month.setText(months[month]); //Refresh the Month (Between MonthBACKbutton, MonthNEXTbutton)
        Month.setBounds(75,12,80,15); //Re-align label with Calendar.
        YearComboBox.setSelectedItem(String.valueOf(year)); //Select the correct year in the YearComboBox.
        
        //Clear table
        for (int i=0; i<6; i++){
        	for (int j=0; j<7; j++){
        		MainCalendarTable.setValueAt(null, i, j);
        	}
        }
        
        //Get the first day of month and number of days
        GregorianCalendar calendar = new GregorianCalendar(year, month, 1);
        nod = calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = calendar.get(GregorianCalendar.DAY_OF_WEEK);
        
        //Draw Calendar
        for (int i=1; i<=nod; i++){
        	int row = new Integer((i+som-2)/7);
        	int column  =  (i+som-2)%7;
        	MainCalendarTable.setValueAt(i, row, column);
        }
        
        //Applying Renderers to the Calendar Table.
        CalendarTable.setDefaultRenderer(CalendarTable.getColumnClass(0), new CalendarTableRenderer());        
        
	}
	
	static class CalendarTableRenderer extends DefaultTableCellRenderer{
		public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
			super.getTableCellRendererComponent(table, value, selected, focused, row, column);
			
			if (column == 0 || column == 6){ //Weekends
	                setBackground(new Color(255, 220, 220));
			}
			else{ //Week
				setBackground(new Color(255, 255, 255));
			}
			if (value != null){
				if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear){
					setBackground(new Color(220, 220, 255));
				}
			}
	            
			setBorder(null);
			setForeground(Color.black);
			return this;
		}		
	}
	
	static class MonthBACKbutton_Press implements ActionListener{
        public void actionPerformed (ActionEvent e){
        	//Back one year
        	if (currentMonth == 0){ 
                currentMonth = 11;
                currentYear -= 1;
            }
            else{ //Back one month
                currentMonth -= 1;
            }
            refreshCalendar(currentMonth, currentYear);
        }
    }
	
	static class MonthNEXTbutton_Press implements ActionListener{
        public void actionPerformed (ActionEvent e){
        	//Forward one year
        	if (currentMonth == 11){
                currentMonth = 0;
                currentYear += 1;
            }
            else{ //Forward one month
                currentMonth += 1;
            }
            refreshCalendar(currentMonth, currentYear);
        }
    }
	
	static class YearComboBox_Press implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (YearComboBox.getSelectedItem() != null){
                String b = YearComboBox.getSelectedItem().toString();
                currentYear = Integer.parseInt(b);
                refreshCalendar(currentMonth, currentYear);
            }
        }
	}	
	
	static class OpenItem_Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
        	
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
        	FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        	fileChooser.setFileFilter(filter);
        	   
        	int response = fileChooser.showOpenDialog(null);
        	   
        	if(response == JFileChooser.APPROVE_OPTION) {
        		   
        		File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
        		Scanner fileIn = null;
        	    
        		try {
        		   
        			fileIn = new Scanner(file);
        			if(file.isFile()) {
        		   
        				while(fileIn.hasNextLine()) {
        					String line = fileIn.nextLine()+"\n";
        					textArea.append(line);
        				}
        	   
        			}
        	     
        		}catch (FileNotFoundException e1) {
        	     
        			e1.printStackTrace();
        		}finally {
        			fileIn.close();
        		}
        	   
        	}
        	   
		}
	}
	
	static class SaveItem_Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
        	
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
        	   
			int response = fileChooser.showSaveDialog(null);
        	   
			if(response == JFileChooser.APPROVE_OPTION) {
        		   
				File file;
				PrintWriter fileOut = null;
        	    
				file = new File(fileChooser.getSelectedFile().getAbsolutePath());
        	    
				try {
        		   
					fileOut = new PrintWriter(file);
					fileOut.println(textArea.getText());
				}catch (FileNotFoundException e1) {       	    	
					e1.printStackTrace();
        	     
				}finally {
					fileOut.close();
				}   
			}
        	   
		}
	}
	
	static class ExitItem_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
        	System.exit(0);
        }
	}
	
}
