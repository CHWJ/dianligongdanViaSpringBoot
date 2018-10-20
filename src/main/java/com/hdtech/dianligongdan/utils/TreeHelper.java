package com.hdtech.dianligongdan.utils;

import com.hdtech.dianligongdan.domain.result.TreeNodeEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeHelper {
    public static String toTreeJson(List<TreeNodeEntity> list) {
        return toTreeJson(list, String.valueOf(0));
    }

    private static String toTreeJson(List<TreeNodeEntity> list, String parentId) {
        StringBuilder sb = new StringBuilder();
        List<TreeNodeEntity> roots = list.stream().filter(x -> parentId.equals(x.getParentId())).collect(Collectors.toList());
        sb.append("[");
        if (roots.size() > 0) {
            List<String> nodeJson = new ArrayList<>();
            for (TreeNodeEntity root : roots) {
                String temp = String.format("{id:'%s',text:'%s',parentId:'%s',",
                        root.getId(),
                        root.getText(),
                        root.getParentId());
                temp += String.format("children:%s", toTreeJson(list, root.getId()));
                temp += "}";
                nodeJson.add(temp);
            }
            sb.append(String.join(",", nodeJson));
        }
        sb.append("]");
        return sb.toString();
    }

    public static List<TreeNodeEntity> toTreeList(List<TreeNodeEntity> list) {
        return toTreeList(list, String.valueOf(0));
    }

    private static List<TreeNodeEntity> toTreeList(List<TreeNodeEntity> list, String parentId) {
        List<TreeNodeEntity> result = new ArrayList<>();
        List<TreeNodeEntity> roots = list.stream().filter(x -> parentId.equals(x.getParentId())).collect(Collectors.toList());
        if (roots.size() > 0) {
            for (TreeNodeEntity root : roots) {
                root.setChildren(toTreeList(list, root.getId()));
                result.add(root);
            }
        }
        return result;
    }
}
