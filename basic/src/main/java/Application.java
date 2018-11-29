import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        int[] ab = getAccounts();
        long startTime = System.currentTimeMillis();

        System.out.println("可用内存:" + Runtime.getRuntime().freeMemory() / (1024 * 1024) + "M");

        StringBuilder result = new StringBuilder();
        List<Integer> list = new Application().nearNum(ab, 50000, 10, 0, ab.length - 1);

        long endTime = System.currentTimeMillis();
        System.out.println(result.substring(0, result.length() - 2) + " = " + list.stream().reduce((x, y) -> x + y).get());
        System.out.println("耗时:" + (endTime - startTime));
    }

    public static int[] getAccounts() {
        FileInputStream fileInputStream = null;
        try {
            File file = new File("C:\\Users\\29410\\Desktop\\amount.txt");
            byte[] inputs = new byte[Long.valueOf(file.length()).intValue()];
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(inputs);
            String[] accounts = new String(inputs, "UTF-8").split("\r\n");
            int[] ab = new int[accounts.length + 1];
            int i = 1;
            for (String account : accounts) {
                ab[i++] = new BigDecimal(account).intValue();
            }
            return ab;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileInputStream != null;
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new int[0];
    }

    //num 复投数组  target数组  y差值  start、end起始下标
    public List<Integer> nearNum(int[] num, int target, int y, int start, int end, int unit) {
        int length = end - start + 1;
        int allowValue = target + y;
        List<Integer> result = new LinkedList<>();

        int[][] dp = new int[length + 1][allowValue + 1];
        int i, j;
        for (i = 1; i < length; i++) {
            for (j = 1; j <= allowValue; j++) {
                int value = num[i] / unit;
                if (j < value) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - value] + value);
                }
            }
        }

        int abs = Math.abs(dp[length - 1][target] - target);
        j = target;
        for (i = allowValue; i >= target && abs != 0; i--) {
            if (Math.abs(dp[length - 1][i] - target) < abs) {
                j = i;//获得最接近目标数的值
                abs = Math.abs(dp[length - 1][i] - target);
            }
        }

        int k = dp[length - 1][j];

        for (i = length - 1; i > 0; --i) {
            int value = num[i] / unit;
            if (dp[i][k] != dp[i - 1][k]
                    && k - value >= 0 && dp[i][k] == dp[i - 1][k - value] + value) {
                result.add(value);
                k -= value;
            }
        }
        return result;
    }

    //num 复投数组  target数组  y差值  start、end起始下标
    public List<Integer> nearNum(int[] num, int target, int y, int start, int end) {
        int length = end - start + 1;
        int allowValue = target + y;
        List<Integer> result = new LinkedList<>();

        int[] dp = new int[allowValue + 1];
        int i, j;
        for (i = 1; i < length; i++) {
            for (j = allowValue; j >= num[i]; --j) {
                dp[j] = Math.max(dp[j], dp[j - num[i]] + num[i]);
            }
        }

        int abs = Math.abs(dp[target] - target);
        j = target;
        for (i = allowValue; i >= target && abs != 0; i--) {
            if (Math.abs(dp[i] - target) < abs) {
                j = i;//获得最接近目标数的值
                abs = Math.abs(dp[i] - target);
            }
        }

        int k = dp[j];

        System.out.println("最接近的值为: "  + k);
        return result;
    }
}







