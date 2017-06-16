package com.jvv.openapi.domain.encounter.decorator;

/**
 * Created by IntelliJ IDEA
 * <p>〈类详细描述〉 </p>
 * 〈功能详细描述〉
 *
 * @author linxm
 * @version 1.0
 * @date 2017/4/12
 * @time 18:14
 */
public class ConstelllationSuitability extends SuitabilityDecorator {

    private int suit = 5;

    public ConstelllationSuitability(Suitability suitability) {
        super(suitability);
    }

    @Override
    public int suit() {
        return super.suit() + suit;
    }
}
