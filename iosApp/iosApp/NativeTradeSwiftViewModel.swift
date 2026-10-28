import SwiftUI
import domain

class NativeTradeSwiftViewModel: ObservableObject {

    private let tradeValidatorEngine = TradeValidator()

    @Published var tradeValidationResultText: String = ""

    func dispatchOrderValidation(symbol: String, sharesCount: Int, targetPriceOnOrder: Double) {

        let validationStatus = tradeValidatorEngine.validateTrade(
            ticker: symbol,
            quantity: Int32(sharesCount),
            price: targetPriceOnOrder
        )

        if validationStatus {
            self.tradeValidationResultText = "Execution Validation Succeeded. Proceeding."
        } else {
            self.tradeValidationResultText = "Transaction Suspended: Boundary Constraint Overflow"
        }
    }
}
