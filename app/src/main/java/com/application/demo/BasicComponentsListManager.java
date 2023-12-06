package com.application.demo;

import com.application.demo.textview.TextViewActivity;

import java.util.ArrayList;

public class BasicComponentsListManager {

    public static ArrayList<BasicComponentsInfo> getComponentList() {
        ArrayList<BasicComponentsInfo> componentsInfos = new ArrayList<>();
        componentsInfos.add(buildComponentsInfo("TextView","文本组件", TextViewActivity.class));
        return componentsInfos;
    }

    private static BasicComponentsInfo buildComponentsInfo(String title,String desc,Class targetCls) {
        BasicComponentsInfo info = new BasicComponentsInfo();
        info.title = title;
        info.desc = desc;
        info.targetCls = targetCls;
        return info;
    }

}
