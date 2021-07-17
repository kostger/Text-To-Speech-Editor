package commands;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import input.HelpReader;

public class ShowHelp implements MouseListener{

	public void mouseClicked(MouseEvent e) {
		HelpReader help = new HelpReader();
		help.showText();
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

}
