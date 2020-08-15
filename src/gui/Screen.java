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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import commands.AddCommandGui;
import commands.DeleteCommandGui;
import storage.Memory;
import task.Main;
import task.Task;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private Object[][] data = { { null }, { null }, { null }, { null } };
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
		// Only in order to know the size of the TaskList, used for debug
		int taskListSize = Main.tasks.size();
		System.out.println("TaskList-data size: " + Main.tasks.size());
		Object[][] data = new Array[taskListSize][];

		/* The actual table content shown on the screen */
		AbstractTableModel tableModel = new AbstractTableModel() {
			@Override
			public int getRowCount() {
				return Main.tasks.size();
			}

			@Override
			public int getColumnCount() {
				return 1; // description only
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				return Main.tasks.get(rowIndex).getDescription();
			}
		};

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
				AddGui.execute(description); // this should return true if succeeded
				if (true && table != null) /* check the result */ {
					tableModel.fireTableDataChanged();
				}
			}
		});
		addButton.setFont(new Font("Roboto", Font.ITALIC, 12));
		addButton.setToolTipText("Add a new task");
		menuBar.add(addButton);

		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String listOfAllTasksWithIDs = "";
				for (Task task : Main.tasks) {
					listOfAllTasksWithIDs += "ID: " + task.getId() + " - " + task.getDescription() + "\n";
				}
				String id = JOptionPane.showInputDialog(getParent(),
						listOfAllTasksWithIDs + "\nInsert the ID of the task you want to delete:",
						"Insert here the ID");

				// Used for debug:
				// System.out.println(id);
				var DeleteGui = new DeleteCommandGui();
				DeleteGui.execute(Integer.parseInt(id)); // this should return true if succeeded
				if (true && table != null) /* check the result */ {
					tableModel.fireTableDataChanged();
				}
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
		JTable table = new JTable(tableModel);
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
