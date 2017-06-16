package com.jvv.openapi.domain.encounter.decorator;

/**
 * Created by IntelliJ IDEA
 * <p>〈用户类型匹配度+10〉 </p>
 * 〈用户类型匹配度+10〉
 *
 * @author linxm
 * @version 1.0
 * @date 2017/4/12
 * @time 18:00
 */
public class UserTypeSuitability extends SuitabilityDecorator {

    private int suit = 10;

    public UserTypeSuitability(Suitability suitability) {
        super(suitability);
    }

    @Override
    public int suit() {
        return super.suit() + suit;
    }
}
