package practice;

/*
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stakes {

    public static void decodeSecretMessage(String urlString) {
        try {
            Scanner scanner = new Scanner(
                URI.create(urlString).toURL().openStream()
            );
            scanner.useDelimiter("\\Z");
            String html = scanner.hasNext() ? scanner.next() : "";
            scanner.close();

            Pattern cellPattern = Pattern.compile(
                "<td[^>]*>(.*?)</td>",
                Pattern.DOTALL
            );
            Matcher matcher = cellPattern.matcher(html);

            List<String> cells = new ArrayList<>();
            while (matcher.find()) {
                String text = matcher.group(1).replaceAll("<[^>]*>", "").trim();
                cells.add(text);
            }

            Map<String, Character> grid = new HashMap<>();
            int maxX = 0;
            int maxY = 0;

            for (int i = 0; i + 2 < cells.size(); i += 3) {
                try {
                    int x = Integer.parseInt(cells.get(i));
                    String charStr = cells.get(i + 1);
                    char ch = charStr.isEmpty() ? ' ' : charStr.charAt(0);
                    int y = Integer.parseInt(cells.get(i + 2));

                    grid.put(x + "," + y, ch);
                    if (x > maxX) maxX = x;
                    if (y > maxY) maxY = y;
                } catch (NumberFormatException ignored) {}
            }

            for (int y = maxY; y >= 0; y--) {
                StringBuilder row = new StringBuilder();
                for (int x = 0; x <= maxX; x++) {
                    row.append(grid.getOrDefault(x + "," + y, ' '));
                }
                System.out.println(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        decodeSecretMessage(
            "https://docs.google.com/document/d/e/2PACX-1vTMOmshQe8YvaRXi6gEPKKlsC6UpFJSMAk4mQjLm_u1gmHdVVTaeh7nBNFBRlui0sTZ-snGwZM4DBCT/pub"
        );
    }
}
*/


/*
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stakes {

    public static void decodeSecretMessage(String url) throws Exception {
        String html;
        try (Scanner sc = new Scanner(URI.create(url).toURL().openStream())) {
            html = sc.useDelimiter("\\A").next();
        }

        Matcher m = Pattern.compile("(?s)<tr[^>]*>.*?<td[^>]*>(.*?)</td>.*?<td[^>]*>(.*?)</td>.*?<td[^>]*>(.*?)</td>.*?</tr>").matcher(html);

        Map<String, Character> grid = new HashMap<>();
        int maxX = 0;
        int maxY = 0;

        while (m.find()) {
            String col1 = m.group(1).replaceAll("<[^>]*>", "").trim();
            String col2 = m.group(2).replaceAll("<[^>]*>", "").trim();
            String col3 = m.group(3).replaceAll("<[^>]*>", "").trim();

            try {
                int x = Integer.parseInt(col1);
                int y = Integer.parseInt(col3);
                char ch = col2.isEmpty() ? ' ' : col2.charAt(0);

                grid.put(x + "," + y, ch);
                if (x > maxX) maxX = x;
                if (y > maxY) maxY = y;
            } catch (NumberFormatException ignored) {
            }
        }

        for (int y = maxY; y >= 0; y--) {
            for (int x = 0; x <= maxX; x++) {
                System.out.print(grid.getOrDefault(x + "," + y, ' '));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        decodeSecretMessage("https://docs.google.com/document/d/e/2PACX-1vSvM5gDlNvt7npYHhp_XfsJvuntUhq184By5xO_pA4b_gCWeXb6dM6ZxwN8rE6S4ghUsCj2VKR21oEP/pub");
    }
}
*/

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void decodeSecretMessage(String url) throws Exception {
        String html;
        try (Scanner sc = new Scanner(URI.create(url).toURL().openStream())) {
            html = sc.useDelimiter("\\A").next();
        }

        Matcher m = Pattern.compile("<td[^>]*>(.*?)</td>", Pattern.DOTALL).matcher(html);
        List<String> cells = new ArrayList<>();
        while (m.find()) {
            cells.add(m.group(1).replaceAll("<[^>]*>", "").trim());
        }

        Map<String, Character> grid = new HashMap<>();
        int maxX = 0;
        int maxY = 0;

        for (int i = 0; i + 2 < cells.size(); i += 3) {
            try {
                int x = Integer.parseInt(cells.get(i));
                String text = cells.get(i + 1);
                char ch = text.isEmpty() ? ' ' : text.charAt(0);
                int y = Integer.parseInt(cells.get(i + 2));

                grid.put(x + "," + y, ch);
                if (x > maxX) maxX = x;
                if (y > maxY) maxY = y;
            } catch (NumberFormatException ignored) {
            }
        }

        for (int y = maxY; y >= 0; y--) {
            for (int x = 0; x <= maxX; x++) {
                System.out.print(grid.getOrDefault(x + "," + y, ' '));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        decodeSecretMessage("https://docs.google.com/document/d/e/2PACX-1vSvM5gDlNvt7npYHhp_XfsJvuntUhq184By5xO_pA4b_gCWeXb6dM6ZxwN8rE6S4ghUsCj2VKR21oEP/pub");
    }
}