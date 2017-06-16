package com.jvv.openapi.domain.encounter.decorator;

/**
 * Created by IntelliJ IDEA
 * <p>〈邂逅匹配度装饰器〉 </p>
 * 〈功能详细描述〉
 *
 * @author linxm
 * @version 1.0
 * @date 2017/4/12
 * @time 17:58
 */
public class SuitabilityDecorator implements Suitability {

    private Suitability suitability;

    public SuitabilityDecorator(Suitability suitability) {
        this.suitability = suitability;
    }

    @Override
    public int suit() {
        return suitability.suit();
    }
}
