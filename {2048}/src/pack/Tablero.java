package pack;

import java.util.Random;

public class Tablero {

	// Matriz que vamos a usar para identificar las posiciones de los numeros en
	// el juego.
	private int[][] tablero = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

	// Busca el espacio vacio y agrega el valor en dicho lugar.
	public int[][] generarNuevo2() {
		int i;
		int j;

		do {
			Random rand = new Random();
			i = rand.nextInt(4) + 0;
			j = rand.nextInt(4) + 0;

		} while (tablero[i][j] != 0);

		tablero[i][j] = 2;
		return tablero;
	}

	// Confirmar que el tablero, aun estando lleno, pueda generar mas
	// movimientos
	public boolean confirmarLlenoArriba() {

		boolean puedeSumar = true;

		for (int i = 1; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				switch (i) {
				case 3:
					if (tablero[i - 1][j] == tablero[i][j]) {
						puedeSumar = true;
					} else {
						puedeSumar = false;
					}
					break;
				case 2:
					if (tablero[i - 1][j] == tablero[i][j]) {
						puedeSumar = true;
					} else {
						puedeSumar = false;
					}
					break;
				case 1:
					if (tablero[i - 1][j] == tablero[i][j]) {
						puedeSumar = true;
					} else {
						puedeSumar = false;
					}
					break;
				}
			}
		}

		return puedeSumar;

	}

	public boolean confirmarLlenoAbajo() {
		boolean puedeSumar = true;

		for (int i = 2; i >= 0; i--) {
			for (int j = 0; j <= 3; j++) {
				switch (i) {
				default:
					if (tablero[i + 1][j] == tablero[i][j]) {
						puedeSumar = true;
					} else {
						puedeSumar = false;
					}
					break;
				case 1:
					if (tablero[i + 1][j] == tablero[i][j]) {
						puedeSumar = true;
					} else {
						puedeSumar = false;
					}
					break;
				case 2:
					if (tablero[i + 1][j] == tablero[i][j]) {
						puedeSumar = true;
					} else {
						puedeSumar = false;
					}
					break;
				}
			}
		}

		return puedeSumar;

	}

	public boolean confirmarLlenoDerecha() {
		boolean puedeSumar = true;

		for (int j = 2; j >= 0; j--) {
			for (int i = 0; i <= 3; i++) {
				switch (j) {
				default:
					if (tablero[i][j + 1] == tablero[i][j]) {
						puedeSumar = true;
					} else {
						puedeSumar = false;
					}
					break;
				case 1:
					if (tablero[i][j + 1] == tablero[i][j]) {
						puedeSumar = true;
					} else {
						puedeSumar = false;
					}
					break;
				case 2:
					if (tablero[i][j + 1] == tablero[i][j]) {
						puedeSumar = true;
					} else {
						puedeSumar = false;
					}
					break;
				}
			}
		}

		return puedeSumar;

	}

	public boolean confirmarLlenoIzquierda() {

		boolean puedeSumar = true;

		for (int j = 1; j <= 3; j++) {
			for (int i = 0; i <= 3; i++) {
				switch (j) {
				case 3:
					if (tablero[i][j - 1] == tablero[i][j]) {
						puedeSumar = true;
					} else {
						puedeSumar = false;
					}
					break;
				case 2:
					if (tablero[i][j - 1] == tablero[i][j]) {
						puedeSumar = true;
					} else {
						puedeSumar = false;
					}
					break;
				case 1:
					if (tablero[i][j - 1] == tablero[i][j]) {
						puedeSumar = true;
					} else {
						puedeSumar = false;
					}
					break;
				}
			}
		}

		return puedeSumar;

	}

	// Confirmar que el tablero sea capaz de realizar un movimiento, estando
	// posiciones del tablero libres
	public boolean confirmarMovArriba() {

		int contador = 0;

		for (int j = 0; j <= 3; j++) {
			if (tablero[0][j] != 0) {
				if (tablero[1][j] == 0 || tablero[1][j] != tablero[0][j]) {
					if (tablero[2][j] == 0 || (tablero[2][j] != tablero[1][j] && tablero[1][j] != 0)) {
						if (tablero[3][j] == 0 || (tablero[3][j] != tablero[2][j] && tablero[2][j] != 0)) {
							contador++;
						} else {
							contador = 0;
						}
					} else {
						contador = 0;
					}

				}
			} else {
				if (tablero[1][j] == 0) {
					if (tablero[2][j] == 0) {
						if (tablero[3][j] == 0) {
							contador++;
						}
					}
				}

			}
		}

		if (contador == 4) {
			contador = 0;
			return false;

		} else {
			contador = 0;
			return true;
		}

	}

	public boolean confirmarMovAbajo() {
		int contador = 0;

		for (int j = 3; j >= 0; j--) {
			if (tablero[3][j] != 0) {
				if (tablero[2][j] == 0 || tablero[2][j] != tablero[3][j]) {
					if (tablero[1][j] == 0 || (tablero[1][j] != tablero[2][j] && tablero[2][j] != 0)) {
						if (tablero[0][j] == 0 || (tablero[0][j] != tablero[1][j] && tablero[1][j] != 0)) {
							contador++;
						} else {
							contador = 0;
						}
					} else {
						contador = 0;
					}

				}
			} else {
				if (tablero[2][j] == 0) {
					if (tablero[1][j] == 0) {
						if (tablero[0][j] == 0) {
							contador++;
						}
					}
				}

			}
		}

		if (contador == 4) {
			contador = 0;
			return false;

		} else {
			contador = 0;
			return true;
		}

	}

	public boolean confirmarMovDerecha() {
		int contador = 0;

		for (int j = 3; j >= 0; j--) {
			if (tablero[j][3] != 0) {
				if (tablero[j][2] == 0 || tablero[j][2] != tablero[j][3]) {
					if (tablero[j][1] == 0 || (tablero[j][1] != tablero[j][2] && tablero[j][2] != 0)) {
						if (tablero[j][0] == 0 || (tablero[j][0] != tablero[j][1] && tablero[j][1] != 0)) {
							contador++;
						} else {
							contador = 0;
						}
					} else {
						contador = 0;
					}

				}
			} else {
				if (tablero[j][2] == 0) {
					if (tablero[j][1] == 0) {
						if (tablero[j][0] == 0) {
							contador++;
						}
					}
				}

			}
		}

		if (contador == 4) {
			contador = 0;
			return false;

		} else {
			contador = 0;
			return true;
		}

	}

	public boolean confirmarMovIzquierda() {

		int contador = 0;

		for (int j = 0; j <= 3; j++) {
			if (tablero[j][0] != 0) {
				if (tablero[j][1] == 0 || tablero[j][1] != tablero[j][0]) {
					if (tablero[j][2] == 0 || (tablero[j][2] != tablero[j][1] && tablero[j][1] != 0)) {
						if (tablero[j][3] == 0 || (tablero[j][3] != tablero[j][2] && tablero[j][2] != 0)) {
							contador++;
						} else {
							contador = 0;
						}
					} else {
						contador = 0;
					}

				}
			} else {
				if (tablero[j][1] == 0) {
					if (tablero[j][2] == 0) {
						if (tablero[j][3] == 0) {
							contador++;
						}
					}
				}

			}
		}

		if (contador == 4) {
			contador = 0;
			return false;

		} else {
			contador = 0;
			return true;
		}

	}

	// Mover**
	public void moverArriba() {
		if (this.confirmarMovArriba() == true) {
			for (int i = 1; i <= 3; i++) {
				for (int j = 0; j <= 3; j++) {
					switch (i) {
					case 3:
						for (int i_disponible = 0; i_disponible < 3; i_disponible++) {
							if (tablero[i_disponible][j] == 0) {
								tablero[i_disponible][j] = tablero[i][j];
								tablero[i][j] = 0;
							}
						}
						break;
					case 2:
						for (int i_disponible = 0; i_disponible < 2; i_disponible++) {
							if (tablero[i_disponible][j] == 0) {
								tablero[i_disponible][j] = tablero[i][j];
								tablero[i][j] = 0;

							}

						}
						break;
					case 1:
						if (tablero[0][j] == 0) {
							tablero[0][j] = tablero[i][j];
							tablero[i][j] = 0;

						}
						break;
					}
				}
			}
			this.sumarArriba();
			tablero = this.generarNuevo2();

		}

	}

	public void moverAbajo() {

		if (this.confirmarMovAbajo() == true) {
			for (int i = 2; i >= 0; i--) {
				for (int j = 0; j <= 3; j++) {
					switch (i) {
					default:
						for (int i_disponible = 3; i_disponible > 0; i_disponible--) {
							if (tablero[i_disponible][j] == 0) {
								tablero[i_disponible][j] = tablero[i][j];
								tablero[i][j] = 0;

							}
						}
						break;
					case 1:
						for (int i_disponible = 3; i_disponible > 1; i_disponible--) {
							if (tablero[i_disponible][j] == 0) {
								tablero[i_disponible][j] = tablero[i][j];
								tablero[i][j] = 0;

							}
						}
						break;
					case 2:
						if (tablero[3][j] == 0) {
							tablero[3][j] = tablero[i][j];
							tablero[i][j] = 0;

						}
						break;
					}
				}
			}
			this.sumarAbajo();
			tablero = this.generarNuevo2();

		}
	}

	public void moverIzquierda() {
		if (this.confirmarMovIzquierda() == true) {
			for (int j = 1; j <= 3; j++) {
				for (int i = 0; i <= 3; i++) {
					switch (j) {
					case 3:
						for (int j_disponible = 0; j_disponible < 3; j_disponible++) {
							if (tablero[i][j_disponible] == 0) {
								tablero[i][j_disponible] = tablero[i][j];
								tablero[i][j] = 0;

							}
						}
						break;
					case 2:
						for (int j_disponible = 0; j_disponible < 2; j_disponible++) {
							if (tablero[i][j_disponible] == 0) {
								tablero[i][j_disponible] = tablero[i][j];
								tablero[i][j] = 0;

							}
						}
						break;
					case 1:
						if (tablero[i][0] == 0) {
							tablero[i][0] = tablero[i][j];
							tablero[i][j] = 0;

						}
						break;
					}
				}
			}
			this.sumarIzquierda();
			tablero = this.generarNuevo2();

		}
	}

	public void moverDerecha() {

		if (this.confirmarMovDerecha() == true) {
			for (int j = 2; j >= 0; j--) {
				for (int i = 0; i <= 3; i++) {
					switch (j) {
					default:
						for (int j_disponible = 3; j_disponible > 0; j_disponible--) {
							if (tablero[i][j_disponible] == 0) {
								tablero[i][j_disponible] = tablero[i][j];
								tablero[i][j] = 0;
							}
						}
						break;
					case 1:
						for (int j_disponible = 3; j_disponible > 1; j_disponible--) {
							if (tablero[i][j_disponible] == 0) {
								tablero[i][j_disponible] = tablero[i][j];
								tablero[i][j] = 0;

							}
						}
						break;
					case 2:
						if (tablero[i][3] == 0) {
							tablero[i][3] = tablero[i][j];
							tablero[i][j] = 0;

						}
						break;
					}
				}
			}
			this.sumarDerecha();
			tablero = this.generarNuevo2();

		}
	}

	// Sumar (se llaman dentro de 'Mover**')
	public void sumarArriba() {
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 3; j++) {
				switch (i) {
				case 2:
					if (tablero[i + 1][j] == tablero[i][j]) {
						tablero[i][j] = tablero[i][j] * 2;
						tablero[i + 1][j] = 0;
						break;
					}

					break;
				case 1:
					if (tablero[i + 1][j] == tablero[i][j]) {
						tablero[i][j] = tablero[i][j] * 2;
						tablero[i + 1][j] = tablero[i + 2][j];
						tablero[i + 2][j] = 0;
						break;
					}

					break;
				default:
					if (tablero[i + 1][j] == tablero[i][j]) {
						tablero[i][j] = tablero[i][j] * 2;
						tablero[i + 1][j] = tablero[i + 2][j];
						tablero[i + 2][j] = tablero[i + 3][j];
						tablero[i + 3][j] = 0;
						break;
					}

					break;
				}
			}
		}
	}

	public void sumarAbajo() {

		for (int i = 3; i >= 1; i--) {
			for (int j = 0; j <= 3; j++) {
				switch (i) {
				case 1:
					if (tablero[i - 1][j] == tablero[i][j]) {
						tablero[i][j] = tablero[i][j] * 2;
						tablero[i - 1][j] = 0;
						break;
					}

					break;
				case 2:
					if (tablero[i - 1][j] == tablero[i][j]) {
						tablero[i][j] = tablero[i][j] * 2;
						tablero[i - 1][j] = tablero[i - 2][j];
						tablero[i - 2][j] = 0;
						break;
					}

					break;
				case 3:
					if (tablero[i - 1][j] == tablero[i][j]) {
						tablero[i][j] = tablero[i][j] * 2;
						tablero[i - 1][j] = tablero[i - 2][j];
						tablero[i - 2][j] = tablero[i - 3][j];
						tablero[i - 3][j] = 0;
						break;
					}

					break;
				}
			}
		}
	}

	public void sumarIzquierda() {

		for (int j = 0; j <= 2; j++) {
			for (int i = 0; i <= 3; i++) {
				switch (j) {
				case 2:
					if (tablero[i][j + 1] == tablero[i][j]) {
						tablero[i][j] = tablero[i][j] * 2;
						tablero[i][j + 1] = 0;
						break;
					}
					break;
				case 1:
					if (tablero[i][j + 1] == tablero[i][j]) {
						tablero[i][j] = tablero[i][j] * 2;
						tablero[i][j + 1] = tablero[i][j + 2];
						tablero[i][j + 2] = 0;
						break;
					}
					break;
				default:
					if (tablero[i][j + 1] == tablero[i][j]) {
						tablero[i][j] = tablero[i][j] * 2;
						tablero[i][j + 1] = tablero[i][j + 2];
						tablero[i][j + 2] = tablero[i][j + 3];
						tablero[i][j + 3] = 0;
						break;
					}
					break;
				}
			}
		}
	}

	public void sumarDerecha() {

		for (int j = 3; j >= 1; j--) {
			for (int i = 0; i <= 3; i++) {
				switch (j) {
				case 1:
					if (tablero[i][j - 1] == tablero[i][j]) {
						tablero[i][j] = tablero[i][j] * 2;
						tablero[i][j - 1] = 0;
						break;
					}

					break;
				case 2:
					if (tablero[i][j - 1] == tablero[i][j]) {
						tablero[i][j] = tablero[i][j] * 2;
						tablero[i][j - 1] = tablero[i][j - 2];
						tablero[i][j - 2] = 0;
						break;
					}

					break;
				case 3:
					if (tablero[i][j - 1] == tablero[i][j]) {
						tablero[i][j] = tablero[i][j] * 2;
						tablero[i][j - 1] = tablero[i][j - 2];
						tablero[i][j - 2] = tablero[i][j - 3];
						tablero[i][j - 3] = 0;
						break;
					}

					break;
				}
			}
		}
	}

	// Una vez modificado, entrega el tablero a la clase Juego.
	public int[][] getTablero() {
		return tablero;
	}

}
