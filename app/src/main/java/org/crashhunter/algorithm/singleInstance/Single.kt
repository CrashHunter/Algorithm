package org.crashhunter.algorithm.singleInstance

class Single {
    companion object {
        val single: Single by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            Single()
        }
    }


}