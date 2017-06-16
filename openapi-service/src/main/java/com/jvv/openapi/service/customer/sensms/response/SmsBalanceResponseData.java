package com.jvv.openapi.service.customer.sensms.response;

import com.jvv.openapi.core.service.entity.AbstractResponseData;

/**
 * Created by IntelliJ IDEA
 * <p>〈类详细描述〉 </p>
 * 〈功能详细描述〉
 *
 * @author linxm
 * @version 1.0
 * @date 2017/4/5
 * @time 15:48
 */
public class SmsBalanceResponseData extends AbstractResponseData {

    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
