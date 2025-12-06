class SqueakyClean {
    private static char unleet(char c) {
        return switch(c) {
            case '4' -> 'a';
            case '3' -> 'e';
            case '0' -> 'o';
            case '1' -> 'l';
            case '7' -> 't';
            default -> c;
        };
    }
    static String clean(String identifier) {
        char[] chars = identifier.toCharArray();
        StringBuilder builder = new StringBuilder();
        boolean convertToCapital = false;
        for (char c: chars) {
            if (Character.isWhitespace(c)) {
                builder.append('_');
            } else if (c == '-') {
                convertToCapital = true;
            } else if (Character.isDigit(c)) {
                char unleeted = unleet(c);
                if (Character.isLetter(unleeted)) {
                    builder.append(unleeted);
                }
            } else if (Character.isLetter(c)) {
                builder.append(convertToCapital ? Character.toUpperCase(c) : c);
                convertToCapital = false;
            }
        }
        return builder.toString();
    }
}
