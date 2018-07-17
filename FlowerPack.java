package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.Herb;
import main.Flower;
import main.Fungus;
import main.Plant;
import main.Weed;

public class FlowerPack extends JFrame {
	DefaultListModel<Plant> listModel;
	Plant plantToRemove;
	JButton analyze;
	JButton remove;
	JFrame jframe;
	Container cp;
	String search;
	Node start, tail, next;
	Plant temp;

	public static void main(String[] args) {
		new FlowerPack();
	}

	public FlowerPack() {

		listModel = new DefaultListModel();
		JList list = new JList(listModel);
		list.addListSelectionListener(new MySelectionListener());
		jframe = new JFrame();
		cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JButton add = new JButton("Add Plant");
		remove = new JButton("Remove Plant");
		JButton sort = new JButton("Sort Plants");
		JButton filter = new JButton("Filter Plants");
		JButton close = new JButton("Close");
		analyze = new JButton("Analyze");
		cp.add(list, BorderLayout.CENTER);

		Container outside = new Container();
		outside.setLayout(new BorderLayout());
		cp.add(outside, BorderLayout.SOUTH);

		Container c = new Container();
		c.setLayout(new FlowLayout());
		c.add(add);
		c.add(remove);
		remove.setEnabled(false);
		c.add(sort);
		c.add(filter);
		c.add(analyze);
		c.add(close);
		outside.add(c, BorderLayout.CENTER);

		JScrollPane scroll = new JScrollPane(list);
		cp.add(scroll);

		ButtonHandler bh = new ButtonHandler();
		add.addActionListener(bh);
		remove.addActionListener(bh);
		sort.addActionListener(bh);
		filter.addActionListener(bh);
		analyze.addActionListener(bh);
		close.addActionListener(bh);

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		JMenu menu2 = new JMenu("Edit");
		menuBar.add(menu2);
		JMenuItem save = new JMenuItem("Save");
		menu.add(save);
		JMenuItem load = new JMenuItem("Load");
		menu.add(load);
		JMenuItem backGround = new JMenuItem("Change Background Color");
		menu2.add(backGround);

		JRadioButtonMenuItem red = new JRadioButtonMenuItem("Red");
		JRadioButtonMenuItem green = new JRadioButtonMenuItem("Green");
		JRadioButtonMenuItem blue = new JRadioButtonMenuItem("Blue");
		JRadioButtonMenuItem black = new JRadioButtonMenuItem("Black");
		JRadioButtonMenuItem gray = new JRadioButtonMenuItem("Gray");

		red.addActionListener(bh);
		green.addActionListener(bh);
		blue.addActionListener(bh);
		black.addActionListener(bh);
		gray.addActionListener(bh);

		ButtonGroup colors = new ButtonGroup();
		colors.add(red);
		colors.add(green);
		colors.add(blue);
		colors.add(black);
		colors.add(gray);
		menu2.add(red);
		menu2.add(blue);
		menu2.add(green);
		menu2.add(black);
		menu2.add(gray);
		setJMenuBar(menuBar);

		save.addActionListener(new MenuActionListener());
		load.addActionListener(new MenuActionListener());
		backGround.addActionListener(new MenuActionListener());

		setSize(750, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	class MenuActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "Save") {
				try {
					File file = new File(
							"C:/Users/akoontz2/Documents/Programming 2 Code/Plants.txt");
					FileOutputStream fileStream = new FileOutputStream(file);
					PrintWriter pw = new PrintWriter(fileStream);

					Node p = start;
					while (p != null) {
						pw.println(p.getItem());
						p = p.getNext();
					}
					pw.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (e.getActionCommand() == "Load") {
				// JOptionPane.showInputDialog("NO");
				String trash, ID, name, color, hasSmell, hasThorn, isPoison, isEdible, isMedicinal, flavor, isSeason;
				File file = new File(
						"C:/Users/akoontz2/Documents/Programming 2 Code/Plants.txt");
				Scanner input = null;
				try {
					input = new Scanner(file);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				start = new Node(null, null);
				tail = start;
				while (input.hasNext()) {
					String s = input.nextLine();
					StringTokenizer st = new StringTokenizer(s);

					trash = st.nextToken();
					trash = st.nextToken();
					ID = st.nextToken();
					trash = st.nextToken();
					trash = st.nextToken();
					name = st.nextToken();
					trash = st.nextToken();
					trash = st.nextToken();
					color = st.nextToken();

					switch (ID) {
					case "1,":
						trash = st.nextToken();
						trash = st.nextToken();
						hasThorn = st.nextToken();
						trash = st.nextToken();
						trash = st.nextToken();
						hasSmell = st.nextToken();
						tail.setNext(new Node(new Flower(ID, name, color,
								hasThorn, hasSmell), null));
						break;
					case "2,":
						trash = st.nextToken();
						trash = st.nextToken();
						isPoison = st.nextToken();
						tail.setNext(new Node(new Fungus(ID, name, color,
								isPoison), null));
						break;
					case "3,":
						trash = st.nextToken();
						trash = st.nextToken();
						isPoison = st.nextToken();
						trash = st.nextToken();
						trash = st.nextToken();
						isEdible = st.nextToken();
						trash = st.nextToken();
						trash = st.nextToken();
						isMedicinal = st.nextToken();
						tail.setNext(new Node(new Weed(ID, name, color,
								isPoison, isEdible, isMedicinal), null));
						break;
					case "4,":
						trash = st.nextToken();
						trash = st.nextToken();
						flavor = st.nextToken();
						trash = st.nextToken();
						trash = st.nextToken();
						isMedicinal = st.nextToken();
						trash = st.nextToken();
						trash = st.nextToken();
						isSeason = st.nextToken();
						tail.setNext(new Node(new Herb(ID, name, color, flavor,
								isMedicinal, isSeason), null));
					}
					tail = tail.getNext();
				}
				start = start.getNext();

				Node p = start;
				while (p != null) {
					listModel.addElement(p.getItem());
					p = p.getNext();
				}
			}
		}

	}

	class ButtonHandler implements ActionListener {
		String ID;
		String color;
		String name;
		String hasThorn;
		String hasSmell;
		String isPoison;
		String isEdible;
		String isMedicinal;
		String isSeason;
		String flavor;
		int count;

		@Override
		public void actionPerformed(ActionEvent e) {

			// JButton clicked = (JButton) e.getSource();
			// String name = clicked.getText();

			switch (e.getActionCommand()) {
			case "Add Plant":
				addPlant();
				break;
			case "Remove Plant":
				removePlant();
				break;
			case "Sort Plants":
				sortPlants();
				break;
			case "Filter Plants":
				filterPlants();
				break;
			case "Analyze":
				search = JOptionPane
						.showInputDialog("What do you want to search for?");
				count = 0;
				analyzePlants(name, count);
				JOptionPane.showMessageDialog(cp, name + " has " + search + " "
						+ count + " time(s) in it.");
				// listModel.add(name + count);
				break;
			case "Close":
				System.exit(0);
				break;
			}
			if (e.getActionCommand() == "Red") {
				cp.setBackground(Color.RED);
			} else if (e.getActionCommand() == "Green") {
				cp.setBackground(Color.GREEN);
			} else if (e.getActionCommand() == "Blue") {
				cp.setBackground(Color.BLUE);
			} else if (e.getActionCommand() == "Black") {
				cp.setBackground(Color.BLACK);
			} else if (e.getActionCommand() == "Gray") {
				cp.setBackground(Color.GRAY);
			}

		}

		public int analyzePlants(String name, int count) {
			if (!name.contains(search)) {
				this.count = count;
				return count;
				// System.out.println(count);
			}
			if (name.startsWith(search)) {
				count++;
			}
			return analyzePlants(name.substring(1), count);
		}

		private void filterPlants() {
			String filter = JOptionPane
					.showInputDialog("What would you like to filter?");
			Node p;
			p = start;
			while (p != null) {
				String name = p.getItem().getName();
				if (name.contains(filter)) {
					break;
				}
				p = p.getNext();
			}
			if (p != null) {
				JOptionPane.showMessageDialog(cp, "We have found that plant!\n"
						+ p.getItem());
			} else {
				JOptionPane
						.showMessageDialog(cp, "We did not find that plant.");
			}
		}

		private void sortPlants() {
			boolean swapped = true;
			Plant temp;
			Node p = start;

			while (swapped) {
				swapped = false;
				while (p != null && p.getNext() != null) {
					if (p.getItem().getName()
							.compareTo(p.getNext().getItem().getName()) > 0) {
						temp = p.getItem();
						p.setItem(p.getNext().getItem());
						p.getNext().setItem(temp);
						swapped = true;
					}
					p = p.getNext();
				}

			}

			listModel.clear();
			// listModel.addElement(start.getItem());
			p = start;
			while (p != null) {
				listModel.addElement(p.getItem());
				p = p.getNext();
			}
		}

		private void removePlant() {
			Node prev, del;
			del = start;
			prev = null;
			while (del != null) {
				if (del.getItem().equals(temp)) {
					plantToRemove = del.getItem();
					break;
				}
				prev = del;
				del = del.getNext();
			}
			if (del == null) {
				JOptionPane.showMessageDialog(cp, "Plant not found.");
			} else {
				if (del == start) {
					start = start.getNext();
				} else {
					prev.setNext(del.getNext());
				}
			}
			remove.setEnabled(false);
			listModel.removeElement(plantToRemove);
		}

		private void addPlant() {
			start = new Node(null, null);
			tail = start;
			while (true) {
				int type = Integer
						.parseInt(JOptionPane
								.showInputDialog("Type of Plant\n1: Flower\n2: Fungus\n3: Weed\n4: Herb\n5: Exit"));
				if (type == 5) {
					break;
				} else{
					JOptionPane.showMessageDialog(cp,
							"That is not a valid input");
				}
				if (type >= 1 && type <= 5) {
					ID = JOptionPane.showInputDialog("ID");
					name = JOptionPane.showInputDialog("Name");
					color = JOptionPane.showInputDialog("Color");
				}
				switch (type) {
				case 1:
					hasThorn = JOptionPane
							.showInputDialog("Does it have thorns?");
					hasSmell = JOptionPane
							.showInputDialog("Describe the smell");
					Plant flower = new Flower(ID, name, color, hasThorn,
							hasSmell);
					listModel.addElement(flower);
					tail.setNext(new Node(new Flower(ID, name, color, hasThorn,
							hasSmell), null));
					break;
				case 2:
					isPoison = JOptionPane.showInputDialog("Is it poisonous?");
					Plant fungus = new Fungus(ID, name, color, isPoison);
					listModel.addElement(fungus);
					tail.setNext(new Node(
							new Fungus(ID, name, color, isPoison), null));
					break;
				case 3:
					isPoison = JOptionPane.showInputDialog("Is it poisonous?");
					isEdible = JOptionPane.showInputDialog("Is it edible?");
					isMedicinal = JOptionPane
							.showInputDialog("Can it be used as medicine?");
					Plant weed = new Weed(ID, name, color, isPoison, isEdible,
							isMedicinal);
					listModel.addElement(weed);
					tail.setNext(new Node(new Weed(ID, name, color, isPoison,
							isEdible, isMedicinal), null));
					break;
				case 4:
					flavor = JOptionPane.showInputDialog("Flavor");
					isMedicinal = JOptionPane
							.showInputDialog("Can it be used as medicine?");
					isSeason = JOptionPane.showInputDialog("Is it seasonal?");
					Plant herb = new Herb(ID, name, color, flavor, isMedicinal,
							isSeason);
					listModel.addElement(herb);
					tail.setNext(new Node(new Herb(ID, name, color, flavor,
							isMedicinal, isSeason), null));
				}
				tail = tail.getNext();
			}
			start = start.getNext();
		}
	}

	class MySelectionListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			JList selectedList = (JList) e.getSource();
			remove.setEnabled(true);
			temp = (Plant) selectedList.getSelectedValue();
		}

	}

	class MyComparator implements Comparator<Plant> {

		@Override
		public int compare(Plant o1, Plant o2) {
			return o1.getName().compareTo(o2.getName());
		}

	}

}