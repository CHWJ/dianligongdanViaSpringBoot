package com.hdtech.dianligongdan.controller;

import com.hdtech.dianligongdan.domain.entity.Organization;
import com.hdtech.dianligongdan.domain.result.TreeNodeEntity;
import com.hdtech.dianligongdan.service.OrganService;
import com.hdtech.dianligongdan.utils.TreeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/organ")
public class OrganController extends BaseController<Organization> {
    @Autowired
    private OrganService organService;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("organ/index");
        return view;
    }

    @PostMapping("/findAll")
    public List<Organization> findAll() {
        List<Organization> list = organService.findAll();
        return list;
    }

    @PostMapping("/findTree")
    public List<TreeNodeEntity> findTree() {
        List<Organization> list = organService.findAll();
        if (list == null || list.size() == 0) {
            return null;
        }

        List<TreeNodeEntity> tree = new ArrayList<>();
        for (Organization organ : list) {
            TreeNodeEntity node = new TreeNodeEntity();
            node.setId(String.valueOf(organ.id));
            node.setText(organ.name);
            node.setParentId(String.valueOf(organ.parentId));
            tree.add(node);
        }

        List<TreeNodeEntity> result = TreeHelper.toTreeList(tree);
        return result;
    }
}
