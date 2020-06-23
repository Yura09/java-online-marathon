class ArrayUtil {
    public static <T> T setAndReturn(T[] array, T value, int position) {
        return array[position] = value;
    }
}
