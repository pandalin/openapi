package com.jvv.openapi.service.customer.sensms.request;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 聚合短信模板
 * Created by admin on 2016/11/16.
 */
public class SmsParam implements Serializable {


    private Map<String,Object>  tplValue;

    public Map<String, Object> getTplValue() {
        return tplValue;
    }

    public void setTplValue(Map<String, Object> tplValue) {
        this.tplValue = tplValue;
    }

    public SmsParam () {
    }

    public SmsParam (String title, Object value) {
        Map mc=new HashMap();
        mc.put(title,value);
        setTplValue(mc);
    }

    public void upTplValue(String title, Object value){
        this.tplValue.put(title,value);
    }

}
