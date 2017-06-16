package com.jvv.openapi.domain.encounter.decorator;

/**
 * Created by IntelliJ IDEA
 * <p>〈年龄、行业、身份+8〉 </p>
 * 〈功能详细描述〉
 *
 * @author linxm
 * @version 1.0
 * @date 2017/4/12
 * @time 18:08
 */
public class UserSuitability extends SuitabilityDecorator {

    private int suit = 8;

    public UserSuitability(Suitability suitability) {
        super(suitability);
    }

    @Override
    public int suit() {
        return super.suit() + suit;
    }
}
