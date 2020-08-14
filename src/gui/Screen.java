package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import commands.AddCommandGui;
import storage.Memory;
import task.Main;
import task.Task;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Screen extends JFrame {

	private JPanel contentPane;
	private JTable table;

	// Import task list and memory in order to load all registered tasks
	public static List<Task> tasks = new ArrayList<>();
	public static Memory memory = new Memory();

	// Default Table Model set up with columnNames and data
	private String[] columnNames = { "Task" };
	// private Object[][] data = { { null }, { null }, { null }, { null } };
	// private TableModel model = new DefaultTableModel(data, columnNames);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				memory.load();
			}
		};
		new Thread(runnable).start();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen frame = new Screen();
					frame.setTitle("TaskList");
					frame.pack();
					frame.setLocationByPlatform(true);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setMinimumSize(new Dimension(300, 200));
					frame.setBounds(100, 100, 450, 300);
					frame.setSize(450, 300);
					frame.setForeground(Color.black);
					frame.setBackground(Color.lightGray);
					frame.setFont(new Font("Roboto", Font.PLAIN, 12));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Screen() {
		int taskListSize = Main.tasks.size();
		System.out.println("TaskList-data size: " + Main.tasks.size());
		Object[][] data = new Array[taskListSize][];

//		for(int i=0; i < Main.tasks.size(); i++) {
//			data[i][0] = i;
//		}

//		int test = 2;
//		Object[][] data = new Array[test][];
//		data[2][0] = "Hellnewo"; 

		TableModel model = new DefaultTableModel(data, columnNames);

//		for (int i = 0; i < Main.tasks.size(); i++) {
//			for (int j = 0; j < Main.tasks.[0]; j++) {
//				arrStr[i][j] = "Str" + j;
//				System.out.print(arrStr[i][j] + " ");
//			}
//			System.out.println("");
//		}

//		this.data = new String[]
//		this.data[0][0] = "Test 1";
//		this.data[0][1] = "Test 2";

//		for (Task task : Main.tasks) {
//			this.data[0][] += task.getDescription();
//		}

//		Main.tasks.forEach(task -> this.data[task][task.toString()]);

		setFont(new Font("Roboto", Font.PLAIN, 12));
		setForeground(Color.black);
		setBackground(Color.lightGray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		/* Add and delete buttons */
		JButton addButton = new JButton("Add");
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String description = JOptionPane.showInputDialog(getParent(), "Insert a description:",
						"Insert here your task");
				// Used for debug:
				// System.out.println(description);
				var AddGui = new AddCommandGui();
				AddGui.execute(description);
			}
		});
		addButton.setFont(new Font("Roboto", Font.ITALIC, 12));
		addButton.setToolTipText("Add a new task");
		menuBar.add(addButton);

		JButton deleteButton = new JButton("Delete");
		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		deleteButton.setFont(new Font("Roboto", Font.ITALIC, 12));
		deleteButton.setToolTipText("Delete a specific task");
		menuBar.add(deleteButton);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		/* Table used to show all tasks */
		JTable table = new JTable(model);
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		table.setFont(new Font("Roboto", Font.PLAIN, 12));
		table.setToolTipText("All registered tasks are listed here");
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 2;
		gbc_table.gridheight = 5;
		gbc_table.insets = new Insets(0, 0, 0, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		contentPane.add(table, gbc_table);
	}

}
