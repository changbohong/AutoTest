package edu.bupt.cbh.ceshi;

import com.alibaba.fastjson.JSONArray;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by scarlett on 2017/7/30.
 */
@Controller
@RequestMapping("/ceshi")
public class CeshiController {

    @RequestMapping(value = "/preTree", method = RequestMethod.GET)
    public String preTree() {
        return "ceshi/preTree";
    }

    @RequestMapping(value = "/tree", method = RequestMethod.POST)
    public String tree(String url, Model model) throws IOException {
        if (!url.startsWith("http")) {
            url = "http://" + url;
        }
        Connection conn = Jsoup.connect(url);
        Document doc = conn.get();
        if (doc == null) {
            doc = conn.post();
        }
        List<ZTreeNode> tree = createZTree(doc.child(0));

        model.addAttribute("zNodes", JSONArray.toJSONString(tree));
        return "ceshi/tree";
    }

    public static void main(String[] args) {
        CeshiController ceshi = new CeshiController();
        Document doc = Jsoup.parse("<html><head><title></title></head><body><div></div></body></html>");
        List<ZTreeNode> tree = ceshi.createZTree(doc.child(0));
        System.out.print(tree);
    }

    class ZTreeNode {
        private String id;
        private String pId;
        private String name;
        private Boolean open;

        public ZTreeNode(String id, String pId, String name, Boolean open) {
            this.id = id;
            this.pId = pId;
            this.name = name;
            this.open = open;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getpId() {
            return pId;
        }

        public void setpId(String pId) {
            this.pId = pId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getOpen() {
            return open;
        }

        public void setOpen(Boolean open) {
            this.open = open;
        }

        @Override
        public String toString() {
            return "ZTreeNode{" +
                    "id='" + id + '\'' +
                    ", pId='" + pId + '\'' +
                    ", name='" + name + '\'' +
                    ", open=" + open +
                    '}';
        }
    }

    private List<ZTreeNode> createZTree(Element html) {
        List<ZTreeNode> tree = new ArrayList<>();
        Queue<Element> queue = new LinkedList<>();
        queue.offer(html);
        tree.add(new ZTreeNode("0", "0", "html", false));
        int index = -1;
        while (!queue.isEmpty()) {
            Element node = queue.poll();
            index++;
            Elements children = node.children();
            for (int i = 0, len = children.size(); i < len; i++) {
                Element child = children.get(i);
                ZTreeNode parent = tree.get(index);
                String pId = parent.getId();
                tree.add(new ZTreeNode(pId + i, pId, child.tagName(), false));
                queue.offer(child);
            }
        }
        return tree;
    }
}
