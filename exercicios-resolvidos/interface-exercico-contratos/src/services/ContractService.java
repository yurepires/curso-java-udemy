package services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months){
        double basicQuota = contract.getTotalValue() / months;

        for (int i=0; i < months; i++){
            LocalDate dueDate = contract.getDate().plusMonths(i + 1);

            double interest = onlinePaymentService.interest(basicQuota, i + 1);
            double fee = onlinePaymentService.paymentFee(basicQuota + interest);
            double quota = basicQuota + interest + fee;

            contract.getInstallments().add(new Installment(dueDate, quota));
        }
    }

    //    public void processContract(Contract contract, int months){
//        Double installmentValue = contract.getTotalValue() / months;
//        OnlinePaymentService paymentService = new PaypalService();
//        for (int i=0; i < months; i++){
//            double amount = installmentValue + paymentService.interest(installmentValue, i + 1);
//            amount += paymentService.paymentFee(amount);
//            contract.addInstallment(new Installment(contract.getDate().plusMonths(i + 1), amount));
//        }
//    }
}
