package com.jvv.openapi.domain.encounter.decorator;

/**
 * Created by IntelliJ IDEA
 * <p>〈默认匹配度〉 </p>
 * 〈默认匹配度〉
 *
 * @author linxm
 * @version 1.0
 * @date 2017/4/12
 * @time 17:56
 */
public class BaseSuitability implements Suitability {

    private int suitability = 60;

    @Override
    public int suit() {
        return suitability;
    }
}
