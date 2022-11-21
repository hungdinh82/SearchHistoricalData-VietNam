package org.example;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<Lehoi> listLehoi = new ArrayList<>();

        Document doc = Jsoup.connect("https://wolverineair.com/cac-le-hoi-o-viet-nam/").get();

//        Elements elements = doc.getElementsByClass("toc_number toc_depth_3");

        Elements elements = doc.select("li > ul > li > ul > li > a");
//        System.out.println(elements.text());

        for (Element e : elements) {
            Lehoi item = new Lehoi();
//            item.setTitle(e.text());
//            item.setTitle(e.child(0).child(1).child(2).text());
//            item.setTitle(e.child(1).child(1).child(0).child(1).child(0).child(0).text());
//            item.setDetailUrl(e.child(0).child(1).child(2).child(0).attr("href"));
//

            // Xử lý phần số bị thừa ở trước mỗi tên lễ hội
            char [] ch = new char[e.text().length() - 8];
            e.text().getChars(8, e.text().length(), ch, 0);
            System.out.println(ch);
            String str = String.valueOf(ch);
            item.setTitle(str);

            listLehoi.add(item);

        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(listLehoi);
        //        System.out.println(jsonData);

        for (int i = 0; i < listLehoi.size(); i++){
            // Xử lý phần số bị thừa ở trước mỗi tên lễ hội
//            char [] ch = new char[listLehoi.get(i).getTitle().length() - 8];
//            listLehoi.get(i).getTitle().getChars(8, listLehoi.get(i).getTitle().length(), ch, 0);
//            System.out.println(ch);
            System.out.println(listLehoi.get(i).getTitle());
        }
    }



}
