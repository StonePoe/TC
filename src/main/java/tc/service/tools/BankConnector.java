package tc.service.tools;

import tc.model.Bankcard;

/**
 * Created by stonezhang on 2017/2/25.
 */
public class BankConnector {
    public static double getBalance (Bankcard bankCard) {
        // visit the bank to search for the remaining money
        // ...
        // here shall contain some bank-linking service
        // ...
        // we then assume that some sort of complex banking service give the feedback as 1000$
        return 1000;
    }
}
