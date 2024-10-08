package bank.command.impl;

import bank.command.Command;
import bank.service.IAccountService;

public class WithdrawCommand implements Command {
    private IAccountService accountService;
    private long accountnumber;
    private double amount;

    public WithdrawCommand(IAccountService accountService,long accountnumber, double amount) {
        this.accountService=accountService;
        this.accountnumber=accountnumber;
        this.amount=amount;
    }

    public void execute() {
       accountService.withdraw(accountnumber, amount);
    }

    public void unExecute() {
        accountService.deposit(accountnumber, amount);

    }


}
