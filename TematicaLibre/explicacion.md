# Explicación traductor con google api

* Nos creamos un nuevo archivo WindowBuilder
* Creamos el interfaz grafico tal que haya podamos introducir texto y al menos 2 botones para traducir de ingles a español y viceversa y muestre su resultado en otro textPane

## Pasos a seguir para conectarse a la google api

(primero de todo si estamos usando gradle intruducimos esto compile 'com.google.cloud:google-cloud-translate:1.51.0')

* Hay que crearse una cuenta de servicio google y una nueva variable de entorno para eso, seguimos los pasos de [este link](https://cloud.google.com/translate/docs/reference/libraries#client-libraries-install-java)

* Codigo a introducir para traducir de ingles a español (incluido el boton)
``` java
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
```

* Codigo a introducir para traducir de español a ingles ( incluido el boton)
``` java
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
```