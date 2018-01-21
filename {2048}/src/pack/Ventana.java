package pack;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.awt.*;

class Ventana extends Frame {

	// Atributos
	private Tablero tab;
	public int[][] tableroFinal = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

	private CardLayout cl;
	private Panel cardpanel;
	private Button inicio, reiniciar;
	private Button a1, a2, a3, a4, b1, b2, b3, b4, c1, c2, c3, c4, d1, d2, d3, d4, seguir;
	private Label titulo;

	// Encargado de que solo se gane una vez por partida.
	boolean ganaste = false;

	// Constructor
	Ventana() {
		super("2048");
		tab = new Tablero();
		cardpanel = new Panel();

		// Cada boton imprime la posicion del tablero que le corresponde
		a1 = new Button(Integer.toString(tableroFinal[0][0]));
		a2 = new Button(Integer.toString(tableroFinal[0][1]));
		a3 = new Button(Integer.toString(tableroFinal[0][2]));
		a4 = new Button(Integer.toString(tableroFinal[0][3]));
		b1 = new Button(Integer.toString(tableroFinal[1][0]));
		b2 = new Button(Integer.toString(tableroFinal[1][1]));
		b3 = new Button(Integer.toString(tableroFinal[1][2]));
		b4 = new Button(Integer.toString(tableroFinal[1][3]));
		c1 = new Button(Integer.toString(tableroFinal[2][0]));
		c2 = new Button(Integer.toString(tableroFinal[2][1]));
		c3 = new Button(Integer.toString(tableroFinal[2][2]));
		c4 = new Button(Integer.toString(tableroFinal[2][3]));
		d1 = new Button(Integer.toString(tableroFinal[3][0]));
		d2 = new Button(Integer.toString(tableroFinal[3][1]));
		d3 = new Button(Integer.toString(tableroFinal[3][2]));
		d4 = new Button(Integer.toString(tableroFinal[3][3]));
		seguir = new Button("Continuar");
		titulo = new Label("PULSE INICIAR");
		cl = new CardLayout();
		cardpanel.setLayout(cl);

		// Panel de entrada 2048
		Panel inicioPanel = new Panel();
		inicioPanel.add(titulo);
		inicioPanel.setBackground(Color.WHITE);

		// Panel de botones
		Panel panelbotones = new Panel();
		panelbotones.setLayout(new GridLayout(4, 4));
		panelbotones.add(a1);
		a1.setBackground(Color.WHITE);
		panelbotones.add(a2);
		a2.setBackground(Color.WHITE);
		panelbotones.add(a3);
		a3.setBackground(Color.WHITE);
		panelbotones.add(a4);
		a4.setBackground(Color.WHITE);
		panelbotones.add(b1);
		b1.setBackground(Color.WHITE);
		panelbotones.add(b2);
		b2.setBackground(Color.WHITE);
		panelbotones.add(b3);
		b3.setBackground(Color.WHITE);
		panelbotones.add(b4);
		b4.setBackground(Color.WHITE);
		panelbotones.add(c1);
		c1.setBackground(Color.WHITE);
		panelbotones.add(c2);
		c2.setBackground(Color.WHITE);
		panelbotones.add(c3);
		c3.setBackground(Color.WHITE);
		panelbotones.add(c4);
		c4.setBackground(Color.WHITE);
		panelbotones.add(d1);
		d1.setBackground(Color.WHITE);
		panelbotones.add(d2);
		d2.setBackground(Color.WHITE);
		panelbotones.add(d3);
		d3.setBackground(Color.WHITE);
		panelbotones.add(d4);
		d4.setBackground(Color.WHITE);

		// Panel que se muestra al ganar
		Panel ganar = new Panel();
		ganar.add(seguir);
		ganar.add(new Label("GANASTE"));
		ganar.setBackground(new Color(144, 202, 249));

		// Panel que se muestra al perder
		Panel perder = new Panel();
		perder.add(new Label("PERDISTE"));
		perder.setBackground(new Color(144, 202, 249));

		// Barra de botones 'iniciar; y 'reiniciar'
		Panel controlpanel = new Panel();
		inicio = new Button("Iniciar");
		reiniciar = new Button("Reiniciar");
		controlpanel.add(inicio);
		controlpanel.add(reiniciar);
		controlpanel.setBackground(new Color(144, 202, 249));

		// Agregar al cardPanel cada uno de los paneles.
		setLayout(new BorderLayout());
		cardpanel.add(inicioPanel, "inicial");
		cardpanel.add(panelbotones, "Botones");
		cardpanel.add(ganar, "ganar");
		cardpanel.add(perder, "perder");
		add(controlpanel, BorderLayout.SOUTH);
		add(cardpanel, BorderLayout.CENTER);

		// Boton de reiniciar bloqueado mientras no se haya iniciado la partida
		reiniciar.setEnabled(false);

		// Botones del tablero bloqueados
		a1.setEnabled(false);
		a2.setEnabled(false);
		a3.setEnabled(false);
		a4.setEnabled(false);
		b1.setEnabled(false);
		b2.setEnabled(false);
		b3.setEnabled(false);
		b4.setEnabled(false);
		c1.setEnabled(false);
		c2.setEnabled(false);
		c3.setEnabled(false);
		c4.setEnabled(false);
		d1.setEnabled(false);
		d2.setEnabled(false);
		d3.setEnabled(false);
		d4.setEnabled(false);

		// Foco de KeyListener es el boton reiniciar (que es el unico foco en la
		// pantalla de juego mientras esta activo)
		reiniciar.addKeyListener(new KeyAdapter() {

			// CADA TURNO: la clase Tablero modifica las posiciones dependiendo
			// de la tecla introducida y confirma que se pueda seguir jugando
			public void keyPressed(KeyEvent e) {
				cl.show(cardpanel, "Botones");
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_LEFT) {
					tab.moverIzquierda();
					setTablero(tab.getTablero());
					confirmarEspacio();
					imprimir();

				} else if (keyCode == KeyEvent.VK_RIGHT) {
					tab.moverDerecha();
					setTablero(tab.getTablero());
					confirmarEspacio();
					imprimir();

				} else if (keyCode == KeyEvent.VK_UP) {
					tab.moverArriba();
					setTablero(tab.getTablero());
					confirmarEspacio();
					imprimir();

				} else if (keyCode == KeyEvent.VK_DOWN) {
					tab.moverAbajo();
					setTablero(tab.getTablero());
					confirmarEspacio();
					imprimir();

				}
			}

		});

		// Boton de inicio
		inicio.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				cl.show(cardpanel, "Botones");

				inicio.setEnabled(false);
				reiniciar.setEnabled(true);
				reiniciar.requestFocusInWindow();

				juegoActivo();

			}

		});

		// Boton de continuar
		seguir.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				ganaste = true;
				cl.show(cardpanel, "Botones");
				ganar.setEnabled(false);
				reiniciar.requestFocusInWindow();

			}

		});

		// Boton de reinicio
		reiniciar.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				cl.show(cardpanel, "Botones");

				juegoActivo();
			}

		});

		// Cerrar con 'x'
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		// Hacer visible
		this.setTablero(tab.getTablero());
		this.imprimir();
		setSize(300, 300);
		setVisible(true);
	}

	// Pasos iniciales cada vez que se repite el juego.
	public void juegoActivo() {
		this.limpiarMatriz();
		tableroFinal = tab.generarNuevo2();
		tableroFinal = tab.generarNuevo2();
		this.imprimir();
	}

	public void setTablero(int[][] matriz) {
		tableroFinal = matriz;
	}

	// Confirma que cuando el tablero este lleno el usuario pueda seguir
	// realizando movimientos, si no, pierde. Tambien se encarga de confirmar si
	// el usuario gana el juego.
	public void confirmarEspacio() {

		int i;
		int j;

		int contador = 0;

		for (i = 0; i <= 3; i++) {
			for (j = 0; j <= 3; j++) {
				if (tableroFinal[i][j] != 0) {
					contador++;
				}

				if (tableroFinal[i][j] == 2048 && ganaste == false) {

					cl.show(cardpanel, "ganar");
					seguir.requestFocusInWindow();
				}

			}
		}

		this.imprimir();

		if (contador == 16) {
			if (tab.confirmarLlenoArriba() == true || tab.confirmarLlenoAbajo() == true
					|| tab.confirmarLlenoIzquierda() == true || tab.confirmarLlenoDerecha() == true) {
			}

			else {
				cl.show(cardpanel, "perder");
				inicio.requestFocusInWindow();

			}

		}

	}

	// Imprimir las posiciones del tablero modificado por la clase Tablero en
	// sus respectivos botones.
	public void imprimir() {

		if (tableroFinal[0][0] != 0) {
			a1.setLabel(Integer.toString(tableroFinal[0][0]));
		} else {
			a1.setLabel(" ");
		}

		if (tableroFinal[0][1] != 0) {
			a2.setLabel(Integer.toString(tableroFinal[0][1]));
		} else {
			a2.setLabel(" ");
		}

		if (tableroFinal[0][2] != 0) {
			a3.setLabel(Integer.toString(tableroFinal[0][2]));
		} else {
			a3.setLabel(" ");
		}

		if (tableroFinal[0][3] != 0) {
			a4.setLabel(Integer.toString(tableroFinal[0][3]));
		} else {
			a4.setLabel(" ");
		}

		if (tableroFinal[1][0] != 0) {
			b1.setLabel(Integer.toString(tableroFinal[1][0]));
		} else {
			b1.setLabel(" ");
		}

		if (tableroFinal[1][1] != 0) {
			b2.setLabel(Integer.toString(tableroFinal[1][1]));
		} else {
			b2.setLabel(" ");
		}

		if (tableroFinal[1][2] != 0) {
			b3.setLabel(Integer.toString(tableroFinal[1][2]));
		} else {
			b3.setLabel(" ");
		}

		if (tableroFinal[1][3] != 0) {
			b4.setLabel(Integer.toString(tableroFinal[1][3]));
		} else {
			b4.setLabel(" ");
		}

		if (tableroFinal[2][0] != 0) {
			c1.setLabel(Integer.toString(tableroFinal[2][0]));
		} else {
			c1.setLabel(" ");
		}

		if (tableroFinal[2][1] != 0) {
			c2.setLabel(Integer.toString(tableroFinal[2][1]));
		} else {
			c2.setLabel(" ");
		}

		if (tableroFinal[2][2] != 0) {
			c3.setLabel(Integer.toString(tableroFinal[2][2]));
		} else {
			c3.setLabel(" ");
		}

		if (tableroFinal[2][3] != 0) {
			c4.setLabel(Integer.toString(tableroFinal[2][3]));
		} else {
			c4.setLabel(" ");
		}

		if (tableroFinal[3][0] != 0) {
			d1.setLabel(Integer.toString(tableroFinal[3][0]));
		} else {
			d1.setLabel(" ");
		}

		if (tableroFinal[3][1] != 0) {
			d2.setLabel(Integer.toString(tableroFinal[3][1]));
		} else {
			d2.setLabel(" ");
		}

		if (tableroFinal[3][2] != 0) {
			d3.setLabel(Integer.toString(tableroFinal[3][2]));
		} else {
			d3.setLabel(" ");
		}

		if (tableroFinal[3][3] != 0) {
			d4.setLabel(Integer.toString(tableroFinal[3][3]));
		} else {
			d4.setLabel(" ");
		}

	}

	// Rellena la matriz con 0, para el momento de reiniciar
	public void limpiarMatriz() {
		for (int[] row : tableroFinal)
			Arrays.fill(row, 0);
	}

}
