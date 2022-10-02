import Foundation

@objc public class SamsungIAP: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
