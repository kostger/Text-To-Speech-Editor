package view;


import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import commands.CommandFactory;
import javax.swing.JScrollPane;

public class TTSEditorView {

	private JFrame frmTTS;
	private JMenuBar menuBar;
	private JTextArea textArea;
	private CommandFactory command;
	static TTSEditorView window = new TTSEditorView();
	

	public static void main(String[] args) {
		window.frmTTS.setVisible(true);
	}
	
	
	public TTSEditorView() {
		initialize();
	}

	private void initialize() {
		frmTTS = new JFrame();
		frmTTS.setTitle("Text to Speech");
		frmTTS.setSize(500, 350);
		frmTTS.setLayout(new BorderLayout());
		frmTTS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		command = new CommandFactory(textArea);
		
		//menu build
		menuBar = new JMenuBar();
		frmTTS.setJMenuBar(menuBar);
		
		
		//about File
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem openFile = new JMenuItem("Open File");
		mnFile.add(openFile);
		
		JMenuItem editFile = new JMenuItem("Edit File");
		mnFile.add(editFile);
		
		JMenuItem saveFile = new JMenuItem("Save File");
		mnFile.add(saveFile);
		
		
		//about Play
		
		/*//JMenuItem mnPlay = new JMenuItem("Play");
		//mnPlay.setMaximumSize(mnPlay.getPreferredSize());
		JButton mnPlay = new JButton("Play");
		//mnPlay.setOpaque(true);
		mnPlay.setContentAreaFilled(false);
		mnPlay.setBorderPainted(false);
		mnPlay.setFocusable(false);
		mnPlay.setSize(size);
		/*
		JButton mnPlay = new JButton("Play"); //Button

		//mnPlay.setText("Play"); //Button Text
		mnPlay.setOpaque(true); //These remove the button filling and border
		mnPlay.setContentAreaFilled(false);
		mnPlay.setBorderPainted(false);
		mnPlay.setBorder(null);
		mnPlay.setFocusable(false);
		//mnPlay.setRolloverEnabled(true); //Allows the button to detect when mouse is over it
		mnPlay.setSize(size);
		//mnPlay.setPreferredSize(mnPlay.getPreferredSize());
		//mnPlay.setMaximumSize(mnPlay.getPreferredSize()); */
		
		JMenu mnPlay = new JMenu("Play");
		menuBar.add(mnPlay);
		
		
		//about Audio
		JMenu mnAudio = new JMenu("Audio");
		menuBar.add(mnAudio);
		
		JLabel lblVol = new JLabel("Volume");
		mnAudio.add(lblVol);
		JSlider slider_vol = new JSlider();
		lblVol.setLabelFor(slider_vol);
		mnAudio.add(slider_vol);
		
		JLabel lblSpeechRt = new JLabel("Speech Rate");
		mnAudio.add(lblSpeechRt);
		JSlider slider_rate = new JSlider();
		lblSpeechRt.setLabelFor(slider_rate);
		mnAudio.add(slider_rate);
		
		JLabel lblPitch = new JLabel("Pitch");
		mnAudio.add(lblPitch);
		JSlider slider_pitch = new JSlider();
		lblPitch.setLabelFor(slider_pitch);
		mnAudio.add(slider_pitch);
		
		
		//about Record
		JMenu mnRec = new JMenu("Record");
		menuBar.add(mnRec);
		
		JMenuItem activateRec = new JMenuItem("Activate Recording");
		mnRec.add(activateRec);
		
		JMenuItem replay = new JMenuItem("Replay Recorded");
		mnRec.add(replay);
		
		JMenuItem deactRec = new JMenuItem("Deactivate Recording");
		mnRec.add(deactRec);
		
		
		
		//about Help
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		frmTTS.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		//select
		JRadioButton btnSelect = new JRadioButton("Select to Speech");
		frmTTS.getContentPane().add(btnSelect, BorderLayout.SOUTH);
		

		//TextArea
		textArea = new JTextArea();
		textArea.setEditable(false);

		//ScrollPane
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setViewportView(textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		frmTTS.getContentPane().add(scroll, BorderLayout.CENTER);
	    
		
		//add commands
		openFile.addActionListener(command.createCommand("openFile"));
		saveFile.addActionListener(command.createCommand("saveFile"));
		editFile.addActionListener(command.createCommand("editFile"));
		mnPlay.addMouseListener(command.createMouseCommand("play"));
		//mnPlay.addActionListener(command.createCommand("play"));
		btnSelect.addActionListener(command.createCommand("select"));
		slider_vol.addChangeListener(command.createChangeCommand("volume"));		
		slider_rate.addChangeListener(command.createChangeCommand("speechRate"));
		slider_pitch.addChangeListener(command.createChangeCommand("pitch"));
		activateRec.addActionListener(command.createCommand("activateRec"));
		replay.addActionListener(command.createCommand("replayRec"));
		deactRec.addActionListener(command.createCommand("deactRec"));
		mnHelp.addMouseListener(command.createMouseCommand("help"));
	}
	
	
	
	public static TTSEditorView getWindow() {
		return window;
	}
	
	public void setDisplay(String str) {
		textArea.setText(str);
	}
	
	public String getTextArea() {
		return textArea.getText();	
	}
	
	public String getSelectedText() {
		return textArea.getSelectedText();
	}
	
	public JTextArea getThisTextArea() {
		return textArea;
	}
}
