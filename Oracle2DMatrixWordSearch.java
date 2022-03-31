public class Oracle2DMatrixWordSearch {

    public boolean findMatch(char[][] data, String word) {

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (hasMatch(data, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasMatch(char[][] data, int i, int j, String key, int level) {
        if (level == key.length()) {
            return true;
        }
        if (i < 0 || i >= data.length || j < 0 || j >= data[i].length) {
            return false;
        }
        if ((data[i][j] - key.charAt(level)) != 0) {
            return false;
        }
        char record = data[i][j];
        data[i][j] = '0';

        boolean res = hasMatch(data, i - 1, j, key, level + 1)
                || hasMatch(data, i, j - 1, key, level + 1)
                || hasMatch(data, i, j + 1, key, level + 1)
                || hasMatch(data, i + 1, j, key, level + 1)
                || hasMatch(data, i + 1, j + 1, key, level + 1)
                || hasMatch(data, i - 1, j - 1, key, level + 1)
                || hasMatch(data, i + 1, j - 1, key, level + 1)
                || hasMatch(data, i - 1, j + 1, key, level + 1);

        data[i][j] = record;
        return res;

    }

    public static void main(String args[]) {
        Oracle2DMatrixWordSearch driver = new Oracle2DMatrixWordSearch();
        char[][] data = {
                "software".toCharArray(),
                "hardware".toCharArray(),
                "hexaware".toCharArray(),
                "scandisk".toCharArray(),
                "keyboard".toCharArray(),
                "cupboard".toCharArray(),
                "demoabcd".toCharArray(),
                "stuvwxyz".toCharArray()
        };

        System.out.println(driver.findMatch(data, "oracle")); // false

        System.out.println(driver.findMatch(data, "hexa")); // true
    }
}