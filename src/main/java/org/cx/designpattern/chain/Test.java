package org.cx.designpattern.chain;

/**
 * @author grass
 * @date 2019/7/9
 */
public class Test {
    public static void main(String[] args) {
        String input = "2";
        CaseChain caseChain = new CaseChain();
        caseChain.addBaseCase(new OneCase()).addBaseCase(new TwoCase());
        caseChain.doSomething(input, caseChain);
    }
}
