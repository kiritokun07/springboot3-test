package groovy

def HelloWorld() {
    println("hello world")
}

/**
 * 简易加法
 * @param a
 * @param b
 * @return 和
 */
static def add(int a, int b) {
    return a + b;
}

/**
 * map转化为String
 * @param paramMap
 * @return 字符串
 */
static def mapToString(Map<String, String> paramMap) {
    StringBuilder sb = new StringBuilder();
    for (final def entry in paramMap.entrySet()) {
        sb.append("key:" + entry.getKey() + ";value:" + entry.getValue())
    }
    return sb.toString()
}

