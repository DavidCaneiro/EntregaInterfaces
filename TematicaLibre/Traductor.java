import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;


import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Traductor {
	private JFrame frame;
	private JTextField textTexto;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Traductor window = new Traductor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Traductor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Escribe tu texto");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		textTexto = new JTextField();
		GridBagConstraints gbc_textTexto = new GridBagConstraints();
		gbc_textTexto.insets = new Insets(0, 0, 5, 5);
		gbc_textTexto.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTexto.gridx = 1;
		gbc_textTexto.gridy = 1;
		panel.add(textTexto, gbc_textTexto);
		textTexto.setColumns(10);
		
		JButton btnEngEsp = new JButton("Ingles-Espa\u00F1ol");
		btnEngEsp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Translate translate = TranslateOptions.getDefaultInstance().getService();
					String texto = textTexto.getText();
					Translation traduccion =
					        translate.translate(
					            texto,
					            TranslateOption.sourceLanguage("en"),
					            TranslateOption.targetLanguage("es"));
					String traducido = traduccion.getTranslatedText();
					textPane.setText(traducido);

			}
		});
		GridBagConstraints gbc_btnEngEsp = new GridBagConstraints();
		gbc_btnEngEsp.insets = new Insets(0, 0, 5, 0);
		gbc_btnEngEsp.gridx = 2;
		gbc_btnEngEsp.gridy = 1;
		panel.add(btnEngEsp, gbc_btnEngEsp);
		
		JButton btnEspEng = new JButton("Espa\u00F1ol-Ingles");
		btnEspEng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 Translate translate = TranslateOptions.getDefaultInstance().getService();
			String texto = textTexto.getText();
			Translation traduccion =
			        translate.translate(
			            texto,
			            TranslateOption.sourceLanguage("es"),
			            TranslateOption.targetLanguage("en"));
			String traducido = traduccion.getTranslatedText();
			textPane.setText(traducido);

			
			}
		});
		GridBagConstraints gbc_btnEspEng = new GridBagConstraints();
		gbc_btnEspEng.insets = new Insets(0, 0, 5, 0);
		gbc_btnEspEng.gridx = 2;
		gbc_btnEspEng.gridy = 2;
		panel.add(btnEspEng, gbc_btnEspEng);
		
		JLabel lblNewLabel_1 = new JLabel("Texto traducido");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.insets = new Insets(0, 0, 0, 5);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 1;
		gbc_textPane.gridy = 3;
		panel.add(textPane, gbc_textPane);
	}

}
