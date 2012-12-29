
import java.awt.Rectangle;

import  javax.swing.*;
public class WindowLoad extends JFrame {

    public WindowLoad() {
        initComponents(); }

   private void initComponents() {
		setTitle("DataBase Loader");
		setResizable(false);
		jfcLoadExc = new JFileChooser();
		jfcLoadDB = new JFileChooser();
        jPanel1 = new  JPanel();
        jtfDataPath = new  JTextField();
        jtfSqlPath = new  JTextField();
        jbExaminar = new  JButton();
        jbLExc = new  JButton();
        jbLoad = new  JButton();
        jbDelete = new  JButton();
        jPanel3 = new  JPanel();
        jDesktopPane1 = new  JDesktopPane();
    	 InsertLanguage = new JButton();
     Delete = new JButton();
	 LanguageName= new JTextField();
	 LanguageId= new JTextField();
	LanguageIdDelete= new JTextField();
	 LanguageIdVocabulary= new JTextField();
	LanguageColumn= new JTextField();
	LanguageIdVocabulary2= new JTextField();
	LanguageColumn2= new JTextField();
    	
    	InsertTheLanguage = new JButton();
    	InsertTheLanguageDesc = new JButton();
    	
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder( BorderFactory.createTitledBorder("Choose Files"));
        jPanel1.setLayout(null);
        jPanel1.add(jtfDataPath);
        jtfDataPath.setBounds(20, 30, 350, 19);
        jPanel1.add(jtfSqlPath);
        jtfSqlPath.setBounds(20, 90, 350, 19);

        jbExaminar.setText("Data File");
        jPanel1.add(jbExaminar);
        jbExaminar.setBounds(400, 30, 100, 25);
        jbLExc.setText("Sql File");
        jPanel1.add(jbLExc);
        jbLExc.setBounds(400, 90, 100, 25);

        jbLoad.setText("load");
        //jPanel3.add(jbLoad);
        jbLoad.setBounds(460, 30, 70, 25);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 30, 550, 120);

        jPanel3.setBorder( BorderFactory.createTitledBorder("Database Load"));
        jPanel3.setLayout(null);
        
       // jPanel3.add(jDesktopPane1);
        jDesktopPane1.setBounds(20, 30, 530, 340);
     
   
	 LanguageName= new JTextField();
    	 LanguageId= new JTextField();
    	LanguageIdDelete= new JTextField();
    	 LanguageIdVocabulary= new JTextField();
    	LanguageColumn= new JTextField();
    	 jPanel3.add(InsertLanguage);
    	 jPanel3.add(LanguageName);
         jPanel3.add(LanguageId);
         jPanel3.add(LanguageIdDelete);
         jPanel3.add(jbDelete);
         jPanel3.add(InsertTheLanguage);
         jPanel3.add(LanguageColumn);
         jPanel3.add(LanguageIdVocabulary);
         jPanel3.add(InsertTheLanguageDesc);
         jPanel3.add(LanguageColumn2);
         jPanel3.add(LanguageIdVocabulary2);
         
         
         InsertLanguage.setText("Insert Language");
         InsertTheLanguage.setText("Insert Words");
         jbDelete.setText("Delete");
         InsertTheLanguageDesc.setText("Insert Descriptions");
         
         InsertLanguage.setBounds(new Rectangle (5,30, 130, 30));
    	 LanguageName.setBounds(new Rectangle (175,30, 100, 30));
 		LanguageId.setBounds(new Rectangle (140,30, 30, 30));
 		jbDelete.setBounds(new Rectangle (5,90, 100, 30));
 		LanguageIdDelete.setBounds(new Rectangle (106,90, 30, 30));
 		InsertTheLanguage.setBounds(new Rectangle (5,160, 110, 30));
 		
 	   LanguageColumn.setBounds(new Rectangle (116,160, 70, 30));
       LanguageIdVocabulary.setBounds(new Rectangle (190,160, 70, 30));
       
       InsertTheLanguageDesc.setBounds(new Rectangle (5,220, 110, 30));
		
 	    LanguageColumn2.setBounds(new Rectangle (116,220, 70, 30));
       LanguageIdVocabulary2.setBounds(new Rectangle (190,220, 70, 30));
       
      LanguageName.setText("\"Name\"");
      LanguageId.setText("\"ID\"");
      
      LanguageIdDelete.setText("\"ID\"");
      LanguageColumn.setText("\"Column\"");
      LanguageColumn2.setText("\"Column\"");
      LanguageIdVocabulary.setText("\"ID\"");
      LanguageIdVocabulary2.setText("\"ID\"");
       
        getContentPane().add(jPanel3);
        jPanel3.setBounds(20, 150, 570, 390);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-618)/2, (screenSize.height-542)/2, 618, 542);

		/*declaramos una referencia a nuestra clase control de eventos*/
		EventController controlaEventos =new EventController (this);
		jbExaminar.addActionListener(controlaEventos);
		jbLExc.addActionListener(controlaEventos);
		jbLoad.addActionListener(controlaEventos);
		jbDelete.addActionListener(controlaEventos);
		InsertTheLanguage.addActionListener(controlaEventos);
		InsertLanguage.addActionListener(controlaEventos);
		InsertTheLanguageDesc.addActionListener(controlaEventos);
    }

    public static void main(String args[]) {
              new WindowLoad().setVisible(true);	}

	public JFileChooser jfcLoadExc;
	public JFileChooser jfcLoadDB;
    public JButton jbExaminar;
    public JButton jbLExc;
    public JButton jbLoad;
    public JDesktopPane jDesktopPane1;
    public JPanel jPanel1;
    public JPanel jPanel3;
    public JTextField jtfDataPath;
    public JTextField jtfSqlPath;
	public JButton InsertTheLanguage;
	public JButton InsertTheLanguageDesc;
	public JButton Delete;
	public JButton InsertLanguage;
	public JButton jbDelete;
	 JTextField LanguageName;//= new JTextField();
	 JTextField LanguageId;//= new JTextField();
	 JTextField LanguageIdDelete;//= new JTextField();
	 JTextField LanguageIdVocabulary;//= new JTextField();
	 JTextField LanguageColumn;//= new JTextField();
	 JTextField LanguageIdVocabulary2;//= new JTextField();
	 JTextField LanguageColumn2;//= new JTextField();
}
