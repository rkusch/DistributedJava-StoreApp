/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week3.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ryan
 */
public class StaticPageService {


    private List<StaticPage> staticPages = new ArrayList<StaticPage>();
  

    private String fileAsString(String filename) throws FileNotFoundException, IOException {
        InputStream is = new FileInputStream(filename);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();

        while (line != null) {
            sb.append(line).append("\n");
            line = buf.readLine();
        }
        return sb.toString();

    }

    public StaticPage getID(String id) {
        StaticPage thePage = null;
        for (StaticPage page : staticPages) {
            if (page.getId().equals(id)) {
                thePage = page;
            }
        }
        return thePage;
    }

    public List<StaticPage> getAllStaticPages() {
        return staticPages;
    }

    public List<StaticPage> findPages(String search) {
        search = search.toLowerCase();
        List<StaticPage> theList = new ArrayList<StaticPage>();
        for (StaticPage page : staticPages) {
            if (page.getId().startsWith(search)) {
                theList.add(page);
            }
        }
        return theList;
    }

    public StaticPageService(String headerFileName, String footerFileName) throws IOException {
        String header = fileAsString(headerFileName);
        String footer = fileAsString(footerFileName);
        StaticPage headerContent = new StaticPage("1", header);
        StaticPage footerContent = new StaticPage("3", footer);
        staticPages.add(headerContent);
        staticPages.add(footerContent);

    }

}
