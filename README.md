# flexion
#I would improve the test to seperate more little parts of the method (buy, all, consume).
#I would create tests to inculde Exception cases.
#It would be nice use better naming(var8, p).
#Better use StringUtils.isEmpty -> 
		purchaseId == null || purchaseId.length() == 0
		alreadyConsumedPurchaseId != null && alreadyConsumedPurchaseId.length() != 0
#The last call useless -> integration.consume(p);
