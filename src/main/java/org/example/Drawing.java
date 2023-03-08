package org.example;

public class Drawing {
    private static final int MAX_BODY_PARTS = 7;

    public static String draw(int remainingTries) {
        StringBuilder sb = new StringBuilder();

        sb.append("  _______\n");
        sb.append(" |       |\n");

        switch (MAX_BODY_PARTS - remainingTries) {
            case 0:
                sb.append(" |\n");
                sb.append(" |\n");
                sb.append(" |\n");
                sb.append(" |\n");
                break;
            case 1:
                sb.append(" |       O\n");
                sb.append(" |\n");
                sb.append(" |\n");
                sb.append(" |\n");
                break;
            case 2:
                sb.append(" |       O\n");
                sb.append(" |       |\n");
                sb.append(" |\n");
                sb.append(" |\n");
                break;
            case 3:
                sb.append(" |       O\n");
                sb.append(" |      /|\n");
                sb.append(" |\n");
                sb.append(" |\n");
                break;
            case 4:
                sb.append(" |       O\n");
                sb.append(" |      /|\\\n");
                sb.append(" |\n");
                sb.append(" |\n");
                break;
            case 5:
                sb.append(" |       O\n");
                sb.append(" |      /|\\\n");
                sb.append(" |      /\n");
                sb.append(" |\n");
                break;
            case 6:
                sb.append(" |       O\n");
                sb.append(" |      /|\\\n");
                sb.append(" |      / \\\n");
                sb.append(" |\n");
                break;
        }

        sb.append(" |\n");
        sb.append("_|_\n");

        return sb.toString();
    }
}