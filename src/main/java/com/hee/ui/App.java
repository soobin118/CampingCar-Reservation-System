package com.hee.ui;

import javax.swing.*;

public class App extends JFrame{

	private JFrame frame;
	private AdminPanel adminP;
	private UserPanel userP;
	private MainPanel selectWhoP;
	public static void main(String[] args) {
		new App();	

	}
	public App() {
		setTitle("Database~");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		selectWhoP = new MainPanel(this);
		getContentPane().add(selectWhoP);
		pack();
		setVisible(true);
	}
	public void changePanel(int a) {
		this.remove(selectWhoP);
		if(a==1) {
			setTitle("Database~ Admin");
			adminP = new AdminPanel();
			getContentPane().add(adminP);
		}
		else if(a==2)
		{
			setTitle("Database~ User");
			userP = new UserPanel();
			getContentPane().add(userP);
		}
		pack();
		setVisible(true);
	}
	
}
