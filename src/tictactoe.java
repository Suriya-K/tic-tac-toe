import java.util.*;

public class tictactoe {
	static String[] table = new String[9];
	static String turn;

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		String cmd;
		String winner = null;
		System.out.println("=+++++++++++++++++++++++++++++++++++++++++++=");
		System.out.println("=                XO GAMES                   =");
		System.out.println("=+++++++++++++++++++++++++++++++++++++++++++=");
		System.out.println("=                                           =");
		System.out.println("=      Enter \"start\" to start game          =");
		System.out.println("=                                           =");
		System.out.println("=+++++++++++++++++++++++++++++++++++++++++++=");
		// command menu
		while (true) {
			System.out.print("commands : ");
			cmd = inp.next();
			if (cmd.equals("start")) {
				System.out.print("who will first turn ( X / O ) : ");
				cmd = inp.next();
				if (cmd.equals("X") || cmd.equals("x")) {
					turn = "x";
					emptyTable();
					drawTable();
					break;
				} else if (cmd.equals("O") || cmd.equals("o")) {
					turn = "o";
					emptyTable();
					drawTable();
					break;
				} else {
					System.out.println("incorect commands");
				}
			} else {
				System.out.println("incorect commands");
			}
		}

		// message first turn
		System.out.print("This is " + turn + " turn place enter row and column number : ");
		// this is main loop
		while (winner == null) {
			int place, inR, inC;
			try {
				// cast row and column from string to integer
				inR = inp.nextInt();
				inC = inp.nextInt();
				place = (((inR - 1) * 3) + inC - 1) + 1;
				if (!(place > 0 && place <= 9)) {
					System.out.println("incorect number");
					System.out.print("This is " + turn + " turn place enter row and column number : ");
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println();
				System.out.println("incorect number");
				System.out.print("This is " + turn + " turn place enter row and column number : ");
				continue;
			}
			if (table[place - 1].equals(String.valueOf(place))) {
				table[place - 1] = turn;
				if (turn.equals("x")) {
					turn = "o";
				} else {
					turn = "x";
				}
				drawTable();
				winner = checkWin();
			} else {
				System.out.print("This number already taken enter new row and column number : ");
				continue;
			}
		}
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println("draw!!");
		} else {
			System.out.println(winner + " won !!");
		}
	}

	static String checkWin() {
		for (int i = 0; i < 8; i++) {
			String line = null;
			switch (i) {
			case 0:
				line = table[0] + table[1] + table[2];
				break;
			case 1:
				line = table[3] + table[4] + table[5];
				break;
			case 2:
				line = table[6] + table[7] + table[8];
				break;
			case 3:
				line = table[0] + table[3] + table[6];
				break;
			case 4:
				line = table[1] + table[4] + table[7];
				break;
			case 5:
				line = table[2] + table[5] + table[8];
				break;
			case 6:
				line = table[0] + table[4] + table[8];
				break;
			case 7:
				line = table[2] + table[4] + table[6];
				break;
			}
			if (line.equals("xxx")) {
				return "x";
			} else if (line.equals("ooo")) {
				return "o";
			}
		}
		for (int y = 0; y < 9; y++) {
			if (Arrays.asList(table).contains(String.valueOf(y + 1))) {
				break;
			} else if (y == 8) {
				return "draw";
			}
		}
		System.out.print("This is " + turn + " turn place enter row and column number : ");
		return null;
	}

	static void drawTable() {
		System.out.println("  ++++ 1 +++++++ 2 +++++++ 3 ++++");
		System.out.println("1 +|   " + table[0] + "    |    " + table[1] + "    |    " + table[2] + "   |+");
		System.out.println("  ++++++++++++++++++++++++++++++");
		System.out.println("2 +|   " + table[3] + "    |    " + table[4] + "    |    " + table[5] + "   |+");
		System.out.println("  ++++++++++++++++++++++++++++++");
		System.out.println("3 +|   " + table[6] + "    |    " + table[7] + "    |    " + table[8] + "   |+");
		System.out.println("  +++++++++++++++++++++++++++++++");
	}

	static void emptyTable() {
		for (int i = 0; i < 9; i++) {
			table[i] = "-";
		}
	}
}
